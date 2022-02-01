package com.tencent.rtmp.sharp.jni;

import android.media.AudioManager;

class TraeAudioManager$speakerSwitchThread
  extends TraeAudioManager.switchThread
{
  TraeAudioManager$speakerSwitchThread(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public void _quit() {}
  
  public void _run()
  {
    Object localObject;
    if ((!TraeAudioManager.IsMusicScene) && (TraeAudioManager.IsUpdateSceneFlag) && (TraeAudioManager.enableDeviceSwitchFlag))
    {
      localObject = this.this$0;
      ((TraeAudioManager)localObject).InternalSetSpeaker(((TraeAudioManager)localObject)._context, true);
    }
    updateStatus();
    int i;
    if ((!TraeAudioManager.IsMusicScene) && (TraeAudioManager.IsUpdateSceneFlag))
    {
      if (!TraeAudioManager.enableDeviceSwitchFlag)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "connect speakerPhone: disableDeviceSwitchFlag");
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" _run:");
        ((StringBuilder)localObject).append(getDeviceName());
        ((StringBuilder)localObject).append(" _running:");
        ((StringBuilder)localObject).append(this._running);
        QLog.w("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
      }
      i = 0;
    }
    for (;;)
    {
      long l;
      if (this._running == true)
      {
        if (this.this$0._am.isSpeakerphoneOn() != true)
        {
          localObject = this.this$0;
          ((TraeAudioManager)localObject).InternalSetSpeaker(((TraeAudioManager)localObject)._context, true);
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
        label200:
        i += 1;
        continue;
        return;
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "connect speakerPhone: do nothing");
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label200;
      }
    }
  }
  
  public String getDeviceName()
  {
    return "DEVICE_SPEAKERPHONE";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.speakerSwitchThread
 * JD-Core Version:    0.7.0.1
 */