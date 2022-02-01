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
    paramMediaPlayer = this.this$0;
    double d1 = i;
    double d2 = paramInt;
    Double.isNaN(d1);
    Double.isNaN(d2);
    InnerAudioPlayer.access$setMBufferedTime$p(paramMediaPlayer, d1 * d2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer.onBufferingUpdateListener.1
 * JD-Core Version:    0.7.0.1
 */