package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport;

import android.util.Log;
import com.tencent.falco.base.libapi.datareport.DataReportInterface.DataReportAdapter;
import com.tencent.mobileqq.litelivesdk.afwraper.config.BuildConfig;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import java.util.HashMap;

class CustomDataReportService$4
  implements Runnable
{
  CustomDataReportService$4(CustomDataReportService paramCustomDataReportService, String paramString, HashMap paramHashMap, boolean paramBoolean) {}
  
  public void run()
  {
    if (BuildConfig.jdField_a_of_type_Boolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("aud quality report--eventName=");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(";params=");
      localStringBuilder.append(CustomDataReportService.a(this.jdField_a_of_type_JavaUtilHashMap));
      Log.d("DataReportService", localStringBuilder.toString());
    }
    if (this.this$0.a.isUserHostBeacon())
    {
      QQBeaconReport.a(this.this$0.a.getAppKey(), "", this.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Boolean);
      return;
    }
    QQBeaconReport.a("", this.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport.CustomDataReportService.4
 * JD-Core Version:    0.7.0.1
 */