package com.tencent.mobileqq.qqaudio.audioplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

class AudioPlayer$MyScoReceiver
  extends BroadcastReceiver
{
  String a;
  int b;
  boolean c = false;
  long d = 0L;
  long e = 0L;
  
  AudioPlayer$MyScoReceiver(AudioPlayer paramAudioPlayer, String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l1 = SystemClock.uptimeMillis();
    int i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("onReceive ACTION_SCO_AUDIO_STATE_UPDATED = ");
      paramContext.append(i);
      paramContext.append(" ");
      paramContext.append(this.a);
      paramContext.append(", time=");
      paramContext.append(l1);
      QLog.d("AudioPlayer_Old", 2, paramContext.toString());
    }
    if (1 == i)
    {
      if (this.e == 0L)
      {
        this.e = l1;
        paramContext = this.f;
        AudioPlayer.a(paramContext, paramContext.h);
        AudioPlayerBase.c = true;
        if (!this.f.m()) {
          this.f.a(this.a, this.b);
        }
      }
    }
    else
    {
      if (2 == i)
      {
        this.c = true;
        return;
      }
      if (i == 0)
      {
        if (this.d == 0L)
        {
          this.d = l1;
          return;
        }
        if (this.c) {
          this.f.p();
        }
        long l2 = this.e;
        if (((l2 != 0L) && (l1 - l2 <= 2000L)) || (l1 - this.d <= 1000L))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AudioPlayer_Old", 2, "sco disconnected quickly.");
          }
          AudioDeviceHelper.d = true;
          if ((AudioPlayer.a(this.f)) && (!this.f.h.isBluetoothA2dpOn())) {
            AudioPlayer.a(this.f, false);
          }
          if (!this.f.m())
          {
            this.f.a(this.a, this.b);
            return;
          }
          this.f.d(0);
          return;
        }
        if (this.f.m())
        {
          paramContext = this.f;
          paramContext.d(paramContext.g.h());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer.MyScoReceiver
 * JD-Core Version:    0.7.0.1
 */