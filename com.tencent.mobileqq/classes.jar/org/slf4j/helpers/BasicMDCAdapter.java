package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.slf4j.spi.MDCAdapter;

public class BasicMDCAdapter
  implements MDCAdapter
{
  private InheritableThreadLocal<Map<String, String>> inheritableThreadLocal = new BasicMDCAdapter.1(this);
  
  public void clear()
  {
    Map localMap = (Map)this.inheritableThreadLocal.get();
    if (localMap != null)
    {
      localMap.clear();
      this.inheritableThreadLocal.remove();
    }
  }
  
  public String get(String paramString)
  {
    Map localMap = (Map)this.inheritableThreadLocal.get();
    if ((localMap != null) && (paramString != null)) {
      return (String)localMap.get(paramString);
    }
    return null;
  }
  
  public Map<String, String> getCopyOfContextMap()
  {
    Map localMap = (Map)this.inheritableThreadLocal.get();
    if (localMap != null) {
      return new HashMap(localMap);
    }
    return null;
  }
  
  public Set<String> getKeys()
  {
    Map localMap = (Map)this.inheritableThreadLocal.get();
    if (localMap != null) {
      return localMap.keySet();
    }
    return null;
  }
  
  public void put(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      Map localMap = (Map)this.inheritableThreadLocal.get();
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new HashMap();
        this.inheritableThreadLocal.set(localObject);
      }
      ((Map)localObject).put(paramString1, paramString2);
      return;
    }
    throw new IllegalArgumentException("key cannot be null");
  }
  
  public void remove(String paramString)
  {
    Map localMap = (Map)this.inheritableThreadLocal.get();
    if (localMap != null) {
      localMap.remove(paramString);
    }
  }
  
  public void setContextMap(Map<String, String> paramMap)
  {
    this.inheritableThreadLocal.set(new HashMap(paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     org.slf4j.helpers.BasicMDCAdapter
 * JD-Core Version:    0.7.0.1
 */