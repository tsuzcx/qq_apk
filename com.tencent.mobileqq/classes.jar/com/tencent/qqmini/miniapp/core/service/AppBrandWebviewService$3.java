package com.tencent.qqmini.miniapp.core.service;

import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.report.MiniReportManager;

class AppBrandWebviewService$3
  implements Runnable
{
  AppBrandWebviewService$3(AppBrandWebviewService paramAppBrandWebviewService, int paramInt, String paramString) {}
  
  public void run()
  {
    MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), this.val$id, "0", this.val$reason, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.AppBrandWebviewService.3
 * JD-Core Version:    0.7.0.1
 */