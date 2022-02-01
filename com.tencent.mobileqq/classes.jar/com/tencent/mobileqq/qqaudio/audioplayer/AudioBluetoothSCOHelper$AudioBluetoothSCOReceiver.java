package com.tencent.mobileqq.qqaudio.audioplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

class AudioBluetoothSCOHelper$AudioBluetoothSCOReceiver
  extends BroadcastReceiver
{
  String a;
  int b;
  boolean c = false;
  long d = 0L;
  long e = 0L;
  
  private AudioBluetoothSCOHelper$AudioBluetoothSCOReceiver(AudioBluetoothSCOHelper paramAudioBluetoothSCOHelper, String paramString, int paramInt)
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
      QLog.d("AudioPlayer_SCOHelper", 2, paramContext.toString());
    }
    paramContext = AudioBluetoothSCOHelper.a(this.f);
    if (1 == i)
    {
      if (this.e == 0L)
      {
        this.e = l1;
        if (paramContext != null)
        {
          paramIntent = paramContext.i();
          if (paramIntent != null)
          {
            paramIntent.setBluetoothScoOn(true);
            AudioPlayerBase.c = true;
          }
          paramContext.n();
          if (!paramContext.m())
          {
            if (QLog.isColorLevel())
            {
              paramIntent = new StringBuilder();
              paramIntent.append("onReceive SCO_AUDIO_STATE_CONNECTED need replay time=");
              paramIntent.append(l1);
              QLog.d("AudioPlayer_SCOHelper", 2, paramIntent.toString());
            }
            paramContext.e(true);
            paramContext.c(this.a, this.b);
          }
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
        if ((this.c) && (paramContext != null)) {
          paramContext.p();
        }
        if (paramContext != null) {
          paramContext.o();
        }
        long l2 = this.e;
        if (((l2 != 0L) && (l1 - l2 <= 2000L)) || (l1 - this.d <= 1000L))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AudioPlayer_SCOHelper", 2, "sco disconnected quickly.");
          }
          AudioDeviceHelper.d = true;
          if (paramContext != null)
          {
            paramContext.b();
            if (paramContext.m())
            {
              paramContext.e(false);
              paramContext.c(this.a, this.b);
              return;
            }
            paramContext.d(0);
          }
        }
        else if ((paramContext != null) && (paramContext.m()))
        {
          paramContext.d(paramContext.h());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioBluetoothSCOHelper.AudioBluetoothSCOReceiver
 * JD-Core Version:    0.7.0.1
 */