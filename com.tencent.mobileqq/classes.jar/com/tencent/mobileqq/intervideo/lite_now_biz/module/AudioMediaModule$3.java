package com.tencent.mobileqq.intervideo.lite_now_biz.module;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.intervideo.lite_now_biz.event.ChangeMicrophoneEvent;

class AudioMediaModule$3
  implements Observer<ChangeMicrophoneEvent>
{
  AudioMediaModule$3(AudioMediaModule paramAudioMediaModule) {}
  
  public void a(ChangeMicrophoneEvent paramChangeMicrophoneEvent)
  {
    boolean bool = true;
    AudioMediaModule localAudioMediaModule = this.a;
    if (paramChangeMicrophoneEvent.a == 1) {}
    for (;;)
    {
      AudioMediaModule.a(localAudioMediaModule, bool);
      AudioMediaModule.a(this.a, AudioMediaModule.a(this.a));
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.module.AudioMediaModule.3
 * JD-Core Version:    0.7.0.1
 */