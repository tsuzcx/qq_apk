package com.tencent.ttpic.cache;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ImageMemoryCache<K, V>
{
  private final ConcurrentHashMap<K, V> map;
  private long maxSize;
  private long size;
  
  public ImageMemoryCache(long paramLong)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    this.maxSize = paramLong;
    this.map = new ConcurrentHashMap();
  }
  
  private void trimToSize(long paramLong)
  {
    for (;;)
    {
      if (paramLong < 0L) {}
      try
      {
        this.map.clear();
        this.size = 0L;
        return;
      }
      finally {}
      if ((this.size < 0L) || ((this.map.isEmpty()) && (this.size != 0L))) {
        throw new IllegalStateException("imageMemoryCache trimToSize Exception!");
      }
      if ((this.size <= paramLong) || (this.map.isEmpty())) {
        return;
      }
      clearValue();
    }
  }
  
  public void clearValue() {}
  
  public boolean containsKey(K paramK)
  {
    return this.map.containsKey(paramK);
  }
  
  public int elementSize()
  {
    if (this.map != null) {
      return this.map.size();
    }
    return 0;
  }
  
  public final void evictAll()
  {
    trimToSize(-1L);
  }
  
  public V get(K paramK)
  {
    if (paramK == null) {
      return null;
    }
    try
    {
      paramK = this.map.get(paramK);
      return paramK;
    }
    finally {}
  }
  
  public long getAllocateSize()
  {
    return this.size;
  }
  
  public long getMaxSize()
  {
    return this.maxSize;
  }
  
  public Set<K> keySet()
  {
    return this.map.keySet();
  }
  
  public V put(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      throw new NullPointerException("key == null || value == null");
    }
    try
    {
      this.size += sizeOf(paramK, paramV);
      paramV = this.map.put(paramK, paramV);
      if (paramV != null) {
        this.size -= sizeOf(paramK, paramV);
      }
      trimToSize(this.maxSize);
      return paramV;
    }
    finally {}
  }
  
  public V remove(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    try
    {
      Object localObject = this.map.remove(paramK);
      if (localObject != null) {
        this.size -= sizeOf(paramK, localObject);
      }
      return localObject;
    }
    finally {}
  }
  
  public void resize(long paramLong)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    try
    {
      this.maxSize = paramLong;
      trimToSize(paramLong);
      return;
    }
    finally {}
  }
  
  public long sizeOf(K paramK, V paramV)
  {
    return 1L;
  }
  
  public Collection<V> values()
  {
    return this.map.values();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.cache.ImageMemoryCache
 * JD-Core Version:    0.7.0.1
 */