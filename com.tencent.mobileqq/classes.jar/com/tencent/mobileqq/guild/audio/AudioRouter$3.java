package com.tencent.mobileqq.guild.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

class AudioRouter$3
  extends BroadcastReceiver
{
  AudioRouter$3(AudioRouter paramAudioRouter) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    if (AudioRouter.c(this.a) != null) {
      AudioRouter.c(this.a).post(new AudioRouter.3.1(this, paramIntent, paramContext));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.AudioRouter.3
 * JD-Core Version:    0.7.0.1
 */