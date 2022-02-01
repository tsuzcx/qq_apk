package com.tencent.ttpic.openapi.initializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Voice2TextInitializer
  extends Feature
{
  private static final String TAG = Voice2TextInitializer.class.getSimpleName();
  private static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("WXVoice"), new SharedLibraryInfo("ParticleSystem") };
  
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
    return "Voice2Text";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.Voice2TextInitializer
 * JD-Core Version:    0.7.0.1
 */