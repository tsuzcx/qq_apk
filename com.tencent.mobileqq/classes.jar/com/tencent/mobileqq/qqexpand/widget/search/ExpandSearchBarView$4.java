package com.tencent.mobileqq.qqexpand.widget.search;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;

class ExpandSearchBarView$4
  implements Animator.AnimatorListener
{
  ExpandSearchBarView$4(ExpandSearchBarView paramExpandSearchBarView, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = (FrameLayout.LayoutParams)this.a.getLayoutParams();
    paramAnimator.topMargin = (-ExpandSearchBarView.a(this.b));
    this.a.setLayoutParams(paramAnimator);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = (FrameLayout.LayoutParams)this.a.getLayoutParams();
    paramAnimator.topMargin = (-ExpandSearchBarView.a(this.b));
    this.a.setLayoutParams(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.search.ExpandSearchBarView.4
 * JD-Core Version:    0.7.0.1
 */