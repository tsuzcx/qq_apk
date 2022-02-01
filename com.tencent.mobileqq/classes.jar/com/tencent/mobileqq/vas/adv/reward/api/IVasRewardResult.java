package com.tencent.mobileqq.vas.adv.reward.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/reward/api/IVasRewardResult;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "_ACTIVITY_IS_NULL", "", "_BIZ_NO_AD", "_DEVICE_INFO_NULL", "_NON_PROFITABLE", "_REPEATING_REQUEST_AD", "_REPORT_AD_ERROR", "_REPORT_AD_RSP_ERROR", "_REQUEST_AD_ERROR", "_REQUEST_AD_RSP_ERROR", "_SUCCESS", "vas-adv-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVasRewardResult
  extends QRouteApi
{
  public abstract int _ACTIVITY_IS_NULL();
  
  public abstract int _BIZ_NO_AD();
  
  public abstract int _DEVICE_INFO_NULL();
  
  public abstract int _NON_PROFITABLE();
  
  public abstract int _REPEATING_REQUEST_AD();
  
  public abstract int _REPORT_AD_ERROR();
  
  public abstract int _REPORT_AD_RSP_ERROR();
  
  public abstract int _REQUEST_AD_ERROR();
  
  public abstract int _REQUEST_AD_RSP_ERROR();
  
  public abstract int _SUCCESS();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.reward.api.IVasRewardResult
 * JD-Core Version:    0.7.0.1
 */