package com.tribe.async.objectpool;

import com.tribe.async.utils.MonotonicClock;
import java.util.HashMap;

public class ObjectPoolManager
{
  private final MonotonicClock mClock;
  private final HashMap<Class, ObjectPool> mObjectPools = new HashMap();
  
  public ObjectPoolManager(MonotonicClock paramMonotonicClock)
  {
    this.mClock = paramMonotonicClock;
  }
  
  <T> void addPool(Class<T> paramClass, ObjectPool<T> paramObjectPool)
  {
    this.mObjectPools.put(paramClass, paramObjectPool);
  }
  
  public <T> T allocate(Class<T> paramClass)
  {
    paramClass = getPool(paramClass);
    if (paramClass != null) {
      return paramClass.allocate();
    }
    return null;
  }
  
  public <T> ObjectPoolBuilder<T> createPoolBuilder(Class<T> paramClass)
  {
    return new ObjectPoolBuilder(this, paramClass, this.mClock);
  }
  
  public <T> ObjectPool<T> getPool(Class<T> paramClass)
  {
    return (ObjectPool)this.mObjectPools.get(paramClass);
  }
  
  public <T> void release(Class<T> paramClass, T paramT)
  {
    paramClass = getPool(paramClass);
    if (paramClass != null) {
      paramClass.release(paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.objectpool.ObjectPoolManager
 * JD-Core Version:    0.7.0.1
 */