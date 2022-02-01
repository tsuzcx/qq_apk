package com.tencent.qqlive.module.videoreport.dtreport.audio;

class AudioPlayerListenerImpl$1
  implements Runnable
{
  AudioPlayerListenerImpl$1(AudioPlayerListenerImpl paramAudioPlayerListenerImpl, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.val$isFirstTime)
    {
      AudioPlayerListenerImpl.access$000(this.this$0);
      return;
    }
    AudioPlayerListenerImpl.access$100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.AudioPlayerListenerImpl.1
 * JD-Core Version:    0.7.0.1
 */