package com.tencent.thumbplayer.core.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Set;

class TPHeadsetPluginDetector$HeadsetPluginReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 0;
    TPNativeLog.printLog(2, "TPHeadsetPluginDetector", "onReceive: " + paramIntent.getAction());
    paramContext = TPHeadsetPluginDetector.access$100();
    if ("android.intent.action.HEADSET_PLUG".equals(paramIntent.getAction()))
    {
      if (paramIntent.hasExtra("state")) {
        i = paramIntent.getIntExtra("state", 0);
      }
      if (paramContext != null) {
        if (i != 0) {
          break label90;
        }
      }
    }
    label90:
    do
    {
      paramContext.remove(Integer.valueOf(1));
      for (;;)
      {
        TPHeadsetPluginDetector.access$200(TPHeadsetPluginDetector.access$000(), paramContext);
        return;
        if (i == 1) {
          paramContext.add(Integer.valueOf(1));
        }
      }
      if ("android.media.AUDIO_BECOMING_NOISY".equals(paramIntent.getAction()))
      {
        if (paramContext != null) {
          paramContext.remove(Integer.valueOf(1));
        }
        TPHeadsetPluginDetector.access$200(TPHeadsetPluginDetector.access$000(), paramContext);
        return;
      }
    } while (!"android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction()));
    i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
    if (paramContext != null)
    {
      if (i != 2) {
        break label192;
      }
      paramContext.add(Integer.valueOf(2));
    }
    for (;;)
    {
      TPHeadsetPluginDetector.access$200(TPHeadsetPluginDetector.access$000(), paramContext);
      return;
      label192:
      if (i == 0) {
        paramContext.remove(Integer.valueOf(2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPHeadsetPluginDetector.HeadsetPluginReceiver
 * JD-Core Version:    0.7.0.1
 */