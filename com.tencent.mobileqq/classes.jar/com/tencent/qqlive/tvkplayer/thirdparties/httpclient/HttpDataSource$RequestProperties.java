package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class HttpDataSource$RequestProperties
{
  private final Map<String, String> requestProperties = new HashMap();
  private Map<String, String> requestPropertiesSnapshot;
  
  public void clear()
  {
    try
    {
      this.requestPropertiesSnapshot = null;
      this.requestProperties.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void clearAndSet(Map<String, String> paramMap)
  {
    try
    {
      this.requestPropertiesSnapshot = null;
      this.requestProperties.clear();
      this.requestProperties.putAll(paramMap);
      return;
    }
    finally
    {
      paramMap = finally;
      throw paramMap;
    }
  }
  
  public Map<String, String> getSnapshot()
  {
    try
    {
      if (this.requestPropertiesSnapshot == null) {
        this.requestPropertiesSnapshot = Collections.unmodifiableMap(new HashMap(this.requestProperties));
      }
      Map localMap = this.requestPropertiesSnapshot;
      return localMap;
    }
    finally {}
  }
  
  public void remove(String paramString)
  {
    try
    {
      this.requestPropertiesSnapshot = null;
      this.requestProperties.remove(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void set(String paramString1, String paramString2)
  {
    try
    {
      this.requestPropertiesSnapshot = null;
      this.requestProperties.put(paramString1, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void set(Map<String, String> paramMap)
  {
    try
    {
      this.requestPropertiesSnapshot = null;
      this.requestProperties.putAll(paramMap);
      return;
    }
    finally
    {
      paramMap = finally;
      throw paramMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.HttpDataSource.RequestProperties
 * JD-Core Version:    0.7.0.1
 */