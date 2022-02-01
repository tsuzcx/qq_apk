package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TVKVideoInfoCache
{
  private static final int MAX_CACHE_COUNT = 20;
  private boolean mIpv6ErrorBefore;
  private Map<String, TVKCGIVideoInfo> mVideoInfos = new HashMap(20);
  
  private String genVideoInfoKey(String paramString1, String paramString2)
  {
    return "";
  }
  
  public static TVKVideoInfoCache getInstance()
  {
    return TVKVideoInfoCache.SingletonHolder.access$100();
  }
  
  private void refreshVideoInfoCache()
  {
    Iterator localIterator = this.mVideoInfos.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (TVKCGIVideoInfo)this.mVideoInfos.get(localObject);
      if (localObject == null)
      {
        localIterator.remove();
      }
      else
      {
        double d1 = System.currentTimeMillis() - ((TVKCGIVideoInfo)localObject).getResponseTime();
        double d2 = ((TVKCGIVideoInfo)localObject).getCt() * 1000;
        Double.isNaN(d2);
        if (d1 > d2 * 0.8D) {
          localIterator.remove();
        }
      }
    }
  }
  
  public void addVideoInfo(@NonNull String paramString1, @Nullable String paramString2, @NonNull TVKCGIVideoInfo paramTVKCGIVideoInfo)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString1);
      if (bool) {
        return;
      }
      if (this.mVideoInfos.size() > 20)
      {
        Iterator localIterator = this.mVideoInfos.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if ((localEntry != null) && (localEntry.getKey() != null)) {
            this.mVideoInfos.remove(localEntry.getKey());
          }
        }
      }
      this.mVideoInfos.put(genVideoInfoKey(paramString1, paramString2), paramTVKCGIVideoInfo);
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString1;
    }
  }
  
  @Nullable
  public TVKCGIVideoInfo getVideoInfo(String paramString1, String paramString2)
  {
    try
    {
      refreshVideoInfoCache();
      paramString1 = (TVKCGIVideoInfo)this.mVideoInfos.get(genVideoInfoKey(paramString1, paramString2));
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public boolean isIpv6Error()
  {
    try
    {
      boolean bool = this.mIpv6ErrorBefore;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setIpv6Error(boolean paramBoolean)
  {
    try
    {
      this.mIpv6ErrorBefore = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVideoInfoCache
 * JD-Core Version:    0.7.0.1
 */