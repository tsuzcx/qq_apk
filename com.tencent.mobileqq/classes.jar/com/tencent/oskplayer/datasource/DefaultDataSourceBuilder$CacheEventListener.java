package com.tencent.oskplayer.datasource;

import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.cache.CacheDataSource.EventListener;
import com.tencent.oskplayer.report.IVideoReporter;

public class DefaultDataSourceBuilder$CacheEventListener
  implements CacheDataSource.EventListener
{
  public DefaultDataSourceBuilder$CacheEventListener(DefaultDataSourceBuilder paramDefaultDataSourceBuilder) {}
  
  public void downloadSizeAndDuration(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    if (PlayerConfig.g().getVideoReporter() != null) {
      PlayerConfig.g().getVideoReporter().downloadSizeAndDuration(paramString, paramInt, paramLong1, paramLong2, paramLong3);
    }
  }
  
  public void onCachedAttrRead(long paramLong)
  {
    if (PlayerConfig.g().getVideoReporter() != null) {
      PlayerConfig.g().getVideoReporter().preLoadOccurred(null, paramLong);
    }
  }
  
  public void onCachedBytesRead(long paramLong1, long paramLong2) {}
  
  public void onHttpUpstreamServerCost(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    if (PlayerConfig.g().getVideoReporter() != null) {
      PlayerConfig.g().getVideoReporter().downloadServerCost(paramString, paramLong1, paramLong2, paramLong3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.DefaultDataSourceBuilder.CacheEventListener
 * JD-Core Version:    0.7.0.1
 */