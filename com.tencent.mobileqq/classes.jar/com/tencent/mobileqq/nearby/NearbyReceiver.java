package com.tencent.mobileqq.nearby;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.olympic.ScannerResultReceiver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.QQBroadcastReceiver;

public class NearbyReceiver
  extends QQBroadcastReceiver
{
  public String getModuleId()
  {
    return "module_nearby";
  }
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramIntent.setExtrasClassLoader(ScannerResultReceiver.class.getClassLoader());
    if ((paramAppRuntime != null) && ((paramAppRuntime instanceof INearbyAppInterface)))
    {
      paramContext = (ResultReceiver)paramIntent.getParcelableExtra("resultreceiver_nearbyfakeactivity");
      if (paramContext != null) {
        paramContext.send(0, new Bundle());
      }
      int i = paramIntent.getIntExtra("nearby_preload_from", 0);
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).preloadNearbyProcessSuc(paramAppRuntime.getAccount());
      ((INearbyAppInterface)paramAppRuntime).updatePerfState(1, i);
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("PRELOAD_NEARBY_PROCESS, ");
      paramContext.append(paramAppRuntime);
      QLog.d("NearbyReceiver", 2, paramContext.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyReceiver
 * JD-Core Version:    0.7.0.1
 */