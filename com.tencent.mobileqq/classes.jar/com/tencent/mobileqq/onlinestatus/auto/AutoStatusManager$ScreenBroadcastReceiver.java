package com.tencent.mobileqq.onlinestatus.auto;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.onlinestatus.OnlineStatusManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class AutoStatusManager$ScreenBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = null;
    if (paramIntent != null) {
      paramContext = paramIntent.getAction();
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] ScreenBroadcastReceiver ACTION_SCREEN_OFF");
      }
      paramContext = (OnlineStatusManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.ONLINE_STATUS_MANAGER);
      if (paramContext != null) {
        paramContext.a().d("screenOff");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.AutoStatusManager.ScreenBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */