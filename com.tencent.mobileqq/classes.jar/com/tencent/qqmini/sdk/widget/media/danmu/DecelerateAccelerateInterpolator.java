package com.tencent.qqmini.sdk.widget.media.danmu;

import android.view.animation.Interpolator;

public class DecelerateAccelerateInterpolator
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    double d = (paramFloat * 2.0F - 1.0F) / 4.0F;
    Double.isNaN(d);
    return (float)Math.tan(d * 3.141592653589793D) / 2.0F + 0.5F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.danmu.DecelerateAccelerateInterpolator
 * JD-Core Version:    0.7.0.1
 */