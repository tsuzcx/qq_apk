package com.tencent.mobileqq.qqaudio.audioplayer;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;

class AudioPlayerBase$1
  extends Handler
{
  AudioPlayerBase$1(AudioPlayerBase paramAudioPlayerBase) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1000) && (this.a.m == 0) && (this.a.m()))
    {
      int i = this.a.h.getStreamVolume(this.a.k.b);
      int j = this.a.h.getStreamMaxVolume(this.a.k.b);
      if (i / j > 0.18F)
      {
        paramMessage = this.a;
        paramMessage.m = 1;
        if (paramMessage.r != null)
        {
          paramMessage = this.a.r;
          AudioPlayerBase localAudioPlayerBase = this.a;
          paramMessage.c(localAudioPlayerBase, localAudioPlayerBase.m);
        }
      }
      else
      {
        this.a.s.sendEmptyMessageDelayed(1000, 200L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.1
 * JD-Core Version:    0.7.0.1
 */