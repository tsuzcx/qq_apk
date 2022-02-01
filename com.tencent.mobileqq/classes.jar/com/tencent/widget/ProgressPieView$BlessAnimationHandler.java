package com.tencent.widget;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

class ProgressPieView$BlessAnimationHandler
  extends Handler
{
  long jdField_a_of_type_Long;
  
  ProgressPieView$BlessAnimationHandler(ProgressPieView paramProgressPieView) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = (int)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
    if (i < this.jdField_a_of_type_ComTencentWidgetProgressPieView.a)
    {
      this.jdField_a_of_type_ComTencentWidgetProgressPieView.setProgress(i);
      sendEmptyMessageDelayed(0, 1L);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetProgressPieView.setProgress(this.jdField_a_of_type_ComTencentWidgetProgressPieView.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.ProgressPieView.BlessAnimationHandler
 * JD-Core Version:    0.7.0.1
 */