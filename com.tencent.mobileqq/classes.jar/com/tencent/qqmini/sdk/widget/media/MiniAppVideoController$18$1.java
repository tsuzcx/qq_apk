package com.tencent.qqmini.sdk.widget.media;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;

class MiniAppVideoController$18$1
  implements AbsVideoPlayer.OnCaptureImageListener
{
  MiniAppVideoController$18$1(MiniAppVideoController.18 param18) {}
  
  public void onCaptureImageFailed() {}
  
  public void onCaptureImageSucceed(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      MiniAppVideoController.access$3402(this.this$1.this$0, Bitmap.createBitmap(paramBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.18.1
 * JD-Core Version:    0.7.0.1
 */