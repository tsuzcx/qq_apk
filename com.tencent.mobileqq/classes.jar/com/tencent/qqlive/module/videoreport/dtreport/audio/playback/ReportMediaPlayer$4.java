package com.tencent.qqlive.module.videoreport.dtreport.audio.playback;

import android.media.MediaPlayer.OnInfoListener;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer;

class ReportMediaPlayer$4
  implements AudioListeners.OnPlayInfoListener
{
  ReportMediaPlayer$4(ReportMediaPlayer paramReportMediaPlayer, MediaPlayer.OnInfoListener paramOnInfoListener) {}
  
  public boolean onAudioInfo(IAudioPlayer paramIAudioPlayer, int paramInt1, int paramInt2)
  {
    paramIAudioPlayer = this.val$listener;
    return (paramIAudioPlayer != null) && (paramIAudioPlayer.onInfo(this.this$0, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer.4
 * JD-Core Version:    0.7.0.1
 */