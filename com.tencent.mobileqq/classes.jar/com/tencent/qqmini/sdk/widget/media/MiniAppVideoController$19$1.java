package com.tencent.qqmini.sdk.widget.media;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;

class MiniAppVideoController$19$1
  implements Runnable
{
  MiniAppVideoController$19$1(MiniAppVideoController.19 param19, Canvas paramCanvas, Bitmap paramBitmap) {}
  
  public void run()
  {
    MiniAppVideoController.access$300(this.this$1.this$0).onCaptureImageSucceed(this.val$canvas);
    this.this$1.val$onCaptureImageListener.onCaptureImageSucceed(this.val$mergedBitmap);
    MiniAppVideoController.19.access$3502(this.this$1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.19.1
 * JD-Core Version:    0.7.0.1
 */