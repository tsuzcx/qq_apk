package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;

public abstract interface VideoFeedsPlayManager$VideoStatusListener
{
  public abstract void a(VideoPlayParam paramVideoPlayParam);
  
  public abstract void a(VideoPlayParam paramVideoPlayParam, int paramInt);
  
  public abstract void a(VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2, String paramString);
  
  public abstract void a(VideoPlayParam paramVideoPlayParam, boolean paramBoolean);
  
  public abstract void b(VideoPlayParam paramVideoPlayParam);
  
  public abstract void b(VideoPlayParam paramVideoPlayParam, boolean paramBoolean);
  
  public abstract void c(VideoPlayParam paramVideoPlayParam);
  
  public abstract void d(VideoPlayParam paramVideoPlayParam);
  
  public abstract void e(VideoPlayParam paramVideoPlayParam);
  
  public abstract void f(VideoPlayParam paramVideoPlayParam);
  
  public abstract void g(VideoPlayParam paramVideoPlayParam);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager.VideoStatusListener
 * JD-Core Version:    0.7.0.1
 */