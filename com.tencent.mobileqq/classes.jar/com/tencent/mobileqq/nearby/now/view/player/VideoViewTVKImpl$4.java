package com.tencent.mobileqq.nearby.now.view.player;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import mqq.os.MqqHandler;

class VideoViewTVKImpl$4
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  VideoViewTVKImpl$4(VideoViewTVKImpl paramVideoViewTVKImpl) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    ThreadManager.getUIHandler().post(new VideoViewTVKImpl.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.player.VideoViewTVKImpl.4
 * JD-Core Version:    0.7.0.1
 */