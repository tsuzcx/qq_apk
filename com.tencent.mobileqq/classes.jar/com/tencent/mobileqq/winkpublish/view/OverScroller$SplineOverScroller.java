package com.tencent.mobileqq.winkpublish.view;

import android.view.ViewConfiguration;

class OverScroller$SplineOverScroller
{
  private static float e = (float)(Math.log(0.78D) / Math.log(0.9D));
  private static final float[] f = new float[101];
  private static final float[] g = new float[101];
  private boolean a = true;
  private float b = ViewConfiguration.getScrollFriction();
  private int c = 0;
  private int d = 0;
  
  static
  {
    float f1 = 0.0F;
    int i = 0;
    float f2 = 0.0F;
    if (i < 100)
    {
      float f5 = i / 100.0F;
      float f3 = 1.0F;
      for (;;)
      {
        float f4 = (f3 - f1) / 2.0F + f1;
        float f6 = 1.0F - f4;
        float f7 = f4 * 3.0F * f6;
        float f8 = f4 * f4 * f4;
        float f9 = (f6 * 0.175F + f4 * 0.35F) * f7 + f8;
        if (Math.abs(f9 - f5) < 1.E-005D)
        {
          f[i] = (f7 * (f6 * 0.5F + f4) + f8);
          f3 = 1.0F;
          for (;;)
          {
            f4 = (f3 - f2) / 2.0F + f2;
            f6 = 1.0F - f4;
            f7 = f4 * 3.0F * f6;
            f8 = f4 * f4 * f4;
            f9 = (f6 * 0.5F + f4) * f7 + f8;
            if (Math.abs(f9 - f5) < 1.E-005D)
            {
              g[i] = (f7 * (f6 * 0.175F + f4 * 0.35F) + f8);
              i += 1;
              break;
            }
            if (f9 > f5) {
              f3 = f4;
            } else {
              f2 = f4;
            }
          }
        }
        if (f9 > f5) {
          f3 = f4;
        } else {
          f1 = f4;
        }
      }
    }
    float[] arrayOfFloat = f;
    g[100] = 1.0F;
    arrayOfFloat[100] = 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.view.OverScroller.SplineOverScroller
 * JD-Core Version:    0.7.0.1
 */