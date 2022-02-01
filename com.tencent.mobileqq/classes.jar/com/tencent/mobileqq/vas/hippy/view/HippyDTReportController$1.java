package com.tencent.mobileqq.vas.hippy.view;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.qqlive.module.videoreport.VideoReport;

class HippyDTReportController$1
  implements View.OnAttachStateChangeListener
{
  HippyDTReportController$1(HippyDTReportController paramHippyDTReportController, View paramView, String paramString) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    VideoReport.setPageId(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_JavaLangString);
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.view.HippyDTReportController.1
 * JD-Core Version:    0.7.0.1
 */