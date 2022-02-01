package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport;

import android.os.Bundle;
import android.util.Log;
import com.tencent.beacon.event.UserAction;
import com.tencent.falco.base.libapi.datareport.DataReportInterface.DataReportAdapter;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.hostproxy.HostReportInterface;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import java.util.HashMap;
import java.util.Map;

class CustomDataReportService$1
  implements Runnable
{
  CustomDataReportService$1(CustomDataReportService paramCustomDataReportService, HashMap paramHashMap, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.this$0.a.getHostProxy().getReportInterface() != null)
    {
      localObject = this.this$0.a.getHostProxy().getReportInterface().getHostReportData();
      if (localObject != null) {
        this.a.putAll((Map)localObject);
      }
      localObject = this.this$0.a.getHostProxy().getReportInterface().getHostReportData(this.b);
      if (localObject != null) {
        this.a.putAll((Map)localObject);
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("anchor", (String)this.a.get("anchor"));
      localObject = this.this$0.a.getHostProxy().getReportInterface().getHostReportPrivateData(this.b, (Bundle)localObject);
      if (localObject != null) {
        this.a.put("zt_str6", localObject);
      }
    }
    if (this.this$0.a.isUserHostBeacon()) {
      QQBeaconReport.a(this.this$0.a.getAppKey(), "", this.b, true, this.a, this.c);
    } else {
      QQBeaconReport.a("", this.b, true, this.a, this.c);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("product report qimei=");
    ((StringBuilder)localObject).append(UserAction.getQIMEI());
    ((StringBuilder)localObject).append(",adapter.getAppKey()=");
    ((StringBuilder)localObject).append(this.this$0.a.getAppKey());
    Log.d("DataReportService", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport.CustomDataReportService.1
 * JD-Core Version:    0.7.0.1
 */