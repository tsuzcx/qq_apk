package com.tencent.qqmini.sdk.widget.media;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;

class MiniAppVideoController$19
  implements AbsVideoPlayer.OnCaptureImageListener
{
  private boolean hasCallImageFailed = false;
  private boolean hasCallImageSucceed = false;
  
  MiniAppVideoController$19(MiniAppVideoController paramMiniAppVideoController, AbsVideoPlayer.OnCaptureImageListener paramOnCaptureImageListener) {}
  
  public void onCaptureImageFailed()
  {
    if (this.hasCallImageFailed) {
      return;
    }
    this.val$onCaptureImageListener.onCaptureImageFailed();
    this.hasCallImageFailed = true;
  }
  
  public void onCaptureImageSucceed(Bitmap paramBitmap)
  {
    if (this.hasCallImageSucceed) {
      return;
    }
    paramBitmap = Bitmap.createBitmap(paramBitmap);
    Canvas localCanvas = new Canvas(paramBitmap);
    ThreadManager.getUIHandler().post(new MiniAppVideoController.19.1(this, localCanvas, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.19
 * JD-Core Version:    0.7.0.1
 */