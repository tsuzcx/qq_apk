package com.tencent.qqlive.module.videoreport.dtreport.audio.playback;

import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer;

class ReportMediaPlayer$1
  implements AudioListeners.OnPlayPreparedListener
{
  ReportMediaPlayer$1(ReportMediaPlayer paramReportMediaPlayer, MediaPlayer.OnPreparedListener paramOnPreparedListener) {}
  
  public void onAudioPlayPrepared(IAudioPlayer paramIAudioPlayer)
  {
    paramIAudioPlayer = this.val$listener;
    if (paramIAudioPlayer != null) {
      paramIAudioPlayer.onPrepared(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */