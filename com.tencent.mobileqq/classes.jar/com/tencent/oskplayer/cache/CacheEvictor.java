package com.tencent.oskplayer.cache;

public abstract interface CacheEvictor
  extends Cache.Listener
{
  public abstract void evictOne(Cache paramCache);
  
  public abstract void onStartFile(Cache paramCache, String paramString, long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.cache.CacheEvictor
 * JD-Core Version:    0.7.0.1
 */