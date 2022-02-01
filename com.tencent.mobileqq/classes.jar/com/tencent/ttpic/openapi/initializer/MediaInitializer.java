package com.tencent.ttpic.openapi.initializer;

import com.tencent.aekit.api.standard.AEModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MediaInitializer
  extends Feature
{
  private static final String TAG = PagInitializer.class.getSimpleName();
  private static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("mp4con_20190710"), new SharedLibraryInfo("soft_decoder_20190710"), new SharedLibraryInfo("vbox_20190530") };
  
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
    return "Media";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    if (AEModule.isEnableReducedMeidaLibrary()) {
      return Arrays.asList(new SharedLibraryInfo[] { sharedLibraries[2] });
    }
    return Arrays.asList(sharedLibraries);
  }
  
  protected boolean initImpl()
  {
    return loadAllSoFiles();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.MediaInitializer
 * JD-Core Version:    0.7.0.1
 */