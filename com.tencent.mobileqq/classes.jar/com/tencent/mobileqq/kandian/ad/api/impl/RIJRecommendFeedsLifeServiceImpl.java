package com.tencent.mobileqq.kandian.ad.api.impl;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdReqFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskConfigMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskUIMgr;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJRecommendFeedsLifeService;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class RIJRecommendFeedsLifeServiceImpl
  implements IRIJRecommendFeedsLifeService
{
  private void handleMask(Activity paramActivity, int paramInt)
  {
    if (((paramActivity instanceof SplashActivity)) && (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowKandianTab()) && (paramInt != 13))
    {
      SuperMaskConfigMgr.a.a();
      QLog.d("ReadInJoySuperMaskAd", 1, "autoRefresh reset main feeds reqNum");
    }
  }
  
  public void onBackToTopAndRefresh(Activity paramActivity, int paramInt)
  {
    handleMask(paramActivity, paramInt);
  }
  
  public void onCreate() {}
  
  public void onCreateView() {}
  
  public void onDestroy() {}
  
  public void onDestroyView()
  {
    AdReqFreshManager.a().a("RIJAdRefreshSceneMainFeeds");
    AdExposeFreshManager.a().a("RIJAdRefreshSceneMainFeeds");
  }
  
  public void onPause()
  {
    SuperMaskUIMgr.a.b(-1);
    SuperMaskUIMgr.a.c();
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoySuperMaskAd", "onPause: setSuperMaskChannelId = -1");
  }
  
  public void onResume()
  {
    SuperMaskUIMgr.a.b();
  }
  
  public void onStart() {}
  
  public void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJRecommendFeedsLifeServiceImpl
 * JD-Core Version:    0.7.0.1
 */