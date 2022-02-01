package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport;

import android.util.Log;
import com.tencent.beacon.event.UserAction;
import com.tencent.falco.base.libapi.datareport.DataReportInterface.DataReportAdapter;
import com.tencent.mobileqq.litelivesdk.afwraper.config.BuildConfig;
import java.util.Map;

class CustomDataReportService$4
  implements Runnable
{
  CustomDataReportService$4(CustomDataReportService paramCustomDataReportService, String paramString, Map paramMap, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.a();
    if (this.this$0.a.isUserHostBeacon())
    {
      if (BuildConfig.jdField_a_of_type_Boolean) {
        Log.d("DataReportService", "aud quality report--eventName=" + this.jdField_a_of_type_JavaLangString + ";params=" + CustomDataReportService.a(this.jdField_a_of_type_JavaUtilMap));
      }
      UserAction.onUserActionToTunnel(this.this$0.a.getAppKey(), this.jdField_a_of_type_JavaLangString, true, -1L, -1L, this.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Boolean);
      return;
    }
    UserAction.onUserAction(this.jdField_a_of_type_JavaLangString, true, -1L, -1L, this.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport.CustomDataReportService.4
 * JD-Core Version:    0.7.0.1
 */