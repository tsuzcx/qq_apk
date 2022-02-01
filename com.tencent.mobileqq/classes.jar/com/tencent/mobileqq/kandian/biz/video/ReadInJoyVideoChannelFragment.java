package com.tencent.mobileqq.kandian.biz.video;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdExposeFreshService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJPatchAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.entity.IHomeWatcher;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyChannelViewController;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController;
import com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabbar;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJStatisticCollectorReport;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.playfeeds.PlayFeedsSPUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.List;

public class ReadInJoyVideoChannelFragment
  extends ReadInJoyBaseFragment
{
  private int jdField_a_of_type_Int = -1;
  protected long a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private IHomeWatcher jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIHomeWatcher;
  protected ReadInJoyChannelViewController a;
  private long b;
  private long c;
  private boolean e = false;
  private boolean f;
  private boolean g = true;
  private boolean h = false;
  
  public ReadInJoyVideoChannelFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController = null;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIHomeWatcher = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createHomeWatcher(a());
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIHomeWatcher.a(new ReadInJoyVideoChannelFragment.2(this));
  }
  
  private void a(Activity paramActivity)
  {
    try
    {
      if ((!this.h) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController == null))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController = ((ReadInJoyChannelViewController)ReadInJoyUtils.a.remove(Integer.valueOf(56)));
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController = new ReadInJoyChannelViewController(paramActivity);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a(56);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.b(3);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.c(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a(this.jdField_a_of_type_AndroidViewViewGroup);
          i();
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.b(true);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.aw_();
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.c(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkCallHotwordChange, this.jdField_b_of_type_Int);
        paramActivity = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a();
        int i;
        if (this.jdField_a_of_type_Int == 1002)
        {
          int j = AIOUtils.b(44.5F, getResources());
          i = j;
          if (ImmersiveUtils.isSupporImmersive() == 1) {
            i = j + ImmersiveUtils.getStatusBarHeight(a());
          }
          paramActivity.setPadding(0, i, 0, 0);
        }
        else if (this.jdField_a_of_type_Int == 1003)
        {
          i = a();
          if (i > 0) {
            paramActivity.setPadding(0, i, 0, 0);
          }
        }
        this.h = true;
        return;
      }
      return;
    }
    finally {}
  }
  
  private void b(Activity paramActivity)
  {
    if (((!RIJShowKanDianTabSp.c()) || ((paramActivity instanceof ReadInJoyNewFeedsActivity))) && (!this.f) && (this.jdField_b_of_type_Long > 0L))
    {
      paramActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
      if (paramActivity != null) {
        paramActivity.d();
      }
    }
    if ((ReadInJoyHelper.l()) && (a().mainVideoTabRedHasRed()))
    {
      paramActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
      if ((paramActivity != null) && (this.jdField_a_of_type_Int == 1001))
      {
        paramActivity.a(true);
        ReadInJoyLogicEngineEventDispatcher.a().a(3, null);
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyShowSelf(): hasRed refresh ");
        return;
      }
    }
    if ((ReadInJoyHelper.l()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController != null) && ((a() instanceof SplashActivity)))
    {
      long l = System.currentTimeMillis() - ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), a());
      boolean bool = false;
      if ((l >= 900000L) && (!this.g))
      {
        paramActivity = new StringBuilder();
        paramActivity.append("videochannel tab auto refresh ! duration : ");
        paramActivity.append(l);
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, paramActivity.toString());
        bool = true;
      }
      else
      {
        this.g = false;
      }
      if (bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a(true);
        ReadInJoyLogicEngineEventDispatcher.a().a(3, null);
      }
      if (QLog.isColorLevel())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("notifyShowSelf(): isLastExitOver15Min : ");
        paramActivity.append(bool);
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, paramActivity.toString());
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Long != 0L)
    {
      ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
      if ((localReadInJoyChannelViewController != null) && (localReadInJoyChannelViewController.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a().size() > 0)) {
        RIJStatisticCollectorReport.a(56, (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a().a(), (AbsBaseArticleInfo)this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a().get(0), paramBoolean);
      }
    }
  }
  
  private void i()
  {
    if (this.e)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
      if (localObject != null)
      {
        ((ReadInJoyChannelViewController)localObject).a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", Long.valueOf(this.jdField_b_of_type_Long));
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", Long.valueOf(this.jdField_c_of_type_Long));
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", this.f);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("doRefreshAndForceInsert()：set intent args finish : ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a().getIntent().getExtras().toString());
          QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, ((StringBuilder)localObject).toString());
        }
        this.e = false;
      }
    }
  }
  
  private void j()
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if ((localReadInJoyChannelViewController != null) && (localReadInJoyChannelViewController.a() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
    }
  }
  
  public VideoPlayManager a()
  {
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null) {
      return localReadInJoyChannelViewController.a();
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null)
    {
      localReadInJoyChannelViewController.a(true);
      return;
    }
    ReadInJoyChannelViewPagerController.d(b());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSuperActivityResult(): requestCode = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", resultCode = ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localObject != null) {
      ((ReadInJoyChannelViewController)localObject).a(paramInt1, paramInt2, paramIntent);
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFragmentNewIntent():");
      String str;
      if (paramBundle == null) {
        str = " null";
      } else {
        str = paramBundle.toString();
      }
      localStringBuilder.append(str);
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, localStringBuilder.toString());
    }
    if ((paramBundle != null) && (paramBundle.getBoolean("key_need_refresh_channel_cover_list", false))) {
      ReadInJoyLogicEngine.a().a(56);
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyShowSelf()：isFirstCreate=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", ");
      if (paramBundle == null) {
        localObject = " null";
      } else {
        localObject = paramBundle.toString();
      }
      localStringBuilder.append((String)localObject);
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (!this.h)) {
      a(paramActivity);
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localObject != null) {
      ((ReadInJoyChannelViewController)localObject).n();
    }
    if (paramBundle != null)
    {
      this.jdField_b_of_type_Long = paramBundle.getLong("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID");
      this.jdField_c_of_type_Long = paramBundle.getLong("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ");
      this.f = paramBoolean;
      if (this.jdField_b_of_type_Long != 0L)
      {
        this.e = true;
        i();
      }
    }
    if ((RIJShowKanDianTabSp.c()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity)))
    {
      a().erasureTabRed(1);
    }
    else
    {
      paramBundle = ((ReadInJoyNewFeedsActivity)paramActivity).a();
      int i = paramBundle.b();
      if (i == 1) {
        paramBundle.b(i);
      }
    }
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (paramBundle != null) {
      paramBundle.i();
    }
    b(paramActivity);
    paramActivity = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIHomeWatcher;
    if (paramActivity != null) {
      paramActivity.a();
    }
  }
  
  public void az_()
  {
    super.az_();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyTabDoubleClick()");
    }
  }
  
  public int b()
  {
    return 56;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyTitleClick()");
    }
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.a(true);
    }
    ThreadManager.executeOnSubThread(new ReadInJoyVideoChannelFragment.1(this));
  }
  
  public boolean d()
  {
    b(true);
    b();
    return true;
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyHideSelf()");
    }
    this.jdField_b_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localObject != null) {
      ((ReadInJoyChannelViewController)localObject).j();
    }
    j();
    b(false);
    this.jdField_a_of_type_Long = 0L;
    if ((ReadInJoyHelper.l()) && ((a() instanceof SplashActivity))) {
      ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), System.currentTimeMillis(), a());
    }
    VideoVolumeControl.getInstance().requestOrAbandonAudioFocus(false, "videoFeeds tab hiseSelf");
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIHomeWatcher;
    if (localObject != null) {
      ((IHomeWatcher)localObject).b();
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyClickSelf()");
    }
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.a(true);
    }
  }
  
  public void g()
  {
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.k();
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onActivityCreated()");
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityResult(): requestCode = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", resultCode = ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localObject != null) {
      ((ReadInJoyChannelViewController)localObject).a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onAttach()");
    }
    try
    {
      ((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).preRequestPatchAd();
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("preRequestPatchAd error:");
        localStringBuilder.append(paramActivity.getMessage());
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, localStringBuilder.toString());
      }
    }
    a();
  }
  
  public boolean onBackEvent()
  {
    b(false);
    b();
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onCreate()");
    }
    if (!this.jdField_c_of_type_Boolean) {
      VideoVolumeControl.getInstance().inKandianModule(a());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onCreateView()");
    }
    this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(paramLayoutInflater.getContext());
    if ((getUserVisibleHint()) || (!ReadInJoyUtils.a())) {
      a(a());
    }
    VideoReport.setPageId(this.jdField_a_of_type_AndroidViewViewGroup, "14");
    VideoReport.setPageParams(this.jdField_a_of_type_AndroidViewViewGroup, new RIJDtParamBuilder().a(Integer.valueOf(56)).a());
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void onDestroy()
  {
    try
    {
      super.onDestroy();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onDestroy()");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.e();
      }
      j();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onDestroyView()");
    }
    if (!this.jdField_c_of_type_Boolean) {
      VideoVolumeControl.getInstance().outKandianModule(a());
    }
    ((IRIJAdExposeFreshService)QRoute.api(IRIJAdExposeFreshService.class)).exitScene("RIJAdRefreshSceneVideoTab");
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onDetach()");
    }
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onPause()");
    }
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
      if (localObject != null) {
        ((ReadInJoyChannelViewController)localObject).h();
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIHomeWatcher;
    if (localObject != null) {
      ((IHomeWatcher)localObject).b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onResume()");
    }
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
      if (localObject != null)
      {
        ((ReadInJoyChannelViewController)localObject).i();
        VideoVolumeControl.getInstance().resumeInKandianModule();
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIHomeWatcher;
    if ((localObject != null) && (!((IHomeWatcher)localObject).a())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIHomeWatcher.a();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onStart()");
    }
    PlayFeedsSPUtils.a(RIJQQAppInterfaceUtil.a());
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.f();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onStop()");
    }
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.g();
    }
    VideoVolumeControl.getInstance().requestOrAbandonAudioFocus(false, "videoChannelFragment tab onStop");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.ReadInJoyVideoChannelFragment
 * JD-Core Version:    0.7.0.1
 */