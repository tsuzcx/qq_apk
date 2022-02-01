package com.tencent.mobileqq.kandian.ad.api.impl;

import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.ReadInjoyADExposureManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.ad.api.IRIJADExposureService;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import mqq.app.AppRuntime;

public class RIJADExposureServiceImpl
  implements IRIJADExposureService
{
  private ReadInjoyADExposureManager exposureManager;
  
  public void checkADScrollAction(IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, Activity paramActivity, boolean paramBoolean, double paramDouble)
  {
    this.exposureManager.a(paramIReadInJoyBaseAdapter, paramActivity, paramBoolean, paramDouble);
  }
  
  public boolean checkAndReportAdExposure(IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, Activity paramActivity, boolean paramBoolean)
  {
    return this.exposureManager.a(paramIReadInJoyBaseAdapter, paramActivity, paramBoolean);
  }
  
  public void clearAdExposureTime()
  {
    this.exposureManager.a();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.exposureManager = ((ReadInjoyADExposureManager)paramAppRuntime.getManager(QQManagerFactory.KANDIAN_AD_EXPOSURE_MANAGER));
  }
  
  public void onDestroy() {}
  
  public void reportAllInvalidADExposure(Activity paramActivity)
  {
    this.exposureManager.a(paramActivity);
  }
  
  public void reportInvalidADExposure(Context paramContext, int paramInt)
  {
    this.exposureManager.a(paramContext, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJADExposureServiceImpl
 * JD-Core Version:    0.7.0.1
 */