package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import android.hardware.SensorEvent;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.CommonUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.TransformUtils;
import com.tencent.ttpic.openapi.listener.LightNodeAppliedListener;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;
import com.tencent.ttpic.params.QQBeautyController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.libpag.VideoDecoder;
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
import org.light.DeviceCameraConfig;
import org.light.LightAsset;
import org.light.LightEngine;
import org.light.LightSurface;
import org.light.MaterialConfig;
import org.light.PhotoClip;
import org.light.RendererConfig;
import org.light.VideoOutput;
import org.light.bean.LightAIDataWrapper;
import org.light.bean.WMElement;
import org.light.callback.ExternalRenderCallback;
import org.light.listener.IOnClickWatermarkListener;
import org.light.listener.LightAIDataListener;
import org.light.listener.LightAssetListener;
import org.light.listener.WatermarkDelegate;

public class LightNode
  extends AEChainI
  implements ICMShowHandle
{
  private static String BODY_SEGMENT_MODEL_PATH = "assets/models/LightSegmentBody.bundle/";
  private static final int FRAME_INTERN_TIME = 80000;
  public static final int LIGHT_TIP_TYPE_NORMAL = 0;
  public static final int LIGHT_TIP_TYPE_PAG = 1;
  public static final String TAG = "LightNode";
  private static String assetsDir;
  private static String emptyMaterialPath;
  private Map<String, String> aiSwitchMap;
  LightNodeAppliedListener appliedListener;
  private LightAsset asset;
  private String assetPath = "";
  private AudioFrame audioFrame;
  private AudioOutput audioReader;
  private QQBeautyController beautyController;
  private HashMap<String, String> bundlePathMap = new HashMap();
  private CameraConfig cameraConfig;
  private CameraController cameraController;
  final String defaultSmoothVersion;
  private DeviceCameraConfig deviceCameraConfig;
  private CameraConfig.ImageOrigin inputOrigin = CameraConfig.ImageOrigin.BottomLeft;
  private boolean isBgmHidden = false;
  private boolean isPicNeedFlip = false;
  private boolean isRealtime = true;
  private LightEngine lightEngine;
  private LightSurface lightSurface;
  private boolean mAutoTest = false;
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame mCopyFrame = new Frame();
  private int mFrameIndex = 0;
  private LightAssetListener mLightAssetListener;
  private boolean mNeedSetBundle = false;
  private LightNode.ILightNodeTipsListener mTipsListener;
  private IOnClickWatermarkListener mWatermarkClickListener;
  private boolean needDowngrade = false;
  private boolean needInitBodySegment = true;
  private boolean needLowEndDownGrade = false;
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
    this("defaultBeautyV6.json", false, true, null, false);
  }
  
  public LightNode(String paramString, boolean paramBoolean1, boolean paramBoolean2, Map<String, String> paramMap, boolean paramBoolean3)
  {
    this.defaultSmoothVersion = paramString;
    this.isBgmHidden = paramBoolean1;
    this.isRealtime = paramBoolean2;
    this.aiSwitchMap = paramMap;
    this.needLowEndDownGrade = paramBoolean3;
    VideoDecoder.SetMaxHardwareDecoderCount(CommonUtils.getPAGSupportedDecoderInstanceCount());
  }
  
  private void addSwitchMap(Map<String, String> paramMap)
  {
    Map localMap = this.aiSwitchMap;
    if (localMap != null) {
      paramMap.putAll(localMap);
    }
  }
  
  public static String getEmptyMaterialPath()
  {
    return emptyMaterialPath;
  }
  
  public static void initResourcePath(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[initResourcePath] dirPath = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" materialPath = ");
    localStringBuilder.append(paramString2);
    LogUtils.d("LightNode", localStringBuilder.toString());
    assetsDir = paramString1;
    emptyMaterialPath = paramString2;
  }
  
  public static void setBodySegmentModelPath(String paramString)
  {
    BODY_SEGMENT_MODEL_PATH = paramString;
  }
  
  private void setBundleToLightEngine(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setBundleToLightEngine ");
      localStringBuilder.append(paramString2);
      LogUtils.i("LightNode", localStringBuilder.toString());
      this.cameraConfig.setLightAIModelPath(paramString1, paramString2);
    }
  }
  
  private void setEditorSegmentModel()
  {
    if (this.isRealtime)
    {
      localCameraConfig = this.cameraConfig;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(FeatureManager.getResourceDir());
      localStringBuilder.append(BODY_SEGMENT_MODEL_PATH);
      localCameraConfig.setLightAIModelPath(localStringBuilder.toString(), "BG_SEG_AGENT");
      return;
    }
    CameraConfig localCameraConfig = this.cameraConfig;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FeatureManager.getResourceDir());
    localStringBuilder.append(BODY_SEGMENT_MODEL_PATH);
    localCameraConfig.setLightAIModelPath(localStringBuilder.toString(), "veryhigh", "BG_SEG_AGENT");
  }
  
  private void setListenersForConfig()
  {
    Log.d("LightNode", "setListenersForConfig: ");
    this.cameraConfig.setOnClickWatermarkListener(new LightNode.1(this));
    Object localObject = this.wmDelegateMap;
    if ((localObject != null) && (((HashMap)localObject).size() > 0))
    {
      localObject = this.wmDelegateMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (localEntry != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("注入水印Delegate：");
          localStringBuilder.append((String)localEntry.getKey());
          localStringBuilder.append("|");
          localStringBuilder.append(localEntry.getValue());
          LogUtils.d("LightNode", localStringBuilder.toString());
          this.cameraConfig.setWatermarkDelegate((String)localEntry.getKey(), (WatermarkDelegate)localEntry.getValue());
        }
      }
    }
    this.cameraConfig.setTipsListener(new LightNode.2(this));
    this.cameraConfig.setLightAssetListener(new LightNode.3(this));
  }
  
  public void apply()
  {
    if (isApplied()) {
      return;
    }
    if ((!TextUtils.isEmpty(assetsDir)) && (!TextUtils.isEmpty(emptyMaterialPath)))
    {
      localObject1 = this.outTexs;
      GLES20.glGenTextures(localObject1.length, (int[])localObject1, 0);
      localObject1 = new RendererConfig(assetsDir);
      ((RendererConfig)localObject1).bundlePath = assetsDir;
      this.lightEngine = LightEngine.Make(null, null, (RendererConfig)localObject1);
      this.lightSurface = LightSurface.FromTexture(this.outTexs[0], this.previewWidth, this.previewHeight, false);
      this.lightEngine.setSurface(this.lightSurface);
      this.videoOutput = this.lightEngine.videoOutput();
      this.audioReader = this.lightEngine.audioOutput();
      this.lightEngine.setBGMusicHidden(this.isBgmHidden);
      this.cameraConfig = CameraConfig.make();
      this.beautyController = new QQBeautyController(new HashMap());
      this.beautyController.setCameraConfig(this.cameraConfig);
      this.cameraConfig.setLightBenchEnable(false);
      this.lightEngine.setConfig(this.cameraConfig);
      this.lightEngine.setDefaultBeautyVersion(this.defaultSmoothVersion);
      if (this.mNeedSetBundle)
      {
        localObject1 = this.bundlePathMap.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          if (localObject2 != null) {
            setBundleToLightEngine((String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
          }
        }
        this.mNeedSetBundle = false;
      }
      Object localObject2 = new HashMap();
      ((Map)localObject2).put(Config.ConfigKeys.ResourceDir.value(), assetsDir);
      addSwitchMap((Map)localObject2);
      int i;
      if ((this.needLowEndDownGrade) && (AEOfflineConfig.getPhonePerfLevel() < 3)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        localObject1 = "true";
      } else {
        localObject1 = "false";
      }
      ((Map)localObject2).put("device_fallback_smooth", localObject1);
      this.cameraConfig.setConfigData((Map)localObject2);
      this.cameraConfig.setRenderSize(this.previewWidth, this.previewHeight);
      setListenersForConfig();
      this.asset = LightAsset.Load(emptyMaterialPath, 0);
      this.cameraController = this.lightEngine.setAssetForCamera(this.asset);
      this.cameraConfig.setDetectShorterEdgeLength(180, "");
      this.cameraConfig.setDetectShorterEdgeLength(480, "VIEW_POINT_AGENT");
      if (this.needInitBodySegment)
      {
        setEditorSegmentModel();
        this.needInitBodySegment = false;
      }
      if (this.orientationChanged) {
        this.cameraConfig.onSensorOrientationChanged((int)this.sensorEvent.values[0], (int)this.sensorEvent.values[1]);
      }
      this.startTime = System.nanoTime();
      this.mCopyFilter.applyFilterChain(true, this.previewWidth, this.previewHeight);
      this.mIsApplied = true;
      localObject1 = this.appliedListener;
      if (localObject1 != null) {
        ((LightNodeAppliedListener)localObject1).onLightNodeApplied();
      }
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("apply LightNode terminated with exception: path null ! --> assetsDir=");
    ((StringBuilder)localObject1).append(assetsDir);
    ((StringBuilder)localObject1).append(" ,emptyMaterialPath=");
    ((StringBuilder)localObject1).append(emptyMaterialPath);
    LogUtils.e("LightNode", ((StringBuilder)localObject1).toString());
  }
  
  public void clear()
  {
    Object localObject = this.mCopyFilter;
    if (localObject != null)
    {
      ((BaseFilter)localObject).clearGLSL();
      this.mCopyFilter = null;
    }
    localObject = this.mCopyFrame;
    if (localObject != null)
    {
      ((Frame)localObject).clear();
      this.mCopyFrame = null;
    }
    localObject = this.videoOutput;
    if (localObject != null)
    {
      ((VideoOutput)localObject).release();
      this.videoOutput = null;
    }
    localObject = this.audioReader;
    if (localObject != null)
    {
      ((AudioOutput)localObject).release();
      this.audioReader = null;
    }
    localObject = this.cameraController;
    if (localObject != null)
    {
      ((CameraController)localObject).release();
      this.cameraController = null;
    }
    localObject = this.lightEngine;
    if (localObject != null)
    {
      ((LightEngine)localObject).release();
      this.lightEngine = null;
    }
    localObject = this.lightSurface;
    if (localObject != null)
    {
      ((LightSurface)localObject).release();
      this.lightSurface = null;
    }
    this.cameraConfig = null;
    this.mIsApplied = false;
  }
  
  public void cmShowSetKapuAnimation(String paramString, CameraController.CmShowCallback paramCmShowCallback)
  {
    CameraController localCameraController = this.cameraController;
    if (localCameraController != null) {
      localCameraController.setKapuAnimation(paramString, paramCmShowCallback);
    }
  }
  
  public void cmShowSetKapuCameraViewType(CameraController.CameraViewType paramCameraViewType)
  {
    CameraController localCameraController = this.cameraController;
    if (localCameraController != null) {
      localCameraController.setKapuCameraViewType(paramCameraViewType);
    }
  }
  
  public void cmShowSetKapuDisplayType(CameraController.DisplayType paramDisplayType)
  {
    CameraController localCameraController = this.cameraController;
    if (localCameraController != null) {
      localCameraController.setKapuDisplayType(paramDisplayType);
    }
  }
  
  public void cmShowSetKapuModel(HashMap<String, String> paramHashMap, String paramString, CameraController.CmShowCallback paramCmShowCallback)
  {
    CameraController localCameraController = this.cameraController;
    if (localCameraController != null) {
      localCameraController.setKapuModel(paramHashMap, paramString, paramCmShowCallback);
    }
  }
  
  public void cmShowUpdateKapuMorph(CameraController.MorphType paramMorphType)
  {
    CameraController localCameraController = this.cameraController;
    if (localCameraController != null) {
      localCameraController.updateKapuMorph(paramMorphType);
    }
  }
  
  public void cmShowUpdateTouchRotate(float[] paramArrayOfFloat)
  {
    CameraController localCameraController = this.cameraController;
    if (localCameraController != null) {
      localCameraController.updateTouchRotate(paramArrayOfFloat);
    }
  }
  
  public void cmShowUpdateTouchScale(float paramFloat)
  {
    CameraController localCameraController = this.cameraController;
    if (localCameraController != null) {
      localCameraController.updateTouchScale(paramFloat);
    }
  }
  
  public void cmShowUpdateViewParams(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float paramFloat)
  {
    CameraController localCameraController = this.cameraController;
    if (localCameraController != null) {
      localCameraController.updateViewParams(paramArrayOfFloat1, paramArrayOfFloat2, paramFloat);
    }
  }
  
  public boolean currentMaterialIsCyberpunk()
  {
    CameraController localCameraController = this.cameraController;
    return (localCameraController != null) && (localCameraController.needCyberpunkStyleAbility());
  }
  
  public String filterName()
  {
    return "LightNode";
  }
  
  public void freeCache()
  {
    LightSurface localLightSurface = this.lightSurface;
    if (localLightSurface != null) {
      localLightSurface.freeCache();
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
  
  public QQBeautyController getBeautyController()
  {
    return this.beautyController;
  }
  
  public List<WMElement> getEditableWMElement()
  {
    CameraController localCameraController = this.cameraController;
    if (localCameraController != null) {
      return localCameraController.getEditableWMElement();
    }
    return null;
  }
  
  public LightAIDataWrapper getLightAIDataWrapper(String[] paramArrayOfString, int paramInt)
  {
    CameraConfig localCameraConfig = this.cameraConfig;
    if (localCameraConfig == null) {
      return null;
    }
    return localCameraConfig.nativeGetAIData(paramArrayOfString, paramInt);
  }
  
  public PTFaceAttr getPtFaceAttr()
  {
    CameraConfig localCameraConfig = this.cameraConfig;
    if (localCameraConfig == null) {
      return null;
    }
    return TransformUtils.lightFaceToPTFaceAttr(localCameraConfig.getFaceData());
  }
  
  public void initPreviewSize(int paramInt1, int paramInt2)
  {
    this.previewWidth = paramInt1;
    this.previewHeight = paramInt2;
  }
  
  public boolean isAbilityOn(String paramString)
  {
    CameraConfig localCameraConfig = this.cameraConfig;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localCameraConfig != null)
    {
      bool1 = bool2;
      if (localCameraConfig.getConfigData() != null)
      {
        if (this.cameraConfig.getConfigData().get(paramString) == null) {
          return false;
        }
        bool1 = Boolean.valueOf((String)this.cameraConfig.getConfigData().get(paramString)).booleanValue();
      }
    }
    return bool1;
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public Frame render(Frame paramFrame)
  {
    int j = paramFrame.getTextureId();
    int i = j;
    if (this.isPicNeedFlip)
    {
      BaseFilter localBaseFilter = this.mCopyFilter;
      if (localBaseFilter != null)
      {
        localBaseFilter.setRotationAndFlip(0, 0, 1);
        this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), this.previewWidth, this.previewHeight, -1, 0.0D, this.mCopyFrame);
      }
      paramFrame = this.mCopyFrame;
      i = j;
      if (paramFrame != null) {
        i = paramFrame.getTextureId();
      }
    }
    this.cameraConfig.setCameraTexture(i, this.previewWidth, this.previewHeight, CameraConfig.DeviceCameraOrientation.ROTATION_0, this.inputOrigin);
    long l;
    if (this.mAutoTest) {
      l = this.mFrameIndex * 80000;
    } else {
      l = (System.nanoTime() - this.startTime) / 1000L;
    }
    paramFrame = this.videoOutput;
    if (paramFrame != null) {
      paramFrame.readSample(l);
    }
    i = this.outTexs[0];
    GLES20.glDisable(3042);
    GLES30.glBindVertexArray(0);
    GLES30.glBindBuffer(34962, 0);
    GLES30.glBindBuffer(34963, 0);
    paramFrame = new Frame();
    paramFrame.setSizedTexture(this.outTexs[0], this.previewWidth, this.previewHeight);
    return paramFrame;
  }
  
  public void resetAsset()
  {
    Object localObject = this.cameraController;
    if (localObject != null)
    {
      ((CameraController)localObject).resetAsset();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[resetAsset] success, start time(");
      ((StringBuilder)localObject).append(this.startTime);
      ((StringBuilder)localObject).append(") is reset to ");
      ((StringBuilder)localObject).append(System.nanoTime());
      LogUtils.d("LightNode", ((StringBuilder)localObject).toString());
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
  
  public void setCustomMaterial(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = this.asset;
      if (localObject == null) {
        return;
      }
      localObject = ((LightAsset)localObject).materialConfigs();
      if (localObject != null)
      {
        if (localObject.length < 1) {
          return;
        }
        localObject = localObject[0];
        PhotoClip localPhotoClip = new PhotoClip();
        localPhotoClip.path = paramString;
        localPhotoClip.duration = 0L;
        this.cameraController.setMaterialClipAssets(((MaterialConfig)localObject).key, new PhotoClip[] { localPhotoClip });
      }
    }
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
  
  public void setLightAIDataListener(LightAIDataListener paramLightAIDataListener)
  {
    CameraConfig localCameraConfig = this.cameraConfig;
    if (localCameraConfig != null) {
      localCameraConfig.setLightAIDataListener(paramLightAIDataListener);
    }
  }
  
  public void setLightAIDataWrapper(LightAIDataWrapper paramLightAIDataWrapper)
  {
    CameraConfig localCameraConfig = this.cameraConfig;
    if (localCameraConfig != null) {
      localCameraConfig.nativeSetAIData(paramLightAIDataWrapper);
    }
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
  
  public void setPicNeedFlip(boolean paramBoolean)
  {
    this.isPicNeedFlip = paramBoolean;
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
    CameraConfig localCameraConfig = this.cameraConfig;
    if (localCameraConfig == null) {
      return;
    }
    localCameraConfig.setFaceData(TransformUtils.ptFaceAttrToLightFaceData(paramPTFaceAttr));
  }
  
  public void setSensorEvent(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent == null)
    {
      LogUtils.e("LightNode", "[setSensorEvent]: event is null ");
      return;
    }
    if (this.cameraConfig == null)
    {
      if (this.sensorEvent != paramSensorEvent)
      {
        this.sensorEvent = paramSensorEvent;
        this.orientationChanged = true;
      }
    }
    else
    {
      this.sensorEvent = paramSensorEvent;
      paramSensorEvent = new StringBuilder();
      paramSensorEvent.append("[setSensorEvent]: x=");
      paramSensorEvent.append((int)this.sensorEvent.values[0]);
      paramSensorEvent.append(" y=");
      paramSensorEvent.append((int)this.sensorEvent.values[1]);
      LogUtils.d("LightNode", paramSensorEvent.toString());
      this.cameraConfig.onSensorOrientationChanged((int)this.sensorEvent.values[0], (int)this.sensorEvent.values[1]);
    }
  }
  
  public void setSyncMode(boolean paramBoolean)
  {
    CameraConfig localCameraConfig = this.cameraConfig;
    if (localCameraConfig != null) {
      localCameraConfig.setSyncMode(paramBoolean);
    }
  }
  
  public void switchSegmentFastMode(boolean paramBoolean)
  {
    CameraController localCameraController = this.cameraController;
    if (localCameraController != null) {
      localCameraController.setSegmentationFastMode(paramBoolean);
    }
  }
  
  public void updateAsset(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.equals(this.assetPath)) {
        return;
      }
      this.assetPath = paramString;
      Object localObject = this.asset;
      if (localObject != null)
      {
        ((LightAsset)localObject).nativeFinalize();
        this.asset = null;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LightAsset Path: ");
      ((StringBuilder)localObject).append(paramString);
      LogUtils.i("LightNode", ((StringBuilder)localObject).toString());
      this.asset = LightAsset.Load(paramString, 0);
      paramString = this.lightEngine;
      if (paramString != null)
      {
        this.cameraController = paramString.setAssetForCamera(this.asset);
        this.startTime = System.nanoTime();
      }
    }
  }
  
  public void updateAsset(LightAsset paramLightAsset)
  {
    if ((paramLightAsset != null) && (this.asset != paramLightAsset))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[configFilters][updateAsset] 更新素材:");
      ((StringBuilder)localObject).append(paramLightAsset.toString());
      LogUtils.d("LightNode", ((StringBuilder)localObject).toString());
      localObject = this.asset;
      if (localObject != null)
      {
        ((LightAsset)localObject).nativeFinalize();
        this.asset = null;
      }
      this.asset = paramLightAsset;
      paramLightAsset = this.lightEngine;
      if (paramLightAsset != null) {
        this.cameraController = paramLightAsset.setAssetForCamera(this.asset);
      }
      this.startTime = System.nanoTime();
      return;
    }
    LogUtils.d("LightNode", "[updateAsset] lightAsset is null or already set, return");
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
    if (paramMap != null)
    {
      CameraConfig localCameraConfig = this.cameraConfig;
      if (localCameraConfig != null) {
        localCameraConfig.setConfigData(paramMap);
      }
    }
  }
  
  public void updateCameraTextureTimestamp(long paramLong)
  {
    CameraController localCameraController = this.cameraController;
    if (localCameraController != null) {
      localCameraController.updateCameraTextureTimestamp(paramLong);
    }
  }
  
  public void updateDeviceCameraConfig(DeviceCameraConfig paramDeviceCameraConfig)
  {
    if (paramDeviceCameraConfig == null) {
      return;
    }
    int j = 0;
    if (this.deviceCameraConfig == null) {
      this.deviceCameraConfig = new DeviceCameraConfig();
    }
    int i = j;
    CameraConfig localCameraConfig;
    if (paramDeviceCameraConfig.cameraIndex != this.deviceCameraConfig.cameraIndex)
    {
      localCameraConfig = this.cameraConfig;
      i = j;
      if (localCameraConfig != null)
      {
        localCameraConfig.onCameraChanged(paramDeviceCameraConfig.cameraIndex);
        this.deviceCameraConfig.cameraIndex = paramDeviceCameraConfig.cameraIndex;
        i = 1;
      }
    }
    j = i;
    if (paramDeviceCameraConfig.cameraHorizontalFov != this.deviceCameraConfig.cameraHorizontalFov)
    {
      localCameraConfig = this.cameraConfig;
      j = i;
      if (localCameraConfig != null)
      {
        localCameraConfig.setHorizontalFov(paramDeviceCameraConfig.cameraHorizontalFov);
        this.deviceCameraConfig.cameraHorizontalFov = paramDeviceCameraConfig.cameraHorizontalFov;
        j = 1;
      }
    }
    if (j != 0)
    {
      paramDeviceCameraConfig = this.lightEngine;
      if (paramDeviceCameraConfig != null)
      {
        localCameraConfig = this.cameraConfig;
        if (localCameraConfig != null) {
          paramDeviceCameraConfig.setConfig(localCameraConfig);
        }
      }
    }
  }
  
  public void updatePreviewSize(int paramInt1, int paramInt2)
  {
    initPreviewSize(paramInt1, paramInt2);
    Object localObject = this.cameraConfig;
    if (localObject != null) {
      ((CameraConfig)localObject).setRenderSize(paramInt1, paramInt2);
    }
    localObject = this.lightSurface;
    if (localObject != null) {
      ((LightSurface)localObject).updateSize(paramInt1, paramInt2);
    }
  }
  
  public void updateTouchEvent(int paramInt1, long paramLong1, long paramLong2, ArrayList<PointF> paramArrayList, int paramInt2, int paramInt3)
  {
    CameraController localCameraController = this.cameraController;
    if (localCameraController != null) {
      localCameraController.updateTouchEvent(paramInt1, paramLong1, paramLong2, paramArrayList, paramInt2, paramInt3);
    }
  }
  
  public void updateVoiceDecibel(float paramFloat)
  {
    CameraController localCameraController = this.cameraController;
    if (localCameraController != null) {
      localCameraController.updateVoiceDecibel(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.LightNode
 * JD-Core Version:    0.7.0.1
 */