package com.tencent.oskplayer.cache;

import android.os.ConditionVariable;
import android.text.TextUtils;
import com.tencent.oskplayer.proxy.FileType;
import com.tencent.oskplayer.util.Assertions;
import com.tencent.oskplayer.util.PlayerUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class SimpleCache
  implements Cache
{
  private static final String LOG_TAG = "SimpleCache";
  private final File cacheDir;
  private final HashMap<String, TreeSet<CacheSpan>> cachedSpans;
  private final CacheEvictor evictor;
  private final HashMap<String, ArrayList<Cache.Listener>> listeners;
  private final HashMap<String, CacheSpan> lockedSpans;
  private long totalSpace;
  
  public SimpleCache(File paramFile, CacheEvictor paramCacheEvictor)
  {
    this.cacheDir = paramFile;
    this.evictor = paramCacheEvictor;
    this.lockedSpans = new HashMap();
    this.cachedSpans = new HashMap();
    this.listeners = new HashMap();
    paramFile = new ConditionVariable();
    new SimpleCache.1(this, paramFile).start();
    paramFile.block();
  }
  
  private boolean addSpan(CacheSpan paramCacheSpan)
  {
    TreeSet localTreeSet2 = (TreeSet)this.cachedSpans.get(paramCacheSpan.key);
    TreeSet localTreeSet1 = localTreeSet2;
    if (localTreeSet2 == null)
    {
      localTreeSet1 = new TreeSet();
      this.cachedSpans.put(paramCacheSpan.key, localTreeSet1);
    }
    boolean bool = localTreeSet1.add(paramCacheSpan);
    this.totalSpace += paramCacheSpan.length;
    notifySpanAdded(paramCacheSpan);
    return bool;
  }
  
  private void deleteDir(File paramFile)
  {
    if (!paramFile.exists()) {
      return;
    }
    paramFile = paramFile.listFiles();
    if (paramFile == null) {
      return;
    }
    int i = 0;
    while (i < paramFile.length)
    {
      File localFile = paramFile[i];
      if (localFile.isDirectory()) {
        deleteDir(localFile);
      }
      localFile.delete();
      i += 1;
    }
  }
  
  private CacheSpan getSpan(CacheSpan paramCacheSpan)
  {
    String str = paramCacheSpan.key;
    long l = paramCacheSpan.position;
    Object localObject = (TreeSet)this.cachedSpans.get(str);
    if (localObject == null) {
      return CacheSpan.createOpenHole(str, paramCacheSpan.position);
    }
    CacheSpan localCacheSpan = (CacheSpan)((TreeSet)localObject).floor(paramCacheSpan);
    if ((localCacheSpan != null) && (localCacheSpan.position <= l) && (l < localCacheSpan.position + localCacheSpan.length))
    {
      if (localCacheSpan.file.exists()) {
        return localCacheSpan;
      }
      removeStaleSpans();
      return getSpan(paramCacheSpan);
    }
    localObject = (CacheSpan)((TreeSet)localObject).ceiling(paramCacheSpan);
    if (localObject == null) {
      return CacheSpan.createOpenHole(str, paramCacheSpan.position);
    }
    return CacheSpan.createClosedHole(str, paramCacheSpan.position, ((CacheSpan)localObject).position - paramCacheSpan.position);
  }
  
  private void initialize()
  {
    if (!this.cacheDir.exists()) {
      this.cacheDir.mkdirs();
    }
    File[] arrayOfFile = this.cacheDir.listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int i = 0;
    while (i < arrayOfFile.length)
    {
      Object localObject = arrayOfFile[i];
      if (((File)localObject).length() == 0L)
      {
        ((File)localObject).delete();
      }
      else
      {
        CacheSpan localCacheSpan = CacheSpan.createCacheEntry((File)localObject);
        if (localCacheSpan == null)
        {
          ((File)localObject).delete();
        }
        else if (!addSpan(localCacheSpan))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("remove duplicated span ");
          ((StringBuilder)localObject).append(localCacheSpan.file);
          PlayerUtils.log(3, "SimpleCache", ((StringBuilder)localObject).toString());
          removeSpan(localCacheSpan);
        }
      }
      i += 1;
    }
  }
  
  private void notifySpanAdded(CacheSpan paramCacheSpan)
  {
    ArrayList localArrayList = (ArrayList)this.listeners.get(paramCacheSpan.key);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((Cache.Listener)localArrayList.get(i)).onSpanAdded(this, paramCacheSpan);
        i -= 1;
      }
    }
    this.evictor.onSpanAdded(this, paramCacheSpan);
  }
  
  private void notifySpanRemoved(CacheSpan paramCacheSpan)
  {
    ArrayList localArrayList = (ArrayList)this.listeners.get(paramCacheSpan.key);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((Cache.Listener)localArrayList.get(i)).onSpanRemoved(this, paramCacheSpan);
        i -= 1;
      }
    }
    this.evictor.onSpanRemoved(this, paramCacheSpan);
  }
  
  private void notifySpanTouched(CacheSpan paramCacheSpan1, CacheSpan paramCacheSpan2)
  {
    ArrayList localArrayList = (ArrayList)this.listeners.get(paramCacheSpan1.key);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((Cache.Listener)localArrayList.get(i)).onSpanTouched(this, paramCacheSpan1, paramCacheSpan2);
        i -= 1;
      }
    }
    this.evictor.onSpanTouched(this, paramCacheSpan1, paramCacheSpan2);
  }
  
  private void removeStaleSpans()
  {
    Iterator localIterator1 = this.cachedSpans.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((TreeSet)((Map.Entry)localIterator1.next()).getValue()).iterator();
      int i = 1;
      while (localIterator2.hasNext())
      {
        CacheSpan localCacheSpan = (CacheSpan)localIterator2.next();
        if (!localCacheSpan.file.exists())
        {
          localIterator2.remove();
          if (localCacheSpan.isCached) {
            this.totalSpace -= localCacheSpan.length;
          }
          notifySpanRemoved(localCacheSpan);
        }
        else
        {
          i = 0;
        }
      }
      if (i != 0) {
        localIterator1.remove();
      }
    }
  }
  
  private CacheSpan startReadWriteNonBlocking(CacheSpan paramCacheSpan)
  {
    try
    {
      CacheSpan localCacheSpan = getSpan(paramCacheSpan);
      boolean bool = localCacheSpan.isCached;
      if (bool) {
        return localCacheSpan;
      }
      if (!this.lockedSpans.containsKey(paramCacheSpan.key))
      {
        this.lockedSpans.put(paramCacheSpan.key, localCacheSpan);
        return localCacheSpan;
      }
      return null;
    }
    finally {}
  }
  
  public NavigableSet<CacheSpan> addListener(String paramString, Cache.Listener paramListener)
  {
    try
    {
      ArrayList localArrayList2 = (ArrayList)this.listeners.get(paramString);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.listeners.put(paramString, localArrayList1);
      }
      localArrayList1.add(paramListener);
      paramString = getCachedSpans(paramString);
      return paramString;
    }
    finally {}
  }
  
  public void commitFile(File paramFile)
  {
    for (;;)
    {
      try
      {
        CacheSpan localCacheSpan = CacheSpan.createCacheEntry(paramFile);
        if (localCacheSpan != null)
        {
          bool = true;
          Assertions.checkState(bool);
          Assertions.checkState(this.lockedSpans.containsKey(localCacheSpan.key));
          bool = paramFile.exists();
          if (!bool) {
            return;
          }
          if (paramFile.length() == 0L)
          {
            paramFile.delete();
            return;
          }
          addSpan(localCacheSpan);
          notifyAll();
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void evictOneSpan()
  {
    try
    {
      if (this.evictor != null) {
        this.evictor.evictOne(this);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getCacheSpace()
  {
    try
    {
      long l = this.totalSpace;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getCachedBytesFromEnd(String paramString)
  {
    paramString = getCachedSpans(paramString);
    long l1 = 0L;
    long l2 = l1;
    if (paramString != null)
    {
      CacheSpan localCacheSpan = (CacheSpan)paramString.last();
      if ((localCacheSpan != null) && (localCacheSpan.isCached) && (localCacheSpan.totalLength >= 0L) && (localCacheSpan.position + localCacheSpan.length < localCacheSpan.totalLength)) {
        return 0L;
      }
      l2 = l1;
      if (localCacheSpan != null)
      {
        l2 = l1;
        if (localCacheSpan.totalLength >= 0L)
        {
          paramString = paramString.descendingSet().iterator();
          for (;;)
          {
            l2 = l1;
            if (!paramString.hasNext()) {
              break;
            }
            localCacheSpan = (CacheSpan)paramString.next();
            if (!localCacheSpan.isCached) {
              return l1;
            }
            l1 += localCacheSpan.length;
          }
        }
      }
    }
    return l2;
  }
  
  public long getCachedBytesFromStart(String paramString)
  {
    try
    {
      paramString = getCachedSpans(paramString);
      long l1 = 0L;
      long l2 = l1;
      if (paramString != null)
      {
        CacheSpan localCacheSpan = (CacheSpan)paramString.first();
        if ((localCacheSpan != null) && (localCacheSpan.isCached) && (localCacheSpan.totalLength >= 0L))
        {
          l2 = localCacheSpan.position;
          if (l2 != 0L) {
            return 0L;
          }
        }
        l2 = l1;
        if (localCacheSpan != null)
        {
          l2 = l1;
          if (localCacheSpan.totalLength >= 0L)
          {
            paramString = paramString.iterator();
            for (;;)
            {
              l2 = l1;
              if (!paramString.hasNext()) {
                break;
              }
              localCacheSpan = (CacheSpan)paramString.next();
              boolean bool = localCacheSpan.isCached;
              if (!bool) {
                return l1;
              }
              l2 = localCacheSpan.length;
              l1 += l2;
            }
          }
        }
      }
      return l2;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public double getCachedSizeRate(String paramString)
  {
    double d2 = 0.0D;
    try
    {
      paramString = getCachedSpans(paramString);
      double d1 = d2;
      if (paramString != null)
      {
        CacheSpan localCacheSpan = (CacheSpan)paramString.first();
        d1 = d2;
        if (localCacheSpan != null)
        {
          long l2 = localCacheSpan.totalLength;
          long l1 = 0L;
          d1 = d2;
          if (l2 > 0L)
          {
            l2 = localCacheSpan.totalLength;
            paramString = paramString.iterator();
            while (paramString.hasNext())
            {
              localCacheSpan = (CacheSpan)paramString.next();
              boolean bool = localCacheSpan.isCached;
              if (!bool)
              {
                d1 = l1;
                return d1;
              }
              long l3 = localCacheSpan.length;
              l1 += l3;
            }
            d1 = l1;
            d2 = l2;
            Double.isNaN(d1);
            Double.isNaN(d2);
            d1 /= d2;
          }
        }
      }
      return d1;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public NavigableSet<CacheSpan> getCachedSpans(String paramString)
  {
    try
    {
      paramString = (TreeSet)this.cachedSpans.get(paramString);
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = new TreeSet(paramString);
      }
      return paramString;
    }
    finally {}
  }
  
  public FileType getContentType(String paramString)
  {
    try
    {
      paramString = getCachedSpans(paramString);
      if (paramString != null)
      {
        paramString = (CacheSpan)paramString.first();
        if ((paramString != null) && (paramString.totalLength >= 0L))
        {
          paramString = paramString.fileType;
          return paramString;
        }
      }
      paramString = FileType.UNKNOWN;
      return paramString;
    }
    finally {}
  }
  
  public Set<String> getKeys()
  {
    try
    {
      HashSet localHashSet = new HashSet(this.cachedSpans.keySet());
      return localHashSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getRemainUnCachedBytes(String paramString)
  {
    long l3 = -1L;
    try
    {
      paramString = getCachedSpans(paramString);
      long l1 = l3;
      if (paramString != null)
      {
        CacheSpan localCacheSpan = (CacheSpan)paramString.first();
        l1 = l3;
        if (localCacheSpan != null)
        {
          long l4 = localCacheSpan.totalLength;
          long l2 = 0L;
          l1 = l3;
          if (l4 > 0L)
          {
            l3 = localCacheSpan.totalLength;
            paramString = paramString.iterator();
            for (l1 = l2; paramString.hasNext(); l1 += l2)
            {
              localCacheSpan = (CacheSpan)paramString.next();
              boolean bool = localCacheSpan.isCached;
              if (!bool) {
                return l1;
              }
              l2 = localCacheSpan.length;
            }
            l1 = l3 - l1;
          }
        }
      }
      return l1;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public long getTotalLength(String paramString)
  {
    try
    {
      paramString = getCachedSpans(paramString);
      if (paramString != null)
      {
        paramString = (CacheSpan)paramString.first();
        if ((paramString != null) && (paramString.totalLength >= 0L))
        {
          long l = paramString.totalLength;
          return l;
        }
      }
      return -1L;
    }
    finally {}
  }
  
  public boolean isCached(String paramString)
  {
    try
    {
      paramString = getCachedSpans(paramString);
      if (paramString != null)
      {
        CacheSpan localCacheSpan = (CacheSpan)paramString.first();
        if (localCacheSpan != null)
        {
          long l2 = localCacheSpan.totalLength;
          long l1 = 0L;
          if (l2 >= 0L)
          {
            l2 = localCacheSpan.totalLength;
            paramString = paramString.iterator();
            while (paramString.hasNext())
            {
              localCacheSpan = (CacheSpan)paramString.next();
              boolean bool = localCacheSpan.isCached;
              if (!bool) {
                return false;
              }
              long l3 = localCacheSpan.length;
              l1 += l3;
            }
            if (l1 >= l2) {
              return true;
            }
          }
        }
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public boolean isCached(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      Object localObject = (TreeSet)this.cachedSpans.get(paramString);
      if (localObject == null) {
        return false;
      }
      paramString = (CacheSpan)((TreeSet)localObject).floor(CacheSpan.createLookup(paramString, paramLong1));
      if ((paramString != null) && (paramString.position + paramString.length > paramLong1))
      {
        long l = paramLong1 + paramLong2;
        paramLong1 = paramString.position;
        paramLong2 = paramString.length;
        paramLong1 += paramLong2;
        if (paramLong1 >= l) {
          return true;
        }
        paramString = ((TreeSet)localObject).tailSet(paramString, false).iterator();
        while (paramString.hasNext())
        {
          localObject = (CacheSpan)paramString.next();
          paramLong2 = ((CacheSpan)localObject).position;
          if (paramLong2 > paramLong1) {
            return false;
          }
          paramLong2 = Math.max(paramLong1, ((CacheSpan)localObject).position + ((CacheSpan)localObject).length);
          paramLong1 = paramLong2;
          if (paramLong2 >= l) {
            return true;
          }
        }
        return false;
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void releaseHoleSpan(CacheSpan paramCacheSpan)
  {
    for (;;)
    {
      try
      {
        if (paramCacheSpan == this.lockedSpans.remove(paramCacheSpan.key))
        {
          bool = true;
          Assertions.checkState(bool);
          notifyAll();
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void removeAll()
  {
    try
    {
      Iterator localIterator1 = this.cachedSpans.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((TreeSet)((Map.Entry)localIterator1.next()).getValue()).iterator();
        while (localIterator2.hasNext())
        {
          CacheSpan localCacheSpan = (CacheSpan)localIterator2.next();
          localIterator2.remove();
          if (localCacheSpan.isCached) {
            this.totalSpace -= localCacheSpan.length;
          }
          notifySpanRemoved(localCacheSpan);
        }
        localIterator1.remove();
      }
      deleteDir(this.cacheDir);
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void removeByKey(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      paramString = getCachedSpans(paramString);
      if (paramString == null) {
        return;
      }
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        removeSpan((CacheSpan)paramString.next());
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void removeListener(String paramString, Cache.Listener paramListener)
  {
    try
    {
      ArrayList localArrayList = (ArrayList)this.listeners.get(paramString);
      if (localArrayList != null)
      {
        localArrayList.remove(paramListener);
        if (localArrayList.isEmpty()) {
          this.listeners.remove(paramString);
        }
      }
      return;
    }
    finally {}
  }
  
  public void removeSpan(CacheSpan paramCacheSpan)
  {
    try
    {
      TreeSet localTreeSet = (TreeSet)this.cachedSpans.get(paramCacheSpan.key);
      this.totalSpace -= paramCacheSpan.length;
      paramCacheSpan.file.delete();
      if ((localTreeSet == null) || (localTreeSet.isEmpty())) {
        this.cachedSpans.remove(paramCacheSpan.key);
      }
      notifySpanRemoved(paramCacheSpan);
      return;
    }
    finally {}
  }
  
  public File startFile(String paramString, long paramLong1, long paramLong2, FileType paramFileType, long paramLong3)
  {
    try
    {
      Assertions.checkState(this.lockedSpans.containsKey(paramString));
      if (!this.cacheDir.exists())
      {
        removeStaleSpans();
        this.cacheDir.mkdirs();
      }
      this.evictor.onStartFile(this, paramString, paramLong1, paramLong3);
      paramString = CacheSpan.getCacheFileName(this.cacheDir, paramString, paramLong1, paramLong2, paramFileType, System.currentTimeMillis());
      return paramString;
    }
    finally {}
  }
  
  public CacheSpan startReadWrite(String paramString, long paramLong)
  {
    try
    {
      paramString = CacheSpan.createLookup(paramString, paramLong);
      for (;;)
      {
        CacheSpan localCacheSpan = startReadWriteNonBlocking(paramString);
        if (localCacheSpan != null) {
          return localCacheSpan;
        }
        wait();
      }
      throw paramString;
    }
    finally {}
    for (;;) {}
  }
  
  public CacheSpan startReadWriteNonBlocking(String paramString, long paramLong)
  {
    try
    {
      paramString = startReadWriteNonBlocking(CacheSpan.createLookup(paramString, paramLong));
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.cache.SimpleCache
 * JD-Core Version:    0.7.0.1
 */