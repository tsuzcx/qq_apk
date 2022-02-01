package com.tencent.mobileqq.tritonaudio.inneraudio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "onSeekComplete"}, k=3, mv={1, 1, 16})
final class InnerAudioPlayer$mOnSeekCompleteListener$1
  implements MediaPlayer.OnSeekCompleteListener
{
  InnerAudioPlayer$mOnSeekCompleteListener$1(InnerAudioPlayer paramInnerAudioPlayer) {}
  
  public final void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer = this.this$0.getStateChangeListener();
    if (paramMediaPlayer != null) {
      paramMediaPlayer.onSeeked();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer.mOnSeekCompleteListener.1
 * JD-Core Version:    0.7.0.1
 */