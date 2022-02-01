package com.tencent.tkd.topicsdk.widget.videocrop;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.widget.TextView;
import com.tencent.tkd.topicsdk.bean.DisplayItem;
import com.tencent.tkd.topicsdk.framework.TLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "mp", "Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "onPrepared"}, k=3, mv={1, 1, 16})
final class VideoCropPage$initVideoView$3
  implements MediaPlayer.OnPreparedListener
{
  VideoCropPage$initVideoView$3(VideoCropPage paramVideoCropPage) {}
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPrepared, duration:");
    Intrinsics.checkExpressionValueIsNotNull(paramMediaPlayer, "mp");
    ((StringBuilder)localObject).append(paramMediaPlayer.getDuration());
    TLog.b("VideoCropPage", ((StringBuilder)localObject).toString());
    VideoCropPage.a(this.a, paramMediaPlayer);
    VideoCropPage.a(this.a, paramMediaPlayer.getDuration());
    localObject = VideoCropPage.a(this.a).a();
    if (localObject != null) {
      if ((((DisplayItem)localObject).getStartMergeTime() != 0) && (((DisplayItem)localObject).getEndMergeTime() != 0)) {
        VideoCropPage.a(this.a).setPlayDuration(((DisplayItem)localObject).getStartMergeTime(), ((DisplayItem)localObject).getEndMergeTime());
      } else {
        VideoCropPage.a(this.a).setPlayDuration(VideoCropPage.a(this.a));
      }
    }
    VideoCropPage.a(this.a).start();
    if (!VideoCropPage.a(this.a).a())
    {
      if ((paramMediaPlayer.getVideoWidth() > 0) && (paramMediaPlayer.getVideoHeight() > 0))
      {
        VideoCropPage.a(this.a);
        VideoCropPage.a(this.a).setEnabled(true);
        return;
      }
      VideoCropPage.a(this.a, "videoWidth <= 0 || videoHeight <= 0");
      TLog.d("VideoCropPage", "videoWidth <= 0 || videoHeight <= 0");
      paramMediaPlayer = this.a.a();
      if (paramMediaPlayer != null) {
        paramMediaPlayer.finish();
      }
    }
    else
    {
      VideoCropPage.a(this.a).setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.VideoCropPage.initVideoView.3
 * JD-Core Version:    0.7.0.1
 */