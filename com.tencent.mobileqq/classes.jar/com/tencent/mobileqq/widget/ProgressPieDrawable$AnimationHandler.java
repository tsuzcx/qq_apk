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
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b - 1);
      sendEmptyMessageDelayed(0, this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.e);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b < this.jdField_a_of_type_Int)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b + this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.f;
      if (i <= this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(i);
      }
      for (;;)
      {
        sendEmptyMessageDelayed(0, this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.e);
        return;
        this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(this.jdField_a_of_type_Int);
      }
    }
    removeMessages(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProgressPieDrawable.AnimationHandler
 * JD-Core Version:    0.7.0.1
 */