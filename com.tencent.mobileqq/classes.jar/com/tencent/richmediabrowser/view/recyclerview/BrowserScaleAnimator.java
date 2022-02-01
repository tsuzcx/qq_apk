package com.tencent.richmediabrowser.view.recyclerview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.DecelerateInterpolator;
import com.tencent.richmediabrowser.listener.IBrowserScaleControlListener;
import com.tencent.richmediabrowser.listener.IBrowserScaleEventListener;

public class BrowserScaleAnimator
  extends ValueAnimator
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  private final float BIGGER = 1.07F;
  private final float SMALLER = 0.93F;
  private float mTargetScale;
  private IBrowserScaleControlListener scaleControlListener;
  private IBrowserScaleEventListener scaleEventListener;
  private float tempScale;
  private float x;
  private float y;
  
  public BrowserScaleAnimator(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mTargetScale = paramFloat1;
    this.x = paramFloat2;
    this.y = paramFloat3;
  }
  
  private boolean isScaleContine()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.scaleControlListener != null)
    {
      float f = this.scaleControlListener.getCurrentScale();
      if ((this.tempScale <= 1.0F) || (f >= this.mTargetScale))
      {
        bool1 = bool2;
        if (this.tempScale < 1.0F)
        {
          bool1 = bool2;
          if (f <= this.mTargetScale) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void initAnimator()
  {
    if (this.scaleControlListener != null)
    {
      float f = this.scaleControlListener.getCurrentScale();
      if (f < this.mTargetScale) {
        this.tempScale = 1.07F;
      }
      if (f > this.mTargetScale) {
        this.tempScale = 0.93F;
      }
      setFloatValues(new float[] { f, this.mTargetScale });
      setInterpolator(new DecelerateInterpolator());
      setDuration(400L);
      addUpdateListener(this);
      addListener(this);
    }
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.scaleEventListener != null) {
      this.scaleEventListener.onScaleAnimationCancel();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.scaleEventListener != null) {
      this.scaleEventListener.onScaleAnimationEnd();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (this.scaleEventListener != null) {
      this.scaleEventListener.onScaleAnimationRepeat();
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.scaleEventListener != null) {
      this.scaleEventListener.onScaleAnimationStart();
    }
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.scaleControlListener != null)
    {
      this.scaleControlListener.startScale(this.tempScale, this.tempScale, this.x, this.y);
      if (!isScaleContine())
      {
        float f = this.mTargetScale / this.scaleControlListener.getCurrentScale();
        this.scaleControlListener.startScale(f, f, this.x, this.y);
      }
    }
  }
  
  public void setBrowserScaleControlListener(IBrowserScaleControlListener paramIBrowserScaleControlListener)
  {
    this.scaleControlListener = paramIBrowserScaleControlListener;
  }
  
  public void setBrowserScaleEventListener(IBrowserScaleEventListener paramIBrowserScaleEventListener)
  {
    this.scaleEventListener = paramIBrowserScaleEventListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.recyclerview.BrowserScaleAnimator
 * JD-Core Version:    0.7.0.1
 */