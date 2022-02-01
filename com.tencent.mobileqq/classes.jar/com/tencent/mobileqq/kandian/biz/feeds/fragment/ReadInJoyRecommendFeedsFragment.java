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
  boolean a = true;
  boolean b = false;
  private KanDianViewController c;
  private long d;
  private long m;
  private boolean n = true;
  private RIJPopupAutomator o = new RIJPopupAutomator();
  
  public static ReadInJoyRecommendFeedsFragment a()
  {
    ReadInJoyRecommendFeedsFragment localReadInJoyRecommendFeedsFragment = new ReadInJoyRecommendFeedsFragment();
    localReadInJoyRecommendFeedsFragment.setArguments(new Bundle());
    return localReadInJoyRecommendFeedsFragment;
  }
  
  private void a(Activity paramActivity)
  {
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)ReadInJoyUtils.b().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    if ((RIJShowKanDianTabSp.c()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity)))
    {
      this.d = System.currentTimeMillis();
      boolean bool = localKandianMergeManager.d();
      Intent localIntent = paramActivity.getIntent();
      int i = localIntent.getIntExtra("launch_from", 5);
      bool = a(i, localIntent, bool);
      long l = this.d - ReadInJoyHelper.c((QQAppInterface)ReadInJoyUtils.b());
      bool = a(l, bool);
      if (localKandianMergeManager.U()) {
        bool = true;
      }
      bool = a(bool, l);
      if ((bool) && (this.c != null)) {
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
    if ((this.c != null) && (paramKandianMergeManager.d())) {
      this.c.a(true);
    }
  }
  
  private void a(boolean paramBoolean, Activity paramActivity, KandianMergeManager paramKandianMergeManager, int paramInt)
  {
    if ((this.c != null) && (paramBoolean))
    {
      ReadinjoySPEventReport.a().f.i = true;
      this.c.a(paramBoolean, 3);
      ReadInJoyLogicEngineEventDispatcher.a().a(3, null);
      a(paramActivity, paramInt);
      return;
    }
    if (paramKandianMergeManager.H() > 0)
    {
      paramActivity = this.c;
      if (paramActivity != null)
      {
        paramActivity.a(false);
        return;
      }
    }
    paramActivity = this.c;
    if ((paramActivity != null) && (paramActivity.k())) {
      this.c.a(false);
    }
  }
  
  private boolean a(int paramInt, Intent paramIntent, boolean paramBoolean)
  {
    if (paramInt == 13)
    {
      boolean bool = paramIntent.getBooleanExtra("force_refresh", false);
      paramBoolean = bool;
      if (this.c != null)
      {
        paramIntent.removeExtra("force_refresh");
        return bool;
      }
    }
    return paramBoolean;
  }
  
  private boolean a(long paramLong, boolean paramBoolean)
  {
    if ((paramLong >= ReadInJoyHelper.at(ReadInJoyUtils.b())) && (!this.n))
    {
      if (paramLong < 900000L) {
        ReadinjoyReportUtils.f();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("kandian tab auto refresh ! duration : ");
      localStringBuilder.append(paramLong);
      QLog.d("Q.readinjoy.4tab", 2, localStringBuilder.toString());
      return true;
    }
    this.n = false;
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
      UserReadUnReadInfoManager.a().e();
    }
    else if (UserReadUnReadInfoManager.a().b())
    {
      KanDianViewController localKanDianViewController = this.c;
      if (localKanDianViewController != null) {
        localKanDianViewController.a(false, 8);
      } else {
        UserReadUnReadInfoManager.a().a(true);
      }
    }
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).onResume();
  }
  
  private void x()
  {
    RIJPopupAutomator localRIJPopupAutomator = this.o;
    localRIJPopupAutomator.a(new BasePopupStep[] { new RIJLockScreenPopupStep(localRIJPopupAutomator, v()), new RIJDailyPopupStep(this.o, v()), new RIJMsgBoxPopupStep(this.o, v()), (BasePopupStep)((IRIJAdService)QRoute.api(IRIJAdService.class)).createSuperMaskPopupStep(this.o, v()), new RIJUGCAccountPopupStep(this.o, v()), new RIJSkinOperationPopupStep(this.o, v()) });
  }
  
  private void y()
  {
    if ((!this.b) && (v() != null))
    {
      this.o.e();
      this.o.h();
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    KanDianViewController localKanDianViewController = this.c;
    if (localKanDianViewController != null)
    {
      localKanDianViewController.a(true, paramInt);
      return;
    }
    ReadInJoyChannelViewPagerController.d(d());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    KanDianViewController localKanDianViewController = this.c;
    if (localKanDianViewController != null) {
      localKanDianViewController.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if (RIJShowKanDianTabSp.c())
    {
      KanDianViewController localKanDianViewController = this.c;
      if (localKanDianViewController != null) {
        localKanDianViewController.a(paramLogoutReason);
      }
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    this.g = true;
    paramBundle = this.c;
    if (paramBundle != null) {
      paramBundle.i();
    }
    if (this.n) {
      UserReadUnReadInfoManager.a().e();
    }
    y();
    this.b = true;
    a(paramActivity);
  }
  
  public int d()
  {
    if (ChannelCoverInfoModule.g() != -1) {
      return ChannelCoverInfoModule.g();
    }
    return 0;
  }
  
  public void h()
  {
    super.h();
    KanDianViewController localKanDianViewController = this.c;
    if (localKanDianViewController != null) {
      localKanDianViewController.a(true);
    }
  }
  
  public void i()
  {
    super.i();
    KanDianViewController localKanDianViewController = this.c;
    if (localKanDianViewController != null) {
      localKanDianViewController.q();
    }
  }
  
  public void j()
  {
    super.j();
    KanDianViewController localKanDianViewController = this.c;
    if (localKanDianViewController != null) {
      localKanDianViewController.r();
    }
  }
  
  public void k()
  {
    super.k();
    this.g = false;
    if (this.b) {
      this.o.f();
    }
    this.b = false;
    KanDianViewController localKanDianViewController = this.c;
    if (localKanDianViewController != null) {
      localKanDianViewController.n();
    }
    if (ReadInJoyHelper.w())
    {
      this.m = System.currentTimeMillis();
      ReadInJoyHelper.a(this.m, (QQAppInterface)ReadInJoyUtils.b());
    }
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).onPause();
  }
  
  public void l()
  {
    KanDianViewController localKanDianViewController = this.c;
    if (localKanDianViewController != null) {
      localKanDianViewController.a(true, 4);
    }
  }
  
  public void n()
  {
    KanDianViewController localKanDianViewController = this.c;
    if (localKanDianViewController != null) {
      localKanDianViewController.cR_();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    KanDianViewController localKanDianViewController = this.c;
    if (localKanDianViewController != null) {
      localKanDianViewController.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ReadInJoyLogicEngine.a().e(false);
    x();
    this.o.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = ReadInJoyUtils.c;
    paramViewGroup = Integer.valueOf(0);
    this.c = ((KanDianViewController)paramLayoutInflater.remove(paramViewGroup));
    if (this.c == null)
    {
      this.c = new KanDianViewController(v());
      this.c.cT_();
    }
    this.c.a(this.j, this.k);
    if (DiandianTopConfigManager.c()) {
      DiandianTopConfigManager.a().a(false);
    }
    VideoReport.setPageId(this.c.l(), "14");
    VideoReport.setPageParams(this.c.l(), new RIJDtParamBuilder().a(paramViewGroup).b());
    return this.c.l();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    KanDianViewController localKanDianViewController = this.c;
    if (localKanDianViewController != null) {
      localKanDianViewController.e();
    }
    this.c = null;
    this.o.b();
  }
  
  public void onDestroyView()
  {
    ((IRIJAdExposeFreshService)QRoute.api(IRIJAdExposeFreshService.class)).exitScene("RIJAdRefreshSceneMainFeeds");
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    KanDianViewController localKanDianViewController = this.c;
    if (localKanDianViewController != null) {
      localKanDianViewController.h();
    }
    this.o.d();
    UserActionCollector.a().c();
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setChannelID(-1);
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).onPause();
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoySuperMaskAd", "onPause: setSuperMaskChannelId = -1");
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.c != null) && (this.g)) {
      this.c.i();
    }
    this.o.c();
    this.o.g();
    UserActionCollector.a().b();
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    KanDianViewController localKanDianViewController = this.c;
    if (localKanDianViewController != null) {
      localKanDianViewController.f();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    KanDianViewController localKanDianViewController = this.c;
    if (localKanDianViewController != null) {
      localKanDianViewController.g();
    }
  }
  
  public boolean w()
  {
    KanDianViewController localKanDianViewController = this.c;
    if (localKanDianViewController != null) {
      return localKanDianViewController.p();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyRecommendFeedsFragment
 * JD-Core Version:    0.7.0.1
 */