package com.tencent.ttpic.openapi.ttpicmodule.module_sky_segment;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.openapi.initializer.Feature;
import com.tencent.ttpic.openapi.initializer.ModelInfo;
import com.tencent.ttpic.openapi.initializer.RapidNetSegCpuInitializer;
import com.tencent.ttpic.openapi.initializer.RapidNetSegGpuInitializer;
import com.tencent.ttpic.openapi.initializer.SharedLibraryInfo;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.offlineset.OfflineConfig;
import com.tencent.ttpic.openapi.ttpicmodule.SkySegmentImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SkySegmentInitializer
  extends Feature
{
  private static final String NAME_RAPIDMODEL_BIG = "sky_58k_320x320_1106.onnx.opt.onnx";
  private static final String NAME_RAPIDMODEL_SMALL = "sky_small_192x256_20191128.onnx.opt.onnx";
  public static final SizeI NET_SIZE_BIG = new SizeI(320, 320);
  public static final SizeI NET_SIZE_SMALL = new SizeI(192, 256);
  private static final String TAG = SkySegmentInitializer.class.getSimpleName();
  private static final ModelInfo[] rapidBigModels = { new ModelInfo(true, "skysegment", "sky_58k_320x320_1106.onnx.opt.onnx.rapidmodel"), new ModelInfo(true, "skysegment", "sky_58k_320x320_1106.onnx.opt.onnx.rapidproto") };
  private static final ModelInfo[] rapidSmallModels = { new ModelInfo(true, "skysegment", "sky_small_192x256_20191128.onnx.opt.onnx.rapidmodel"), new ModelInfo(true, "skysegment", "sky_small_192x256_20191128.onnx.opt.onnx.rapidproto") };
  private SkySegmentImpl mSkySegmentImpl;
  private boolean useCPULib = false;
  private boolean useSmallModel = false;
  
  private boolean initBigGpu()
  {
    this.useSmallModel = false;
    this.useCPULib = false;
    return FeatureManager.Features.RAPID_NET_SEG_GPU.loadRapidModelFrom(getFinalResourcesDir(), "sky_58k_320x320_1106.onnx.opt.onnx", false, true, 0, 1, 2);
  }
  
  private boolean initModelSync()
  {
    if (this.useSmallModel)
    {
      if (!FeatureManager.Features.RAPID_NET_SEG_CPU.isModelLoaded(2)) {}
    }
    else {
      while (FeatureManager.Features.RAPID_NET_SEG_GPU.isModelLoaded(2)) {
        return true;
      }
    }
    if (OfflineConfig.getPhonePerfLevel() <= 2)
    {
      Log.i(TAG, "low device init model: CPU + small");
      return initSmallCpu();
    }
    if (Build.BRAND.toLowerCase().startsWith("huawei"))
    {
      Log.i(TAG, "huawei device init model: CPU + small");
      return initSmallCpu();
    }
    boolean bool2 = initBigGpu();
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = initSmallCpu();
    }
    String str2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("non-low device init model: ");
    if (this.useCPULib)
    {
      str1 = "CPU";
      localStringBuilder = localStringBuilder.append(str1).append("+");
      if (!this.useSmallModel) {
        break label169;
      }
    }
    label169:
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
    return FeatureManager.Features.RAPID_NET_SEG_CPU.loadRapidModelFrom(getFinalResourcesDir(), "sky_small_192x256_20191128.onnx.opt.onnx", false, true, 0, 0, 2);
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
    for (paramBitmap = FeatureManager.Features.RAPID_NET_SEG_CPU.forward(paramBitmap, 2, this.useSmallModel, this.useSmallModel, paramInt);; paramBitmap = FeatureManager.Features.RAPID_NET_SEG_GPU.forward(paramBitmap, 2, this.useSmallModel, this.useSmallModel, paramInt)) {
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
    Collections.addAll(localArrayList, rapidSmallModels);
    return localArrayList;
  }
  
  public String getName()
  {
    return "SkySegment";
  }
  
  public SkySegmentImpl getSegmentImpl()
  {
    return this.mSkySegmentImpl;
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return new ArrayList();
  }
  
  public boolean initGL()
  {
    return this.mSkySegmentImpl != null;
  }
  
  public boolean initImpl()
  {
    if ((!FeatureManager.Features.RAPID_NET_SEG_GPU.init()) || (!FeatureManager.Features.RAPID_NET_SEG_CPU.init())) {}
    do
    {
      return false;
      this.isSoFilesLoaded = true;
    } while (!initModelSync());
    this.mSkySegmentImpl = new SkySegmentImpl();
    return true;
  }
  
  public boolean isFunctionReady()
  {
    return (this.isInited) && (((FeatureManager.Features.RAPID_NET_SEG_CPU.isModelLoaded(2)) && (this.useSmallModel)) || ((FeatureManager.Features.RAPID_NET_SEG_GPU.isModelLoaded(2)) && (!this.useSmallModel)));
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
      if (!FeatureManager.Features.RAPID_NET_SEG_CPU.isModelLoaded(2)) {}
    }
    else {
      while (FeatureManager.Features.RAPID_NET_SEG_GPU.isModelLoaded(2)) {
        return true;
      }
    }
    return initModelSync();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.module_sky_segment.SkySegmentInitializer
 * JD-Core Version:    0.7.0.1
 */