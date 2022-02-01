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
  protected ReadInJoyChannelViewController a = null;
  protected long b = 0L;
  private boolean c = false;
  private long d;
  private long m;
  private boolean n;
  private int o = -1;
  private boolean p = true;
  private boolean q = false;
  private ViewGroup r;
  private IHomeWatcher s;
  
  private void a(Activity paramActivity)
  {
    try
    {
      if ((!this.q) && (this.a == null))
      {
        this.a = ((ReadInJoyChannelViewController)ReadInJoyUtils.c.remove(Integer.valueOf(56)));
        if (this.a == null)
        {
          this.a = new ReadInJoyChannelViewController(paramActivity);
          this.a.a(56);
          this.a.b(3);
          this.a.c(this.o);
          this.a.a(this.r);
          x();
          this.a.b(true);
          this.a.cT_();
        }
        this.a.c(this.o);
        this.a.a(this.j, this.k);
        paramActivity = (ViewGroup)this.a.q();
        int i;
        if (this.o == 1002)
        {
          int j = AIOUtils.b(44.5F, getResources());
          i = j;
          if (ImmersiveUtils.isSupporImmersive() == 1) {
            i = j + ImmersiveUtils.getStatusBarHeight(v());
          }
          paramActivity.setPadding(0, i, 0, 0);
        }
        else if (this.o == 1003)
        {
          i = b();
          if (i > 0) {
            paramActivity.setPadding(0, i, 0, 0);
          }
        }
        this.q = true;
        return;
      }
      return;
    }
    finally {}
  }
  
  private void b(Activity paramActivity)
  {
    if (((!RIJShowKanDianTabSp.c()) || ((paramActivity instanceof ReadInJoyNewFeedsActivity))) && (!this.n) && (this.d > 0L))
    {
      paramActivity = this.a;
      if (paramActivity != null) {
        paramActivity.k();
      }
    }
    if ((ReadInJoyHelper.v()) && (u().mainVideoTabRedHasRed()))
    {
      paramActivity = this.a;
      if ((paramActivity != null) && (this.o == 1001))
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
    if ((ReadInJoyHelper.v()) && (this.a != null) && ((v() instanceof SplashActivity)))
    {
      long l = System.currentTimeMillis() - ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.b(), v());
      boolean bool = false;
      if ((l >= 900000L) && (!this.p))
      {
        paramActivity = new StringBuilder();
        paramActivity.append("videochannel tab auto refresh ! duration : ");
        paramActivity.append(l);
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, paramActivity.toString());
        bool = true;
      }
      else
      {
        this.p = false;
      }
      if (bool)
      {
        this.a.a(true);
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
    if (this.b != 0L)
    {
      ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
      if ((localReadInJoyChannelViewController != null) && (localReadInJoyChannelViewController.j() != null) && (this.a.u() != null) && (this.a.u().size() > 0)) {
        RIJStatisticCollectorReport.a(56, (System.currentTimeMillis() - this.b) / 1000L, this.a.j().a(), (AbsBaseArticleInfo)this.a.u().get(0), paramBoolean);
      }
    }
  }
  
  private void w()
  {
    this.s = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createHomeWatcher(v());
    this.s.a(new ReadInJoyVideoChannelFragment.2(this));
  }
  
  private void x()
  {
    if (this.c)
    {
      Object localObject = this.a;
      if (localObject != null)
      {
        ((ReadInJoyChannelViewController)localObject).cQ_().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", Long.valueOf(this.d));
        this.a.cQ_().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", Long.valueOf(this.m));
        this.a.cQ_().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", this.n);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("doRefreshAndForceInsert()：set intent args finish : ");
          ((StringBuilder)localObject).append(this.a.cQ_().getIntent().getExtras().toString());
          QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, ((StringBuilder)localObject).toString());
        }
        this.c = false;
      }
    }
  }
  
  private void y()
  {
    this.d = 0L;
    this.m = 0L;
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
    if ((localReadInJoyChannelViewController != null) && (localReadInJoyChannelViewController.cQ_() != null))
    {
      this.a.cQ_().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      this.a.cQ_().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
      this.a.cQ_().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
    }
  }
  
  public VideoPlayManager a()
  {
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
    if (localReadInJoyChannelViewController != null) {
      return localReadInJoyChannelViewController.j();
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
    if (localReadInJoyChannelViewController != null)
    {
      localReadInJoyChannelViewController.a(true);
      return;
    }
    ReadInJoyChannelViewPagerController.d(d());
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
    Object localObject = this.a;
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
    if ((this.r != null) && (!this.q)) {
      a(paramActivity);
    }
    this.b = System.currentTimeMillis();
    this.g = true;
    Object localObject = this.a;
    if (localObject != null) {
      ((ReadInJoyChannelViewController)localObject).p();
    }
    if (paramBundle != null)
    {
      this.d = paramBundle.getLong("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID");
      this.m = paramBundle.getLong("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ");
      this.n = paramBoolean;
      if (this.d != 0L)
      {
        this.c = true;
        x();
      }
    }
    if ((RIJShowKanDianTabSp.c()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity)))
    {
      u().erasureTabRed(1);
    }
    else
    {
      paramBundle = ((ReadInJoyNewFeedsActivity)paramActivity).n();
      int i = paramBundle.getShowingPopupTipsTapPosi();
      if (i == 1) {
        paramBundle.d(i);
      }
    }
    paramBundle = this.a;
    if (paramBundle != null) {
      paramBundle.i();
    }
    b(paramActivity);
    paramActivity = this.s;
    if (paramActivity != null) {
      paramActivity.b();
    }
  }
  
  public int d()
  {
    return 56;
  }
  
  public void d(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void g()
  {
    super.g();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyTabDoubleClick()");
    }
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyTitleClick()");
    }
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.a(true);
    }
    ThreadManager.executeOnSubThread(new ReadInJoyVideoChannelFragment.1(this));
  }
  
  public void k()
  {
    super.k();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyHideSelf()");
    }
    this.g = false;
    Object localObject = this.a;
    if (localObject != null) {
      ((ReadInJoyChannelViewController)localObject).n();
    }
    y();
    b(false);
    this.b = 0L;
    if ((ReadInJoyHelper.v()) && ((v() instanceof SplashActivity))) {
      ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.b(), System.currentTimeMillis(), v());
    }
    VideoVolumeControl.getInstance().requestOrAbandonAudioFocus(false, "videoFeeds tab hiseSelf");
    localObject = this.s;
    if (localObject != null) {
      ((IHomeWatcher)localObject).c();
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyClickSelf()");
    }
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.a(true);
    }
  }
  
  public void n()
  {
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.cR_();
    }
  }
  
  public boolean o()
  {
    b(true);
    f();
    return true;
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
    Object localObject = this.a;
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
    w();
  }
  
  public boolean onBackEvent()
  {
    b(false);
    f();
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onCreate()");
    }
    if (!this.h) {
      VideoVolumeControl.getInstance().inKandianModule(v());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onCreateView()");
    }
    this.r = new FrameLayout(paramLayoutInflater.getContext());
    if ((getUserVisibleHint()) || (!ReadInJoyUtils.g())) {
      a(v());
    }
    VideoReport.setPageId(this.r, "14");
    VideoReport.setPageParams(this.r, new RIJDtParamBuilder().a(Integer.valueOf(56)).b());
    return this.r;
  }
  
  public void onDestroy()
  {
    try
    {
      super.onDestroy();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onDestroy()");
      }
      if (this.a != null) {
        this.a.e();
      }
      y();
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
    if (!this.h) {
      VideoVolumeControl.getInstance().outKandianModule(v());
    }
    ((IRIJAdExposeFreshService)QRoute.api(IRIJAdExposeFreshService.class)).exitScene("RIJAdRefreshSceneVideoTab");
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onDetach()");
    }
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
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
    if (this.g)
    {
      localObject = this.a;
      if (localObject != null) {
        ((ReadInJoyChannelViewController)localObject).h();
      }
    }
    Object localObject = this.s;
    if (localObject != null) {
      ((IHomeWatcher)localObject).c();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onResume()");
    }
    if (this.g)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((ReadInJoyChannelViewController)localObject).i();
        VideoVolumeControl.getInstance().resumeInKandianModule();
      }
    }
    Object localObject = this.s;
    if ((localObject != null) && (!((IHomeWatcher)localObject).a())) {
      this.s.b();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onStart()");
    }
    PlayFeedsSPUtils.a(RIJQQAppInterfaceUtil.e());
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
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
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.g();
    }
    VideoVolumeControl.getInstance().requestOrAbandonAudioFocus(false, "videoChannelFragment tab onStop");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.ReadInJoyVideoChannelFragment
 * JD-Core Version:    0.7.0.1
 */