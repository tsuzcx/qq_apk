package com.tencent.ttpic.openai.ttpicmodule;

import android.graphics.Bitmap;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.openapi.initializer.Feature;
import com.tencent.ttpic.openapi.initializer.ModelInfo;
import com.tencent.ttpic.openapi.initializer.SharedLibraryInfo;
import com.tencent.ttpic.openapi.initializer.TNNGenderDetectInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AEGenderDetectorInitializer
  extends Feature
{
  private static final String GENDER_DETECT_MODEL_NAME = "test_xception39_gender.onnx-new";
  public static final SizeI NET_SIZE = new SizeI(128, 128);
  private static final String TAG = "AEGenderDetectorInitializer";
  private static final ModelInfo[] rapidBigModels = { new ModelInfo(true, "aegenderdetect", "test_xception39_gender.onnx-new.rapidmodel.wmc"), new ModelInfo(true, "aegenderdetect", "test_xception39_gender.onnx-new.rapidproto.wmc") };
  private AEGenderDetectImpl mGenderDetectImpl;
  
  private boolean initModelSync()
  {
    if (FeatureManager.Features.RAPID_NET_GENDER_DETECT.isModelLoaded(5)) {
      return true;
    }
    return FeatureManager.Features.RAPID_NET_GENDER_DETECT.loadRapidModelFrom(getFinalResourcesDir(), new ArrayList(Arrays.asList(new String[] { "test_xception39_gender.onnx-new" })), false, true, 5, 0, 5);
  }
  
  public boolean destroyImpl()
  {
    this.mGenderDetectImpl.destroy();
    return true;
  }
  
  public SizeI getCurrentSize()
  {
    return NET_SIZE;
  }
  
  public AEGenderDetectImpl getHandDetectImpl()
  {
    return this.mGenderDetectImpl;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, rapidBigModels);
    return localArrayList;
  }
  
  public String getName()
  {
    return "AEGenderDetect";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return new ArrayList();
  }
  
  public boolean initGL()
  {
    return this.mGenderDetectImpl != null;
  }
  
  public boolean initImpl()
  {
    if (!FeatureManager.Features.RAPID_NET_GENDER_DETECT.init()) {}
    do
    {
      return false;
      this.isSoFilesLoaded = true;
    } while (!initModelSync());
    this.mGenderDetectImpl = new AEGenderDetectImpl();
    return true;
  }
  
  public boolean isFunctionReady()
  {
    return (this.isInited) && (FeatureManager.Features.RAPID_NET_GENDER_DETECT.isModelLoaded(5));
  }
  
  public boolean reloadModel()
  {
    if (FeatureManager.Features.RAPID_NET_GENDER_DETECT.isModelLoaded(5)) {
      return true;
    }
    return initModelSync();
  }
  
  public float[] retrieveGenderInfo(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!isFunctionReady()) {
      return null;
    }
    return FeatureManager.Features.RAPID_NET_GENDER_DETECT.retrieveGenderInfo(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openai.ttpicmodule.AEGenderDetectorInitializer
 * JD-Core Version:    0.7.0.1
 */