package com.tencent.mobileqq.statistics;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;

public final class DcReportUtil$2
  implements Runnable
{
  public DcReportUtil$2(String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      localIntent.putExtra("reporting_tag", this.a);
      localIntent.putExtra("reporting_detail", this.b);
      localIntent.putExtra("reporting_count", 1);
      localIntent.putExtra("is_runtime", 0);
      BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.DcReportUtil.2
 * JD-Core Version:    0.7.0.1
 */