package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

class AdVideoViewController$3
  implements VideoPlayerCallback
{
  AdVideoViewController$3(AdVideoViewController paramAdVideoViewController, AlumBasicData paramAlumBasicData, BaseVideoView paramBaseVideoView) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong) {}
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong) {}
  
  public void onLoopBack(long paramLong1, long paramLong2)
  {
    Object localObject = this.b;
    if (localObject != null) {
      paramLong1 = ((BaseVideoView)localObject).getCurPlayingPos();
    } else {
      paramLong1 = 0L;
    }
    AdVideoViewController.i(this.c);
    if (AdVideoViewController.a(this.c) != null)
    {
      localObject = this.c;
      AdVideoViewController.a((AdVideoViewController)localObject, AdVideoViewController.g((AdVideoViewController)localObject), paramLong1, 0, 3, true, this.a.mVideoReportUrl);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AdVideoView", 0, "onLoopBack ");
    }
  }
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramString = this.b;
    if (paramString != null) {
      paramLong = paramString.getCurPlayingPos();
    } else {
      paramLong = 0L;
    }
    if (AdVideoViewController.a(this.c) != null)
    {
      paramString = this.c;
      AdVideoViewController.a(paramString, AdVideoViewController.g(paramString), paramLong, 3, 3, false, this.a.mVideoReportUrl);
    }
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    AdVideoViewController.a(this.c, paramLong2);
  }
  
  public void onStateChange(long paramLong, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onStateChange , state = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", msgUniseq=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("time ");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("AdVideoView", 0, ((StringBuilder)localObject).toString());
    }
    if (paramInt != 4)
    {
      if (paramInt != 6) {
        return;
      }
      if (AdVideoViewController.c(this.c) != null) {
        AdVideoViewController.c(this.c).setVisibility(0);
      }
      if (AdVideoViewController.f(this.c))
      {
        AdVideoViewController.a(this.c, false);
        paramInt = 2;
      }
      else
      {
        paramInt = 3;
      }
      if (this.a != null)
      {
        localObject = this.c;
        AdVideoViewController.a((AdVideoViewController)localObject, AdVideoViewController.g((AdVideoViewController)localObject), AdVideoViewController.h(this.c), 0, paramInt, false, this.a.mVideoReportUrl);
      }
    }
    else
    {
      if (AdVideoViewController.c(this.c) != null) {
        AdVideoViewController.c(this.c).setVisibility(8);
      }
      if (AdVideoViewController.e(this.c) != null) {
        AdVideoViewController.e(this.c).setVisibility(8);
      }
      AdVideoViewController.b(this.c, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.logic.AdVideoViewController.3
 * JD-Core Version:    0.7.0.1
 */