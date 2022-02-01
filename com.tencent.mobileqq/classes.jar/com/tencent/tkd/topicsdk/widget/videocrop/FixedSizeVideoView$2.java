package com.tencent.tkd.topicsdk.widget.videocrop;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "mp", "Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "onCompletion"}, k=3, mv={1, 1, 16})
final class FixedSizeVideoView$2
  implements MediaPlayer.OnCompletionListener
{
  FixedSizeVideoView$2(FixedSizeVideoView paramFixedSizeVideoView) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    FixedSizeVideoView.a(this.a).removeMessages(0);
    FixedSizeVideoView.OnTrimVDPlayCompleteListener localOnTrimVDPlayCompleteListener = this.a.getListener();
    if (localOnTrimVDPlayCompleteListener != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramMediaPlayer, "mp");
      localOnTrimVDPlayCompleteListener.a(paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.FixedSizeVideoView.2
 * JD-Core Version:    0.7.0.1
 */