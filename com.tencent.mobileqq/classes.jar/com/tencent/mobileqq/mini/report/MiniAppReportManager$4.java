package com.tencent.mobileqq.mini.report;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

final class MiniAppReportManager$4
  implements Runnable
{
  MiniAppReportManager$4(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    MiniAppReportManager.access$100(this.val$miniAppConfig, null, this.val$appType, this.val$path, "page_view", this.val$subActionType, this.val$reserves, null, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppReportManager.4
 * JD-Core Version:    0.7.0.1
 */