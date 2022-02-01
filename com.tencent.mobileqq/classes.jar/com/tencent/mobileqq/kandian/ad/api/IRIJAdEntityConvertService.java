package com.tencent.mobileqq.kandian.ad.api;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IRIJAdEntityConvertService
  extends QRouteApi
{
  public abstract AdvertisementInfo convertAdData2AdsInfo(Object paramObject);
  
  public abstract VideoAdInfo convertAdsInfo2VideoAdInfo(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract AdvertisementInfo convertVideoAd2AdsInfo(VideoAdInfo paramVideoAdInfo);
  
  public abstract AdvertisementInfo convertVideoAd2AdsInfo(VideoAdInfo paramVideoAdInfo, Integer paramInteger1, Integer paramInteger2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService
 * JD-Core Version:    0.7.0.1
 */