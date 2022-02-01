package com.tencent.mobileqq.kandian.ad.api.impl;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdSwitchService;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;

public class RIJAdSwitchServiceImpl
  implements IRIJAdSwitchService
{
  public boolean enableCheckWebProcess(AdData paramAdData)
  {
    return ReadInJoyAdSwitchUtil.c(paramAdData);
  }
  
  public boolean isADVideoAutoPlayFlag(AdvertisementInfo paramAdvertisementInfo, Object paramObject, Context paramContext, int paramInt)
  {
    return ReadInJoyAdSwitchUtil.a(paramAdvertisementInfo, (ProteusBannerVideoItemData)paramObject, paramContext, paramInt);
  }
  
  public boolean isAmsSubcribeEnabled(AdData paramAdData)
  {
    return ReadInJoyAdSwitchUtil.d(paramAdData);
  }
  
  public boolean isKingCardAutoPlay(Context paramContext)
  {
    return ReadInJoyAdSwitchUtil.a(paramContext);
  }
  
  public boolean isNeedShowAnotherAd(VideoAdInfo paramVideoAdInfo)
  {
    return ReadInJoyAdSwitchUtil.e(paramVideoAdInfo);
  }
  
  public boolean isServerRspReport(AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo)
  {
    return ReadInJoyAdSwitchUtil.a(paramAdvertisementInfo, paramVideoAdInfo);
  }
  
  public boolean isShowAdGuide(VideoAdInfo paramVideoAdInfo)
  {
    return ReadInJoyAdSwitchUtil.a(paramVideoAdInfo);
  }
  
  public boolean isShowZanComment(VideoAdInfo paramVideoAdInfo)
  {
    return ReadInJoyAdSwitchUtil.g(paramVideoAdInfo);
  }
  
  public boolean isTelephoneComponent(AdvertisementInfo paramAdvertisementInfo)
  {
    return ReadInJoyAdSwitchUtil.i(paramAdvertisementInfo);
  }
  
  public boolean isTelephoneComponentForDetail(AdData paramAdData)
  {
    return ReadInJoyAdSwitchUtil.e(paramAdData);
  }
  
  public boolean isVideoFeedsAdButtonTiktokStyle()
  {
    return ReadInJoyAdSwitchUtil.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJAdSwitchServiceImpl
 * JD-Core Version:    0.7.0.1
 */