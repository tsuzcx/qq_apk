package com.tencent.tkd.topicsdk.ucrop.util;

public final class CubicEasing
{
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = paramFloat1 / paramFloat4 - 1.0F;
    return paramFloat3 * (paramFloat1 * paramFloat1 * paramFloat1 + 1.0F) + paramFloat2;
  }
  
  public static float b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 /= paramFloat4 / 2.0F;
    if (paramFloat1 < 1.0F)
    {
      paramFloat1 = paramFloat3 / 2.0F * paramFloat1 * paramFloat1 * paramFloat1;
    }
    else
    {
      paramFloat3 /= 2.0F;
      paramFloat1 -= 2.0F;
      paramFloat1 = paramFloat3 * (paramFloat1 * paramFloat1 * paramFloat1 + 2.0F);
    }
    return paramFloat1 + paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.util.CubicEasing
 * JD-Core Version:    0.7.0.1
 */