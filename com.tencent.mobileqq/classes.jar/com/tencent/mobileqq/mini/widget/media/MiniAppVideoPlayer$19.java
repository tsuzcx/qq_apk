package com.tencent.mobileqq.mini.widget.media;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCaptureImageListener;

class MiniAppVideoPlayer$19
  implements TVK_IMediaPlayer.OnCaptureImageListener
{
  private boolean hasCallImageFailed;
  private boolean hasCallImageSucceed;
  
  MiniAppVideoPlayer$19(MiniAppVideoPlayer paramMiniAppVideoPlayer, TVK_IMediaPlayer.OnCaptureImageListener paramOnCaptureImageListener) {}
  
  public void onCaptureImageFailed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2)
  {
    if (this.hasCallImageFailed) {
      return;
    }
    if (this.val$onCaptureImageListener != null) {
      this.val$onCaptureImageListener.onCaptureImageFailed(paramTVK_IMediaPlayer, paramInt1, paramInt2);
    }
    try
    {
      MiniAppVideoPlayer.access$800(this.this$0).setOnCaptureImageListener(null);
      this.hasCallImageFailed = true;
      return;
    }
    catch (Throwable paramTVK_IMediaPlayer)
    {
      for (;;)
      {
        QLog.e("MiniAppVideoPlayer", 1, "onCaptureImageFailed mVideoPlayer.setOnCaptureImageListener get a Throwable:", paramTVK_IMediaPlayer);
      }
    }
  }
  
  public void onCaptureImageSucceed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    if (this.hasCallImageSucceed) {
      return;
    }
    paramBitmap = Bitmap.createBitmap(paramBitmap);
    Canvas localCanvas = new Canvas(paramBitmap);
    ThreadManagerV2.getUIHandlerV2().post(new MiniAppVideoPlayer.19.1(this, localCanvas, paramTVK_IMediaPlayer, paramInt1, paramInt2, paramInt3, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.19
 * JD-Core Version:    0.7.0.1
 */