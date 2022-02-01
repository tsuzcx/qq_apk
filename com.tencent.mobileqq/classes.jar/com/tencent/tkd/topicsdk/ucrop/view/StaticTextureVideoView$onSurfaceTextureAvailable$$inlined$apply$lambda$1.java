package com.tencent.tkd.topicsdk.ucrop.view;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "mp", "Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "width", "", "height", "onVideoSizeChanged", "com/tencent/tkd/topicsdk/ucrop/view/StaticTextureVideoView$onSurfaceTextureAvailable$1$1"}, k=3, mv={1, 1, 16})
final class StaticTextureVideoView$onSurfaceTextureAvailable$$inlined$apply$lambda$1
  implements MediaPlayer.OnVideoSizeChangedListener
{
  StaticTextureVideoView$onSurfaceTextureAvailable$$inlined$apply$lambda$1(StaticTextureVideoView paramStaticTextureVideoView) {}
  
  public final void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = this.a.getSurfaceTexture();
    if (paramMediaPlayer != null) {
      paramMediaPlayer.setDefaultBufferSize(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.view.StaticTextureVideoView.onSurfaceTextureAvailable..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */