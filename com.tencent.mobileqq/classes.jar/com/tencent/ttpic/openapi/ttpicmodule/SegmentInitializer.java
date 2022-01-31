package com.tencent.ttpic.openapi.ttpicmodule;

import com.tencent.ttpic.openapi.SegmentImpl;
import com.tencent.ttpic.openapi.initializer.Feature;
import com.tencent.ttpic.openapi.initializer.ModelInfo;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.SharedLibraryInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SegmentInitializer
  extends Feature
{
  private static final String TAG = PtuAlgoInitializer.class.getSimpleName();
  private static final ModelInfo[] rapidBigModels = { new ModelInfo(true, "segment", "model_m5_510.rapidnetmodel"), new ModelInfo(true, "segment", "deploy_498.rapidnetproto") };
  private static final ModelInfo[] rapidSmallModels = { new ModelInfo(true, "segment", "RPNSegmenter_m6.rapidnetmodel"), new ModelInfo(true, "segment", "deploy_m6.rapidnetproto") };
  private static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("segmentern") };
  private SegmentImpl mSegmentImpl;
  private boolean useSmallModel = true;
  
  public boolean destroyImpl()
  {
    if (this.mSegmentImpl != null) {
      this.mSegmentImpl.destroy();
    }
    return true;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, rapidBigModels);
    Collections.addAll(localArrayList, rapidSmallModels);
    return localArrayList;
  }
  
  public String getName()
  {
    return "Segment";
  }
  
  public SegmentImpl getSegmentImpl()
  {
    return this.mSegmentImpl;
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(sharedLibraries);
  }
  
  public boolean initGL()
  {
    if (this.mSegmentImpl == null) {
      return false;
    }
    String str2;
    if (this.useSmallModel) {
      str2 = getFinalResourcesDir() + File.separator + rapidSmallModels[0].getFileName();
    }
    for (String str1 = getFinalResourcesDir() + File.separator + rapidSmallModels[1].getFileName();; str1 = getFinalResourcesDir() + File.separator + rapidBigModels[1].getFileName())
    {
      this.mSegmentImpl.init(str1, str2);
      return true;
      str2 = getFinalResourcesDir() + File.separator + rapidBigModels[0].getFileName();
    }
  }
  
  public boolean initImpl()
  {
    boolean bool = loadAllSoFiles();
    this.mSegmentImpl = new SegmentImpl();
    return bool;
  }
  
  public void setUseSmallModel(boolean paramBoolean)
  {
    this.useSmallModel = paramBoolean;
  }
  
  public boolean useSmallModel()
  {
    return this.useSmallModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.SegmentInitializer
 * JD-Core Version:    0.7.0.1
 */