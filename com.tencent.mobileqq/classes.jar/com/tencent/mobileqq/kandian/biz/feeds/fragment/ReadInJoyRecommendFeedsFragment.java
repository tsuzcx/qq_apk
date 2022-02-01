package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdExposeFreshService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.kandian.base.automator.BasePopupStep;
import com.tencent.mobileqq.kandian.base.automator.RIJPopupAutomator;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.UserReadUnReadInfoManager;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.feeds.controller.KanDianViewController;
import com.tencent.mobileqq.kandian.biz.feedspopup.RIJDailyPopupStep;
import com.tencent.mobileqq.kandian.biz.feedspopup.RIJLockScreenPopupStep;
import com.tencent.mobileqq.kandian.biz.feedspopup.RIJMsgBoxPopupStep;
import com.tencent.mobileqq.kandian.biz.feedspopup.RIJSkinOperationPopupStep;
import com.tencent.mobileqq.kandian.biz.feedspopup.RIJUGCAccountPopupStep;
import com.tencent.mobileqq.kandian.biz.framework.UserActionCollector;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController;
import com.tencent.mobileqq.kandian.glue.businesshandler.DiandianTopConfigManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;

public class ReadInJoyRecommendFeedsFragment
  extends ReadInJoyBaseFragment
{
  private long jdField_a_of_type_Long;
  private RIJPopupAutomator jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator = new RIJPopupAutomator();
  private KanDianViewController jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController;
  private long b;
  boolean e = true;
  boolean f = false;
  private boolean g = true;
  
  public static ReadInJoyRecommendFeedsFragment a()
  {
    ReadInJoyRecommendFeedsFragment localReadInJoyRecommendFeedsFragment = new ReadInJoyRecommendFeedsFragment();
    localReadInJoyRecommendFeedsFragment.setArguments(new Bundle());
    return localReadInJoyRecommendFeedsFragment;
  }
  
  private void a()
  {
    RIJPopupAutomator localRIJPopupAutomator = this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator;
    localRIJPopupAutomator.a(new BasePopupStep[] { new RIJLockScreenPopupStep(localRIJPopupAutomator, a()), new RIJDailyPopupStep(this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator, a()), new RIJMsgBoxPopupStep(this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator, a()), (BasePopupStep)((IRIJAdService)QRoute.api(IRIJAdService.class)).createSuperMaskPopupStep(this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator, a()), new RIJUGCAccountPopupStep(this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator, a()), new RIJSkinOperationPopupStep(this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator, a()) });
  }
  
  private void a(Activity paramActivity)
  {
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    if ((RIJShowKanDianTabSp.c()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity)))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      boolean bool = localKandianMergeManager.b();
      Intent localIntent = paramActivity.getIntent();
      int i = localIntent.getIntExtra("launch_from", 5);
      bool = a(i, localIntent, bool);
      long l = this.jdField_a_of_type_Long - ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a());
      bool = a(l, bool);
      if (localKandianMergeManager.j()) {
        bool = true;
      }
      bool = a(bool, l);
      if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController != null)) {
        ReadInJoyLogicEngineEventDispatcher.a().i();
      }
      a(bool, paramActivity, localKandianMergeManager, i);
      b(bool);
      return;
    }
    a(localKandianMergeManager);
  }
  
  private void a(Activity paramActivity, int paramInt)
  {
    if (((paramActivity instanceof SplashActivity)) && (RIJShowKanDianTabSp.c()) && (paramInt != 13))
    {
      ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).refreshMainFeedsReqAndRefreshNum();
      QLog.d("ReadInJoySuperMaskAd", 1, "autoRefresh reset main feeds reqNum");
    }
  }
  
  private void a(KandianMergeManager paramKandianMergeManager)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController != null) && (paramKandianMergeManager.b())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController.a(true);
    }
  }
  
  private void a(boolean paramBoolean, Activity paramActivity, KandianMergeManager paramKandianMergeManager, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController != null) && (paramBoolean))
    {
      ReadinjoySPEventReport.a().a.a = true;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController.a(paramBoolean, 3);
      ReadInJoyLogicEngineEventDispatcher.a().a(3, null);
      a(paramActivity, paramInt);
      return;
    }
    if (paramKandianMergeManager.d() > 0)
    {
      paramActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController;
      if (paramActivity != null)
      {
        paramActivity.a(false);
        return;
      }
    }
    paramActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController;
    if ((paramActivity != null) && (paramActivity.a())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController.a(false);
    }
  }
  
  private boolean a(int paramInt, Intent paramIntent, boolean paramBoolean)
  {
    if (paramInt == 13)
    {
      boolean bool = paramIntent.getBooleanExtra("force_refresh", false);
      paramBoolean = bool;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController != null)
      {
        paramIntent.removeExtra("force_refresh");
        return bool;
      }
    }
    return paramBoolean;
  }
  
  private boolean a(long paramLong, boolean paramBoolean)
  {
    if ((paramLong >= ReadInJoyHelper.d(ReadInJoyUtils.a())) && (!this.g))
    {
      if (paramLong < 900000L) {
        ReadinjoyReportUtils.c();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("kandian tab auto refresh ! duration : ");
      localStringBuilder.append(paramLong);
      QLog.d("Q.readinjoy.4tab", 2, localStringBuilder.toString());
      return true;
    }
    this.g = false;
    return paramBoolean;
  }
  
  private boolean a(boolean paramBoolean, long paramLong)
  {
    return paramBoolean;
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      UserReadUnReadInfoManager.a().a();
    }
    else if (UserReadUnReadInfoManager.a().a())
    {
      KanDianViewController localKanDianViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController;
      if (localKanDianViewController != null) {
        localKanDianViewController.a(false, 8);
      } else {
        UserReadUnReadInfoManager.a().a(true);
      }
    }
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).onResume();
  }
  
  private void i()
  {
    if ((!this.f) && (a() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator.e();
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator.h();
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    KanDianViewController localKanDianViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController;
    if (localKanDianViewController != null)
    {
      localKanDianViewController.a(true, paramInt);
      return;
    }
    ReadInJoyChannelViewPagerController.d(b());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    KanDianViewController localKanDianViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController;
    if (localKanDianViewController != null) {
      localKanDianViewController.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if (RIJShowKanDianTabSp.c())
    {
      KanDianViewController localKanDianViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController;
      if (localKanDianViewController != null) {
        localKanDianViewController.a(paramLogoutReason);
      }
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    this.jdField_b_of_type_Boolean = true;
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController;
    if (paramBundle != null) {
      paramBundle.i();
    }
    if (this.g) {
      UserReadUnReadInfoManager.a().a();
    }
    i();
    this.f = true;
    a(paramActivity);
  }
  
  public int b()
  {
    if (ChannelCoverInfoModule.a() != -1) {
      return ChannelCoverInfoModule.a();
    }
    return 0;
  }
  
  public void d()
  {
    super.d();
    KanDianViewController localKanDianViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController;
    if (localKanDianViewController != null) {
      localKanDianViewController.a(true);
    }
  }
  
  public void e()
  {
    super.e();
    this.jdField_b_of_type_Boolean = false;
    if (this.f) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator.f();
    }
    this.f = false;
    KanDianViewController localKanDianViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController;
    if (localKanDianViewController != null) {
      localKanDianViewController.j();
    }
    if (ReadInJoyHelper.m())
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      ReadInJoyHelper.a(this.jdField_b_of_type_Long, (QQAppInterface)ReadInJoyUtils.a());
    }
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).onPause();
  }
  
  public void f()
  {
    KanDianViewController localKanDianViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController;
    if (localKanDianViewController != null) {
      localKanDianViewController.a(true, 4);
    }
  }
  
  public boolean f()
  {
    KanDianViewController localKanDianViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController;
    if (localKanDianViewController != null) {
      return localKanDianViewController.b();
    }
    return false;
  }
  
  public void g()
  {
    KanDianViewController localKanDianViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController;
    if (localKanDianViewController != null) {
      localKanDianViewController.k();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    KanDianViewController localKanDianViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController;
    if (localKanDianViewController != null) {
      localKanDianViewController.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ReadInJoyLogicEngine.a().e(false);
    a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = ReadInJoyUtils.a;
    paramViewGroup = Integer.valueOf(0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController = ((KanDianViewController)paramLayoutInflater.remove(paramViewGroup));
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController = new KanDianViewController(a());
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController.aw_();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkCallHotwordChange, this.jdField_b_of_type_Int);
    if (DiandianTopConfigManager.a()) {
      DiandianTopConfigManager.a().a(false);
    }
    VideoReport.setPageId(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController.a(), "14");
    VideoReport.setPageParams(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController.a(), new RIJDtParamBuilder().a(paramViewGroup).a());
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController.a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    KanDianViewController localKanDianViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController;
    if (localKanDianViewController != null) {
      localKanDianViewController.e();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator.b();
  }
  
  public void onDestroyView()
  {
    ((IRIJAdExposeFreshService)QRoute.api(IRIJAdExposeFreshService.class)).exitScene("RIJAdRefreshSceneMainFeeds");
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    KanDianViewController localKanDianViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController;
    if (localKanDianViewController != null) {
      localKanDianViewController.h();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator.d();
    UserActionCollector.a().b();
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setChannelID(-1);
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).onPause();
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoySuperMaskAd", "onPause: setSuperMaskChannelId = -1");
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController != null) && (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController.i();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator.c();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator.g();
    UserActionCollector.a().a();
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    KanDianViewController localKanDianViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController;
    if (localKanDianViewController != null) {
      localKanDianViewController.f();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    KanDianViewController localKanDianViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController;
    if (localKanDianViewController != null) {
      localKanDianViewController.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyRecommendFeedsFragment
 * JD-Core Version:    0.7.0.1
 */