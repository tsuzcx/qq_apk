package com.tencent.mobileqq.mini.report;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppExposureData;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import java.util.Iterator;
import java.util.List;

final class MiniProgramLpReportDC04239$12
  implements Runnable
{
  MiniProgramLpReportDC04239$12(List paramList, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void run()
  {
    Iterator localIterator = this.val$appConfigList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (MiniAppExposureManager.MiniAppExposureData)localIterator.next();
      if ((localObject != null) && (((MiniAppExposureManager.MiniAppExposureData)localObject).getMiniAppConfig() != null))
      {
        MiniAppConfig localMiniAppConfig = ((MiniAppExposureManager.MiniAppExposureData)localObject).getMiniAppConfig();
        if ((localMiniAppConfig.launchParam == null) || (!this.val$reportReserves2) || ((localMiniAppConfig.launchParam.scene != 3009) && (localMiniAppConfig.launchParam.scene != 3010)))
        {
          String str1 = MiniProgramLpReportDC04239.getAppType(localMiniAppConfig);
          String str2 = this.val$path;
          String str3 = this.val$subActionType;
          int i = ((MiniAppExposureManager.MiniAppExposureData)localObject).getPosition();
          if (this.val$reportReserves2) {}
          for (localObject = ((MiniAppExposureManager.MiniAppExposureData)localObject).getReserves2();; localObject = null)
          {
            MiniProgramLpReportDC04239.exposureReport(localMiniAppConfig, str1, str2, "page_view", str3, String.valueOf(i), (String)localObject);
            break;
          }
        }
      }
    }
    MiniProgramReporter.getInstance().flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.12
 * JD-Core Version:    0.7.0.1
 */