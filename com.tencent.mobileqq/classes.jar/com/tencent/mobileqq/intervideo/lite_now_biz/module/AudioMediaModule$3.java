package com.tencent.mobileqq.intervideo.lite_now_biz.module;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.intervideo.lite_now_biz.event.ChangeMicrophoneEvent;

class AudioMediaModule$3
  implements Observer<ChangeMicrophoneEvent>
{
  AudioMediaModule$3(AudioMediaModule paramAudioMediaModule) {}
  
  public void a(ChangeMicrophoneEvent paramChangeMicrophoneEvent)
  {
    AudioMediaModule localAudioMediaModule = this.a;
    int i = paramChangeMicrophoneEvent.a;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    AudioMediaModule.a(localAudioMediaModule, bool);
    paramChangeMicrophoneEvent = this.a;
    AudioMediaModule.a(paramChangeMicrophoneEvent, AudioMediaModule.a(paramChangeMicrophoneEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.module.AudioMediaModule.3
 * JD-Core Version:    0.7.0.1
 */