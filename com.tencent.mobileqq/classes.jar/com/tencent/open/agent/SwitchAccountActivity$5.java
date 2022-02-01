package com.tencent.open.agent;

import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class SwitchAccountActivity$5
  implements View.OnTouchListener
{
  protected GestureDetector.SimpleOnGestureListener a;
  protected GestureDetector a;
  View jdField_a_of_type_AndroidViewView;
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  
  SwitchAccountActivity$5(SwitchAccountActivity paramSwitchAccountActivity)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener = new SwitchAccountActivity.5.1(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("action = ");
      localStringBuilder.append(i);
      QLog.i("AccountManage", 2, localStringBuilder.toString());
    }
    if (i == 0)
    {
      this.jdField_a_of_type_AndroidViewView = paramView;
      if (SwitchAccountActivity.access$500(this.jdField_a_of_type_ComTencentOpenAgentSwitchAccountActivity)) {
        SwitchAccountActivity.access$502(this.jdField_a_of_type_ComTencentOpenAgentSwitchAccountActivity, false);
      }
    }
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.SwitchAccountActivity.5
 * JD-Core Version:    0.7.0.1
 */