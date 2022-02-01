package com.tencent.mobileqq.qassistant.api.impl;

import com.tencent.mobileqq.qassistant.api.IAudio2TextRealTime;
import com.tencent.mobileqq.qassistant.audio.AudioNewController;
import com.tencent.mobileqq.qassistant.listener.IAudio2TextResultCallBack;
import mqq.app.AppRuntime;

public class Audio2TextRealTimeImpl
  implements IAudio2TextRealTime
{
  private AudioNewController audioNewController;
  
  public void finishAudio2Text()
  {
    AudioNewController localAudioNewController = this.audioNewController;
    if (localAudioNewController != null)
    {
      localAudioNewController.a(null);
      this.audioNewController.a();
    }
  }
  
  public void invokeAudio2Text(IAudio2TextResultCallBack paramIAudio2TextResultCallBack)
  {
    AudioNewController localAudioNewController = this.audioNewController;
    if (localAudioNewController != null)
    {
      localAudioNewController.a();
      this.audioNewController.a(paramIAudio2TextResultCallBack);
      this.audioNewController.a(4);
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if (this.audioNewController == null) {
      this.audioNewController = new AudioNewController();
    }
  }
  
  public void onDestroy()
  {
    AudioNewController localAudioNewController = this.audioNewController;
    if (localAudioNewController != null)
    {
      localAudioNewController.a();
      this.audioNewController = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.api.impl.Audio2TextRealTimeImpl
 * JD-Core Version:    0.7.0.1
 */