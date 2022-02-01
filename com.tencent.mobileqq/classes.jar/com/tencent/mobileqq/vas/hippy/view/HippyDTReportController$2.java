package com.tencent.mobileqq.vas.hippy.view;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.qqlive.module.videoreport.VideoReport;

class HippyDTReportController$2
  implements View.OnAttachStateChangeListener
{
  HippyDTReportController$2(HippyDTReportController paramHippyDTReportController, View paramView, String paramString) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    VideoReport.setElementId(this.a, this.b);
    VideoReport.traverseExposure();
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.view.HippyDTReportController.2
 * JD-Core Version:    0.7.0.1
 */