package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.qphone.base.util.QLog;

class TVKVideoController$4
  implements VideoPlayerCallback
{
  TVKVideoController$4(TVKVideoController paramTVKVideoController) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong) {}
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong) {}
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.e("TVKVideoController", 1, "module ===== " + paramInt1 + "  errorType ===== " + paramInt2 + "  errorCode ==== " + paramInt3 + "  exInfo === " + paramString);
    TVKVideoController.a(this.a, paramInt1, paramInt3);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    if (TVKVideoController.a(this.a) != null) {
      TVKVideoController.a(this.a).onVideoProgressUpdate((int)paramLong2);
    }
  }
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TVKVideoController", 2, "onStateChange , state = " + paramInt + ", msgUniseq=" + paramLong);
    }
    switch (paramInt)
    {
    case 6: 
    default: 
      return;
    case 4: 
      TVKVideoController.c(this.a);
      TVKVideoController.a(this.a, 4);
      return;
    case 3: 
      if ((TVKVideoController.a(this.a) != null) && (TVKVideoController.a(this.a) != null))
      {
        TVKVideoController.a(this.a).onSetVideoCover(TVKVideoController.a(this.a));
        TVKVideoController.a(this.a).onVideoSize(TVKVideoController.a(this.a), TVKVideoController.b(this.a));
      }
      TVKVideoController.a(this.a, 3);
      return;
    case 8: 
      if (TVKVideoController.a(this.a) != null) {
        TVKVideoController.a(this.a).e = 0L;
      }
      if (TVKVideoController.a(this.a) != null) {
        TVKVideoController.a(this.a).mStartPlayPosMs = 0L;
      }
      TVKVideoController.d(this.a);
      if (TVKVideoController.a(this.a) != null)
      {
        TVKVideoController.a(this.a).onVideoComplete(true);
        TVKVideoController.a(this.a).onVideoProgressUpdate(0);
      }
      TVKVideoController.a(this.a, 8);
      return;
    case 7: 
      TVKVideoController.a(this.a, 7);
      return;
    }
    if (TVKVideoController.a(this.a) != null) {
      TVKVideoController.a(this.a).onVideoBuffering();
    }
    TVKVideoController.a(this.a, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.TVKVideoController.4
 * JD-Core Version:    0.7.0.1
 */