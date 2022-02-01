package com.tribe.async.objectpool;

public abstract interface ObjectPool$Allocator<T>
{
  public abstract T create();
  
  public abstract void onAllocate(T paramT);
  
  public abstract void onRelease(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tribe.async.objectpool.ObjectPool.Allocator
 * JD-Core Version:    0.7.0.1
 */