package com.tencent.mobileqq.datareportviewer;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DataReportViewer$1
  implements CompoundButton.OnCheckedChangeListener
{
  DataReportViewer$1(DataReportViewer paramDataReportViewer) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    DataReportViewer localDataReportViewer = this.a;
    localDataReportViewer.n = paramBoolean;
    if (localDataReportViewer.n) {
      this.a.a();
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportViewer.1
 * JD-Core Version:    0.7.0.1
 */