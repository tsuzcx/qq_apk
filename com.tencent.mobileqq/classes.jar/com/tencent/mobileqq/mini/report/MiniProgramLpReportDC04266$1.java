package com.tencent.mobileqq.mini.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import java.util.List;

final class MiniProgramLpReportDC04266$1
  implements Runnable
{
  MiniProgramLpReportDC04266$1(int paramInt1, MiniAppConfig paramMiniAppConfig, int paramInt2, String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9) {}
  
  public void run()
  {
    MiniProgramReportHelper.checkShouldAssignPreloadLaunchId(this.val$eventType);
    if (this.val$eventType == 1)
    {
      MiniProgramReportHelper.assignAppLaunchId(this.val$miniAppConfig);
      if ((this.val$miniAppConfig != null) && (this.val$miniAppConfig.config != null)) {
        MiniProgramReporter.getInstance().addLaunchMiniAppRecord(this.val$miniAppConfig.config.appId, MiniProgramReportHelper.launchIdForMiniAppConfig(this.val$miniAppConfig));
      }
    }
    if ((this.val$eventType == 611) && (this.val$miniAppConfig != null) && (this.val$miniAppConfig.config != null))
    {
      str = MiniProgramReporter.getInstance().getLaunchMiniAppRecord(this.val$miniAppConfig.config.appId);
      localObject = MiniProgramReportHelper.launchIdForMiniAppConfig(this.val$miniAppConfig);
      if ((str != null) && (str.equals(localObject))) {
        MiniProgramReporter.getInstance().removeLaunchMiniAppRecord(this.val$miniAppConfig.config.appId);
      }
    }
    Object localObject = MiniProgramReportHelper.launchIdForMiniAppConfig(this.val$miniAppConfig);
    String str = MiniReportManager.getEventName(this.val$eventType);
    localObject = MiniProgramReportHelper.newAppQualityEntries(this.val$miniAppConfig, AppBrandUtil.getUrlWithoutParams(this.val$page), str, this.val$attachInfo, this.val$ssoCmdName, String.valueOf(this.val$ssoCmdRetCode), this.val$appType, String.valueOf(this.val$timeCost), this.val$httpRequestThirdUrl, String.valueOf(this.val$timestamp), (String)localObject, this.val$reserves1, this.val$reserves2, this.val$reserves3, this.val$reserves4);
    if (MiniReportManager.needReportToDC4266(str))
    {
      APP_REPORT_TRANSFER.SingleDcData localSingleDcData = MiniProgramReportHelper.newSingleReportData(MiniProgramLpReportDC04266.access$000(), (List)localObject, null);
      MiniProgramReporter.getInstance().addData(localSingleDcData);
    }
    if (MiniReportManager.needReportToDC5332(this.val$appType, str, this.val$reserves4))
    {
      localObject = MiniProgramReportHelper.newSingleReportData(MiniProgramLpReportDC04266.access$100(), (List)localObject, null);
      MiniProgramReporter.getInstance().addData((APP_REPORT_TRANSFER.SingleDcData)localObject);
    }
    MiniProgramLpReportDC05115.reDispatchReportEvent(this.val$miniAppConfig, str, String.valueOf(this.val$ssoCmdRetCode), this.val$timeCost, this.val$reserves4);
    if (MiniProgramLpReportDC04266.access$200(this.val$eventType)) {
      MiniProgramReporter.getInstance().flush();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04266.1
 * JD-Core Version:    0.7.0.1
 */