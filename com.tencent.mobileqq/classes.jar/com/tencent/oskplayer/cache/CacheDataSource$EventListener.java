package com.tencent.oskplayer.cache;

public abstract interface CacheDataSource$EventListener
{
  public abstract void downloadSizeAndDuration(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void onCachedAttrRead(long paramLong);
  
  public abstract void onCachedBytesRead(long paramLong1, long paramLong2);
  
  public abstract void onHttpUpstreamServerCost(String paramString, long paramLong1, long paramLong2, long paramLong3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.cache.CacheDataSource.EventListener
 * JD-Core Version:    0.7.0.1
 */