package com.tencent.mobileqq.guild.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class AudioRoom$1
  extends BroadcastReceiver
{
  AudioRoom$1(AudioRoom paramAudioRoom) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("qqAccountReceiver onReceive=");
    paramIntent.append(paramContext);
    QLog.i("AudioRoom", 1, paramIntent.toString());
    AudioRoom.a(this.a, "");
    AudioRoom.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.AudioRoom.1
 * JD-Core Version:    0.7.0.1
 */