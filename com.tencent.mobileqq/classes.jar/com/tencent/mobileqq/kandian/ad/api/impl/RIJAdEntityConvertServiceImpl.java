package com.tencent.mobileqq.kandian.ad.api.impl;

import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.NativeAd.util.RIJAdReportManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyBottomAdVideoUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;

public class RIJAdEntityConvertServiceImpl
  implements IRIJAdEntityConvertService
{
  public AdvertisementInfo convertAdData2AdsInfo(Object paramObject)
  {
    return ReadInJoyBottomAdVideoUtil.a((AdData)paramObject);
  }
  
  public VideoAdInfo convertAdsInfo2VideoAdInfo(AdvertisementInfo paramAdvertisementInfo)
  {
    return NativeAdUtils.a(paramAdvertisementInfo);
  }
  
  public AdvertisementInfo convertVideoAd2AdsInfo(VideoAdInfo paramVideoAdInfo)
  {
    return RIJAdReportManager.a(paramVideoAdInfo);
  }
  
  public AdvertisementInfo convertVideoAd2AdsInfo(VideoAdInfo paramVideoAdInfo, Integer paramInteger1, Integer paramInteger2)
  {
    return RIJAdReportManager.a(paramVideoAdInfo, paramInteger1, paramInteger2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJAdEntityConvertServiceImpl
 * JD-Core Version:    0.7.0.1
 */