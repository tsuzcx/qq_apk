package com.tencent.oskplayer.proxy;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.datasource.DefaultBandwidthMeter;
import com.tencent.oskplayer.datasource.DownloadListener;
import com.tencent.oskplayer.datasource.HttpHeader;
import com.tencent.oskplayer.datasource.VideoDownloadListener;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.model.SegmentVideoInfo.SegmentInfo;
import com.tencent.oskplayer.model.SegmentVideoInfo.StreamInfo;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.util.QLog;
import com.tencent.oskplayer.util.ThreadUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class VideoManager
{
  private static final String TAG = "VideoManager";
  private static volatile VideoManager instance;
  public static volatile int sElapsedMs;
  public static volatile long sEstimateBitrate;
  private VideoProxy proxy = new VideoProxy();
  
  private void cancelAsync(String paramString, boolean paramBoolean)
  {
    this.proxy.cancelAsync(paramString, paramBoolean);
  }
  
  public static VideoManager getInstance()
  {
    if (instance != null) {
      return instance;
    }
    throw new IllegalStateException("Video SDK has not been initialized! Call init() first!");
  }
  
  public static boolean hasInit()
  {
    return instance != null;
  }
  
  public static void init(Context paramContext)
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new VideoManager();
        }
        return;
      }
      finally {}
    }
  }
  
  public void addCacheReadListener(String paramString, VideoProxy.CacheReadListener paramCacheReadListener)
  {
    this.proxy.addCacheReadListener(paramString, paramCacheReadListener);
  }
  
  public void addHttpErrorListener(String paramString, VideoProxy.HttpErrorListener paramHttpErrorListener)
  {
    this.proxy.addHttpErrorListener(paramString, paramHttpErrorListener);
  }
  
  public void addHttpRetryLogic(String paramString, HttpRetryLogic paramHttpRetryLogic)
  {
    this.proxy.addHttpRetryLogic(paramString, paramHttpRetryLogic);
  }
  
  public void addUuidErrorListener(String paramString, VideoProxy.HttpErrorListener paramHttpErrorListener)
  {
    this.proxy.addUuidErrorListener(paramString, paramHttpErrorListener);
  }
  
  public void cancelAllAsync()
  {
    this.proxy.cancelAllAsync();
  }
  
  public void cancelAllPreloadAsync()
  {
    this.proxy.cancelAllPreloadAsync(true);
  }
  
  public void cancelAsync(String paramString)
  {
    cancelAsync(paramString, true);
  }
  
  public void cancelPreloadMedia()
  {
    this.proxy.cancelAllPreloadAsync(true);
  }
  
  public void clearCache()
  {
    try
    {
      this.proxy.clearCache();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed clear cache. msg=");
      localStringBuilder.append(localException.getMessage());
      PlayerUtils.log(6, "VideoManager", localStringBuilder.toString());
    }
  }
  
  public void clearCacheByInfo(SegmentVideoInfo paramSegmentVideoInfo)
  {
    if (paramSegmentVideoInfo != null)
    {
      if (paramSegmentVideoInfo.getStreams() == null) {
        return;
      }
      paramSegmentVideoInfo = paramSegmentVideoInfo.getStreams().values().iterator();
      while (paramSegmentVideoInfo.hasNext())
      {
        Object localObject = (SegmentVideoInfo.StreamInfo)paramSegmentVideoInfo.next();
        if ((localObject != null) && (((SegmentVideoInfo.StreamInfo)localObject).segmentInfos != null))
        {
          localObject = ((SegmentVideoInfo.StreamInfo)localObject).segmentInfos.iterator();
          while (((Iterator)localObject).hasNext())
          {
            SegmentVideoInfo.SegmentInfo localSegmentInfo = (SegmentVideoInfo.SegmentInfo)((Iterator)localObject).next();
            if ((localSegmentInfo != null) && (!TextUtils.isEmpty(localSegmentInfo.url))) {
              clearCacheByUrl(localSegmentInfo.url);
            }
          }
        }
      }
    }
  }
  
  public void clearCacheByUrl(String paramString)
  {
    try
    {
      this.proxy.clearCacheByUrl(paramString);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed clear cache by url. url=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" msg=");
      localStringBuilder.append(localException.getMessage());
      PlayerUtils.log(6, "VideoManager", localStringBuilder.toString());
    }
  }
  
  public String downloadVideoSync(String paramString, VideoDownloadListener paramVideoDownloadListener, boolean paramBoolean, HttpHeader paramHttpHeader)
  {
    return this.proxy.downloadVideoSync(paramString, paramVideoDownloadListener, paramBoolean, paramHttpHeader);
  }
  
  public void downloadVideosAsync(List<String> paramList, int paramInt, boolean paramBoolean, VideoDownloadListener paramVideoDownloadListener, HttpHeader paramHttpHeader)
  {
    this.proxy.downloadVideosAsync(paramList, paramInt, paramBoolean, paramVideoDownloadListener, paramHttpHeader);
  }
  
  public long getCachedBytesFromEnd(String paramString)
  {
    return this.proxy.getCachedBytesFromEnd(paramString);
  }
  
  public long getCachedBytesFromStart(String paramString)
  {
    return this.proxy.getCachedBytesFromStart(paramString);
  }
  
  public double getCachedSizeRate(String paramString)
  {
    return this.proxy.getCachedSizeRate(paramString);
  }
  
  public long getDownloadBitrate()
  {
    return DefaultBandwidthMeter.getBitrate();
  }
  
  public String getLocalServerPrefix()
  {
    return this.proxy.getLocalServerPrefix();
  }
  
  public long getTotalLength(String paramString)
  {
    return this.proxy.getTotalLength(paramString);
  }
  
  public long getUnCachedSize(String paramString)
  {
    return this.proxy.getUnCachedSize(paramString);
  }
  
  public String getUrl(String paramString)
  {
    return this.proxy.getUrl(paramString);
  }
  
  public String getUrl(String paramString, HttpHeader paramHttpHeader)
  {
    return this.proxy.getUrl(paramString, paramHttpHeader);
  }
  
  public String getUrl(String paramString1, HttpHeader paramHttpHeader, String paramString2)
  {
    return this.proxy.getUrl(paramString1, paramHttpHeader, paramString2);
  }
  
  public List<String> getUrl(List<String> paramList)
  {
    return this.proxy.getUrl(paramList);
  }
  
  public List<String> getUrl(List<String> paramList, List<HttpHeader> paramList1)
  {
    return this.proxy.getUrl(paramList, paramList1);
  }
  
  public String getVideoKey(String paramString)
  {
    return PlayerUtils.parseVideoKey(paramString);
  }
  
  public VideoRequestManager getVideoRequestManager()
  {
    return this.proxy.getVideoRequestManager();
  }
  
  public boolean isCached(SegmentVideoInfo.StreamInfo paramStreamInfo)
  {
    if (paramStreamInfo != null)
    {
      if (!paramStreamInfo.isValid()) {
        return false;
      }
      if (PlayerUtils.isOnMainThread())
      {
        paramStreamInfo = ThreadUtils.submitTaskCatchAll(new VideoManager.IsStreamInfoCachedCallable(this, paramStreamInfo), 800, true, "isCached", "VideoManager");
        if (paramStreamInfo != null) {
          return ((Boolean)paramStreamInfo).booleanValue();
        }
        return false;
      }
      paramStreamInfo = paramStreamInfo.segmentInfos.iterator();
      while (paramStreamInfo.hasNext())
      {
        SegmentVideoInfo.SegmentInfo localSegmentInfo = (SegmentVideoInfo.SegmentInfo)paramStreamInfo.next();
        if (!this.proxy.isCached(localSegmentInfo.url)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public boolean isCached(String paramString)
  {
    return this.proxy.isCached(paramString);
  }
  
  public boolean preload(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    boolean bool1;
    if (getCachedBytesFromStart(paramString) < paramLong1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (getCachedBytesFromEnd(paramString) <= 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    StringBuilder localStringBuilder1;
    if ((!bool1) && (!bool2))
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("preloadSync skipped: url=");
      localStringBuilder1.append(paramString);
      PlayerUtils.log(4, "VideoManager", localStringBuilder1.toString());
      return false;
    }
    if (PlayerUtils.isHLSStream(paramString))
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("preloadSync skipped m3u8 is not supported: url=");
      localStringBuilder1.append(paramString);
      PlayerUtils.log(4, "VideoManager", localStringBuilder1.toString());
      return false;
    }
    try
    {
      this.proxy.preloadAsync(paramString, paramLong1, paramLong2, paramInt, bool1, bool2, null, null);
      return true;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("preloadSync error: url=");
      localStringBuilder2.append(paramString);
      localStringBuilder2.append(" msg=");
      localStringBuilder2.append(localException.getMessage());
      PlayerUtils.log(6, "VideoManager", localStringBuilder2.toString());
    }
    return true;
  }
  
  public boolean preload(String paramString, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean, DownloadListener paramDownloadListener)
  {
    boolean bool;
    if (getCachedBytesFromStart(paramString) < paramLong1) {
      bool = true;
    } else {
      bool = false;
    }
    if ((!paramBoolean) && (getCachedBytesFromEnd(paramString) <= 0L)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    if ((!bool) && (!paramBoolean))
    {
      paramDownloadListener = new StringBuilder();
      paramDownloadListener.append("preload_log 不需要预加载 preloadSync skipped: url=");
      paramDownloadListener.append(paramString);
      PlayerUtils.log(4, "VideoManager", paramDownloadListener.toString());
      return false;
    }
    if (PlayerUtils.isHLSStream(paramString))
    {
      paramDownloadListener = new StringBuilder();
      paramDownloadListener.append("preload_log preloadSync skipped m3u8 is not supported: url=");
      paramDownloadListener.append(paramString);
      PlayerUtils.log(4, "VideoManager", paramDownloadListener.toString());
      return false;
    }
    try
    {
      this.proxy.preloadAsync(paramString, paramLong1, paramLong2, paramInt, bool, paramBoolean, null, paramDownloadListener);
      return true;
    }
    catch (Exception paramDownloadListener)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preload_log preloadSync error: url=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" msg=");
      localStringBuilder.append(paramDownloadListener.getMessage());
      PlayerUtils.log(6, "VideoManager", localStringBuilder.toString());
    }
    return true;
  }
  
  public void preloadMedia(List<String> paramList, int paramInt, long paramLong, PreloadListener paramPreloadListener)
  {
    this.proxy.preloadMedia(paramList, paramInt, paramLong, paramPreloadListener);
  }
  
  public int probeContentFlag(String paramString)
  {
    return this.proxy.probeContentFlag(paramString);
  }
  
  public void removeCacheReadListener(String paramString)
  {
    this.proxy.removeCacheReadListener(paramString);
  }
  
  public void removeHttpErrorListener(String paramString)
  {
    this.proxy.removeHttpErrorListener(paramString);
  }
  
  public void removeHttpRetryLogic(String paramString)
  {
    this.proxy.removeHttpRetryLogic(paramString);
  }
  
  public void removeUuidErrorListener(String paramString)
  {
    this.proxy.removeUuidErrorListener(paramString);
  }
  
  public void setDataSourceBuilder(ITcDataSourceUtils paramITcDataSourceUtils)
  {
    this.proxy.setDataSourceBuilder(paramITcDataSourceUtils);
  }
  
  public void setLogger(QLog paramQLog)
  {
    PlayerConfig.g().setLogger(paramQLog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.VideoManager
 * JD-Core Version:    0.7.0.1
 */