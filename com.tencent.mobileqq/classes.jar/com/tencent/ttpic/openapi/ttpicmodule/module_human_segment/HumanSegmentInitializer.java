package com.tencent.ttpic.openapi.ttpicmodule.module_human_segment;

import android.graphics.Bitmap;
import android.os.Build;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.openapi.initializer.Feature;
import com.tencent.ttpic.openapi.initializer.ModelInfo;
import com.tencent.ttpic.openapi.initializer.SharedLibraryInfo;
import com.tencent.ttpic.openapi.initializer.TNNHumanSegCpuInitializer;
import com.tencent.ttpic.openapi.initializer.TNNHumanSegGpuInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.offlineset.OfflineConfig;
import com.tencent.ttpic.openapi.ttpicmodule.HumanSegmentImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanSegmentInitializer
  extends Feature
{
  private static final String NAME_RAPIDMODEL_BBIG = "net2_v14_0618jizhi_155.onnx.opt.onnx";
  private static final String NAME_RAPIDMODEL_BIG = "big_Xception_EX_spconv_256x256_0508_300.onnx.opt.onnx";
  private static final String NAME_RAPIDMODEL_MIDDLE = "small_Xception_EX_spconv_192x160_0511_300.onnx.opt.onnx";
  private static final String NAME_RAPIDMODEL_SMALL = "smallest_Xception_EX_spconv_v3_160x160_0519_300.onnx.opt.onnx";
  public static final SizeI NET_SIZE_BIG = new SizeI(320, 320);
  public static final SizeI NET_SIZE_SMALL = new SizeI(256, 256);
  private static final String TAG = HumanSegmentInitializer.class.getSimpleName();
  private static final ModelInfo[] rapidBBigModels = { new ModelInfo(true, "humansegment", "net2_v14_0618jizhi_155.onnx.opt.onnx.rapidmodel.wmc"), new ModelInfo(true, "humansegment", "net2_v14_0618jizhi_155.onnx.opt.onnx.rapidproto.wmc") };
  private static final ModelInfo[] rapidBigModels = { new ModelInfo(true, "humansegment", "big_Xception_EX_spconv_256x256_0508_300.onnx.opt.onnx.rapidmodel.wmc"), new ModelInfo(true, "humansegment", "big_Xception_EX_spconv_256x256_0508_300.onnx.opt.onnx.rapidproto.wmc") };
  private static final ModelInfo[] rapidMiddleModels = { new ModelInfo(true, "humansegment", "small_Xception_EX_spconv_192x160_0511_300.onnx.opt.onnx.rapidmodel.wmc"), new ModelInfo(true, "humansegment", "small_Xception_EX_spconv_192x160_0511_300.onnx.opt.onnx.rapidproto.wmc") };
  private static final ModelInfo[] rapidSmallModels = { new ModelInfo(true, "humansegment", "smallest_Xception_EX_spconv_v3_160x160_0519_300.onnx.opt.onnx.rapidmodel.wmc"), new ModelInfo(true, "humansegment", "smallest_Xception_EX_spconv_v3_160x160_0519_300.onnx.opt.onnx.rapidproto.wmc") };
  private int cameraId;
  private HumanSegmentImpl mHumanSegmentImpl;
  private HumanSegmentInitializer.MODLE_LEVEL modle_level;
  private int postMode;
  private volatile boolean useCPULib = false;
  private volatile boolean useCPULibImage = false;
  private boolean useSmallModel = false;
  
  private boolean initBBigCpu()
  {
    this.useCPULibImage = true;
    boolean bool = FeatureManager.Features.RAPID_NET_HUMAN_SEG_CPU_IMAGE.loadRapidModelFrom(getFinalResourcesDir(), "net2_v14_0618jizhi_155.onnx.opt.onnx", false, true, 0, 0, 4);
    FeatureManager.Features.RAPID_NET_HUMAN_SEG_CPU_IMAGE.setMode(-1);
    return bool;
  }
  
  private boolean initBBigGpu()
  {
    this.useCPULibImage = false;
    boolean bool = FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU_IMAGE.loadRapidModelFrom(getFinalResourcesDir(), "net2_v14_0618jizhi_155.onnx.opt.onnx", false, true, 0, 0, 4);
    FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU_IMAGE.setMode(-1);
    return bool;
  }
  
  private boolean initBigGpu()
  {
    this.useCPULib = false;
    this.modle_level = HumanSegmentInitializer.MODLE_LEVEL.BIG_MODEL;
    boolean bool = FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.loadRapidModelFrom(getFinalResourcesDir(), "big_Xception_EX_spconv_256x256_0508_300.onnx.opt.onnx", false, true, 0, 1, 4);
    FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.setMode(2);
    this.postMode = 2;
    this.cameraId = 0;
    return bool;
  }
  
  private boolean initMiddleCpu()
  {
    this.useCPULib = true;
    this.modle_level = HumanSegmentInitializer.MODLE_LEVEL.MIDDLE_MODEL;
    boolean bool = FeatureManager.Features.RAPID_NET_HUMAN_SEG_CPU.loadRapidModelFrom(getFinalResourcesDir(), "small_Xception_EX_spconv_192x160_0511_300.onnx.opt.onnx", false, true, 0, 0, 4);
    this.postMode = 1;
    this.cameraId = 0;
    return bool;
  }
  
  private boolean initMiddleGpu()
  {
    this.useCPULib = false;
    this.modle_level = HumanSegmentInitializer.MODLE_LEVEL.MIDDLE_MODEL;
    boolean bool = FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.loadRapidModelFrom(getFinalResourcesDir(), "small_Xception_EX_spconv_192x160_0511_300.onnx.opt.onnx", false, true, 0, 1, 4);
    FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.setMode(2);
    this.postMode = 2;
    this.cameraId = 0;
    return bool;
  }
  
  private boolean initSmallCpu()
  {
    this.useCPULib = true;
    this.modle_level = HumanSegmentInitializer.MODLE_LEVEL.SMALL_MODEL;
    boolean bool = FeatureManager.Features.RAPID_NET_HUMAN_SEG_CPU.loadRapidModelFrom(getFinalResourcesDir(), "smallest_Xception_EX_spconv_v3_160x160_0519_300.onnx.opt.onnx", false, true, 0, 0, 4);
    FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.setMode(0);
    this.postMode = 0;
    this.cameraId = 0;
    return bool;
  }
  
  private boolean initSmallGpu()
  {
    this.useCPULib = false;
    this.modle_level = HumanSegmentInitializer.MODLE_LEVEL.SMALL_MODEL;
    boolean bool = FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.loadRapidModelFrom(getFinalResourcesDir(), "smallest_Xception_EX_spconv_v3_160x160_0519_300.onnx.opt.onnx", false, true, 0, 1, 4);
    FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.setMode(2);
    this.postMode = 2;
    this.cameraId = 0;
    return bool;
  }
  
  public boolean destroyImpl()
  {
    return true;
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt)
  {
    if (!isFunctionReady()) {
      return paramBitmap;
    }
    if (this.useCPULib) {}
    for (paramBitmap = FeatureManager.Features.RAPID_NET_HUMAN_SEG_CPU.forward(paramBitmap, 4, false, false, paramInt);; paramBitmap = FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.forward(paramBitmap, 4, false, false, paramInt)) {
      return paramBitmap;
    }
  }
  
  public Bitmap forwardImage(Bitmap paramBitmap, int paramInt)
  {
    if (!isFunctionReadyImage()) {
      return paramBitmap;
    }
    if (this.useCPULibImage) {}
    for (paramBitmap = FeatureManager.Features.RAPID_NET_HUMAN_SEG_CPU_IMAGE.forward(paramBitmap, 4, false, false, paramInt);; paramBitmap = FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU_IMAGE.forward(paramBitmap, 4, false, false, paramInt)) {
      return paramBitmap;
    }
  }
  
  public int getCameraId()
  {
    return this.cameraId;
  }
  
  public SizeI getCurrentSize()
  {
    if (this.useSmallModel) {
      return NET_SIZE_SMALL;
    }
    return NET_SIZE_BIG;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, rapidBigModels);
    Collections.addAll(localArrayList, rapidMiddleModels);
    Collections.addAll(localArrayList, rapidSmallModels);
    return localArrayList;
  }
  
  public List<ModelInfo> getModelInfosImage()
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, rapidBBigModels);
    return localArrayList;
  }
  
  public int getModelLevel()
  {
    return this.modle_level.getValue();
  }
  
  public String getName()
  {
    return "HumanSegment";
  }
  
  public int getPostMode()
  {
    return this.postMode;
  }
  
  public HumanSegmentImpl getSegmentImpl()
  {
    return this.mHumanSegmentImpl;
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return new ArrayList();
  }
  
  public boolean initGL()
  {
    if (this.mHumanSegmentImpl == null)
    {
      this.mHumanSegmentImpl = new HumanSegmentImpl();
      this.mHumanSegmentImpl.setHumanSegmentInitializer(this);
    }
    this.mHumanSegmentImpl.init();
    return true;
  }
  
  public boolean initImpl()
  {
    if ((!FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.init()) || (!FeatureManager.Features.RAPID_NET_HUMAN_SEG_CPU.init())) {}
    do
    {
      return false;
      this.isSoFilesLoaded = true;
    } while (!initModelSync());
    return true;
  }
  
  public boolean initModelSync()
  {
    if (this.useCPULib)
    {
      if (!FeatureManager.Features.RAPID_NET_HUMAN_SEG_CPU.isModelLoaded(4)) {}
    }
    else {
      while (FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.isModelLoaded(4)) {
        return true;
      }
    }
    if (OfflineConfig.getPhonePerfLevel() <= 2)
    {
      bool2 = initSmallGpu();
      bool1 = bool2;
      if (!bool2) {
        bool1 = initSmallCpu();
      }
      str2 = TAG;
      localStringBuilder = new StringBuilder().append("low device init human seg model: ");
      if (this.useCPULib) {}
      for (str1 = "CPU";; str1 = "GPU")
      {
        LogUtils.i(str2, str1 + "+" + this.modle_level.toString());
        return bool1;
      }
    }
    if ((Build.BRAND.toLowerCase().startsWith("huawei")) || (Build.BRAND.toLowerCase().startsWith("honor")))
    {
      LogUtils.i(TAG, "huawei device init human seg model: CPU + " + HumanSegmentInitializer.MODLE_LEVEL.SMALL_MODEL.toString());
      return initSmallCpu();
    }
    if (OfflineConfig.getPhonePerfLevel() <= 3)
    {
      bool2 = initMiddleGpu();
      bool1 = bool2;
      if (!bool2) {
        bool1 = initSmallCpu();
      }
      str2 = TAG;
      localStringBuilder = new StringBuilder().append("middle device init human seg model: ");
      if (this.useCPULib) {}
      for (str1 = "CPU";; str1 = "GPU")
      {
        LogUtils.i(str2, str1 + "+" + this.modle_level.toString());
        return bool1;
      }
    }
    boolean bool2 = initBigGpu();
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = initMiddleCpu();
    }
    String str2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("high device init human seg model: ");
    if (this.useCPULib) {}
    for (String str1 = "CPU";; str1 = "GPU")
    {
      LogUtils.i(str2, str1 + "+" + this.modle_level.toString());
      return bool1;
    }
  }
  
  public boolean initModelSyncImage()
  {
    if (!copyAssetsModelsToLocalPath(getModelInfosImage()))
    {
      LogUtils.i(TAG, "load human seg bbig model faild ");
      return false;
    }
    boolean bool2 = initBBigGpu();
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = initBBigCpu();
    }
    String str2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("force init human seg model: ");
    if (this.useCPULib) {}
    for (String str1 = "CPU";; str1 = "GPU")
    {
      LogUtils.i(str2, str1 + "+ bbig model");
      return bool1;
    }
  }
  
  public boolean isFunctionReady()
  {
    return (this.isInited) && (((FeatureManager.Features.RAPID_NET_HUMAN_SEG_CPU.isModelLoaded(4)) && (this.useCPULib)) || ((FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.isModelLoaded(4)) && (!this.useCPULib)));
  }
  
  public boolean isFunctionReadyImage()
  {
    return (this.isInited) && (((FeatureManager.Features.RAPID_NET_HUMAN_SEG_CPU_IMAGE.isModelLoaded(4)) && (this.useCPULibImage)) || ((FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU_IMAGE.isModelLoaded(4)) && (!this.useCPULibImage)));
  }
  
  public boolean isUseCPULib()
  {
    return this.useCPULib;
  }
  
  public boolean reloadModel()
  {
    if (this.useCPULib)
    {
      if (!FeatureManager.Features.RAPID_NET_HUMAN_SEG_CPU.isModelLoaded(4)) {}
    }
    else {
      while (FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.isModelLoaded(4)) {
        return true;
      }
    }
    return initModelSync();
  }
  
  public void setCameraId(int paramInt)
  {
    this.cameraId = paramInt;
  }
  
  public void setMode(int paramInt)
  {
    if (!isFunctionReady()) {}
    do
    {
      return;
      if (!this.useCPULib) {
        break;
      }
    } while (paramInt == 2);
    FeatureManager.Features.RAPID_NET_HUMAN_SEG_CPU.setMode(paramInt);
    return;
    FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.setMode(paramInt);
  }
  
  public void setPostMode(int paramInt)
  {
    this.postMode = paramInt;
    FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.setMode(paramInt);
  }
  
  public void setUseCPULib(boolean paramBoolean)
  {
    this.useCPULib = paramBoolean;
  }
  
  public void setUseSmallModel(boolean paramBoolean)
  {
    this.useSmallModel = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.HumanSegmentInitializer
 * JD-Core Version:    0.7.0.1
 */