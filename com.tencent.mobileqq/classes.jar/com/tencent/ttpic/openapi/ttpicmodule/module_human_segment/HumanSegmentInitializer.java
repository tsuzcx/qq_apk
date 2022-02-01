package com.tencent.ttpic.openapi.ttpicmodule.module_human_segment;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
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
  private static final String NAME_RAPIDMODEL_BIG = "portrait_Xception_EX_spconv_256x256_0317_400_big.onnx.opt.onnx";
  private static final String NAME_RAPIDMODEL_MIDDLE = "portrait_Xception_192x160_0302_8910_small.onnx.opt.onnx.middle";
  private static final String NAME_RAPIDMODEL_SMALL = "portrait_Xception_192x160_0302_8910_small.onnx.opt.onnx";
  public static final SizeI NET_SIZE_BIG = new SizeI(320, 320);
  public static final SizeI NET_SIZE_SMALL = new SizeI(256, 256);
  private static final String TAG = HumanSegmentInitializer.class.getSimpleName();
  private static final ModelInfo[] rapidBigModels = { new ModelInfo(true, "humansegment", "portrait_Xception_EX_spconv_256x256_0317_400_big.onnx.opt.onnx.rapidmodel.wmc"), new ModelInfo(true, "humansegment", "portrait_Xception_EX_spconv_256x256_0317_400_big.onnx.opt.onnx.rapidproto.wmc") };
  private static final ModelInfo[] rapidMiddleModels = { new ModelInfo(true, "humansegment", "portrait_Xception_192x160_0302_8910_small.onnx.opt.onnx.middle.rapidmodel.wmc"), new ModelInfo(true, "humansegment", "portrait_Xception_192x160_0302_8910_small.onnx.opt.onnx.middle.rapidproto.wmc") };
  private static final ModelInfo[] rapidSmallModels = { new ModelInfo(true, "humansegment", "portrait_Xception_192x160_0302_8910_small.onnx.opt.onnx.rapidmodel.wmc"), new ModelInfo(true, "humansegment", "portrait_Xception_192x160_0302_8910_small.onnx.opt.onnx.rapidproto.wmc") };
  private int cameraId;
  private HumanSegmentImpl mHumanSegmentImpl;
  private HumanSegmentInitializer.MODLE_LEVEL modle_level;
  private int postMode;
  private volatile boolean useCPULib = false;
  private boolean useSmallModel = false;
  
  private boolean initBigGpu()
  {
    this.useCPULib = false;
    this.modle_level = HumanSegmentInitializer.MODLE_LEVEL.BIG_MODEL;
    boolean bool = FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.loadRapidModelFrom(getFinalResourcesDir(), "portrait_Xception_EX_spconv_256x256_0317_400_big.onnx.opt.onnx", false, true, 0, 1, 4);
    FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.setMode(2);
    this.postMode = 2;
    this.cameraId = 0;
    return bool;
  }
  
  private boolean initMiddleCpu()
  {
    this.useCPULib = true;
    this.modle_level = HumanSegmentInitializer.MODLE_LEVEL.MIDDLE_MODEL;
    boolean bool = FeatureManager.Features.RAPID_NET_HUMAN_SEG_CPU.loadRapidModelFrom(getFinalResourcesDir(), "portrait_Xception_192x160_0302_8910_small.onnx.opt.onnx.middle", false, true, 0, 0, 4);
    this.postMode = 1;
    this.cameraId = 0;
    return bool;
  }
  
  private boolean initMiddleGpu()
  {
    this.useCPULib = false;
    this.modle_level = HumanSegmentInitializer.MODLE_LEVEL.MIDDLE_MODEL;
    boolean bool = FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.loadRapidModelFrom(getFinalResourcesDir(), "portrait_Xception_192x160_0302_8910_small.onnx.opt.onnx.middle", false, true, 0, 1, 4);
    FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.setMode(2);
    this.postMode = 2;
    this.cameraId = 0;
    return bool;
  }
  
  private boolean initSmallCpu()
  {
    this.useCPULib = true;
    this.modle_level = HumanSegmentInitializer.MODLE_LEVEL.SMALL_MODEL;
    boolean bool = FeatureManager.Features.RAPID_NET_HUMAN_SEG_CPU.loadRapidModelFrom(getFinalResourcesDir(), "portrait_Xception_192x160_0302_8910_small.onnx.opt.onnx", false, true, 0, 0, 4);
    FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.setMode(0);
    this.postMode = 0;
    this.cameraId = 0;
    return bool;
  }
  
  private boolean initSmallGpu()
  {
    this.useCPULib = false;
    this.modle_level = HumanSegmentInitializer.MODLE_LEVEL.SMALL_MODEL;
    boolean bool = FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.loadRapidModelFrom(getFinalResourcesDir(), "portrait_Xception_192x160_0302_8910_small.onnx.opt.onnx", false, true, 0, 1, 4);
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
        Log.i(str2, str1 + "+" + this.modle_level.toString());
        return bool1;
      }
    }
    if (Build.BRAND.toLowerCase().startsWith("huawei"))
    {
      Log.i(TAG, "huawei device init human seg model: CPU + " + HumanSegmentInitializer.MODLE_LEVEL.SMALL_MODEL.toString());
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
        Log.i(str2, str1 + "+" + this.modle_level.toString());
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
      Log.i(str2, str1 + "+" + this.modle_level.toString());
      return bool1;
    }
  }
  
  public boolean isFunctionReady()
  {
    return (this.isInited) && (((FeatureManager.Features.RAPID_NET_HUMAN_SEG_CPU.isModelLoaded(4)) && (this.useCPULib)) || ((FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.isModelLoaded(4)) && (!this.useCPULib)));
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