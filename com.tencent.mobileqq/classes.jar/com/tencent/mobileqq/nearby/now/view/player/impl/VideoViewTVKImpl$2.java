package com.tencent.mobileqq.nearby.now.view.player.impl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import mqq.os.MqqHandler;

class VideoViewTVKImpl$2
  implements TVK_IMediaPlayer.OnErrorListener
{
  VideoViewTVKImpl$2(VideoViewTVKImpl paramVideoViewTVKImpl) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onError called with: tvk_iMediaPlayer = [");
      localStringBuilder.append(paramTVK_IMediaPlayer);
      localStringBuilder.append("], model = [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], what = [");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], position = [");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("], extra = [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], Info = [");
      localStringBuilder.append(paramObject);
      localStringBuilder.append("]");
      QLog.i("VideoViewTVKImpl", 2, localStringBuilder.toString());
    }
    ThreadManager.getUIHandler().post(new VideoViewTVKImpl.2.1(this, paramInt1, paramInt2, paramInt3, paramString, paramObject));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.player.impl.VideoViewTVKImpl.2
 * JD-Core Version:    0.7.0.1
 */