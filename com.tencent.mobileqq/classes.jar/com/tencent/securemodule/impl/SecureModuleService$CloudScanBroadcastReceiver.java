package com.tencent.securemodule.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.securemodule.service.CloudScanListener;
import java.util.List;

public class SecureModuleService$CloudScanBroadcastReceiver
  extends BroadcastReceiver
{
  private CloudScanListener b;
  
  public SecureModuleService$CloudScanBroadcastReceiver(SecureModuleService paramSecureModuleService, CloudScanListener paramCloudScanListener)
  {
    this.b = paramCloudScanListener;
  }
  
  public boolean a(CloudScanListener paramCloudScanListener)
  {
    if (this.b != null) {
      return this.b.equals(paramCloudScanListener);
    }
    return paramCloudScanListener == null;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("1000030".equals(paramIntent.getAction()))
    {
      this.b.onRiskFound();
      paramContext = (List)paramIntent.getSerializableExtra("key_rise");
      this.b.onRiskFoud(paramContext);
    }
    while (!"1000031".equals(paramIntent.getAction())) {
      return;
    }
    int i = paramIntent.getIntExtra("key_errcode", 0);
    this.b.onFinish(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.securemodule.impl.SecureModuleService.CloudScanBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */