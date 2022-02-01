package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport;

import com.tencent.beacon.BeaconAdapter;
import com.tencent.falco.base.libapi.datareport.DataReportInterface.DataReportAdapter;

class CustomDataReportService$5
  implements Runnable
{
  CustomDataReportService$5(CustomDataReportService paramCustomDataReportService) {}
  
  public void run()
  {
    BeaconAdapter.registerTunnel(this.this$0.a.getAppKey(), this.this$0.a.getAppVersion(), this.this$0.a.getChannelId());
    CustomDataReportService.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport.CustomDataReportService.5
 * JD-Core Version:    0.7.0.1
 */