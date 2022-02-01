package com.tencent.qqmini.sdk.plugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BatteryJsPlugin$PowerConnectionReceiver
  extends BroadcastReceiver
{
  public BatteryJsPlugin$PowerConnectionReceiver(BatteryJsPlugin paramBatteryJsPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent.getIntExtra("status", -1);
    paramContext = this.this$0;
    if (paramIntent.getIntExtra("plugged", -1) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      BatteryJsPlugin.access$002(paramContext, bool);
      int i = paramIntent.getIntExtra("level", 0);
      int j = paramIntent.getIntExtra("scale", 0);
      BatteryJsPlugin.access$102(this.this$0, i / j);
      BatteryJsPlugin.access$202(this.this$0, paramIntent.getIntExtra("plugged", -1));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.BatteryJsPlugin.PowerConnectionReceiver
 * JD-Core Version:    0.7.0.1
 */