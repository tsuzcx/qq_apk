package com.tencent.mobileqq.statistics;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

final class DcReportUtil$2
  implements Runnable
{
  DcReportUtil$2(String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(MobileQQ.context, "com.tencent.mobileqq.statistics.ReportReceiver");
      localIntent.putExtra("reporting_tag", this.a);
      localIntent.putExtra("reporting_detail", this.b);
      localIntent.putExtra("reporting_count", 1);
      localIntent.putExtra("is_runtime", 0);
      MobileQQ.sMobileQQ.sendBroadcast(localIntent);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("DcReportUtil", 1, "reportDCEvent e:" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.DcReportUtil.2
 * JD-Core Version:    0.7.0.1
 */