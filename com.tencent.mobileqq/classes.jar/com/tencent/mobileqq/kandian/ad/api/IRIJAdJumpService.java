package com.tencent.mobileqq.kandian.ad.api;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IRIJAdJumpService
  extends QRouteApi
{
  public abstract boolean isFromLiuJin(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract Integer jumpToLiujin(AdvertisementInfo paramAdvertisementInfo, Context paramContext);
  
  public abstract Integer jumpToLiujin(AdvertisementInfo paramAdvertisementInfo, Context paramContext, boolean paramBoolean);
  
  public abstract Integer openAppFromGdtApi(Context paramContext, AdvertisementInfo paramAdvertisementInfo, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams);
  
  public abstract boolean openAppFromGdtApi(Context paramContext, AdvertisementInfo paramAdvertisementInfo, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJAdJumpService
 * JD-Core Version:    0.7.0.1
 */