package com.tencent.mobileqq.widget;

import android.animation.Animator;

class SlideBottomPanel$3
  extends D8SafeAnimatorListener
{
  SlideBottomPanel$3(SlideBottomPanel paramSlideBottomPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = this.a;
    paramAnimator.jdField_a_of_type_Boolean = false;
    paramAnimator.b = false;
    paramAnimator.e = false;
    if (paramAnimator.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener.hidePanelFinish();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.a;
    paramAnimator.jdField_a_of_type_Boolean = false;
    paramAnimator.b = false;
    paramAnimator.e = false;
    if (paramAnimator.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener.hidePanelFinish();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideBottomPanel.3
 * JD-Core Version:    0.7.0.1
 */