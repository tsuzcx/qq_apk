package com.tencent.mobileqq.kandian.biz.pts.view.polymeric;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ProteusRecycleView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ProteusRecycleView$1(ProteusRecycleView paramProteusRecycleView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = this.a;
    paramValueAnimator.setPadding(0, 0, (int)ProteusRecycleView.a(paramValueAnimator).a(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.ProteusRecycleView.1
 * JD-Core Version:    0.7.0.1
 */