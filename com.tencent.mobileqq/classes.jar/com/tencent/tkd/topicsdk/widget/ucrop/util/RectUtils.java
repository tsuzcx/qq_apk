package com.tencent.tkd.topicsdk.widget.ucrop.util;

import android.graphics.RectF;

public class RectUtils
{
  public static RectF a(float[] paramArrayOfFloat)
  {
    RectF localRectF = new RectF((1.0F / 1.0F), (1.0F / 1.0F), (1.0F / -1.0F), (1.0F / -1.0F));
    int i = 1;
    while (i < paramArrayOfFloat.length)
    {
      float f1 = Math.round(paramArrayOfFloat[(i - 1)] * 10.0F) / 10.0F;
      float f2 = Math.round(paramArrayOfFloat[i] * 10.0F) / 10.0F;
      localRectF.left = Math.min(f1, localRectF.left);
      localRectF.top = Math.min(f2, localRectF.top);
      localRectF.right = Math.max(f1, localRectF.right);
      localRectF.bottom = Math.max(f2, localRectF.bottom);
      i += 2;
    }
    localRectF.sort();
    return localRectF;
  }
  
  public static float[] a(RectF paramRectF)
  {
    return new float[] { paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.top, paramRectF.right, paramRectF.bottom, paramRectF.left, paramRectF.bottom };
  }
  
  public static float[] a(float[] paramArrayOfFloat)
  {
    return new float[] { (float)Math.sqrt(Math.pow(paramArrayOfFloat[0] - paramArrayOfFloat[2], 2.0D) + Math.pow(paramArrayOfFloat[1] - paramArrayOfFloat[3], 2.0D)), (float)Math.sqrt(Math.pow(paramArrayOfFloat[2] - paramArrayOfFloat[4], 2.0D) + Math.pow(paramArrayOfFloat[3] - paramArrayOfFloat[5], 2.0D)) };
  }
  
  public static float[] b(RectF paramRectF)
  {
    return new float[] { paramRectF.centerX(), paramRectF.centerY() };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.ucrop.util.RectUtils
 * JD-Core Version:    0.7.0.1
 */