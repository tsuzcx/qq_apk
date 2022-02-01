package com.tencent.mobileqq.mini.report;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

final class MiniProgramLpReportDC04239$9
  implements Runnable
{
  MiniProgramLpReportDC04239$9(String paramString, MiniAppConfig paramMiniAppConfig) {}
  
  public void run()
  {
    MiniAppConfig localMiniAppConfig = this.val$miniAppConfig;
    if ((localMiniAppConfig != null) && (localMiniAppConfig.config != null))
    {
      localMiniAppConfig = this.val$miniAppConfig;
      MiniProgramLpReportDC04239.access$000(localMiniAppConfig, MiniProgramLpReportDC04239.getAppType(localMiniAppConfig), null, "inner-app", "from_api", this.val$eventName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.9
 * JD-Core Version:    0.7.0.1
 */