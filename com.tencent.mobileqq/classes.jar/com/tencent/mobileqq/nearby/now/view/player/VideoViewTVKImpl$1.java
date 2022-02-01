package com.tencent.mobileqq.nearby.now.view.player;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import mqq.os.MqqHandler;

class VideoViewTVKImpl$1
  implements TVK_IMediaPlayer.OnCompletionListener
{
  VideoViewTVKImpl$1(VideoViewTVKImpl paramVideoViewTVKImpl) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoViewTVKImpl", 2, "onCompletion() called with: tvk_iMediaPlayer = [" + paramTVK_IMediaPlayer + "]");
    }
    ThreadManager.getUIHandler().post(new VideoViewTVKImpl.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.player.VideoViewTVKImpl.1
 * JD-Core Version:    0.7.0.1
 */