package com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper;

import android.animation.Animator;
import android.view.View;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class FloatingVideoWrapper$14
  extends D8SafeAnimatorListener
{
  FloatingVideoWrapper$14(FloatingVideoWrapper paramFloatingVideoWrapper, int paramInt, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = this.jdField_a_of_type_AndroidViewView;
    if (paramAnimator != null)
    {
      int i = this.jdField_a_of_type_Int;
      if (i == 0) {
        paramAnimator.setAlpha(1.0F);
      } else if (i == 1) {
        paramAnimator.setAlpha(0.0F);
      }
      FloatingVideoWrapper.b(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplUiwrapperFloatingVideoWrapper, this.jdField_a_of_type_Int);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    FloatingVideoWrapper.b(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplUiwrapperFloatingVideoWrapper, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 1)
    {
      FloatingVideoWrapper.b(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplUiwrapperFloatingVideoWrapper, false);
      paramAnimator = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplUiwrapperFloatingVideoWrapper;
      paramAnimator.a(false, new View[] { FloatingVideoWrapper.a(paramAnimator) });
    }
    FloatingVideoWrapper.d(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplUiwrapperFloatingVideoWrapper);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    FloatingVideoWrapper.b(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplUiwrapperFloatingVideoWrapper, 2);
    if (this.jdField_a_of_type_Int == 0)
    {
      FloatingVideoWrapper.b(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplUiwrapperFloatingVideoWrapper, true);
      if (FloatingVideoWrapper.a(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplUiwrapperFloatingVideoWrapper) == 1)
      {
        paramAnimator = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplUiwrapperFloatingVideoWrapper;
        paramAnimator.a(true, new View[] { FloatingVideoWrapper.a(paramAnimator) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper.14
 * JD-Core Version:    0.7.0.1
 */