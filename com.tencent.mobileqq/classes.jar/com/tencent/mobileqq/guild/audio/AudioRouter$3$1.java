package com.tencent.mobileqq.guild.audio;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class AudioRouter$3$1
  implements Runnable
{
  AudioRouter$3$1(AudioRouter.3 param3, Intent paramIntent, String paramString) {}
  
  public void run()
  {
    int i;
    if ("android.intent.action.HEADSET_PLUG".equals(this.a.getAction()))
    {
      i = this.a.getIntExtra("state", -1);
      QLog.d(AudioRouter.c(), 1, String.format("onReceive ACTION_HEADSET_PLUG state=%s", new Object[] { Integer.valueOf(i) }));
      if (i == 0)
      {
        AudioRouter.b(this.c.a, 3);
        return;
      }
      if (i == 1) {
        AudioRouter.c(this.c.a, 3);
      }
    }
    else if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(this.b))
    {
      i = this.a.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
      QLog.d(AudioRouter.c(), 1, String.format("onReceive ACTION_CONNECTION_STATE_CHANGED state=%s", new Object[] { Integer.valueOf(i) }));
      if (i == 2)
      {
        AudioRouter.c(this.c.a, 2);
        return;
      }
      if (i == 0) {
        AudioRouter.b(this.c.a, 2);
      }
    }
    else if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(this.b))
    {
      i = this.a.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
      QLog.d(AudioRouter.c(), 1, String.format("onReceive ACTION_CONNECTION_STATE_CHANGED state=%s", new Object[] { Integer.valueOf(i) }));
      if (i == 2)
      {
        AudioRouter.c(this.c.a, 2);
        return;
      }
      if (i == 0) {
        AudioRouter.b(this.c.a, 2);
      }
    }
    else if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(this.b))
    {
      i = this.a.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
      QLog.d(AudioRouter.c(), 1, String.format("onReceive ACTION_STATE_CHANGED state=%s", new Object[] { Integer.valueOf(i) }));
      if ((i == 10) || (i == 13)) {
        AudioRouter.b(this.c.a, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.AudioRouter.3.1
 * JD-Core Version:    0.7.0.1
 */