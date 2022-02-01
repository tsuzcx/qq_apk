package com.tencent.mobileqq.kandian.base.view.widget;

import android.animation.Animator;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class BaseTabbar$TabHolder$1
  extends D8SafeAnimatorListener
{
  BaseTabbar$TabHolder$1(BaseTabbar.TabHolder paramTabHolder, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    BaseTabbar.TabHolder.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBaseTabbar$TabHolder, this.jdField_a_of_type_Boolean);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    BaseTabbar.TabHolder.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBaseTabbar$TabHolder, this.jdField_a_of_type_Boolean);
    BaseTabbar.TabHolder.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBaseTabbar$TabHolder);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBaseTabbar$TabHolder.b.clearAnimation();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.BaseTabbar.TabHolder.1
 * JD-Core Version:    0.7.0.1
 */