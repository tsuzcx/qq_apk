package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class AudioItem$4
  extends BroadcastReceiver
{
  AudioItem$4(AudioItem paramAudioItem) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("com.tencent.mobileqq.activity.ai.audiopanel.startrecord_action".equals(paramContext))
    {
      paramContext = this.a;
      paramContext.b(AudioItem.b(paramContext));
      return;
    }
    if ("com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video".equals(paramContext))
    {
      paramContext = this.a;
      paramContext.b(AudioItem.b(paramContext));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.4
 * JD-Core Version:    0.7.0.1
 */