package com.tencent.ttpic.openapi.initializer;

import com.tencent.aekit.api.standard.GLCapabilities;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LightSdkInitializer
  extends Feature
{
  private static final SharedLibraryInfo CPP_SHARED = new SharedLibraryInfo("c++_shared");
  private static final SharedLibraryInfo OPENCV_WORLD = new SharedLibraryInfo("opencv_world");
  private static final SharedLibraryInfo[] SHARED_LIBRARIES;
  private static final String TAG = LightSdkInitializer.class.getSimpleName();
  private static final SharedLibraryInfo V8_JNI = new SharedLibraryInfo("v8jni");
  
  static
  {
    SHARED_LIBRARIES = new SharedLibraryInfo[] { new SharedLibraryInfo("thread"), new SharedLibraryInfo("miniz"), new SharedLibraryInfo("logging"), new SharedLibraryInfo("libpag"), new SharedLibraryInfo("light-sdk") };
  }
  
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
    return "LightSdk";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(SHARED_LIBRARIES);
  }
  
  protected boolean initImpl()
  {
    if (!isExternalSoLoad()) {
      if ((!systemLoadLibrarySafely(CPP_SHARED.fileName)) || (!systemLoadLibrarySafely(V8_JNI.fileName)) || (!loadAllSoFiles())) {}
    }
    while ((systemLoadSafely(FileUtils.genSeperateFileDir(FeatureManager.getSoDir()), CPP_SHARED)) && (systemLoadLibrarySafely(V8_JNI.fileName)) && (loadAllSoFiles()))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean supportAceEngine()
  {
    return (GLCapabilities.getGlesVersion().contains("3.")) && (GLCapabilities.isFilamentShaderCompileSucceed());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.LightSdkInitializer
 * JD-Core Version:    0.7.0.1
 */