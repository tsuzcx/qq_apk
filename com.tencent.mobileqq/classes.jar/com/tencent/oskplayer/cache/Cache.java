package com.tencent.oskplayer.cache;

import com.tencent.oskplayer.proxy.FileType;
import java.io.File;
import java.util.NavigableSet;
import java.util.Set;

public abstract interface Cache
{
  public abstract NavigableSet<CacheSpan> addListener(String paramString, Cache.Listener paramListener);
  
  public abstract void commitFile(File paramFile);
  
  public abstract void evictOneSpan();
  
  public abstract long getCacheSpace();
  
  public abstract long getCachedBytesFromEnd(String paramString);
  
  public abstract long getCachedBytesFromStart(String paramString);
  
  public abstract double getCachedSizeRate(String paramString);
  
  public abstract NavigableSet<CacheSpan> getCachedSpans(String paramString);
  
  public abstract FileType getContentType(String paramString);
  
  public abstract Set<String> getKeys();
  
  public abstract long getRemainUnCachedBytes(String paramString);
  
  public abstract long getTotalLength(String paramString);
  
  public abstract boolean isCached(String paramString);
  
  public abstract boolean isCached(String paramString, long paramLong1, long paramLong2);
  
  public abstract void releaseHoleSpan(CacheSpan paramCacheSpan);
  
  public abstract void removeAll();
  
  public abstract void removeByKey(String paramString);
  
  public abstract void removeListener(String paramString, Cache.Listener paramListener);
  
  public abstract void removeSpan(CacheSpan paramCacheSpan);
  
  public abstract File startFile(String paramString, long paramLong1, long paramLong2, FileType paramFileType, long paramLong3);
  
  public abstract CacheSpan startReadWrite(String paramString, long paramLong);
  
  public abstract CacheSpan startReadWriteNonBlocking(String paramString, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.cache.Cache
 * JD-Core Version:    0.7.0.1
 */