package com.tencent.qqmini.minigame.webaudio;

import com.tencent.mobileqq.triton.sdk.audio.IAudioNativeManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class WebAudioManager$1
  implements Runnable
{
  WebAudioManager$1(WebAudioManager paramWebAudioManager, int paramInt1, int paramInt2, RequestEvent paramRequestEvent, int paramInt3) {}
  
  public void run()
  {
    if (WebAudioManager.access$000(this.this$0) != null)
    {
      WebAudioManager.access$000(this.this$0).play(this.val$sourceId, this.val$offset);
      WebAudioManager.access$100(this.this$0, this.val$req, this.val$sourceId, this.val$audioId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.webaudio.WebAudioManager.1
 * JD-Core Version:    0.7.0.1
 */