package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class VoIPManager$1
  extends BroadcastReceiver
{
  VoIPManager$1(VoIPManager paramVoIPManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext != null) && (paramContext.equals("android.intent.action.HEADSET_PLUG")) && (paramIntent.hasExtra("state")))
    {
      if (paramIntent.getIntExtra("state", 0) != 0) {
        break label46;
      }
      VoIPManager.access$000(this.this$0, 2);
    }
    label46:
    while (paramIntent.getIntExtra("state", 0) != 1) {
      return;
    }
    VoIPManager.access$000(this.this$0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VoIPManager.1
 * JD-Core Version:    0.7.0.1
 */