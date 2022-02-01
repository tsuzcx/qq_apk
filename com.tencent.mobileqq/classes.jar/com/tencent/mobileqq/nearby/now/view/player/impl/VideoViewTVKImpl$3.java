package com.tencent.mobileqq.nearby.now.view.player.impl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import mqq.os.MqqHandler;

class VideoViewTVKImpl$3
  implements TVK_IMediaPlayer.OnInfoListener
{
  VideoViewTVKImpl$3(VideoViewTVKImpl paramVideoViewTVKImpl) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramTVK_IMediaPlayer = new StringBuilder();
      paramTVK_IMediaPlayer.append("onInfo what=");
      paramTVK_IMediaPlayer.append(paramInt);
      paramTVK_IMediaPlayer.append("  ex:");
      paramTVK_IMediaPlayer.append(paramObject);
      QLog.d("VideoViewTVKImpl", 2, paramTVK_IMediaPlayer.toString());
    }
    ThreadManager.getUIHandler().post(new VideoViewTVKImpl.3.1(this, paramInt, paramObject));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.player.impl.VideoViewTVKImpl.3
 * JD-Core Version:    0.7.0.1
 */