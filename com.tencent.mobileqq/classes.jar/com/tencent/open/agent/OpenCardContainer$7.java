package com.tencent.open.agent;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;

class OpenCardContainer$7
  extends AnimatorListenerAdapter
{
  OpenCardContainer$7(OpenCardContainer paramOpenCardContainer, ImageView paramImageView) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setBackgroundColor(0);
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = -1;
    this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenCardContainer.7
 * JD-Core Version:    0.7.0.1
 */