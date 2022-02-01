package com.tencent.util;

import android.view.animation.Interpolator;

public class ViscousFluidInterpolator
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    return AnimateUtils.a(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.util.ViscousFluidInterpolator
 * JD-Core Version:    0.7.0.1
 */