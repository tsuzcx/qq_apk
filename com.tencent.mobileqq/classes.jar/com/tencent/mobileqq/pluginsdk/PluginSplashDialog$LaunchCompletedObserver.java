package com.tencent.mobileqq.pluginsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class PluginSplashDialog$LaunchCompletedObserver
  extends BroadcastReceiver
{
  private String mPluginApk;
  private String mPluginName;
  
  public PluginSplashDialog$LaunchCompletedObserver(PluginSplashDialog paramPluginSplashDialog, String paramString1, String paramString2)
  {
    this.mPluginName = paramString1;
    this.mPluginApk = paramString2;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("plugin_apk");
    paramIntent = paramIntent.getStringExtra("plugin_name");
    if ((this.mPluginApk.equalsIgnoreCase(paramContext)) && (this.mPluginName.equalsIgnoreCase(paramIntent))) {}
    try
    {
      this.this$0.dismiss();
      return;
    }
    catch (Exception paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginSplashDialog.LaunchCompletedObserver
 * JD-Core Version:    0.7.0.1
 */