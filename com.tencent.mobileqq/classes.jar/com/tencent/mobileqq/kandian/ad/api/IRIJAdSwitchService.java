package com.tencent.mobileqq.kandian.ad.api;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IRIJAdSwitchService
  extends QRouteApi
{
  public abstract boolean enableCheckWebProcess(AdData paramAdData);
  
  public abstract boolean isADVideoAutoPlayFlag(AdvertisementInfo paramAdvertisementInfo, Object paramObject, Context paramContext, int paramInt);
  
  public abstract boolean isAmsSubcribeEnabled(AdData paramAdData);
  
  public abstract boolean isKingCardAutoPlay(Context paramContext);
  
  public abstract boolean isNeedShowAnotherAd(VideoAdInfo paramVideoAdInfo);
  
  public abstract boolean isServerRspReport(AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo);
  
  public abstract boolean isShowAdGuide(VideoAdInfo paramVideoAdInfo);
  
  public abstract boolean isShowZanComment(VideoAdInfo paramVideoAdInfo);
  
  public abstract boolean isTelephoneComponent(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract boolean isTelephoneComponentForDetail(AdData paramAdData);
  
  public abstract boolean isVideoFeedsAdButtonTiktokStyle();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJAdSwitchService
 * JD-Core Version:    0.7.0.1
 */