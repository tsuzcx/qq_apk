package com.tencent.mobileqq.kandian.ad.api.entity;

import android.content.res.Configuration;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;

public abstract interface IVideoFeedsGameAdComManager
{
  public abstract void a(Configuration paramConfiguration);
  
  public abstract void a(VideoItemHolder paramVideoItemHolder);
  
  public abstract boolean a(VideoItemHolder paramVideoItemHolder, boolean paramBoolean);
  
  public abstract int b();
  
  public abstract int c();
  
  public abstract void d();
  
  public abstract void s();
  
  public abstract Object t();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.entity.IVideoFeedsGameAdComManager
 * JD-Core Version:    0.7.0.1
 */