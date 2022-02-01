package com.tencent.mobileqq.tritonaudio.webaudio;

class WebAudioManager$2
  implements Runnable
{
  WebAudioManager$2(WebAudioManager paramWebAudioManager, int paramInt) {}
  
  public void run()
  {
    AudioNativeManager.stopSource(this.val$sourceId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager.2
 * JD-Core Version:    0.7.0.1
 */