package com.tencent.viola.ui.view.list;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

class DefaultRecycleItemAnimator$3$1
  implements ValueAnimator.AnimatorUpdateListener
{
  DefaultRecycleItemAnimator$3$1(DefaultRecycleItemAnimator.3 param3) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ViewGroup.LayoutParams localLayoutParams = this.this$0.val$convertView.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
      this.this$0.val$convertView.setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.DefaultRecycleItemAnimator.3.1
 * JD-Core Version:    0.7.0.1
 */