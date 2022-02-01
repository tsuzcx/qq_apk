package com.tencent.qqmini.sdk.report;

import com.tencent.qqmini.sdk.entry.MiniAppExposureManager.MiniAppExposureData;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.Iterator;
import java.util.List;

final class SDKMiniProgramLpReportDC04239$6
  implements Runnable
{
  SDKMiniProgramLpReportDC04239$6(List paramList, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void run()
  {
    Iterator localIterator = this.val$appConfigList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (MiniAppExposureManager.MiniAppExposureData)localIterator.next();
      if ((localObject != null) && (((MiniAppExposureManager.MiniAppExposureData)localObject).getMiniAppConfig() != null))
      {
        MiniAppInfo localMiniAppInfo = ((MiniAppExposureManager.MiniAppExposureData)localObject).getMiniAppConfig();
        if ((localMiniAppInfo.launchParam == null) || (!this.val$reportReserves2) || ((localMiniAppInfo.launchParam.scene != 3009) && (localMiniAppInfo.launchParam.scene != 3010)))
        {
          String str1 = SDKMiniProgramLpReportDC04239.getAppType(localMiniAppInfo);
          String str2 = this.val$path;
          String str3 = this.val$subActionType;
          int i = ((MiniAppExposureManager.MiniAppExposureData)localObject).getPosition();
          if (this.val$reportReserves2) {
            localObject = ((MiniAppExposureManager.MiniAppExposureData)localObject).getReserves2();
          } else {
            localObject = null;
          }
          SDKMiniProgramLpReportDC04239.exposureReport(localMiniAppInfo, str1, str2, "page_view", str3, String.valueOf(i), (String)localObject);
        }
      }
    }
    MiniProgramReporter.getInstance().flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.6
 * JD-Core Version:    0.7.0.1
 */