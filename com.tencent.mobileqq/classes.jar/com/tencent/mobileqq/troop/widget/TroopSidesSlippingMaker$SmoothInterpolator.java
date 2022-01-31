package com.tencent.mobileqq.troop.widget;

import android.view.animation.Interpolator;

public class TroopSidesSlippingMaker$SmoothInterpolator
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    return (float)(Math.pow(paramFloat - 1.0D, 5.0D) + 1.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopSidesSlippingMaker.SmoothInterpolator
 * JD-Core Version:    0.7.0.1
 */