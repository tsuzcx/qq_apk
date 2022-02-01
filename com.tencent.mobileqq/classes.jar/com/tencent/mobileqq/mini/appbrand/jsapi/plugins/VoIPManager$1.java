package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class VoIPManager$1
  extends BroadcastReceiver
{
  VoIPManager$1(VoIPManager paramVoIPManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!"android.intent.action.HEADSET_PLUG".equals(paramContext)) {
              break;
            }
            i = paramIntent.getIntExtra("state", -1);
            QLog.d("VoIPManager", 1, String.format("onReceive ACTION_HEADSET_PLUG state=%s", new Object[] { Integer.valueOf(i) }));
            if (i == 0)
            {
              VoIPManager.access$000(this.this$0);
              return;
            }
          } while (i != 1);
          VoIPManager.access$100(this.this$0, 0);
          return;
          if (!"android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(paramContext)) {
            break;
          }
          i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
          QLog.d("VoIPManager", 1, String.format("onReceive ACTION_CONNECTION_STATE_CHANGED state=%s", new Object[] { Integer.valueOf(i) }));
          if (i == 2)
          {
            VoIPManager.access$100(this.this$0, 2);
            return;
          }
        } while (i != 0);
        VoIPManager.access$000(this.this$0);
        return;
      } while (!"android.bluetooth.adapter.action.STATE_CHANGED".equals(paramContext));
      i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
      QLog.d("VoIPManager", 1, String.format("onReceive ACTION_STATE_CHANGED state=%s", new Object[] { Integer.valueOf(i) }));
    } while ((i != 10) && (i != 13));
    VoIPManager.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VoIPManager.1
 * JD-Core Version:    0.7.0.1
 */