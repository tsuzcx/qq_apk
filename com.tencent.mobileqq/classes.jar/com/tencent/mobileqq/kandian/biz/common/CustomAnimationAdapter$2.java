package com.tencent.mobileqq.kandian.biz.common;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;

class CustomAnimationAdapter$2
  implements ValueAnimator.AnimatorUpdateListener
{
  CustomAnimationAdapter$2(CustomAnimationAdapter paramCustomAnimationAdapter, Container paramContainer) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
    localLayoutParams.topMargin = paramValueAnimator.intValue();
    this.a.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.CustomAnimationAdapter.2
 * JD-Core Version:    0.7.0.1
 */