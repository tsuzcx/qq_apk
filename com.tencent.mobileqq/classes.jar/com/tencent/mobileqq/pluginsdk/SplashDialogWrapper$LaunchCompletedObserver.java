package com.tencent.mobileqq.pluginsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class SplashDialogWrapper$LaunchCompletedObserver
  extends BroadcastReceiver
{
  private String mPluginID;
  private String mPluginName;
  
  public SplashDialogWrapper$LaunchCompletedObserver(SplashDialogWrapper paramSplashDialogWrapper, String paramString1, String paramString2)
  {
    this.mPluginName = paramString1;
    this.mPluginID = paramString2;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("plugin_apk");
    paramIntent = paramIntent.getStringExtra("plugin_name");
    if (DebugHelper.sDebug)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LaunchCompletedObserver.onReceive: ");
      localStringBuilder.append(paramContext);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramIntent);
      localStringBuilder.append(", ");
      localStringBuilder.append(SplashDialogWrapper.access$000(this.this$0));
      DebugHelper.log("plugin_tag", localStringBuilder.toString());
    }
    if ((this.mPluginID.equalsIgnoreCase(paramContext)) && ((SplashDialogWrapper.access$000(this.this$0)) || (paramIntent != null))) {
      this.this$0.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.SplashDialogWrapper.LaunchCompletedObserver
 * JD-Core Version:    0.7.0.1
 */