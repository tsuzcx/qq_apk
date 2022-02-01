package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

class RefreshView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  RefreshView$3(RefreshView paramRefreshView, RefreshView.OnLottieEndListener paramOnLottieEndListener) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = RefreshView.c(this.b).getProgress();
    paramValueAnimator = new StringBuilder();
    paramValueAnimator.append("current progress is ");
    paramValueAnimator.append(f);
    QLog.d("RefreshView", 1, paramValueAnimator.toString());
    double d = f;
    Double.isNaN(d);
    if (Math.abs(d - 0.5D) < 0.008333334F)
    {
      RefreshView.c(this.b).stop();
      RefreshView.c(this.b).removeAnimatorUpdateListener(this);
      paramValueAnimator = this.a;
      if (paramValueAnimator != null) {
        paramValueAnimator.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RefreshView.3
 * JD-Core Version:    0.7.0.1
 */