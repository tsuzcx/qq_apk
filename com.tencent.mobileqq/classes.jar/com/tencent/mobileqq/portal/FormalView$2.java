package com.tencent.mobileqq.portal;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;

class FormalView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  FormalView$2(FormalView paramFormalView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (paramValueAnimator.getAnimatedValue() == null) {
      return;
    }
    float f = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() * 1.0F / 1000.0F;
    int i = -(int)(FormalView.b(this.a) * f);
    f = 1.0F - f;
    int j = -(int)(FormalView.c(this.a) * f);
    ((RelativeLayout.LayoutParams)FormalView.d(this.a).getLayoutParams()).topMargin = j;
    paramValueAnimator = (RelativeLayout.LayoutParams)FormalView.e(this.a).getLayoutParams();
    paramValueAnimator.leftMargin = i;
    FormalView.e(this.a).setLayoutParams(paramValueAnimator);
    paramValueAnimator = (RelativeLayout.LayoutParams)FormalView.f(this.a).getLayoutParams();
    paramValueAnimator.rightMargin = i;
    FormalView.f(this.a).setLayoutParams(paramValueAnimator);
    paramValueAnimator = (RelativeLayout.LayoutParams)FormalView.g(this.a).getLayoutParams();
    paramValueAnimator.topMargin = ((int)(f * FormalView.h(this.a)));
    FormalView.g(this.a).setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.FormalView.2
 * JD-Core Version:    0.7.0.1
 */