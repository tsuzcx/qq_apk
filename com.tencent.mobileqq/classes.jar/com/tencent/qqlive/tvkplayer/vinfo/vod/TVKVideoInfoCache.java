package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
      if (localObject == null) {
        localIterator.remove();
      } else if (System.currentTimeMillis() - ((TVKCGIVideoInfo)localObject).getResponseTime() > ((TVKCGIVideoInfo)localObject).getCt() * 1000 * 0.8D) {
        localIterator.remove();
      }
    }
  }
  
  /* Error */
  public void addVideoInfo(@android.support.annotation.NonNull String paramString1, @Nullable String paramString2, @android.support.annotation.NonNull TVKCGIVideoInfo paramTVKCGIVideoInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 23	com/tencent/qqlive/tvkplayer/vinfo/vod/TVKVideoInfoCache:mVideoInfos	Ljava/util/Map;
    //   20: invokeinterface 99 1 0
    //   25: bipush 20
    //   27: if_icmple +73 -> 100
    //   30: aload_0
    //   31: getfield 23	com/tencent/qqlive/tvkplayer/vinfo/vod/TVKVideoInfoCache:mVideoInfos	Ljava/util/Map;
    //   34: invokeinterface 102 1 0
    //   39: invokeinterface 50 1 0
    //   44: astore 5
    //   46: aload 5
    //   48: invokeinterface 56 1 0
    //   53: ifeq +47 -> 100
    //   56: aload 5
    //   58: invokeinterface 60 1 0
    //   63: checkcast 104	java/util/Map$Entry
    //   66: astore 6
    //   68: aload 6
    //   70: ifnull -24 -> 46
    //   73: aload 6
    //   75: invokeinterface 107 1 0
    //   80: ifnull -34 -> 46
    //   83: aload_0
    //   84: getfield 23	com/tencent/qqlive/tvkplayer/vinfo/vod/TVKVideoInfoCache:mVideoInfos	Ljava/util/Map;
    //   87: aload 6
    //   89: invokeinterface 107 1 0
    //   94: invokeinterface 109 2 0
    //   99: pop
    //   100: aload_0
    //   101: getfield 23	com/tencent/qqlive/tvkplayer/vinfo/vod/TVKVideoInfoCache:mVideoInfos	Ljava/util/Map;
    //   104: aload_0
    //   105: aload_1
    //   106: aload_2
    //   107: invokespecial 111	com/tencent/qqlive/tvkplayer/vinfo/vod/TVKVideoInfoCache:genVideoInfoKey	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   110: aload_3
    //   111: invokeinterface 115 3 0
    //   116: pop
    //   117: goto -104 -> 13
    //   120: astore_1
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	TVKVideoInfoCache
    //   0	125	1	paramString1	String
    //   0	125	2	paramString2	String
    //   0	125	3	paramTVKCGIVideoInfo	TVKCGIVideoInfo
    //   6	3	4	bool	boolean
    //   44	13	5	localIterator	Iterator
    //   66	22	6	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   2	8	120	finally
    //   16	46	120	finally
    //   46	68	120	finally
    //   73	100	120	finally
    //   100	117	120	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVideoInfoCache
 * JD-Core Version:    0.7.0.1
 */