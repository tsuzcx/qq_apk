package com.tencent.mobileqq.troop.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import java.util.Queue;

class MessageSubtitleView$TextAnimationListener
  implements Animator.AnimatorListener
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean = false;
  
  public MessageSubtitleView$TextAnimationListener(MessageSubtitleView paramMessageSubtitleView, boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Int == MessageSubtitleView.c) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView.b();
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView.a.isEmpty()) {
        MessageSubtitleView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.MessageSubtitleView.TextAnimationListener
 * JD-Core Version:    0.7.0.1
 */