package com.tencent.mobileqq.kandian.glue.viola;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class CommonSuspensionGestureLayout$7
  implements Animation.AnimationListener
{
  CommonSuspensionGestureLayout$7(CommonSuspensionGestureLayout paramCommonSuspensionGestureLayout, int paramInt1, int paramInt2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    CommonSuspensionGestureLayout.c(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout).setVisibility(8);
    CommonSuspensionGestureLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout).a(true, this.jdField_a_of_type_Int, this.b);
    CommonSuspensionGestureLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout, this.b);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout.7
 * JD-Core Version:    0.7.0.1
 */