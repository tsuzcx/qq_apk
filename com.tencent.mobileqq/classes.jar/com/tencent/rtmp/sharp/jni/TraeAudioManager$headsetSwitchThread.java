package com.tencent.rtmp.sharp.jni;

import android.media.AudioManager;

class TraeAudioManager$headsetSwitchThread
  extends TraeAudioManager.switchThread
{
  TraeAudioManager$headsetSwitchThread(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public void _quit() {}
  
  public void _run()
  {
    TraeAudioManager localTraeAudioManager;
    if ((!TraeAudioManager.IsMusicScene) && (TraeAudioManager.IsUpdateSceneFlag) && (TraeAudioManager.enableDeviceSwitchFlag))
    {
      localTraeAudioManager = this.this$0;
      localTraeAudioManager.InternalSetSpeaker(localTraeAudioManager._context, false);
      this.this$0._am.setWiredHeadsetOn(true);
    }
    updateStatus();
    int i;
    if ((!TraeAudioManager.IsMusicScene) && (TraeAudioManager.IsUpdateSceneFlag))
    {
      if (!TraeAudioManager.enableDeviceSwitchFlag)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "connect headset: disableDeviceSwitchFlag");
        }
        return;
      }
      i = 0;
    }
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
        label148:
        i += 1;
        continue;
        return;
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "connect headset: do nothing");
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label148;
      }
    }
  }
  
  public String getDeviceName()
  {
    return "DEVICE_WIREDHEADSET";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.headsetSwitchThread
 * JD-Core Version:    0.7.0.1
 */