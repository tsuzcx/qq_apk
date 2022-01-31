package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class OtherJsPlugin$2
  extends BroadcastReceiver
{
  OtherJsPlugin$2(OtherJsPlugin paramOtherJsPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d(OtherJsPlugin.access$000(), 2, String.format("receiver.onReceive action=%s", new Object[] { paramContext }));
    }
    if ("action_return_address_to_miniapp".equals(paramContext))
    {
      paramContext = paramIntent.getStringExtra("key_miniapp_address_info");
      if ((OtherJsPlugin.access$100(this.this$0) != null) && (OtherJsPlugin.access$200(this.this$0) > 0)) {
        OtherJsPlugin.access$300(this.this$0, paramContext, OtherJsPlugin.access$100(this.this$0), OtherJsPlugin.access$200(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OtherJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */