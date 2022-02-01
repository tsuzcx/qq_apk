package com.tencent.thumbplayer.core.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class TPAudioPassThroughPluginDetector$HdmiAudioPlugBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = false;
    TPNativeLog.printLog(2, "TPAudioPassThroughPluginDetector", "HdmiAudioPlugBroadcastReceiver onReceive: " + paramIntent.getAction());
    int i;
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0);
      if (i != 0) {
        break label112;
      }
    }
    for (;;)
    {
      TPNativeLog.printLog(2, "TPAudioPassThroughPluginDetector", "HdmiAudioPlugBroadcastReceiver audioPassThroughState:" + i + " bPlugin:" + bool);
      TPAudioPassThroughPluginDetector.access$100(new TPAudioPassThroughCapabilities(paramIntent.getIntArrayExtra("android.media.extra.ENCODINGS"), paramIntent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8)));
      TPAudioPassThroughPluginDetector.access$200(bool);
      return;
      label112:
      if (i == 1) {
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPAudioPassThroughPluginDetector.HdmiAudioPlugBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */