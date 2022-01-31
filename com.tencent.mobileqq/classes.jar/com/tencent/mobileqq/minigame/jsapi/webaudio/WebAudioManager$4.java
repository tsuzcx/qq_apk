package com.tencent.mobileqq.minigame.jsapi.webaudio;

class WebAudioManager$4
  implements Runnable
{
  WebAudioManager$4(WebAudioManager paramWebAudioManager, int paramInt) {}
  
  public void run()
  {
    AudioNativeManager.stopSource(this.val$sourceId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.webaudio.WebAudioManager.4
 * JD-Core Version:    0.7.0.1
 */