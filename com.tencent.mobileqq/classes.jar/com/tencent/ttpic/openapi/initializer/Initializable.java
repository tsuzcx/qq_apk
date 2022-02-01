package com.tencent.ttpic.openapi.initializer;

import java.util.List;

public abstract interface Initializable
{
  public abstract List<ModelInfo> getModelInfos();
  
  public abstract String getName();
  
  public abstract List<SharedLibraryInfo> getSharedLibraries();
  
  public abstract boolean init();
  
  public abstract boolean isFunctionReady();
  
  public abstract boolean isResourceReady();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.Initializable
 * JD-Core Version:    0.7.0.1
 */