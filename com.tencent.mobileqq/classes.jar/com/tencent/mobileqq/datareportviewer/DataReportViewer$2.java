package com.tencent.mobileqq.datareportviewer;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DataReportViewer$2
  implements AdapterView.OnItemClickListener
{
  DataReportViewer$2(DataReportViewer paramDataReportViewer, Context paramContext) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    DataReportViewer.a(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer, this.jdField_a_of_type_AndroidContentContext, paramInt);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportViewer.2
 * JD-Core Version:    0.7.0.1
 */