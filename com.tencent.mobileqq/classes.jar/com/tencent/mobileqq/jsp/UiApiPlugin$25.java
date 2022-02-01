package com.tencent.mobileqq.jsp;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class UiApiPlugin$25
  implements Animation.AnimationListener
{
  UiApiPlugin$25(UiApiPlugin paramUiApiPlugin, View paramView, int paramInt1, int paramInt2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    paramAnimation = this.jdField_a_of_type_AndroidViewView;
    paramAnimation.layout(paramAnimation.getLeft(), this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView.getRight(), this.b);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.25
 * JD-Core Version:    0.7.0.1
 */