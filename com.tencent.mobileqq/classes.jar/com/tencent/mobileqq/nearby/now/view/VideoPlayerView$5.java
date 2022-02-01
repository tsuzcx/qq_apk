package com.tencent.mobileqq.nearby.now.view;

import com.tencent.mobileqq.nearby.now.view.player.IVideoView.OnDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class VideoPlayerView$5
  implements IVideoView.OnDownloadListener
{
  VideoPlayerView$5(VideoPlayerView paramVideoPlayerView) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnDownloadListener error ! vid = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("  url = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("  errorCode=");
      localStringBuilder.append(paramInt);
      QLog.w("VideoPlayerView", 2, localStringBuilder.toString());
    }
    if (this.a.mReultListener != null) {
      this.a.mReultListener.a(paramString1, 199, paramInt, "use sdk download error");
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    this.a.mFileSize = paramLong;
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnDownloadListener onProgress   ! vid = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("  url = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("  offset=");
      localStringBuilder.append(paramLong2);
      QLog.w("VideoPlayerView", 2, localStringBuilder.toString());
    }
    paramString1 = this.a;
    paramString1.mFileSize = paramLong1;
    if (paramLong2 > paramString1.mOffset) {
      this.a.mOffset = paramLong2;
    }
  }
  
  public void a(String paramString1, String paramString2, File paramFile)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnDownloadListener onSuccess ! vid = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("  url = ");
      localStringBuilder.append(paramString2);
      QLog.i("VideoPlayerView", 2, localStringBuilder.toString());
    }
    VideoPlayerView.setFileCompleted(paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.VideoPlayerView.5
 * JD-Core Version:    0.7.0.1
 */