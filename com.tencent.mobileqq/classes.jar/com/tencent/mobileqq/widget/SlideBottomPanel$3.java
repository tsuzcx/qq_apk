package com.tencent.mobileqq.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class SlideBottomPanel$3
  implements Animator.AnimatorListener
{
  SlideBottomPanel$3(SlideBottomPanel paramSlideBottomPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = false;
    this.a.b = false;
    this.a.e = false;
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener.hidePanelFinish();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = false;
    this.a.b = false;
    this.a.e = false;
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener.hidePanelFinish();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideBottomPanel.3
 * JD-Core Version:    0.7.0.1
 */