package com.tencent.mobileqq.kandian.ad.api.impl;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdExposeFreshService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import java.util.Set;

public class RIJAdExposeFreshServiceImpl
  implements IRIJAdExposeFreshService
{
  public void addArticleDetailsReceiveAds(String paramString, Set<AdData> paramSet)
  {
    AdExposeFreshManager.a().b(paramString, paramSet);
  }
  
  public void addNormalReceiveAds(String paramString, Set<AdvertisementInfo> paramSet)
  {
    AdExposeFreshManager.a().c(paramString, paramSet);
  }
  
  public void addVideoFloatReceiveAds(String paramString, Object paramObject)
  {
    AdExposeFreshManager.a().a(paramString, (Set)paramObject);
  }
  
  public void exitScene(String paramString)
  {
    AdExposeFreshManager.a().a(paramString);
  }
  
  public void handleExposedAd(String paramString, AdvertisementInfo paramAdvertisementInfo)
  {
    AdExposeFreshManager.a().a(paramString, paramAdvertisementInfo);
  }
  
  public void handleExposedAd(String paramString, Object paramObject)
  {
    AdExposeFreshManager.a().a(paramString, (VideoInfo)paramObject);
  }
  
  public boolean isExposed(long paramLong)
  {
    return AdExposeFreshManager.a().a(paramLong);
  }
  
  public AdvertisementInfo replace(String paramString, AdvertisementInfo paramAdvertisementInfo)
  {
    return AdExposeFreshManager.a().a(paramString, paramAdvertisementInfo);
  }
  
  public AdData replace(String paramString, AdData paramAdData)
  {
    return AdExposeFreshManager.a().a(paramString, paramAdData);
  }
  
  public Object replace(String paramString, Object paramObject)
  {
    return AdExposeFreshManager.a().a(paramString, (VideoInfo)paramObject);
  }
  
  public boolean reqRefreshSwitch()
  {
    return AdExposeFreshManager.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJAdExposeFreshServiceImpl
 * JD-Core Version:    0.7.0.1
 */