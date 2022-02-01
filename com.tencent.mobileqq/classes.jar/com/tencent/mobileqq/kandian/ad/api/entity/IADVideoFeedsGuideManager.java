package com.tencent.mobileqq.kandian.ad.api.entity;

import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ProgressStateListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;

public abstract interface IADVideoFeedsGuideManager
{
  public abstract void a();
  
  public abstract void a(ProgressStateListener paramProgressStateListener);
  
  public abstract void a(VideoItemHolder paramVideoItemHolder);
  
  public abstract boolean a(VideoPlayParam paramVideoPlayParam);
  
  public abstract void b();
  
  public abstract boolean c();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract VideoItemHolder i();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.entity.IADVideoFeedsGuideManager
 * JD-Core Version:    0.7.0.1
 */