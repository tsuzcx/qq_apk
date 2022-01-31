package com.tencent.ttpic.openapi.initializer;

import com.tencent.ttpic.util.youtu.animojisdk.AnimojiSDK;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class AnimojiInitializer
  extends Feature
{
  public static final ModelInfo[] ANIMOJI_MODELS = { new ModelInfo(true, "animoji", "license_facekit.lic"), new ModelInfo(true, "animoji", "Params_animoji.json"), new ModelInfo(true, "animoji", "FaceKit6K_Animoji.xbin") };
  private static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("XHumanActionSDK"), new SharedLibraryInfo("animojisdk") };
  private AnimojiSDK animojiSDK = new AnimojiSDK();
  
  protected boolean destroyImpl()
  {
    return false;
  }
  
  public AnimojiSDK getAnimojiSDK()
  {
    return this.animojiSDK;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    return Arrays.asList(ANIMOJI_MODELS);
  }
  
  public String getName()
  {
    return "Animoji";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(sharedLibraries);
  }
  
  protected boolean initImpl()
  {
    if (!loadAllSoFiles()) {}
    while (!this.animojiSDK.nativeInit(getModelFinalPath(ANIMOJI_MODELS[0]), getModelFinalPath(ANIMOJI_MODELS[1]), getModelFinalPath(ANIMOJI_MODELS[2]))) {
      return false;
    }
    return true;
  }
  
  public void setLicense(String paramString1, String paramString2)
  {
    ModelInfo localModelInfo = ANIMOJI_MODELS[0];
    String str = paramString1;
    if (!paramString1.endsWith(File.separator)) {
      str = paramString1 + File.separator;
    }
    localModelInfo.assetsDir = str;
    localModelInfo.fileName = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.AnimojiInitializer
 * JD-Core Version:    0.7.0.1
 */