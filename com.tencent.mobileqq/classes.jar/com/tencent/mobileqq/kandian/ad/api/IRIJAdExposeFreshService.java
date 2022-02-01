package com.tencent.mobileqq.kandian.ad.api;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Set;

@QAPI(process={"all"})
public abstract interface IRIJAdExposeFreshService
  extends IAdFreshService, QRouteApi
{
  public abstract void addArticleDetailsReceiveAds(String paramString, Set<AdData> paramSet);
  
  public abstract void addNormalReceiveAds(String paramString, Set<AdvertisementInfo> paramSet);
  
  public abstract void addVideoFloatReceiveAds(String paramString, Object paramObject);
  
  public abstract void handleExposedAd(String paramString, AdvertisementInfo paramAdvertisementInfo);
  
  public abstract void handleExposedAd(String paramString, Object paramObject);
  
  public abstract boolean isExposed(long paramLong);
  
  public abstract AdvertisementInfo replace(String paramString, AdvertisementInfo paramAdvertisementInfo);
  
  public abstract AdData replace(String paramString, AdData paramAdData);
  
  public abstract Object replace(String paramString, Object paramObject);
  
  public abstract boolean reqRefreshSwitch();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJAdExposeFreshService
 * JD-Core Version:    0.7.0.1
 */