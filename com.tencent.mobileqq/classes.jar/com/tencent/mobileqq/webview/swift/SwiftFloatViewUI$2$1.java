package com.tencent.mobileqq.webview.swift;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;

class SwiftFloatViewUI$2$1
  implements Animation.AnimationListener
{
  SwiftFloatViewUI$2$1(SwiftFloatViewUI.2 param2, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramAnimation.leftMargin = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI$2.e;
    paramAnimation.topMargin = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI$2.f;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimation);
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI$2.a = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftFloatViewUI.2.1
 * JD-Core Version:    0.7.0.1
 */