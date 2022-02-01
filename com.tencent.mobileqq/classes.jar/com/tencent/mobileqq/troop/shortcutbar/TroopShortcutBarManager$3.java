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
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramContext))) {
        break label57;
      }
      if (QLog.isColorLevel()) {
        QLog.e("TroopShortcutBarManager", 2, "BroadcastReceiver onReceive Failed");
      }
    }
    label57:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e("TroopShortcutBarManager", 2, "BroadcastReceiver onReceive troopUin:" + str + "appId: " + paramContext);
      }
      paramContext = null;
      try
      {
        long l = Long.parseLong(str);
        paramContext = Long.valueOf(l);
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          QLog.e("TroopShortcutBarManager", 1, "parseLong troopUin exception");
        }
      }
      paramContext = this.a.a(paramContext);
      if (paramContext != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopShortcutBarManager", 2, "BroadcastReceiver onReceive info is not null");
        }
        paramContext.d(0);
        paramContext.a(0L);
        paramContext.c(0);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TroopShortcutBarManager", 2, "BroadcastReceiver onReceive info is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager.3
 * JD-Core Version:    0.7.0.1
 */