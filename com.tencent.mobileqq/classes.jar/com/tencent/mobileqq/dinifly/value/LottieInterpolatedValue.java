package com.tencent.mobileqq.dinifly.value;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

abstract class LottieInterpolatedValue<T>
  extends LottieValueCallback<T>
{
  private final T endValue;
  private final Interpolator interpolator;
  private final T startValue;
  
  LottieInterpolatedValue(T paramT1, T paramT2)
  {
    this(paramT1, paramT2, new LinearInterpolator());
  }
  
  LottieInterpolatedValue(T paramT1, T paramT2, Interpolator paramInterpolator)
  {
    this.startValue = paramT1;
    this.endValue = paramT2;
    this.interpolator = paramInterpolator;
  }
  
  public T getValue(LottieFrameInfo<T> paramLottieFrameInfo)
  {
    float f = this.interpolator.getInterpolation(paramLottieFrameInfo.getOverallProgress());
    return interpolateValue(this.startValue, this.endValue, f);
  }
  
  abstract T interpolateValue(T paramT1, T paramT2, float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.value.LottieInterpolatedValue
 * JD-Core Version:    0.7.0.1
 */