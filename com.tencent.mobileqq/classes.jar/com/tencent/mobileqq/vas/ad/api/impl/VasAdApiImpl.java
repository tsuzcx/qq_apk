package com.tencent.mobileqq.vas.ad.api.impl;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.vas.ad.api.IVasAdApi;
import com.tencent.mobileqq.vas.ad.api.IVasAdApi.InnerVasRewardAdCallback;
import com.tencent.mobileqq.vas.ad.api.QCircleVasRewardAdParams;
import cooperation.vip.VasAdvSupport;
import cooperation.vip.reward.VasRewardAdParams.Builder;
import cooperation.vip.reward.VasRewardAdService;

public class VasAdApiImpl
  implements IVasAdApi
{
  public void VasAdvInitDeviceInfo()
  {
    VasAdvSupport.a().a(null);
  }
  
  public int _VasRewardResult_BIZ_NO_AD()
  {
    return 1;
  }
  
  public int _VasRewardResult_NON_PROFITABLE()
  {
    return 4;
  }
  
  public int _VasRewardResult_REPORT_AD_ERROR()
  {
    return 3;
  }
  
  public int _VasRewardResult_SUCCESS()
  {
    return 0;
  }
  
  public void requestAd(Context paramContext, QCircleVasRewardAdParams paramQCircleVasRewardAdParams, IVasAdApi.InnerVasRewardAdCallback paramInnerVasRewardAdCallback)
  {
    paramQCircleVasRewardAdParams = new VasRewardAdParams.Builder(Integer.valueOf(paramQCircleVasRewardAdParams.mAdvPos), Integer.valueOf(paramQCircleVasRewardAdParams.mRewardType), paramQCircleVasRewardAdParams.mRewardItem, paramQCircleVasRewardAdParams.mRewardText, Long.valueOf(paramQCircleVasRewardAdParams.mUin), paramQCircleVasRewardAdParams.mGdtBizId, paramQCircleVasRewardAdParams.mBizSrcId).a();
    new VasRewardAdService((Activity)paramContext, paramQCircleVasRewardAdParams, new VasAdApiImpl.1(this, paramInnerVasRewardAdCallback)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ad.api.impl.VasAdApiImpl
 * JD-Core Version:    0.7.0.1
 */