package com.tencent.mobileqq.kandian.ad.api.entity;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

public abstract interface IRecommendADVideoFeedsManager
{
  public abstract VideoPlayParam a(AdvertisementInfo paramAdvertisementInfo, View paramView, IReadInJoyModel paramIReadInJoyModel);
  
  public abstract void a();
  
  public abstract void a(IVideoPlayManager paramIVideoPlayManager);
  
  public abstract boolean a(VideoPlayParam paramVideoPlayParam);
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.entity.IRecommendADVideoFeedsManager
 * JD-Core Version:    0.7.0.1
 */