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
    TraeAudioManager localTraeAudioManager;
    if ((TraeAudioManager.IsUpdateSceneFlag) && (TraeAudioManager.enableDeviceSwitchFlag))
    {
      localTraeAudioManager = this.this$0;
      localTraeAudioManager.InternalSetSpeaker(localTraeAudioManager._context, false);
    }
    updateStatus();
    if (!TraeAudioManager.IsUpdateSceneFlag)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "connect earphone: do nothing");
      }
      return;
    }
    if (!TraeAudioManager.enableDeviceSwitchFlag)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "connect earphone: disableDeviceSwitchFlag");
      }
      return;
    }
    int i = 0;
    for (;;)
    {
      long l;
      if (this._running == true)
      {
        if (this.this$0._am.isSpeakerphoneOn())
        {
          localTraeAudioManager = this.this$0;
          localTraeAudioManager.InternalSetSpeaker(localTraeAudioManager._context, false);
        }
        if (i < 5) {
          l = 1000L;
        } else {
          l = 4000L;
        }
      }
      try
      {
        Thread.sleep(l);
        label137:
        i += 1;
        continue;
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label137;
      }
    }
  }
  
  public String getDeviceName()
  {
    return "DEVICE_EARPHONE";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.earphoneSwitchThread
 * JD-Core Version:    0.7.0.1
 */