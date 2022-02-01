package com.tencent.ttpic.openapi.ttpicmodule;

import android.graphics.Bitmap;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.openapi.initializer.Feature;
import com.tencent.ttpic.openapi.initializer.ModelInfo;
import com.tencent.ttpic.openapi.initializer.SharedLibraryInfo;
import com.tencent.ttpic.openapi.initializer.TNNCatInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AECatDetectorInitializer
  extends Feature
{
  private static final String CAT_DETECT_MODEL_NAME = "20200218_cat_cleaned_ly_blazenet208_multiscale_coconobody_plus_bush_real_plus_handseg_all_plus_rear_neg_yolact_no_yolact_aug_90.onnx.opt.onnx";
  private static final String CAT_KEYPOINTS_MODEL_NAME = "cat_keypoint_v1.7.onnx.opt.onnx";
  private static final String CAT_TRACK_MODEL_NAME = "cat_tracking_v1.6.onnx.opt.onnx";
  public static final SizeI NET_SIZE = new SizeI(128, 128);
  private static final String TAG = "AECatDetectInitializer";
  private static final ModelInfo[] rapidBigModels = { new ModelInfo(true, "aecatdetect", "20200218_cat_cleaned_ly_blazenet208_multiscale_coconobody_plus_bush_real_plus_handseg_all_plus_rear_neg_yolact_no_yolact_aug_90.onnx.opt.onnx.rapidmodel.wmc"), new ModelInfo(true, "aecatdetect", "20200218_cat_cleaned_ly_blazenet208_multiscale_coconobody_plus_bush_real_plus_handseg_all_plus_rear_neg_yolact_no_yolact_aug_90.onnx.opt.onnx.rapidproto.wmc"), new ModelInfo(true, "aecatdetect", "cat_tracking_v1.6.onnx.opt.onnx.rapidmodel.wmc"), new ModelInfo(true, "aecatdetect", "cat_tracking_v1.6.onnx.opt.onnx.rapidproto.wmc"), new ModelInfo(true, "aecatdetect", "cat_keypoint_v1.7.onnx.opt.onnx.rapidmodel.wmc"), new ModelInfo(true, "aecatdetect", "cat_keypoint_v1.7.onnx.opt.onnx.rapidproto.wmc") };
  private AECatDetectImpl mCatDetectImpl;
  
  private boolean initModelSync()
  {
    if (this.isInited) {
      return true;
    }
    return FeatureManager.Features.RAPID_NET_CAT.loadRapidModelFrom(getFinalResourcesDir(), new ArrayList(Arrays.asList(new String[] { "20200218_cat_cleaned_ly_blazenet208_multiscale_coconobody_plus_bush_real_plus_handseg_all_plus_rear_neg_yolact_no_yolact_aug_90.onnx.opt.onnx", "cat_tracking_v1.6.onnx.opt.onnx", "cat_keypoint_v1.7.onnx.opt.onnx" })), false, true, 0);
  }
  
  public boolean destroyImpl()
  {
    this.mCatDetectImpl.destroy();
    return true;
  }
  
  public AECatDetectImpl getCatDetectImpl()
  {
    return this.mCatDetectImpl;
  }
  
  public SizeI getCurrentSize()
  {
    return NET_SIZE;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, rapidBigModels);
    return localArrayList;
  }
  
  public String getName()
  {
    return "AECatDetect";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return new ArrayList();
  }
  
  public boolean initGL()
  {
    return this.mCatDetectImpl != null;
  }
  
  public boolean initImpl()
  {
    if (!FeatureManager.Features.RAPID_NET_CAT.init()) {}
    do
    {
      return false;
      this.isSoFilesLoaded = true;
    } while (!initModelSync());
    this.mCatDetectImpl = new AECatDetectImpl();
    return true;
  }
  
  public boolean isFunctionReady()
  {
    return this.isInited;
  }
  
  public boolean reloadModel()
  {
    if (this.isInited) {
      return true;
    }
    return initModelSync();
  }
  
  public float[] retrieveCatKeyPoints(Bitmap paramBitmap)
  {
    if (!isFunctionReady()) {
      return null;
    }
    return FeatureManager.Features.RAPID_NET_CAT.retrieveCatKeyPoints(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.AECatDetectorInitializer
 * JD-Core Version:    0.7.0.1
 */