package com.tencent.mobileqq.mini.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.qphone.base.util.QLog;

final class MiniProgramLpReportDC04266$2
  implements Runnable
{
  MiniProgramLpReportDC04266$2(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void run()
  {
    String str = MiniProgramReportHelper.launchIdForMiniAppConfig(this.val$miniAppConfig);
    APP_REPORT_TRANSFER.SingleDcData localSingleDcData = MiniProgramReportHelper.newSingleReportData(3, MiniProgramReportHelper.newAppQualityEntries(this.val$miniAppConfig, null, this.val$eventName, this.val$attachInfo, null, String.valueOf(this.val$retCode), MiniReportManager.getAppType(this.val$miniAppConfig), String.valueOf(this.val$costTime), null, String.valueOf(this.val$timestamp), str, this.val$reserves1, this.val$reserves2, this.val$reserves3, this.val$reserves4), null);
    QLog.d("MiniProgramLpReportDC04266", 2, "MiniReportManager  reportCostTimeEvent: costTime event = [" + this.val$eventName + "], costTime result = [" + this.val$retCode + "], appType = [" + MiniReportManager.getAppType(this.val$miniAppConfig) + "], timeCost = [" + this.val$costTime + "],  attachInfo = [" + this.val$attachInfo + "]  launchId:" + str + "  retCode:" + this.val$retCode + "  reserves1:" + this.val$reserves1 + "  reserves2:" + this.val$reserves2 + "  reserves3:" + this.val$reserves3 + "  reserves4:" + this.val$reserves4);
    MiniProgramReporter.getInstance().addData(localSingleDcData);
    MiniProgramLpReportDC05115.reDispatchReportEvent(this.val$miniAppConfig, this.val$eventName, String.valueOf(this.val$retCode), this.val$costTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04266.2
 * JD-Core Version:    0.7.0.1
 */