package com.tencent.mobileqq.mini.report;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

final class MiniProgramLpReportDC04239$8
  implements Runnable
{
  MiniProgramLpReportDC04239$8(String paramString, MiniAppConfig paramMiniAppConfig) {}
  
  public void run()
  {
    if ((this.val$miniAppConfig != null) && (this.val$miniAppConfig.config != null)) {
      MiniProgramLpReportDC04239.access$000(this.val$miniAppConfig, MiniProgramLpReportDC04239.getAppType(this.val$miniAppConfig), null, "inner-app", "from_api", this.val$eventName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.8
 * JD-Core Version:    0.7.0.1
 */