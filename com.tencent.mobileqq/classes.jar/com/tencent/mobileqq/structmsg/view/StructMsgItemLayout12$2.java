package com.tencent.mobileqq.structmsg.view;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.DecelerateInterpolator;
import com.tencent.qphone.base.util.QLog;

class StructMsgItemLayout12$2
  implements View.OnTouchListener
{
  StructMsgItemLayout12$2(StructMsgItemLayout12 paramStructMsgItemLayout12, View paramView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3) {
          return false;
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout12.a.onClick(this.jdField_a_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout12.b = false;
      paramView = (ObjectAnimator)paramView.getTag(2131374282);
      if (paramView != null) {
        paramView.reverse();
      }
      return false;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout12.b)
    {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout12.b = true;
      ObjectAnimator localObjectAnimator = (ObjectAnimator)paramView.getTag(2131374282);
      paramMotionEvent = localObjectAnimator;
      if (localObjectAnimator == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("StructMsgItemLayout12", 2, "animator is null");
        }
        paramMotionEvent = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidViewView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scaleX", new float[] { 0.9F }), PropertyValuesHolder.ofFloat("scaleY", new float[] { 0.95F }) });
        paramMotionEvent.setInterpolator(new DecelerateInterpolator(2.0F));
        paramMotionEvent.setDuration(100L);
        paramView.setTag(2131374282, paramMotionEvent);
      }
      paramMotionEvent.start();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12.2
 * JD-Core Version:    0.7.0.1
 */