package com.tencent.mobileqq.kandian.biz.fastweb.data;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class ProteusAnimationItemData$2
  implements ValueAnimator.AnimatorUpdateListener
{
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ProteusAnimationItemData.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    if (ProteusAnimationItemData.a(this.a).getLayoutParams() != null) {
      ProteusAnimationItemData.a(this.a).getLayoutParams().height = ProteusAnimationItemData.b(this.a);
    }
    ProteusAnimationItemData.a(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.data.ProteusAnimationItemData.2
 * JD-Core Version:    0.7.0.1
 */