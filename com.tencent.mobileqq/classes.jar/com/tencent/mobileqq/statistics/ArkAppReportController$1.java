package com.tencent.mobileqq.statistics;

import android.content.Intent;
import com.tencent.qphone.base.util.BaseApplication;

final class ArkAppReportController$1
  implements Runnable
{
  ArkAppReportController$1(String paramString) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(BaseApplication.getContext(), "com.tencent.mobileqq.statistics.ReportReceiver");
    localIntent.putExtra("reporting_tag", "dc01616");
    localIntent.putExtra("reporting_detail", this.a);
    localIntent.putExtra("reporting_count", 1);
    localIntent.putExtra("is_runtime", 0);
    BaseApplication.getContext().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ArkAppReportController.1
 * JD-Core Version:    0.7.0.1
 */