package com.tencent.mobileqq.nearby.now.view.player.impl;

import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnErrorListener;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView.OnErrorListener;

class VideoViewTextureImpl$2
  implements IMediaPlayer.OnErrorListener
{
  VideoViewTextureImpl$2(VideoViewTextureImpl paramVideoViewTextureImpl, IVideoView.OnErrorListener paramOnErrorListener, Object paramObject) {}
  
  public boolean a(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    paramIMediaPlayer = this.a;
    VideoViewTextureImpl localVideoViewTextureImpl = this.c;
    return paramIMediaPlayer.a(localVideoViewTextureImpl, 0, paramInt1, localVideoViewTextureImpl.a.getCurrentPosition(), String.valueOf(paramInt2), this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.player.impl.VideoViewTextureImpl.2
 * JD-Core Version:    0.7.0.1
 */