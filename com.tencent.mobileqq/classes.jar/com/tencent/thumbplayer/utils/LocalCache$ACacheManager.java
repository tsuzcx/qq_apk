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
    File localFile = this.cacheDir;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.hashCode());
    localStringBuilder.append("");
    return new File(localFile, localStringBuilder.toString());
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
    if (this.lastUsageDates.isEmpty()) {
      return 0L;
    }
    Object localObject1 = this.lastUsageDates.entrySet();
    synchronized (this.lastUsageDates)
    {
      Iterator localIterator = ((Set)localObject1).iterator();
      localObject1 = null;
      Object localObject3 = null;
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localObject1 == null)
        {
          localObject1 = (File)localEntry.getKey();
          localObject3 = (Long)localEntry.getValue();
        }
        else
        {
          Long localLong = (Long)localEntry.getValue();
          if (localLong.longValue() < ((Long)localObject3).longValue())
          {
            localObject1 = (File)localEntry.getKey();
            localObject3 = localLong;
          }
        }
      }
      if (localObject1 == null) {
        return 0L;
      }
      long l = calculateSize((File)localObject1);
      if ((localObject1 != null) && (((File)localObject1).delete())) {
        this.lastUsageDates.remove(localObject1);
      }
      return l;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.LocalCache.ACacheManager
 * JD-Core Version:    0.7.0.1
 */