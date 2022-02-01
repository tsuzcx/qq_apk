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
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.device.DeviceUtils;
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
import com.tencent.ttpic.openapi.model.VideoMaterial.GLB_FIELD;
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
import org.light.device.LightDeviceUtils;

public class FilamentFilter
  implements AEFilterI
{
  private static final boolean DEBUG = false;
  private static final String TAG = FilamentFilter.class.getSimpleName();
  private static final boolean USE_SHARE_CONTEXT = true;
  private List<String> animationItemNames;
  private ARManager arManager;
  private Texture cameraTexture;
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
  private final VideoMaterial material;
  private volatile boolean modelLoadSucceed;
  private volatile boolean modelReady;
  private List<Texture> multiViewerTextures = new ArrayList();
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
    this.material = paramVideoMaterial;
    this.glbList = paramVideoMaterial.getGlbList();
    updateJawOpenThreshold(this.glbList);
    this.dataPath = paramVideoMaterial.getDataPath();
    this.arManager = new ARManager(this.glbList, paramVideoMaterial.getIsAR3DMaterial(), paramVideoMaterial.getArShaderPlanOffset());
    paramVideoMaterial = this.glbList.iterator();
    while (paramVideoMaterial.hasNext())
    {
      GLBItemJava localGLBItemJava = (GLBItemJava)paramVideoMaterial.next();
      Iterator localIterator = localGLBItemJava.nodeList.iterator();
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
      if (localGLBItemJava.triggerCtrlItem != null) {
        paramTriggerManager.addTriggers(localGLBItemJava.triggerCtrlItem);
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
  
  private void initCameraTexture(int paramInt1, int paramInt2)
  {
    if ((this.needFaceMesh) || (this.hasSetCameraTexture))
    {
      if (this.cameraTexture != null) {
        this.filamentJNI.getEngine().destroyTexture(this.cameraTexture);
      }
      this.cameraTexture = new Texture.Builder().width(paramInt1).height(paramInt2).levels(1).usage(16).sampler(Texture.Sampler.SAMPLER_2D).format(Texture.InternalFormat.RGBA8).build(this.filamentJNI.getEngine());
      this.filamentJNI.setImage(this.cameraTexture);
      FilamentJNI localFilamentJNI = this.filamentJNI;
      long l = this.cameraTexture.getNativeObject();
      localFilamentJNI.setDynamicTexture(new String[] { "$cameraTexture" }, new long[] { l });
    }
  }
  
  private void initMultiViewerTexture(Map<String, Frame> paramMap)
  {
    long[] arrayOfLong;
    if ((!this.keys.isEmpty()) && (this.multiViewerTextures.isEmpty()))
    {
      arrayOfLong = new long[this.keys.size()];
      Iterator localIterator = this.keys.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        Object localObject = (Frame)paramMap.get((String)localIterator.next());
        if (localObject == null) {
          break label198;
        }
        localObject = new Texture.Builder().width(((Frame)localObject).width).height(((Frame)localObject).height).levels(1).usage(16).sampler(Texture.Sampler.SAMPLER_2D).format(Texture.InternalFormat.RGBA8).build(this.filamentJNI.getEngine());
        this.multiViewerTextures.add(localObject);
        int j = i + 1;
        arrayOfLong[i] = ((Texture)localObject).getNativeObject();
        i = j;
      }
    }
    label198:
    for (;;)
    {
      break;
      this.filamentJNI.setDynamicTexture((String[])this.keys.toArray(new String[0]), arrayOfLong);
      return;
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
  
  private void resize(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    float f = 1.0F;
    if ((paramInt1 != this.width) || (paramInt2 != this.height) || (this.rotation != paramInt3))
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.rotation = paramInt3;
      if (paramBoolean) {
        f = Math.min(paramInt1 / FilamentUtil.getProcessWidth(), 1.0F);
      }
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
      initCameraTexture(paramInt1, paramInt2);
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
  
  private void updateCameraAndMultiViewerFrames(Frame paramFrame)
  {
    this.mCopyFilter.setRotationAndFlip(this.rotation, 0, 0);
    Point localPoint = AlgoUtils.rotate(this.width, this.height, this.rotation);
    Object localObject1;
    label206:
    Object localObject2;
    if ((this.canUseShareContext) && (this.cameraTexture != null))
    {
      i = this.cameraTexture.getId(this.filamentJNI.getEngine());
      if ((this.needFaceMesh) || (this.hasSetCameraTexture))
      {
        localObject1 = (Frame)this.frames.get(this.faceMeshTextureKey);
        if ((localObject1 == null) || (this.hasSetCameraTexture)) {
          localObject1 = paramFrame;
        }
        this.mCopyFilter.RenderProcess(((Frame)localObject1).getTextureId(), localPoint.x, localPoint.y, i, 0.0D, this.mCopyFrame);
        GLES20.glFlush();
        if (!this.canUseShareContext)
        {
          paramFrame = RendererUtils.saveTexture(this.mCopyFrame);
          if (BitmapUtils.isLegal(paramFrame)) {
            TextureHelper.setBitmap(this.filamentJNI.getEngine(), this.cameraTexture, 0, paramFrame);
          }
        }
      }
      if ((this.keys.isEmpty()) || (this.frames.isEmpty())) {
        break label351;
      }
      paramFrame = this.keys.iterator();
      if (!paramFrame.hasNext()) {
        break label351;
      }
      localObject2 = (String)paramFrame.next();
      localObject1 = (Texture)this.multiViewerTextures.get(0);
      localObject2 = (Frame)this.frames.get(localObject2);
      if (!this.canUseShareContext) {
        break label346;
      }
    }
    label346:
    for (int i = ((Texture)localObject1).getId(this.filamentJNI.getEngine());; i = -1)
    {
      this.mCopyFilter.RenderProcess(((Frame)localObject2).getTextureId(), localPoint.x, localPoint.y, i, 0.0D, this.mCopyFrame);
      if (this.canUseShareContext) {
        break label206;
      }
      localObject2 = RendererUtils.saveTexture(this.mCopyFrame);
      if (localObject2 == null) {
        break label206;
      }
      TextureHelper.setBitmap(this.filamentJNI.getEngine(), (Texture)localObject1, 0, (Bitmap)localObject2);
      break label206;
      i = -1;
      break;
    }
    label351:
    this.mCopyFilter.setRotationAndFlip(0, 0, 0);
    if ((!this.keys.isEmpty()) && (this.frames.isEmpty())) {
      LogUtils.e(TAG, "自定义shader配置错误，导致获取不到吐出的frame（请检查滤镜顺序）。");
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
    List localList = getMaxValidFaceInfoList(paramPTFaceAttr.getFaceInfoList(), this.filamentJNI.getMaxFaceCount());
    int i;
    label101:
    FaceInfo localFaceInfo;
    Object localObject2;
    if (this.arManager.isAR3DMaterial())
    {
      this.filamentJNI.setHeadCount(this.filamentJNI.getMaxFaceCount());
      updateActionTriggered(paramAIAttr, paramPTFaceAttr, this.filamentJNI.getMaxFaceCount());
      i = 0;
      if (i >= localList.size()) {
        break label572;
      }
      localFaceInfo = (FaceInfo)localList.get(i);
      if (!this.arManager.isAR3DMaterial())
      {
        localObject2 = new float[16];
        Matrix.transposeM((float[])localObject2, 0, localFaceInfo.transform, 0);
        if ((paramPTFaceAttr.getFace3DVerticesArray() == null) || (paramPTFaceAttr.getFace3DVerticesArray().size() <= i)) {
          break label743;
        }
      }
    }
    label563:
    label572:
    label743:
    for (Object localObject1 = (float[])paramPTFaceAttr.getFace3DVerticesArray().get(i);; localObject1 = null)
    {
      Object localObject3;
      if ((paramPTFaceAttr.getFace3DRotationArray() != null) && (paramPTFaceAttr.getFace3DRotationArray().size() > i))
      {
        localObject3 = (float[])paramPTFaceAttr.getFace3DRotationArray().get(i);
        this.filamentJNI.setMvpMatrix((float[])localObject3, (float)paramPTFaceAttr.getFaceDetectScale());
      }
      if ((this.material.isFace3DMaterial()) && (paramPTFaceAttr.getFace3DRotationArray() != null) && (i == 0)) {
        localObject2 = (float[])paramPTFaceAttr.getFace3DRotationArray().get(2);
      }
      for (;;)
      {
        this.filamentJNI.setMaterialTransform(i, (float[])localObject2, localFaceInfo.denseFaceModel, (float[])localObject1);
        this.filamentJNI.updateFaceVertices(i, (float[])localObject1);
        localObject1 = localFaceInfo.eyeRollWeights;
        int j = 0;
        for (;;)
        {
          if (j >= this.glbList.size()) {
            break label563;
          }
          localObject2 = (GLBItemJava)this.glbList.get(j);
          if (localFaceInfo.expressionWeights != null)
          {
            localObject3 = ((GLBItemJava)localObject2).nodeList.iterator();
            for (;;)
            {
              if (((Iterator)localObject3).hasNext())
              {
                NodeItemJava localNodeItemJava = (NodeItemJava)((Iterator)localObject3).next();
                if (localNodeItemJava.enableExpressionConfigRemap) {
                  FilamentUtil.adjustExpressionWeights(localNodeItemJava.expressionConfigList, localFaceInfo.expressionWeights, ((Float)this.jawOpenThresholdMap.get(localNodeItemJava.name)).floatValue(), localFaceInfo.angles);
                }
                if (localNodeItemJava.expressionOrderList.size() > 0)
                {
                  FilamentUtil.setMorphWeights(this.filamentJNI, localNodeItemJava, localFaceInfo.expressionWeights, i, j);
                  continue;
                  this.filamentJNI.setHeadCount(localList.size());
                  updateActionTriggered(paramAIAttr, paramPTFaceAttr, localList.size());
                  break;
                }
              }
            }
          }
          localObject2 = ((GLBItemJava)localObject2).eyeNodeList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (EyeNodeItem)((Iterator)localObject2).next();
            this.filamentJNI.updateEyeNodeEuler(((EyeNodeItem)localObject3).name, (float[])localObject1, i, j);
          }
          j += 1;
        }
        i += 1;
        break label101;
        localObject1 = getFaceInfoGenders(localList);
        localObject2 = new int[this.glbList.size()];
        i = 0;
        while (i < localObject2.length)
        {
          localObject2[i] = ((GLBItemJava)this.glbList.get(i)).isHit();
          i += 1;
        }
        this.filamentJNI.changeAssetsDynamic((int[])localObject2, localObject2.length, (int[])localObject1, localObject1.length);
        AceMaterialManager.getInstance().setFaceLightness((float)paramPTFaceAttr.getFaceAverageL());
        this.filamentJNI.setAverageL(AceMaterialManager.getInstance().getFaceLightness());
        updateCameraAndMultiViewerFrames(paramFrame);
        LogUtils.d(TAG, "test for averageL: " + AceMaterialManager.getInstance().getFaceLightness());
        this.arManager.initArModleStatus();
        this.arManager.changeViewMatrix(paramAIAttr);
        this.filamentJNI.render();
        this.needRender = true;
        return;
      }
    }
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
    Iterator localIterator = this.multiViewerTextures.iterator();
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
    paramJsonObject = GsonUtils.optJsonObject(paramJsonObject, VideoMaterial.GLB_FIELD.LIGHT.value);
    if (paramJsonObject != null)
    {
      paramJsonObject.addProperty(VideoMaterial.GLB_FIELD.INTENSITY.value, Integer.valueOf(AceMaterialManager.getInstance().getDirectionIntensity()));
      Object localObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterial.GLB_FIELD.DIRECTION.value);
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
      paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterial.GLB_FIELD.COLOR.value);
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
    Object localObject = GsonUtils.optJsonArray(localJsonObject, VideoMaterial.GLB_FIELD.GLB_LIST.value);
    if (localObject != null)
    {
      localObject = GsonUtils.optJsonObject((JsonArray)localObject, 0);
      if (localObject != null)
      {
        JsonArray localJsonArray = GsonUtils.optJsonArray((JsonObject)localObject, VideoMaterial.GLB_FIELD.TRANSLATE.value);
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
        localJsonArray = GsonUtils.optJsonArray((JsonObject)localObject, VideoMaterial.GLB_FIELD.SCALE.value);
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
        localJsonArray = GsonUtils.optJsonArray((JsonObject)localObject, VideoMaterial.GLB_FIELD.ROTATE.value);
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
        ((JsonObject)localObject).addProperty(VideoMaterial.GLB_FIELD.IBL_INTENSITY.value, Integer.valueOf(AceMaterialManager.getInstance().getIblIntensity()));
        ((JsonObject)localObject).addProperty(VideoMaterial.GLB_FIELD.IBL_ROTATION.value, Integer.valueOf(AceMaterialManager.getInstance().getIblRotation()));
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
    int i = paramFrame.width;
    int k = paramFrame.height;
    int j = paramPTFaceAttr.getRotation();
    boolean bool;
    if (this.arManager.isAR3DMaterial())
    {
      i = LightDeviceUtils.getScreenWidth(AEModule.getContext());
      k = LightDeviceUtils.getScreenHeight(AEModule.getContext());
      bool = false;
      j = 0;
    }
    for (;;)
    {
      resize(i, k, j, bool);
      if (this.arManager.isAR3DMaterial()) {
        this.arManager.getCurDeviceOrientation(paramPTFaceAttr);
      }
      updateParams(paramAIAttr, paramPTFaceAttr, paramFrame);
      BenchUtil.benchEnd("[filament] updateParams");
      long l1 = FilaBenchUtil.benchEnd(FilamentUtil.BenchTag.FIRST_RENDER.tag);
      if (!this.needRender)
      {
        this.skipFrame = 0;
        return paramFrame;
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
          this.onLoadFinishListener.onLoadFinish(l1 + l2);
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
        return paramFrame;
      }
      bool = true;
    }
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
  
  public void setFilamentAssetRotate(float[] paramArrayOfFloat)
  {
    if (this.arManager != null) {
      this.arManager.setArModelRotate(paramArrayOfFloat);
    }
  }
  
  public void setFilamentAssetScale(float paramFloat)
  {
    if (this.arManager != null) {
      this.arManager.setArModelScale(paramFloat);
    }
  }
  
  public void setMultiViewerFrames(Map<String, Frame> paramMap)
  {
    this.frames = paramMap;
    initMultiViewerTexture(paramMap);
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
    if ((this.arManager != null) && (paramArrayOfFloat != null) && (paramArrayOfFloat.length >= 3)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilamentFilter
 * JD-Core Version:    0.7.0.1
 */