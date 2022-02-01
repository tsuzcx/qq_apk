package com.tencent.mobileqq.dpc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class DeviceProfileManager$1
  extends BroadcastReceiver
{
  DeviceProfileManager$1(DeviceProfileManager paramDeviceProfileManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.e("DeviceProfileManager", 4, "onReceive");
    }
    if (paramIntent == null) {
      return;
    }
    try
    {
      paramContext = paramIntent.getExtras();
      if (paramContext == null) {
        return;
      }
      DeviceProfileManager.access$002(this.this$0, (HashMap)paramContext.getSerializable("featureMapLV2"));
      if (DeviceProfileManager.sAccountDpcService != null)
      {
        DeviceProfileManager.sAccountDpcService.mFeatureAccountMapLV2 = ((HashMap)paramContext.getSerializable("featureAccountMapLV2"));
        return;
      }
    }
    catch (Exception paramContext)
    {
      if (QLog.isDevelopLevel()) {
        paramContext.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dpc.DeviceProfileManager.1
 * JD-Core Version:    0.7.0.1
 */