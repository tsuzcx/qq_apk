package com.tencent.qqmini.sdk.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.List;

final class MiniProgramLpReportDC04266$2
  implements Runnable
{
  MiniProgramLpReportDC04266$2(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {}
  
  public void run()
  {
    String str = MiniProgramReportHelper.launchIdForMiniAppConfig(this.val$miniAppConfig);
    Object localObject = MiniProgramReportHelper.newAppQualityEntries(this.val$miniAppConfig, null, this.val$eventName, this.val$attachInfo, null, String.valueOf(this.val$retCode), MiniReportManager.getAppType(this.val$miniAppConfig), String.valueOf(this.val$costTime), null, String.valueOf(this.val$timestamp), str, this.val$reserves1, this.val$reserves2, this.val$reserves3, this.val$reserves4, this.val$renderMode);
    if (!QUAUtil.isQQApp()) {
      ((List)localObject).addAll(MiniProgramReportHelper.newThirdSourceEntries());
    }
    APP_REPORT_TRANSFER.SingleDcData localSingleDcData = MiniProgramReportHelper.newSingleReportData(MiniProgramLpReportDC04266.access$000(), (List)localObject, null);
    MiniProgramReporter.getInstance().addData(localSingleDcData);
    if (MiniReportManager.needReportToDC5332(MiniReportManager.getAppType(this.val$miniAppConfig), this.val$eventName, this.val$reserves4))
    {
      localObject = MiniProgramReportHelper.newSingleReportData(MiniProgramLpReportDC04266.access$100(), (List)localObject, null);
      MiniProgramReporter.getInstance().addData((APP_REPORT_TRANSFER.SingleDcData)localObject);
      if (QMLog.isDebugEnabled())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MiniReportManager  [5332] reportCostTimeEvent: costTime event = [");
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
        QMLog.d("MiniProgramLpReportDC04266", ((StringBuilder)localObject).toString());
      }
    }
    if (QMLog.isDebugEnabled())
    {
      if (!TextUtils.isEmpty(this.val$eventName))
      {
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
        QMLog.d("MiniProgramLpReportDC04266", ((StringBuilder)localObject).toString());
        return;
      }
      QMLog.e("MiniProgramLpReportDC04266", "eventName not found!");
      throw new AssertionError("MiniProgramLpReportDC04266 eventName not found!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04266.2
 * JD-Core Version:    0.7.0.1
 */