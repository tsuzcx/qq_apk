package com.tencent.mobileqq.mini.report;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

final class MiniProgramLpReportDC04239$12
  implements Runnable
{
  MiniProgramLpReportDC04239$12(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = MiniProgramLpReportDC04239.getAppType(this.val$miniAppConfig);
    MiniProgramLpReportDC04239.access$000(this.val$miniAppConfig, str, null, "drop_down", this.val$subActionType, this.val$reserves);
    MiniProgramReporter.getInstance().flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.12
 * JD-Core Version:    0.7.0.1
 */