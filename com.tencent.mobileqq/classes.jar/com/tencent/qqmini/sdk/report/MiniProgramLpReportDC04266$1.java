package com.tencent.qqmini.sdk.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.List;

final class MiniProgramLpReportDC04266$1
  implements Runnable
{
  MiniProgramLpReportDC04266$1(int paramInt1, MiniAppInfo paramMiniAppInfo, int paramInt2, String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10) {}
  
  public void run()
  {
    MiniProgramReportHelper.checkShouldAssignPreloadLaunchId(this.val$eventType);
    if (this.val$eventType == 1)
    {
      MiniProgramReportHelper.assignAppLaunchId(this.val$miniAppConfig);
      if (this.val$miniAppConfig != null) {
        MiniProgramReporter.getInstance().addLaunchMiniAppRecord(this.val$miniAppConfig.appId, MiniProgramReportHelper.launchIdForMiniAppConfig(this.val$miniAppConfig));
      }
    }
    if ((this.val$eventType == 611) && (this.val$miniAppConfig != null))
    {
      str1 = MiniProgramReporter.getInstance().getLaunchMiniAppRecord(this.val$miniAppConfig.appId);
      str2 = MiniProgramReportHelper.launchIdForMiniAppConfig(this.val$miniAppConfig);
      if ((str1 != null) && (str1.equals(str2))) {
        MiniProgramReporter.getInstance().removeLaunchMiniAppRecord(this.val$miniAppConfig.appId);
      }
    }
    String str1 = MiniProgramReportHelper.launchIdForMiniAppConfig(this.val$miniAppConfig);
    String str2 = MiniReportManager.getEventName(this.val$eventType);
    if (QMLog.isDebugEnabled())
    {
      if (TextUtils.isEmpty(str2))
      {
        QMLog.e("MiniProgramLpReportDC04266", "eventName not found!");
        throw new AssertionError("MiniProgramLpReportDC04266 eventName not found!");
      }
      QMLog.d("MiniProgramLpReportDC04266", "MiniReportManager  reportEventType() called with: eventType = [" + this.val$eventType + "]" + str2 + "  retCode:" + this.val$ssoCmdRetCode + "  attachInfo: " + this.val$attachInfo + "  timestamp: " + this.val$timestamp + "  launchId: " + str1 + " timecost: " + this.val$timeCost + " reserves1:" + this.val$reserves1 + " reserves2:" + this.val$reserves2);
    }
    Object localObject = MiniProgramReportHelper.newAppQualityEntries(this.val$miniAppConfig, AppBrandUtil.getUrlWithoutParams(this.val$page), str2, this.val$attachInfo, this.val$ssoCmdName, String.valueOf(this.val$ssoCmdRetCode), this.val$appType, String.valueOf(this.val$timeCost), this.val$httpRequestThirdUrl, String.valueOf(this.val$timestamp), str1, this.val$reserves1, this.val$reserves2, this.val$reserves3, this.val$reserves4, this.val$renderMode);
    if (!QUAUtil.isQQApp()) {
      ((List)localObject).addAll(MiniProgramReportHelper.newThirdSourceEntries());
    }
    APP_REPORT_TRANSFER.SingleDcData localSingleDcData = MiniProgramReportHelper.newSingleReportData(MiniProgramLpReportDC04266.access$000(), (List)localObject, null);
    MiniProgramReporter.getInstance().addData(localSingleDcData);
    if (MiniReportManager.needReportToDC5332(this.val$appType, str2, this.val$reserves4))
    {
      localObject = MiniProgramReportHelper.newSingleReportData(MiniProgramLpReportDC04266.access$100(), (List)localObject, null);
      MiniProgramReporter.getInstance().addData((APP_REPORT_TRANSFER.SingleDcData)localObject);
      if (QMLog.isDebugEnabled()) {
        QMLog.d("MiniProgramLpReportDC04266", "MiniReportManager  [5332] reportEventType() called with: eventType = [" + this.val$eventType + "]" + str2 + "  retCode:" + this.val$ssoCmdRetCode + "  attachInfo: " + this.val$attachInfo + "  timestamp: " + this.val$timestamp + "  launchId: " + str1 + " timecost: " + this.val$timeCost);
      }
    }
    if (MiniProgramLpReportDC04266.access$200(this.val$eventType)) {
      MiniProgramReporter.getInstance().flush();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04266.1
 * JD-Core Version:    0.7.0.1
 */