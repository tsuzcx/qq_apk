package com.tencent.mobileqq.widget;

import android.view.animation.Interpolator;

public class DrawerFrame$SmoothInterpolator
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    double d = paramFloat;
    Double.isNaN(d);
    return (float)(Math.pow(d - 1.0D, 3.0D) + 1.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DrawerFrame.SmoothInterpolator
 * JD-Core Version:    0.7.0.1
 */