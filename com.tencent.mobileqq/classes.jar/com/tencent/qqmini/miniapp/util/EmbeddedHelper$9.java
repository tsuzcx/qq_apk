package com.tencent.qqmini.miniapp.util;

import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.report.MiniReportManager;

final class EmbeddedHelper$9
  implements Runnable
{
  EmbeddedHelper$9(int paramInt, String paramString) {}
  
  public void run()
  {
    MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), this.val$id, "0", this.val$reason, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.EmbeddedHelper.9
 * JD-Core Version:    0.7.0.1
 */