package com.tencent.tkd.topicsdk.videoprocess.videopreview;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "onPrepared", "com/tencent/tkd/topicsdk/videoprocess/videopreview/VideoPreviewPage$surfaceCreated$1$1"}, k=3, mv={1, 1, 16})
final class VideoPreviewPage$surfaceCreated$$inlined$apply$lambda$1
  implements MediaPlayer.OnPreparedListener
{
  VideoPreviewPage$surfaceCreated$$inlined$apply$lambda$1(VideoPreviewPage paramVideoPreviewPage) {}
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    VideoPreviewPage.a(this.a);
    VideoPreviewPage.b(this.a).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videopreview.VideoPreviewPage.surfaceCreated..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */