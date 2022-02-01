package com.tencent.mobileqq.datareportviewer;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DataReportViewer$4
  implements View.OnClickListener
{
  DataReportViewer$4(DataReportViewer paramDataReportViewer, Context paramContext, ReportData paramReportData, WindowManager paramWindowManager) {}
  
  public void onClick(View paramView)
  {
    ClipboardManager localClipboardManager = (ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard");
    if (localClipboardManager != null)
    {
      ClipData localClipData = ClipData.newPlainText(null, this.jdField_a_of_type_ComTencentMobileqqDatareportviewerReportData.toString());
      ClipboardMonitor.setPrimaryClip(localClipboardManager, localClipData);
      localClipboardManager.setPrimaryClip(localClipData);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.getContext(), HardCodeUtil.a(2131702938), 0).a();
    }
    this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportViewer.4
 * JD-Core Version:    0.7.0.1
 */