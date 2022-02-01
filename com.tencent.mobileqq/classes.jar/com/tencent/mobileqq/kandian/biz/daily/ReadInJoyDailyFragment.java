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
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
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
  private static TimeSliceHelper jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper = new TimeSliceHelper();
  public static List<String> a;
  private int jdField_a_of_type_Int = 5;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ReadInJoyDailyFragment.3(this);
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ReadInJoyDailyFragment.2(this);
  private View jdField_a_of_type_AndroidViewView;
  private RIJPopupAutomator jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator = new RIJPopupAutomator();
  private DailyDynamicHeaderViewController jdField_a_of_type_ComTencentMobileqqKandianBizDailyDailyDynamicHeaderViewController;
  private ReadInJoyDailyViewController jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailyViewController;
  private RIJDailyFloatingPopupStep jdField_a_of_type_ComTencentMobileqqKandianBizFeedspopupRIJDailyFloatingPopupStep;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyDailyFragment.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  private View b;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList(1);
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    KandianDailyReportUtils.a(paramIntent);
    if (b())
    {
      paramIntent = RIJQQAppInterfaceUtil.a();
      if (paramIntent != null)
      {
        KandianMergeManager localKandianMergeManager = (KandianMergeManager)paramIntent.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
        localKandianMergeManager.d();
        localKandianMergeManager.r();
        RIJKanDianFolderStatus.updateKandianFolderStatus(paramIntent);
      }
    }
  }
  
  private void a(String paramString)
  {
    String str;
    if (DailyModeConfigHandler.b(DailyModeConfigHandler.b())) {
      str = "0X80089D1";
    } else {
      str = "0X80098B0";
    }
    ThreadManager.executeOnSubThread(new ReadInJoyDailyFragment.4(this, paramString, str));
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_JavaUtilList.size() > 0;
  }
  
  public static void b()
  {
    TimeSliceHelper localTimeSliceHelper = jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper;
    if (localTimeSliceHelper != null)
    {
      localTimeSliceHelper.b();
      QLog.d("ReadInJoyDailyFragment", 2, "stopTimeCalculateWhenInBackground");
    }
  }
  
  private boolean b()
  {
    int i = this.jdField_a_of_type_Int;
    return (i == 6) || (i == 9);
  }
  
  public static void c()
  {
    TimeSliceHelper localTimeSliceHelper = jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper;
    if (localTimeSliceHelper != null)
    {
      localTimeSliceHelper.a();
      QLog.d("ReadInJoyDailyFragment", 2, "wakeUpTimeCalculateWhenInForeground");
    }
  }
  
  private void d()
  {
    if (RIJQQAppInterfaceUtil.a() == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedspopupRIJDailyFloatingPopupStep == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedspopupRIJDailyFloatingPopupStep = new RIJDailyFloatingPopupStep(this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator, getBaseActivity());
    }
    RIJPopupAutomator localRIJPopupAutomator = this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator;
    localRIJPopupAutomator.a(new BasePopupStep[] { new RIJLockScreenPopupStep(localRIJPopupAutomator, getBaseActivity()), new RIJDailyPopupStep(this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator, getBaseActivity()), new RIJMsgBoxPopupStep(this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator, getBaseActivity()), this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedspopupRIJDailyFloatingPopupStep, (BasePopupStep)((IRIJAdService)QRoute.api(IRIJAdService.class)).createSuperMaskPopupStep(this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator, getBaseActivity()), new RIJUGCAccountPopupStep(this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator, getBaseActivity()), new RIJSkinOperationPopupStep(this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator, getBaseActivity()) });
  }
  
  private void e()
  {
    if (getBaseActivity() != null)
    {
      IntentFilter localIntentFilter = new IntentFilter("float_layer_finsh_action");
      getBaseActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void f()
  {
    if (getBaseActivity() != null) {
      getBaseActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
  }
  
  private void g()
  {
    ThreadManager.executeOnSubThread(new ReadInJoyDailyFragment.5(this));
  }
  
  private void h()
  {
    jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.c();
    QLog.d("ReadInJoyDailyFragment", 2, "resetTime when create");
  }
  
  public void a()
  {
    View localView;
    if (ThemeUtil.isNowThemeIsNight(ReadInJoyUtils.a(), false, null))
    {
      if (this.b == null) {
        this.b = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131365371)).inflate();
      }
      localView = this.b;
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
    else
    {
      localView = this.b;
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
    ReadInJoyDailyViewController localReadInJoyDailyViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailyViewController;
    if (localReadInJoyDailyViewController != null) {
      localReadInJoyDailyViewController.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    if ((getBaseActivity() != null) && (getBaseActivity().getIntent() != null) && (getBaseActivity().getIntent().hasExtra("launch_from")))
    {
      int i = getBaseActivity().getIntent().getIntExtra("launch_from", 0);
      if ((i == 9) || (i == 6))
      {
        Intent localIntent = new Intent(getBaseActivity(), SplashActivity.class);
        localIntent.putExtra("fragment_id", 1);
        localIntent.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
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
    DailyModeConfigHandler.b();
    KandianDailyReportUtils.a(getBaseActivity().app);
    KandianDailyReportUtils.c();
    jdField_a_of_type_JavaUtilList.add(String.valueOf(hashCode()));
    UserActionCollector.a().a(UserActionCollector.d, 1);
    GifHelper.a();
    paramBundle = getBaseActivity();
    if (paramBundle != null)
    {
      localObject = paramBundle.getIntent();
      if (localObject != null) {
        this.jdField_a_of_type_Int = ((Intent)localObject).getIntExtra("launch_from", 5);
      }
      a((Intent)localObject);
    }
    ThreadManager.getFileThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 20000L);
    PreLoader.a().a();
    g();
    Object localObject = getArguments();
    int i;
    if (this.jdField_a_of_type_Int == 15)
    {
      com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.jdField_a_of_type_Boolean = true;
      QLog.d("ReadInJoyDailyFragment", 1, "from aio share");
      i = 1;
    }
    else
    {
      i = 0;
    }
    if ((localObject != null) && (paramBundle != null))
    {
      if (((Bundle)localObject).getBoolean("open_floating_window", false)) {
        i = 1;
      }
      if (i != 0)
      {
        QLog.d("ReadInJoyDailyFragment", 1, "openFloatingWindow is true");
        i = ((Bundle)localObject).getInt("floating_window_business");
        int j = ((Bundle)localObject).getInt("floating_window_scene");
        ReadInjoyFloatingWindowHelper.a(paramBundle, j, i, (Bundle)localObject, DailyModeConfigHandler.b());
        if ((j == 1) && ((i != 1) || (ReadInjoyFloatingWindowHelper.a((Bundle)localObject)))) {
          KandianDailyReportUtils.a(32);
        }
      }
    }
    e();
    RIJPushNotification.a();
    h();
    d();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedspopupRIJDailyFloatingPopupStep.i();
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
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560163, paramViewGroup, false);
    ReadinjoySPEventReport.b(0, KandianDailyReportUtils.a(), 0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailyViewController = new ReadInJoyDailyViewController(getBaseActivity());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailyViewController.a(DailyModeConfigHandler.b());
    paramLayoutInflater = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131376123);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailyViewController.a(paramLayoutInflater);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailyViewController.aw_();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyDailyDynamicHeaderViewController = new DailyDynamicHeaderViewController(this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailyViewController.a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyDailyDynamicHeaderViewController.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyDailyDynamicHeaderViewController.a(this.jdField_a_of_type_AndroidViewView);
    a();
    VideoReport.addToDetectionWhitelist(getBaseActivity());
    VideoReport.setPageId(this.jdField_a_of_type_AndroidViewView, "14");
    VideoReport.setPageParams(this.jdField_a_of_type_AndroidViewView, new RIJDtParamBuilder().a(Integer.valueOf(DailyModeConfigHandler.b())).a());
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    jdField_a_of_type_JavaUtilList.remove(String.valueOf(hashCode()));
    GifHelper.b();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailyViewController;
    if (localObject != null) {
      ((ReadInJoyDailyViewController)localObject).e();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator;
    if (localObject != null) {
      ((RIJPopupAutomator)localObject).b();
    }
    ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    PreLoader.a().b();
    f();
  }
  
  public void onDestroyView()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyDailyDynamicHeaderViewController.a();
    ((IRIJAdExposeFreshService)QRoute.api(IRIJAdExposeFreshService.class)).exitScene("RIJAdRefreshSceneDaily");
    super.onDestroyView();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    getBaseActivity().setIntent(paramIntent);
    if (paramIntent != null) {
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("launch_from", 5);
    }
    a(paramIntent);
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailyViewController;
    if (paramIntent != null) {
      paramIntent.j();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailyViewController;
    if (localObject != null) {
      ((ReadInJoyDailyViewController)localObject).h();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailyViewController;
    if (localObject != null) {
      ((ReadInJoyDailyViewController)localObject).i();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator;
    if (localObject != null) {
      ((RIJPopupAutomator)localObject).c();
    }
    RecommendFeedsDiandianEntranceManager.getInstance().checkAndReqRefreshDianDianIcon();
    ApngImage.playByTag(31);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009940", "0X8009940", 0, 0, "", "", "", "", false);
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setChannelID(DailyModeConfigHandler.b());
    localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResume: setSuperMaskChannelId = ");
    localStringBuilder.append(DailyModeConfigHandler.b());
    ((IRIJAdLogService)localObject).d("ReadInJoySuperMaskAd", localStringBuilder.toString());
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailyViewController;
    if (localObject != null) {
      ((ReadInJoyDailyViewController)localObject).f();
    }
    localObject = jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper;
    if (localObject != null) {
      ((TimeSliceHelper)localObject).a();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailyViewController;
    if (localObject != null) {
      ((ReadInJoyDailyViewController)localObject).g();
    }
    if (!BaseActivity.mAppForground)
    {
      localObject = jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper;
      if (localObject != null) {
        ((TimeSliceHelper)localObject).b();
      }
    }
    if (getBaseActivity().isFinishing())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailyViewController;
      if (localObject != null) {
        ((ReadInJoyDailyViewController)localObject).c();
      }
      UserActionCollector.a().c();
      ReadinjoySPEventReport.b(1, KandianDailyReportUtils.a(), KandianDailyReportUtils.b());
      if (!this.jdField_a_of_type_Boolean) {
        a(KandianDailyReportUtils.a());
      }
      KandianDailyReportUtils.b();
      com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.jdField_a_of_type_Boolean = false;
      DailyModeConfigHandler.c();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      RIJPopupAutomator localRIJPopupAutomator = this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator;
      if (localRIJPopupAutomator != null) {
        localRIJPopupAutomator.g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyFragment
 * JD-Core Version:    0.7.0.1
 */