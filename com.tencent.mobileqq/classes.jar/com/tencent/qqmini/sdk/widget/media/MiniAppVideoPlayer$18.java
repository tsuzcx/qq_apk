package com.tencent.qqmini.sdk.widget.media;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;

class MiniAppVideoPlayer$18
  implements AbsVideoPlayer.OnCaptureImageListener
{
  private boolean hasCallImageFailed = false;
  private boolean hasCallImageSucceed = false;
  
  MiniAppVideoPlayer$18(MiniAppVideoPlayer paramMiniAppVideoPlayer, AbsVideoPlayer.OnCaptureImageListener paramOnCaptureImageListener) {}
  
  public void onCaptureImageFailed(AbsVideoPlayer paramAbsVideoPlayer)
  {
    if (this.hasCallImageFailed) {
      return;
    }
    this.val$onCaptureImageListener.onCaptureImageFailed(paramAbsVideoPlayer);
    MiniAppVideoPlayer.access$000(this.this$0).setOnCaptureImageListener(null);
    this.hasCallImageFailed = true;
  }
  
  public void onCaptureImageSucceed(AbsVideoPlayer paramAbsVideoPlayer, Bitmap paramBitmap)
  {
    if (this.hasCallImageSucceed) {
      return;
    }
    paramBitmap = Bitmap.createBitmap(paramBitmap);
    Canvas localCanvas = new Canvas(paramBitmap);
    ThreadManager.getUIHandler().post(new MiniAppVideoPlayer.18.1(this, localCanvas, paramAbsVideoPlayer, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayer.18
 * JD-Core Version:    0.7.0.1
 */