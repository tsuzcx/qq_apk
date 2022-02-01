package com.tencent.richmediabrowser.animation;

import android.view.animation.Interpolator;

public class ViscousFluidInterpolator
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    return AnimateUtils.viscousFluid(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.animation.ViscousFluidInterpolator
 * JD-Core Version:    0.7.0.1
 */