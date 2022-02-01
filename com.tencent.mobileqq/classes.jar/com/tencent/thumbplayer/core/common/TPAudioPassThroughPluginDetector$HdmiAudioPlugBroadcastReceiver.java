package com.tencent.thumbplayer.core.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class TPAudioPassThroughPluginDetector$HdmiAudioPlugBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = new StringBuilder();
    paramContext.append("HdmiAudioPlugBroadcastReceiver onReceive: ");
    paramContext.append(paramIntent.getAction());
    TPNativeLog.printLog(2, "TPAudioPassThroughPluginDetector", paramContext.toString());
    if (paramIntent != null)
    {
      boolean bool = false;
      int i = paramIntent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0);
      if ((i != 0) && (i == 1)) {
        bool = true;
      }
      paramContext = new StringBuilder();
      paramContext.append("HdmiAudioPlugBroadcastReceiver audioPassThroughState:");
      paramContext.append(i);
      paramContext.append(" bPlugin:");
      paramContext.append(bool);
      TPNativeLog.printLog(2, "TPAudioPassThroughPluginDetector", paramContext.toString());
      TPAudioPassThroughPluginDetector.access$100(new TPAudioPassThroughCapabilities(paramIntent.getIntArrayExtra("android.media.extra.ENCODINGS"), paramIntent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8)));
      TPAudioPassThroughPluginDetector.access$200(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPAudioPassThroughPluginDetector.HdmiAudioPlugBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */