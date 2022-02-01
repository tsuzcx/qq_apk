package com.tencent.mobileqq.nearby.now.view.player.impl;

import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnInfoListener;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView.OnInfoListener;

class VideoViewTextureImpl$3
  implements IMediaPlayer.OnInfoListener
{
  VideoViewTextureImpl$3(VideoViewTextureImpl paramVideoViewTextureImpl, IVideoView.OnInfoListener paramOnInfoListener) {}
  
  public boolean a_(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 == 3)
    {
      i = 1;
    }
    else if (paramInt1 == 701)
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
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerIVideoView$OnInfoListener.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerImplVideoViewTextureImpl, i, Integer.valueOf(paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.player.impl.VideoViewTextureImpl.3
 * JD-Core Version:    0.7.0.1
 */