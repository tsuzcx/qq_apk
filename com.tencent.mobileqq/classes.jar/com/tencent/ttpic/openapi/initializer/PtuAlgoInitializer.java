package com.tencent.ttpic.openapi.initializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PtuAlgoInitializer
  extends Feature
{
  private static final String TAG = PtuAlgoInitializer.class.getSimpleName();
  private static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("image_filter_common"), new SharedLibraryInfo("image_filter_gpu") };
  
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
    return "PtuAlgo";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer
 * JD-Core Version:    0.7.0.1
 */