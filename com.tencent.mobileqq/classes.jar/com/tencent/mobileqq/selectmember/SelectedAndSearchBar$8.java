package com.tencent.mobileqq.selectmember;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;

class SelectedAndSearchBar$8
  implements ValueAnimator.AnimatorUpdateListener
{
  SelectedAndSearchBar$8(SelectedAndSearchBar paramSelectedAndSearchBar, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = i;
    SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectedAndSearchBar.8
 * JD-Core Version:    0.7.0.1
 */