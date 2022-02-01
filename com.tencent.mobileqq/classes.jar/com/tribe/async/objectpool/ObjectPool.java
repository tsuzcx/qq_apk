package com.tribe.async.objectpool;

import com.tribe.async.log.SLog;
import com.tribe.async.utils.MonotonicClock;
import java.lang.reflect.Array;

public class ObjectPool<T>
{
  private static final String TAG = "async.ObjectPool";
  private final ObjectPool.Allocator<T> mAllocator;
  private final Class<T> mClazz;
  private final MonotonicClock mClock;
  private final long mCompactionDelayMs;
  private final int mIncrementSize;
  private long mLastLowSupplyTimeMs;
  private final int mMaxSize;
  private final int mMinSize;
  private T[] mPool;
  private int mSize;
  
  public ObjectPool(Class<T> paramClass, int paramInt1, int paramInt2, int paramInt3, long paramLong, ObjectPool.Allocator<T> paramAllocator, MonotonicClock paramMonotonicClock)
  {
    this.mClazz = paramClass;
    this.mMinSize = Math.max(paramInt1, 0);
    this.mMaxSize = Math.max(this.mMinSize, paramInt2);
    this.mIncrementSize = Math.max(paramInt3, 1);
    this.mCompactionDelayMs = paramLong;
    this.mAllocator = paramAllocator;
    this.mClock = paramMonotonicClock;
    this.mPool = ((Object[])Array.newInstance(this.mClazz, this.mMinSize));
  }
  
  private void resizePool(int paramInt)
  {
    Object[] arrayOfObject1 = (Object[])Array.newInstance(this.mClazz, paramInt);
    Object[] arrayOfObject2 = this.mPool;
    System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, Math.min(arrayOfObject2.length, paramInt));
    this.mPool = arrayOfObject1;
    this.mSize = Math.min(this.mSize, paramInt);
  }
  
  public T allocate()
  {
    try
    {
      Object localObject1;
      if (this.mSize > 0)
      {
        this.mSize -= 1;
        localObject1 = this.mPool[this.mSize];
        this.mPool[this.mSize] = null;
      }
      else
      {
        localObject1 = this.mAllocator.create();
      }
      this.mAllocator.onAllocate(localObject1);
      return localObject1;
    }
    finally {}
  }
  
  public void checkUsage()
  {
    try
    {
      long l = this.mClock.now();
      if (this.mSize < this.mIncrementSize * 2) {
        this.mLastLowSupplyTimeMs = l;
      }
      if (l - this.mLastLowSupplyTimeMs > this.mCompactionDelayMs)
      {
        SLog.d("async.ObjectPool", "ObjectPool.checkUsage is compacting the pool.");
        compactUsage();
      }
      return;
    }
    finally {}
  }
  
  public void compactUsage()
  {
    try
    {
      int i = Math.max(this.mPool.length - this.mIncrementSize, this.mMinSize);
      if (i != this.mPool.length) {
        resizePool(i);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getCompactionDelayMs()
  {
    return this.mCompactionDelayMs;
  }
  
  public int getIncrementSize()
  {
    return this.mIncrementSize;
  }
  
  public int getMaximumSize()
  {
    return this.mMaxSize;
  }
  
  public int getMinimumSize()
  {
    return this.mMinSize;
  }
  
  public int getPoolSize()
  {
    return this.mPool.length;
  }
  
  public int getPooledObjectCount()
  {
    return this.mSize;
  }
  
  public void release(T paramT)
  {
    try
    {
      checkUsage();
      this.mAllocator.onRelease(paramT);
      if (this.mSize < this.mMaxSize)
      {
        if (this.mSize + 1 > this.mPool.length) {
          resizePool(Math.min(this.mMaxSize, this.mPool.length + this.mIncrementSize));
        }
        Object[] arrayOfObject = this.mPool;
        int i = this.mSize;
        this.mSize = (i + 1);
        arrayOfObject[i] = paramT;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.objectpool.ObjectPool
 * JD-Core Version:    0.7.0.1
 */