package com.tencent.mobileqq.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class SlideBottomPanel$5
  implements Animator.AnimatorListener
{
  SlideBottomPanel$5(SlideBottomPanel paramSlideBottomPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = false;
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener.displayPanelFinish();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = false;
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener.displayPanelFinish();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideBottomPanel.5
 * JD-Core Version:    0.7.0.1
 */