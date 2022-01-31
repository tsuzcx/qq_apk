package com.tencent.oskplayer.datasource;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class HttpHeader
{
  private static AtomicInteger sId = new AtomicInteger(10);
  private Map<String, String> headerSnapshot;
  private final Map<String, String> headers = new HashMap();
  private int mId = -1;
  
  public void clear()
  {
    try
    {
      this.headerSnapshot = null;
      this.headers.clear();
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
      this.headerSnapshot = null;
      this.headers.clear();
      this.headers.putAll(paramMap);
      return;
    }
    finally
    {
      paramMap = finally;
      throw paramMap;
    }
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public Map<String, String> getSnapshot()
  {
    try
    {
      if (this.headerSnapshot == null) {
        this.headerSnapshot = Collections.unmodifiableMap(new HashMap(this.headers));
      }
      Map localMap = this.headerSnapshot;
      return localMap;
    }
    finally {}
  }
  
  public void remove(String paramString)
  {
    try
    {
      this.headerSnapshot = null;
      this.headers.remove(paramString);
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
      this.headerSnapshot = null;
      this.headers.put(paramString1, paramString2);
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
      this.headerSnapshot = null;
      this.headers.putAll(paramMap);
      return;
    }
    finally
    {
      paramMap = finally;
      throw paramMap;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("HttpHeader[");
    localStringBuilder.append("id=");
    localStringBuilder.append(this.mId);
    localStringBuilder.append(",");
    Iterator localIterator = this.headers.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append(localEntry.getKey());
      localStringBuilder.append("=");
      localStringBuilder.append(localEntry.getValue());
      localStringBuilder.append(",");
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.HttpHeader
 * JD-Core Version:    0.7.0.1
 */