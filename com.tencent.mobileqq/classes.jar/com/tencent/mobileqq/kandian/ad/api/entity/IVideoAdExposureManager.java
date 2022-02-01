package com.tencent.mobileqq.kandian.ad.api.entity;

import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.video.api.IBaseVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;

public abstract interface IVideoAdExposureManager
{
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2, VideoInfo paramVideoInfo);
  
  public abstract void a(int paramInt, VideoPlayParam paramVideoPlayParam, Object paramObject);
  
  public abstract void a(VideoAdInfo paramVideoAdInfo, int paramInt);
  
  public abstract void a(IBaseVideoItemHolder paramIBaseVideoItemHolder);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean, int paramInt, Object paramObject);
  
  public abstract boolean a(int paramInt);
  
  public abstract void b(int paramInt, VideoPlayParam paramVideoPlayParam, Object paramObject);
  
  public abstract void c(int paramInt);
  
  public abstract VideoInfo d(int paramInt);
  
  public abstract VideoInfo i(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdExposureManager
 * JD-Core Version:    0.7.0.1
 */