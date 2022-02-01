package com.tencent.tkd.topicsdk.widget.videocrop;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.tkd.topicsdk.framework.TLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onError"}, k=3, mv={1, 1, 16})
final class VideoCropPage$initVideoView$2
  implements MediaPlayer.OnErrorListener
{
  VideoCropPage$initVideoView$2(VideoCropPage paramVideoCropPage) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = "VideoView onError, what:" + paramInt1 + ", extra:" + paramInt2;
    TLog.d("VideoCropPage", paramMediaPlayer);
    VideoCropPage.a(this.a, paramMediaPlayer);
    paramMediaPlayer = this.a.a();
    if (paramMediaPlayer != null) {
      paramMediaPlayer.finish();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.VideoCropPage.initVideoView.2
 * JD-Core Version:    0.7.0.1
 */