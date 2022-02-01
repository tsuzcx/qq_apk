package com.tribe.async.objectpool;

import android.support.annotation.Nullable;
import com.tribe.async.utils.MonotonicClock;

public class ObjectPoolBuilder<T>
{
  public static final long DEFAULT_COMPACTION_DELAY_MS = 60000L;
  public static final int DEFAULT_INCREMENT_SIZE = 16;
  public static final int DEFAULT_MAX_SIZE = 1024;
  public static final int DEFAULT_MIN_SIZE = 16;
  private ObjectPool.Allocator<T> mAllocator;
  private Class<T> mClazz;
  private MonotonicClock mClock;
  private long mCompactionDelayMs = 60000L;
  private int mIncrementSize = 16;
  private final ObjectPoolManager mManager;
  private int mMaxSize = 1024;
  private int mMinSize = 16;
  
  ObjectPoolBuilder(@Nullable ObjectPoolManager paramObjectPoolManager, Class<T> paramClass, MonotonicClock paramMonotonicClock)
  {
    this.mManager = paramObjectPoolManager;
    this.mClazz = paramClass;
    this.mClock = paramMonotonicClock;
  }
  
  public ObjectPoolBuilder(Class<T> paramClass, MonotonicClock paramMonotonicClock)
  {
    this(null, paramClass, paramMonotonicClock);
  }
  
  public ObjectPool<T> build()
  {
    if (this.mClock != null)
    {
      Object localObject2 = this.mAllocator;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ObjectPool.BasicAllocator(this.mClazz);
      }
      localObject1 = new ObjectPool(this.mClazz, this.mMinSize, this.mMaxSize, this.mIncrementSize, this.mCompactionDelayMs, (ObjectPool.Allocator)localObject1, this.mClock);
      localObject2 = this.mManager;
      if (localObject2 != null) {
        ((ObjectPoolManager)localObject2).addPool(this.mClazz, (ObjectPool)localObject1);
      }
      return localObject1;
    }
    throw new IllegalArgumentException("Must add a clock to the object pool builder");
  }
  
  public ObjectPool.Allocator<T> getAllocator()
  {
    return this.mAllocator;
  }
  
  public MonotonicClock getClock()
  {
    return this.mClock;
  }
  
  public long getCompactionDelay()
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
  
  public ObjectPoolBuilder<T> setAllocator(ObjectPool.Allocator<T> paramAllocator)
  {
    this.mAllocator = paramAllocator;
    return this;
  }
  
  public ObjectPoolBuilder<T> setClock(MonotonicClock paramMonotonicClock)
  {
    this.mClock = paramMonotonicClock;
    return this;
  }
  
  public ObjectPoolBuilder<T> setCompactionDelay(long paramLong)
  {
    this.mCompactionDelayMs = paramLong;
    return this;
  }
  
  public ObjectPoolBuilder<T> setIncrementSize(int paramInt)
  {
    this.mIncrementSize = paramInt;
    return this;
  }
  
  public ObjectPoolBuilder<T> setMaximumSize(int paramInt)
  {
    this.mMaxSize = paramInt;
    return this;
  }
  
  public ObjectPoolBuilder<T> setMinimumSize(int paramInt)
  {
    this.mMinSize = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tribe.async.objectpool.ObjectPoolBuilder
 * JD-Core Version:    0.7.0.1
 */