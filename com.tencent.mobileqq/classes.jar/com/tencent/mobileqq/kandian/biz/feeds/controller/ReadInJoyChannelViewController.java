package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListViewGroup;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyChannelActivity;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.feeds.api.CountDownCallback;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.handlers.FrameworkHandler;
import com.tencent.mobileqq.kandian.biz.framework.handlers.RIJInvokeHandler;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskVideoTimer;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager.OnRefreshChangedListener;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager.OnSkinChangedListener;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyVideoChannelFragment;
import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.biz.video.VideoUIManager;
import com.tencent.mobileqq.kandian.biz.video.VideoUIManager.OnScreenChangeListener;
import com.tencent.mobileqq.kandian.biz.video.api.OnPlayStateListener;
import com.tencent.mobileqq.kandian.biz.video.api.OnUIChangeListener;
import com.tencent.mobileqq.kandian.biz.video.api.impl.VideoFeedsWeiShiUtils;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.BaseVideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.video.VideoFullPlayController.OnFullPlayListener;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.VideoRecommendManager;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadInJoyChannelViewController
  extends ReadInJoyBaseViewController
  implements View.OnClickListener, View.OnKeyListener, CountDownCallback, ReadInJoyRefreshManager.OnRefreshChangedListener, ReadInJoySkinManager.OnSkinChangedListener, VideoUIManager.OnScreenChangeListener, OnPlayStateListener, OnUIChangeListener, VideoFullPlayController.OnFullPlayListener
{
  private static boolean jdField_a_of_type_Boolean = true;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
  ReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
  private RIJRewardTaskVideoTimer jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskVideoTimer;
  private VideoUIManager jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager;
  private VideoPlayManager jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
  private VideoRecommendManager jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoRecommendManager;
  protected ReadInJoyObserver a;
  private int jdField_b_of_type_Int = -1;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = false;
  private int d = -1;
  
  public ReadInJoyChannelViewController(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyChannelViewController.ReadInJoyChannelObserver(this, null);
  }
  
  private boolean a()
  {
    return b() == 40677;
  }
  
  private boolean a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if ((localObject != null) && (((VideoPlayManager)localObject).a()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager;
      if ((localObject != null) && (!((VideoUIManager)localObject).a()))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager.c(paramInt);
        return true;
      }
    }
    return false;
  }
  
  private int b()
  {
    int i = this.jdField_b_of_type_Int;
    if (i != -1) {
      return i;
    }
    return this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("channel_id", 0);
  }
  
  private boolean b()
  {
    return b() == 56;
  }
  
  private int c()
  {
    int i = this.jdField_c_of_type_Int;
    if (i != -1) {
      return i;
    }
    return this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("channel_type", 0);
  }
  
  public int a()
  {
    int i = this.d;
    if (i != -1) {
      return i;
    }
    if (a().getIntent() != null) {
      return a().getIntent().getIntExtra("channel_from", -1);
    }
    return -1;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public VideoPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
  }
  
  public VideoRecommendManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoRecommendManager;
  }
  
  public List<AbsBaseArticleInfo> a()
  {
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
    if (localReadInJoyBaseAdapter == null) {
      return null;
    }
    return localReadInJoyBaseAdapter.b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if ((paramString instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)paramString).setRefreshHeader(paramInt);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a(BaseVideoPlayParam paramBaseVideoPlayParam1, BaseVideoPlayParam paramBaseVideoPlayParam2, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onNextVideoPlay:  enterVideoPlayParam:");
      ((StringBuilder)localObject).append(paramBaseVideoPlayParam1);
      ((StringBuilder)localObject).append("  nextVideoPlayParam:");
      ((StringBuilder)localObject).append(paramBaseVideoPlayParam2);
      ((StringBuilder)localObject).append("\n nextScrollByDistance:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" isPlayFirstNext:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("ReadInJoyBaseAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramBaseVideoPlayParam1 != null) && ((paramBaseVideoPlayParam1 instanceof VideoPlayParam)) && (paramBaseVideoPlayParam2 != null) && ((paramBaseVideoPlayParam2 instanceof VideoPlayParam)))
    {
      paramBaseVideoPlayParam1 = ((VideoPlayParam)paramBaseVideoPlayParam1).a;
      paramBaseVideoPlayParam2 = (VideoPlayParam)paramBaseVideoPlayParam2;
      localObject = paramBaseVideoPlayParam2.a;
      if ((paramBaseVideoPlayParam1 != null) && (localObject != null)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(paramBaseVideoPlayParam1, (AbsBaseArticleInfo)localObject, paramBoolean ^ true);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager.a()) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(paramBaseVideoPlayParam2, 1);
      }
    }
  }
  
  public void a(VideoPlayParam paramVideoPlayParam)
  {
    if (VideoAutoPlayController.sPauseScrollToNextVideo) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(paramVideoPlayParam);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2) {}
  
  public void a(VideoPlayParam paramVideoPlayParam, IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void a(VideoPlayParam paramVideoPlayParam1, VideoPlayParam paramVideoPlayParam2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(paramVideoPlayParam1, paramVideoPlayParam2);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.a(paramBoolean);
    super.a(paramBoolean, paramInt);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if ((localObject instanceof ReadInJoyListViewGroup))
    {
      localObject = (ReadInJoyListViewGroup)localObject;
      if (!paramBoolean1) {
        ((ReadInJoyListViewGroup)localObject).p();
      }
      if (!paramBoolean2) {
        ((ReadInJoyListViewGroup)localObject).q();
      }
    }
  }
  
  public void aw_()
  {
    super.aw_();
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoRecommendManager = new VideoRecommendManager(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager = new VideoPlayManager(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoRecommendManager);
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(b()), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup = new ReadInJoyListViewGroup(this, b(), c(), this.d, null);
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup).setNotifyEndRefresh(new ReadInJoyChannelViewController.1(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup).a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
    if (localObject != null) {
      ((ReadInJoyBaseAdapter)localObject).d();
    }
    if ((!(this.jdField_a_of_type_AndroidAppActivity instanceof ReadInJoyNewFeedsActivity)) && (!(this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)))
    {
      String str = (String)VideoReporter.a.get(ReadInJoyChannelActivity.class);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = VideoReporter.b();
      }
    }
    else
    {
      localObject = VideoReporter.b();
      VideoReporter.a.put(ReadInJoyVideoChannelFragment.class, localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a((String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoRecommendManager.a((String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager = new VideoUIManager((FrameLayout)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.findViewById(2131380736), (ReadInJoyBaseListView)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.findViewById(2131378123), this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(this);
    if (b())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.setFocusableInTouchMode(true);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.requestFocus();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.setOnKeyListener(this);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      ReadInJoyLogicEngine.a().c();
    }
    b();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskVideoTimer = new RIJRewardTaskVideoTimer();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskVideoTimer.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager);
  }
  
  public void ay_()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager.j();
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    super.b();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if (localObject != null)
    {
      ((ReadInJoyBaseListViewGroup)localObject).a(a(Integer.valueOf(b())), b(Integer.valueOf(b())));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.b(this.jdField_b_of_type_JavaUtilMap);
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localObject = new ViewGroup.LayoutParams(-1, -1);
        this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup, (ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    super.c();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if (localObject != null)
    {
      ((ReadInJoyBaseListViewGroup)localObject).a(b(Integer.valueOf(b())), a(Integer.valueOf(b())));
      localObject = this.jdField_a_of_type_AndroidViewViewGroup;
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup);
      }
    }
  }
  
  public void c(int paramInt)
  {
    this.d = paramInt;
    if (a().getIntent() != null) {
      a().getIntent().putExtra("channel_from", paramInt);
    }
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
    if (localReadInJoyBaseAdapter != null) {
      localReadInJoyBaseAdapter.c(paramInt);
    }
  }
  
  public void d()
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if ((localReadInJoyBaseListViewGroup != null) && ((localReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)localReadInJoyBaseListViewGroup).a(null, 1);
    }
  }
  
  public void e()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.a(b(Integer.valueOf(b())), a(Integer.valueOf(b())));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.a(this.jdField_b_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.f();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.c();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if (localObject != null)
    {
      ((VideoPlayManager)localObject).b(this);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager;
    if (localObject != null) {
      ((VideoUIManager)localObject).c(null);
    }
  }
  
  public void f()
  {
    super.f();
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
    if (localReadInJoyBaseAdapter != null) {
      localReadInJoyBaseAdapter.notifyDataSetChanged();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.d();
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.e();
  }
  
  public void h()
  {
    super.h();
    RIJRewardTaskVideoTimer localRIJRewardTaskVideoTimer = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskVideoTimer;
    if (localRIJRewardTaskVideoTimer != null) {
      localRIJRewardTaskVideoTimer.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.e();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.c();
  }
  
  public void i()
  {
    super.i();
    RIJRewardTaskVideoTimer localRIJRewardTaskVideoTimer = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskVideoTimer;
    if (localRIJRewardTaskVideoTimer != null) {
      localRIJRewardTaskVideoTimer.a();
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.d(b());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.b();
  }
  
  public void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskVideoTimer;
    if (localObject != null) {
      ((RIJRewardTaskVideoTimer)localObject).b();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(ReportConstants.VideoEndType.EXIT_SCENE);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.e();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.c();
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager;
    if ((localObject != null) && (((VideoUIManager)localObject).a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager.a().c();
    }
  }
  
  public void k()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if ((localObject != null) && ((localObject instanceof ReadInJoyListViewGroup)))
    {
      localObject = a(Integer.valueOf(b()));
      Map localMap = ReadinjoyReportUtils.a(b());
      ThreadManager.executeOnSubThread(new ReadInJoyChannelViewController.2(this, (Map)localObject, a(Integer.valueOf(b())), localMap, RIJKanDianFolderStatus.getFolderStatus(b())));
      b(Integer.valueOf(b())).clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
      localObject = (FrameworkHandler)((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup).a().a(2);
      if (localObject != null) {
        ((FrameworkHandler)localObject).i();
      }
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.k();
  }
  
  public void n()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskVideoTimer;
    if (localObject != null) {
      ((RIJRewardTaskVideoTimer)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager;
    if ((localObject != null) && (((VideoUIManager)localObject).a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager.a().b();
    }
  }
  
  public void o()
  {
    if (WeishiGuideUtils.a(a()))
    {
      VideoFeedsWeiShiUtils.a(a(), "video_type_videopublic");
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009338", "0X8009338", 0, 0, "", "", "", VideoReporter.a("0"), false);
      return;
    }
    QQToast.a(a(), -1, HardCodeUtil.a(2131713010), 0).b(a().getResources().getDimensionPixelSize(2131299168));
    VideoFeedsWeiShiUtils.b(a(), "video_type_videopublic");
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009338", "0X8009338", 0, 0, "", "", "", VideoReporter.a("1"), false);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131369216) {
      return;
    }
    if (a())
    {
      paramView = new ActivityURIRequest(this.jdField_a_of_type_AndroidViewViewGroup.getContext(), "/pubaccount/detail");
      paramView.extra().putString("uin", String.valueOf(2062433139L));
      paramView.extra().putInt("uintype", 1008);
      paramView.extra().putInt("source", 119);
      QRoute.startUri(paramView, null);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800932E", "0X800932E", 0, 0, "", "", "", VideoReporter.a(null), false);
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((b()) && (paramKeyEvent.getAction() == 0))
    {
      if (paramInt == 25) {
        return a(-1);
      }
      if (paramInt == 24) {
        return a(1);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyChannelViewController
 * JD-Core Version:    0.7.0.1
 */