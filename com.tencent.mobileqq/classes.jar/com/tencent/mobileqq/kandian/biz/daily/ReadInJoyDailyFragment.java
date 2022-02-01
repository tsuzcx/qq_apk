package com.tencent.mobileqq.kandian.biz.daily;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.util.GifHelper;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdExposeFreshService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.kandian.base.automator.BasePopupStep;
import com.tencent.mobileqq.kandian.base.automator.RIJPopupAutomator;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInjoyFloatingWindowHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.diandian.RecommendFeedsDiandianEntranceManager;
import com.tencent.mobileqq.kandian.biz.feedspopup.RIJDailyFloatingPopupStep;
import com.tencent.mobileqq.kandian.biz.feedspopup.RIJDailyPopupStep;
import com.tencent.mobileqq.kandian.biz.feedspopup.RIJLockScreenPopupStep;
import com.tencent.mobileqq.kandian.biz.feedspopup.RIJMsgBoxPopupStep;
import com.tencent.mobileqq.kandian.biz.feedspopup.RIJSkinOperationPopupStep;
import com.tencent.mobileqq.kandian.biz.feedspopup.RIJUGCAccountPopupStep;
import com.tencent.mobileqq.kandian.biz.framework.UserActionCollector;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotification;
import com.tencent.mobileqq.kandian.glue.baseconfig.RIJImageAladdinConfig;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.daily.PreLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ReadInJoyDailyFragment
  extends PublicBaseFragment
{
  public static List<String> a = new ArrayList(1);
  private static TimeSliceHelper d = new TimeSliceHelper();
  private ReadInJoyDailyViewController b;
  private DailyDynamicHeaderViewController c;
  private int e = 5;
  private View f;
  private View g;
  private boolean h = false;
  private RIJPopupAutomator i = new RIJPopupAutomator();
  private RIJDailyFloatingPopupStep j;
  private Runnable k = new ReadInJoyDailyFragment.1(this);
  private final View.OnClickListener l = new ReadInJoyDailyFragment.2(this);
  private BroadcastReceiver m = new ReadInJoyDailyFragment.3(this);
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    KandianDailyReportUtils.a(paramIntent);
    if (i())
    {
      paramIntent = RIJQQAppInterfaceUtil.a();
      if (paramIntent != null)
      {
        KandianMergeManager localKandianMergeManager = (KandianMergeManager)paramIntent.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
        localKandianMergeManager.o();
        localKandianMergeManager.W();
        RIJKanDianFolderStatus.updateKandianFolderStatus(paramIntent);
      }
    }
  }
  
  private void a(String paramString)
  {
    String str;
    if (DailyModeConfigHandler.b(DailyModeConfigHandler.j())) {
      str = "0X80089D1";
    } else {
      str = "0X80098B0";
    }
    ThreadManager.executeOnSubThread(new ReadInJoyDailyFragment.4(this, paramString, str));
  }
  
  public static boolean a()
  {
    return a.size() > 0;
  }
  
  public static void c()
  {
    TimeSliceHelper localTimeSliceHelper = d;
    if (localTimeSliceHelper != null)
    {
      localTimeSliceHelper.c();
      QLog.d("ReadInJoyDailyFragment", 2, "stopTimeCalculateWhenInBackground");
    }
  }
  
  public static void d()
  {
    TimeSliceHelper localTimeSliceHelper = d;
    if (localTimeSliceHelper != null)
    {
      localTimeSliceHelper.b();
      QLog.d("ReadInJoyDailyFragment", 2, "wakeUpTimeCalculateWhenInForeground");
    }
  }
  
  private void f()
  {
    if (RIJQQAppInterfaceUtil.a() == null) {
      return;
    }
    if (this.j == null) {
      this.j = new RIJDailyFloatingPopupStep(this.i, getBaseActivity());
    }
    RIJPopupAutomator localRIJPopupAutomator = this.i;
    localRIJPopupAutomator.a(new BasePopupStep[] { new RIJLockScreenPopupStep(localRIJPopupAutomator, getBaseActivity()), new RIJDailyPopupStep(this.i, getBaseActivity()), new RIJMsgBoxPopupStep(this.i, getBaseActivity()), this.j, (BasePopupStep)((IRIJAdService)QRoute.api(IRIJAdService.class)).createSuperMaskPopupStep(this.i, getBaseActivity()), new RIJUGCAccountPopupStep(this.i, getBaseActivity()), new RIJSkinOperationPopupStep(this.i, getBaseActivity()) });
  }
  
  private void g()
  {
    if (getBaseActivity() != null)
    {
      IntentFilter localIntentFilter = new IntentFilter("float_layer_finsh_action");
      getBaseActivity().registerReceiver(this.m, localIntentFilter);
    }
  }
  
  private void h()
  {
    if (getBaseActivity() != null) {
      getBaseActivity().unregisterReceiver(this.m);
    }
  }
  
  private boolean i()
  {
    int n = this.e;
    return (n == 6) || (n == 9);
  }
  
  private void j()
  {
    ThreadManager.executeOnSubThread(new ReadInJoyDailyFragment.5(this));
  }
  
  private void k()
  {
    d.g();
    QLog.d("ReadInJoyDailyFragment", 2, "resetTime when create");
  }
  
  public void b()
  {
    View localView;
    if (ThemeUtil.isNowThemeIsNight(ReadInJoyUtils.b(), false, null))
    {
      if (this.g == null) {
        this.g = ((ViewStub)this.f.findViewById(2131431564)).inflate();
      }
      localView = this.g;
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
    else
    {
      localView = this.g;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ReadInJoyDailyViewController localReadInJoyDailyViewController = this.b;
    if (localReadInJoyDailyViewController != null) {
      localReadInJoyDailyViewController.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    if ((getBaseActivity() != null) && (getBaseActivity().getIntent() != null) && (getBaseActivity().getIntent().hasExtra("launch_from")))
    {
      int n = getBaseActivity().getIntent().getIntExtra("launch_from", 0);
      if ((n == 9) || (n == 6))
      {
        Intent localIntent = new Intent(getBaseActivity(), SplashActivity.class);
        localIntent.putExtra("fragment_id", 1);
        localIntent.putExtra("tab_index", FrameControllerUtil.a);
        localIntent.putExtra("open_kandian_tab_fragment", true);
        localIntent.putExtra("arg_channel_cover_id", 0);
        localIntent.setFlags(335544320);
        getBaseActivity().startActivity(localIntent);
      }
    }
    return super.onBackEvent();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getResources().getDisplayMetrics();
    float f2 = FontSettingManager.getFontLevel() / 16.0F;
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = 1.0F;
    }
    f1 = paramConfiguration.density / f1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onConfigurationChanged densityNoScale : ");
    localStringBuilder.append(f1);
    localStringBuilder.append(", screenWidth : ");
    localStringBuilder.append(paramConfiguration.widthPixels);
    QLog.d("ReadInJoyDailyFragment", 1, localStringBuilder.toString());
    Utils.init(f1, paramConfiguration.widthPixels);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    RIJImageAladdinConfig.a.a();
    DailyModeConfigHandler.h();
    KandianDailyReportUtils.a(getBaseActivity().app);
    KandianDailyReportUtils.g();
    a.add(String.valueOf(hashCode()));
    UserActionCollector.a().a(UserActionCollector.g, 1);
    GifHelper.a();
    paramBundle = getBaseActivity();
    if (paramBundle != null)
    {
      localObject = paramBundle.getIntent();
      if (localObject != null) {
        this.e = ((Intent)localObject).getIntExtra("launch_from", 5);
      }
      a((Intent)localObject);
    }
    ThreadManager.getFileThreadHandler().postDelayed(this.k, 20000L);
    PreLoader.a().b();
    j();
    Object localObject = getArguments();
    int n;
    if (this.e == 15)
    {
      com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.b = true;
      QLog.d("ReadInJoyDailyFragment", 1, "from aio share");
      n = 1;
    }
    else
    {
      n = 0;
    }
    if ((localObject != null) && (paramBundle != null))
    {
      if (((Bundle)localObject).getBoolean("open_floating_window", false)) {
        n = 1;
      }
      if (n != 0)
      {
        QLog.d("ReadInJoyDailyFragment", 1, "openFloatingWindow is true");
        n = ((Bundle)localObject).getInt("floating_window_business");
        int i1 = ((Bundle)localObject).getInt("floating_window_scene");
        ReadInjoyFloatingWindowHelper.a(paramBundle, i1, n, (Bundle)localObject, DailyModeConfigHandler.j());
        if ((i1 == 1) && ((n != 1) || (ReadInjoyFloatingWindowHelper.a((Bundle)localObject)))) {
          KandianDailyReportUtils.a(32);
        }
      }
    }
    g();
    RIJPushNotification.c();
    k();
    f();
    this.i.a();
    this.j.j();
    paramBundle = RIJQQAppInterfaceUtil.a();
    if (paramBundle != null)
    {
      ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).initRes(paramBundle);
      ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).checkAdMaterialRefresh(paramBundle);
    }
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setChannelID(41697);
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoySuperMaskAd", "setSuperMaskChannelId 41697 notifyShowSelf ");
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setShowStatus(0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    DailyTipsFoldUtils.a();
    this.f = paramLayoutInflater.inflate(2131626210, paramViewGroup, false);
    ReadinjoySPEventReport.b(0, KandianDailyReportUtils.c(), 0);
    this.b = new ReadInJoyDailyViewController(getBaseActivity());
    this.b.a(DailyModeConfigHandler.j());
    paramLayoutInflater = (ViewGroup)this.f.findViewById(2131444326);
    this.b.a(paramLayoutInflater);
    this.b.cT_();
    this.c = new DailyDynamicHeaderViewController(this.b.n());
    this.c.a(this.l);
    this.c.a(this.f);
    b();
    VideoReport.addToDetectionWhitelist(getBaseActivity());
    VideoReport.setPageId(this.f, "14");
    VideoReport.setPageParams(this.f, new RIJDtParamBuilder().a(Integer.valueOf(DailyModeConfigHandler.j())).b());
    return this.f;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a.remove(String.valueOf(hashCode()));
    GifHelper.b();
    Object localObject = this.b;
    if (localObject != null) {
      ((ReadInJoyDailyViewController)localObject).e();
    }
    localObject = this.i;
    if (localObject != null) {
      ((RIJPopupAutomator)localObject).b();
    }
    ThreadManager.getFileThreadHandler().removeCallbacks(this.k);
    PreLoader.a().c();
    h();
  }
  
  public void onDestroyView()
  {
    this.c.a();
    ((IRIJAdExposeFreshService)QRoute.api(IRIJAdExposeFreshService.class)).exitScene("RIJAdRefreshSceneDaily");
    super.onDestroyView();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    getBaseActivity().setIntent(paramIntent);
    if (paramIntent != null) {
      this.e = paramIntent.getIntExtra("launch_from", 5);
    }
    a(paramIntent);
    paramIntent = this.b;
    if (paramIntent != null) {
      paramIntent.k();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    Object localObject = this.b;
    if (localObject != null) {
      ((ReadInJoyDailyViewController)localObject).h();
    }
    localObject = this.i;
    if (localObject != null) {
      ((RIJPopupAutomator)localObject).d();
    }
    ApngImage.pauseByTag(31);
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setChannelID(-1);
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoySuperMaskAd", "onPause: setSuperMaskChannelId = -1");
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = this.b;
    if (localObject != null) {
      ((ReadInJoyDailyViewController)localObject).i();
    }
    localObject = this.i;
    if (localObject != null) {
      ((RIJPopupAutomator)localObject).c();
    }
    RecommendFeedsDiandianEntranceManager.getInstance().checkAndReqRefreshDianDianIcon();
    ApngImage.playByTag(31);
    PublicAccountReportUtils.a(null, "", "0X8009940", "0X8009940", 0, 0, "", "", "", "", false);
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setChannelID(DailyModeConfigHandler.j());
    localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResume: setSuperMaskChannelId = ");
    localStringBuilder.append(DailyModeConfigHandler.j());
    ((IRIJAdLogService)localObject).d("ReadInJoySuperMaskAd", localStringBuilder.toString());
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    Object localObject = this.b;
    if (localObject != null) {
      ((ReadInJoyDailyViewController)localObject).f();
    }
    localObject = d;
    if (localObject != null) {
      ((TimeSliceHelper)localObject).b();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    Object localObject = this.b;
    if (localObject != null) {
      ((ReadInJoyDailyViewController)localObject).g();
    }
    if (!BaseActivity.mAppForground)
    {
      localObject = d;
      if (localObject != null) {
        ((TimeSliceHelper)localObject).c();
      }
    }
    if (getBaseActivity().isFinishing())
    {
      localObject = this.b;
      if (localObject != null) {
        ((ReadInJoyDailyViewController)localObject).c();
      }
      UserActionCollector.a().d();
      ReadinjoySPEventReport.b(1, KandianDailyReportUtils.c(), KandianDailyReportUtils.f());
      if (!this.h) {
        a(KandianDailyReportUtils.e());
      }
      KandianDailyReportUtils.b();
      com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.b = false;
      DailyModeConfigHandler.i();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      RIJPopupAutomator localRIJPopupAutomator = this.i;
      if (localRIJPopupAutomator != null) {
        localRIJPopupAutomator.g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyFragment
 * JD-Core Version:    0.7.0.1
 */