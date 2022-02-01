package com.tencent.mobileqq.kandian.base.imagecrop.util;

import android.graphics.RectF;

public class RectUtils
{
  public static float[] a(RectF paramRectF)
  {
    return new float[] { paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.top, paramRectF.right, paramRectF.bottom, paramRectF.left, paramRectF.bottom };
  }
  
  public static float[] a(float[] paramArrayOfFloat)
  {
    return new float[] { (float)Math.sqrt(Math.pow(paramArrayOfFloat[0] - paramArrayOfFloat[2], 2.0D) + Math.pow(paramArrayOfFloat[1] - paramArrayOfFloat[3], 2.0D)), (float)Math.sqrt(Math.pow(paramArrayOfFloat[2] - paramArrayOfFloat[4], 2.0D) + Math.pow(paramArrayOfFloat[3] - paramArrayOfFloat[5], 2.0D)) };
  }
  
  public static RectF b(float[] paramArrayOfFloat)
  {
    RectF localRectF = new RectF((1.0F / 1.0F), (1.0F / 1.0F), (1.0F / -1.0F), (1.0F / -1.0F));
    int i = 1;
    while (i < paramArrayOfFloat.length)
    {
      float f2 = Math.round(paramArrayOfFloat[(i - 1)] * 10.0F) / 10.0F;
      float f1 = Math.round(paramArrayOfFloat[i] * 10.0F) / 10.0F;
      float f3;
      if (f2 < localRectF.left) {
        f3 = f2;
      } else {
        f3 = localRectF.left;
      }
      localRectF.left = f3;
      if (f1 < localRectF.top) {
        f3 = f1;
      } else {
        f3 = localRectF.top;
      }
      localRectF.top = f3;
      if (f2 <= localRectF.right) {
        f2 = localRectF.right;
      }
      localRectF.right = f2;
      if (f1 <= localRectF.bottom) {
        f1 = localRectF.bottom;
      }
      localRectF.bottom = f1;
      i += 2;
    }
    localRectF.sort();
    return localRectF;
  }
  
  public static float[] b(RectF paramRectF)
  {
    return new float[] { paramRectF.centerX(), paramRectF.centerY() };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.imagecrop.util.RectUtils
 * JD-Core Version:    0.7.0.1
 */