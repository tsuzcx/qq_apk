package com.tencent.ttpic.openapi.initializer;

import com.tencent.aekit.api.standard.GLCapabilities;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GpuParticleInitializer
  extends Feature
{
  private static final String TAG = "GpuParticleInitializer";
  private static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("gpuParticleSystem") };
  
  private static boolean support()
  {
    return GLCapabilities.getGlesVersion().contains("3.");
  }
  
  protected boolean destroyImpl()
  {
    return false;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    return Collections.emptyList();
  }
  
  public String getName()
  {
    return "GpuParticleSystem";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(sharedLibraries);
  }
  
  protected boolean initImpl()
  {
    if (!support()) {
      return false;
    }
    return loadAllSoFiles();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.GpuParticleInitializer
 * JD-Core Version:    0.7.0.1
 */