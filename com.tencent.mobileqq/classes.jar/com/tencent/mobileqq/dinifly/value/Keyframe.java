package com.tencent.mobileqq.dinifly.value;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.dinifly.LottieComposition;

public class Keyframe<T>
{
  private static final float UNSET_FLOAT = -3987645.8F;
  private static final int UNSET_INT = 784923401;
  @Nullable
  private final LottieComposition composition;
  @Nullable
  public Float endFrame;
  private float endProgress = 1.4E-45F;
  @Nullable
  public T endValue;
  private float endValueFloat = -3987645.8F;
  private int endValueInt = 784923401;
  @Nullable
  public final Interpolator interpolator;
  public PointF pathCp1 = null;
  public PointF pathCp2 = null;
  public final float startFrame;
  private float startProgress = 1.4E-45F;
  @Nullable
  public final T startValue;
  private float startValueFloat = -3987645.8F;
  private int startValueInt = 784923401;
  
  public Keyframe(LottieComposition paramLottieComposition, @Nullable T paramT1, @Nullable T paramT2, @Nullable Interpolator paramInterpolator, float paramFloat, @Nullable Float paramFloat1)
  {
    this.composition = paramLottieComposition;
    this.startValue = paramT1;
    this.endValue = paramT2;
    this.interpolator = paramInterpolator;
    this.startFrame = paramFloat;
    this.endFrame = paramFloat1;
  }
  
  public Keyframe(T paramT)
  {
    this.composition = null;
    this.startValue = paramT;
    this.endValue = paramT;
    this.interpolator = null;
    this.startFrame = 1.4E-45F;
    this.endFrame = Float.valueOf(3.4028235E+38F);
  }
  
  public boolean containsProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    return (paramFloat >= getStartProgress()) && (paramFloat < getEndProgress());
  }
  
  public float getEndProgress()
  {
    if (this.composition == null) {
      return 1.0F;
    }
    if (this.endProgress == 1.4E-45F) {
      if (this.endFrame != null) {
        break label36;
      }
    }
    label36:
    for (this.endProgress = 1.0F;; this.endProgress = (getStartProgress() + (this.endFrame.floatValue() - this.startFrame) / this.composition.getDurationFrames())) {
      return this.endProgress;
    }
  }
  
  public float getEndValueFloat()
  {
    if (this.endValueFloat == -3987645.8F) {
      this.endValueFloat = ((Float)this.endValue).floatValue();
    }
    return this.endValueFloat;
  }
  
  public int getEndValueInt()
  {
    if (this.endValueInt == 784923401) {
      this.endValueInt = ((Integer)this.endValue).intValue();
    }
    return this.endValueInt;
  }
  
  public float getStartProgress()
  {
    if (this.composition == null) {
      return 0.0F;
    }
    if (this.startProgress == 1.4E-45F) {
      this.startProgress = ((this.startFrame - this.composition.getStartFrame()) / this.composition.getDurationFrames());
    }
    return this.startProgress;
  }
  
  public float getStartValueFloat()
  {
    if (this.startValueFloat == -3987645.8F) {
      this.startValueFloat = ((Float)this.startValue).floatValue();
    }
    return this.startValueFloat;
  }
  
  public int getStartValueInt()
  {
    if (this.startValueInt == 784923401) {
      this.startValueInt = ((Integer)this.startValue).intValue();
    }
    return this.startValueInt;
  }
  
  public boolean isStatic()
  {
    return this.interpolator == null;
  }
  
  public String toString()
  {
    return "Keyframe{startValue=" + this.startValue + ", endValue=" + this.endValue + ", startFrame=" + this.startFrame + ", endFrame=" + this.endFrame + ", interpolator=" + this.interpolator + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.value.Keyframe
 * JD-Core Version:    0.7.0.1
 */