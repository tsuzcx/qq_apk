package com.tencent.ttpic.openapi.ttpicmodule.module_rgb_depth;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.openapi.initializer.Feature;
import com.tencent.ttpic.openapi.initializer.ModelInfo;
import com.tencent.ttpic.openapi.initializer.SharedLibraryInfo;
import com.tencent.ttpic.openapi.initializer.TNNRGBDepthInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.offlineset.OfflineConfig;
import com.tencent.ttpic.openapi.ttpicmodule.RGBDepthImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RGBDepthInitializer
  extends Feature
{
  private static String NAME_RAPIDMODEL_BIG = "depth_big";
  private static String NAME_RAPIDMODEL_MIDDLE = "depth_middle";
  private static String NAME_RAPIDMODEL_SMALL = "depth_small";
  public static final SizeI NET_SIZE_BIG;
  public static final SizeI NET_SIZE_SMALL;
  private static final String TAG = RGBDepthInitializer.class.getSimpleName();
  public static volatile int TYPE = 0;
  private static final ModelInfo[] rapidBigModels = { new ModelInfo(true, "rgbdepth", NAME_RAPIDMODEL_BIG + ".tnnm.wmc"), new ModelInfo(true, "rgbdepth", NAME_RAPIDMODEL_BIG + ".tnnp.wmc"), new ModelInfo(true, "rgbdepth", "surface_big.tnnm.wmc"), new ModelInfo(true, "rgbdepth", "surface_big.tnnp.wmc"), new ModelInfo(true, "rgbdepth", "placeholder_1_big.tnnm.wmc"), new ModelInfo(true, "rgbdepth", "placeholder_1_big.tnnp.wmc"), new ModelInfo(true, "rgbdepth", "placeholder_2_big.tnnm.wmc"), new ModelInfo(true, "rgbdepth", "placeholder_2_big.tnnp.wmc"), new ModelInfo(true, "rgbdepth", "placeholder_3_big.tnnm.wmc"), new ModelInfo(true, "rgbdepth", "placeholder_3_big.tnnp.wmc") };
  private static ModelInfo[] rapidMiddleModels = { new ModelInfo(true, "rgbdepth", NAME_RAPIDMODEL_MIDDLE + ".tnnm.wmc"), new ModelInfo(true, "rgbdepth", NAME_RAPIDMODEL_MIDDLE + ".tnnp.wmc"), new ModelInfo(true, "rgbdepth", "surface_middle.tnnm.wmc"), new ModelInfo(true, "rgbdepth", "surface_middle.tnnp.wmc"), new ModelInfo(true, "rgbdepth", "placeholder_1_middle.tnnm.wmc"), new ModelInfo(true, "rgbdepth", "placeholder_1_middle.tnnp.wmc"), new ModelInfo(true, "rgbdepth", "placeholder_2_middle.tnnm.wmc"), new ModelInfo(true, "rgbdepth", "placeholder_2_middle.tnnp.wmc"), new ModelInfo(true, "rgbdepth", "placeholder_3_middle.tnnm.wmc"), new ModelInfo(true, "rgbdepth", "placeholder_3_middle.tnnp.wmc") };
  private static ModelInfo[] rapidSmallModels = { new ModelInfo(true, "rgbdepth", NAME_RAPIDMODEL_SMALL + ".tnnm.wmc"), new ModelInfo(true, "rgbdepth", NAME_RAPIDMODEL_SMALL + ".tnnp.wmc"), new ModelInfo(true, "rgbdepth", "surface_small.tnnm.wmc"), new ModelInfo(true, "rgbdepth", "surface_small.tnnp.wmc"), new ModelInfo(true, "rgbdepth", "placeholder_1_small.tnnm.wmc"), new ModelInfo(true, "rgbdepth", "placeholder_1_small.tnnp.wmc"), new ModelInfo(true, "rgbdepth", "placeholder_2_small.tnnm.wmc"), new ModelInfo(true, "rgbdepth", "placeholder_2_small.tnnp.wmc"), new ModelInfo(true, "rgbdepth", "placeholder_3_small.tnnm.wmc"), new ModelInfo(true, "rgbdepth", "placeholder_3_small.tnnp.wmc") };
  private RGBDepthImpl mRGBDepthImpl;
  private RGBDepthInitializer.MODLE_LEVEL modle_level;
  private boolean useCPULib = false;
  private boolean useSmallModel = false;
  
  static
  {
    NET_SIZE_BIG = new SizeI(320, 320);
    NET_SIZE_SMALL = new SizeI(192, 256);
  }
  
  private boolean initBigGpu()
  {
    this.useSmallModel = false;
    this.useCPULib = false;
    this.modle_level = RGBDepthInitializer.MODLE_LEVEL.BIG_MODEL;
    boolean bool = FeatureManager.Features.RAPID_NET_RGB_DEPTH.loadRapidModelFrom(getFinalResourcesDir(), NAME_RAPIDMODEL_BIG, false, true, 0, 1, 7);
    FeatureManager.Features.RAPID_NET_RGB_DEPTH.setMode(7, 400);
    return bool;
  }
  
  private boolean initMiddleCpu()
  {
    this.useSmallModel = false;
    this.useCPULib = true;
    this.modle_level = RGBDepthInitializer.MODLE_LEVEL.MIDDLE_MODEL;
    boolean bool = FeatureManager.Features.RAPID_NET_RGB_DEPTH.loadRapidModelFrom(getFinalResourcesDir(), NAME_RAPIDMODEL_MIDDLE, false, true, 0, 0, 7);
    FeatureManager.Features.RAPID_NET_RGB_DEPTH.setMode(7, -1);
    return bool;
  }
  
  private boolean initMiddleGpu()
  {
    this.useSmallModel = false;
    this.useCPULib = false;
    this.modle_level = RGBDepthInitializer.MODLE_LEVEL.MIDDLE_MODEL;
    boolean bool = FeatureManager.Features.RAPID_NET_RGB_DEPTH.loadRapidModelFrom(getFinalResourcesDir(), NAME_RAPIDMODEL_MIDDLE, false, true, 0, 1, 7);
    FeatureManager.Features.RAPID_NET_RGB_DEPTH.setMode(7, 400);
    return bool;
  }
  
  private boolean initModelSync()
  {
    if (this.useSmallModel)
    {
      if (!FeatureManager.Features.RAPID_NET_RGB_DEPTH.isModelLoaded(7)) {}
    }
    else {
      while (FeatureManager.Features.RAPID_NET_RGB_DEPTH.isModelLoaded(7)) {
        return true;
      }
    }
    return initModelSyncImpl();
  }
  
  private boolean initModelSyncImpl()
  {
    if (OfflineConfig.getPhonePerfLevel() <= 3)
    {
      bool2 = initSmallGpu();
      bool1 = bool2;
      if (!bool2) {
        bool1 = initSmallCpu();
      }
      str2 = TAG;
      localStringBuilder = new StringBuilder().append("low device init rgb depth model: ");
      if (this.useCPULib) {}
      for (str1 = "CPU";; str1 = "GPU")
      {
        LogUtils.i(str2, str1 + "+" + this.modle_level.toString());
        return bool1;
      }
    }
    if (OfflineConfig.getPhonePerfLevel() <= 4)
    {
      bool2 = initMiddleGpu();
      bool1 = bool2;
      if (!bool2) {
        bool1 = initSmallCpu();
      }
      str2 = TAG;
      localStringBuilder = new StringBuilder().append("middle device init rgb depth model: ");
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
    StringBuilder localStringBuilder = new StringBuilder().append("non-low device init rgb depth model: ");
    if (this.useCPULib)
    {
      str1 = "CPU";
      localStringBuilder = localStringBuilder.append(str1).append("+");
      if (!this.useSmallModel) {
        break label269;
      }
    }
    label269:
    for (String str1 = "small";; str1 = "big")
    {
      Log.i(str2, str1);
      return bool1;
      str1 = "GPU";
      break;
    }
  }
  
  private boolean initSmallCpu()
  {
    this.useSmallModel = true;
    this.useCPULib = true;
    this.modle_level = RGBDepthInitializer.MODLE_LEVEL.SMALL_MODEL;
    boolean bool = FeatureManager.Features.RAPID_NET_RGB_DEPTH.loadRapidModelFrom(getFinalResourcesDir(), NAME_RAPIDMODEL_SMALL, false, true, 0, 0, 7);
    FeatureManager.Features.RAPID_NET_RGB_DEPTH.setMode(7, -1);
    return bool;
  }
  
  private boolean initSmallGpu()
  {
    this.useSmallModel = true;
    this.useCPULib = false;
    this.modle_level = RGBDepthInitializer.MODLE_LEVEL.SMALL_MODEL;
    boolean bool = FeatureManager.Features.RAPID_NET_RGB_DEPTH.loadRapidModelFrom(getFinalResourcesDir(), NAME_RAPIDMODEL_SMALL, false, true, 0, 1, 7);
    FeatureManager.Features.RAPID_NET_RGB_DEPTH.setMode(7, -1);
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
    if (this.useSmallModel) {}
    for (paramBitmap = FeatureManager.Features.RAPID_NET_RGB_DEPTH.forward(paramBitmap, 7, this.useSmallModel, this.useSmallModel, paramInt);; paramBitmap = FeatureManager.Features.RAPID_NET_RGB_DEPTH.forward(paramBitmap, 7, this.useSmallModel, this.useSmallModel, paramInt)) {
      return paramBitmap;
    }
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
  
  public String getName()
  {
    return "RGBDepth";
  }
  
  public RGBDepthImpl getSegmentImpl()
  {
    return this.mRGBDepthImpl;
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return new ArrayList();
  }
  
  public boolean initGL()
  {
    return this.mRGBDepthImpl != null;
  }
  
  public boolean initImpl()
  {
    if (!FeatureManager.Features.RAPID_NET_RGB_DEPTH.init()) {}
    do
    {
      return false;
      this.isSoFilesLoaded = true;
    } while (!initModelSync());
    this.mRGBDepthImpl = new RGBDepthImpl();
    return true;
  }
  
  public boolean isFunctionReady()
  {
    return (this.isInited) && (FeatureManager.Features.RAPID_NET_RGB_DEPTH.isModelLoaded(7));
  }
  
  public boolean isUseCPULib()
  {
    return this.useCPULib;
  }
  
  public boolean isUseSmallModel()
  {
    return this.useSmallModel;
  }
  
  public boolean reloadModel()
  {
    if (this.useSmallModel)
    {
      if (!FeatureManager.Features.RAPID_NET_RGB_DEPTH.isModelLoaded(7)) {}
    }
    else {
      while (FeatureManager.Features.RAPID_NET_RGB_DEPTH.isModelLoaded(7)) {
        return true;
      }
    }
    return initModelSync();
  }
  
  public boolean reloadModel(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      NAME_RAPIDMODEL_BIG = "model-400000_320x224_4ch22.opt";
      NAME_RAPIDMODEL_MIDDLE = "model-15000_320x224_4ch2.opt";
      NAME_RAPIDMODEL_SMALL = "model-100000_224x192_4ch.opt";
    }
    for (;;)
    {
      return initModelSyncImpl();
      NAME_RAPIDMODEL_BIG = "depth_big";
      NAME_RAPIDMODEL_MIDDLE = "depth_middle";
      NAME_RAPIDMODEL_SMALL = "depth_small";
      continue;
      NAME_RAPIDMODEL_BIG = "surface_big";
      NAME_RAPIDMODEL_MIDDLE = "surface_middle";
      NAME_RAPIDMODEL_SMALL = "surface_small";
      continue;
      NAME_RAPIDMODEL_BIG = "placeholder_1_big";
      NAME_RAPIDMODEL_MIDDLE = "placeholder_1_middle";
      NAME_RAPIDMODEL_SMALL = "placeholder_1_small";
      continue;
      NAME_RAPIDMODEL_BIG = "placeholder_2_big";
      NAME_RAPIDMODEL_MIDDLE = "placeholder_2_middle";
      NAME_RAPIDMODEL_SMALL = "placeholder_2_small";
      continue;
      NAME_RAPIDMODEL_BIG = "placeholder_3_big";
      NAME_RAPIDMODEL_MIDDLE = "placeholder_3_middle";
      NAME_RAPIDMODEL_SMALL = "placeholder_3_small";
    }
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
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.module_rgb_depth.RGBDepthInitializer
 * JD-Core Version:    0.7.0.1
 */