package com.tencent.mobileqq.flashshow.view.refresh;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class PullRefreshLayout$4
  implements ValueAnimator.AnimatorUpdateListener
{
  PullRefreshLayout$4(PullRefreshLayout paramPullRefreshLayout, View[] paramArrayOfView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.a;
    int j = paramValueAnimator.length;
    int i = 0;
    while (i < j)
    {
      paramValueAnimator[i].setTranslationY(f1);
      i += 1;
    }
    float f2 = f1 / PullRefreshLayout.f(this.b);
    f1 = f2;
    if (f2 > 1.0F) {
      f1 = 1.0F;
    }
    if ((PullRefreshLayout.g(this.b) != null) && (PullRefreshLayout.h(this.b) == 1)) {
      PullRefreshLayout.g(this.b).a(this.b, f1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.view.refresh.PullRefreshLayout.4
 * JD-Core Version:    0.7.0.1
 */