package com.tencent.ttpic.openapi.filter;

import android.hardware.SensorEvent;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.TransformUtils;
import com.tencent.ttpic.openapi.listener.LightNodeAppliedListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.light.AudioFrame;
import org.light.AudioOutput;
import org.light.CameraConfig;
import org.light.CameraConfig.DeviceCameraOrientation;
import org.light.CameraConfig.ImageOrigin;
import org.light.CameraController;
import org.light.CameraController.CameraViewType;
import org.light.CameraController.CmShowCallback;
import org.light.CameraController.DisplayType;
import org.light.CameraController.MorphType;
import org.light.Config.ConfigKeys;
import org.light.LightAsset;
import org.light.LightEngine;
import org.light.LightSurface;
import org.light.RendererConfig;
import org.light.VideoOutput;
import org.light.bean.WMElement;
import org.light.callback.ExternalRenderCallback;
import org.light.listener.IOnClickWatermarkListener;
import org.light.listener.LightAssetListener;
import org.light.listener.WatermarkDelegate;

public class LightNode
  extends AEChainI
  implements ICMShowHandle
{
  private static final int FRAME_INTERN_TIME = 80000;
  public static final int LIGHT_TIP_TYPE_NORMAL = 0;
  public static final int LIGHT_TIP_TYPE_PAG = 1;
  public static final String TAG = "LightNode";
  private static String assetsDir;
  private static String emptyMaterialPath;
  LightNodeAppliedListener appliedListener;
  private LightAsset asset;
  private String assetPath = "";
  private AudioFrame audioFrame;
  private AudioOutput audioReader;
  private HashMap<String, String> bundlePathMap = new HashMap();
  private CameraConfig cameraConfig;
  private CameraController cameraController;
  final String defaultSmoothVersion;
  private CameraConfig.ImageOrigin inputOrigin = CameraConfig.ImageOrigin.BottomLeft;
  private LightEngine lightEngine;
  private LightSurface lightSurface;
  private boolean mAutoTest = false;
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private int mFrameIndex = 0;
  private LightAssetListener mLightAssetListener;
  private boolean mNeedSetBundle = false;
  private LightNode.ILightNodeTipsListener mTipsListener;
  private IOnClickWatermarkListener mWatermarkClickListener;
  private boolean orientationChanged = false;
  int[] outTexs = new int[2];
  private int previewHeight = 1;
  private int previewWidth = 1;
  private SensorEvent sensorEvent;
  private long startTime = 0L;
  private VideoOutput videoOutput;
  HashMap<String, WatermarkDelegate> wmDelegateMap = new HashMap();
  
  public LightNode()
  {
    this("defaultBeautyV6.json");
  }
  
  public LightNode(String paramString)
  {
    this.defaultSmoothVersion = paramString;
  }
  
  public static String getEmptyMaterialPath()
  {
    return emptyMaterialPath;
  }
  
  public static void initResourcePath(String paramString1, String paramString2)
  {
    LogUtils.d("LightNode", "[initResourcePath] dirPath = " + paramString1 + " materialPath = " + paramString2);
    assetsDir = paramString1;
    emptyMaterialPath = paramString2;
  }
  
  private void setBundleToLightEngine(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      LogUtils.i("LightNode", "setBundleToLightEngine " + paramString2);
      this.cameraConfig.setLightAIModelPath(paramString1, paramString2);
    }
  }
  
  private void setListenersForConfig()
  {
    Log.d("LightNode", "setListenersForConfig: ");
    this.cameraConfig.setOnClickWatermarkListener(new LightNode.1(this));
    if ((this.wmDelegateMap != null) && (this.wmDelegateMap.size() > 0))
    {
      Iterator localIterator = this.wmDelegateMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry != null)
        {
          LogUtils.d("LightNode", "注入水印Delegate：" + (String)localEntry.getKey() + "|" + localEntry.getValue());
          this.cameraConfig.setWatermarkDelegate((String)localEntry.getKey(), (WatermarkDelegate)localEntry.getValue());
        }
      }
    }
    this.cameraConfig.setTipsListener(new LightNode.2(this));
    this.cameraConfig.setLightAssetListener(new LightNode.3(this));
  }
  
  public void apply()
  {
    if (isApplied()) {}
    do
    {
      return;
      if ((TextUtils.isEmpty(assetsDir)) || (TextUtils.isEmpty(emptyMaterialPath)))
      {
        LogUtils.e("LightNode", "apply LightNode terminated with exception: path null ! --> assetsDir=" + assetsDir + " ,emptyMaterialPath=" + emptyMaterialPath);
        return;
      }
      GLES20.glGenTextures(this.outTexs.length, this.outTexs, 0);
      Object localObject = new RendererConfig();
      ((RendererConfig)localObject).bundlePath = assetsDir;
      this.lightEngine = LightEngine.Make(null, null, (RendererConfig)localObject);
      this.lightSurface = LightSurface.FromTexture(this.outTexs[0], this.previewWidth, this.previewHeight, false);
      this.lightEngine.setSurface(this.lightSurface);
      this.videoOutput = this.lightEngine.videoOutput();
      this.audioReader = this.lightEngine.audioOutput();
      this.lightEngine.setBGMusicHidden(false);
      this.cameraConfig = CameraConfig.make();
      this.lightEngine.setConfig(this.cameraConfig);
      this.lightEngine.setDefaultBeautyVersion(this.defaultSmoothVersion);
      if (this.mNeedSetBundle)
      {
        localObject = this.bundlePathMap.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          if (localEntry != null) {
            setBundleToLightEngine((String)localEntry.getKey(), (String)localEntry.getValue());
          }
        }
        this.mNeedSetBundle = false;
      }
      localObject = new HashMap();
      ((Map)localObject).put(Config.ConfigKeys.ResourceDir.value(), assetsDir);
      this.cameraConfig.setConfigData((Map)localObject);
      this.cameraConfig.setRenderSize(this.previewWidth, this.previewHeight);
      setListenersForConfig();
      this.asset = LightAsset.Load(emptyMaterialPath, 0);
      this.cameraController = this.lightEngine.setAssetForCamera(this.asset);
      this.cameraConfig.setDetectShorterEdgeLength(180, "");
      if (this.orientationChanged) {
        this.cameraConfig.onSensorOrientationChanged((int)this.sensorEvent.values[0], (int)this.sensorEvent.values[1]);
      }
      this.startTime = System.nanoTime();
      this.mCopyFilter.applyFilterChain(true, this.previewWidth, this.previewHeight);
      this.mIsApplied = true;
    } while (this.appliedListener == null);
    this.appliedListener.onLightNodeApplied();
  }
  
  public void clear()
  {
    if (this.mCopyFilter != null)
    {
      this.mCopyFilter.clearGLSL();
      this.mCopyFilter = null;
    }
    if (this.videoOutput != null)
    {
      this.videoOutput.release();
      this.videoOutput = null;
    }
    if (this.audioReader != null)
    {
      this.audioReader.release();
      this.audioReader = null;
    }
    if (this.cameraController != null)
    {
      this.cameraController.release();
      this.cameraController = null;
    }
    if (this.lightEngine != null)
    {
      this.lightEngine.release();
      this.lightEngine = null;
    }
    if (this.lightSurface != null)
    {
      this.lightSurface.release();
      this.lightSurface = null;
    }
    this.cameraConfig = null;
    this.mIsApplied = false;
  }
  
  public void cmShowSetKapuAnimation(String paramString, CameraController.CmShowCallback paramCmShowCallback)
  {
    if (this.cameraController != null) {
      this.cameraController.setKapuAnimation(paramString, paramCmShowCallback);
    }
  }
  
  public void cmShowSetKapuCameraViewType(CameraController.CameraViewType paramCameraViewType)
  {
    if (this.cameraController != null) {
      this.cameraController.setKapuCameraViewType(paramCameraViewType);
    }
  }
  
  public void cmShowSetKapuDisplayType(CameraController.DisplayType paramDisplayType)
  {
    if (this.cameraController != null) {
      this.cameraController.setKapuDisplayType(paramDisplayType);
    }
  }
  
  public void cmShowSetKapuModel(HashMap<String, String> paramHashMap, String paramString, CameraController.CmShowCallback paramCmShowCallback)
  {
    if (this.cameraController != null) {
      this.cameraController.setKapuModel(paramHashMap, paramString, paramCmShowCallback);
    }
  }
  
  public void cmShowUpdateKapuMorph(CameraController.MorphType paramMorphType)
  {
    if (this.cameraController != null) {
      this.cameraController.updateKapuMorph(paramMorphType);
    }
  }
  
  public void cmShowUpdateTouchRotate(float[] paramArrayOfFloat)
  {
    if (this.cameraController != null) {
      this.cameraController.updateTouchRotate(paramArrayOfFloat);
    }
  }
  
  public void cmShowUpdateTouchScale(float paramFloat)
  {
    if (this.cameraController != null) {
      this.cameraController.updateTouchScale(paramFloat);
    }
  }
  
  public void cmShowUpdateViewParams(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float paramFloat)
  {
    if (this.cameraController != null) {
      this.cameraController.updateViewParams(paramArrayOfFloat1, paramArrayOfFloat2, paramFloat);
    }
  }
  
  public boolean currentMaterialIsCyberpunk()
  {
    return (this.cameraController != null) && (this.cameraController.needCyberpunkStyleAbility());
  }
  
  public String filterName()
  {
    return "LightNode";
  }
  
  public void freeCache()
  {
    if (this.lightSurface != null) {
      this.lightSurface.freeCache();
    }
  }
  
  public LightAsset getAsset()
  {
    return this.asset;
  }
  
  public AudioOutput getAudioReader()
  {
    return this.audioReader;
  }
  
  public List<WMElement> getEditableWMElement()
  {
    if (this.cameraController != null) {
      return this.cameraController.getEditableWMElement();
    }
    return null;
  }
  
  public PTFaceAttr getPtFaceAttr()
  {
    if (this.cameraConfig == null) {
      return null;
    }
    return TransformUtils.lightFaceToPTFaceAttr(this.cameraConfig.getFaceData());
  }
  
  public void initPreviewSize(int paramInt1, int paramInt2)
  {
    this.previewWidth = paramInt1;
    this.previewHeight = paramInt2;
  }
  
  public boolean isAbilityOn(String paramString)
  {
    if ((this.cameraConfig == null) || (this.cameraConfig.getConfigData() == null) || (this.cameraConfig.getConfigData().get(paramString) == null)) {
      return false;
    }
    return Boolean.valueOf((String)this.cameraConfig.getConfigData().get(paramString)).booleanValue();
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public Frame render(Frame paramFrame)
  {
    this.cameraConfig.setCameraTexture(paramFrame.getTextureId(), this.previewWidth, this.previewHeight, CameraConfig.DeviceCameraOrientation.ROTATION_0, this.inputOrigin);
    if (this.mAutoTest) {}
    for (long l = this.mFrameIndex * 80000;; l = (System.nanoTime() - this.startTime) / 1000L)
    {
      if (this.videoOutput != null) {
        this.videoOutput.readSample(l);
      }
      int i = this.outTexs[0];
      GLES20.glDisable(3042);
      GLES30.glBindVertexArray(0);
      GLES30.glBindBuffer(34962, 0);
      GLES30.glBindBuffer(34963, 0);
      paramFrame = new Frame();
      paramFrame.setSizedTexture(this.outTexs[0], this.previewWidth, this.previewHeight);
      return paramFrame;
    }
  }
  
  public void resetAsset()
  {
    if (this.cameraController != null)
    {
      this.cameraController.resetAsset();
      LogUtils.d("LightNode", "[resetAsset] success, start time(" + this.startTime + ") is reset to " + System.nanoTime());
      this.startTime = System.nanoTime();
      this.audioReader.seekTo(0L);
    }
  }
  
  public void setApplyListener(LightNodeAppliedListener paramLightNodeAppliedListener)
  {
    this.appliedListener = paramLightNodeAppliedListener;
  }
  
  public void setAutoTest(boolean paramBoolean)
  {
    this.mAutoTest = paramBoolean;
  }
  
  public void setExternalRenderCallback(ExternalRenderCallback paramExternalRenderCallback)
  {
    this.cameraConfig.setExternalRenderCallback(paramExternalRenderCallback);
  }
  
  public void setFrameIndex(int paramInt)
  {
    this.mFrameIndex = paramInt;
  }
  
  public void setGetOnlineUsrCountDelegate(String paramString, WatermarkDelegate paramWatermarkDelegate)
  {
    this.wmDelegateMap.put(paramString, paramWatermarkDelegate);
    if (this.cameraConfig != null)
    {
      LogUtils.d("LightNode", "设置水印delegate时config初始化完成，直接注入");
      this.cameraConfig.setWatermarkDelegate(paramString, paramWatermarkDelegate);
      return;
    }
    LogUtils.d("LightNode", "设置水印delegate时config尚未初始化，等待节点apply后注入");
  }
  
  public void setInputOrigin(CameraConfig.ImageOrigin paramImageOrigin)
  {
    this.inputOrigin = paramImageOrigin;
  }
  
  public void setLightBundle(String paramString1, String paramString2)
  {
    if (this.cameraConfig == null)
    {
      this.bundlePathMap.put(paramString1, paramString2);
      this.mNeedSetBundle = true;
      LogUtils.w("LightNode", "can not set to sdk now ");
      return;
    }
    setBundleToLightEngine(paramString1, paramString2);
    this.mNeedSetBundle = false;
  }
  
  public void setLightNodeLightAssetListener(LightAssetListener paramLightAssetListener)
  {
    this.mLightAssetListener = paramLightAssetListener;
  }
  
  public void setLightNodeTipsListener(LightNode.ILightNodeTipsListener paramILightNodeTipsListener)
  {
    this.mTipsListener = paramILightNodeTipsListener;
  }
  
  public void setOnClickWatermarkListener(IOnClickWatermarkListener paramIOnClickWatermarkListener)
  {
    this.mWatermarkClickListener = paramIOnClickWatermarkListener;
  }
  
  public void setPresetData(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (this.cameraController != null))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(paramString1, paramString2);
      this.cameraController.setPresetData(localHashMap);
    }
  }
  
  public void setPtFaceAttr(PTFaceAttr paramPTFaceAttr)
  {
    if (this.cameraConfig == null) {
      return;
    }
    this.cameraConfig.setFaceData(TransformUtils.ptFaceAttrToLightFaceData(paramPTFaceAttr));
  }
  
  public void setSensorEvent(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent == null) {
      LogUtils.e("LightNode", "[setSensorEvent]: event is null ");
    }
    do
    {
      return;
      if (this.cameraConfig != null) {
        break;
      }
    } while (this.sensorEvent == paramSensorEvent);
    this.sensorEvent = paramSensorEvent;
    this.orientationChanged = true;
    return;
    this.sensorEvent = paramSensorEvent;
    LogUtils.d("LightNode", "[setSensorEvent]: x=" + (int)this.sensorEvent.values[0] + " y=" + (int)this.sensorEvent.values[1]);
    this.cameraConfig.onSensorOrientationChanged((int)this.sensorEvent.values[0], (int)this.sensorEvent.values[1]);
  }
  
  public void setSyncMode(boolean paramBoolean)
  {
    if (this.cameraConfig != null) {
      this.cameraConfig.setSyncMode(paramBoolean);
    }
  }
  
  public void switchSegmentFastMode(boolean paramBoolean)
  {
    if (this.cameraController != null) {
      this.cameraController.setSegmentationFastMode(paramBoolean);
    }
  }
  
  public void updateAsset(String paramString)
  {
    if ((paramString == null) || (paramString.equals(this.assetPath))) {}
    do
    {
      return;
      this.assetPath = paramString;
      if (this.asset != null)
      {
        this.asset.nativeFinalize();
        this.asset = null;
      }
      LogUtils.i("LightNode", "LightAsset Path: " + paramString);
      this.asset = LightAsset.Load(paramString, 0);
    } while (this.lightEngine == null);
    this.cameraController = this.lightEngine.setAssetForCamera(this.asset);
    this.startTime = System.nanoTime();
  }
  
  public void updateAsset(LightAsset paramLightAsset)
  {
    if ((paramLightAsset == null) || (this.asset == paramLightAsset))
    {
      LogUtils.d("LightNode", "[updateAsset] lightAsset is null or already set, return");
      return;
    }
    LogUtils.d("LightNode", "[configFilters][updateAsset] 更新素材:" + paramLightAsset.toString());
    if (this.asset != null)
    {
      this.asset.nativeFinalize();
      this.asset = null;
    }
    this.asset = paramLightAsset;
    if (this.lightEngine != null) {
      this.cameraController = this.lightEngine.setAssetForCamera(this.asset);
    }
    this.startTime = System.nanoTime();
  }
  
  public void updateCameraConfigData(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (this.cameraConfig != null))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(paramString1, paramString2);
      this.cameraConfig.setConfigData(localHashMap);
    }
  }
  
  public void updateCameraConfigData(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (this.cameraConfig != null)) {
      this.cameraConfig.setConfigData(paramMap);
    }
  }
  
  public void updatePreviewSize(int paramInt1, int paramInt2)
  {
    initPreviewSize(paramInt1, paramInt2);
    if (this.cameraConfig != null) {
      this.cameraConfig.setRenderSize(paramInt1, paramInt2);
    }
    if (this.lightSurface != null) {
      this.lightSurface.updateSize(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.LightNode
 * JD-Core Version:    0.7.0.1
 */