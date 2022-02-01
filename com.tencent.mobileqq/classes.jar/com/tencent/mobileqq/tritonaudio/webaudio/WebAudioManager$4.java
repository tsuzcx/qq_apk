package com.tencent.mobileqq.tritonaudio.webaudio;

class WebAudioManager$4
  implements Runnable
{
  WebAudioManager$4(WebAudioManager paramWebAudioManager, int paramInt) {}
  
  public void run()
  {
    AudioNativeManager.stopSource(this.val$sourceId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager.4
 * JD-Core Version:    0.7.0.1
 */