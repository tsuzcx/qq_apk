package com.tencent.richmediabrowser.view.video;

import android.graphics.Bitmap;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.video.VideoData;
import com.tencent.richmediabrowser.presenter.video.VideoPresenter;
import com.tencent.richmediabrowser.utils.BrowserUtils;

class VideoView$2
  implements VideoPlayerCallback
{
  VideoView$2(VideoView paramVideoView, VideoPlayParam paramVideoPlayParam) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCapFrame, id:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", isSuccess:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", w:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", h:");
    localStringBuilder.append(paramInt2);
    localIBrowserLog.d("VideoView", 4, localStringBuilder.toString());
    if (VideoView.access$100(this.b) != null) {
      VideoView.access$100(this.b).onCapFrame(paramLong, paramBoolean, paramInt1, paramInt2, paramBitmap);
    }
  }
  
  public void onDownloadComplete(long paramLong)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onDownloadComplete");
    if (VideoView.access$100(this.b) != null) {
      VideoView.access$100(this.b).onDownloadComplete(paramLong);
    }
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2)
  {
    if (VideoView.access$100(this.b) != null) {
      VideoView.access$100(this.b).onDownloadProgress(paramLong1, paramLong2);
    }
  }
  
  public void onFirstFrameRendered(long paramLong)
  {
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFirstFrameRendered, id:");
    localStringBuilder.append(paramLong);
    localIBrowserLog.d("VideoView", 4, localStringBuilder.toString());
    if (VideoView.access$100(this.b) != null) {
      VideoView.access$100(this.b).onFirstFrameRendered(paramLong);
    }
  }
  
  public void onLoopBack(long paramLong1, long paramLong2)
  {
    if (VideoView.access$100(this.b) != null) {
      VideoView.access$100(this.b).onLoopBack(paramLong1, paramLong2);
    }
  }
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPlayError, id = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" ,module = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" , errorType = ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", errCode = ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(" , exInfo = ");
    localStringBuilder.append(paramString);
    localIBrowserLog.e("VideoView", 1, localStringBuilder.toString());
    if (VideoView.access$100(this.b) != null)
    {
      VideoView.access$100(this.b).onPlayError(paramLong, paramInt1, paramInt2, paramInt3, paramString);
      return;
    }
    VideoView.access$200(this.b, paramInt1, paramInt3, this.a);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    if (this.b.mVideoView != null)
    {
      double d1 = paramLong2;
      double d2 = this.b.mVideoView.getVideoDurationMs();
      Double.isNaN(d1);
      Double.isNaN(d2);
      int i = (int)(d1 / d2 * 10000.0D);
      IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPlayProgress, id = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" , position = ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(" , progress = ");
      localStringBuilder.append(i);
      localIBrowserLog.d("VideoView", 4, localStringBuilder.toString());
      this.b.progressTime.setText(BrowserUtils.a(paramLong2));
      this.b.playBar.setProgress(i);
    }
    if (VideoView.access$100(this.b) != null) {
      VideoView.access$100(this.b).onPlayProgress(paramLong1, paramLong2);
    }
  }
  
  public void onStateChange(long paramLong, int paramInt)
  {
    Object localObject = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStateChange , state = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", id = ");
    localStringBuilder.append(paramLong);
    ((IBrowserLog)localObject).d("VideoView", 4, localStringBuilder.toString());
    if (paramInt != 4)
    {
      if (paramInt != 5)
      {
        if (paramInt != 6)
        {
          if (paramInt != 8)
          {
            if (paramInt == 9) {
              this.b.abandonAudioFocus();
            }
          }
          else
          {
            if (this.b.mVideoView != null) {
              this.b.progressTime.setText(BrowserUtils.a(this.b.mVideoView.getVideoDurationMs()));
            }
            this.b.playBar.setProgress(100);
            VideoView.access$000(this.b, 0);
            this.b.updateUI();
          }
        }
        else
        {
          VideoView.access$000(this.b, 4);
          this.b.updateUI();
        }
      }
      else
      {
        VideoView.access$000(this.b, 2);
        this.b.updateUI();
      }
    }
    else
    {
      VideoView.access$000(this.b, 3);
      this.b.updateUI();
      if (!this.a.mIsMute) {
        this.b.requestAudioFocus();
      }
      localObject = this.b.videoPresenter.getCurrentVideoData();
      if (localObject != null)
      {
        this.b.videoPresenter.dealVideoMutePlay(((VideoData)localObject).id, false);
        this.b.videoPresenter.dealVideoAutoPlay(((VideoData)localObject).id, false);
      }
    }
    if (VideoView.access$100(this.b) != null) {
      VideoView.access$100(this.b).onStateChange(paramLong, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.video.VideoView.2
 * JD-Core Version:    0.7.0.1
 */