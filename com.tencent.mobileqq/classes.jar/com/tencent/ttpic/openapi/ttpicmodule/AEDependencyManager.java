package com.tencent.ttpic.openapi.ttpicmodule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AEDependencyManager
{
  private static final AEDependencyManager ourInstance = new AEDependencyManager();
  private List<String> loadedDependencies = new ArrayList();
  private List<String> materialDependencies = new ArrayList();
  private List<String> notLoadedDependencies = new ArrayList();
  
  public static AEDependencyManager getInstance()
  {
    return ourInstance;
  }
  
  public List<String> getNotLoadedDependencies()
  {
    return this.notLoadedDependencies;
  }
  
  public int getUnloadedDependenciesCount()
  {
    if (this.materialDependencies == null) {
      return this.notLoadedDependencies.size();
    }
    Iterator localIterator = this.materialDependencies.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!isDependencyLoaded(str)) {
        this.notLoadedDependencies.add(str);
      }
    }
    return this.notLoadedDependencies.size();
  }
  
  public boolean isDependencyLoaded(String paramString)
  {
    return this.loadedDependencies.indexOf(paramString) > 0;
  }
  
  public void loadDependency(String paramString)
  {
    try
    {
      this.loadedDependencies.add(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setMaterialDependencies(List<String> paramList)
  {
    this.materialDependencies = paramList;
    this.notLoadedDependencies.clear();
  }
  
  public void unloadDependency(String paramString)
  {
    this.loadedDependencies.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.AEDependencyManager
 * JD-Core Version:    0.7.0.1
 */