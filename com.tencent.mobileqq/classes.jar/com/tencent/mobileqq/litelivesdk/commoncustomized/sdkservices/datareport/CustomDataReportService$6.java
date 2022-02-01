package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport;

import android.content.Context;
import com.tencent.beacon.event.UserAction;
import com.tencent.falco.base.libapi.datareport.DataReportInterface.DataReportAdapter;
import com.tencent.falco.base.libapi.log.LogInterface;

class CustomDataReportService$6
  implements Runnable
{
  CustomDataReportService$6(CustomDataReportService paramCustomDataReportService, Context paramContext) {}
  
  public void run()
  {
    try
    {
      UserAction.setLogAble(false, false);
      UserAction.initUserAction(this.a);
      UserAction.setAppKey(this.this$0.a.getAppKey());
      UserAction.setAppVersion(this.this$0.a.getAppVersion());
      UserAction.setChannelID(this.this$0.a.getChannelId());
      CustomDataReportService.a(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      this.this$0.a.getLog().printStackTrace(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport.CustomDataReportService.6
 * JD-Core Version:    0.7.0.1
 */