package com.tencent.mobileqq.search.base.util;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ObjectTransfer
{
  public static ObjectTransfer a = new ObjectTransfer();
  public long b = 0L;
  public Map<Long, WeakReference<Object>> c = new ConcurrentHashMap();
  
  public static ObjectTransfer a()
  {
    return a;
  }
  
  public long a(Object paramObject)
  {
    if (paramObject == null) {
      return -9223372036854775808L;
    }
    try
    {
      long l = this.b;
      this.b = (1L + l);
      this.c.put(Long.valueOf(l), new WeakReference(paramObject));
      return l;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public Object a(long paramLong)
  {
    try
    {
      Object localObject1 = (WeakReference)this.c.get(Long.valueOf(paramLong));
      if (localObject1 != null)
      {
        localObject1 = ((WeakReference)localObject1).get();
        return localObject1;
      }
      return null;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.util.ObjectTransfer
 * JD-Core Version:    0.7.0.1
 */