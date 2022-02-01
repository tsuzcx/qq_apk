package com.tencent.mobileqq.kandian.biz.video.playfeeds.api;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;

public abstract interface IVideoFeedsFollowButton
{
  public abstract void a(VideoInfo paramVideoInfo, boolean paramBoolean);
  
  public abstract long getAnimDelayDuration();
  
  public abstract View getView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsFollowButton
 * JD-Core Version:    0.7.0.1
 */