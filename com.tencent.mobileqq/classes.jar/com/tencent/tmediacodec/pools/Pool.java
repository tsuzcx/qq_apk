package com.tencent.tmediacodec.pools;

import android.support.annotation.Nullable;

public abstract interface Pool<T, Y>
{
  public abstract void clear();
  
  public abstract boolean isEmpty();
  
  public abstract boolean isFull();
  
  @Nullable
  public abstract T obtain(Y paramY);
  
  public abstract void put(T paramT);
  
  public abstract void remove(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmediacodec.pools.Pool
 * JD-Core Version:    0.7.0.1
 */