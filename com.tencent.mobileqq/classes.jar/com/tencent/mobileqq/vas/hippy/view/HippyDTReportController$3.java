package com.tencent.mobileqq.vas.hippy.view;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;

class HippyDTReportController$3
  implements View.OnAttachStateChangeListener
{
  HippyDTReportController$3(HippyDTReportController paramHippyDTReportController, View paramView, HashMap paramHashMap) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    VideoReport.setPageParams(this.a, new PageParams(this.b));
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.view.HippyDTReportController.3
 * JD-Core Version:    0.7.0.1
 */