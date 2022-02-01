package com.tencent.qqmini.sdk.report;

import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class SDKMiniProgramLpReportDC04239$13
  implements Runnable
{
  SDKMiniProgramLpReportDC04239$13(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = SDKMiniProgramLpReportDC04239.getAppType(this.val$miniAppConfig);
    SDKMiniProgramLpReportDC04239.access$300(this.val$miniAppConfig, str, null, "drop_down", this.val$subActionType, this.val$reserves);
    MiniProgramReporter.getInstance().flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.13
 * JD-Core Version:    0.7.0.1
 */