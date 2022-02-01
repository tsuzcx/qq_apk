package com.tencent.ttpic.filament;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.support.annotation.RequiresApi;
import android.view.Surface;
import com.google.android.filament.Engine;
import com.google.android.filament.FilamentJNI;
import com.google.android.filament.Texture;
import com.google.android.filament.Texture.Builder;
import com.google.android.filament.Texture.InternalFormat;
import com.google.android.filament.Texture.Sampler;
import com.google.android.filament.android.TextureHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIActionCounter;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.ttpic.ar.sensor.representation.Matrix;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.gameplaysdk.model.Range;
import com.tencent.ttpic.openapi.PTDetectInfo.Builder;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.filter.SimpleGLThread;
import com.tencent.ttpic.openapi.initializer.Ace3DEngineInitializer;
import com.tencent.ttpic.openapi.listener.MaterialLoadFinishListener;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.AnimojiExpressionJava;
import com.tencent.ttpic.openapi.model.EyeNodeItem;
import com.tencent.ttpic.openapi.model.GLBItemJava;
import com.tencent.ttpic.openapi.model.NodeItemJava;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.GLB_FIELD;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import com.tencent.ttpic.trigger.TriggerManager;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.GsonUtils;
import com.tencent.view.RendererUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import org.jetbrains.annotations.NotNull;

public class FilamentFilter
  implements AEFilterI
{
  private static final boolean DEBUG = false;
  private static final String TAG = FilamentFilter.class.getSimpleName();
  private static final boolean USE_SHARE_CONTEXT = true;
  private List<String> animationItemNames;
  private ARManager arManager;
  private Texture cameraTexture;
  private List<Texture> cameraTextures = new ArrayList();
  private boolean canUseShareContext;
  private String dataPath;
  private String defaultAnimationName = "";
  private int defaultAnimationPlaycount;
  private LinkedBlockingDeque<Runnable> drawQueue = new LinkedBlockingDeque();
  private String faceMeshTextureKey;
  private Frame filamentFrame = new Frame();
  private FilamentJNI filamentJNI;
  private Map<String, Frame> frames = new HashMap();
  private Map<GLBItemJava, byte[]> glbBytesMap = new HashMap();
  private List<GLBItemJava> glbList;
  private boolean hasLoadGlbData;
  private boolean hasSetCameraTexture = false;
  private int height = -1;
  private final HashMap<String, Float> jawOpenThresholdMap = new HashMap();
  private byte[] jsonData;
  private Set<String> keys = new HashSet();
  private BaseFilter mCopyFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
  private Frame mCopyFrame = new Frame();
  private SimpleGLThread mHandler;
  private SurfaceTextureFilter mPreviewFilter = new SurfaceTextureFilter();
  private int[] mPreviewTextureId = new int[2];
  private EGLContext mShareContext;
  private volatile boolean modelLoadSucceed;
  private volatile boolean modelReady;
  private boolean needFaceMesh = false;
  private boolean needRender;
  private MaterialLoadFinishListener onLoadFinishListener;
  private int rotation = 0;
  private int skipFrame;
  private Surface surface;
  private SurfaceTexture surfaceTexture;
  private int width = -1;
  
  @RequiresApi(api=17)
  public FilamentFilter(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    this.glbList = paramVideoMaterial.getGlbList();
    updateJawOpenThreshold(this.glbList);
    this.dataPath = paramVideoMaterial.getDataPath();
    this.arManager = new ARManager(this.glbList, paramVideoMaterial.getIsAR3DMaterial());
    paramVideoMaterial = this.glbList.iterator();
    while (paramVideoMaterial.hasNext())
    {
      Iterator localIterator = ((GLBItemJava)paramVideoMaterial.next()).nodeList.iterator();
      while (localIterator.hasNext())
      {
        NodeItemJava localNodeItemJava = (NodeItemJava)localIterator.next();
        if (localNodeItemJava.needFaceMesh == 1) {
          this.needFaceMesh = true;
        }
        if (paramTriggerManager != null)
        {
          TriggerCtrlItem localTriggerCtrlItem = new TriggerCtrlItem(localNodeItemJava);
          paramTriggerManager.addTriggers(localTriggerCtrlItem);
          localNodeItemJava.triggerCtrlItem = localTriggerCtrlItem;
        }
      }
    }
    paramVideoMaterial = this.glbList.iterator();
    do
    {
      if (!paramVideoMaterial.hasNext()) {
        break;
      }
      this.faceMeshTextureKey = ((GLBItemJava)paramVideoMaterial.next()).faceMeshTextureKey;
    } while (this.faceMeshTextureKey.isEmpty());
    paramVideoMaterial = this.glbList.iterator();
    while (paramVideoMaterial.hasNext()) {
      if (((GLBItemJava)paramVideoMaterial.next()).hasSetCameraTexture()) {
        this.hasSetCameraTexture = true;
      }
    }
    paramVideoMaterial = this.glbList.iterator();
    while (paramVideoMaterial.hasNext())
    {
      paramTriggerManager = (GLBItemJava)paramVideoMaterial.next();
      this.keys.addAll(paramTriggerManager.specialFilterFrameKeys());
    }
    this.mShareContext = EGL14.eglGetCurrentContext();
    this.mHandler = new SimpleGLThread(EGL14.eglGetCurrentContext(), "HTM_Fila", null);
    AceMaterialManager.getInstance().setFilter(this);
  }
  
  private void checkDefaultAnimation(Map<String, Integer> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    Object localObject;
    String str;
    do
    {
      if (!paramMap.hasNext()) {
        break;
      }
      localObject = (Map.Entry)paramMap.next();
      str = (String)((Map.Entry)localObject).getKey();
      localObject = (Integer)((Map.Entry)localObject).getValue();
    } while (((!str.equals(this.defaultAnimationName)) || (((Integer)localObject).intValue() >= 0)) && ((str.equals(this.defaultAnimationName)) || (((Integer)localObject).intValue() < 0)));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.filamentJNI.stopAnimation(this.defaultAnimationName);
        return;
      }
      this.filamentJNI.playAnimation(this.defaultAnimationName, this.defaultAnimationPlaycount);
      return;
    }
  }
  
  private int[] getFaceInfoGenders(List<FaceInfo> paramList)
  {
    int[] arrayOfInt = new int[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfInt[i] = ((FaceInfo)paramList.get(i)).gender;
      i += 1;
    }
    return arrayOfInt;
  }
  
  private List<FaceInfo> getMaxValidFaceInfoList(List<FaceInfo> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    if ((i < paramList.size()) && (j < paramInt))
    {
      FaceInfo localFaceInfo = (FaceInfo)paramList.get(i);
      if (!FilamentUtil.isValidTransform(localFaceInfo.transform)) {}
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localFaceInfo);
        j += 1;
      }
    }
    return localArrayList;
  }
  
  private void initCameraTexture()
  {
    if ((!this.keys.isEmpty()) && (this.cameraTextures.isEmpty()))
    {
      Iterator localIterator = this.keys.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (Frame)this.frames.get(localObject);
        if (localObject != null) {
          this.cameraTextures.add(new Texture.Builder().width(((Frame)localObject).width).height(((Frame)localObject).height).levels(1).usage(16).sampler(Texture.Sampler.SAMPLER_2D).format(Texture.InternalFormat.RGBA8).build(this.filamentJNI.getEngine()));
        }
      }
    }
  }
  
  private void loadGlbData()
  {
    FilaBenchUtil.benchStart(FilamentUtil.BenchTag.LOAD_DATA.tag);
    Iterator localIterator = this.glbList.iterator();
    while (localIterator.hasNext())
    {
      GLBItemJava localGLBItemJava = (GLBItemJava)localIterator.next();
      byte[] arrayOfByte = (byte[])this.glbBytesMap.get(localGLBItemJava);
      this.filamentJNI.setGlbData(FileUtils.getFileNameWithSuffixByPath(localGLBItemJava.path), arrayOfByte);
    }
    this.filamentJNI.loadAllData();
    this.modelLoadSucceed = true;
    FilaBenchUtil.benchEnd(FilamentUtil.BenchTag.LOAD_DATA.tag);
    if (this.needFaceMesh) {
      this.filamentJNI.setImage(this.cameraTexture);
    }
  }
  
  private void resize(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 != this.width) || (paramInt2 != this.height) || (this.rotation != paramInt3))
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.rotation = paramInt3;
      float f = Math.min(paramInt1 / FilamentUtil.getProcessWidth(), 1.0F);
      int i = (int)(paramInt1 * f);
      int j = (int)(f * paramInt2);
      if (paramInt3 != 90)
      {
        paramInt2 = j;
        paramInt1 = i;
        if (paramInt3 != 270) {}
      }
      else
      {
        paramInt1 = i + j;
        paramInt2 = paramInt1 - j;
        paramInt1 -= paramInt2;
      }
      setupFilament();
      this.filamentJNI.resize(paramInt1, paramInt2);
      this.surfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
      if ((this.needFaceMesh) || (this.hasSetCameraTexture))
      {
        if (this.cameraTexture != null) {
          this.filamentJNI.getEngine().destroyTexture(this.cameraTexture);
        }
        this.cameraTexture = new Texture.Builder().width(paramInt1).height(paramInt2).levels(1).usage(16).sampler(Texture.Sampler.SAMPLER_2D).format(Texture.InternalFormat.RGBA8).build(this.filamentJNI.getEngine());
        if ((this.needFaceMesh) && (this.modelLoadSucceed)) {
          this.filamentJNI.setImage(this.cameraTexture);
        }
      }
    }
  }
  
  private void resizeForAr(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.width) || (paramInt2 != this.height))
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.rotation = 0;
      setupFilament();
      this.filamentJNI.resize(paramInt1, paramInt2);
      this.surfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
      if ((this.needFaceMesh) || (this.hasSetCameraTexture))
      {
        if (this.cameraTexture != null) {
          this.filamentJNI.getEngine().destroyTexture(this.cameraTexture);
        }
        this.cameraTexture = new Texture.Builder().width(paramInt1).height(paramInt2).levels(1).usage(16).sampler(Texture.Sampler.SAMPLER_2D).format(Texture.InternalFormat.RGBA8).build(this.filamentJNI.getEngine());
        if ((this.needFaceMesh) && (this.modelLoadSucceed)) {
          this.filamentJNI.setImage(this.cameraTexture);
        }
      }
    }
  }
  
  private void setupFilament()
  {
    this.mHandler.waitDone();
    if (this.filamentJNI != null) {}
    do
    {
      return;
      this.modelReady = false;
      this.modelLoadSucceed = false;
      this.hasLoadGlbData = false;
      this.filamentJNI = FilamentJNI.create(this.surface, this.mShareContext, Math.min(this.width, this.height), Math.max(this.width, this.height), FeatureManager.Features.ACE_3D_ENGINE.getFinalResourcesDir() + File.separator, this.dataPath, this.jsonData);
      this.arManager.setFilamentJNI(this.filamentJNI);
      AceMaterialManager.getInstance().setFilterNativeObject(this.filamentJNI.getNativeObject());
      if (!DeviceUtils.hasDeviceNormal(AEModule.getContext())) {
        this.filamentJNI.setNewFurLayers(0);
      }
      this.canUseShareContext = this.filamentJNI.canUseShareContext();
      this.mHandler.postJob(new FilamentFilter.3(this));
    } while (this.animationItemNames == null);
    this.filamentJNI.registerAnimation((String[])this.animationItemNames.toArray(new String[0]));
  }
  
  private void updateActionTriggered(AIAttr paramAIAttr, PTFaceAttr paramPTFaceAttr, int paramInt)
  {
    Object localObject1 = paramPTFaceAttr.getFaceActionCounter();
    Object localObject2 = AIActionCounter.getActions(AEDetectorType.HAND);
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    paramAIAttr = new PTDetectInfo.Builder().faceActionCounter((Map)localObject1).handActionCounter((Map)localObject2).triggeredExpression(localSet).aiAttr(paramAIAttr).faceDetector(paramPTFaceAttr.getFaceDetector()).timestamp(paramPTFaceAttr.getTimeStamp()).build();
    int i = 0;
    while (i < this.glbList.size())
    {
      boolean bool = ((GLBItemJava)this.glbList.get(i)).updateActionTriggered(paramAIAttr);
      int j = 0;
      while (j < paramInt)
      {
        this.filamentJNI.showOrHideAsset(j, i, bool);
        j += 1;
      }
      paramPTFaceAttr = ((GLBItemJava)this.glbList.get(i)).nodeList.iterator();
      while (paramPTFaceAttr.hasNext())
      {
        localObject1 = (NodeItemJava)paramPTFaceAttr.next();
        localObject2 = ((NodeItemJava)localObject1).getTexture(((GLBItemJava)this.glbList.get(i)).folder);
        if (((NodeItemJava)localObject1).triggerCtrlItem.isTriggered())
        {
          j = 0;
          while (j < paramInt)
          {
            this.filamentJNI.showOrHideAssetEntity(j, i, ((NodeItemJava)localObject1).name, ((NodeItemJava)localObject1).needShow);
            this.filamentJNI.setMaterialImage(j, i, ((NodeItemJava)localObject1).name, ((NodeItemJava)localObject1).material, (String)localObject2, true);
            j += 1;
          }
        }
      }
      i += 1;
    }
  }
  
  private void updateJawOpenThreshold(List<GLBItemJava> paramList)
  {
    paramList = paramList.iterator();
    label35:
    NodeItemJava localNodeItemJava;
    float f1;
    if (paramList.hasNext())
    {
      Iterator localIterator1 = ((GLBItemJava)paramList.next()).nodeList.iterator();
      if (localIterator1.hasNext())
      {
        localNodeItemJava = (NodeItemJava)localIterator1.next();
        Iterator localIterator2 = localNodeItemJava.expressionConfigList.iterator();
        f1 = 1.1F;
        label73:
        if (localIterator2.hasNext())
        {
          AnimojiExpressionJava localAnimojiExpressionJava = (AnimojiExpressionJava)localIterator2.next();
          if (!localAnimojiExpressionJava.shapeName.equals("disableeyeblinkwhenopenjaw")) {
            break label160;
          }
          float f2 = localAnimojiExpressionJava.shapeRange.min;
          if (f2 > 0.0F)
          {
            f1 = f2;
            if (f2 <= 1.0F) {}
          }
          else
          {
            f1 = 1.1F;
          }
        }
      }
    }
    label160:
    for (;;)
    {
      break label73;
      this.jawOpenThresholdMap.put(localNodeItemJava.name, Float.valueOf(f1));
      break label35;
      break;
      return;
    }
  }
  
  private void updateParams(AIAttr paramAIAttr, @NotNull PTFaceAttr paramPTFaceAttr, Frame paramFrame)
  {
    this.needRender = false;
    if (!this.modelReady) {}
    do
    {
      return;
      if (!this.modelLoadSucceed) {
        loadGlbData();
      }
    } while ((!this.arManager.isAR3DMaterial()) && (CollectionUtils.isEmpty(paramPTFaceAttr.getFaceInfoList())));
    Object localObject1 = getMaxValidFaceInfoList(paramPTFaceAttr.getFaceInfoList(), this.filamentJNI.getMaxFaceCount());
    if (this.arManager.isAR3DMaterial())
    {
      this.filamentJNI.setHeadCount(this.filamentJNI.getMaxFaceCount());
      updateActionTriggered(paramAIAttr, paramPTFaceAttr, ((List)localObject1).size());
      i = 0;
    }
    Object localObject3;
    int j;
    Object localObject4;
    for (;;)
    {
      if (i >= ((List)localObject1).size()) {
        break label421;
      }
      localObject2 = (FaceInfo)((List)localObject1).get(i);
      if (!this.arManager.isAR3DMaterial())
      {
        localObject3 = new float[16];
        Matrix.transposeM((float[])localObject3, 0, ((FaceInfo)localObject2).transform, 0);
        this.filamentJNI.setMaterialTransform(i, (float[])localObject3, ((FaceInfo)localObject2).denseFaceModel);
      }
      localObject3 = ((FaceInfo)localObject2).eyeRollWeights;
      j = 0;
      for (;;)
      {
        if (j >= this.glbList.size()) {
          break label412;
        }
        localObject4 = (GLBItemJava)this.glbList.get(j);
        Object localObject5;
        if (((FaceInfo)localObject2).expressionWeights != null)
        {
          localObject5 = ((GLBItemJava)localObject4).nodeList.iterator();
          for (;;)
          {
            if (((Iterator)localObject5).hasNext())
            {
              NodeItemJava localNodeItemJava = (NodeItemJava)((Iterator)localObject5).next();
              if (localNodeItemJava.enableExpressionConfigRemap) {
                FilamentUtil.adjustExpressionWeights(localNodeItemJava.expressionConfigList, ((FaceInfo)localObject2).expressionWeights, ((Float)this.jawOpenThresholdMap.get(localNodeItemJava.name)).floatValue(), ((FaceInfo)localObject2).angles);
              }
              if (localNodeItemJava.expressionOrderList.size() > 0)
              {
                FilamentUtil.setMorphWeights(this.filamentJNI, localNodeItemJava, ((FaceInfo)localObject2).expressionWeights, i, j);
                continue;
                this.filamentJNI.setHeadCount(((List)localObject1).size());
                break;
              }
            }
          }
        }
        localObject4 = ((GLBItemJava)localObject4).eyeNodeList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (EyeNodeItem)((Iterator)localObject4).next();
          this.filamentJNI.updateEyeNodeEuler(((EyeNodeItem)localObject5).name, (float[])localObject3, i, j);
        }
        j += 1;
      }
      label412:
      i += 1;
    }
    label421:
    localObject1 = getFaceInfoGenders((List)localObject1);
    Object localObject2 = new int[this.glbList.size()];
    int i = 0;
    while (i < localObject2.length)
    {
      localObject2[i] = ((GLBItemJava)this.glbList.get(i)).isHit();
      i += 1;
    }
    this.filamentJNI.changeAssetsDynamic((int[])localObject2, localObject2.length, (int[])localObject1, localObject1.length);
    AceMaterialManager.getInstance().setFaceLightness((float)paramPTFaceAttr.getFaceAverageL());
    this.filamentJNI.setAverageL(AceMaterialManager.getInstance().getFaceLightness());
    this.mCopyFilter.setRotationAndFlip(this.rotation, 0, 0);
    localObject1 = AlgoUtils.rotate(this.width, this.height, this.rotation);
    if ((this.canUseShareContext) && (this.cameraTexture != null)) {}
    for (i = this.cameraTexture.getId(this.filamentJNI.getEngine());; i = -1)
    {
      if ((this.needFaceMesh) || (this.hasSetCameraTexture))
      {
        paramPTFaceAttr = (Frame)this.frames.get(this.faceMeshTextureKey);
        if ((paramPTFaceAttr == null) || (this.hasSetCameraTexture)) {
          paramPTFaceAttr = paramFrame;
        }
        this.mCopyFilter.RenderProcess(paramPTFaceAttr.getTextureId(), ((Point)localObject1).x, ((Point)localObject1).y, i, 0.0D, this.mCopyFrame);
        GLES20.glFlush();
        if (!this.canUseShareContext)
        {
          paramPTFaceAttr = RendererUtils.saveTexture(this.mCopyFrame);
          if (BitmapUtils.isLegal(paramPTFaceAttr)) {
            TextureHelper.setBitmap(this.filamentJNI.getEngine(), this.cameraTexture, 0, paramPTFaceAttr);
          }
        }
        if (this.hasSetCameraTexture)
        {
          paramPTFaceAttr = this.filamentJNI;
          long l = this.cameraTexture.getNativeObject();
          paramPTFaceAttr.setDynamicTexture(new String[] { "$cameraTexture" }, new long[] { l });
        }
      }
      if ((this.keys.isEmpty()) || (this.frames.isEmpty())) {
        break label973;
      }
      paramPTFaceAttr = new ArrayList();
      paramFrame = new long[this.keys.size()];
      localObject2 = this.keys.iterator();
      j = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (String)((Iterator)localObject2).next();
        paramPTFaceAttr.add(localObject4);
        localObject3 = (Texture)this.cameraTextures.get(j);
        localObject4 = (Frame)this.frames.get(localObject4);
        this.mCopyFilter.RenderProcess(((Frame)localObject4).getTextureId(), ((Point)localObject1).x, ((Point)localObject1).y, i, 0.0D, this.mCopyFrame);
        if (!this.canUseShareContext)
        {
          localObject4 = RendererUtils.saveTexture(this.mCopyFrame);
          if (localObject4 != null) {
            TextureHelper.setBitmap(this.filamentJNI.getEngine(), (Texture)localObject3, 0, (Bitmap)localObject4);
          }
        }
        paramFrame[j] = ((Texture)localObject3).getNativeObject();
        j += 1;
      }
    }
    this.filamentJNI.setDynamicTexture((String[])paramPTFaceAttr.toArray(new String[0]), paramFrame);
    label973:
    this.mCopyFilter.setRotationAndFlip(0, 0, 0);
    if ((!this.keys.isEmpty()) && (this.frames.isEmpty())) {
      LogUtils.e(TAG, "自定义shader配置错误，导致获取不到吐出的frame（请检查滤镜顺序）。");
    }
    LogUtils.d(TAG, "test for averageL: " + AceMaterialManager.getInstance().getFaceLightness());
    this.arManager.initArModleStatus();
    this.arManager.changeViewMatrix(paramAIAttr);
    this.filamentJNI.render();
    this.needRender = true;
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    return paramFrame;
  }
  
  public void addTouchPoint(PointF paramPointF)
  {
    if (this.arManager != null) {
      this.arManager.addTouchPoint(paramPointF, this.width, this.height);
    }
  }
  
  public void arTracked()
  {
    if (this.arManager != null) {
      this.arManager.arTracked();
    }
  }
  
  public void destroy()
  {
    if (this.cameraTexture != null) {
      this.filamentJNI.getEngine().destroyTexture(this.cameraTexture);
    }
    Iterator localIterator = this.cameraTextures.iterator();
    while (localIterator.hasNext())
    {
      Texture localTexture = (Texture)localIterator.next();
      this.filamentJNI.getEngine().destroyTexture(localTexture);
    }
    LogUtils.d(TAG, "test for filament destory 1");
    this.mHandler.destroy();
    this.surfaceTexture.setOnFrameAvailableListener(null);
    LogUtils.d(TAG, "test for filament destory 2");
    this.surface.release();
    this.surfaceTexture.release();
    GLES20.glDeleteTextures(this.mPreviewTextureId.length, this.mPreviewTextureId, 0);
    this.filamentFrame.clear();
    this.mCopyFrame.clear();
    this.mCopyFilter.clearGLSLSelf();
    this.mPreviewFilter.clearGLSLSelf();
    AceMaterialManager.getInstance().removeMaterialInfo();
    if (this.filamentJNI != null) {
      this.filamentJNI.destroy();
    }
    FilaBenchUtil.init();
    this.arManager = null;
    LogUtils.d(TAG, "test for filament destory 3");
  }
  
  public void exportLightParams(JsonObject paramJsonObject)
  {
    int j = 0;
    paramJsonObject = GsonUtils.optJsonObject(paramJsonObject, VideoMaterialUtil.GLB_FIELD.LIGHT.value);
    if (paramJsonObject != null)
    {
      paramJsonObject.addProperty(VideoMaterialUtil.GLB_FIELD.INTENSITY.value, Integer.valueOf(AceMaterialManager.getInstance().getDirectionIntensity()));
      Object localObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.GLB_FIELD.DIRECTION.value);
      int i;
      if (localObject != null)
      {
        float[] arrayOfFloat = AceMaterialManager.getInstance().getLightDirection();
        i = 0;
        while ((i < ((JsonArray)localObject).size()) && (i < 3))
        {
          ((JsonArray)localObject).set(i, new JsonPrimitive(Float.valueOf(arrayOfFloat[i])));
          i += 1;
        }
      }
      paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.GLB_FIELD.COLOR.value);
      if (paramJsonObject != null)
      {
        localObject = AceMaterialManager.getInstance().getDirectionColor();
        i = j;
        while ((i < paramJsonObject.size()) && (i < 3))
        {
          paramJsonObject.set(i, new JsonPrimitive(Float.valueOf(localObject[i])));
          i += 1;
        }
      }
    }
  }
  
  public boolean exportParams()
  {
    int j = 0;
    JsonObject localJsonObject = VideoTemplateParser.parseVideoMaterialFileAsJSONObject(this.dataPath, "params", true, VideoTemplateParser.decryptListener);
    Object localObject = GsonUtils.optJsonArray(localJsonObject, VideoMaterialUtil.GLB_FIELD.GLB_LIST.value);
    if (localObject != null)
    {
      localObject = GsonUtils.optJsonObject((JsonArray)localObject, 0);
      if (localObject != null)
      {
        JsonArray localJsonArray = GsonUtils.optJsonArray((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.TRANSLATE.value);
        float[] arrayOfFloat;
        int i;
        if (localJsonArray != null)
        {
          arrayOfFloat = AceMaterialManager.getInstance().getPosition();
          i = 0;
          while ((i < localJsonArray.size()) && (i < 3))
          {
            localJsonArray.set(i, new JsonPrimitive(Float.valueOf(arrayOfFloat[i])));
            i += 1;
          }
        }
        localJsonArray = GsonUtils.optJsonArray((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.SCALE.value);
        if (localJsonArray != null)
        {
          arrayOfFloat = AceMaterialManager.getInstance().getScale();
          i = 0;
          while ((i < localJsonArray.size()) && (i < 3))
          {
            localJsonArray.set(i, new JsonPrimitive(Float.valueOf(arrayOfFloat[i])));
            i += 1;
          }
        }
        localJsonArray = GsonUtils.optJsonArray((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.ROTATE.value);
        if (localJsonArray != null)
        {
          arrayOfFloat = AceMaterialManager.getInstance().getRotation();
          i = j;
          while ((i < localJsonArray.size()) && (i < 3))
          {
            localJsonArray.set(i, new JsonPrimitive(Float.valueOf(arrayOfFloat[i])));
            i += 1;
          }
        }
        ((JsonObject)localObject).addProperty(VideoMaterialUtil.GLB_FIELD.IBL_INTENSITY.value, Integer.valueOf(AceMaterialManager.getInstance().getIblIntensity()));
        ((JsonObject)localObject).addProperty(VideoMaterialUtil.GLB_FIELD.IBL_ROTATION.value, Integer.valueOf(AceMaterialManager.getInstance().getIblRotation()));
        exportLightParams((JsonObject)localObject);
      }
    }
    FileUtils.saveFile(this.dataPath + "/" + "params" + ".json", localJsonObject.toString());
    return true;
  }
  
  public float[] getFilamentAssetPosition()
  {
    if (this.filamentJNI == null) {
      return null;
    }
    return this.filamentJNI.getFilamentAssetPosition();
  }
  
  public List<GLBItemJava> getGlbList()
  {
    return this.glbList;
  }
  
  public void initial()
  {
    FilaBenchUtil.benchStart(FilamentUtil.BenchTag.INIT.tag);
    FilaBenchUtil.benchStart(FilamentUtil.BenchTag.FIRST_RENDER.tag);
    FilaBenchUtil.benchStart(FilamentUtil.BenchTag.AFTER_RENDER.tag);
    GlUtil.glGenTextures(this.mPreviewTextureId.length, this.mPreviewTextureId, 0);
    this.mHandler.postJobSync(new FilamentFilter.1(this));
    this.mPreviewFilter.apply();
    this.mCopyFilter.apply();
    this.surface = new Surface(this.surfaceTexture);
    String str2 = VideoTemplateParser.readMaterialFile(this.dataPath, "params", true, VideoTemplateParser.decryptListener);
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.jsonData = str1.getBytes();
    this.surfaceTexture.setOnFrameAvailableListener(new FilamentFilter.2(this));
    FilaBenchUtil.benchEnd(FilamentUtil.BenchTag.INIT.tag);
  }
  
  public boolean isModelReady()
  {
    return this.modelReady;
  }
  
  public void pauseAnimation()
  {
    if (this.filamentJNI != null) {
      this.filamentJNI.pauseAnimation();
    }
  }
  
  public Frame render(Frame paramFrame, AIAttr paramAIAttr, PTFaceAttr paramPTFaceAttr)
  {
    BenchUtil.benchStart("[filament] updateParams");
    if ((this.needFaceMesh) && (!this.canUseShareContext) && (!DeviceUtils.hasDeviceHigh(AEModule.getContext()))) {}
    while (this.arManager.isArTracked()) {
      return paramFrame;
    }
    if (this.arManager.isAR3DMaterial())
    {
      resizeForAr(DeviceUtils.getScreenWidth(AEModule.getContext()), DeviceUtils.getScreenHeight(AEModule.getContext()));
      this.arManager.getCurDeviceOrientation(paramPTFaceAttr);
    }
    long l1;
    for (;;)
    {
      initCameraTexture();
      updateParams(paramAIAttr, paramPTFaceAttr, paramFrame);
      BenchUtil.benchEnd("[filament] updateParams");
      l1 = FilaBenchUtil.benchEnd(FilamentUtil.BenchTag.FIRST_RENDER.tag);
      if (this.needRender) {
        break;
      }
      this.skipFrame = 0;
      return paramFrame;
      resize(paramFrame.width, paramFrame.height, paramPTFaceAttr.getRotation());
    }
    LogUtils.d(TAG, "test for filament render called");
    FilaBenchUtil.benchStart(FilamentUtil.BenchTag.FIRST_FRAME.tag);
    try
    {
      BenchUtil.benchStart("[filament] wait");
      paramAIAttr = (Runnable)this.drawQueue.take();
      BenchUtil.benchEnd("[filament] wait");
      BenchUtil.benchStart("[filament] render");
      paramAIAttr.run();
      BenchUtil.benchEnd("[filament] render");
      long l2 = FilaBenchUtil.benchEnd(FilamentUtil.BenchTag.FIRST_FRAME.tag);
      if ((l1 > 0L) && (this.onLoadFinishListener != null)) {
        this.onLoadFinishListener.onLoadFinish(l2 + l1);
      }
      FilaBenchUtil.benchEnd(FilamentUtil.BenchTag.AFTER_RENDER.tag);
      FilaBenchUtil.reset();
      if (this.skipFrame < 1)
      {
        this.skipFrame += 1;
        return paramFrame;
      }
    }
    catch (InterruptedException paramAIAttr)
    {
      for (;;)
      {
        paramAIAttr.printStackTrace();
      }
      GlUtil.setBlendMode(true);
      this.mCopyFilter.RenderProcess(this.filamentFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, paramFrame);
      GlUtil.setBlendMode(false);
    }
    return paramFrame;
  }
  
  public void reset()
  {
    if (this.filamentJNI != null) {
      this.filamentJNI.reset();
    }
  }
  
  public void resumeAnimation()
  {
    if (this.filamentJNI != null) {
      this.filamentJNI.resumeAnimation();
    }
  }
  
  public void setAnimationItemNames(List<String> paramList)
  {
    this.animationItemNames = paramList;
  }
  
  public void setDefaultAnimation(String paramString, int paramInt)
  {
    this.defaultAnimationName = paramString;
    this.defaultAnimationPlaycount = paramInt;
  }
  
  public void setDownEventUnProjectionPoint(ArrayList<float[]> paramArrayList)
  {
    if (this.arManager != null) {
      this.arManager.setDownEventUnProjectionPoint(paramArrayList);
    }
  }
  
  public void setFilamentAssetScale(float paramFloat)
  {
    if (this.arManager != null) {
      this.arManager.setArModelScale(paramFloat);
    }
  }
  
  public void setFrames(Map<String, Frame> paramMap)
  {
    this.frames = paramMap;
  }
  
  public void setOnLoadFinishListener(MaterialLoadFinishListener paramMaterialLoadFinishListener)
  {
    this.onLoadFinishListener = paramMaterialLoadFinishListener;
  }
  
  public void setScreenMidPoint(float[] paramArrayOfFloat)
  {
    if (this.arManager != null) {
      this.arManager.setScreenMidPoint(paramArrayOfFloat);
    }
  }
  
  public void setUnProjectionHitPoint(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    if (this.arManager != null) {
      this.arManager.setUnProjectionHitPoint(paramArrayOfFloat, paramBoolean);
    }
  }
  
  public void updatePreview(Object paramObject)
  {
    if (this.filamentJNI == null) {}
    for (;;)
    {
      return;
      paramObject = (Map)paramObject;
      checkDefaultAnimation(paramObject);
      paramObject = paramObject.entrySet().iterator();
      while (paramObject.hasNext())
      {
        Object localObject = (Map.Entry)paramObject.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (Integer)((Map.Entry)localObject).getValue();
        if (!str.equals(this.defaultAnimationName))
        {
          if (((Integer)localObject).intValue() >= 0)
          {
            if (((Integer)localObject).intValue() == 0) {}
            for (int i = 999;; i = ((Integer)localObject).intValue())
            {
              this.filamentJNI.playAnimation(str, Integer.valueOf(i).intValue());
              break;
            }
          }
          this.filamentJNI.stopAnimation(str);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilamentFilter
 * JD-Core Version:    0.7.0.1
 */