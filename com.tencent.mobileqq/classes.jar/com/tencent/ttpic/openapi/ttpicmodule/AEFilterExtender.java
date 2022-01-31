package com.tencent.ttpic.openapi.ttpicmodule;

import com.tencent.aekit.openrender.AEFilterBase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AEFilterExtender
{
  private static final AEFilterExtender ourInstance = new AEFilterExtender();
  private Map<String, List<Class<? extends AEFilterBase>>> extFilterMap = new HashMap();
  
  public static AEFilterExtender getInstance()
  {
    return ourInstance;
  }
  
  public List<Class<? extends AEFilterBase>> getFilterClassList(String paramString)
  {
    if (this.extFilterMap.containsKey(paramString)) {
      return (List)this.extFilterMap.get(paramString);
    }
    return null;
  }
  
  public void installFilter(String paramString, Class paramClass)
  {
    if (!this.extFilterMap.containsKey(paramString))
    {
      localArrayList = new ArrayList();
      localArrayList.add(paramClass);
      this.extFilterMap.put(paramString, localArrayList);
    }
    while (((List)this.extFilterMap.get(paramString)).contains(paramClass))
    {
      ArrayList localArrayList;
      return;
    }
    ((List)this.extFilterMap.get(paramString)).add(paramClass);
  }
  
  public void unInstallFilter(String paramString)
  {
    if (this.extFilterMap.containsKey(paramString)) {
      this.extFilterMap.remove(paramString);
    }
  }
  
  public void unInstallFilter(String paramString, Class paramClass)
  {
    if ((this.extFilterMap.containsKey(paramString)) && (((List)this.extFilterMap.get(paramString)).contains(paramClass))) {
      ((List)this.extFilterMap.get(paramString)).remove(paramClass);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.AEFilterExtender
 * JD-Core Version:    0.7.0.1
 */