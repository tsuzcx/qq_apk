package com.tencent.ttpic.openapi.initializer;

import android.util.Log;
import com.tencent.ttpic.util.youtu.GenderDetector;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenderDetectorInitializer
  extends Feature
{
  public static final ModelInfo GENDER_DET_LIC = new ModelInfo(true, "genderdetector", "pitu_gender_faceKit.lic");
  public static final ModelInfo GENDER_DET_MODEL;
  private static final String TAG = GenderDetectorInitializer.class.getSimpleName();
  private static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("XHumanActionSDK"), new SharedLibraryInfo("genderdetector") };
  
  static
  {
    GENDER_DET_MODEL = new ModelInfo(true, "genderdetector", "gender_v2.xnet");
  }
  
  private boolean loadModels()
  {
    boolean bool2 = false;
    String str1 = getFinalResourcesDir() + File.separator + GENDER_DET_MODEL.getFileName();
    String str2 = getFinalResourcesDir() + File.separator + GENDER_DET_LIC.getFileName();
    Log.i(TAG, "before xnetInitLicense");
    boolean bool3 = GenderDetector.auth(str2, false);
    if (!bool3)
    {
      Log.i(TAG, "xnetInitLicense error");
      return false;
    }
    Log.i(TAG, "after xnetInitLicense");
    Log.i(TAG, "path: " + str1);
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (GenderDetector.xnetInit(str1)) {
        bool1 = true;
      }
    }
    Log.e(TAG, "path: " + str1);
    return bool1;
  }
  
  protected boolean destroyImpl()
  {
    return false;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, new ModelInfo[] { GENDER_DET_MODEL, GENDER_DET_LIC });
    return localArrayList;
  }
  
  public String getName()
  {
    return "GenderDetector";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(sharedLibraries);
  }
  
  protected boolean initImpl()
  {
    if (!loadAllSoFiles()) {}
    while (!loadModels()) {
      return false;
    }
    return true;
  }
  
  public void setLicense(String paramString1, String paramString2)
  {
    ModelInfo localModelInfo = GENDER_DET_LIC;
    String str = paramString1;
    if (!paramString1.endsWith(File.separator)) {
      str = paramString1 + File.separator;
    }
    localModelInfo.assetsDir = str;
    localModelInfo.fileName = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.GenderDetectorInitializer
 * JD-Core Version:    0.7.0.1
 */