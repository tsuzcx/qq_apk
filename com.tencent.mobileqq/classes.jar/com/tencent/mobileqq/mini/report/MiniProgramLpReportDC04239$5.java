package com.tencent.mobileqq.mini.report;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

final class MiniProgramLpReportDC04239$5
  implements Runnable
{
  public void run()
  {
    MiniAppInfo localMiniAppInfo = new MiniAppInfo();
    MiniAppConfig localMiniAppConfig = new MiniAppConfig(localMiniAppInfo);
    localMiniAppConfig.launchParam.scene = 2009;
    localMiniAppInfo.via = "2009_1";
    localMiniAppInfo.appId = "1108291530";
    MiniProgramLpReportDC04239.reportMiniAppEvent(localMiniAppConfig, "0", null, "page_view", "expo", null, null);
    MiniProgramReporter.getInstance().flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.5
 * JD-Core Version:    0.7.0.1
 */