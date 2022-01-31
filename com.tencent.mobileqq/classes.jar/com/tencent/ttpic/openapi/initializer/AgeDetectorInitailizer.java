package com.tencent.ttpic.openapi.initializer;

import android.os.Environment;
import android.util.Log;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ytFaceAttr.YTFaceAttr;
import com.tencent.ytFaceAttr.YTFaceAttr.FaceAttrConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AgeDetectorInitailizer
  extends Feature
{
  public static final ModelInfo[] AGE_DET_MODELS = { new ModelInfo(true, "agedetect/models", "190522_res18_age_lds_bin.rpdproto"), new ModelInfo(true, "agedetect/models", "190523_res18_age_lds_f16.rpdmodel") };
  private static String ageDetectorDownloadPath = Environment.getExternalStorageDirectory().getPath() + File.separator + "weishi_yt_model";
  private static String model_path = null;
  private static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("YTIllumination"), new SharedLibraryInfo("YTFaceAttr") };
  private final String TAG = "AgeDetectorInitailizer";
  
  public static String getModelPath()
  {
    if ((model_path == null) || (model_path.startsWith("assets://"))) {
      model_path = ageDetectorDownloadPath;
    }
    return model_path;
  }
  
  protected boolean destroyImpl()
  {
    return false;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, AGE_DET_MODELS);
    return localArrayList;
  }
  
  public String getName()
  {
    return "AgeDetector";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(sharedLibraries);
  }
  
  protected boolean initImpl()
  {
    if (!loadAllSoFiles()) {
      return false;
    }
    String str = FeatureManager.Features.AGE_DETECT.getFinalResourcesDir();
    YTFaceAttr.FaceAttrConfig localFaceAttrConfig = new YTFaceAttr.FaceAttrConfig(false, true, false, false, false, false);
    Log.i("AgeDetectorInitailizer", "baseDir: " + str);
    try
    {
      i = YTFaceAttr.NativeGlobalInit(str + File.separator, localFaceAttrConfig);
      if (i == 0)
      {
        LogUtils.i("AgeDetectorInitailizer", "Load model successful.");
        return true;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        Log.e("AgeDetectorInitailizer", "YTFaceAttr.NativeGlobalInit is fail!");
        localUnsatisfiedLinkError.printStackTrace();
        int i = -1;
      }
      LogUtils.e("AgeDetectorInitailizer", "AgeDetector init is failed!");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.AgeDetectorInitailizer
 * JD-Core Version:    0.7.0.1
 */