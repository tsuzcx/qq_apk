package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class TabDragAnimationView$ScrollAnimUpdateListener
  implements ValueAnimator.AnimatorUpdateListener
{
  private final TabDragAnimationView a;
  
  TabDragAnimationView$ScrollAnimUpdateListener(TabDragAnimationView paramTabDragAnimationView)
  {
    this.a = paramTabDragAnimationView;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a(f, 0.0F, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabDragAnimationView.ScrollAnimUpdateListener
 * JD-Core Version:    0.7.0.1
 */