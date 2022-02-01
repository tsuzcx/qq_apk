package com.tencent.qqlive.module.videoreport.dtreport.audio.playback;

import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer;

class ReportMediaPlayer$2
  implements AudioListeners.OnPlayCompletionListener
{
  ReportMediaPlayer$2(ReportMediaPlayer paramReportMediaPlayer, MediaPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public void onAudioPlayComplete(IAudioPlayer paramIAudioPlayer)
  {
    this.val$listener.onCompletion(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */