package com.tencent.open.agent;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class SwitchAccountActivity$5$1
  extends GestureDetector.SimpleOnGestureListener
{
  SwitchAccountActivity$5$1(SwitchAccountActivity.5 param5) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((Math.abs(paramFloat1) > Math.abs(paramFloat2)) && (Math.abs(paramFloat1) > 20.0F) && (!SwitchAccountActivity.access$500(this.a.jdField_a_of_type_ComTencentOpenAgentSwitchAccountActivity)))
    {
      SwitchAccountActivity.access$502(this.a.jdField_a_of_type_ComTencentOpenAgentSwitchAccountActivity, true);
      if (this.a.jdField_a_of_type_AndroidViewView != null) {
        this.a.jdField_a_of_type_AndroidViewView.setPressed(false);
      }
      if ((paramFloat1 < -20.0F) && (this.a.jdField_a_of_type_JavaLangRefWeakReference != null))
      {
        paramMotionEvent1 = (View)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramMotionEvent1 != null)
        {
          paramMotionEvent1 = paramMotionEvent1.findViewById(2131377351);
          if ((paramMotionEvent1 != null) && (paramMotionEvent1.getVisibility() == 0)) {
            ((ShaderAnimLayout)paramMotionEvent1).e();
          }
        }
        this.a.jdField_a_of_type_JavaLangRefWeakReference = null;
      }
      if (paramFloat1 > 20.0F)
      {
        if ((this.a.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.a.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
        {
          paramMotionEvent1 = (View)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (paramMotionEvent1 != this.a.jdField_a_of_type_AndroidViewView)
          {
            paramMotionEvent1 = paramMotionEvent1.findViewById(2131377351);
            if ((paramMotionEvent1 != null) && (paramMotionEvent1.getVisibility() == 0)) {
              ((ShaderAnimLayout)paramMotionEvent1).e();
            }
          }
          this.a.jdField_a_of_type_JavaLangRefWeakReference = null;
          return true;
        }
        if (this.a.jdField_a_of_type_AndroidViewView != null)
        {
          paramMotionEvent1 = this.a.jdField_a_of_type_AndroidViewView.findViewById(2131377351);
          if ((paramMotionEvent1 != null) && (paramMotionEvent1.getVisibility() != 0))
          {
            if (QLog.isColorLevel()) {
              QLog.i("AccountManage", 2, "show current selectedAccountView");
            }
            ((ShaderAnimLayout)paramMotionEvent1).a();
            paramMotionEvent1 = this.a;
            paramMotionEvent1.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramMotionEvent1.jdField_a_of_type_AndroidViewView);
            this.a.jdField_a_of_type_AndroidViewView = null;
          }
        }
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.SwitchAccountActivity.5.1
 * JD-Core Version:    0.7.0.1
 */