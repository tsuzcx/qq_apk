package com.tencent.mobileqq.dinifly.utils;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.annotation.FloatRange;

public class LottieValueAnimator
  extends ValueAnimator
{
  private long compositionDuration;
  @FloatRange(from=0.0D, to=1.0D)
  private float maxValue = 1.0F;
  @FloatRange(from=0.0D, to=1.0D)
  private float minValue = 0.0F;
  private float speed = 1.0F;
  private boolean systemAnimationsAreDisabled = false;
  @FloatRange(from=0.0D, to=1.0D)
  private float value = 0.0F;
  
  public LottieValueAnimator()
  {
    setInterpolator(null);
    addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        if (!LottieValueAnimator.this.systemAnimationsAreDisabled) {
          LottieValueAnimator.access$102(LottieValueAnimator.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        }
      }
    });
    updateValues();
  }
  
  private boolean isReversed()
  {
    return this.speed < 0.0F;
  }
  
  private void updateValues()
  {
    setDuration(((float)this.compositionDuration * (this.maxValue - this.minValue) / Math.abs(this.speed)));
    float f1;
    if (this.speed < 0.0F)
    {
      f1 = this.maxValue;
      if (this.speed >= 0.0F) {
        break label89;
      }
    }
    label89:
    for (float f2 = this.minValue;; f2 = this.maxValue)
    {
      setFloatValues(new float[] { f1, f2 });
      setValue(this.value);
      return;
      f1 = this.minValue;
      break;
    }
  }
  
  public float getMinValue()
  {
    return this.minValue;
  }
  
  public float getSpeed()
  {
    return this.speed;
  }
  
  public float getValue()
  {
    return this.value;
  }
  
  public void pauseAnimation()
  {
    float f = this.value;
    cancel();
    setValue(f);
  }
  
  public void playAnimation()
  {
    start();
    if (isReversed()) {}
    for (float f = this.maxValue;; f = this.minValue)
    {
      setValue(f);
      return;
    }
  }
  
  public void resumeAnimation()
  {
    float f2 = this.value;
    float f1;
    if ((isReversed()) && (this.value == this.minValue)) {
      f1 = this.maxValue;
    }
    for (;;)
    {
      start();
      setValue(f1);
      return;
      f1 = f2;
      if (!isReversed())
      {
        f1 = f2;
        if (this.value == this.maxValue) {
          f1 = this.minValue;
        }
      }
    }
  }
  
  public void reverseAnimationSpeed()
  {
    setSpeed(-getSpeed());
  }
  
  public void setCompositionDuration(long paramLong)
  {
    this.compositionDuration = paramLong;
    updateValues();
  }
  
  public void setMaxValue(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    if (paramFloat <= this.minValue) {
      throw new IllegalArgumentException("Max value must be greater than min value.");
    }
    this.maxValue = paramFloat;
    updateValues();
  }
  
  public void setMinValue(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    if (paramFloat >= this.maxValue) {
      throw new IllegalArgumentException("Min value must be smaller then max value.");
    }
    this.minValue = paramFloat;
    updateValues();
  }
  
  public void setSpeed(float paramFloat)
  {
    this.speed = paramFloat;
    updateValues();
  }
  
  public void setValue(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    paramFloat = MiscUtils.clamp(paramFloat, this.minValue, this.maxValue);
    this.value = paramFloat;
    if (isReversed()) {}
    for (paramFloat = this.maxValue - paramFloat;; paramFloat -= this.minValue)
    {
      paramFloat /= Math.abs(this.maxValue - this.minValue);
      if (getDuration() > 0L) {
        setCurrentPlayTime(((float)getDuration() * paramFloat));
      }
      return;
    }
  }
  
  public void systemAnimationsAreDisabled()
  {
    this.systemAnimationsAreDisabled = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.utils.LottieValueAnimator
 * JD-Core Version:    0.7.0.1
 */