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
    paramContext = new StringBuilder();
    paramContext.append("onReceive: ");
    paramContext.append(paramIntent.getAction());
    Object localObject = paramContext.toString();
    paramContext = Integer.valueOf(2);
    TPNativeLog.printLog(2, "TPHeadsetPluginDetector", (String)localObject);
    localObject = TPHeadsetPluginDetector.access$100();
    boolean bool = "android.intent.action.HEADSET_PLUG".equals(paramIntent.getAction());
    int i = 0;
    Integer localInteger = Integer.valueOf(1);
    if (bool)
    {
      if (paramIntent.hasExtra("state")) {
        i = paramIntent.getIntExtra("state", 0);
      }
      if (localObject != null) {
        if (i == 0) {
          ((Set)localObject).remove(localInteger);
        } else if (i == 1) {
          ((Set)localObject).add(localInteger);
        }
      }
      TPHeadsetPluginDetector.access$200(TPHeadsetPluginDetector.access$000(), (Set)localObject);
      return;
    }
    if ("android.media.AUDIO_BECOMING_NOISY".equals(paramIntent.getAction()))
    {
      if (localObject != null) {
        ((Set)localObject).remove(localInteger);
      }
      TPHeadsetPluginDetector.access$200(TPHeadsetPluginDetector.access$000(), (Set)localObject);
      return;
    }
    if ("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
      if (localObject != null) {
        if (i == 2) {
          ((Set)localObject).add(paramContext);
        } else if (i == 0) {
          ((Set)localObject).remove(paramContext);
        }
      }
      TPHeadsetPluginDetector.access$200(TPHeadsetPluginDetector.access$000(), (Set)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPHeadsetPluginDetector.HeadsetPluginReceiver
 * JD-Core Version:    0.7.0.1
 */