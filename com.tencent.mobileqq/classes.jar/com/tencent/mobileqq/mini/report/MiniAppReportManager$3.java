package com.tencent.mobileqq.mini.report;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

final class MiniAppReportManager$3
  implements Runnable
{
  MiniAppReportManager$3(MiniAppConfig paramMiniAppConfig, MiniAppReportEntity paramMiniAppReportEntity, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    MiniAppReportManager.access$100(this.val$appConfig, this.val$entity.launchId, this.val$entity.appType, null, "page_view", this.val$subActionType, this.val$reserves, this.val$reserves2, this.val$reserves3, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppReportManager.3
 * JD-Core Version:    0.7.0.1
 */