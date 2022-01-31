package com.tencent.mobileqq.dinifly.value;

import android.support.annotation.RestrictTo;

public class LottieFrameInfo<T>
{
  private float endFrame;
  private T endValue;
  private float interpolatedKeyframeProgress;
  private float linearKeyframeProgress;
  private float overallProgress;
  private float startFrame;
  private T startValue;
  
  public float getEndFrame()
  {
    return this.endFrame;
  }
  
  public T getEndValue()
  {
    return this.endValue;
  }
  
  public float getInterpolatedKeyframeProgress()
  {
    return this.interpolatedKeyframeProgress;
  }
  
  public float getLinearKeyframeProgress()
  {
    return this.linearKeyframeProgress;
  }
  
  public float getOverallProgress()
  {
    return this.overallProgress;
  }
  
  public float getStartFrame()
  {
    return this.startFrame;
  }
  
  public T getStartValue()
  {
    return this.startValue;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public LottieFrameInfo<T> set(float paramFloat1, float paramFloat2, T paramT1, T paramT2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    this.startFrame = paramFloat1;
    this.endFrame = paramFloat2;
    this.startValue = paramT1;
    this.endValue = paramT2;
    this.linearKeyframeProgress = paramFloat3;
    this.interpolatedKeyframeProgress = paramFloat4;
    this.overallProgress = paramFloat5;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.value.LottieFrameInfo
 * JD-Core Version:    0.7.0.1
 */