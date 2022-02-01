package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Message;

class ProgressPieDrawable$AnimationHandler
  extends Handler
{
  public int a;
  
  ProgressPieDrawable$AnimationHandler(ProgressPieDrawable paramProgressPieDrawable) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.isVisible())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b = this.jdField_a_of_type_Int;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b > this.jdField_a_of_type_Int)
    {
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
      paramMessage.c(paramMessage.b - 1);
      sendEmptyMessageDelayed(0, this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.e);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b < this.jdField_a_of_type_Int)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b + this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.f;
      int j = this.jdField_a_of_type_Int;
      if (i <= j) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(i);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(j);
      }
      sendEmptyMessageDelayed(0, this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.e);
      return;
    }
    removeMessages(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProgressPieDrawable.AnimationHandler
 * JD-Core Version:    0.7.0.1
 */