package com.tencent.mobileqq.vas;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AvatarPendantManager$LruLinkedHashMap<K, V>
  extends LinkedHashMap<K, V>
{
  private static final long serialVersionUID = 1L;
  private final Lock lock = new ReentrantLock();
  protected final int maxCapacity;
  
  public AvatarPendantManager$LruLinkedHashMap(int paramInt)
  {
    super(paramInt, 0.75F, true);
    this.maxCapacity = paramInt;
  }
  
  public V get(Object paramObject)
  {
    try
    {
      this.lock.lock();
      paramObject = super.get(paramObject);
      return paramObject;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public V put(K paramK, V paramV)
  {
    try
    {
      this.lock.lock();
      paramK = super.put(paramK, paramV);
      return paramK;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
  {
    return size() > this.maxCapacity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.AvatarPendantManager.LruLinkedHashMap
 * JD-Core Version:    0.7.0.1
 */