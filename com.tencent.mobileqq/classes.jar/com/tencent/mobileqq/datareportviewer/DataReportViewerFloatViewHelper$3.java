package com.tencent.mobileqq.datareportviewer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.HashMap;

class DataReportViewerFloatViewHelper$3
  extends BroadcastReceiver
{
  DataReportViewerFloatViewHelper$3(DataReportViewerFloatViewHelper paramDataReportViewerFloatViewHelper) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = (ReportData)paramIntent.getSerializableExtra("reportData");
    paramIntent = (ReportDataConfig)DataReportViewerFloatViewHelper.c(this.a).get(paramContext.actionName);
    if ((paramIntent != null) && (paramIntent.c()))
    {
      this.a.b();
      DataReportViewerFloatViewHelper.a(this.a).a(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportViewerFloatViewHelper.3
 * JD-Core Version:    0.7.0.1
 */