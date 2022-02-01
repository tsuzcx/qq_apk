package com.tencent.mobileqq.msf.core.net.utils;

import java.util.Random;

public class h
{
  private static final String a = "RandomUtils";
  private static final Random b = new Random(System.currentTimeMillis());
  
  public static double a(double paramDouble1, double paramDouble2)
  {
    if (paramDouble1 == paramDouble2) {
      return paramDouble1;
    }
    return paramDouble1 + (paramDouble2 - paramDouble1) * b.nextDouble();
  }
  
  public static float a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 == paramFloat2) {
      return paramFloat1;
    }
    return paramFloat1 + (paramFloat2 - paramFloat1) * b.nextFloat();
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return paramInt1;
    }
    return paramInt1 + b.nextInt(paramInt2 - paramInt1);
  }
  
  public static long a(long paramLong1, long paramLong2)
  {
    if (paramLong1 == paramLong2) {
      return paramLong1;
    }
    return a(paramLong1, paramLong2);
  }
  
  public static boolean a()
  {
    return b.nextBoolean();
  }
  
  public static byte[] a(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    b.nextBytes(arrayOfByte);
    return arrayOfByte;
  }
  
  public static int b()
  {
    return a(0, 2147483647);
  }
  
  public static long c()
  {
    return a(0L, 9223372036854775807L);
  }
  
  public static double d()
  {
    return a(0.0D, 1.7976931348623157E+308D);
  }
  
  public static float e()
  {
    return a(0.0F, 3.4028235E+38F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.h
 * JD-Core Version:    0.7.0.1
 */