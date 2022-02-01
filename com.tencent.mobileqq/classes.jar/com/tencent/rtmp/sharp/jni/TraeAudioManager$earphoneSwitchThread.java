package com.tencent.rtmp.sharp.jni;

import android.media.AudioManager;

class TraeAudioManager$earphoneSwitchThread
  extends TraeAudioManager.switchThread
{
  TraeAudioManager$earphoneSwitchThread(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public void _quit() {}
  
  public void _run()
  {
    if ((!TraeAudioManager.IsMusicScene) && (TraeAudioManager.IsUpdateSceneFlag) && (TraeAudioManager.enableDeviceSwitchFlag))
    {
      TraeAudioManager localTraeAudioManager = this.this$0;
      localTraeAudioManager.InternalSetSpeaker(localTraeAudioManager._context, false);
    }
    updateStatus();
    int i;
    if ((!TraeAudioManager.IsMusicScene) && (TraeAudioManager.IsUpdateSceneFlag))
    {
      if (!TraeAudioManager.enableDeviceSwitchFlag)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "connect earphone: disableDeviceSwitchFlag");
        }
        return;
      }
      i = 0;
    }
    for (;;)
    {
      if (this._running == true) {}
      try
      {
        if (this.this$0._am.isSpeakerphoneOn()) {
          this.this$0.InternalSetSpeaker(this.this$0._context, false);
        }
        if (i < 5) {
          l = 1000L;
        } else {
          l = 4000L;
        }
      }
      catch (Exception localException)
      {
        try
        {
          long l;
          Thread.sleep(l);
          label135:
          i += 1;
          continue;
          return;
          if (QLog.isColorLevel()) {
            QLog.w("TraeAudioManager", 2, "connect earphone: do nothing");
          }
          return;
          localException = localException;
        }
        catch (InterruptedException localInterruptedException)
        {
          break label135;
        }
      }
    }
  }
  
  public String getDeviceName()
  {
    return "DEVICE_EARPHONE";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.earphoneSwitchThread
 * JD-Core Version:    0.7.0.1
 */