package com.tencent.qqmini.sdk.widget.media;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;

class MiniAppVideoPlayer$17$1
  implements AbsVideoPlayer.OnCaptureImageListener
{
  MiniAppVideoPlayer$17$1(MiniAppVideoPlayer.17 param17) {}
  
  public void onCaptureImageFailed(AbsVideoPlayer paramAbsVideoPlayer) {}
  
  public void onCaptureImageSucceed(AbsVideoPlayer paramAbsVideoPlayer, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      MiniAppVideoPlayer.access$6002(this.this$1.this$0, Bitmap.createBitmap(paramBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayer.17.1
 * JD-Core Version:    0.7.0.1
 */