package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.report.MiniReportManager;

class PageWebview$1
  implements Runnable
{
  PageWebview$1(PageWebview paramPageWebview, int paramInt, String paramString) {}
  
  public void run()
  {
    MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), this.val$id, "0", this.val$reason, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebview.1
 * JD-Core Version:    0.7.0.1
 */