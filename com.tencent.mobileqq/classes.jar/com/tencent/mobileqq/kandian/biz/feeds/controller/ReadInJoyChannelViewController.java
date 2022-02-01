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
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
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
  private static boolean j = true;
  ReadInJoyBaseAdapter a;
  protected ReadInJoyObserver i = new ReadInJoyChannelViewController.ReadInJoyChannelObserver(this, null);
  private ViewGroup k;
  private ReadInJoyBaseListViewGroup l;
  private VideoRecommendManager m;
  private VideoPlayManager n;
  private VideoUIManager o;
  private int p = -1;
  private int q = -1;
  private volatile boolean r = false;
  private int s = -1;
  private RIJRewardTaskVideoTimer t;
  private boolean u = false;
  
  public ReadInJoyChannelViewController(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private boolean d(int paramInt)
  {
    Object localObject = this.n;
    if ((localObject != null) && (((VideoPlayManager)localObject).g()))
    {
      localObject = this.o;
      if ((localObject != null) && (!((VideoUIManager)localObject).c()))
      {
        this.o.c(paramInt);
        return true;
      }
    }
    return false;
  }
  
  private int v()
  {
    int i1 = this.p;
    if (i1 != -1) {
      return i1;
    }
    return this.b.getIntent().getIntExtra("channel_id", 0);
  }
  
  private int w()
  {
    int i1 = this.q;
    if (i1 != -1) {
      return i1;
    }
    return this.b.getIntent().getIntExtra("channel_type", 0);
  }
  
  private boolean x()
  {
    return v() == 40677;
  }
  
  private boolean y()
  {
    return v() == 56;
  }
  
  public void a(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.l.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    paramString = this.l;
    if ((paramString instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)paramString).setRefreshHeader(paramInt);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    this.k = paramViewGroup;
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
      paramBaseVideoPlayParam1 = ((VideoPlayParam)paramBaseVideoPlayParam1).D;
      paramBaseVideoPlayParam2 = (VideoPlayParam)paramBaseVideoPlayParam2;
      localObject = paramBaseVideoPlayParam2.D;
      if ((paramBaseVideoPlayParam1 != null) && (localObject != null)) {
        this.a.a(paramBaseVideoPlayParam1, (AbsBaseArticleInfo)localObject, paramBoolean ^ true);
      }
      if (!this.o.c()) {
        this.a.a(paramBaseVideoPlayParam2, 1);
      }
    }
  }
  
  public void a(VideoPlayParam paramVideoPlayParam)
  {
    if (VideoAutoPlayController.sPauseScrollToNextVideo) {
      return;
    }
    this.a.a(paramVideoPlayParam);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2) {}
  
  public void a(VideoPlayParam paramVideoPlayParam, IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void a(VideoPlayParam paramVideoPlayParam1, VideoPlayParam paramVideoPlayParam2)
  {
    this.a.a(paramVideoPlayParam1, paramVideoPlayParam2);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.l.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.l.a(paramBoolean);
    super.a(paramBoolean, paramInt);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = this.l;
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
  
  public void b()
  {
    if (this.r) {
      return;
    }
    this.r = true;
    super.b();
    Object localObject = this.l;
    if (localObject != null)
    {
      ((ReadInJoyBaseListViewGroup)localObject).a(c(Integer.valueOf(v())), d(Integer.valueOf(v())));
      this.l.b(this.d);
      if (this.k != null)
      {
        localObject = new ViewGroup.LayoutParams(-1, -1);
        this.k.addView(this.l, (ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public void c()
  {
    if (!this.r) {
      return;
    }
    this.r = false;
    super.c();
    Object localObject = this.l;
    if (localObject != null)
    {
      ((ReadInJoyBaseListViewGroup)localObject).a(d(Integer.valueOf(v())), b(Integer.valueOf(v())));
      localObject = this.k;
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(this.l);
      }
    }
  }
  
  public void c(int paramInt)
  {
    this.s = paramInt;
    if (cQ_().getIntent() != null) {
      cQ_().getIntent().putExtra("channel_from", paramInt);
    }
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.a;
    if (localReadInJoyBaseAdapter != null) {
      localReadInJoyBaseAdapter.c(paramInt);
    }
  }
  
  public void cR_()
  {
    Object localObject = this.l;
    if ((localObject != null) && ((localObject instanceof ReadInJoyListViewGroup)))
    {
      localObject = a(Integer.valueOf(v()));
      Map localMap = ReadinjoyReportUtils.a(v());
      ThreadManager.executeOnSubThread(new ReadInJoyChannelViewController.2(this, (Map)localObject, b(Integer.valueOf(v())), localMap, RIJKanDianFolderStatus.getFolderStatus(v())));
      d(Integer.valueOf(v())).clear();
      this.c.clear();
      localObject = (FrameworkHandler)((ReadInJoyListViewGroup)this.l).getInvokeHandler().a(2);
      if (localObject != null) {
        ((FrameworkHandler)localObject).x();
      }
    }
  }
  
  public void cT_()
  {
    super.cT_();
    this.m = new VideoRecommendManager(this.b);
    this.n = new VideoPlayManager(this.b);
    this.n.a(this.m);
    this.d.put(Integer.valueOf(v()), Boolean.valueOf(true));
    this.l = new ReadInJoyListViewGroup(this, v(), w(), this.s, null);
    ((ReadInJoyListViewGroup)this.l).setNotifyEndRefresh(new ReadInJoyChannelViewController.1(this));
    this.a = ((ReadInJoyListViewGroup)this.l).getAdapter();
    Object localObject = this.a;
    if (localObject != null) {
      ((ReadInJoyBaseAdapter)localObject).K();
    }
    if ((!(this.b instanceof ReadInJoyNewFeedsActivity)) && (!(this.b instanceof SplashActivity)))
    {
      String str = (String)VideoReporter.c.get(ReadInJoyChannelActivity.class);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = VideoReporter.b();
      }
    }
    else
    {
      localObject = VideoReporter.b();
      VideoReporter.c.put(ReadInJoyVideoChannelFragment.class, localObject);
    }
    this.n.c((String)localObject);
    this.m.a((String)localObject);
    this.o = new VideoUIManager((FrameLayout)this.l.findViewById(2131449704), (ReadInJoyBaseListView)this.l.findViewById(2131446630), this.b);
    this.o.a(this);
    this.n.a(this.o);
    this.o.a(this);
    this.o.a(this);
    this.o.a(this);
    this.n.a(this);
    if (y())
    {
      this.l.setFocusableInTouchMode(true);
      this.l.requestFocus();
      this.l.setOnKeyListener(this);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.i);
    if (j)
    {
      j = false;
      ReadInJoyLogicEngine.a().w();
    }
    b();
    this.t = new RIJRewardTaskVideoTimer();
    this.t.a(this.n);
  }
  
  public void cV_()
  {
    this.o.p();
  }
  
  public void cW_()
  {
    this.a.V();
  }
  
  public void e()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.i);
    super.e();
    this.l.a(d(Integer.valueOf(v())), b(Integer.valueOf(v())));
    this.l.a(this.d);
    this.l.f();
    this.a.I();
    this.c.clear();
    this.e.clear();
    this.d.clear();
    Object localObject = this.n;
    if (localObject != null)
    {
      ((VideoPlayManager)localObject).b(this);
      this.n.w();
    }
    localObject = this.o;
    if (localObject != null) {
      ((VideoUIManager)localObject).c(null);
    }
  }
  
  public void f()
  {
    super.f();
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.a;
    if (localReadInJoyBaseAdapter != null) {
      localReadInJoyBaseAdapter.notifyDataSetChanged();
    }
    this.l.d();
  }
  
  public void g()
  {
    super.g();
    this.l.e();
  }
  
  public void h()
  {
    super.h();
    RIJRewardTaskVideoTimer localRIJRewardTaskVideoTimer = this.t;
    if (localRIJRewardTaskVideoTimer != null) {
      localRIJRewardTaskVideoTimer.b();
    }
    this.n.z();
    this.l.c();
  }
  
  public void i()
  {
    super.i();
    RIJRewardTaskVideoTimer localRIJRewardTaskVideoTimer = this.t;
    if (localRIJRewardTaskVideoTimer != null) {
      localRIJRewardTaskVideoTimer.a();
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.i);
    this.n.d(v());
    this.l.b();
  }
  
  public VideoPlayManager j()
  {
    return this.n;
  }
  
  public void k()
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = this.l;
    if ((localReadInJoyBaseListViewGroup != null) && ((localReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)localReadInJoyBaseListViewGroup).a(null, 1);
    }
  }
  
  public ViewGroup l()
  {
    return this.k;
  }
  
  public int m()
  {
    int i1 = this.s;
    if (i1 != -1) {
      return i1;
    }
    if (cQ_().getIntent() != null) {
      return cQ_().getIntent().getIntExtra("channel_from", -1);
    }
    return -1;
  }
  
  public void n()
  {
    Object localObject = this.t;
    if (localObject != null) {
      ((RIJRewardTaskVideoTimer)localObject).b();
    }
    this.n.a(ReportConstants.VideoEndType.EXIT_SCENE);
    this.n.z();
    this.l.c();
    localObject = this.o;
    if ((localObject != null) && (((VideoUIManager)localObject).w() != null)) {
      this.o.w().c();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131436194) {
      return;
    }
    if (x())
    {
      paramView = new ActivityURIRequest(this.k.getContext(), "/pubaccount/detail");
      paramView.extra().putString("uin", String.valueOf(2062433139L));
      paramView.extra().putInt("uintype", 1008);
      paramView.extra().putInt("source", 119);
      QRoute.startUri(paramView, null);
      PublicAccountReportUtils.a(null, null, "0X800932E", "0X800932E", 0, 0, "", "", "", VideoReporter.b(null), false);
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((y()) && (paramKeyEvent.getAction() == 0))
    {
      if (paramInt == 25) {
        return d(-1);
      }
      if (paramInt == 24) {
        return d(1);
      }
    }
    return false;
  }
  
  public void p()
  {
    Object localObject = this.t;
    if (localObject != null) {
      ((RIJRewardTaskVideoTimer)localObject).a();
    }
    localObject = this.o;
    if ((localObject != null) && (((VideoUIManager)localObject).w() != null)) {
      this.o.w().b();
    }
  }
  
  public View q()
  {
    return this.l;
  }
  
  public void r()
  {
    if (WeishiGuideUtils.a(cQ_()))
    {
      VideoFeedsWeiShiUtils.a(cQ_(), "video_type_videopublic");
      PublicAccountReportUtils.a(null, "", "0X8009338", "0X8009338", 0, 0, "", "", "", VideoReporter.a("0"), false);
      return;
    }
    QQToast.makeText(cQ_(), -1, HardCodeUtil.a(2131910574), 0).show(cQ_().getResources().getDimensionPixelSize(2131299920));
    VideoFeedsWeiShiUtils.b(cQ_(), "video_type_videopublic");
    PublicAccountReportUtils.a(null, "", "0X8009338", "0X8009338", 0, 0, "", "", "", VideoReporter.a("1"), false);
  }
  
  public VideoRecommendManager s()
  {
    return this.m;
  }
  
  public List<AbsBaseArticleInfo> u()
  {
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.a;
    if (localReadInJoyBaseAdapter == null) {
      return null;
    }
    return localReadInJoyBaseAdapter.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyChannelViewController
 * JD-Core Version:    0.7.0.1
 */