package com.tencent.mobileqq.kandian.ad.api;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IRIJLiujinAdJumpService
  extends QRouteApi
{
  public abstract Integer doJumpAction(AdvertisementInfo paramAdvertisementInfo, Context paramContext);
  
  public abstract boolean isFromLiuJin(AdvertisementInfo paramAdvertisementInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJLiujinAdJumpService
 * JD-Core Version:    0.7.0.1
 */