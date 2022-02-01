package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;

public abstract interface VideoFeedsAdapter$AdapterEventListener
{
  public abstract void a();
  
  public abstract void a(long paramLong);
  
  public abstract void a(VideoInfo paramVideoInfo, boolean paramBoolean);
  
  public abstract void a(VideoItemHolder paramVideoItemHolder);
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAdapter.AdapterEventListener
 * JD-Core Version:    0.7.0.1
 */