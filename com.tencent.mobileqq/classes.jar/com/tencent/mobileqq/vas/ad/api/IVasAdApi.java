package com.tencent.mobileqq.vas.ad.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IVasAdApi
  extends QRouteApi
{
  public abstract void VasAdvInitDeviceInfo();
  
  public abstract int _VasRewardResult_BIZ_NO_AD();
  
  public abstract int _VasRewardResult_NON_PROFITABLE();
  
  public abstract int _VasRewardResult_REPORT_AD_ERROR();
  
  public abstract int _VasRewardResult_SUCCESS();
  
  public abstract void requestAd(Context paramContext, QCircleVasRewardAdParams paramQCircleVasRewardAdParams, IVasAdApi.InnerVasRewardAdCallback paramInnerVasRewardAdCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ad.api.IVasAdApi
 * JD-Core Version:    0.7.0.1
 */