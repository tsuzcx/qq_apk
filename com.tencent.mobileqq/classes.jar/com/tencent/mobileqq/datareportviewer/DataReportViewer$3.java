package com.tencent.mobileqq.datareportviewer;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DataReportViewer$3
  implements View.OnClickListener
{
  DataReportViewer$3(DataReportViewer paramDataReportViewer, WindowManager paramWindowManager) {}
  
  public void onClick(View paramView)
  {
    this.a.removeViewImmediate(this.b.m);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportViewer.3
 * JD-Core Version:    0.7.0.1
 */