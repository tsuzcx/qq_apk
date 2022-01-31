package com.tencent.qqmini.sdk.minigame.webaudio;

import bgwp;
import com.tencent.mobileqq.triton.sdk.audio.IAudioNativeManager;

public class WebAudioManager$2
  implements Runnable
{
  public WebAudioManager$2(bgwp parambgwp, int paramInt) {}
  
  public void run()
  {
    if (bgwp.a(this.this$0) != null) {
      bgwp.a(this.this$0).stopSource(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.2
 * JD-Core Version:    0.7.0.1
 */