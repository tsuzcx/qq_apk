package com.tencent.thumbplayer.utils;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class LocalCache$ACacheManager
{
  private final AtomicInteger cacheCount;
  protected File cacheDir;
  private final AtomicLong cacheSize;
  private final int countLimit;
  private final Map<File, Long> lastUsageDates = Collections.synchronizedMap(new HashMap());
  private final long sizeLimit;
  
  private LocalCache$ACacheManager(File paramFile, long paramLong, int paramInt)
  {
    this.cacheDir = paramFile;
    this.sizeLimit = paramLong;
    this.countLimit = paramInt;
    this.cacheSize = new AtomicLong();
    this.cacheCount = new AtomicInteger();
    calculateCacheSizeAndCacheCount();
  }
  
  private void calculateCacheSizeAndCacheCount()
  {
    TPThreadUtil.THREAD_POOL_EXECUTOR.execute(new LocalCache.ACacheManager.1(this));
  }
  
  private long calculateSize(File paramFile)
  {
    if (paramFile == null) {
      return 0L;
    }
    return paramFile.length();
  }
  
  private void clear()
  {
    this.lastUsageDates.clear();
    this.cacheSize.set(0L);
    File[] arrayOfFile = this.cacheDir.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        arrayOfFile[i].delete();
        i += 1;
      }
    }
  }
  
  private File get(String paramString)
  {
    paramString = newFile(paramString);
    Long localLong = Long.valueOf(System.currentTimeMillis());
    paramString.setLastModified(localLong.longValue());
    this.lastUsageDates.put(paramString, localLong);
    return paramString;
  }
  
  private File newFile(String paramString)
  {
    return new File(this.cacheDir, paramString.hashCode() + "");
  }
  
  private void put(File paramFile)
  {
    for (int i = this.cacheCount.get(); i + 1 > this.countLimit; i = this.cacheCount.addAndGet(-1))
    {
      l1 = removeNext();
      this.cacheSize.addAndGet(-l1);
    }
    this.cacheCount.addAndGet(1);
    long l2 = calculateSize(paramFile);
    for (long l1 = this.cacheSize.get(); l1 + l2 > this.sizeLimit; l1 = this.cacheSize.addAndGet(-l1)) {
      l1 = removeNext();
    }
    this.cacheSize.addAndGet(l2);
    Long localLong = Long.valueOf(System.currentTimeMillis());
    paramFile.setLastModified(localLong.longValue());
    this.lastUsageDates.put(paramFile, localLong);
  }
  
  private boolean remove(String paramString)
  {
    return get(paramString).delete();
  }
  
  private long removeNext()
  {
    File localFile = null;
    long l1;
    if (this.lastUsageDates.isEmpty())
    {
      l1 = 0L;
      return l1;
    }
    Object localObject1 = this.lastUsageDates.entrySet();
    label206:
    for (;;)
    {
      synchronized (this.lastUsageDates)
      {
        Iterator localIterator = ((Set)localObject1).iterator();
        localObject1 = null;
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (localFile == null)
          {
            localFile = (File)localEntry.getKey();
            localObject1 = (Long)localEntry.getValue();
            break label206;
          }
          Long localLong = (Long)localEntry.getValue();
          if (localLong.longValue() >= ((Long)localObject1).longValue()) {
            break label206;
          }
          localFile = (File)localEntry.getKey();
          localObject1 = localLong;
          break label206;
        }
        if (localFile == null) {
          return 0L;
        }
      }
      long l2 = calculateSize(localFile);
      l1 = l2;
      if (localFile == null) {
        break;
      }
      l1 = l2;
      if (!localFile.delete()) {
        break;
      }
      this.lastUsageDates.remove(localFile);
      return l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.LocalCache.ACacheManager
 * JD-Core Version:    0.7.0.1
 */