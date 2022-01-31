package com.tencent.mobileqq.pluginsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class l
  extends BroadcastReceiver
{
  l(PluginProxyActivity paramPluginProxyActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((PluginProxyActivity.mGestureLockEnable) && (this.a.mStopFlag == 0) && (this.a.isPatternLockOpened())) {
      this.a.startUnlockActivity(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.l
 * JD-Core Version:    0.7.0.1
 */