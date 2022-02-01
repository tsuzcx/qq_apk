package com.tencent.mobileqq.tritonaudio.inneraudio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "percent", "", "onBufferingUpdate"}, k=3, mv={1, 1, 16})
final class InnerAudioPlayer$onBufferingUpdateListener$1
  implements MediaPlayer.OnBufferingUpdateListener
{
  InnerAudioPlayer$onBufferingUpdateListener$1(InnerAudioPlayer paramInnerAudioPlayer) {}
  
  public final void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    int i = this.this$0.getDuration();
    InnerAudioPlayer.access$setMBufferedTime$p(this.this$0, i * paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer.onBufferingUpdateListener.1
 * JD-Core Version:    0.7.0.1
 */