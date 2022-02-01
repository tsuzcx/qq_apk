package com.tencent.mobileqq.vas.hippy.view;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mobileqq.data.dt.QQDtConfig;
import com.tencent.qqlive.module.videoreport.VideoReport;

class HippyDTReportController$1
  implements View.OnAttachStateChangeListener
{
  HippyDTReportController$1(HippyDTReportController paramHippyDTReportController, View paramView, String paramString) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    VideoReport.setPageId(this.a, this.b);
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (this.c.mDtCustomPublicParams != null)
    {
      QQDtConfig.a().b(this.c.mDtCustomPublicParams);
      this.c.mDtCustomPublicParams = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.view.HippyDTReportController.1
 * JD-Core Version:    0.7.0.1
 */