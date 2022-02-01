package com.tencent.mobileqq.kandian.glue.viola.videonew;

import com.tencent.mobileqq.kandian.base.bandwidth.VideoBufferRangeController;
import com.tencent.mobileqq.kandian.base.video.player.ErrorCode;
import com.tencent.mobileqq.kandian.base.video.player.MediaPlayListenerAdapter;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.biz.viola.video.VideoInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class VideoPlayManager$MediaPlayListenerAdapterImpl
  extends MediaPlayListenerAdapter
{
  private VideoPlayManager$MediaPlayListenerAdapterImpl(VideoPlayManager paramVideoPlayManager) {}
  
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper)
  {
    VideoPlayManager.VideoPlayParam localVideoPlayParam = VideoPlayManager.a(this.a);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("播放状态回调 onCompletion() vid=");
      if (localVideoPlayParam != null) {
        paramIVideoPlayerWrapper = localVideoPlayParam.a.a;
      } else {
        paramIVideoPlayerWrapper = "param null";
      }
      localStringBuilder.append(paramIVideoPlayerWrapper);
      QLog.d("Viola.VideoPlayManager", 2, localStringBuilder.toString());
    }
    paramIVideoPlayerWrapper = VideoPlayManager.a(this.a).iterator();
    while (paramIVideoPlayerWrapper.hasNext()) {
      ((VideoPlayManager.VideoStatusListener)paramIVideoPlayerWrapper.next()).h(localVideoPlayParam);
    }
  }
  
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    paramIVideoPlayerWrapper = VideoPlayManager.a(this.a);
    if ((paramIVideoPlayerWrapper != null) && (QLog.isColorLevel()))
    {
      paramObject = new StringBuilder();
      paramObject.append("播放状态回调 onVideoPrepared() vid=");
      paramObject.append(paramIVideoPlayerWrapper.a.a);
      paramObject.append(", mIsOpenedVideo = ");
      paramObject.append(VideoPlayManager.a(this.a));
      QLog.d("Viola.VideoPlayManager", 2, paramObject.toString());
    }
    if (!VideoPlayManager.a(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "onVideoPrepared  return isOpenedVideo false");
      }
      return;
    }
    VideoPlayManager.a(this.a, false);
    VideoPlayManager.a(this.a).removeMessages(0);
    VideoPlayManager.a(this.a).sendEmptyMessage(0);
    paramObject = VideoPlayManager.a(this.a).iterator();
    while (paramObject.hasNext()) {
      ((VideoPlayManager.VideoStatusListener)paramObject.next()).c(paramIVideoPlayerWrapper);
    }
    if (VideoPlayManager.b(this.a))
    {
      this.a.b();
      return;
    }
    VideoPlayManager.b(this.a, true);
  }
  
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper, String paramString)
  {
    paramIVideoPlayerWrapper = (VideoPlayerWrapper)paramIVideoPlayerWrapper;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConnectQualityCallback json= ");
      localStringBuilder.append(paramString);
      QLog.d("Viola.VideoPlayManager", 2, localStringBuilder.toString());
    }
    if (VideoPlayManager.a(this.a) != null) {
      VideoBufferRangeController.a().a(paramIVideoPlayerWrapper, VideoPlayManager.a(this.a).a.d, paramIVideoPlayerWrapper.d());
    }
  }
  
  public boolean a(IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("model : ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" what : ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" extra : ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("detailInfo : ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" obj : ");
    if (paramObject != null) {
      paramIVideoPlayerWrapper = paramObject.toString();
    } else {
      paramIVideoPlayerWrapper = "";
    }
    localStringBuilder.append(paramIVideoPlayerWrapper);
    paramString = localStringBuilder.toString();
    paramIVideoPlayerWrapper = VideoPlayManager.a(this.a);
    if ((paramIVideoPlayerWrapper != null) && (paramIVideoPlayerWrapper.a != null) && (QLog.isColorLevel()))
    {
      paramObject = new StringBuilder();
      paramObject.append("播放状态回调 onError() ");
      paramObject.append(paramString);
      paramObject.append(", vid=");
      paramObject.append(paramIVideoPlayerWrapper.a.a);
      QLog.d("Viola.VideoPlayManager", 2, paramObject.toString());
    }
    paramString = ErrorCode.a(paramInt1, paramInt2, paramInt3);
    paramObject = VideoPlayManager.a(this.a).iterator();
    while (paramObject.hasNext()) {
      ((VideoPlayManager.VideoStatusListener)paramObject.next()).a(paramIVideoPlayerWrapper, paramInt1, paramInt2, paramString);
    }
    return false;
  }
  
  public boolean a(IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt, Object paramObject)
  {
    paramIVideoPlayerWrapper = VideoPlayManager.a(this.a);
    if (paramInt != 28)
    {
      if (paramInt != 39)
      {
        if (paramInt != 40) {
          if (paramInt != 112)
          {
            if (paramInt == 113)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
              }
              paramObject = VideoPlayManager.a(this.a).iterator();
              while (paramObject.hasNext()) {
                ((VideoPlayManager.VideoStatusListener)paramObject.next()).g(paramIVideoPlayerWrapper);
              }
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
            }
            paramObject = VideoPlayManager.a(this.a).iterator();
            while (paramObject.hasNext()) {
              ((VideoPlayManager.VideoStatusListener)paramObject.next()).f(paramIVideoPlayerWrapper);
            }
          }
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.VideoPlayManager.MediaPlayListenerAdapterImpl
 * JD-Core Version:    0.7.0.1
 */