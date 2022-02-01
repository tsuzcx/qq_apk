package com.tencent.mobileqq.olympic.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.RelativeLayout;

class ARTipsManager$9
  extends AnimatorListenerAdapter
{
  ARTipsManager$9(ARTipsManager paramARTipsManager, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ARTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager).removeView(this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ARTipsManager.9
 * JD-Core Version:    0.7.0.1
 */