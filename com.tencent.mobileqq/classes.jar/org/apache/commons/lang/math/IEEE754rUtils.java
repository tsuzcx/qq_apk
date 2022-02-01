package org.apache.commons.lang.math;

public class IEEE754rUtils
{
  public static double max(double paramDouble1, double paramDouble2)
  {
    if (Double.isNaN(paramDouble1)) {
      return paramDouble2;
    }
    if (Double.isNaN(paramDouble2)) {
      return paramDouble1;
    }
    return Math.max(paramDouble1, paramDouble2);
  }
  
  public static double max(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return max(max(paramDouble1, paramDouble2), paramDouble3);
  }
  
  public static double max(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble != null)
    {
      if (paramArrayOfDouble.length != 0)
      {
        double d = paramArrayOfDouble[0];
        int i = 1;
        while (i < paramArrayOfDouble.length)
        {
          d = max(paramArrayOfDouble[i], d);
          i += 1;
        }
        return d;
      }
      throw new IllegalArgumentException("Array cannot be empty.");
    }
    paramArrayOfDouble = new IllegalArgumentException("The Array must not be null");
    for (;;)
    {
      throw paramArrayOfDouble;
    }
  }
  
  public static float max(float paramFloat1, float paramFloat2)
  {
    if (Float.isNaN(paramFloat1)) {
      return paramFloat2;
    }
    if (Float.isNaN(paramFloat2)) {
      return paramFloat1;
    }
    return Math.max(paramFloat1, paramFloat2);
  }
  
  public static float max(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return max(max(paramFloat1, paramFloat2), paramFloat3);
  }
  
  public static float max(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat != null)
    {
      if (paramArrayOfFloat.length != 0)
      {
        float f = paramArrayOfFloat[0];
        int i = 1;
        while (i < paramArrayOfFloat.length)
        {
          f = max(paramArrayOfFloat[i], f);
          i += 1;
        }
        return f;
      }
      throw new IllegalArgumentException("Array cannot be empty.");
    }
    paramArrayOfFloat = new IllegalArgumentException("The Array must not be null");
    for (;;)
    {
      throw paramArrayOfFloat;
    }
  }
  
  public static double min(double paramDouble1, double paramDouble2)
  {
    if (Double.isNaN(paramDouble1)) {
      return paramDouble2;
    }
    if (Double.isNaN(paramDouble2)) {
      return paramDouble1;
    }
    return Math.min(paramDouble1, paramDouble2);
  }
  
  public static double min(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return min(min(paramDouble1, paramDouble2), paramDouble3);
  }
  
  public static double min(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble != null)
    {
      if (paramArrayOfDouble.length != 0)
      {
        double d = paramArrayOfDouble[0];
        int i = 1;
        while (i < paramArrayOfDouble.length)
        {
          d = min(paramArrayOfDouble[i], d);
          i += 1;
        }
        return d;
      }
      throw new IllegalArgumentException("Array cannot be empty.");
    }
    paramArrayOfDouble = new IllegalArgumentException("The Array must not be null");
    for (;;)
    {
      throw paramArrayOfDouble;
    }
  }
  
  public static float min(float paramFloat1, float paramFloat2)
  {
    if (Float.isNaN(paramFloat1)) {
      return paramFloat2;
    }
    if (Float.isNaN(paramFloat2)) {
      return paramFloat1;
    }
    return Math.min(paramFloat1, paramFloat2);
  }
  
  public static float min(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return min(min(paramFloat1, paramFloat2), paramFloat3);
  }
  
  public static float min(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat != null)
    {
      if (paramArrayOfFloat.length != 0)
      {
        float f = paramArrayOfFloat[0];
        int i = 1;
        while (i < paramArrayOfFloat.length)
        {
          f = min(paramArrayOfFloat[i], f);
          i += 1;
        }
        return f;
      }
      throw new IllegalArgumentException("Array cannot be empty.");
    }
    paramArrayOfFloat = new IllegalArgumentException("The Array must not be null");
    for (;;)
    {
      throw paramArrayOfFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.math.IEEE754rUtils
 * JD-Core Version:    0.7.0.1
 */