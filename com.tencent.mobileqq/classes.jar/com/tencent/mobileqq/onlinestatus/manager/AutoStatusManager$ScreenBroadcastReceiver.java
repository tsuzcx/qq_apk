package com.tencent.mobileqq.onlinestatus.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class AutoStatusManager$ScreenBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null) {
      paramContext = paramIntent.getAction();
    } else {
      paramContext = null;
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] ScreenBroadcastReceiver ACTION_SCREEN_OFF");
      }
      ((AutoStatusManager)((IOnlineStatusManagerService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IAutoStatusManager.class)).d("screenOff");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.AutoStatusManager.ScreenBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */