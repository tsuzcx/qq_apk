package com.tencent.mobileqq.vas.qvip.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.RadioButton;

class QQVipFeedWedFragment$4
  extends AnimatorListenerAdapter
{
  QQVipFeedWedFragment$4(QQVipFeedWedFragment paramQQVipFeedWedFragment, RadioButton paramRadioButton) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidWidgetRadioButton.postDelayed(new QQVipFeedWedFragment.4.1(this), 500L);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidWidgetRadioButton.setBackgroundResource(2130847294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.fragment.QQVipFeedWedFragment.4
 * JD-Core Version:    0.7.0.1
 */