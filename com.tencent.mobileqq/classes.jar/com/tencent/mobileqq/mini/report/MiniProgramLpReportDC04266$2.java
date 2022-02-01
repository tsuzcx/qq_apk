package com.tencent.mobileqq.mini.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

final class MiniProgramLpReportDC04266$2
  implements Runnable
{
  MiniProgramLpReportDC04266$2(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong1, long paramLong2, String paramString4, String paramString5, String paramString6, String paramString7) {}
  
  public void run()
  {
    String str = MiniProgramReportHelper.launchIdForMiniAppConfig(this.val$miniAppConfig);
    Object localObject = MiniProgramReportHelper.newAppQualityEntries(this.val$miniAppConfig, AppBrandUtil.getUrlWithoutParams(this.val$page), this.val$eventName, this.val$attachInfo, null, String.valueOf(this.val$retCode), MiniReportManager.getAppType(this.val$miniAppConfig), String.valueOf(this.val$costTime), null, String.valueOf(this.val$timestamp), str, this.val$reserves1, this.val$reserves2, this.val$reserves3, this.val$reserves4);
    APP_REPORT_TRANSFER.SingleDcData localSingleDcData = MiniProgramReportHelper.newSingleReportData(MiniProgramLpReportDC04266.access$000(), (List)localObject, null);
    MiniProgramReporter.getInstance().addData(localSingleDcData);
    if (MiniReportManager.needReportToDC5332(MiniReportManager.getAppType(this.val$miniAppConfig), this.val$eventName, this.val$reserves4))
    {
      localObject = MiniProgramReportHelper.newSingleReportData(MiniProgramLpReportDC04266.access$100(), (List)localObject, null);
      MiniProgramReporter.getInstance().addData((APP_REPORT_TRANSFER.SingleDcData)localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MiniReportManager  reportCostTimeEvent: costTime event = [");
    ((StringBuilder)localObject).append(this.val$eventName);
    ((StringBuilder)localObject).append("], costTime result = [");
    ((StringBuilder)localObject).append(this.val$retCode);
    ((StringBuilder)localObject).append("], appType = [");
    ((StringBuilder)localObject).append(MiniReportManager.getAppType(this.val$miniAppConfig));
    ((StringBuilder)localObject).append("], timeCost = [");
    ((StringBuilder)localObject).append(this.val$costTime);
    ((StringBuilder)localObject).append("],  attachInfo = [");
    ((StringBuilder)localObject).append(this.val$attachInfo);
    ((StringBuilder)localObject).append("]  launchId:");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("  retCode:");
    ((StringBuilder)localObject).append(this.val$retCode);
    ((StringBuilder)localObject).append("  reserves1:");
    ((StringBuilder)localObject).append(this.val$reserves1);
    ((StringBuilder)localObject).append("  reserves2:");
    ((StringBuilder)localObject).append(this.val$reserves2);
    ((StringBuilder)localObject).append("  reserves3:");
    ((StringBuilder)localObject).append(this.val$reserves3);
    ((StringBuilder)localObject).append("  reserves4:");
    ((StringBuilder)localObject).append(this.val$reserves4);
    QLog.d("MiniProgramLpReportDC04266", 2, ((StringBuilder)localObject).toString());
    MiniProgramLpReportDC05115.reDispatchReportEvent(this.val$miniAppConfig, this.val$eventName, String.valueOf(this.val$retCode), this.val$costTime, this.val$reserves4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04266.2
 * JD-Core Version:    0.7.0.1
 */