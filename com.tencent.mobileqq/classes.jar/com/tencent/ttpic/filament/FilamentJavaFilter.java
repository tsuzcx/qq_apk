package com.tencent.ttpic.filament;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.google.android.filament.Box;
import com.google.android.filament.Camera;
import com.google.android.filament.Camera.Fov;
import com.google.android.filament.DynamicBoneManager;
import com.google.android.filament.Engine;
import com.google.android.filament.Entity;
import com.google.android.filament.EntityInstance;
import com.google.android.filament.EntityManager;
import com.google.android.filament.Fence;
import com.google.android.filament.Fence.Mode;
import com.google.android.filament.IndexBuffer;
import com.google.android.filament.IndexBuffer.Builder;
import com.google.android.filament.IndexBuffer.Builder.IndexType;
import com.google.android.filament.IndirectLight;
import com.google.android.filament.LightManager;
import com.google.android.filament.LightManager.Builder;
import com.google.android.filament.LightManager.Type;
import com.google.android.filament.Material;
import com.google.android.filament.MaterialInstance;
import com.google.android.filament.RenderableManager;
import com.google.android.filament.RenderableManager.PrimitiveType;
import com.google.android.filament.Renderer;
import com.google.android.filament.Scene;
import com.google.android.filament.SwapChain;
import com.google.android.filament.TransformManager;
import com.google.android.filament.VertexBuffer;
import com.google.android.filament.VertexBuffer.AttributeType;
import com.google.android.filament.VertexBuffer.Builder;
import com.google.android.filament.VertexBuffer.VertexAttribute;
import com.google.android.filament.View;
import com.google.android.filament.View.AmbientOcclusion;
import com.google.android.filament.View.AntiAliasing;
import com.google.android.filament.View.DepthPrepass;
import com.google.android.filament.View.Dithering;
import com.google.android.filament.Viewport;
import com.google.android.filament.gltfio.Animator;
import com.google.android.filament.gltfio.AssetLoader;
import com.google.android.filament.gltfio.FilamentAsset;
import com.google.android.filament.gltfio.MaterialProvider;
import com.google.android.filament.gltfio.ResourceLoader;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIActionCounter;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.gameplaysdk.model.Range;
import com.tencent.ttpic.openapi.PTDetectInfo.Builder;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.initializer.FilamentInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.AnimojiExpressionJava;
import com.tencent.ttpic.openapi.model.DynamicBoneItem;
import com.tencent.ttpic.openapi.model.EyeNodeItem;
import com.tencent.ttpic.openapi.model.GLBItemJava;
import com.tencent.ttpic.openapi.model.LightItem;
import com.tencent.ttpic.openapi.model.NodeItemJava;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.HandlerUtil;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import org.jetbrains.annotations.NotNull;

public class FilamentJavaFilter
{
  private final String TAG = getClass().getSimpleName();
  private List<Animator> animatorList = new ArrayList();
  private AssetLoader assetLoader;
  private List<DynamicBoneItem> boneItemList = new ArrayList();
  private List<Camera> cameraList = new ArrayList();
  private Frame curInputFrame = new Frame();
  private String dataPath;
  private LinkedBlockingDeque<Runnable> drawQueue = new LinkedBlockingDeque();
  private Engine engine;
  private FilamentAsset filamentAssetHead;
  private List<FilamentAsset> filamentAssetList = new ArrayList();
  private Frame filamentFrame = new Frame();
  private final boolean flattenEar;
  private final boolean flattenNose;
  private double fov;
  private Map<GLBItemJava, byte[]> glbBytesMap = new HashMap();
  private List<GLBItemJava> glbList;
  @EntityInstance
  private int head;
  private Camera headCamera;
  private Material headMaterial;
  private List<Float> headMeshOriginPoints = new ArrayList();
  private List<Integer> headMeshPointIndex = new ArrayList();
  @EntityInstance
  private int headRoot;
  private Scene headScene;
  private View headView;
  private int height = 1280;
  private boolean hideUserHeadModel;
  private IndexBuffer indexBuffer;
  private IndirectLight indirectLight = null;
  private boolean isAnimoji;
  private List<float[]> itemPosition = new ArrayList();
  private List<float[]> itemRotate = new ArrayList();
  private List<float[]> itemScale = new ArrayList();
  private final HashMap<String, Float> jawOpenThresholdMap = new HashMap();
  private Frame lastInputFrame = new Frame();
  @Entity
  private List<Integer> lightList = new ArrayList();
  private LightManager lm;
  private CountDownLatch lock;
  private BaseFilter mCopyFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
  private Handler mHandler;
  private SurfaceTextureFilter mPreviewFilter = new SurfaceTextureFilter();
  private int[] mPreviewTextureId = new int[2];
  private List<DynamicBoneManager> managerList = new ArrayList();
  private int maxHeadCount = 10;
  private boolean modelLoadSuccess;
  private volatile boolean modelReady;
  private boolean needEye = false;
  private boolean needRender;
  private Map<EyeNodeItem, MatrixInfo> nodeTransInfo = new HashMap();
  private List<float[]> oldAngleList = new ArrayList();
  private List<float[]> oldExpression = new ArrayList();
  private List<float[]> oldTranslateList = new ArrayList();
  private List<Integer> renderableList = new ArrayList();
  private Renderer renderer;
  private RenderableManager rm;
  private int rotation = 0;
  private int skipFrame;
  private Surface surface;
  private SurfaceTexture surfaceTexture;
  private SwapChain swapChain;
  private TransformManager tm;
  private float transformAdjustAlpha;
  private VertexBuffer vertexBuffer;
  private List<View> viewList = new ArrayList();
  private int width = 590;
  
  public FilamentJavaFilter(VideoMaterial paramVideoMaterial)
  {
    this.glbList = paramVideoMaterial.getGlbList();
    updateJawOpenThreshold(this.glbList);
    this.isAnimoji = VideoMaterialUtil.isFilamentAnimojiMaterial(paramVideoMaterial);
    this.flattenNose = paramVideoMaterial.isFlattenNose();
    this.flattenEar = paramVideoMaterial.isFlattenEar();
    this.hideUserHeadModel = paramVideoMaterial.isHideUserHeadModel();
    this.transformAdjustAlpha = paramVideoMaterial.getTransformAdjustAlpha();
    this.fov = paramVideoMaterial.getFov();
    this.dataPath = paramVideoMaterial.getDataPath();
    paramVideoMaterial = new HandlerThread("HTM_Fila");
    paramVideoMaterial.start();
    this.mHandler = new Handler(paramVideoMaterial.getLooper());
    paramVideoMaterial = this.glbList.iterator();
    while (paramVideoMaterial.hasNext()) {
      if (!((GLBItemJava)paramVideoMaterial.next()).eyeNodeList.isEmpty()) {
        this.needEye = true;
      }
    }
  }
  
  private void loadModel(GLBItemJava paramGLBItemJava, Scene paramScene, byte[] paramArrayOfByte)
  {
    LogUtils.d(this.TAG, "loadModel - glbModePath");
    paramArrayOfByte = this.assetLoader.createAssetFromBinary(ByteBuffer.wrap(paramArrayOfByte));
    if (paramArrayOfByte == null) {}
    do
    {
      return;
      try
      {
        new ResourceLoader(this.engine).loadResources(paramArrayOfByte).destroy();
        Animator localAnimator = paramArrayOfByte.getAnimator();
        paramScene.addEntities(paramArrayOfByte.getEntities());
        i = this.tm.getInstance(paramArrayOfByte.getRoot());
        LogUtils.d(this.TAG, "test for filament size: " + Arrays.toString(paramArrayOfByte.getBoundingBox().getHalfExtent()) + " number: " + paramArrayOfByte.getEntities().length);
        Iterator localIterator1 = paramGLBItemJava.dynamicBoneItems.iterator();
        while (localIterator1.hasNext())
        {
          DynamicBoneItem localDynamicBoneItem = (DynamicBoneItem)localIterator1.next();
          Iterator localIterator2 = localDynamicBoneItem.rootNames.iterator();
          while (localIterator2.hasNext())
          {
            String str = (String)localIterator2.next();
            localDynamicBoneItem.entities.add(Integer.valueOf(paramArrayOfByte.getEntity(str)));
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          LogUtils.e(localException);
        }
        this.boneItemList.addAll(paramGLBItemJava.dynamicBoneItems);
        this.animatorList.add(localException);
        this.filamentAssetList.add(paramArrayOfByte);
        this.renderableList.add(Integer.valueOf(i));
        if (paramGLBItemJava.lightItem != null)
        {
          i = EntityManager.get().create();
          new LightManager.Builder(LightManager.Type.DIRECTIONAL).color(paramGLBItemJava.lightItem.color[0], paramGLBItemJava.lightItem.color[1], paramGLBItemJava.lightItem.color[2]).intensity(paramGLBItemJava.lightItem.intensity).direction(paramGLBItemJava.lightItem.direction[0], paramGLBItemJava.lightItem.direction[1], paramGLBItemJava.lightItem.direction[2]).castShadows(paramGLBItemJava.lightItem.castShadow).build(this.engine, i);
          paramScene.addEntity(i);
          this.lightList.add(Integer.valueOf(i));
        }
      }
    } while (!this.lightList.isEmpty());
    int i = EntityManager.get().create();
    new LightManager.Builder(LightManager.Type.DIRECTIONAL).color(1.0F, 1.0F, 1.0F).intensity(0.0F).direction(0.0F, 0.0F, -1.0F).castShadows(false).build(this.engine, i);
    paramScene.addEntity(i);
    this.lightList.add(Integer.valueOf(i));
  }
  
  private byte[] openGlbFile(GLBItemJava paramGLBItemJava)
  {
    if (!TextUtils.isEmpty(paramGLBItemJava.path))
    {
      this.itemScale.add(paramGLBItemJava.scale);
      this.itemPosition.add(paramGLBItemJava.translate);
      this.itemRotate.add(paramGLBItemJava.rotate);
      return FilamentJavaUtil.decryptGlb(paramGLBItemJava.path);
    }
    return null;
  }
  
  private void resize(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.width == paramInt1) && (this.height == paramInt2) && (this.rotation == paramInt3)) {
      return;
    }
    this.rotation = paramInt3;
    this.width = paramInt1;
    this.height = paramInt2;
    float f = Math.min(paramInt1 / FilamentJavaUtil.getProcessWidth(), 1.0F);
    int i = (int)(paramInt1 * f);
    paramInt1 = (int)(f * paramInt2);
    if ((paramInt3 == 90) || (paramInt3 == 270))
    {
      paramInt3 = i + paramInt1;
      paramInt2 = paramInt3 - paramInt1;
      paramInt1 = paramInt2;
    }
    for (paramInt2 = paramInt3 - paramInt2;; paramInt2 = i)
    {
      double d = paramInt2 / paramInt1;
      paramInt3 = 0;
      while (paramInt3 < this.viewList.size())
      {
        ((Camera)this.cameraList.get(paramInt3)).setProjection(this.fov, d, 0.1D, 100.0D, Camera.Fov.VERTICAL);
        ((View)this.viewList.get(paramInt3)).setViewport(new Viewport(0, 0, paramInt2, paramInt1));
        paramInt3 += 1;
      }
      this.headCamera.setProjection(this.fov, d, 0.1D, 100.0D, Camera.Fov.VERTICAL);
      this.headView.setViewport(new Viewport(0, 0, paramInt2, paramInt1));
      this.surfaceTexture.setDefaultBufferSize(paramInt2, paramInt1);
      return;
    }
  }
  
  private void setupFilament(Context paramContext)
  {
    this.engine = Engine.create();
    this.renderer = this.engine.createRenderer();
    this.tm = this.engine.getTransformManager();
    this.rm = this.engine.getRenderableManager();
    this.lm = this.engine.getLightManager();
    this.assetLoader = new AssetLoader(this.engine, new MaterialProvider(this.engine), EntityManager.get());
    this.surface = new Surface(this.surfaceTexture);
    if (this.swapChain != null) {
      this.engine.destroySwapChain(this.swapChain);
    }
    this.swapChain = this.engine.createSwapChain(this.surface, 1L);
    this.surfaceTexture.setOnFrameAvailableListener(new FilamentJavaFilter.2(this));
    setupHead(paramContext);
    this.mHandler.post(new FilamentJavaFilter.3(this));
  }
  
  private void setupHead(Context paramContext)
  {
    this.headScene = this.engine.createScene();
    this.headView = this.engine.createView();
    Object localObject3 = this.headView;
    Object localObject1;
    if (((GLBItemJava)this.glbList.get(0)).enableSSAO == 0) {
      localObject1 = View.AmbientOcclusion.NONE;
    }
    for (;;)
    {
      ((View)localObject3).setAmbientOcclusion((View.AmbientOcclusion)localObject1);
      this.headView.setAntiAliasing(View.AntiAliasing.FXAA);
      this.headView.setDithering(View.Dithering.TEMPORAL);
      this.headView.setDepthPrepass(View.DepthPrepass.ENABLED);
      this.headView.setSampleCount(4);
      this.headCamera = this.engine.createCamera();
      this.headView.setClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      this.headView.setCamera(this.headCamera);
      this.headView.setScene(this.headScene);
      this.headView.setVisibleLayers(255, 1);
      double d = this.width / this.height;
      this.headCamera.setProjection(this.fov, d, 0.1D, 100.0D, Camera.Fov.VERTICAL);
      this.headView.setViewport(new Viewport(0, 0, this.width, this.height));
      this.headMaterial = FilamentJavaUtil.loadMaterial(paramContext, this.engine, FeatureManager.Features.FILAMENT.getHeadFilamentPath());
      if (this.headMaterial == null) {
        this.hideUserHeadModel = true;
      }
      this.filamentAssetHead = this.assetLoader.createAssetFromBinary(ByteBuffer.wrap(FileUtils.loadByteArray(paramContext, FeatureManager.Features.FILAMENT.getHeadGlbPath())));
      try
      {
        new ResourceLoader(this.engine).loadResources(this.filamentAssetHead).destroy();
        this.headScene.addEntities(this.filamentAssetHead.getEntities());
        this.headRoot = this.tm.getInstance(this.filamentAssetHead.getRoot());
        localObject1 = this.filamentAssetHead.getEntities();
        int k = localObject1.length;
        i = 0;
        if (i < k)
        {
          j = localObject1[i];
          int m = this.rm.getInstance(j);
          int n = this.rm.getPrimitiveCount(m);
          j = 0;
          while (j < n)
          {
            this.head = m;
            if (this.headMaterial != null)
            {
              localObject3 = this.headMaterial.getDefaultInstance();
              this.rm.setMaterialInstanceAt(m, j, (MaterialInstance)localObject3);
            }
            j += 1;
            continue;
            localObject1 = View.AmbientOcclusion.SSAO;
          }
        }
      }
      catch (Exception localException)
      {
        int j;
        for (;;)
        {
          LogUtils.e(localException);
          continue;
          i += 1;
        }
        Object localObject2 = FileUtils.loadByteArray(paramContext, FeatureManager.Features.FILAMENT.getVertextxtPath());
        if (localObject2 != null)
        {
          localObject2 = new String((byte[])localObject2).split(",");
          j = localObject2.length;
          i = 0;
          while (i < j)
          {
            localObject3 = localObject2[i];
            this.headMeshOriginPoints.add(Float.valueOf(Float.parseFloat((String)localObject3)));
            i += 1;
          }
        }
        int i = 0;
        while (i < 1000)
        {
          this.headMeshOriginPoints.add(Float.valueOf(0.0F));
          i += 1;
        }
        localObject3 = this.dataPath + File.separator + "index.txt";
        localObject2 = localObject3;
        if (!new File((String)localObject3).exists()) {
          localObject2 = FeatureManager.Features.FILAMENT.getIndexTxtPath();
        }
        paramContext = FileUtils.loadByteArray(paramContext, (String)localObject2);
        if (paramContext != null)
        {
          paramContext = new String(paramContext).split(", ");
          j = paramContext.length;
          i = 0;
          while (i < j)
          {
            localObject2 = paramContext[i];
            this.headMeshPointIndex.add(Integer.valueOf(Integer.parseInt((String)localObject2)));
            i += 1;
          }
        }
        i = 0;
        while (i < 5925)
        {
          this.headMeshPointIndex.add(Integer.valueOf(0));
          i += 1;
        }
        this.vertexBuffer = new VertexBuffer.Builder().bufferCount(1).vertexCount(1000).attribute(VertexBuffer.VertexAttribute.POSITION, 0, VertexBuffer.AttributeType.FLOAT3, 0, 12).build(this.engine);
        paramContext = ByteBuffer.allocate(12000).order(ByteOrder.nativeOrder());
        localObject2 = this.headMeshOriginPoints.iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramContext.putFloat(((Float)((Iterator)localObject2).next()).floatValue());
        }
        this.vertexBuffer.setBufferAt(this.engine, 0, paramContext.flip());
        i = this.headMeshPointIndex.size();
        this.indexBuffer = new IndexBuffer.Builder().indexCount(i).bufferType(IndexBuffer.Builder.IndexType.UINT).build(this.engine);
        paramContext = ByteBuffer.allocate(i * 4).order(ByteOrder.nativeOrder());
        localObject2 = this.headMeshPointIndex.iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramContext.putInt(((Integer)((Iterator)localObject2).next()).intValue());
        }
        this.indexBuffer.setBuffer(this.engine, paramContext.flip());
        this.rm.setGeometryAt(this.head, 0, RenderableManager.PrimitiveType.TRIANGLES, this.vertexBuffer, this.indexBuffer);
      }
    }
  }
  
  private void setupItemInHead(GLBItemJava paramGLBItemJava, Context paramContext, byte[] paramArrayOfByte)
  {
    if ((!TextUtils.isEmpty(paramGLBItemJava.iblPath)) && (this.indirectLight == null))
    {
      this.indirectLight = FilamentJavaUtil.loadIndirectLight(paramContext, this.engine, paramGLBItemJava.iblPath, paramGLBItemJava.iblIntensity);
      this.headScene.setIndirectLight(this.indirectLight);
      double d = paramGLBItemJava.iblRotation * 3.141592653589793D / 180.0D;
      float f1 = (float)Math.cos(d);
      float f2 = (float)-Math.sin(d);
      float f3 = (float)Math.sin(d);
      float f4 = (float)Math.cos(d);
      this.indirectLight.setRotation(new float[] { f1, 0.0F, f2, 0.0F, 1.0F, 0.0F, f3, 0.0F, f4 });
    }
    loadModel(paramGLBItemJava, this.headScene, paramArrayOfByte);
  }
  
  private void updateActionTriggered(int paramInt, AIAttr paramAIAttr, PTFaceAttr paramPTFaceAttr)
  {
    BenchUtil.benchStart("[filament] updateActionTriggered 0");
    Object localObject1 = paramPTFaceAttr.getFaceActionCounter();
    Object localObject2 = AIActionCounter.getActions(AEDetectorType.HAND);
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    paramAIAttr = new PTDetectInfo.Builder().faceActionCounter((Map)localObject1).handActionCounter((Map)localObject2).triggeredExpression(localSet).aiAttr(paramAIAttr).faceDetector(paramPTFaceAttr.getFaceDetector()).timestamp(paramPTFaceAttr.getTimeStamp()).build();
    paramPTFaceAttr = this.engine.getRenderableManager();
    BenchUtil.benchEnd("[filament] updateActionTriggered 0");
    BenchUtil.benchStart("[filament] updateActionTriggered 1");
    localObject1 = ((GLBItemJava)this.glbList.get(paramInt)).nodeList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (NodeItemJava)((Iterator)localObject1).next();
      ((NodeItemJava)localObject2).updateActionTriggered(paramAIAttr);
      int i = paramPTFaceAttr.getInstance(((FilamentAsset)this.filamentAssetList.get(paramInt)).getEntity(((NodeItemJava)localObject2).name));
      if (((NodeItemJava)localObject2).getHide()) {
        paramPTFaceAttr.setLayerMask(i, 255, 4);
      } else {
        paramPTFaceAttr.setLayerMask(i, 255, 1);
      }
    }
    BenchUtil.benchEnd("[filament] updateActionTriggered 1");
  }
  
  private void updateGlbParams(int paramInt, float[] paramArrayOfFloat1, int[] paramArrayOfInt, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, AIAttr paramAIAttr, @NotNull PTFaceAttr paramPTFaceAttr)
  {
    BenchUtil.benchStart("[filament] updateGlbParams");
    BenchUtil.benchStart("[filament] updateGlbParams 0");
    updateActionTriggered(paramInt, paramAIAttr, paramPTFaceAttr);
    paramPTFaceAttr = new float[3];
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[i] == 1) {
        paramPTFaceAttr[i] = paramArrayOfFloat1[i];
      }
      i += 1;
    }
    BenchUtil.benchEnd("[filament] updateGlbParams 0");
    BenchUtil.benchStart("[filament] updateGlbParams 1");
    Iterator localIterator = ((GLBItemJava)this.glbList.get(paramInt)).eyeNodeList.iterator();
    while (localIterator.hasNext())
    {
      EyeNodeItem localEyeNodeItem = (EyeNodeItem)localIterator.next();
      i = ((FilamentAsset)this.filamentAssetList.get(paramInt)).getEntity(localEyeNodeItem.name);
      int j = this.tm.getInstance(i);
      if (i >= 0)
      {
        paramAIAttr = (MatrixInfo)this.nodeTransInfo.get(localEyeNodeItem);
        paramArrayOfInt = paramAIAttr;
        if (paramAIAttr == null)
        {
          paramArrayOfInt = new MatrixInfo();
          paramAIAttr = new float[16];
          this.tm.getTransform(j, paramAIAttr);
          float[] arrayOfFloat = new float[16];
          this.tm.getWorldTransform(j, arrayOfFloat);
          MatrixUtil.decompose(arrayOfFloat, paramArrayOfInt.worldTranslate, paramArrayOfInt.worldScale, paramArrayOfInt.worldRotate);
          MatrixUtil.decompose(paramAIAttr, paramArrayOfInt.originTranslate, paramArrayOfInt.originScale, paramArrayOfInt.originRotate);
          paramArrayOfInt.translateScaleMat = MatrixUtil.compose(paramArrayOfInt.originTranslate, paramArrayOfInt.originScale, MatrixUtil.ROTATE_IDENTITY);
          paramArrayOfInt.translateScaleMat = MatrixUtil.rotate(paramArrayOfInt.translateScaleMat, MatrixUtil.inverse(paramArrayOfInt.worldRotate));
          this.nodeTransInfo.put(localEyeNodeItem, paramArrayOfInt);
        }
        paramAIAttr = Arrays.copyOf(paramArrayOfInt.originRotate, paramArrayOfInt.originRotate.length);
        i = 0;
        while (i < paramArrayOfFloat5.length)
        {
          paramAIAttr[i] += paramArrayOfFloat5[i];
          i += 1;
        }
        paramArrayOfInt = MatrixUtil.rotate(MatrixUtil.rotate(Arrays.copyOf(paramArrayOfInt.translateScaleMat, paramArrayOfInt.translateScaleMat.length), paramAIAttr), paramArrayOfInt.worldRotate);
        this.tm.setTransform(j, paramArrayOfInt);
      }
    }
    paramArrayOfInt = FilamentJavaUtil.getTransformMatrix(paramPTFaceAttr, paramArrayOfFloat2, paramArrayOfFloat3, ((GLBItemJava)this.glbList.get(paramInt)).flip);
    float f = paramArrayOfInt[12];
    paramArrayOfInt[12] = (((float[])this.itemPosition.get(paramInt))[0] + f);
    f = paramArrayOfInt[13];
    paramArrayOfInt[13] = (((float[])this.itemPosition.get(paramInt))[1] + f);
    f = paramArrayOfInt[14];
    paramArrayOfInt[14] = (((float[])this.itemPosition.get(paramInt))[2] + f);
    Matrix.scaleM(paramArrayOfInt, 0, ((float[])this.itemScale.get(paramInt))[0], ((float[])this.itemScale.get(paramInt))[1], ((float[])this.itemScale.get(paramInt))[2]);
    paramArrayOfFloat2 = new float[16];
    MatrixUtil.setRotateEulerM(paramArrayOfFloat2, 0, ((float[])this.itemRotate.get(paramInt))[0], ((float[])this.itemRotate.get(paramInt))[1], ((float[])this.itemRotate.get(paramInt))[2]);
    paramArrayOfFloat3 = new float[16];
    Matrix.multiplyMM(paramArrayOfFloat3, 0, paramArrayOfInt, 0, paramArrayOfFloat2, 0);
    LogUtils.d(this.TAG, "test for filament render: test rotation 1: " + Arrays.toString(paramArrayOfFloat3));
    this.tm.setTransform(((Integer)this.renderableList.get(paramInt)).intValue(), paramArrayOfFloat3);
    BenchUtil.benchEnd("[filament] updateGlbParams 1");
    BenchUtil.benchStart("[filament] updateGlbParams 2");
    if (this.isAnimoji)
    {
      paramArrayOfInt = paramArrayOfFloat4;
      if (paramArrayOfFloat4 == null) {
        paramArrayOfInt = new float[52];
      }
      paramArrayOfFloat2 = ((GLBItemJava)this.glbList.get(paramInt)).nodeList.iterator();
      while (paramArrayOfFloat2.hasNext())
      {
        paramArrayOfFloat3 = (NodeItemJava)paramArrayOfFloat2.next();
        paramArrayOfFloat4 = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
        FilamentJavaUtil.adjustExpressionWeights(paramArrayOfFloat3.expressionConfigList, paramArrayOfFloat4, ((Float)this.jawOpenThresholdMap.get(paramArrayOfFloat3.name)).floatValue(), paramArrayOfFloat1);
        FilamentJavaUtil.setMorphWeights((FilamentAsset)this.filamentAssetList.get(paramInt), paramArrayOfFloat3, paramArrayOfFloat4);
      }
    }
    this.needRender = true;
    BenchUtil.benchEnd("[filament] updateGlbParams 2");
    BenchUtil.benchEnd("[filament] updateGlbParams");
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
  
  private void updateParams(AIAttr paramAIAttr, @NotNull PTFaceAttr paramPTFaceAttr)
  {
    this.needRender = false;
    if (!this.modelReady) {
      return;
    }
    BenchUtil.benchStart("[filament] updateParams 0");
    if (!this.modelLoadSuccess)
    {
      localObject1 = this.glbList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (GLBItemJava)((Iterator)localObject1).next();
        localObject3 = (byte[])this.glbBytesMap.get(localObject2);
        setupItemInHead((GLBItemJava)localObject2, AEModule.getContext(), (byte[])localObject3);
      }
      this.modelLoadSuccess = true;
    }
    if (this.hideUserHeadModel)
    {
      localObject1 = this.filamentAssetHead.getEntities();
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        int k = localObject1[i];
        this.headScene.removeEntity(k);
        i += 1;
      }
    }
    int j = Math.min(paramPTFaceAttr.getFaceStatusList().size(), 1);
    if (j != this.oldExpression.size())
    {
      this.oldExpression.clear();
      i = 0;
      while (i < j)
      {
        this.oldExpression.add(new float[52]);
        i += 1;
      }
    }
    if (j != this.oldAngleList.size()) {
      this.oldAngleList.clear();
    }
    if (j != this.oldTranslateList.size()) {
      this.oldTranslateList.clear();
    }
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    BenchUtil.benchEnd("[filament] updateParams 0");
    int i = j - 1;
    label289:
    FaceInfo localFaceInfo;
    if (i >= 0)
    {
      BenchUtil.benchStart("[filament] updateParams 1");
      LogUtils.d(this.TAG, "test for filament render: update stage 1");
      localFaceInfo = (FaceInfo)paramPTFaceAttr.getFaceInfoList().get(i);
      if ((localFaceInfo.denseFaceModel == null) || (localFaceInfo.denseFaceModel[0] == 0.0F)) {
        break label1658;
      }
      if (localFaceInfo.transform[15] >= 1.0F) {}
    }
    label359:
    label1658:
    for (;;)
    {
      i -= 1;
      break label289;
      if (localObject2 == null) {
        localObject2 = localFaceInfo.expressionWeights;
      }
      for (;;)
      {
        float[] arrayOfFloat2 = localFaceInfo.eyeRollWeights;
        if (localObject1 == null) {
          localObject1 = arrayOfFloat2;
        }
        for (;;)
        {
          if (this.flattenEar) {
            FilamentJavaUtil.flattenEars(localFaceInfo.denseFaceModel);
          }
          if (this.flattenNose) {
            FilamentJavaUtil.flattenNose(localFaceInfo.denseFaceModel);
          }
          Object localObject4 = FloatBuffer.wrap(localFaceInfo.denseFaceModel);
          this.vertexBuffer.setBufferAt(this.engine, 0, ((FloatBuffer)localObject4).flip());
          BenchUtil.benchEnd("[filament] updateParams 1");
          BenchUtil.benchStart("[filament] updateParams 2");
          float[] arrayOfFloat4 = new float[16];
          localObject4 = new float[3];
          float[] arrayOfFloat1 = new float[4];
          Object localObject5 = new float[3];
          FilamentJavaUtil.decomposeMatrix2(localFaceInfo.transform, (float[])localObject4, arrayOfFloat1, (float[])localObject5);
          localObject5 = FilamentJavaUtil.convertSimdQuaternionToEulerZXY(arrayOfFloat1);
          if (localObject3 == null) {
            localObject3 = localObject5;
          }
          for (;;)
          {
            Matrix.transposeM(arrayOfFloat4, 0, localFaceInfo.transform, 0);
            arrayOfFloat4[1] *= -1.0F;
            arrayOfFloat4[2] *= -1.0F;
            arrayOfFloat4[5] *= -1.0F;
            arrayOfFloat4[6] *= -1.0F;
            arrayOfFloat4[9] *= -1.0F;
            arrayOfFloat4[10] *= -1.0F;
            arrayOfFloat4[13] *= -1.0F;
            arrayOfFloat4[14] *= -1.0F;
            float[] arrayOfFloat3 = new float[16];
            LogUtils.d(this.TAG, "test for filament render: test rotation: " + Arrays.toString(arrayOfFloat4));
            localObject4 = new float[3];
            if (this.oldAngleList.size() > i)
            {
              localObject4 = (float[])this.oldAngleList.get(i);
              arrayOfFloat1 = new float[3];
              if (this.oldTranslateList.size() <= i) {
                break label1089;
              }
              arrayOfFloat1 = (float[])this.oldTranslateList.get(i);
              float f1 = arrayOfFloat4[12];
              float f2 = arrayOfFloat4[13];
              float f3 = arrayOfFloat4[14];
              arrayOfFloat4 = MatrixUtil.getScale(arrayOfFloat4);
              localObject5 = FilamentJavaUtil.getBlendFloatArrayThres((float[])localObject4, (float[])localObject5, this.transformAdjustAlpha, 0.15F, 0.05F);
              float f4 = this.transformAdjustAlpha;
              localObject5 = FilamentJavaUtil.getTransformMatrix((float[])localObject5, FilamentJavaUtil.getBlendFloatArrayThres(arrayOfFloat1, new float[] { f1, f2, f3 }, f4, 0.3F, 0.05F), arrayOfFloat4, new int[] { 0, 0, 0 });
              if (!this.hideUserHeadModel)
              {
                Matrix.rotateM(arrayOfFloat3, 0, (float[])localObject5, 0, 180.0F, 1.0F, 0.0F, 0.0F);
                this.tm.setTransform(this.headRoot, arrayOfFloat3);
              }
              if (this.managerList.size() <= i) {
                break label1104;
              }
              localObject5 = (DynamicBoneManager)this.managerList.get(i);
            }
            for (;;)
            {
              ((DynamicBoneManager)localObject5).updateHeadData(localFaceInfo.denseFaceModel, 1000, arrayOfFloat3);
              ((DynamicBoneManager)localObject5).update();
              BenchUtil.benchEnd("[filament] updateParams 2");
              BenchUtil.benchStart("[filament] updateParams 3");
              j = 0;
              while (j < this.glbList.size())
              {
                if (((GLBItemJava)this.glbList.get(j)).positionType == FilamentJavaUtil.PositionType.DYNAMIC.value)
                {
                  localObject5 = FilamentJavaUtil.getBlendFloatArray((float[])this.oldExpression.get(i), localFaceInfo.expressionWeights, ((GLBItemJava)this.glbList.get(j)).blendShapeAdjustAlpha);
                  updateGlbParams(j, (float[])localObject4, ((GLBItemJava)this.glbList.get(j)).rotateType, arrayOfFloat1, arrayOfFloat4, (float[])localObject5, arrayOfFloat2, paramAIAttr, paramPTFaceAttr);
                }
                j += 1;
              }
              this.oldAngleList.add(localObject4);
              break;
              this.oldTranslateList.add(arrayOfFloat1);
              break label742;
              localObject5 = new DynamicBoneManager(this.engine, this.filamentAssetHead.getRoot());
              Iterator localIterator1 = this.boneItemList.iterator();
              while (localIterator1.hasNext())
              {
                DynamicBoneItem localDynamicBoneItem = (DynamicBoneItem)localIterator1.next();
                Iterator localIterator2 = localDynamicBoneItem.entities.iterator();
                while (localIterator2.hasNext()) {
                  ((DynamicBoneManager)localObject5).add(((Integer)localIterator2.next()).intValue(), localDynamicBoneItem.boneParamsList, localDynamicBoneItem.colliderList, localDynamicBoneItem.noRotateUpdate, localDynamicBoneItem.gravity);
                }
              }
              this.managerList.add(localObject5);
            }
            BenchUtil.benchEnd("[filament] updateParams 3");
            break label359;
            BenchUtil.benchStart("[filament] updateParams 4");
            if (localObject3 == null) {
              localObject3 = new float[] { 0.0F, 0.0F, 0.0F };
            }
            for (;;)
            {
              if (localObject1 == null)
              {
                localObject1 = new float[3];
                tmp1285_1283 = localObject1;
                tmp1285_1283[0] = 0.0F;
                tmp1289_1285 = tmp1285_1283;
                tmp1289_1285[1] = 0.0F;
                tmp1293_1289 = tmp1289_1285;
                tmp1293_1289[2] = 0.0F;
                tmp1293_1289;
              }
              for (;;)
              {
                i = 0;
                if (i < this.glbList.size()) {
                  if (((GLBItemJava)this.glbList.get(i)).positionType == FilamentJavaUtil.PositionType.STATIC.value) {
                    if (this.oldExpression.size() <= 0) {
                      break label1637;
                    }
                  }
                }
                for (localObject4 = (float[])this.oldExpression.get(0);; localObject4 = null)
                {
                  arrayOfFloat1 = null;
                  if (this.oldAngleList.size() > 0) {
                    arrayOfFloat1 = (float[])this.oldAngleList.get(0);
                  }
                  arrayOfFloat1 = FilamentJavaUtil.getBlendFloatArrayThres(arrayOfFloat1, (float[])localObject3, this.transformAdjustAlpha, 0.15F, 0.05F);
                  localObject4 = FilamentJavaUtil.getBlendFloatArray((float[])localObject4, (float[])localObject2, ((GLBItemJava)this.glbList.get(i)).blendShapeAdjustAlpha);
                  updateGlbParams(i, arrayOfFloat1, ((GLBItemJava)this.glbList.get(i)).rotateType, new float[] { 0.0F, 0.0F, 0.0F }, new float[] { 1.0F, 1.0F, 1.0F }, (float[])localObject4, (float[])localObject1, paramAIAttr, paramPTFaceAttr);
                  i += 1;
                  break label1301;
                  if (!this.needRender) {
                    break;
                  }
                  this.needRender = false;
                  if (this.swapChain != null)
                  {
                    LogUtils.d(this.TAG, "test for filament render functioned 1-start");
                    if (this.renderer.beginFrame(this.swapChain))
                    {
                      LogUtils.d(this.TAG, "test for filament render functioned 2");
                      this.renderer.render(this.headView);
                      paramAIAttr = this.viewList.iterator();
                      while (paramAIAttr.hasNext())
                      {
                        paramPTFaceAttr = (View)paramAIAttr.next();
                        this.renderer.render(paramPTFaceAttr);
                      }
                      this.renderer.endFrame();
                      this.needRender = true;
                    }
                  }
                  BenchUtil.benchEnd("[filament] updateParams 4");
                  return;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void destroy()
  {
    LogUtils.d(this.TAG, "test for filament destory 1");
    HandlerUtil.waitDone(this.mHandler);
    this.mHandler.getLooper().quit();
    this.surfaceTexture.setOnFrameAvailableListener(null);
    if (this.swapChain != null)
    {
      this.engine.destroySwapChain(this.swapChain);
      this.engine.flushAndWait();
      this.swapChain = null;
    }
    Fence.waitAndDestroy(this.engine.createFence(), Fence.Mode.FLUSH);
    LogUtils.d(this.TAG, "test for filament destory 2");
    this.surface.release();
    this.surfaceTexture.release();
    GLES20.glDeleteTextures(this.mPreviewTextureId.length, this.mPreviewTextureId, 0);
    this.filamentFrame.clear();
    this.lastInputFrame.clear();
    this.curInputFrame.clear();
    this.mCopyFilter.clearGLSLSelf();
    this.mPreviewFilter.clearGLSLSelf();
    LogUtils.d(this.TAG, "test for filament destory 3");
    Object localObject1 = this.managerList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((DynamicBoneManager)((Iterator)localObject1).next()).clear();
    }
    localObject1 = this.filamentAssetList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FilamentAsset)((Iterator)localObject1).next();
      this.assetLoader.destroyAsset((FilamentAsset)localObject2);
    }
    if (this.vertexBuffer != null) {
      this.engine.destroyVertexBuffer(this.vertexBuffer);
    }
    if (this.indexBuffer != null) {
      this.engine.destroyIndexBuffer(this.indexBuffer);
    }
    if (this.headMaterial != null) {
      this.engine.destroyMaterial(this.headMaterial);
    }
    if (this.filamentAssetHead != null) {
      this.assetLoader.destroyAsset(this.filamentAssetHead);
    }
    this.assetLoader.destroy();
    localObject1 = EntityManager.get();
    Object localObject2 = this.lightList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      int i = ((Integer)((Iterator)localObject2).next()).intValue();
      this.engine.destroyEntity(i);
      ((EntityManager)localObject1).destroy(i);
    }
    this.engine.destroyRenderer(this.renderer);
    localObject1 = this.viewList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (View)((Iterator)localObject1).next();
      if (((View)localObject2).getScene() != null) {
        this.engine.destroyScene(((View)localObject2).getScene());
      }
      this.engine.destroyView((View)localObject2);
    }
    if (this.headView != null)
    {
      if (this.headView.getScene() != null) {
        this.engine.destroyScene(this.headView.getScene());
      }
      this.engine.destroyView(this.headView);
    }
    localObject1 = this.cameraList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Camera)((Iterator)localObject1).next();
      this.engine.destroyCamera((Camera)localObject2);
    }
    if (this.headCamera != null) {
      this.engine.destroyCamera(this.headCamera);
    }
    if (this.indirectLight != null) {
      this.engine.destroyIndirectLight(this.indirectLight);
    }
    localObject1 = this.glbList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((GLBItemJava)((Iterator)localObject1).next()).nodeList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((NodeItemJava)((Iterator)localObject2).next()).destroy(this.engine);
      }
    }
    LogUtils.d(this.TAG, "test for filament destory 4");
    this.engine.destroy();
  }
  
  public void initial()
  {
    GlUtil.glGenTextures(this.mPreviewTextureId.length, this.mPreviewTextureId, 0);
    this.lock = new CountDownLatch(1);
    this.mHandler.post(new FilamentJavaFilter.1(this));
    try
    {
      this.lock.await();
      this.mPreviewFilter.apply();
      this.mCopyFilter.apply();
      setupFilament(AEModule.getContext());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtils.e(localException);
      }
    }
  }
  
  public Frame render(Frame paramFrame, AIAttr paramAIAttr, PTFaceAttr paramPTFaceAttr)
  {
    resize(paramFrame.width, paramFrame.height, paramPTFaceAttr.getRotation());
    BenchUtil.benchStart("[filament] updateParams");
    updateParams(paramAIAttr, paramPTFaceAttr);
    BenchUtil.benchEnd("[filament] updateParams");
    if (!this.needRender)
    {
      this.skipFrame = 0;
      return paramFrame;
    }
    LogUtils.d(this.TAG, "test for filament render called");
    try
    {
      BenchUtil.benchStart("[filament] wait");
      paramAIAttr = (Runnable)this.drawQueue.take();
      BenchUtil.benchEnd("[filament] wait");
      BenchUtil.benchStart("[filament] render");
      paramAIAttr.run();
      BenchUtil.benchEnd("[filament] render");
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
  
  public void setIblIntensity(int paramInt)
  {
    this.headScene.getIndirectLight().setIntensity(paramInt);
  }
  
  public void setIblRotation(int paramInt)
  {
    IndirectLight localIndirectLight = this.headScene.getIndirectLight();
    double d = paramInt * 3.141592653589793D / 180.0D;
    localIndirectLight.setRotation(new float[] { (float)Math.cos(d), 0.0F, (float)-Math.sin(d), 0.0F, 1.0F, 0.0F, (float)Math.sin(d), 0.0F, (float)Math.cos(d) });
  }
  
  public void setLightIntensity(int paramInt)
  {
    Iterator localIterator = this.lightList.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      i = this.lm.getInstance(i);
      this.lm.setIntensity(i, paramInt);
    }
  }
  
  public void setMaxHeadCount(int paramInt)
  {
    this.maxHeadCount = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilamentJavaFilter
 * JD-Core Version:    0.7.0.1
 */