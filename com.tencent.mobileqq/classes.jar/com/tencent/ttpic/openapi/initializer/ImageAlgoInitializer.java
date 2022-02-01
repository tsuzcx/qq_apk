package com.tencent.ttpic.openapi.initializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImageAlgoInitializer
  extends Feature
{
  private static final String TAG = "ImageAlgoInitializer";
  private static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("algo_rithm_jni") };
  
  protected boolean destroyImpl()
  {
    return false;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    return new ArrayList();
  }
  
  public String getName()
  {
    return "ImageAlgo";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(sharedLibraries);
  }
  
  protected boolean initImpl()
  {
    return loadAllSoFiles();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer
 * JD-Core Version:    0.7.0.1
 */