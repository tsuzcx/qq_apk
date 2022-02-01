package com.tencent.mobileqq.guild.audio.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.qphone.base.util.QLog;

class VolumnAnimateView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  VolumnAnimateView$1(VolumnAnimateView paramVolumnAnimateView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    VolumnAnimateView.a(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    if (QLog.isColorLevel())
    {
      paramValueAnimator = new StringBuilder();
      paramValueAnimator.append("onAnimationUpdate: deflating=");
      paramValueAnimator.append(VolumnAnimateView.a(this.a));
      paramValueAnimator.append(", curFraction=");
      paramValueAnimator.append(VolumnAnimateView.b(this.a));
      paramValueAnimator.append(", targetFraction=");
      paramValueAnimator.append(VolumnAnimateView.c(this.a));
      QLog.i("VolumnAnimateView", 2, paramValueAnimator.toString());
    }
    VolumnAnimateView.d(this.a);
    this.a.postInvalidate();
    boolean bool;
    if ((!VolumnAnimateView.a(this.a)) && (Float.compare(VolumnAnimateView.b(this.a), VolumnAnimateView.c(this.a)) >= 0))
    {
      bool = true;
    }
    else
    {
      if ((Float.compare(VolumnAnimateView.b(this.a), 0.0F) != 0) || (!VolumnAnimateView.a(this.a))) {
        return;
      }
      bool = false;
    }
    this.a.post(new VolumnAnimateView.1.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.VolumnAnimateView.1
 * JD-Core Version:    0.7.0.1
 */