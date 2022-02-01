package com.tencent.robolectric;

import java.util.LinkedHashMap;
import java.util.Map;

public class ShadowParcel
{
  private static long jdField_a_of_type_Long = 1L;
  private static final Map<Long, ShadowParcel.ByteBuffer> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  
  public static Number a()
  {
    try
    {
      long l = jdField_a_of_type_Long;
      jdField_a_of_type_Long = 1L + l;
      jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), new ShadowParcel.ByteBuffer());
      Number localNumber = a(l);
      return localNumber;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static Number a(long paramLong)
  {
    return Long.valueOf(paramLong);
  }
  
  public static byte[] a(int paramInt)
  {
    return a(paramInt);
  }
  
  protected static byte[] a(long paramLong)
  {
    return ((ShadowParcel.ByteBuffer)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong))).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.robolectric.ShadowParcel
 * JD-Core Version:    0.7.0.1
 */