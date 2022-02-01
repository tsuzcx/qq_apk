package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport;

import android.util.Log;
import com.tencent.falco.base.libapi.datareport.DataReportInterface.DataReportAdapter;
import com.tencent.mobileqq.litelivesdk.afwraper.config.BuildConfig;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import java.util.HashMap;

class CustomDataReportService$2
  implements Runnable
{
  CustomDataReportService$2(CustomDataReportService paramCustomDataReportService, String paramString, HashMap paramHashMap, boolean paramBoolean) {}
  
  public void run()
  {
    if (BuildConfig.a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("anchor quality report--eventName=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(";params=");
      localStringBuilder.append(CustomDataReportService.b(this.b));
      Log.d("DataReportService", localStringBuilder.toString());
    }
    if (this.this$0.a.isUserHostBeacon())
    {
      QQBeaconReport.a(this.this$0.a.getAppKey(), "", this.a, true, this.b, this.c);
      return;
    }
    QQBeaconReport.a("", this.a, true, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport.CustomDataReportService.2
 * JD-Core Version:    0.7.0.1
 */