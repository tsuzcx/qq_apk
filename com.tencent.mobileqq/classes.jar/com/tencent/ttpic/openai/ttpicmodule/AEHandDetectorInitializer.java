package com.tencent.ttpic.openai.ttpicmodule;

import android.graphics.Bitmap;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.openapi.initializer.Feature;
import com.tencent.ttpic.openapi.initializer.ModelInfo;
import com.tencent.ttpic.openapi.initializer.SharedLibraryInfo;
import com.tencent.ttpic.openapi.initializer.TNNGestureInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AEHandDetectorInitializer
  extends Feature
{
  private static final String HAND_CLASSIFY_MODEL_NAME = "test_newbackbone3_cleandata_112.onnx.opt.onnx";
  private static final String HAND_DETECT_MODEL_NAME = "20200418_hand_blazenet_no_aug_cleaned8w_onehand_plus1280_plus8700_90.onnx.opt.onnx";
  private static final String HAND_KEYPOINTS_MODEL_NAME = "hand_keypoint_v3.5_single.onnx.opt.onnx";
  private static final String HAND_PRE_DETECT_MODEL_NAME = "20191231_blazenet_thin_maxpool_preDet_binaryhand_multiscale_softmax_ckpt_99.onnx.opt.onnx";
  private static final String HAND_TRACK_MODEL_NAME = "tracking_v1.onnx.opt.onnx";
  public static final SizeI NET_SIZE = new SizeI(128, 128);
  private static final String TAG = "AEHandDetectInitializer";
  private static final ModelInfo[] rapidBigModels = { new ModelInfo(true, "aehanddetect", "20191231_blazenet_thin_maxpool_preDet_binaryhand_multiscale_softmax_ckpt_99.onnx.opt.onnx.rapidmodel.wmc"), new ModelInfo(true, "aehanddetect", "20191231_blazenet_thin_maxpool_preDet_binaryhand_multiscale_softmax_ckpt_99.onnx.opt.onnx.rapidproto.wmc"), new ModelInfo(true, "aehanddetect", "20200418_hand_blazenet_no_aug_cleaned8w_onehand_plus1280_plus8700_90.onnx.opt.onnx.rapidmodel.wmc"), new ModelInfo(true, "aehanddetect", "20200418_hand_blazenet_no_aug_cleaned8w_onehand_plus1280_plus8700_90.onnx.opt.onnx.rapidproto.wmc"), new ModelInfo(true, "aehanddetect", "tracking_v1.onnx.opt.onnx.rapidmodel.wmc"), new ModelInfo(true, "aehanddetect", "tracking_v1.onnx.opt.onnx.rapidproto.wmc"), new ModelInfo(true, "aehanddetect", "hand_keypoint_v3.5_single.onnx.opt.onnx.rapidmodel.wmc"), new ModelInfo(true, "aehanddetect", "hand_keypoint_v3.5_single.onnx.opt.onnx.rapidproto.wmc"), new ModelInfo(true, "aehanddetect", "test_newbackbone3_cleandata_112.onnx.opt.onnx.rapidmodel.wmc"), new ModelInfo(true, "aehanddetect", "test_newbackbone3_cleandata_112.onnx.opt.onnx.rapidproto.wmc") };
  private AEHandDetectImpl mHandDetectImpl;
  
  private boolean initModelSync()
  {
    if (FeatureManager.Features.RAPID_NET_GESTURE.isModelLoaded(3)) {
      return true;
    }
    return FeatureManager.Features.RAPID_NET_GESTURE.loadRapidModelFrom(getFinalResourcesDir(), new ArrayList(Arrays.asList(new String[] { "20191231_blazenet_thin_maxpool_preDet_binaryhand_multiscale_softmax_ckpt_99.onnx.opt.onnx", "20200418_hand_blazenet_no_aug_cleaned8w_onehand_plus1280_plus8700_90.onnx.opt.onnx", "tracking_v1.onnx.opt.onnx", "hand_keypoint_v3.5_single.onnx.opt.onnx", "test_newbackbone3_cleandata_112.onnx.opt.onnx" })), false, true, 2, 0, 3);
  }
  
  public boolean destroyImpl()
  {
    this.mHandDetectImpl.destroy();
    return true;
  }
  
  public SizeI getCurrentSize()
  {
    return NET_SIZE;
  }
  
  public AEHandDetectImpl getHandDetectImpl()
  {
    return this.mHandDetectImpl;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, rapidBigModels);
    return localArrayList;
  }
  
  public String getName()
  {
    return "AEHandDetect";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return new ArrayList();
  }
  
  public boolean initGL()
  {
    return this.mHandDetectImpl != null;
  }
  
  public boolean initImpl()
  {
    if (!FeatureManager.Features.RAPID_NET_GESTURE.init()) {}
    do
    {
      return false;
      this.isSoFilesLoaded = true;
    } while (!initModelSync());
    this.mHandDetectImpl = new AEHandDetectImpl();
    return true;
  }
  
  public boolean isFunctionReady()
  {
    return (this.isInited) && (FeatureManager.Features.RAPID_NET_GESTURE.isModelLoaded(3));
  }
  
  public boolean reloadModel()
  {
    if (FeatureManager.Features.RAPID_NET_GESTURE.isModelLoaded(3)) {
      return true;
    }
    return initModelSync();
  }
  
  public float[] retrieveGestureBoxAndType(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (!isFunctionReady()) {
      return null;
    }
    return FeatureManager.Features.RAPID_NET_GESTURE.retrieveGestureBoxAndType(paramBitmap, paramBoolean);
  }
  
  public float[] retrieveGestureInfo(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (!isFunctionReady()) {
      return null;
    }
    return FeatureManager.Features.RAPID_NET_GESTURE.retrieveGestureInfo(paramBitmap, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openai.ttpicmodule.AEHandDetectorInitializer
 * JD-Core Version:    0.7.0.1
 */