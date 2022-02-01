package com.tencent.mobileqq.kandian.biz.video.api;

import com.tencent.mobileqq.kandian.base.video.player.PlayState;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;

public abstract interface OnPlayStateListener
  extends PlayState
{
  public abstract void a(VideoPlayParam paramVideoPlayParam, IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt1, int paramInt2, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.OnPlayStateListener
 * JD-Core Version:    0.7.0.1
 */