package com.tencent.thumbplayer.tplayer.plugins.report;

import android.telephony.TelephonyManager;

class TPReportManager$2
  implements Runnable
{
  TPReportManager$2(TPReportManager paramTPReportManager, TelephonyManager paramTelephonyManager) {}
  
  public void run()
  {
    TPReportManager.access$3500(this.this$0);
    this.val$telMgr.listen(TPReportManager.access$3600(this.this$0), 256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportManager.2
 * JD-Core Version:    0.7.0.1
 */