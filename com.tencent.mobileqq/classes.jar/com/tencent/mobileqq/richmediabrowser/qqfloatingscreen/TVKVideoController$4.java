package com.tencent.mobileqq.richmediabrowser.qqfloatingscreen;

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
    if (TVKVideoController.a(this.a) != null) {
      TVKVideoController.a(this.a).onVideoProgressUpdate((int)paramLong2);
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
          }
          TVKVideoController.a(this.a, 7);
          return;
        }
        if (TVKVideoController.a(this.a) != null) {
          TVKVideoController.a(this.a).onVideoBuffering();
        }
        TVKVideoController.a(this.a, 5);
        return;
      }
      TVKVideoController.c(this.a);
      TVKVideoController.a(this.a, 4);
      return;
    }
    if ((TVKVideoController.a(this.a) != null) && (TVKVideoController.a(this.a) != null))
    {
      TVKVideoController.a(this.a).onSetVideoCover(TVKVideoController.a(this.a));
      TVKVideoController.a(this.a).onVideoSize(TVKVideoController.a(this.a), TVKVideoController.b(this.a));
    }
    TVKVideoController.a(this.a, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.qqfloatingscreen.TVKVideoController.4
 * JD-Core Version:    0.7.0.1
 */