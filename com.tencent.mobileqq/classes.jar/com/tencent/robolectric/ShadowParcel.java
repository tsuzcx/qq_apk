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
  
  public static void a(int paramInt, double paramDouble)
  {
    a(paramInt, paramDouble);
  }
  
  public static void a(int paramInt, float paramFloat)
  {
    a(paramInt, paramFloat);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
  
  public static void a(int paramInt, long paramLong)
  {
    a(paramInt, paramLong);
  }
  
  public static void a(int paramInt, String paramString)
  {
    a(paramInt, paramString);
  }
  
  public static void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  protected static void a(long paramLong, double paramDouble)
  {
    ((ShadowParcel.ByteBuffer)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong))).a(paramDouble);
  }
  
  protected static void a(long paramLong, float paramFloat)
  {
    ((ShadowParcel.ByteBuffer)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong))).a(paramFloat);
  }
  
  protected static void a(long paramLong, int paramInt)
  {
    ((ShadowParcel.ByteBuffer)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong))).b(paramInt);
  }
  
  protected static void a(long paramLong1, long paramLong2)
  {
    ((ShadowParcel.ByteBuffer)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong1))).a(paramLong2);
  }
  
  protected static void a(long paramLong, String paramString)
  {
    ((ShadowParcel.ByteBuffer)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong))).a(paramString);
  }
  
  protected static void a(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ((ShadowParcel.ByteBuffer)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong))).a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static byte[] a(int paramInt)
  {
    return a(paramInt);
  }
  
  protected static byte[] a(long paramLong)
  {
    return ((ShadowParcel.ByteBuffer)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong))).a();
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
  }
  
  protected static void b(long paramLong, int paramInt)
  {
    ((ShadowParcel.ByteBuffer)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong))).a(paramInt);
  }
  
  public static void b(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a(paramLong, paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.robolectric.ShadowParcel
 * JD-Core Version:    0.7.0.1
 */