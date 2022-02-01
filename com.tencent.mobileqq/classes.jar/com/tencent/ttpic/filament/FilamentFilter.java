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
import com.google.android.filament.Camera;
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
import com.tencent.ttpic.baseutils.device.DeviceInstance.SOC_CLASS;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
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
import com.tencent.ttpic.openapi.model.CameraTransform;
import com.tencent.ttpic.openapi.model.CameraViewConfig;
import com.tencent.ttpic.openapi.model.EyeNodeItem;
import com.tencent.ttpic.openapi.model.GLBItemJava;
import com.tencent.ttpic.openapi.model.KapuModelViewParam;
import com.tencent.ttpic.openapi.model.NodeItemJava;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.MatrixUtil;
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
  private static final float KAPU_SCALE = 1.0F;
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
  private boolean hasSetCameraTexture = false;
  private int height = -1;
  private final HashMap<String, Float> jawOpenThresholdMap = new HashMap();
  private byte[] jsonData;
  private String jsonName;
  private Set<String> keys = new HashSet();
  private ArrayList<CMShowUserLoader> loaderList = new ArrayList();
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
  private CmShowMaterialDisplayType showMaterialDisplayType = null;
  private int skipFrame;
  private Surface surface;
  private SurfaceTexture surfaceTexture;
  private KapuModelViewParam viewParam;
  private int width = -1;
  
  @RequiresApi(api=17)
  public FilamentFilter(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    this.material = paramVideoMaterial;
    this.glbList = paramVideoMaterial.getGlbList();
    updateJawOpenThreshold(this.glbList);
    this.dataPath = paramVideoMaterial.getDataPath();
    this.jsonName = paramVideoMaterial.getJsonName();
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
    if (paramList == null) {
      return localArrayList;
    }
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
  
  private void loadKapuData()
  {
    if ((this.loaderList == null) || (this.loaderList.isEmpty())) {}
    for (;;)
    {
      return;
      if (!this.modelLoadSucceed)
      {
        this.filamentJNI.loadAllData();
        long[] arrayOfLong = new long[this.loaderList.size()];
        i = 0;
        while (i < this.loaderList.size())
        {
          arrayOfLong[i] = ((CMShowUserLoader)this.loaderList.get(i)).getNativeObject();
          i += 1;
        }
        this.filamentJNI.setupLoaders(arrayOfLong);
        this.modelLoadSucceed = true;
      }
      int j = 0;
      int i = 0;
      if (j < this.loaderList.size())
      {
        if ((i != 0) || (((CMShowUserLoader)this.loaderList.get(j)).getNeedUpdate())) {}
        for (i = 1;; i = 0)
        {
          j += 1;
          break;
        }
      }
      if (i != 0)
      {
        FilaBenchUtil.benchStart(FilamentUtil.BenchTag.KAPU_LOAD_DATA.tag);
        this.filamentJNI.loadDataForCMShow();
        this.filamentJNI.setKapuAnimation();
        FilaBenchUtil.benchEnd(FilamentUtil.BenchTag.KAPU_LOAD_DATA.tag);
        if (this.showMaterialDisplayType != null) {
          setKapuMaterialDisplayType(this.showMaterialDisplayType);
        }
        this.filamentJNI.initKapuModelPosition();
        AceMaterialManager.getInstance().getPosition();
        AceMaterialManager.getInstance().getScale();
        AceMaterialManager.getInstance().getRotation();
        i = 0;
        while (i < this.loaderList.size())
        {
          ((CMShowUserLoader)this.loaderList.get(i)).setNeedUpdate(false);
          if ((this.viewParam != null) && (this.viewParam.viewSize != null) && (this.viewParam.boundingBox != null)) {
            this.filamentJNI.adjustKapuModelView(i, this.viewParam.viewSize, this.viewParam.boundingBox, this.viewParam.bottomMargin);
          }
          i += 1;
        }
      }
    }
  }
  
  private void resize(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (this.material.isKapuMaterial())
    {
      resizeKapu(paramInt1, paramInt2);
      return;
    }
    resizeNormal(paramInt1, paramInt2, paramInt3, paramBoolean);
  }
  
  private void resizeKapu(int paramInt1, int paramInt2)
  {
    if ((paramInt1 * 1.0F != this.width) || (paramInt2 * 1.0F != this.height))
    {
      this.width = ((int)(paramInt1 * 1.0F));
      this.height = ((int)(paramInt2 * 1.0F));
      FilaBenchUtil.benchStart(FilamentUtil.BenchTag.KAPU_INIT_FILTER.tag);
      setupFilament();
      this.filamentJNI.resize(this.width, this.height);
      this.surfaceTexture.setDefaultBufferSize(this.width, this.height);
      FilaBenchUtil.benchEnd(FilamentUtil.BenchTag.KAPU_INIT_FILTER.tag);
    }
  }
  
  private void resizeNormal(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
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
    if (this.filamentJNI != null) {
      return;
    }
    this.modelReady = false;
    this.modelLoadSucceed = false;
    this.filamentJNI = FilamentJNI.create(this.surface, this.mShareContext, Math.min(this.width, this.height), Math.max(this.width, this.height), FeatureManager.Features.ACE_3D_ENGINE.getFinalResourcesDir() + File.separator, this.dataPath, this.jsonData, this.material.isKapuMaterial(), DeviceUtils.getDeviceSocClass(AEModule.getContext()).value);
    AceMaterialManager.getInstance().setFilterNativeObject(this.filamentJNI.getNativeObject());
    if (this.material.isKapuMaterial())
    {
      initCameraTransform();
      return;
    }
    setupNormalConfig();
  }
  
  private void setupKapuConfig()
  {
    CmShowAssetsData localCmShowAssetsData = new CmShowAssetsData();
    localCmShowAssetsData.roleResDir = "/sdcard/aekit/stickers/dresslist/3000055";
    localCmShowAssetsData.dressResMap.put("hair", "/sdcard/aekit/stickers/dresslist/3000604");
    localCmShowAssetsData.dressResMap.put("tops", "/sdcard/aekit/stickers/dresslist/3000605");
    localCmShowAssetsData.dressResMap.put("pants", "/sdcard/aekit/stickers/dresslist/3000606");
    localCmShowAssetsData.dressResMap.put("shoes", "/sdcard/aekit/stickers/dresslist/3000607");
    localCmShowAssetsData.dressResMap.put("stocking", "/sdcard/aekit/stickers/dresslist/3000608");
    localCmShowAssetsData.dressResMap.put("eyelash", "/sdcard/aekit/stickers/dresslist/3000420");
    localCmShowAssetsData.dressResMap.put("eyebrow", "/sdcard/aekit/stickers/dresslist/3000421");
    localCmShowAssetsData.dressResMap.put("eyes", "/sdcard/aekit/stickers/dresslist/3000536");
  }
  
  private void setupNormalConfig()
  {
    this.arManager.setFilamentJNI(this.filamentJNI);
    if (!DeviceUtils.hasDeviceNormal(AEModule.getContext())) {
      this.filamentJNI.setNewFurLayers(0);
    }
    this.canUseShareContext = this.filamentJNI.canUseShareContext();
    this.mHandler.postJob(new FilamentFilter.3(this));
    if (this.animationItemNames != null) {
      this.filamentJNI.registerAnimation((String[])this.animationItemNames.toArray(new String[0]));
    }
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
    if (this.material.isKapuMaterial())
    {
      loadKapuData();
      if (this.modelLoadSucceed)
      {
        updateParamsKapu(paramAIAttr, paramPTFaceAttr);
        this.filamentJNI.render();
        this.needRender = true;
      }
      return;
    }
    updateParamsNormal(paramAIAttr, paramPTFaceAttr, paramFrame);
  }
  
  private void updateParamsKapu(AIAttr paramAIAttr, @NotNull PTFaceAttr paramPTFaceAttr)
  {
    paramPTFaceAttr = getMaxValidFaceInfoList(paramPTFaceAttr.getFaceInfoList(), this.filamentJNI.getMaxFaceCount());
    int i = 0;
    FaceInfo localFaceInfo;
    if (i < paramPTFaceAttr.size())
    {
      localFaceInfo = (FaceInfo)paramPTFaceAttr.get(i);
      paramAIAttr = new float[16];
      Matrix.transposeM(paramAIAttr, 0, localFaceInfo.transform, 0);
      this.filamentJNI.setKapuHeadTransform(i, paramAIAttr);
      if (localFaceInfo.expressionWeights != null)
      {
        paramAIAttr = new ArrayList();
        if ((this.glbList.size() <= 0) || (((GLBItemJava)this.glbList.get(0)).nodeList.size() <= 0)) {
          break label259;
        }
        paramAIAttr = ((NodeItemJava)((GLBItemJava)this.glbList.get(0)).nodeList.get(0)).expressionConfigList;
      }
    }
    label259:
    for (;;)
    {
      FilamentUtil.setMorphWeightsKapu(this.filamentJNI, localFaceInfo.expressionWeights, i, paramAIAttr);
      i += 1;
      break;
      if ((paramPTFaceAttr.size() == 0) && (this.material.getKapuMaterialType() == 1))
      {
        paramAIAttr = new float[16];
        Matrix.setIdentityM(paramAIAttr, 0);
        this.filamentJNI.setKapuHeadTransform(0, paramAIAttr);
        FilamentUtil.setMorphWeightsKapu(this.filamentJNI, null, 0, null);
      }
      if (this.filamentJNI.getAnimationOver())
      {
        paramAIAttr = this.loaderList.iterator();
        while (paramAIAttr.hasNext()) {
          ((CMShowUserLoader)paramAIAttr.next()).animationEnd();
        }
      }
      return;
    }
  }
  
  private void updateParamsNormal(AIAttr paramAIAttr, @NotNull PTFaceAttr paramPTFaceAttr, Frame paramFrame)
  {
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
    label96:
    FaceInfo localFaceInfo;
    Object localObject2;
    if (this.arManager.isAR3DMaterial())
    {
      this.filamentJNI.setHeadCount(this.filamentJNI.getMaxFaceCount());
      updateActionTriggered(paramAIAttr, paramPTFaceAttr, this.filamentJNI.getMaxFaceCount());
      i = 0;
      if (i >= localList.size()) {
        break label567;
      }
      localFaceInfo = (FaceInfo)localList.get(i);
      if (!this.arManager.isAR3DMaterial())
      {
        localObject2 = new float[16];
        Matrix.transposeM((float[])localObject2, 0, localFaceInfo.transform, 0);
        if ((paramPTFaceAttr.getFace3DVerticesArray() == null) || (paramPTFaceAttr.getFace3DVerticesArray().size() <= i)) {
          break label738;
        }
      }
    }
    label558:
    label567:
    label738:
    for (Object localObject1 = (float[])paramPTFaceAttr.getFace3DVerticesArray().get(i);; localObject1 = null)
    {
      Object localObject3;
      if ((paramPTFaceAttr.getFace3DRotationArray() != null) && (paramPTFaceAttr.getFace3DRotationArray().size() > i))
      {
        localObject3 = (float[])paramPTFaceAttr.getFace3DRotationArray().get(i);
        this.filamentJNI.setMvpMatrix((float[])localObject3, (float)paramPTFaceAttr.getFaceDetectScale());
      }
      if ((this.material.isUse3DMMTransform()) && (paramPTFaceAttr.getFace3DRotationArray() != null) && (i == 0)) {
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
            break label558;
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
        break label96;
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
  
  public void initCameraTransform()
  {
    if (((this.material.getIsAR3DMaterial()) || (this.material.isKapuMaterial())) && (this.filamentJNI != null))
    {
      Camera localCamera = this.filamentJNI.getCamera();
      Object localObject = this.material.getCameraTransform();
      if (localObject != null)
      {
        List localList = ((CameraTransform)localObject).getCameraPosition();
        localObject = ((CameraTransform)localObject).getCameraRotation();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Float.valueOf(1.0F));
        localArrayList.add(Float.valueOf(1.0F));
        localArrayList.add(Float.valueOf(1.0F));
        localCamera.setModelMatrix(MatrixUtil.compose(localList, localArrayList, (List)localObject));
      }
    }
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
    String str2 = VideoTemplateParser.readMaterialFile(this.dataPath, this.jsonName, true, VideoTemplateParser.decryptListener);
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
  
  public void playKapuAnimation()
  {
    this.filamentJNI.playKapuAnimation();
  }
  
  /* Error */
  public Frame render(Frame paramFrame, AIAttr paramAIAttr, PTFaceAttr paramPTFaceAttr)
  {
    // Byte code:
    //   0: ldc_w 1359
    //   3: invokestatic 1362	com/tencent/ttpic/baseutils/fps/BenchUtil:benchStart	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: getfield 152	com/tencent/ttpic/filament/FilamentFilter:needFaceMesh	Z
    //   10: ifeq +21 -> 31
    //   13: aload_0
    //   14: getfield 751	com/tencent/ttpic/filament/FilamentFilter:canUseShareContext	Z
    //   17: ifne +14 -> 31
    //   20: invokestatic 661	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   23: invokestatic 1365	com/tencent/ttpic/baseutils/device/DeviceUtils:hasDeviceHigh	(Landroid/content/Context;)Z
    //   26: ifne +5 -> 31
    //   29: aload_1
    //   30: areturn
    //   31: aload_0
    //   32: getfield 213	com/tencent/ttpic/filament/FilamentFilter:arManager	Lcom/tencent/ttpic/filament/ARManager;
    //   35: invokevirtual 1368	com/tencent/ttpic/filament/ARManager:isArTracked	()Z
    //   38: ifne -9 -> 29
    //   41: aload_1
    //   42: getfield 475	com/tencent/aekit/openrender/internal/Frame:width	I
    //   45: istore 6
    //   47: aload_1
    //   48: getfield 476	com/tencent/aekit/openrender/internal/Frame:height	I
    //   51: istore 5
    //   53: aload_3
    //   54: invokevirtual 1370	com/tencent/ttpic/openapi/PTFaceAttr:getRotation	()I
    //   57: istore 4
    //   59: iconst_1
    //   60: istore 7
    //   62: aload_0
    //   63: getfield 213	com/tencent/ttpic/filament/FilamentFilter:arManager	Lcom/tencent/ttpic/filament/ARManager;
    //   66: invokevirtual 1009	com/tencent/ttpic/filament/ARManager:isAR3DMaterial	()Z
    //   69: ifeq +25 -> 94
    //   72: invokestatic 661	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   75: invokestatic 1374	com/tencent/ttpic/baseutils/device/DeviceUtils:getScreenWidth	(Landroid/content/Context;)I
    //   78: istore 6
    //   80: invokestatic 661	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   83: invokestatic 1377	com/tencent/ttpic/baseutils/device/DeviceUtils:getScreenHeight	(Landroid/content/Context;)I
    //   86: istore 5
    //   88: iconst_0
    //   89: istore 4
    //   91: iconst_0
    //   92: istore 7
    //   94: aload_0
    //   95: iload 6
    //   97: iload 5
    //   99: iload 4
    //   101: iload 7
    //   103: invokespecial 1379	com/tencent/ttpic/filament/FilamentFilter:resize	(IIIZ)V
    //   106: aload_0
    //   107: getfield 213	com/tencent/ttpic/filament/FilamentFilter:arManager	Lcom/tencent/ttpic/filament/ARManager;
    //   110: invokevirtual 1009	com/tencent/ttpic/filament/ARManager:isAR3DMaterial	()Z
    //   113: ifeq +11 -> 124
    //   116: aload_0
    //   117: getfield 213	com/tencent/ttpic/filament/FilamentFilter:arManager	Lcom/tencent/ttpic/filament/ARManager;
    //   120: aload_3
    //   121: invokevirtual 1383	com/tencent/ttpic/filament/ARManager:getCurDeviceOrientation	(Lcom/tencent/ttpic/openapi/PTFaceAttr;)V
    //   124: aload_0
    //   125: aload_2
    //   126: aload_3
    //   127: aload_1
    //   128: invokespecial 1385	com/tencent/ttpic/filament/FilamentFilter:updateParams	(Lcom/tencent/aekit/plugin/core/AIAttr;Lcom/tencent/ttpic/openapi/PTFaceAttr;Lcom/tencent/aekit/openrender/internal/Frame;)V
    //   131: ldc_w 1359
    //   134: invokestatic 1386	com/tencent/ttpic/baseutils/fps/BenchUtil:benchEnd	(Ljava/lang/String;)J
    //   137: pop2
    //   138: getstatic 1315	com/tencent/ttpic/filament/FilamentUtil$BenchTag:FIRST_RENDER	Lcom/tencent/ttpic/filament/FilamentUtil$BenchTag;
    //   141: getfield 493	com/tencent/ttpic/filament/FilamentUtil$BenchTag:tag	Ljava/lang/String;
    //   144: invokestatic 521	com/tencent/ttpic/filament/FilaBenchUtil:benchEnd	(Ljava/lang/String;)J
    //   147: lstore 8
    //   149: aload_0
    //   150: getfield 952	com/tencent/ttpic/filament/FilamentFilter:needRender	Z
    //   153: ifne +10 -> 163
    //   156: aload_0
    //   157: iconst_0
    //   158: putfield 1388	com/tencent/ttpic/filament/FilamentFilter:skipFrame	I
    //   161: aload_1
    //   162: areturn
    //   163: getstatic 99	com/tencent/ttpic/filament/FilamentFilter:TAG	Ljava/lang/String;
    //   166: ldc_w 1390
    //   169: invokestatic 1114	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: getstatic 1393	com/tencent/ttpic/filament/FilamentUtil$BenchTag:FIRST_FRAME	Lcom/tencent/ttpic/filament/FilamentUtil$BenchTag;
    //   175: getfield 493	com/tencent/ttpic/filament/FilamentUtil$BenchTag:tag	Ljava/lang/String;
    //   178: invokestatic 498	com/tencent/ttpic/filament/FilaBenchUtil:benchStart	(Ljava/lang/String;)V
    //   181: aconst_null
    //   182: astore_3
    //   183: aconst_null
    //   184: astore 12
    //   186: aconst_null
    //   187: astore_2
    //   188: aload_0
    //   189: getfield 176	com/tencent/ttpic/filament/FilamentFilter:material	Lcom/tencent/ttpic/openapi/model/VideoMaterial;
    //   192: invokevirtual 586	com/tencent/ttpic/openapi/model/VideoMaterial:isKapuMaterial	()Z
    //   195: ifeq +228 -> 423
    //   198: aload_0
    //   199: getfield 176	com/tencent/ttpic/filament/FilamentFilter:material	Lcom/tencent/ttpic/openapi/model/VideoMaterial;
    //   202: invokevirtual 993	com/tencent/ttpic/openapi/model/VideoMaterial:getKapuMaterialType	()I
    //   205: ifne +218 -> 423
    //   208: lload 8
    //   210: lconst_0
    //   211: lcmp
    //   212: ifgt +211 -> 423
    //   215: aload_0
    //   216: getfield 150	com/tencent/ttpic/filament/FilamentFilter:drawQueue	Ljava/util/concurrent/LinkedBlockingDeque;
    //   219: invokevirtual 1394	java/util/concurrent/LinkedBlockingDeque:size	()I
    //   222: ifle +59 -> 281
    //   225: ldc_w 1396
    //   228: invokestatic 1362	com/tencent/ttpic/baseutils/fps/BenchUtil:benchStart	(Ljava/lang/String;)V
    //   231: aload_0
    //   232: getfield 150	com/tencent/ttpic/filament/FilamentFilter:drawQueue	Ljava/util/concurrent/LinkedBlockingDeque;
    //   235: invokevirtual 1399	java/util/concurrent/LinkedBlockingDeque:take	()Ljava/lang/Object;
    //   238: checkcast 1401	java/lang/Runnable
    //   241: astore_2
    //   242: getstatic 99	com/tencent/ttpic/filament/FilamentFilter:TAG	Ljava/lang/String;
    //   245: new 629	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 630	java/lang/StringBuilder:<init>	()V
    //   252: ldc_w 1403
    //   255: invokevirtual 645	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_0
    //   259: getfield 150	com/tencent/ttpic/filament/FilamentFilter:drawQueue	Ljava/util/concurrent/LinkedBlockingDeque;
    //   262: invokevirtual 1394	java/util/concurrent/LinkedBlockingDeque:size	()I
    //   265: invokevirtual 1406	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: invokevirtual 653	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 1114	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: ldc_w 1396
    //   277: invokestatic 1386	com/tencent/ttpic/baseutils/fps/BenchUtil:benchEnd	(Ljava/lang/String;)J
    //   280: pop2
    //   281: aload_2
    //   282: ifnull +22 -> 304
    //   285: ldc_w 1408
    //   288: invokestatic 1362	com/tencent/ttpic/baseutils/fps/BenchUtil:benchStart	(Ljava/lang/String;)V
    //   291: aload_2
    //   292: invokeinterface 1411 1 0
    //   297: ldc_w 1408
    //   300: invokestatic 1386	com/tencent/ttpic/baseutils/fps/BenchUtil:benchEnd	(Ljava/lang/String;)J
    //   303: pop2
    //   304: getstatic 1393	com/tencent/ttpic/filament/FilamentUtil$BenchTag:FIRST_FRAME	Lcom/tencent/ttpic/filament/FilamentUtil$BenchTag;
    //   307: getfield 493	com/tencent/ttpic/filament/FilamentUtil$BenchTag:tag	Ljava/lang/String;
    //   310: invokestatic 521	com/tencent/ttpic/filament/FilaBenchUtil:benchEnd	(Ljava/lang/String;)J
    //   313: lstore 10
    //   315: lload 8
    //   317: lconst_0
    //   318: lcmp
    //   319: ifle +58 -> 377
    //   322: getstatic 99	com/tencent/ttpic/filament/FilamentFilter:TAG	Ljava/lang/String;
    //   325: new 629	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 630	java/lang/StringBuilder:<init>	()V
    //   332: ldc_w 1413
    //   335: invokevirtual 645	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: lload 10
    //   340: invokevirtual 1416	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   343: ldc_w 1418
    //   346: invokevirtual 645	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 653	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 1423	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   355: pop
    //   356: aload_0
    //   357: getfield 1425	com/tencent/ttpic/filament/FilamentFilter:onLoadFinishListener	Lcom/tencent/ttpic/openapi/listener/MaterialLoadFinishListener;
    //   360: ifnull +17 -> 377
    //   363: aload_0
    //   364: getfield 1425	com/tencent/ttpic/filament/FilamentFilter:onLoadFinishListener	Lcom/tencent/ttpic/openapi/listener/MaterialLoadFinishListener;
    //   367: lload 10
    //   369: lload 8
    //   371: ladd
    //   372: invokeinterface 1430 3 0
    //   377: aload_0
    //   378: getfield 172	com/tencent/ttpic/filament/FilamentFilter:loaderList	Ljava/util/ArrayList;
    //   381: invokevirtual 1001	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   384: astore_2
    //   385: aload_2
    //   386: invokeinterface 224 1 0
    //   391: ifeq +70 -> 461
    //   394: aload_2
    //   395: invokeinterface 228 1 0
    //   400: checkcast 527	com/tencent/ttpic/filament/CMShowUserLoader
    //   403: invokevirtual 1433	com/tencent/ttpic/filament/CMShowUserLoader:firstRenderEnd	()V
    //   406: goto -21 -> 385
    //   409: astore 12
    //   411: aload_3
    //   412: astore_2
    //   413: aload 12
    //   415: astore_3
    //   416: aload_3
    //   417: invokevirtual 1436	java/lang/InterruptedException:printStackTrace	()V
    //   420: goto -139 -> 281
    //   423: ldc_w 1396
    //   426: invokestatic 1362	com/tencent/ttpic/baseutils/fps/BenchUtil:benchStart	(Ljava/lang/String;)V
    //   429: aload_0
    //   430: getfield 150	com/tencent/ttpic/filament/FilamentFilter:drawQueue	Ljava/util/concurrent/LinkedBlockingDeque;
    //   433: invokevirtual 1399	java/util/concurrent/LinkedBlockingDeque:take	()Ljava/lang/Object;
    //   436: checkcast 1401	java/lang/Runnable
    //   439: astore_2
    //   440: ldc_w 1396
    //   443: invokestatic 1386	com/tencent/ttpic/baseutils/fps/BenchUtil:benchEnd	(Ljava/lang/String;)J
    //   446: pop2
    //   447: goto -166 -> 281
    //   450: astore_3
    //   451: aload 12
    //   453: astore_2
    //   454: aload_3
    //   455: invokevirtual 1436	java/lang/InterruptedException:printStackTrace	()V
    //   458: goto -177 -> 281
    //   461: getstatic 1318	com/tencent/ttpic/filament/FilamentUtil$BenchTag:AFTER_RENDER	Lcom/tencent/ttpic/filament/FilamentUtil$BenchTag;
    //   464: getfield 493	com/tencent/ttpic/filament/FilamentUtil$BenchTag:tag	Ljava/lang/String;
    //   467: invokestatic 521	com/tencent/ttpic/filament/FilaBenchUtil:benchEnd	(Ljava/lang/String;)J
    //   470: pop2
    //   471: invokestatic 1439	com/tencent/ttpic/filament/FilaBenchUtil:reset	()V
    //   474: aload_0
    //   475: getfield 1388	com/tencent/ttpic/filament/FilamentFilter:skipFrame	I
    //   478: iconst_1
    //   479: if_icmpge +15 -> 494
    //   482: aload_0
    //   483: aload_0
    //   484: getfield 1388	com/tencent/ttpic/filament/FilamentFilter:skipFrame	I
    //   487: iconst_1
    //   488: iadd
    //   489: putfield 1388	com/tencent/ttpic/filament/FilamentFilter:skipFrame	I
    //   492: aload_1
    //   493: areturn
    //   494: iconst_1
    //   495: invokestatic 1442	com/tencent/aekit/openrender/util/GlUtil:setBlendMode	(Z)V
    //   498: aload_0
    //   499: getfield 131	com/tencent/ttpic/filament/FilamentFilter:mCopyFilter	Lcom/tencent/filter/BaseFilter;
    //   502: aload_0
    //   503: getfield 136	com/tencent/ttpic/filament/FilamentFilter:filamentFrame	Lcom/tencent/aekit/openrender/internal/Frame;
    //   506: invokevirtual 876	com/tencent/aekit/openrender/internal/Frame:getTextureId	()I
    //   509: aload_1
    //   510: getfield 475	com/tencent/aekit/openrender/internal/Frame:width	I
    //   513: aload_1
    //   514: getfield 476	com/tencent/aekit/openrender/internal/Frame:height	I
    //   517: iconst_m1
    //   518: dconst_0
    //   519: aload_1
    //   520: invokevirtual 888	com/tencent/filter/BaseFilter:RenderProcess	(IIIIDLcom/tencent/aekit/openrender/internal/Frame;)V
    //   523: iconst_0
    //   524: invokestatic 1442	com/tencent/aekit/openrender/util/GlUtil:setBlendMode	(Z)V
    //   527: aload_1
    //   528: areturn
    //   529: astore_3
    //   530: goto -76 -> 454
    //   533: astore_3
    //   534: goto -118 -> 416
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	537	0	this	FilamentFilter
    //   0	537	1	paramFrame	Frame
    //   0	537	2	paramAIAttr	AIAttr
    //   0	537	3	paramPTFaceAttr	PTFaceAttr
    //   57	43	4	i	int
    //   51	47	5	j	int
    //   45	51	6	k	int
    //   60	42	7	bool	boolean
    //   147	223	8	l1	long
    //   313	55	10	l2	long
    //   184	1	12	localObject	Object
    //   409	43	12	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   225	242	409	java/lang/InterruptedException
    //   423	440	450	java/lang/InterruptedException
    //   440	447	529	java/lang/InterruptedException
    //   242	281	533	java/lang/InterruptedException
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
    StringBuilder localStringBuilder = new StringBuilder().append("FilamentFilter|setFilamentAssetRotate:");
    Object localObject;
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length == 3))
    {
      localObject = Float.valueOf(paramArrayOfFloat[1]);
      LogUtils.i("3D_ROTATE", localObject);
      if (this.filamentJNI != null) {
        break label62;
      }
    }
    label62:
    label74:
    do
    {
      return;
      localObject = "NONE";
      break;
      if (this.material.getIsAR3DMaterial())
      {
        int i = 0;
        if (i < this.glbList.size())
        {
          localStringBuilder = new StringBuilder().append("FilamentFilter|setFilamentAssetRotate|filamentJNI.setFilamentAssetRotate:").append(i).append("||");
          if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length != 3)) {
            break label160;
          }
        }
        for (localObject = Float.valueOf(paramArrayOfFloat[1]);; localObject = "NONE")
        {
          LogUtils.i("3D_ROTATE", localObject);
          this.filamentJNI.setFilamentAssetRotate(i, paramArrayOfFloat);
          i += 1;
          break label74;
          break;
        }
      }
    } while (!this.material.isKapuMaterial());
    label160:
    this.filamentJNI.setAssetRotate(paramArrayOfFloat);
  }
  
  public void setFilamentAssetScale(float paramFloat)
  {
    if (this.arManager != null) {
      this.arManager.setArModelScale(paramFloat);
    }
  }
  
  public void setKapuMaterialDisplayType(CmShowMaterialDisplayType paramCmShowMaterialDisplayType)
  {
    int i = 0;
    this.showMaterialDisplayType = paramCmShowMaterialDisplayType;
    if (((this.material.getIsAR3DMaterial()) || (this.material.isKapuMaterial())) && (this.filamentJNI != null))
    {
      ArrayList localArrayList = new ArrayList();
      switch (FilamentFilter.4.$SwitchMap$com$tencent$ttpic$filament$CmShowMaterialDisplayType[paramCmShowMaterialDisplayType.ordinal()])
      {
      }
      for (;;)
      {
        paramCmShowMaterialDisplayType = (String[])localArrayList.toArray(new String[0]);
        while (i < this.glbList.size())
        {
          this.filamentJNI.setKapuDisplayMaterialTypeList(i, paramCmShowMaterialDisplayType);
          i += 1;
        }
        localArrayList.add("tops");
        localArrayList.add("eyelash");
        localArrayList.add("eyebrow");
        localArrayList.add("pants");
        localArrayList.add("shoes");
        localArrayList.add("stocking");
        localArrayList.add("eyes");
        localArrayList.add("role");
        localArrayList.add("hair");
        localArrayList.add("eyeglasses");
        localArrayList.add("wing");
        localArrayList.add("headDress");
        localArrayList.add("wing");
        localArrayList.add("nose");
        localArrayList.add("mouth");
        continue;
        localArrayList.add("eyelash");
        localArrayList.add("eyebrow");
        localArrayList.add("eyes");
        localArrayList.add("role");
        localArrayList.add("hair");
        localArrayList.add("eyeglasses");
        localArrayList.add("headDress");
        localArrayList.add("nose");
        localArrayList.add("mouth");
      }
    }
  }
  
  public void setKapuModelView(KapuModelViewParam paramKapuModelViewParam)
  {
    this.viewParam = paramKapuModelViewParam;
    if ((this.filamentJNI != null) && (this.modelLoadSucceed) && (this.material.isKapuMaterial()) && (paramKapuModelViewParam.viewSize != null) && (paramKapuModelViewParam.boundingBox != null))
    {
      int i = 0;
      while (i < this.loaderList.size())
      {
        this.filamentJNI.adjustKapuModelView(i, paramKapuModelViewParam.viewSize, paramKapuModelViewParam.boundingBox, paramKapuModelViewParam.bottomMargin);
        i += 1;
      }
    }
  }
  
  public void setLoaders(ArrayList<CMShowUserLoader> paramArrayList)
  {
    this.loaderList = paramArrayList;
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
  
  public void switchCameraViewType(CameraViewType paramCameraViewType)
  {
    int k = 0;
    int j = 0;
    Object localObject;
    if (((this.material.getIsAR3DMaterial()) || (this.material.isKapuMaterial())) && (this.filamentJNI != null))
    {
      localObject = this.material.getCameraViewConfig();
      if (localObject != null) {
        switch (FilamentFilter.4.$SwitchMap$com$tencent$ttpic$filament$CameraViewType[paramCameraViewType.ordinal()])
        {
        }
      }
    }
    for (;;)
    {
      return;
      int i = 0;
      List localList;
      float[] arrayOfFloat;
      while (i < ((List)localObject).size())
      {
        paramCameraViewType = (CameraViewConfig)((List)localObject).get(i);
        if (paramCameraViewType.getCameraViewType() == CameraViewType.Body.value)
        {
          localList = paramCameraViewType.getCameraPosition();
          localObject = new float[localList.size()];
          i = 0;
          while (i < localList.size())
          {
            localObject[i] = ((Float)localList.get(i)).floatValue();
            i += 1;
          }
          localList = paramCameraViewType.getCameraRotation();
          arrayOfFloat = new float[localList.size()];
          i = j;
          while (i < localList.size())
          {
            arrayOfFloat[i] = ((Float)localList.get(i)).floatValue();
            i += 1;
          }
          this.filamentJNI.setCameraAnimation((float[])localObject, arrayOfFloat, paramCameraViewType.getAnimationTime(), paramCameraViewType.getAnimationType());
          return;
        }
        i += 1;
      }
      continue;
      i = 0;
      while (i < ((List)localObject).size())
      {
        paramCameraViewType = (CameraViewConfig)((List)localObject).get(i);
        if (paramCameraViewType.getCameraViewType() == CameraViewType.Head.value)
        {
          localList = paramCameraViewType.getCameraPosition();
          localObject = new float[localList.size()];
          i = 0;
          while (i < localList.size())
          {
            localObject[i] = ((Float)localList.get(i)).floatValue();
            i += 1;
          }
          localList = paramCameraViewType.getCameraRotation();
          arrayOfFloat = new float[localList.size()];
          i = k;
          while (i < localList.size())
          {
            arrayOfFloat[i] = ((Float)localList.get(i)).floatValue();
            i += 1;
          }
          this.filamentJNI.setCameraAnimation((float[])localObject, arrayOfFloat, paramCameraViewType.getAnimationTime(), paramCameraViewType.getAnimationType());
          return;
        }
        i += 1;
      }
    }
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((this.filamentJNI == null) || (this.material.isKapuMaterial())) {}
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