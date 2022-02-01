package com.tencent.qqmini.sdk.core.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class VoIPManager$1
  extends BroadcastReceiver
{
  VoIPManager$1(VoIPManager paramVoIPManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    int i;
    if ("android.intent.action.HEADSET_PLUG".equals(paramContext))
    {
      i = paramIntent.getIntExtra("state", -1);
      QMLog.d("VoIPManager", String.format("onReceive ACTION_HEADSET_PLUG state=%s", new Object[] { Integer.valueOf(i) }));
      if (i == 0)
      {
        VoIPManager.access$000(this.this$0);
        return;
      }
      if (i == 1) {
        VoIPManager.access$100(this.this$0, 0);
      }
    }
    else if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(paramContext))
    {
      i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
      QMLog.d("VoIPManager", String.format("onReceive ACTION_CONNECTION_STATE_CHANGED state=%s", new Object[] { Integer.valueOf(i) }));
      if (i == 2)
      {
        VoIPManager.access$100(this.this$0, 2);
        return;
      }
      if (i == 0) {
        VoIPManager.access$000(this.this$0);
      }
    }
    else if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(paramContext))
    {
      i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
      QMLog.d("VoIPManager", String.format("onReceive ACTION_STATE_CHANGED state=%s", new Object[] { Integer.valueOf(i) }));
      if ((i == 10) || (i == 13)) {
        VoIPManager.access$000(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.VoIPManager.1
 * JD-Core Version:    0.7.0.1
 */