package com.tencent.robolectric;

import java.util.LinkedHashMap;
import java.util.Map;

public class ShadowParcel
{
  private static final Map<Long, ShadowParcel.ByteBuffer> a = new LinkedHashMap();
  private static long b = 1L;
  
  public static Number a()
  {
    try
    {
      long l = b;
      b = 1L + l;
      a.put(Long.valueOf(l), new ShadowParcel.ByteBuffer());
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
    return b(paramInt);
  }
  
  protected static byte[] b(long paramLong)
  {
    return ((ShadowParcel.ByteBuffer)a.get(Long.valueOf(paramLong))).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.robolectric.ShadowParcel
 * JD-Core Version:    0.7.0.1
 */