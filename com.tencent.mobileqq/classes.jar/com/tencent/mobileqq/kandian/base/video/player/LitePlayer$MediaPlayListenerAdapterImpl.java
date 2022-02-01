package com.tencent.mobileqq.kandian.base.video.player;

import com.tencent.mobileqq.kandian.base.bandwidth.VideoBufferRangeController;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

class LitePlayer$MediaPlayListenerAdapterImpl
  extends MediaPlayListenerAdapter
{
  LitePlayer$MediaPlayListenerAdapterImpl(LitePlayer paramLitePlayer) {}
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(LitePlayer.f(this.a), 2, "onPreloadFinished()");
    }
  }
  
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper)
  {
    if (QLog.isColorLevel())
    {
      String str = LitePlayer.f(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("播放状态回调 onCompletion() vid=");
      if (LitePlayer.g(this.a) != null) {
        paramIVideoPlayerWrapper = LitePlayer.g(this.a).a;
      } else {
        paramIVideoPlayerWrapper = "param null";
      }
      localStringBuilder.append(paramIVideoPlayerWrapper);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.a.b.a(null);
    paramIVideoPlayerWrapper = LitePlayer.b(this.a).iterator();
    while (paramIVideoPlayerWrapper.hasNext()) {
      ((PlayerStatusListener)paramIVideoPlayerWrapper.next()).onCompletion();
    }
    paramIVideoPlayerWrapper = LitePlayer.i(this.a).iterator();
    while (paramIVideoPlayerWrapper.hasNext()) {
      ((IPlayerReporter)paramIVideoPlayerWrapper.next()).a();
    }
  }
  
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(LitePlayer.f(this.a), 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    if (QLog.isColorLevel())
    {
      if (LitePlayer.g(this.a) != null) {
        paramIVideoPlayerWrapper = LitePlayer.g(this.a).a;
      } else {
        paramIVideoPlayerWrapper = null;
      }
      paramObject = LitePlayer.f(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("播放状态回调 onVideoPrepared() vid=");
      localStringBuilder.append(paramIVideoPlayerWrapper);
      localStringBuilder.append(", mIsOpenedVideo = ");
      localStringBuilder.append(LitePlayer.j(this.a));
      localStringBuilder.append(", preload=");
      localStringBuilder.append(LitePlayer.a(this.a));
      localStringBuilder.append(", mActivityOnResume=");
      localStringBuilder.append(LitePlayer.k(this.a));
      QLog.d(paramObject, 2, localStringBuilder.toString());
    }
    if (LitePlayer.a(this.a))
    {
      a();
      return;
    }
    if ((LitePlayer.j(this.a)) && (!LitePlayer.l(this.a)) && (LitePlayer.m(this.a)))
    {
      LitePlayer.b(this.a, false);
      LitePlayer.e(this.a).removeMessages(0);
      LitePlayer.e(this.a).sendEmptyMessage(0);
      paramIVideoPlayerWrapper = LitePlayer.b(this.a).iterator();
      while (paramIVideoPlayerWrapper.hasNext()) {
        ((PlayerStatusListener)paramIVideoPlayerWrapper.next()).onVideoPrepared();
      }
      paramIVideoPlayerWrapper = LitePlayer.i(this.a).iterator();
      while (paramIVideoPlayerWrapper.hasNext()) {
        ((IPlayerReporter)paramIVideoPlayerWrapper.next()).b(this.a.b);
      }
      LitePlayer.h(this.a);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramIVideoPlayerWrapper = LitePlayer.f(this.a);
      paramObject = new StringBuilder();
      paramObject.append("onVideoPrepared  return mIsOpenedVideo=");
      paramObject.append(LitePlayer.j(this.a));
      paramObject.append(", mHasDestory=");
      paramObject.append(LitePlayer.l(this.a));
      QLog.d(paramIVideoPlayerWrapper, 2, paramObject.toString());
    }
  }
  
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = LitePlayer.f(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConnectQualityCallback json= ");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    paramIVideoPlayerWrapper = (VideoPlayerWrapper)paramIVideoPlayerWrapper;
    Object localObject = LitePlayer.g(this.a);
    if (localObject != null) {
      VideoBufferRangeController.a().a(paramIVideoPlayerWrapper, ((LitePlayer.PlayParams)localObject).e, paramIVideoPlayerWrapper.M());
    }
    paramIVideoPlayerWrapper = LitePlayer.i(this.a).iterator();
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
      paramString = LitePlayer.f(this.a);
      paramObject = new StringBuilder();
      paramObject.append("播放状态回调 onError() ");
      paramObject.append(paramIVideoPlayerWrapper);
      paramObject.append(", vid=");
      if (LitePlayer.g(this.a) != null) {
        paramIVideoPlayerWrapper = LitePlayer.g(this.a).a;
      } else {
        paramIVideoPlayerWrapper = null;
      }
      paramObject.append(paramIVideoPlayerWrapper);
      QLog.d(paramString, 2, paramObject.toString());
    }
    if (LitePlayer.a(this.a))
    {
      paramIVideoPlayerWrapper = this.a;
      LitePlayer.a(paramIVideoPlayerWrapper, paramIVideoPlayerWrapper.b);
      LitePlayer.a(this.a, false);
    }
    paramIVideoPlayerWrapper = ErrorCode.a(paramInt1, paramInt2, paramInt3);
    paramString = LitePlayer.b(this.a).iterator();
    while (paramString.hasNext()) {
      ((PlayerStatusListener)paramString.next()).onVideoError(paramInt1, paramInt2, paramIVideoPlayerWrapper);
    }
    paramString = LitePlayer.i(this.a).iterator();
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
            QLog.d(LitePlayer.f(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
          }
          paramIVideoPlayerWrapper = LitePlayer.b(this.a).iterator();
          while (paramIVideoPlayerWrapper.hasNext()) {
            ((PlayerStatusListener)paramIVideoPlayerWrapper.next()).onBufferEnd();
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(LitePlayer.f(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
        }
        paramIVideoPlayerWrapper = LitePlayer.b(this.a).iterator();
        while (paramIVideoPlayerWrapper.hasNext()) {
          ((PlayerStatusListener)paramIVideoPlayerWrapper.next()).onBufferStart();
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(LitePlayer.f(this.a), 2, "onInfo: PLAYER_INFO_FIRST_VIDEO_FRAME_REDNERED");
      }
      paramIVideoPlayerWrapper = LitePlayer.b(this.a).iterator();
      while (paramIVideoPlayerWrapper.hasNext()) {
        ((PlayerStatusListener)paramIVideoPlayerWrapper.next()).onFirstFrameRendered();
      }
    }
    paramIVideoPlayerWrapper = LitePlayer.i(this.a).iterator();
    while (paramIVideoPlayerWrapper.hasNext()) {
      ((IPlayerReporter)paramIVideoPlayerWrapper.next()).a(paramInt, paramObject);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.LitePlayer.MediaPlayListenerAdapterImpl
 * JD-Core Version:    0.7.0.1
 */