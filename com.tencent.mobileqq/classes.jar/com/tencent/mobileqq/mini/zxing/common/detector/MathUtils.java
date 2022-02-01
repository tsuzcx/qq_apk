package com.tencent.mobileqq.mini.zxing.common.detector;

public final class MathUtils
{
  public static float distance(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    double d1 = paramFloat1 - paramFloat3;
    double d2 = paramFloat2 - paramFloat4;
    Double.isNaN(d1);
    Double.isNaN(d1);
    Double.isNaN(d2);
    Double.isNaN(d2);
    return (float)Math.sqrt(d1 * d1 + d2 * d2);
  }
  
  public static float distance(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d1 = paramInt1 - paramInt3;
    double d2 = paramInt2 - paramInt4;
    Double.isNaN(d1);
    Double.isNaN(d1);
    Double.isNaN(d2);
    Double.isNaN(d2);
    return (float)Math.sqrt(d1 * d1 + d2 * d2);
  }
  
  public static int round(float paramFloat)
  {
    float f;
    if (paramFloat < 0.0F) {
      f = -0.5F;
    } else {
      f = 0.5F;
    }
    return (int)(paramFloat + f);
  }
  
  public static int sum(int[] paramArrayOfInt)
  {
    int k = paramArrayOfInt.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += paramArrayOfInt[i];
      i += 1;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.common.detector.MathUtils
 * JD-Core Version:    0.7.0.1
 */