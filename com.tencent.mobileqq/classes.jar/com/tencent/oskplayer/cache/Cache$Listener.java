package com.tencent.oskplayer.cache;

public abstract interface Cache$Listener
{
  public abstract void onSpanAdded(Cache paramCache, CacheSpan paramCacheSpan);
  
  public abstract void onSpanRemoved(Cache paramCache, CacheSpan paramCacheSpan);
  
  public abstract void onSpanTouched(Cache paramCache, CacheSpan paramCacheSpan1, CacheSpan paramCacheSpan2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.oskplayer.cache.Cache.Listener
 * JD-Core Version:    0.7.0.1
 */