package com.tencent.ttpic.openapi.ttpicmodule.module_hair_segment;

import android.graphics.Bitmap;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.openapi.initializer.Feature;
import com.tencent.ttpic.openapi.initializer.ModelInfo;
import com.tencent.ttpic.openapi.initializer.RapidNetSDKInitializer;
import com.tencent.ttpic.openapi.initializer.SharedLibraryInfo;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.ttpicmodule.HairSegmentImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HairSegmentInitializer
  extends Feature
{
  private static final String NAME_RAPIDMODEL_BIG = "hair_v2_deconv_k4_320x320_299_softmax_concat4_iter.onnx.opt.onnx";
  private static final String NAME_RAPIDMODEL_SMALL = "hair_v2_deconv_k4_depthwise_192x256_799999_softmax_iter.onnx.opt.onnx";
  public static final SizeI NET_SIZE_BIG = new SizeI(320, 320);
  public static final SizeI NET_SIZE_SMALL = new SizeI(192, 256);
  private static final String TAG = HairSegmentInitializer.class.getSimpleName();
  private static final ModelInfo[] rapidBigModels = { new ModelInfo(true, "hairsegment", "hair_v2_deconv_k4_320x320_299_softmax_concat4_iter.onnx.opt.onnx.rapidmodel"), new ModelInfo(true, "hairsegment", "hair_v2_deconv_k4_320x320_299_softmax_concat4_iter.onnx.opt.onnx.rapidproto") };
  private static final ModelInfo[] rapidSmallModels = { new ModelInfo(true, "hairsegment", "hair_v2_deconv_k4_depthwise_192x256_799999_softmax_iter.onnx.opt.onnx.rapidmodel"), new ModelInfo(true, "hairsegment", "hair_v2_deconv_k4_depthwise_192x256_799999_softmax_iter.onnx.opt.onnx.rapidproto") };
  private HairSegmentImpl mHairSegmentImpl;
  private boolean useSmallModel = false;
  
  private boolean initModelSync(boolean paramBoolean)
  {
    if (FeatureManager.Features.RAPID_NET.isModelLoaded(1)) {
      return true;
    }
    RapidNetSDKInitializer localRapidNetSDKInitializer = FeatureManager.Features.RAPID_NET;
    String str2 = getFinalResourcesDir();
    String str1;
    if (paramBoolean)
    {
      str1 = "hair_v2_deconv_k4_depthwise_192x256_799999_softmax_iter.onnx.opt.onnx";
      if (!paramBoolean) {
        break label80;
      }
    }
    boolean bool;
    label80:
    for (int i = RapidNetSDKInitializer.RAPID_NET_TYPE_CPU_LIB;; i = RapidNetSDKInitializer.RAPID_NET_TYPE_GPU_LIB)
    {
      bool = localRapidNetSDKInitializer.loadRapidModelFrom(str2, str1, false, true, 0, i, 1);
      if ((bool) || (paramBoolean)) {
        return bool;
      }
      this.useSmallModel = true;
      return initModelSync(true);
      str1 = "hair_v2_deconv_k4_320x320_299_softmax_concat4_iter.onnx.opt.onnx";
      break;
    }
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
    return FeatureManager.Features.RAPID_NET.forward(paramBitmap, 0, this.useSmallModel, this.useSmallModel, paramInt);
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
    return "HairSegment";
  }
  
  public HairSegmentImpl getSegmentImpl()
  {
    return this.mHairSegmentImpl;
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return new ArrayList();
  }
  
  public boolean getUseSmallModel()
  {
    return this.useSmallModel;
  }
  
  public boolean initGL()
  {
    return this.mHairSegmentImpl != null;
  }
  
  public boolean initImpl()
  {
    if (!FeatureManager.Features.RAPID_NET.init()) {}
    do
    {
      return false;
      this.isSoFilesLoaded = true;
    } while (!initModelSync(this.useSmallModel));
    this.mHairSegmentImpl = new HairSegmentImpl();
    return true;
  }
  
  public boolean isFunctionReady()
  {
    return (this.isInited) && (FeatureManager.Features.RAPID_NET.isModelLoaded(1));
  }
  
  public boolean reloadModel()
  {
    if (FeatureManager.Features.RAPID_NET.isModelLoaded(1)) {
      return true;
    }
    return initModelSync(this.useSmallModel);
  }
  
  public void setUseSmallModel(boolean paramBoolean)
  {
    this.useSmallModel = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.module_hair_segment.HairSegmentInitializer
 * JD-Core Version:    0.7.0.1
 */