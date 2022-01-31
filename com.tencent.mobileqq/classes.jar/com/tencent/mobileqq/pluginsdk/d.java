package com.tencent.mobileqq.pluginsdk;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import mqq.app.MobileQQ;

class d
  implements IBinder.DeathRecipient
{
  d(PluginInterface paramPluginInterface, IBinder paramIBinder) {}
  
  public void binderDied()
  {
    PluginInterfaceHelper.getPluginInterface(MobileQQ.sMobileQQ, null);
    this.a.unlinkToDeath(this, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.d
 * JD-Core Version:    0.7.0.1
 */