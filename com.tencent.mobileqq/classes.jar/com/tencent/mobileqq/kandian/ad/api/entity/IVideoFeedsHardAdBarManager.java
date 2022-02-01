package com.tencent.mobileqq.kandian.ad.api.entity;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;

public abstract interface IVideoFeedsHardAdBarManager
{
  public abstract AdvertisementInfo a(Object paramObject, boolean paramBoolean);
  
  public abstract void a(long paramLong);
  
  public abstract void a(View paramView, BaseItemHolder paramBaseItemHolder, Object paramObject1, Object paramObject2);
  
  public abstract void a(IADVideoAppDownloadManager paramIADVideoAppDownloadManager);
  
  public abstract void a(VideoInfo paramVideoInfo);
  
  public abstract void a(VideoInfo paramVideoInfo, int paramInt, Integer paramInteger, boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean, VideoItemHolder paramVideoItemHolder);
  
  public abstract boolean a(String paramString);
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.entity.IVideoFeedsHardAdBarManager
 * JD-Core Version:    0.7.0.1
 */