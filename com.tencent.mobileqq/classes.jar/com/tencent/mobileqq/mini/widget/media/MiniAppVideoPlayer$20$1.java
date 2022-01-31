package com.tencent.mobileqq.mini.widget.media;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCaptureImageListener;

class MiniAppVideoPlayer$20$1
  implements Runnable
{
  MiniAppVideoPlayer$20$1(MiniAppVideoPlayer.20 param20, Canvas paramCanvas, TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((MiniAppVideoPlayer.access$5700(this.this$1.this$0) != null) && (MiniAppVideoPlayer.access$5700(this.this$1.this$0).getVisibility() == 0))
    {
      MiniAppVideoPlayer.access$5700(this.this$1.this$0).setDrawingCacheEnabled(true);
      MiniAppVideoPlayer.access$5700(this.this$1.this$0).buildDrawingCache();
      MiniAppVideoPlayer.access$5700(this.this$1.this$0).setDrawingCacheEnabled(false);
    }
    if ((MiniAppVideoPlayer.access$5800(this.this$1.this$0) != null) && (MiniAppVideoPlayer.access$5800(this.this$1.this$0).getVisibility() == 0))
    {
      MiniAppVideoPlayer.access$5800(this.this$1.this$0).setDrawingCacheEnabled(true);
      MiniAppVideoPlayer.access$5800(this.this$1.this$0).buildDrawingCache();
      Bitmap localBitmap = MiniAppVideoPlayer.access$5800(this.this$1.this$0).getDrawingCache();
      if (localBitmap != null) {
        this.val$canvas.drawBitmap(Bitmap.createBitmap(localBitmap), 0.0F, 0.0F, null);
      }
      MiniAppVideoPlayer.access$5800(this.this$1.this$0).setDrawingCacheEnabled(false);
    }
    if (this.this$1.val$onCaptureImageListener != null) {
      this.this$1.val$onCaptureImageListener.onCaptureImageSucceed(this.val$tvk_iMediaPlayer, this.val$i, this.val$i1, this.val$i2, this.val$mergedBitmap);
    }
    try
    {
      MiniAppVideoPlayer.access$1100(this.this$1.this$0).setOnCaptureImageListener(null);
      MiniAppVideoPlayer.20.access$5902(this.this$1, true);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("MiniAppVideoPlayer", 1, "onCaptureImageSucceed mVideoPlayer.setOnCaptureImageListener get a Throwable:", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.20.1
 * JD-Core Version:    0.7.0.1
 */