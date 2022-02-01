package com.tencent.qqlive.module.videoreport.dtreport.audio.playback;

import android.media.MediaPlayer.OnErrorListener;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer;

class ReportMediaPlayer$3
  implements AudioListeners.OnPlayErrorListener
{
  ReportMediaPlayer$3(ReportMediaPlayer paramReportMediaPlayer, MediaPlayer.OnErrorListener paramOnErrorListener) {}
  
  public boolean onAudioError(IAudioPlayer paramIAudioPlayer, int paramInt1, int paramInt2)
  {
    return (this.val$listener != null) && (this.val$listener.onError(this.this$0, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer.3
 * JD-Core Version:    0.7.0.1
 */