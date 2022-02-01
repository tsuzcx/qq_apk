package com.tencent.mobileqq.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;

public class PAHighLightImageView$ViewOnTouchListener
  implements View.OnTouchListener
{
  Context jdField_a_of_type_AndroidContentContext;
  PAHighLightImageView jdField_a_of_type_ComTencentMobileqqWidgetPAHighLightImageView;
  
  public PAHighLightImageView$ViewOnTouchListener(PAHighLightImageView paramPAHighLightImageView, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPAHighLightImageView = paramPAHighLightImageView;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onTouch is called,action is:");
      paramView.append(paramMotionEvent.getAction());
      QLog.d("PAHighLightImageView", 2, paramView.toString());
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetPAHighLightImageView.getTag(2131373227);
    if (paramView == null) {
      return false;
    }
    boolean bool;
    if (paramView.equals(Integer.valueOf(1)))
    {
      bool = true;
    }
    else
    {
      if (!paramView.equals(Integer.valueOf(2))) {
        break label129;
      }
      bool = false;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPAHighLightImageView.a(this.jdField_a_of_type_AndroidContentContext, bool);
      return false;
    }
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPAHighLightImageView.a();
    }
    label129:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PAHighLightImageView.ViewOnTouchListener
 * JD-Core Version:    0.7.0.1
 */