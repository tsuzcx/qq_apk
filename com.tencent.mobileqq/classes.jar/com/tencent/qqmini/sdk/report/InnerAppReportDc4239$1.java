package com.tencent.qqmini.sdk.report;

import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class InnerAppReportDc4239$1
  implements Runnable
{
  InnerAppReportDc4239$1(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    SDKMiniProgramLpReportDC04239.report(this.val$miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(this.val$miniAppInfo), this.val$path, "inner_app", "from_api", this.val$reservesAction, this.val$reserves2, this.val$reserves3, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.InnerAppReportDc4239.1
 * JD-Core Version:    0.7.0.1
 */