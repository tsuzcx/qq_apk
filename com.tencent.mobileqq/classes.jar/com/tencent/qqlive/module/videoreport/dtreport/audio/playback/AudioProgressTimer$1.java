package com.tencent.qqlive.module.videoreport.dtreport.audio.playback;

import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer;

class AudioProgressTimer$1
  implements Runnable
{
  AudioProgressTimer$1(AudioProgressTimer paramAudioProgressTimer) {}
  
  public void run()
  {
    AudioProgressTimer.access$100(this.this$0).onAudioProgressChanged(AudioProgressTimer.access$000(this.this$0), AudioProgressTimer.access$000(this.this$0).getCurrentPosition__(), AudioProgressTimer.access$000(this.this$0).getDuration__());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.playback.AudioProgressTimer.1
 * JD-Core Version:    0.7.0.1
 */