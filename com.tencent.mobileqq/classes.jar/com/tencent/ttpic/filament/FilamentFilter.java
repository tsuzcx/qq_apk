package com.tencent.ttpic.filament;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.Surface;
import com.google.android.filament.FilamentJNI;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aekit.plugin.core.AIActionCounter;
import com.tencent.aekit.plugin.core.AIActionCounter.AI_TYPE;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.ttpic.ar.sensor.representation.Matrix;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.gameplaysdk.model.Range;
import com.tencent.ttpic.openapi.PTDetectInfo.Builder;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.filter.SimpleGLThread;
import com.tencent.ttpic.openapi.initializer.FilamentInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.AnimojiExpressionJava;
import com.tencent.ttpic.openapi.model.GLBItemJava;
import com.tencent.ttpic.openapi.model.NodeItemJava;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import org.jetbrains.annotations.NotNull;

public class FilamentFilter
{
  private static final boolean DEBUG = true;
  private static final String TAG = FilamentFilter.class.getSimpleName();
  private static final boolean USE_SHARE_CONTEXT = false;
  private String dataPath;
  private LinkedBlockingDeque<Runnable> drawQueue = new LinkedBlockingDeque();
  private Frame filamentFrame = new Frame();
  private FilamentJNI filamentJNI;
  private Map<GLBItemJava, byte[]> glbBytesMap = new HashMap();
  private List<GLBItemJava> glbList;
  private boolean hasLoadGlbData;
  private int height = -1;
  private final boolean isBloomMaterial;
  private final HashMap<String, Float> jawOpenThresholdMap = new HashMap();
  private byte[] jsonData;
  private BaseFilter mCopyFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
  private SimpleGLThread mHandler;
  private SurfaceTextureFilter mPreviewFilter = new SurfaceTextureFilter();
  private int[] mPreviewTextureId = new int[2];
  private EGLContext mShareContext;
  private volatile boolean modelLoadSucceed;
  private volatile boolean modelReady;
  private boolean needRender;
  private int rotation = 0;
  private int skipFrame;
  private Surface surface;
  private SurfaceTexture surfaceTexture;
  private int width = -1;
  
  @RequiresApi(api=17)
  public FilamentFilter(VideoMaterial paramVideoMaterial)
  {
    this.glbList = paramVideoMaterial.getGlbList();
    updateJawOpenThreshold(this.glbList);
    this.dataPath = paramVideoMaterial.getDataPath();
    this.isBloomMaterial = VideoMaterialUtil.isFilamentBloomMaterial(paramVideoMaterial);
    this.mHandler = new SimpleGLThread(EGL14.eglGetCurrentContext(), "HTM_Fila", new FilamentFilter.1(this));
  }
  
  private void loadGlbData()
  {
    FilaBenchUtil.benchStart(FilamentJavaUtil.BenchTag.LOAD_DATA.tag);
    Iterator localIterator = this.glbList.iterator();
    while (localIterator.hasNext())
    {
      GLBItemJava localGLBItemJava = (GLBItemJava)localIterator.next();
      byte[] arrayOfByte = (byte[])this.glbBytesMap.get(localGLBItemJava);
      this.filamentJNI.setGlbData(FileUtils.getFileNameWithSuffixByPath(localGLBItemJava.path), arrayOfByte);
    }
    this.filamentJNI.loadAllData();
    this.modelLoadSucceed = true;
    FilaBenchUtil.benchEnd(FilamentJavaUtil.BenchTag.LOAD_DATA.tag);
  }
  
  private byte[] openGlbFile(GLBItemJava paramGLBItemJava)
  {
    if (!TextUtils.isEmpty(paramGLBItemJava.path)) {
      return FilamentJavaUtil.decryptGlb(paramGLBItemJava.path);
    }
    return null;
  }
  
  private void resize(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 != this.width) || (paramInt2 != this.height) || (this.rotation != paramInt3))
    {
      float f = Math.min(paramInt1 / FilamentJavaUtil.getProcessWidth(), 1.0F);
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
      this.width = paramInt1;
      this.height = paramInt2;
      this.rotation = paramInt3;
      setupFilament();
      this.filamentJNI.resize(paramInt1, paramInt2);
      this.surfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
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
    this.hasLoadGlbData = false;
    this.filamentJNI = FilamentJNI.create(this.surface, this.mShareContext, Math.min(this.width, this.height), Math.max(this.width, this.height), FeatureManager.Features.FILAMENT.getFinalResourcesDir() + File.separator, this.dataPath, this.jsonData);
    if (!DeviceUtils.hasDeviceNormal(AEModule.getContext())) {
      this.filamentJNI.setNewFurLayers(0);
    }
    this.mHandler.postJob(new FilamentFilter.4(this));
  }
  
  private void updateActionTriggered(int paramInt, AIAttr paramAIAttr, PTFaceAttr paramPTFaceAttr)
  {
    if (!this.modelLoadSucceed) {}
    for (;;)
    {
      return;
      BenchUtil.benchStart("[filament] updateActionTriggered 0");
      Object localObject1 = paramPTFaceAttr.getFaceActionCounter();
      Object localObject2 = AIActionCounter.getActions(AIActionCounter.AI_TYPE.HAND);
      Set localSet = paramPTFaceAttr.getTriggeredExpression();
      paramAIAttr = new PTDetectInfo.Builder().faceActionCounter((Map)localObject1).handActionCounter((Map)localObject2).triggeredExpression(localSet).aiAttr(paramAIAttr).faceDetector(paramPTFaceAttr.getFaceDetector()).timestamp(paramPTFaceAttr.getTimeStamp()).build();
      BenchUtil.benchStart("[filament] updateActionTriggered 1");
      paramPTFaceAttr = ((GLBItemJava)this.glbList.get(paramInt)).nodeList.iterator();
      while (paramPTFaceAttr.hasNext())
      {
        localObject1 = (NodeItemJava)paramPTFaceAttr.next();
        ((NodeItemJava)localObject1).updateActionTriggered(paramAIAttr);
        localObject2 = ((NodeItemJava)localObject1).getTexture(((GLBItemJava)this.glbList.get(paramInt)).folder);
        this.filamentJNI.setMaterialImage((String)localObject2, ((NodeItemJava)localObject1).name, ((NodeItemJava)localObject1).material, true, false);
      }
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
  
  private void updateParams(AIAttr paramAIAttr, @NotNull PTFaceAttr paramPTFaceAttr)
  {
    this.needRender = false;
    if (!this.modelReady) {}
    do
    {
      return;
      if (!this.modelLoadSucceed) {
        loadGlbData();
      }
    } while (paramPTFaceAttr.getFaceInfoList().isEmpty());
    int i = 0;
    while (i < this.glbList.size())
    {
      updateActionTriggered(i, paramAIAttr, paramPTFaceAttr);
      i += 1;
    }
    i = 0;
    while (i < paramPTFaceAttr.getFaceInfoList().size())
    {
      paramAIAttr = (FaceInfo)paramPTFaceAttr.getFaceInfoList().get(i);
      Object localObject;
      if (paramAIAttr.transform != null)
      {
        localObject = new float[16];
        Matrix.transposeM((float[])localObject, 0, paramAIAttr.transform, 0);
        this.filamentJNI.setMaterialTransform(i, (float[])localObject, paramAIAttr.denseFaceModel);
      }
      int j = 0;
      while (j < this.glbList.size())
      {
        if (paramAIAttr.expressionWeights != null)
        {
          localObject = ((GLBItemJava)this.glbList.get(j)).nodeList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            NodeItemJava localNodeItemJava = (NodeItemJava)((Iterator)localObject).next();
            FilamentJavaUtil.adjustExpressionWeights(localNodeItemJava.expressionConfigList, paramAIAttr.expressionWeights, ((Float)this.jawOpenThresholdMap.get(localNodeItemJava.name)).floatValue(), paramAIAttr.angles);
            FilamentJavaUtil.setMorphWeights(this.filamentJNI, localNodeItemJava, paramAIAttr.expressionWeights, i, j);
          }
        }
        j += 1;
      }
      i += 1;
    }
    this.filamentJNI.setHeadCount(paramPTFaceAttr.getFaceInfoList().size());
    this.filamentJNI.render();
    this.needRender = true;
  }
  
  public void destroy()
  {
    LogUtils.d(TAG, "test for filament destory 1");
    this.mHandler.waitDone();
    this.mHandler.getLooper().quit();
    this.surfaceTexture.setOnFrameAvailableListener(null);
    LogUtils.d(TAG, "test for filament destory 2");
    this.surface.release();
    this.surfaceTexture.release();
    GLES20.glDeleteTextures(this.mPreviewTextureId.length, this.mPreviewTextureId, 0);
    this.filamentFrame.clear();
    this.mCopyFilter.clearGLSLSelf();
    this.mPreviewFilter.clearGLSLSelf();
    if (this.filamentJNI != null) {
      this.filamentJNI.destroy();
    }
    FilaBenchUtil.init();
    LogUtils.d(TAG, "test for filament destory 3");
  }
  
  public void initial()
  {
    FilaBenchUtil.benchStart(FilamentJavaUtil.BenchTag.INIT.tag);
    FilaBenchUtil.benchStart(FilamentJavaUtil.BenchTag.FIRST_RENDER.tag);
    GlUtil.glGenTextures(this.mPreviewTextureId.length, this.mPreviewTextureId, 0);
    this.mHandler.postJobSync(new FilamentFilter.2(this));
    this.mPreviewFilter.apply();
    this.mCopyFilter.apply();
    this.surface = new Surface(this.surfaceTexture);
    String str2 = VideoTemplateParser.readMaterialFile(this.dataPath, "params", true, VideoTemplateParser.decryptListener);
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.jsonData = str1.getBytes();
    this.surfaceTexture.setOnFrameAvailableListener(new FilamentFilter.3(this));
    FilaBenchUtil.benchEnd(FilamentJavaUtil.BenchTag.INIT.tag);
  }
  
  public Frame render(Frame paramFrame, AIAttr paramAIAttr, PTFaceAttr paramPTFaceAttr)
  {
    BenchUtil.benchStart("[filament] updateParams");
    resize(paramFrame.width, paramFrame.height, paramPTFaceAttr.getRotation());
    updateParams(paramAIAttr, paramPTFaceAttr);
    BenchUtil.benchEnd("[filament] updateParams");
    if (!this.needRender)
    {
      this.skipFrame = 0;
      return paramFrame;
    }
    FilaBenchUtil.benchEnd(FilamentJavaUtil.BenchTag.FIRST_RENDER.tag);
    FilaBenchUtil.reset();
    LogUtils.d(TAG, "test for filament render called");
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
  
  public void reset()
  {
    Iterator localIterator1 = this.glbList.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((GLBItemJava)localIterator1.next()).nodeList.iterator();
      while (localIterator2.hasNext()) {
        ((NodeItemJava)localIterator2.next()).reset();
      }
    }
  }
  
  public void setIblIntensity(int paramInt) {}
  
  public void setIblRotation(int paramInt) {}
  
  public void setLightIntensity(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilamentFilter
 * JD-Core Version:    0.7.0.1
 */