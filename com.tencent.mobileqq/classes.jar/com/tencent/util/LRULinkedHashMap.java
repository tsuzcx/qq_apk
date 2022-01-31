package com.tencent.util;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRULinkedHashMap<K, V>
  extends LinkedHashMap<K, V>
{
  private static final long serialVersionUID = 1L;
  private final int maxCapacity;
  
  public LRULinkedHashMap(int paramInt)
  {
    super(paramInt, 0.75F, true);
    this.maxCapacity = paramInt;
  }
  
  protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
  {
    return size() > this.maxCapacity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.util.LRULinkedHashMap
 * JD-Core Version:    0.7.0.1
 */