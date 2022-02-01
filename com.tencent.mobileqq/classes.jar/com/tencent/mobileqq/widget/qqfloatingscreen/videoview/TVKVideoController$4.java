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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("module ===== ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("  errorType ===== ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("  errorCode ==== ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("  exInfo === ");
    localStringBuilder.append(paramString);
    QLog.e("TVKVideoController", 1, localStringBuilder.toString());
    TVKVideoController.a(this.a, paramInt1, paramInt3);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    if (TVKVideoController.e(this.a) != null) {
      TVKVideoController.e(this.a).onVideoProgressUpdate((int)paramLong2);
    }
  }
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStateChange , state = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", msgUniseq=");
      localStringBuilder.append(paramLong);
      QLog.d("TVKVideoController", 2, localStringBuilder.toString());
    }
    if (paramInt != 3)
    {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if (paramInt != 7)
          {
            if (paramInt != 8) {
              return;
            }
            if (TVKVideoController.j(this.a) != null) {
              TVKVideoController.j(this.a).q = 0L;
            }
            if (TVKVideoController.k(this.a) != null) {
              TVKVideoController.k(this.a).mStartPlayPosMs = 0L;
            }
            TVKVideoController.l(this.a);
            if (TVKVideoController.e(this.a) != null)
            {
              TVKVideoController.e(this.a).onVideoComplete(true);
              TVKVideoController.e(this.a).onVideoProgressUpdate(0);
            }
            TVKVideoController.b(this.a, 8);
            return;
          }
          TVKVideoController.b(this.a, 7);
          return;
        }
        if (TVKVideoController.e(this.a) != null) {
          TVKVideoController.e(this.a).onVideoBuffering();
        }
        TVKVideoController.b(this.a, 5);
        return;
      }
      TVKVideoController.f(this.a);
      TVKVideoController.b(this.a, 4);
      return;
    }
    if ((TVKVideoController.g(this.a) != null) && (TVKVideoController.e(this.a) != null))
    {
      TVKVideoController.e(this.a).onSetVideoCover(TVKVideoController.g(this.a));
      TVKVideoController.e(this.a).onVideoSize(TVKVideoController.h(this.a), TVKVideoController.i(this.a));
    }
    TVKVideoController.b(this.a, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.TVKVideoController.4
 * JD-Core Version:    0.7.0.1
 */