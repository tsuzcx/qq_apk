package com.tencent.mobileqq.troop.widget;

import android.view.animation.Interpolator;

public class TroopSidesSlippingMaker$SmoothInterpolator
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    double d = paramFloat;
    Double.isNaN(d);
    return (float)(Math.pow(d - 1.0D, 5.0D) + 1.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopSidesSlippingMaker.SmoothInterpolator
 * JD-Core Version:    0.7.0.1
 */