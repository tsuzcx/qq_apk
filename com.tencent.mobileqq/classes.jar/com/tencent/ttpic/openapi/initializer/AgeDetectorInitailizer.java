package com.tencent.ttpic.openapi.initializer;

import android.content.Context;
import com.tencent.aekit.api.standard.AEModule;
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
  private static String model_path;
  private static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("YTIllumination"), new SharedLibraryInfo("YTFaceAttr") };
  private final String TAG = AgeDetectorInitailizer.class.getSimpleName();
  
  public static String getModelPath()
  {
    Object localObject = model_path;
    if ((localObject == null) || (((String)localObject).startsWith("assets://"))) {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(AEModule.getContext().getExternalFilesDir(null).getPath());
        ((StringBuilder)localObject).append(File.separator);
        ((StringBuilder)localObject).append("weishi_yt_model");
        model_path = ((StringBuilder)localObject).toString();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
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
    return this.TAG;
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
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("baseDir: ");
    localStringBuilder.append(str);
    LogUtils.i((String)localObject, localStringBuilder.toString());
    int i = -1;
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(File.separator);
      int j = YTFaceAttr.NativeGlobalInit(((StringBuilder)localObject).toString(), localFaceAttrConfig);
      i = j;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      LogUtils.e(this.TAG, "YTFaceAttr.NativeGlobalInit is fail!");
      localUnsatisfiedLinkError.printStackTrace();
    }
    if (i == 0)
    {
      LogUtils.i(this.TAG, "Load model successful.");
      return true;
    }
    LogUtils.e(this.TAG, "AgeDetector init is failed!");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.AgeDetectorInitailizer
 * JD-Core Version:    0.7.0.1
 */