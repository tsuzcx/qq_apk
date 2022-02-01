package com.tencent.mobileqq.richmedia.capture.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class CaptureVideoFilterViewPager$3
  implements Animation.AnimationListener
{
  CaptureVideoFilterViewPager$3(CaptureVideoFilterViewPager paramCaptureVideoFilterViewPager, View paramView, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (this.jdField_a_of_type_Int == CaptureVideoFilterViewPager.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager)) {
      CaptureVideoFilterViewPager.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager, false);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager.3
 * JD-Core Version:    0.7.0.1
 */