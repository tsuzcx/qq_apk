package com.tencent.tkd.topicsdk.ucrop.util;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/ucrop/util/CubicEasing;", "", "()V", "easeIn", "", "time", "start", "end", "duration", "easeInOut", "easeOut", "topicsdk-ucrop_release"}, k=1, mv={1, 1, 16})
public final class CubicEasing
{
  public static final CubicEasing a = new CubicEasing();
  
  @JvmStatic
  public static final float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return paramFloat3 * ((paramFloat1 / paramFloat4 - 1.0F) * 1.0F * 1.0F + 1.0F) + paramFloat2;
  }
  
  @JvmStatic
  public static final float b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 /= 2.0F;
    if (paramFloat4 / paramFloat1 < 1.0F)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.util.CubicEasing
 * JD-Core Version:    0.7.0.1
 */