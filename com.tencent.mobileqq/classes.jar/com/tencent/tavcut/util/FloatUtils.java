package com.tencent.tavcut.util;

public class FloatUtils
{
  public static boolean isEquals(double paramDouble1, double paramDouble2)
  {
    return Math.abs(paramDouble1 - paramDouble2) < 1.0E-013D;
  }
  
  public static boolean isEquals(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 1.0E-013D;
  }
  
  public static boolean isEqualsToZero(double paramDouble)
  {
    return Math.abs(paramDouble) < 1.0E-013D;
  }
  
  public static boolean isEqualsToZero(float paramFloat)
  {
    return Math.abs(paramFloat) < 1.0E-013D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.util.FloatUtils
 * JD-Core Version:    0.7.0.1
 */