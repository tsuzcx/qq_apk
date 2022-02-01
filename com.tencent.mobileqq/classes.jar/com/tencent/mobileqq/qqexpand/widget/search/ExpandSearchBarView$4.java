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
    paramAnimator = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramAnimator.topMargin = (-ExpandSearchBarView.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimator);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramAnimator.topMargin = (-ExpandSearchBarView.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.search.ExpandSearchBarView.4
 * JD-Core Version:    0.7.0.1
 */