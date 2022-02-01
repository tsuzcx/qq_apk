package com.tencent.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.qphone.base.util.QLog;

class XPanelContainer$4
  implements ValueAnimator.AnimatorUpdateListener
{
  XPanelContainer$4(XPanelContainer paramXPanelContainer, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("XPanelContainer", 2, "colseAnim resetPosition");
      }
      XPanelContainer.a(this.jdField_a_of_type_ComTencentWidgetXPanelContainer, 0);
      return;
    }
    XPanelContainer.a(this.jdField_a_of_type_ComTencentWidgetXPanelContainer, this.jdField_a_of_type_Int - i);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.XPanelContainer.4
 * JD-Core Version:    0.7.0.1
 */