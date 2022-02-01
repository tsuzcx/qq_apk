package com.tencent.mobileqq.tritonaudio.webaudio;

import com.tencent.mobileqq.triton.script.Argument;

class WebAudioManager$1
  implements Runnable
{
  WebAudioManager$1(WebAudioManager paramWebAudioManager, int paramInt1, int paramInt2, Argument paramArgument, int paramInt3) {}
  
  public void run()
  {
    AudioNativeManager.play(this.val$sourceId, this.val$offset);
    WebAudioManager.access$000(this.this$0, this.val$argument, this.val$sourceId, this.val$audioId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager.1
 * JD-Core Version:    0.7.0.1
 */