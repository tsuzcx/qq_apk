package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "mp", "Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "onPrepared"}, k=3, mv={1, 1, 16})
final class SystemCaptureProxy$onPreparedListener$1
  implements MediaPlayer.OnPreparedListener
{
  SystemCaptureProxy$onPreparedListener$1(SystemCaptureProxy paramSystemCaptureProxy) {}
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    SystemCaptureProxy.a(this.a, paramMediaPlayer);
    paramMediaPlayer.seekTo(0);
    paramMediaPlayer = SystemCaptureProxy.a(this.a);
    if (paramMediaPlayer != null) {
      paramMediaPlayer.setOnSeekCompleteListener((MediaPlayer.OnSeekCompleteListener)this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.SystemCaptureProxy.onPreparedListener.1
 * JD-Core Version:    0.7.0.1
 */