package com.tencent.mobileqq.mini.widget.media;

import android.graphics.Bitmap;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCaptureImageListener;

class MiniAppVideoPlayer$18$1
  implements TVK_IMediaPlayer.OnCaptureImageListener
{
  MiniAppVideoPlayer$18$1(MiniAppVideoPlayer.18 param18) {}
  
  public void onCaptureImageFailed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2) {}
  
  public void onCaptureImageSucceed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      MiniAppVideoPlayer.access$5602(this.this$1.this$0, Bitmap.createBitmap(paramBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.18.1
 * JD-Core Version:    0.7.0.1
 */