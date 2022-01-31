package com.tencent.mobileqq.vas;

import android.view.animation.Interpolator;

public class IndividuationAnimationUtils$CirculateTraslateInterpolator
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat < 0.25D) {}
    do
    {
      return paramFloat;
      if ((paramFloat >= 0.25D) && (paramFloat < 0.5D)) {
        return (float)(0.5D - paramFloat);
      }
      if ((paramFloat >= 0.5D) && (paramFloat < 0.75D)) {
        return (float)(0.5D - paramFloat);
      }
    } while (paramFloat < 0.75D);
    return paramFloat - 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vas.IndividuationAnimationUtils.CirculateTraslateInterpolator
 * JD-Core Version:    0.7.0.1
 */