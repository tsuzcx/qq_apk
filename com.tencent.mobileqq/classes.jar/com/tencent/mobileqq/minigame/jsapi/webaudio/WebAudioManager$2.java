package com.tencent.mobileqq.minigame.jsapi.webaudio;

import com.tencent.mobileqq.triton.sdk.audio.IAudioNativeManager;

class WebAudioManager$2
  implements Runnable
{
  WebAudioManager$2(WebAudioManager paramWebAudioManager, int paramInt) {}
  
  public void run()
  {
    if (WebAudioManager.access$000(this.this$0) != null) {
      WebAudioManager.access$000(this.this$0).stopSource(this.val$sourceId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.webaudio.WebAudioManager.2
 * JD-Core Version:    0.7.0.1
 */