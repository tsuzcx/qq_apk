package com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.RelativeLayout;

class FloatingVideoWrapper$5
  implements Animator.AnimatorListener
{
  FloatingVideoWrapper$5(FloatingVideoWrapper paramFloatingVideoWrapper, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplUiwrapperFloatingVideoWrapper.mRootLayout != null)
    {
      if (this.jdField_a_of_type_Int != 0) {
        break label41;
      }
      this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplUiwrapperFloatingVideoWrapper.mRootLayout.setAlpha(1.0F);
    }
    for (;;)
    {
      FloatingVideoWrapper.b(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplUiwrapperFloatingVideoWrapper, this.jdField_a_of_type_Int);
      return;
      label41:
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplUiwrapperFloatingVideoWrapper.mRootLayout.setAlpha(0.0F);
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    FloatingVideoWrapper.b(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplUiwrapperFloatingVideoWrapper, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 1)
    {
      FloatingVideoWrapper.a(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplUiwrapperFloatingVideoWrapper, false);
      this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplUiwrapperFloatingVideoWrapper.a(false, new View[] { FloatingVideoWrapper.a(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplUiwrapperFloatingVideoWrapper) });
    }
    FloatingVideoWrapper.a(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplUiwrapperFloatingVideoWrapper);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    FloatingVideoWrapper.b(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplUiwrapperFloatingVideoWrapper, 2);
    if (this.jdField_a_of_type_Int == 0)
    {
      FloatingVideoWrapper.a(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplUiwrapperFloatingVideoWrapper, true);
      if (FloatingVideoWrapper.a(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplUiwrapperFloatingVideoWrapper) == 1) {
        this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplUiwrapperFloatingVideoWrapper.a(true, new View[] { FloatingVideoWrapper.a(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplUiwrapperFloatingVideoWrapper) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper.5
 * JD-Core Version:    0.7.0.1
 */