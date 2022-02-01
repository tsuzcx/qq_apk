package com.tencent.qqmini.sdk.plugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class SettingsJsPlugin$1
  extends BroadcastReceiver
{
  SettingsJsPlugin$1(SettingsJsPlugin paramSettingsJsPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QMLog.isColorLevel()) {
      QMLog.d("SettingsJsPlugin", String.format("receiver.onReceive action=%s", new Object[] { paramContext }));
    }
    if ("action_return_address_to_miniapp".equals(paramContext))
    {
      paramContext = paramIntent.getStringExtra("key_miniapp_address_info");
      if (SettingsJsPlugin.access$000(this.this$0) != null)
      {
        SettingsJsPlugin.access$100(this.this$0, paramContext, SettingsJsPlugin.access$000(this.this$0));
        SettingsJsPlugin.access$002(this.this$0, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.SettingsJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */