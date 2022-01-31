package com.tencent.mobileqq.util;

import android.support.v4.util.LruCache;

public class CustomLruCache<K, V>
  extends LruCache<K, V>
{
  public CustomLruCache(int paramInt)
  {
    super(paramInt);
  }
  
  public V create(K paramK)
  {
    return super.create(paramK);
  }
  
  public void entryRemoved(boolean paramBoolean, K paramK, V paramV1, V paramV2)
  {
    super.entryRemoved(paramBoolean, paramK, paramV1, paramV2);
  }
  
  public int sizeOf(K paramK, V paramV)
  {
    return super.sizeOf(paramK, paramV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.CustomLruCache
 * JD-Core Version:    0.7.0.1
 */