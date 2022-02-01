package com.tencent.mobileqq.nearby.now.view.player;

import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnInfoListener;

class VideoViewTextureImpl$3
  implements IMediaPlayer.OnInfoListener
{
  VideoViewTextureImpl$3(VideoViewTextureImpl paramVideoViewTextureImpl, IVideoView.OnInfoListener paramOnInfoListener) {}
  
  public boolean a_(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 == 3) {
      i = 1;
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerIVideoView$OnInfoListener.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerVideoViewTextureImpl, i, Integer.valueOf(paramInt2));
      if (paramInt1 == 701)
      {
        i = 2;
      }
      else
      {
        i = paramInt1;
        if (paramInt1 == 702) {
          i = 3;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.player.VideoViewTextureImpl.3
 * JD-Core Version:    0.7.0.1
 */