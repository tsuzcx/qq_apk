package com.tencent.mobileqq.utils;

import java.util.Random;

public class RandomUtils
{
  private static final Random a = new Random();
  
  public static double a(double paramDouble1, double paramDouble2)
  {
    if (paramDouble1 == paramDouble2) {
      return paramDouble1;
    }
    return paramDouble1 + (paramDouble2 - paramDouble1) * a.nextDouble();
  }
  
  public static float a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 == paramFloat2) {
      return paramFloat1;
    }
    return paramFloat1 + (paramFloat2 - paramFloat1) * a.nextFloat();
  }
  
  public static long a()
  {
    return a(0L, 9223372036854775807L);
  }
  
  public static long a(long paramLong1, long paramLong2)
  {
    if (paramLong1 == paramLong2) {
      return paramLong1;
    }
    return a(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.RandomUtils
 * JD-Core Version:    0.7.0.1
 */