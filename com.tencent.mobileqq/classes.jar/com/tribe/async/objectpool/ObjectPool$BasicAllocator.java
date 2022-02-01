package com.tribe.async.objectpool;

import com.tribe.async.log.SLog;

public class ObjectPool$BasicAllocator<T>
  implements ObjectPool.Allocator<T>
{
  Class<T> mClazz;
  
  public ObjectPool$BasicAllocator(Class<T> paramClass)
  {
    this.mClazz = paramClass;
  }
  
  public T create()
  {
    try
    {
      Object localObject = this.mClazz.newInstance();
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      SLog.e("async.ObjectPool", "Couldn't instantiate object", localIllegalAccessException);
    }
    catch (InstantiationException localInstantiationException)
    {
      SLog.e("async.ObjectPool", "Couldn't instantiate object", localInstantiationException);
    }
    return null;
  }
  
  public void onAllocate(T paramT) {}
  
  public void onRelease(T paramT) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.objectpool.ObjectPool.BasicAllocator
 * JD-Core Version:    0.7.0.1
 */