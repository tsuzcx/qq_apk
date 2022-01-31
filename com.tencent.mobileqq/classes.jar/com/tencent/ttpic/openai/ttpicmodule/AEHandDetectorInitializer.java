package com.tencent.ttpic.openai.ttpicmodule;

import android.graphics.Bitmap;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.openapi.initializer.Feature;
import com.tencent.ttpic.openapi.initializer.ModelInfo;
import com.tencent.ttpic.openapi.initializer.RapidNetSDKInitializer;
import com.tencent.ttpic.openapi.initializer.SharedLibraryInfo;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AEHandDetectorInitializer
  extends Feature
{
  private static final String HAND_CLASSIFY_MODEL_NAME = "shufflenet_cleandata2_1016_iter_60000.onnx.opt.onnx";
  private static final String HAND_DETECT_MODEL_NAME = "20191030_blazeNet_from_40_selfie_rotate90_celian_wailian_60.onnx.opt.onnx";
  private static final String HAND_KEYPOINTS_MODEL_NAME = "tracking+keypoint_v2.onnx.opt.onnx";
  private static final String HAND_TRACK_MODEL_NAME = "tracking_v1.onnx.opt.onnx";
  public static final SizeI NET_SIZE = new SizeI(128, 128);
  private static final String TAG = "AEHandDetectInitializer";
  private static final ModelInfo[] rapidBigModels = { new ModelInfo(true, "aehanddetect", "20191030_blazeNet_from_40_selfie_rotate90_celian_wailian_60.onnx.opt.onnx.rapidmodel"), new ModelInfo(true, "aehanddetect", "20191030_blazeNet_from_40_selfie_rotate90_celian_wailian_60.onnx.opt.onnx.rapidproto"), new ModelInfo(true, "aehanddetect", "tracking_v1.onnx.opt.onnx.rapidmodel"), new ModelInfo(true, "aehanddetect", "tracking_v1.onnx.opt.onnx.rapidproto"), new ModelInfo(true, "aehanddetect", "tracking+keypoint_v2.onnx.opt.onnx.rapidmodel"), new ModelInfo(true, "aehanddetect", "tracking+keypoint_v2.onnx.opt.onnx.rapidproto"), new ModelInfo(true, "aehanddetect", "shufflenet_cleandata2_1016_iter_60000.onnx.opt.onnx.rapidmodel"), new ModelInfo(true, "aehanddetect", "shufflenet_cleandata2_1016_iter_60000.onnx.opt.onnx.rapidproto") };
  private AEHandDetectImpl mHandDetectImpl;
  
  private boolean initModelSync()
  {
    if (FeatureManager.Features.RAPID_NET.isModelLoaded(3)) {
      return true;
    }
    return FeatureManager.Features.RAPID_NET.loadRapidModelFrom(getFinalResourcesDir(), new ArrayList(Arrays.asList(new String[] { "20191030_blazeNet_from_40_selfie_rotate90_celian_wailian_60.onnx.opt.onnx", "tracking_v1.onnx.opt.onnx", "tracking+keypoint_v2.onnx.opt.onnx", "shufflenet_cleandata2_1016_iter_60000.onnx.opt.onnx" })), false, true, 2, RapidNetSDKInitializer.RAPID_NET_TYPE_CPU_LIB, 3);
  }
  
  public boolean destroyImpl()
  {
    this.mHandDetectImpl.destroy();
    return true;
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt)
  {
    if (!isFunctionReady()) {
      return paramBitmap;
    }
    return FeatureManager.Features.RAPID_NET.forward(paramBitmap, 2, true, false, paramInt);
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
    if (!FeatureManager.Features.RAPID_NET.init()) {}
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
    return (this.isInited) && (FeatureManager.Features.RAPID_NET.isModelLoaded(3));
  }
  
  public boolean reloadModel()
  {
    if (FeatureManager.Features.RAPID_NET.isModelLoaded(3)) {
      return true;
    }
    return initModelSync();
  }
  
  public float[] retrieveGestureBoxAndType(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (!isFunctionReady()) {
      return null;
    }
    return FeatureManager.Features.RAPID_NET.retrieveGestureBoxAndType(paramBitmap, paramBoolean);
  }
  
  public float[] retrieveGestureInfo(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (!isFunctionReady()) {
      return null;
    }
    return FeatureManager.Features.RAPID_NET.retrieveGestureInfo(paramBitmap, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openai.ttpicmodule.AEHandDetectorInitializer
 * JD-Core Version:    0.7.0.1
 */