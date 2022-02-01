package com.tencent.mobileqq.kandian.base.video.player;

import com.tencent.mobileqq.kandian.base.bandwidth.VideoBufferRangeController;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class LitePlayer$MediaPlayListenerAdapterImpl
  extends MediaPlayListenerAdapter
{
  LitePlayer$MediaPlayListenerAdapterImpl(LitePlayer paramLitePlayer) {}
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(LitePlayer.a(this.a), 2, "onPreloadFinished()");
    }
    this.a.a.j();
  }
  
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper)
  {
    if (QLog.isColorLevel())
    {
      String str = LitePlayer.a(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("播放状态回调 onCompletion() vid=");
      if (LitePlayer.a(this.a) != null) {
        paramIVideoPlayerWrapper = LitePlayer.a(this.a).a;
      } else {
        paramIVideoPlayerWrapper = "param null";
      }
      localStringBuilder.append(paramIVideoPlayerWrapper);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.a.a.a(null);
    paramIVideoPlayerWrapper = LitePlayer.a(this.a).iterator();
    while (paramIVideoPlayerWrapper.hasNext()) {
      ((PlayerStatusListener)paramIVideoPlayerWrapper.next()).onCompletion();
    }
    paramIVideoPlayerWrapper = LitePlayer.b(this.a).iterator();
    while (paramIVideoPlayerWrapper.hasNext()) {
      ((IPlayerReporter)paramIVideoPlayerWrapper.next()).a();
    }
  }
  
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(LitePlayer.a(this.a), 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    if (QLog.isColorLevel())
    {
      if (LitePlayer.a(this.a) != null) {
        paramIVideoPlayerWrapper = LitePlayer.a(this.a).a;
      } else {
        paramIVideoPlayerWrapper = null;
      }
      paramObject = LitePlayer.a(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("播放状态回调 onVideoPrepared() vid=");
      localStringBuilder.append(paramIVideoPlayerWrapper);
      localStringBuilder.append(", mIsOpenedVideo = ");
      localStringBuilder.append(LitePlayer.b(this.a));
      localStringBuilder.append(", preload=");
      localStringBuilder.append(LitePlayer.a(this.a));
      localStringBuilder.append(", mActivityOnResume=");
      localStringBuilder.append(LitePlayer.c(this.a));
      QLog.d(paramObject, 2, localStringBuilder.toString());
    }
    if (LitePlayer.a(this.a))
    {
      a();
      return;
    }
    if ((LitePlayer.b(this.a)) && (!LitePlayer.d(this.a)))
    {
      LitePlayer.b(this.a, false);
      LitePlayer.a(this.a).removeMessages(0);
      LitePlayer.a(this.a).sendEmptyMessage(0);
      paramIVideoPlayerWrapper = LitePlayer.a(this.a).iterator();
      while (paramIVideoPlayerWrapper.hasNext()) {
        ((PlayerStatusListener)paramIVideoPlayerWrapper.next()).onVideoPrepared();
      }
      paramIVideoPlayerWrapper = LitePlayer.b(this.a).iterator();
      while (paramIVideoPlayerWrapper.hasNext()) {
        ((IPlayerReporter)paramIVideoPlayerWrapper.next()).b(this.a.a);
      }
      LitePlayer.b(this.a);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramIVideoPlayerWrapper = LitePlayer.a(this.a);
      paramObject = new StringBuilder();
      paramObject.append("onVideoPrepared  return mIsOpenedVideo=");
      paramObject.append(LitePlayer.b(this.a));
      paramObject.append(", mHasDestory=");
      paramObject.append(LitePlayer.d(this.a));
      QLog.d(paramIVideoPlayerWrapper, 2, paramObject.toString());
    }
  }
  
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper, String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = LitePlayer.a(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConnectQualityCallback json= ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    paramIVideoPlayerWrapper = (VideoPlayerWrapper)paramIVideoPlayerWrapper;
    if (LitePlayer.a(this.a) != null) {
      VideoBufferRangeController.a().a(paramIVideoPlayerWrapper, LitePlayer.a(this.a).b, paramIVideoPlayerWrapper.d());
    }
    paramIVideoPlayerWrapper = LitePlayer.b(this.a).iterator();
    while (paramIVideoPlayerWrapper.hasNext()) {
      ((IPlayerReporter)paramIVideoPlayerWrapper.next()).a(paramString);
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
    paramIVideoPlayerWrapper = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      paramString = LitePlayer.a(this.a);
      paramObject = new StringBuilder();
      paramObject.append("播放状态回调 onError() ");
      paramObject.append(paramIVideoPlayerWrapper);
      paramObject.append(", vid=");
      if (LitePlayer.a(this.a) != null) {
        paramIVideoPlayerWrapper = LitePlayer.a(this.a).a;
      } else {
        paramIVideoPlayerWrapper = null;
      }
      paramObject.append(paramIVideoPlayerWrapper);
      QLog.d(paramString, 2, paramObject.toString());
    }
    if (LitePlayer.a(this.a))
    {
      paramIVideoPlayerWrapper = this.a;
      LitePlayer.a(paramIVideoPlayerWrapper, paramIVideoPlayerWrapper.a);
      LitePlayer.a(this.a, false);
    }
    paramIVideoPlayerWrapper = ErrorCode.a(paramInt1, paramInt2, paramInt3);
    paramString = LitePlayer.a(this.a).iterator();
    while (paramString.hasNext()) {
      ((PlayerStatusListener)paramString.next()).onVideoError(paramInt1, paramInt2, paramIVideoPlayerWrapper);
    }
    paramString = LitePlayer.b(this.a).iterator();
    while (paramString.hasNext()) {
      ((IPlayerReporter)paramString.next()).a(paramInt1, paramInt2, paramIVideoPlayerWrapper);
    }
    return false;
  }
  
  public boolean a(IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt, Object paramObject)
  {
    if (paramInt != 105)
    {
      if (paramInt != 112)
      {
        if (paramInt == 113)
        {
          if (QLog.isColorLevel()) {
            QLog.d(LitePlayer.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
          }
          paramIVideoPlayerWrapper = LitePlayer.a(this.a).iterator();
          while (paramIVideoPlayerWrapper.hasNext()) {
            ((PlayerStatusListener)paramIVideoPlayerWrapper.next()).onBufferEnd();
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(LitePlayer.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
        }
        paramIVideoPlayerWrapper = LitePlayer.a(this.a).iterator();
        while (paramIVideoPlayerWrapper.hasNext()) {
          ((PlayerStatusListener)paramIVideoPlayerWrapper.next()).onBufferStart();
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(LitePlayer.a(this.a), 2, "onInfo: PLAYER_INFO_FIRST_VIDEO_FRAME_REDNERED");
      }
      paramIVideoPlayerWrapper = LitePlayer.a(this.a).iterator();
      while (paramIVideoPlayerWrapper.hasNext()) {
        ((PlayerStatusListener)paramIVideoPlayerWrapper.next()).onFirstFrameRendered();
      }
    }
    paramIVideoPlayerWrapper = LitePlayer.b(this.a).iterator();
    while (paramIVideoPlayerWrapper.hasNext()) {
      ((IPlayerReporter)paramIVideoPlayerWrapper.next()).a(paramInt, paramObject);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.LitePlayer.MediaPlayListenerAdapterImpl
 * JD-Core Version:    0.7.0.1
 */