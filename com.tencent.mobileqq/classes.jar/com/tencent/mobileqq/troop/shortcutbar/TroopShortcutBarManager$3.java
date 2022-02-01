package com.tencent.mobileqq.troop.shortcutbar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class TroopShortcutBarManager$3
  extends BroadcastReceiver
{
  TroopShortcutBarManager$3(TroopShortcutBarManager paramTroopShortcutBarManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str;
    if ("com.tencent.mobileqq.addgroupapplication".equals(paramIntent.getAction()))
    {
      str = paramIntent.getStringExtra("groupUin");
      paramContext = paramIntent.getStringExtra("appId");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramContext)))
      {
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("BroadcastReceiver onReceive troopUin:");
          paramIntent.append(str);
          paramIntent.append("appId: ");
          paramIntent.append(paramContext);
          QLog.e("TroopShortcutBarManager", 2, paramIntent.toString());
        }
        paramContext = null;
      }
    }
    try
    {
      paramIntent = Long.valueOf(Long.parseLong(str));
      paramContext = paramIntent;
    }
    catch (Exception paramIntent)
    {
      label108:
      break label108;
    }
    QLog.e("TroopShortcutBarManager", 1, "parseLong troopUin exception");
    paramContext = this.a.a(paramContext);
    if (paramContext != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopShortcutBarManager", 2, "BroadcastReceiver onReceive info is not null");
      }
      paramContext.d(0);
      paramContext.b(0L);
      paramContext.c(0);
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.e("TroopShortcutBarManager", 2, "BroadcastReceiver onReceive info is null");
      return;
      if (QLog.isColorLevel()) {
        QLog.e("TroopShortcutBarManager", 2, "BroadcastReceiver onReceive Failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager.3
 * JD-Core Version:    0.7.0.1
 */