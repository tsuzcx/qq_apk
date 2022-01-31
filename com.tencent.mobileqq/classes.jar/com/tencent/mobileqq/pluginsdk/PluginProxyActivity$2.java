package com.tencent.mobileqq.pluginsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class PluginProxyActivity$2
  extends BroadcastReceiver
{
  PluginProxyActivity$2(PluginProxyActivity paramPluginProxyActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((PluginProxyActivity.mGestureLockEnable) && (this.this$0.mStopFlag == 0) && (this.this$0.isPatternLockOpened())) {
      this.this$0.startUnlockActivity(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginProxyActivity.2
 * JD-Core Version:    0.7.0.1
 */