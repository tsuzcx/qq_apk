package com.tencent.mobileqq.search.base.util;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ObjectTransfer
{
  public static ObjectTransfer a;
  public long a;
  public Map<Long, WeakReference<Object>> a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqSearchBaseUtilObjectTransfer = new ObjectTransfer();
  }
  
  private ObjectTransfer()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  public static ObjectTransfer a()
  {
    return jdField_a_of_type_ComTencentMobileqqSearchBaseUtilObjectTransfer;
  }
  
  public long a(Object paramObject)
  {
    if (paramObject == null) {
      return -9223372036854775808L;
    }
    try
    {
      long l = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = (1L + l);
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), new WeakReference(paramObject));
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
      Object localObject1 = (WeakReference)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.util.ObjectTransfer
 * JD-Core Version:    0.7.0.1
 */