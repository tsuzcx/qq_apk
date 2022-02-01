package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport;

import android.os.Bundle;
import android.util.Log;
import com.tencent.beacon.event.UserAction;
import com.tencent.falco.base.libapi.datareport.DataReportInterface.DataReportAdapter;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.hostproxy.HostReportInterface;
import com.tencent.mobileqq.litelivesdk.afwraper.config.BuildConfig;
import java.util.Map;

class CustomDataReportService$1
  implements Runnable
{
  CustomDataReportService$1(CustomDataReportService paramCustomDataReportService, Map paramMap, String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void run()
  {
    if (this.this$0.a.getHostProxy().getReportInterface() != null)
    {
      Object localObject = this.this$0.a.getHostProxy().getReportInterface().getHostReportData();
      if (localObject != null) {
        this.jdField_a_of_type_JavaUtilMap.putAll((Map)localObject);
      }
      localObject = this.this$0.a.getHostProxy().getReportInterface().getHostReportData(this.jdField_a_of_type_JavaLangString);
      if (localObject != null) {
        this.jdField_a_of_type_JavaUtilMap.putAll((Map)localObject);
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("anchor", (String)this.jdField_a_of_type_JavaUtilMap.get("anchor"));
      localObject = this.this$0.a.getHostProxy().getReportInterface().getHostReportPrivateData(this.jdField_a_of_type_JavaLangString, (Bundle)localObject);
      if (localObject != null) {
        this.jdField_a_of_type_JavaUtilMap.put("zt_str6", localObject);
      }
    }
    this.this$0.a();
    if (this.this$0.a.isUserHostBeacon())
    {
      if (BuildConfig.jdField_a_of_type_Boolean) {
        Log.d("DataReportService", "product report--eventName=" + this.jdField_a_of_type_JavaLangString + ";params=" + CustomDataReportService.a(this.jdField_a_of_type_JavaUtilMap));
      }
      UserAction.onUserActionToTunnel(this.this$0.a.getAppKey(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_a_of_type_JavaUtilMap, this.jdField_b_of_type_Boolean, this.c);
    }
    for (;;)
    {
      Log.d("DataReportService", "product report qimei=" + UserAction.getQIMEI() + ",adapter.getAppKey()=" + this.this$0.a.getAppKey());
      return;
      UserAction.onUserAction(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_a_of_type_JavaUtilMap, this.jdField_b_of_type_Boolean, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport.CustomDataReportService.1
 * JD-Core Version:    0.7.0.1
 */