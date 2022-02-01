package com.tencent.oskplayer.proxy;

import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.cache.CacheEvictor;
import com.tencent.oskplayer.cache.LeastRecentlyUsedCacheEvictor;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.util.StorageUtil;

class VideoProxy$1
  implements Runnable
{
  VideoProxy$1(VideoProxy paramVideoProxy, String paramString, long paramLong, CacheEvictor paramCacheEvictor) {}
  
  public void run()
  {
    long l2 = System.currentTimeMillis();
    try
    {
      l1 = StorageUtil.getDirUsedSpace(this.val$cacheDir);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      long l1;
      label15:
      StringBuilder localStringBuilder;
      break label15;
    }
    PlayerUtils.log(5, "VideoProxy", "calculate cacheSize OOM usedSpace set to 0");
    l1 = 0L;
    l1 = Math.min(this.val$availableSpace + l1, PlayerConfig.g().getCacheMaxBytes());
    ((LeastRecentlyUsedCacheEvictor)this.val$evictor).setMaxBytes(l1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("update cacheSize ");
    localStringBuilder.append(l1);
    localStringBuilder.append(", timecost=");
    localStringBuilder.append(System.currentTimeMillis() - l2);
    PlayerUtils.log(4, "VideoProxy", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.VideoProxy.1
 * JD-Core Version:    0.7.0.1
 */