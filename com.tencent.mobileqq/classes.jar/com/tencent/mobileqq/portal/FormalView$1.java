package com.tencent.mobileqq.portal;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class FormalView$1
  extends AnimateUtils.AnimationAdapter
{
  FormalView$1(FormalView paramFormalView, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.d();
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a = true;
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (FormalView.a(this.jdField_a_of_type_ComTencentMobileqqPortalFormalView) != null) {
      FormalView.a(this.jdField_a_of_type_ComTencentMobileqqPortalFormalView).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.FormalView.1
 * JD-Core Version:    0.7.0.1
 */