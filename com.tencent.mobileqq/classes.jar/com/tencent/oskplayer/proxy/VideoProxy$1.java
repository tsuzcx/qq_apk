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
    long l1 = 0L;
    long l3 = System.currentTimeMillis();
    try
    {
      long l2 = StorageUtil.getDirUsedSpace(this.val$cacheDir);
      l1 = l2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        PlayerUtils.log(5, "VideoProxy", "calculate cacheSize OOM usedSpace set to 0");
      }
    }
    l1 = Math.min(l1 + this.val$availableSpace, PlayerConfig.g().getCacheMaxBytes());
    ((LeastRecentlyUsedCacheEvictor)this.val$evictor).setMaxBytes(l1);
    PlayerUtils.log(4, "VideoProxy", "update cacheSize " + l1 + ", timecost=" + (System.currentTimeMillis() - l3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.VideoProxy.1
 * JD-Core Version:    0.7.0.1
 */