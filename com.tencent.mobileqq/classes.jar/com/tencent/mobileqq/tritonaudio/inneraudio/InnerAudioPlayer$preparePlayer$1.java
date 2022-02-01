package com.tencent.mobileqq.tritonaudio.inneraudio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnMediaTimeDiscontinuityListener;
import android.media.MediaTimestamp;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/media/MediaTimestamp;", "onMediaTimeDiscontinuity"}, k=3, mv={1, 1, 16})
final class InnerAudioPlayer$preparePlayer$1
  implements MediaPlayer.OnMediaTimeDiscontinuityListener
{
  InnerAudioPlayer$preparePlayer$1(InnerAudioPlayer paramInnerAudioPlayer) {}
  
  public final void onMediaTimeDiscontinuity(MediaPlayer paramMediaPlayer, MediaTimestamp paramMediaTimestamp)
  {
    if (!this.this$0.isPaused())
    {
      paramMediaPlayer = this.this$0.getStateChangeListener();
      if (paramMediaPlayer != null) {
        paramMediaPlayer.onWaiting();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer.preparePlayer.1
 * JD-Core Version:    0.7.0.1
 */