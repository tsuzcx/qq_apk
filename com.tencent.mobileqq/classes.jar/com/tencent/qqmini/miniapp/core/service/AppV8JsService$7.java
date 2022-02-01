package com.tencent.qqmini.miniapp.core.service;

import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.report.MiniReportManager;

class AppV8JsService$7
  implements Runnable
{
  AppV8JsService$7(AppV8JsService paramAppV8JsService, int paramInt, String paramString) {}
  
  public void run()
  {
    MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), this.val$id, "0", this.val$reason, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.AppV8JsService.7
 * JD-Core Version:    0.7.0.1
 */