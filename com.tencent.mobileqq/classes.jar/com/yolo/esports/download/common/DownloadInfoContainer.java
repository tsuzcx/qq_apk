package com.yolo.esports.download.common;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadInfoContainer
{
  public ConcurrentHashMap<String, DownloadInfo> a = new ConcurrentHashMap();
  public final Object b = new Object();
  
  public DownloadInfo a(Object paramObject)
  {
    synchronized (this.b)
    {
      paramObject = (DownloadInfo)this.a.remove(paramObject);
      return paramObject;
    }
  }
  
  public DownloadInfo a(String paramString, DownloadInfo paramDownloadInfo)
  {
    Object localObject = this.b;
    if (paramDownloadInfo != null) {}
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = (DownloadInfo)this.a.put(paramString, paramDownloadInfo);
        return paramString;
      }
      return null;
    }
    finally {}
  }
  
  public boolean a(String paramString)
  {
    synchronized (this.b)
    {
      boolean bool = this.a.containsKey(paramString);
      return bool;
    }
  }
  
  public DownloadInfo b(String paramString)
  {
    synchronized (this.b)
    {
      paramString = (DownloadInfo)this.a.get(paramString);
      return paramString;
    }
  }
  
  public String toString()
  {
    synchronized (this.b)
    {
      label137:
      try
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("downloadInfos, size=");
        ((StringBuilder)localObject2).append(this.a.keySet().size());
        ((StringBuilder)localObject2).append("{\n");
        Iterator localIterator = this.a.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ((StringBuilder)localObject2).append(((DownloadInfo)this.a.get(str)).toString());
          ((StringBuilder)localObject2).append("\n");
        }
        ((StringBuilder)localObject2).append("}\n");
        localObject2 = ((StringBuilder)localObject2).toString();
        return localObject2;
      }
      catch (Throwable localThrowable)
      {
        Object localObject2;
        label125:
        break label125;
      }
      return "";
      break label137;
      throw ((Throwable)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.yolo.esports.download.common.DownloadInfoContainer
 * JD-Core Version:    0.7.0.1
 */