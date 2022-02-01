package com.tencent.mobileqq.kandian.biz.common.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.pubaccount.util.RIJBlackWhiteModeHelper;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.kandian.ad.api.IRIJADExposureService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.base.utils.ReadinjoySensorUtils;
import com.tencent.mobileqq.kandian.base.utils.ValueReference;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager.Builder;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyPageItemCache;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.baseui.api.IReadInJoyListViewGroup;
import com.tencent.mobileqq.kandian.biz.daily.DailyTipsFoldUtils;
import com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyXListView;
import com.tencent.mobileqq.kandian.biz.diandian.RecommendFeedsDiandianEntranceManager;
import com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyArticleAdapter;
import com.tencent.mobileqq.kandian.biz.feeds.UserReadUnReadInfoManager;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyBaseViewController;
import com.tencent.mobileqq.kandian.biz.framework.NotifyEndRefresh;
import com.tencent.mobileqq.kandian.biz.framework.RIJActivityResultHandler;
import com.tencent.mobileqq.kandian.biz.framework.RIJFrameworkHeaderManager;
import com.tencent.mobileqq.kandian.biz.framework.UserActionCollector;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.framework.click.OnGalleryImageClickListener;
import com.tencent.mobileqq.kandian.biz.framework.click.OnHorizontalSubArticleClick;
import com.tencent.mobileqq.kandian.biz.framework.click.OnSubRegionClickListener;
import com.tencent.mobileqq.kandian.biz.framework.click.RIJListViewGroupHandlerClick;
import com.tencent.mobileqq.kandian.biz.framework.click.RIJListViewGroupHandlerClick.Builder;
import com.tencent.mobileqq.kandian.biz.framework.handlers.FrameworkHandler;
import com.tencent.mobileqq.kandian.biz.framework.handlers.RIJInvokeHandler;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoPlayControlUtils;
import com.tencent.mobileqq.kandian.biz.message.RIJTipMessageManager;
import com.tencent.mobileqq.kandian.biz.message.RIJTipMessageManager.Builder;
import com.tencent.mobileqq.kandian.biz.pts.OnLastReadRefreshListener;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.ugc.managecolumn.ColumnSubscribeChangeObserver;
import com.tencent.mobileqq.kandian.biz.video.VideoBehaviorsReporter;
import com.tencent.mobileqq.kandian.biz.video.VideoUIManager.OnScreenChangeListener;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.UserOptInfo;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.ReadInJoySessionManager;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils.ExposureReportItem;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.router.ReadInJoyChannelGuidingManager;
import com.tencent.mobileqq.kandian.glue.video.report.RIJVideoReportManager;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianOverDrawOptimizeAladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.mobileqq.kandian.repo.ugc.srtutils.UGRuleManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView.DrawFinishedListener;
import com.tencent.widget.pull2refresh.anim.IAnimManager.PullRefreshComplete;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ReadInJoyListViewGroup
  extends ReadInJoyBaseListViewGroup
  implements View.OnClickListener, IReadInJoyListViewGroup, ReadInJoyBaseListView.RefreshCallback, OnGalleryImageClickListener, OnHorizontalSubArticleClick, OnSubRegionClickListener, OnLastReadRefreshListener, VideoUIManager.OnScreenChangeListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  private long A;
  private long B = -1L;
  private Handler C;
  private HashMap<String, Integer> D = new HashMap();
  private XListView.DrawFinishedListener E = new ReadInJoyListViewGroup.6(this);
  private int F;
  private FriendListObserver G = new ReadInJoyListViewGroup.8(this);
  private ReadInJoyObserver H = new ReadInJoyListViewGroup.10(this);
  private ColumnSubscribeChangeObserver I = new ReadInJoyListViewGroup.11(this);
  private Function1<Canvas, Unit> J = new ReadInJoyListViewGroup.12(this);
  private Function1<Canvas, Unit> K = new ReadInJoyListViewGroup.13(this);
  protected IFaceDecoder j;
  RIJInvokeHandler k;
  NotifyEndRefresh l;
  RIJFrameworkReportManager m;
  RIJVideoReportManager n;
  RIJListViewGroupHandlerClick o;
  RIJListViewGroupHandlerClick.Builder p;
  RIJFrameworkHeaderManager q;
  RIJDataFetchManager r;
  RIJTipMessageManager s;
  private ReadInJoyArticleAdapter t;
  private View u;
  private View v;
  private TextView w;
  private ImageView x;
  private int y = 1;
  private long z;
  
  public ReadInJoyListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt1, int paramInt2, int paramInt3, ReadInJoyPageItemCache paramReadInJoyPageItemCache)
  {
    this(paramReadInJoyBaseViewController, paramInt1, paramInt2, paramInt3, paramReadInJoyPageItemCache, 2131626334);
  }
  
  public ReadInJoyListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt1, int paramInt2, int paramInt3, ReadInJoyPageItemCache paramReadInJoyPageItemCache, int paramInt4)
  {
    super(paramReadInJoyBaseViewController, paramInt1, paramReadInJoyPageItemCache);
    this.u = getCurrentActivity().getLayoutInflater().inflate(paramInt4, this);
    this.A = paramInt3;
    setId(2131444298);
    this.k = new RIJInvokeHandler();
    this.k.a(this);
    this.m = new RIJFrameworkReportManager();
    this.n = new RIJVideoReportManager();
    this.o = new RIJListViewGroupHandlerClick();
    this.q = new RIJFrameworkHeaderManager();
    this.b.d = ReadInJoyHelper.c((QQAppInterface)ReadInJoyUtils.b());
    this.r = new RIJDataFetchManager(new RIJDataFetchManager.Builder().a(this.b).a(this.a).a(getCurrentActivity()).a(this.A).d(paramInt2).a(this.c).a(this.q).a(this));
    this.p = new RIJListViewGroupHandlerClick.Builder().a(this.a).a(getCurrentActivity());
    this.s = new RIJTipMessageManager(new RIJTipMessageManager.Builder().a(this.a).a(getCurrentActivity()));
    a(paramInt1, paramInt2);
    this.r.a().a(this.d);
    this.r.a().a(this.t);
    this.s.a().a(this.d);
    this.p.a(this.t);
    this.k.a(this.u, this.d);
  }
  
  public ReadInJoyListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt1, int paramInt2, ReadInJoyPageItemCache paramReadInJoyPageItemCache)
  {
    this(paramReadInJoyBaseViewController, paramInt1, paramInt2, -1, paramReadInJoyPageItemCache);
  }
  
  public ReadInJoyListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt, ReadInJoyPageItemCache paramReadInJoyPageItemCache)
  {
    this(paramReadInJoyBaseViewController, paramInt, -1, paramReadInJoyPageItemCache);
  }
  
  private void A()
  {
    View localView = this.v;
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = findViewById(2131441404);
    this.d.setEmptyView(localView);
    localView.setOnClickListener(null);
    this.q.a(this, this.a);
  }
  
  public static AbsBaseArticleInfo a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return RIJListViewGroupHandlerClick.a(paramAbsBaseArticleInfo);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.d = ((ReadInJoyXListView)findViewById(2131446630));
    if (paramInt1 == 41695)
    {
      this.q.a(this.d, getCurrentActivity());
      RIJDataFetchManager.a(this.a);
    }
    if (paramInt1 == 56) {
      this.z = getCurrentActivity().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
    }
    if (DailyModeConfigHandler.c(this.a)) {
      ReadinjoySensorUtils.a().b();
    }
    this.j = ((IQQAvatarService)((BaseActivity)getCurrentActivity()).app.getRuntimeService(IQQAvatarService.class, "")).getInstance(((BaseActivity)getCurrentActivity()).app);
    this.t = new ReadInJoyArticleAdapter(getCurrentActivity(), getCurrentActivity().getLayoutInflater(), this.a, this.d, this.j, this.k.a());
    Object localObject = this.k;
    ((RIJInvokeHandler)localObject).a(((RIJInvokeHandler)localObject).a(), this.t);
    this.k.a(this.u, this.d, this.A);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initUI before mListView.setPadding :");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(getCurrentActivity());
      QLog.d("ReadInJoyListViewGroup", 2, ((StringBuilder)localObject).toString());
    }
    x();
    b(paramInt2);
    A();
    this.q.a(this.d, getCurrentActivity(), this.a);
    ((BaseActivity)getCurrentActivity()).app.addObserver(this.G);
    this.s.b();
    this.s.j();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.H);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.I);
  }
  
  private void a(int paramInt, Runnable paramRunnable)
  {
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.9(this, paramRunnable), paramInt);
  }
  
  private void a(int paramInt1, List<Long> paramList, boolean paramBoolean, int paramInt2)
  {
    if ((paramList != null) && (paramInt2 > 0) && (paramList.size() > 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder("onChannelRefreshed ");
        Object localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          Long localLong = (Long)((Iterator)localObject).next();
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("recommendSeq = ");
          localStringBuilder2.append(localLong);
          localStringBuilder2.append(",\n ");
          localStringBuilder1.append(localStringBuilder2.toString());
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ReadInJoyListViewGroup_");
        ((StringBuilder)localObject).append(this.a);
        QLog.d(((StringBuilder)localObject).toString(), 1, localStringBuilder1.toString());
      }
      if (!this.t.v) {
        this.t.a(false);
      }
      this.t.v = true;
      VideoBehaviorsReporter.a().c(true);
      this.r.a(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.a), paramList), 1);
      this.t.d(0);
      a(paramInt1, paramBoolean);
      return;
    }
    if (this.t.isEmpty())
    {
      if (this.a == 70)
      {
        a(getResources().getString(2131915400), getResources().getDrawable(2130851396));
        return;
      }
      setNetworkErrorView(getResources().getString(2131915491));
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (((paramInt == 56) || (paramInt == 0)) && (ReadInJoyUtils.b() != null)) {
      ((IRIJADExposureService)RIJQQAppInterfaceUtil.a().getRuntimeService(IRIJADExposureService.class)).reportInvalidADExposure(getContext(), paramInt);
    }
    if (paramInt == 70) {
      this.d.setNoMoreData(paramBoolean);
    }
    if ((paramInt == 0) || (DailyModeConfigHandler.c(this.a))) {
      ReadinjoySPEventReport.a().f.a(2, this.d);
    }
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    findViewById(2131441404).setVisibility(8);
    if (this.v == null)
    {
      this.v = ((ViewStub)findViewById(2131439207)).inflate();
      this.w = ((TextView)this.v.findViewById(2131444252));
      this.x = ((ImageView)this.v.findViewById(2131444251));
    }
    this.w.setText(paramString);
    this.d.setEmptyView(this.v);
    this.v.setOnClickListener(this);
    if (paramDrawable != null)
    {
      this.x.setImageDrawable(paramDrawable);
      if (this.a == 70)
      {
        this.w.setTextColor(-4473925);
        ((LinearLayout.LayoutParams)this.w.getLayoutParams()).topMargin = AIOUtils.b(20.0F, getResources());
      }
    }
    else
    {
      this.x.setImageDrawable(getResources().getDrawable(2130839454));
      this.w.setTextColor(getResources().getColor(2131167846));
      ((LinearLayout.LayoutParams)this.w.getLayoutParams()).topMargin = AIOUtils.b(10.0F, getResources());
    }
    this.q.a(this, this.a);
  }
  
  private void b(int paramInt)
  {
    this.t.e(paramInt);
    this.t.c(this.A);
    ListenerBuilder localListenerBuilder = new ListenerBuilder().a(this).a(this).a(this).a(this);
    this.t.a(localListenerBuilder);
    this.d.setAdapter(this.t);
  }
  
  private void b(boolean paramBoolean, int paramInt)
  {
    if (z())
    {
      this.d.h();
      return;
    }
    String str;
    if (this.a == 70)
    {
      if ((paramBoolean) && (paramInt > 0)) {
        str = getResources().getString(2131915404);
      } else {
        str = getResources().getString(2131915403);
      }
    }
    else if (this.a == 40677)
    {
      if ((paramBoolean) && (paramInt > 0)) {
        str = String.format(getResources().getString(2131915228), new Object[] { Integer.valueOf(paramInt * 2) });
      } else {
        str = getResources().getString(2131915227);
      }
    }
    else if (this.a == 40531)
    {
      if ((paramBoolean) && (paramInt > 0)) {
        str = String.format(getResources().getString(2131915228), new Object[] { Integer.valueOf(paramInt) });
      } else {
        str = getResources().getString(2131915226);
      }
    }
    else if ((paramBoolean) && (paramInt > 0)) {
      str = String.format(getResources().getString(2131915228), new Object[] { Integer.valueOf(paramInt) });
    } else {
      str = getResources().getString(2131915227);
    }
    this.d.a(true, str);
    if (RIJShowKanDianTabSp.c()) {
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.5(this), 1500L);
    }
  }
  
  private void c(int paramInt)
  {
    if (RecommendFeedsDiandianEntranceManager.isFollowOrTribeFeedsType(ReadInJoyHelper.K()))
    {
      QLog.d("ReadInJoyListViewGroup", 1, "request 0xdcb");
      RecommendFeedsDiandianEntranceManager.getInstance().checkAndReqRefreshDianDianIcon();
      return;
    }
    QLog.d("ReadInJoyListViewGroup", 1, "request 0x6cf");
    this.r.c(paramInt);
  }
  
  private void setNetworkErrorView(String paramString)
  {
    a(paramString, null);
  }
  
  private void x()
  {
    if (!RIJKanDianOverDrawOptimizeAladdinConfig.a())
    {
      QLog.d("ReadInJoyListViewGroup", 2, "ListView overdraw switch close");
      this.d.setContentBackground(2130838958);
      int i = Color.parseColor("#f8f8f8");
      this.d.setBackgroundColor(i);
    }
    this.d.b(0);
    this.d.setChannelId(this.a);
    this.d.setOnItemClickListener(this);
    this.d.setRefreshCallback(this);
    this.d.setOnItemLongClickListener(this);
    if (this.a == 0)
    {
      this.d.setOverScrollTouchMode(1);
      this.d.setOverScrollFlingMode(1);
    }
    this.d.setDrawFinishedListener(this.E);
    this.d.a(this.k.a);
    if ((this.a == 0) || (DailyModeConfigHandler.c(this.a))) {
      UserActionCollector.a().a(this.d, this.a);
    }
  }
  
  private void y()
  {
    if (this.a == 70) {
      this.d.f = 0;
    }
    if ((this.a == 56) && (this.r.a().u()))
    {
      int i;
      if (this.q.a() == null) {
        i = 0;
      } else {
        i = 1;
      }
      this.d.setSelectionFromTop(i, 0);
      this.r.a().a(false);
    }
    if ((DailyModeConfigHandler.a(this.a)) && ((this.d instanceof ReadInJoyDailyXListView))) {
      ((ReadInJoyDailyXListView)this.d).k();
    }
  }
  
  private boolean z()
  {
    boolean bool = getCurrentActivity().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", false);
    getCurrentActivity().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", false);
    return bool;
  }
  
  public void a()
  {
    Object localObject = this.l;
    if (localObject != null) {
      ((NotifyEndRefresh)localObject).a(this.r.a().m());
    }
    localObject = this.t;
    if (localObject != null) {
      ((ReadInJoyArticleAdapter)localObject).a(2, null);
    }
    this.k.h();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshListByChannelID channelID = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" mChannelID = ");
      localStringBuilder.append(this.a);
      QLog.i("ReadInJoyListViewGroup", 2, localStringBuilder.toString());
    }
    if ((paramInt == this.a) && (this.t != null)) {
      this.r.b(true, 1001, true);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.k.a(paramInt1, paramInt2, paramIntent);
    RIJActivityResultHandler localRIJActivityResultHandler = new RIJActivityResultHandler(this.t, getCurrentActivity(), this.a, this.r);
    if (paramInt1 == 9993)
    {
      if (paramInt2 == 1) {
        m();
      }
    }
    else {
      localRIJActivityResultHandler.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    this.t.a(paramInt, paramIntent);
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString1, String paramString2)
  {
    this.r.a(paramInt, paramAbsBaseArticleInfo, paramString1, paramString2);
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    PublicTracker.a(null, "KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED");
    if (paramInt == this.a)
    {
      if (this.t == null) {
        return;
      }
      this.k.a(paramInt, paramList);
      this.r.a(paramInt, paramList, new ReadInJoyListViewGroup.4(this));
      PublicTracker.a("KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED", null);
      PublicTracker.a("KANDIAN_NEW_FEEDS_LOAD_ARTICLE", null);
      PublicTracker.a(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE_FINISH_TO_MEASURE");
    }
  }
  
  public void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    this.k.a(paramContext, paramAbsBaseArticleInfo, paramString, paramInt2);
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((paramConfiguration != null) && (paramConfiguration.hashCode() != this.F))
    {
      if ((!LiuHaiUtils.f()) && (!LiuHaiUtils.e())) {
        return;
      }
      this.F = paramConfiguration.hashCode();
      ThreadManager.getUIHandler().post(new ReadInJoyListViewGroup.7(this));
    }
  }
  
  public void a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    RIJJumpUtils.a = paramAbsBaseArticleInfo;
    this.k.a(paramView, paramAbsBaseArticleInfo, paramInt);
    this.o.a(paramView, paramAbsBaseArticleInfo, paramInt, this.p);
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    this.r.a().b(paramInt);
    this.k.a(paramReadInJoyBaseListView, paramInt);
    this.m.a(this.a, paramInt);
    this.r.i();
    this.r.p();
    this.q.c();
    if (this.a == 0) {
      ReadinjoyReportUtils.g();
    }
    c(paramInt);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam1, VideoPlayParam paramVideoPlayParam2)
  {
    ((FrameworkHandler)this.k.a(2)).A();
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, View paramView, int paramInt, long paramLong)
  {
    if (RIJFeedsType.l(paramAbsBaseArticleInfo))
    {
      boolean bool = RIJFeedsType.J(paramAbsBaseArticleInfo);
      int i = 2;
      if ((!bool) && (!RIJFeedsType.b(paramAbsBaseArticleInfo)))
      {
        if (RIJFeedsType.d(paramAbsBaseArticleInfo))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ReadInJoyListViewGroup", 2, "atlas native has undercarriage");
          }
          paramInt = 0;
        }
        else
        {
          this.o.b(paramAbsBaseArticleInfo, this.p);
          paramInt = i;
        }
      }
      else
      {
        this.o.a(paramAbsBaseArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt, this.p);
        paramInt = 4;
      }
      this.o.a(paramInt, this.p);
      return;
    }
    a(null, paramAbsBaseArticleInfo, paramView, paramInt, paramLong);
    if (paramAbsBaseArticleInfo != null) {
      paramAbsBaseArticleInfo.invalidateProteusTemplateBean();
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    this.q.a(paramTopBannerInfo, this.d, getCurrentActivity(), this.a, this.t);
  }
  
  public void a(AdapterView<?> paramAdapterView, AbsBaseArticleInfo paramAbsBaseArticleInfo, View paramView, int paramInt, long paramLong)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mArticleContentUrl != null) && (paramAbsBaseArticleInfo.mArticleContentUrl.startsWith("mqqapi://readinjoy/open")) && (paramAbsBaseArticleInfo.mArticleContentUrl.contains("appSchema=rijvideo")) && (paramAbsBaseArticleInfo.mArticleContentUrl.contains("target=4")))
    {
      RIJJumpUtils.a(getCurrentActivity(), paramAbsBaseArticleInfo);
      paramAdapterView = new HashMap();
      paramAdapterView.put("ugType", "1");
      if (PackageUtil.a(getCurrentActivity(), "com.tencent.rijvideo")) {
        paramAdapterView.put("stateType", "2");
      } else {
        paramAdapterView.put("stateType", "1");
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(RIJQQAppInterfaceUtil.d(), "actKanDianUgClick", true, 0L, 0L, paramAdapterView, "", true);
      return;
    }
    ValueReference localValueReference = new ValueReference(Integer.valueOf(0));
    this.o.a(paramView);
    if (paramAbsBaseArticleInfo != null)
    {
      String str = paramAbsBaseArticleInfo.innerUniqueID;
      this.k.a(paramAdapterView, paramView, paramInt, paramLong);
      this.o.a(paramAbsBaseArticleInfo, this.a);
      RIJJumpUtils.a = paramAbsBaseArticleInfo;
      if (this.o.a(paramAbsBaseArticleInfo, paramView, paramInt, localValueReference, paramAbsBaseArticleInfo, this.p, this.C)) {
        return;
      }
      this.o.a(paramInt, paramAbsBaseArticleInfo, this.D, this.p);
      paramAdapterView = str;
    }
    else
    {
      paramAdapterView = "";
    }
    this.o.a(((Integer)localValueReference.a()).intValue(), this.p);
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append("onItemClick, rowkey= ");
    paramAbsBaseArticleInfo.append(paramAdapterView);
    QLog.d("ReadInJoyListViewGroup", 1, paramAbsBaseArticleInfo.toString());
  }
  
  public void a(IAnimManager.PullRefreshComplete paramPullRefreshComplete)
  {
    this.q.a(paramPullRefreshComplete, this.d);
  }
  
  public void a(Map<Integer, Boolean> paramMap) {}
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ReadInJoyListViewGroup_");
      localStringBuilder.append(this.a);
      QLog.d(localStringBuilder.toString(), 2, "detachFromViewGroup()");
    }
    this.k.a(paramMap, paramBoolean);
    this.m.a(paramMap, paramBoolean, ReadinjoyReportUtils.a(this.a), RIJKanDianFolderStatus.getFolderStatus(this.a), this.r.m(), this.a, getContext(), this.r.a().k(), this.c, this.r.a().i(), this.z);
    this.r.r();
    if (this.d != null) {
      this.d.b(false);
    }
    getCurrentActivity().getIntent().putExtra("from_search", false);
  }
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean, Map<Long, ReadinjoyReportUtils.ExposureReportItem> paramMap1, String paramString)
  {
    this.m.a(paramMap, paramBoolean, paramMap1, paramString, getContext(), this.a, this.r.a().k(), this.c, this.r.a().i(), this.z);
  }
  
  public void a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ReadInJoyListViewGroup_");
      ((StringBuilder)localObject).append(this.a);
      QLog.d(((StringBuilder)localObject).toString(), 2, "attachToViewGroup()");
    }
    this.k.a(paramSet, paramMap);
    Object localObject = this.t;
    if (localObject != null) {
      ((ReadInJoyArticleAdapter)localObject).a(paramSet, paramMap);
    }
    this.r.q();
    this.s.c();
    PublicTracker.a(null, "KANDIAN_FEEDS_STAGE_2_COST");
    if (!this.r.m()) {
      i();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, 1);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (!this.e) {
      return;
    }
    if (paramInt == 8)
    {
      this.r.n();
      if (!this.r.a().h()) {
        return;
      }
    }
    this.k.a(paramBoolean, paramInt);
    this.d.post(new ReadInJoyListViewGroup.1(this, paramBoolean));
    if (paramBoolean) {
      this.d.c(paramInt);
    } else {
      a(2, null);
    }
    this.t.v();
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<AbsBaseArticleInfo> paramList1)
  {
    this.r.a(paramBoolean, paramInt, paramLong, paramList, paramList1);
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if (paramInt == this.a)
    {
      if (this.t == null) {
        return;
      }
      this.k.a(paramBoolean1, paramInt, paramList, paramBoolean2);
      int i1 = ReadInJoyLogicEngine.a().b(Integer.valueOf(paramInt));
      if (this.r.a().h())
      {
        if ((paramList != null) && (i1 == 1)) {
          this.t.q_(0);
        }
        this.r.a().d(false);
      }
      UserReadUnReadInfoManager.a().e();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onChannelRefreshed, success = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(", refreshedArticleSize = ");
      localStringBuilder.append(i1);
      localStringBuilder.append(", articleSeqList size = ");
      int i;
      if (paramList != null) {
        i = paramList.size();
      } else {
        i = 0;
      }
      localStringBuilder.append(i);
      QLog.d("ReadInJoyListViewGroup", 1, localStringBuilder.toString());
      if (paramBoolean1) {
        a(paramInt, paramList, paramBoolean2, i1);
      } else if (this.t.isEmpty()) {
        setNetworkErrorView(getResources().getString(2131915451));
      }
      b(paramBoolean1, i1);
      y();
      this.r.d(paramList);
      this.r.b(paramList);
      this.r.c(paramList);
      AbstractGifImage.resumeAll();
      ReadInJoyChannelGuidingManager.a(this.t.a(0), this.d, this.t);
      DailyTipsFoldUtils.a(this.t.a(0), this.d);
      if (paramInt == 0) {
        ReadInJoySessionManager.a.c();
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ReadInJoyListViewGroup_");
      ((StringBuilder)localObject).append(this.a);
      QLog.d(((StringBuilder)localObject).toString(), 2, "OnResume()");
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "onResume, mChannelID= ", Integer.valueOf(this.a) });
    }
    this.k.e();
    if (this.r.m()) {
      i();
    }
    if (System.currentTimeMillis() - this.B > 10000L)
    {
      this.B = System.currentTimeMillis();
      ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.2(this));
    }
    Object localObject = this.t;
    if (localObject != null) {
      ((ReadInJoyArticleAdapter)localObject).M();
    }
    this.q.d();
    if (StudyModeManager.h()) {
      this.s.d();
    } else {
      this.s.c();
    }
    this.d.invalidate();
    if ((this.a == 0) || (DailyModeConfigHandler.c(this.a))) {
      UserActionCollector.a().a(this.d, this.a);
    }
    this.s.k();
    UGRuleManager.a(getChannelID());
    w();
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if ((paramInt == this.a) && (this.t != null))
    {
      if (paramList == null) {
        return;
      }
      if (paramList.size() > 0)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder("refreshChannelData ");
          localStringBuilder1.append("channelID : ");
          localStringBuilder1.append(paramInt);
          localStringBuilder1.append("\n");
          Object localObject = paramList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            Long localLong = (Long)((Iterator)localObject).next();
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("recommendSeq = ");
            localStringBuilder2.append(localLong);
            localStringBuilder2.append(",\n ");
            localStringBuilder1.append(localStringBuilder2.toString());
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ReadInJoyListViewGroup_");
          ((StringBuilder)localObject).append(this.a);
          QLog.d(((StringBuilder)localObject).toString(), 1, localStringBuilder1.toString());
        }
        VideoBehaviorsReporter.a().c(true);
        this.r.a(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.a), paramList), 1);
        this.t.d(0);
        return;
      }
      if (this.t.isEmpty()) {
        setNetworkErrorView(getResources().getString(2131915491));
      }
    }
  }
  
  public void b(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    paramReadInJoyBaseListView = this.r.a();
    int i = 4;
    boolean bool;
    if (paramInt == 4) {
      bool = true;
    } else {
      bool = false;
    }
    paramReadInJoyBaseListView.g(bool);
    if (QLog.isColorLevel())
    {
      paramReadInJoyBaseListView = new StringBuilder();
      paramReadInJoyBaseListView.append("loadmorechannel ");
      paramReadInJoyBaseListView.append(this.a);
      paramReadInJoyBaseListView.append(" ");
      paramReadInJoyBaseListView.append(paramInt);
      paramReadInJoyBaseListView.append(" ");
      paramReadInJoyBaseListView.append(this.d.f);
      QLog.d("ReadInJoyListViewGroup", 2, paramReadInJoyBaseListView.toString());
    }
    paramReadInJoyBaseListView = ReadInJoyUtils.b();
    if ((paramReadInJoyBaseListView != null) && (this.a == 56) && (this.A == 1001L))
    {
      if (!((KandianMergeManager)paramReadInJoyBaseListView.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).M()) {
        i = 0;
      }
      i = 0x2 | i;
    }
    else
    {
      i = 0;
    }
    int i1;
    if ((this.a != 40830) && (!DailyModeConfigHandler.c(this.a)))
    {
      i1 = 1;
    }
    else
    {
      i1 = this.y;
      this.y = (i1 + 1);
    }
    ReadInJoyLogicEngine.a().a(this.a, this.r.a().k(), paramInt, i, i1);
    RIJFrameworkReportManager.a(this.a);
  }
  
  public void b(Map<Integer, Boolean> paramMap)
  {
    paramMap.put(Integer.valueOf(this.a), Boolean.valueOf(true));
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((paramInt == this.a) && (this.t != null))
    {
      this.k.b(paramBoolean1, paramInt, paramList, paramBoolean2);
      this.r.a(paramBoolean1, paramInt, paramList, paramBoolean2);
      return;
    }
    this.r.a().g(false);
  }
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ReadInJoyListViewGroup_");
      ((StringBuilder)localObject).append(this.a);
      QLog.d(((StringBuilder)localObject).toString(), 2, "onPause()");
    }
    this.k.f();
    Object localObject = this.t;
    if (localObject != null) {
      ((ReadInJoyArticleAdapter)localObject).N();
    }
    this.q.e();
    v();
    long l1 = System.currentTimeMillis();
    this.r.j();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "mListView onSaveInstanceState cost: ", Long.valueOf(System.currentTimeMillis() - l1) });
    }
  }
  
  public void c(int paramInt, List<Long> paramList)
  {
    if ((paramInt == this.a) && (paramList != null))
    {
      ReadInJoyArticleAdapter localReadInJoyArticleAdapter = this.t;
      if (localReadInJoyArticleAdapter == null) {
        return;
      }
      localReadInJoyArticleAdapter.b(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.a), paramList));
      this.t.notifyDataSetChanged();
    }
  }
  
  public void c(Map<Integer, BaseReportData> paramMap)
  {
    this.k.a(paramMap);
  }
  
  public void cW_()
  {
    ((FrameworkHandler)this.k.a(2)).z();
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ReadInJoyListViewGroup_");
      localStringBuilder.append(this.a);
      QLog.d(localStringBuilder.toString(), 2, "onStart()");
    }
    this.k.g();
    UserReadUnReadInfoManager.a().f();
    if ((this.a == 0) && (!this.r.a().h())) {
      a(1500, new ReadInJoyListViewGroup.3(this));
    }
  }
  
  public void d(Map<Integer, BaseReportData> paramMap)
  {
    this.m.a(paramMap);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.a == 0)
    {
      RIJBlackWhiteModeHelper.a.a(paramCanvas, true, this.K);
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    DailyTipsFoldUtils.b(this.d, this.a);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.a == 0)
    {
      RIJBlackWhiteModeHelper.a.a(paramCanvas, true, this.J);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ReadInJoyListViewGroup_");
      localStringBuilder.append(this.a);
      QLog.d(localStringBuilder.toString(), 2, "onStop()");
    }
    this.k.g();
    this.r.l();
    UserReadUnReadInfoManager.a().g();
  }
  
  public void f()
  {
    this.k.d();
    ReadInJoyHelper.a(System.currentTimeMillis(), (QQAppInterface)ReadInJoyUtils.b());
    this.r.d(this.p.c());
    ((BaseActivity)getCurrentActivity()).app.removeObserver(this.G);
    this.y = 1;
    this.t.I();
    this.t.s();
    this.t.a(null);
    this.t.W();
    this.t = null;
    if (this.d != null)
    {
      DailyTipsFoldUtils.a(this.d, this.a);
      this.d.setDrawFinishedListener(null);
      this.d.setRefreshCallback(null);
      this.d.d();
    }
    Object localObject = this.j;
    if (localObject != null)
    {
      ((IFaceDecoder)localObject).destory();
      this.j = null;
    }
    ReadInJoyHelper.b(((BaseActivity)getCurrentActivity()).app);
    localObject = this.s;
    if (localObject != null) {
      ((RIJTipMessageManager)localObject).e();
    }
    localObject = this.q;
    if (localObject != null) {
      ((RIJFrameworkHeaderManager)localObject).f();
    }
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).unRegisterReceiver();
    VideoPlayControlUtils.f(this.d);
    if (DailyModeConfigHandler.c(getChannelID())) {
      ReadinjoySensorUtils.a().c();
    }
    UGRuleManager.b(getChannelID());
    this.r.b();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.H);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.I);
  }
  
  public ReadInJoyArticleAdapter getAdapter()
  {
    return this.t;
  }
  
  public RIJDataFetchManager getDataFetchManager()
  {
    return this.r;
  }
  
  public RIJFrameworkHeaderManager getHeaderViewManager()
  {
    return this.q;
  }
  
  public RIJInvokeHandler getInvokeHandler()
  {
    return this.k;
  }
  
  public String getLastActionBrief()
  {
    if (this.r.a().d() != null) {
      return this.r.a().d().mTitle;
    }
    return null;
  }
  
  public long getLastActionTime()
  {
    return this.r.a().e();
  }
  
  public ListView getListView()
  {
    return this.d;
  }
  
  public void j()
  {
    this.s.f();
  }
  
  public void k()
  {
    this.d.f();
  }
  
  public void m()
  {
    if (this.d == null) {
      return;
    }
    a(true);
  }
  
  public void n()
  {
    ReadInJoyArticleAdapter localReadInJoyArticleAdapter = this.t;
    if (localReadInJoyArticleAdapter != null) {
      localReadInJoyArticleAdapter.notifyDataSetChanged();
    }
  }
  
  public void o()
  {
    this.q.g();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131439205) {
      return;
    }
    A();
    RIJThreadHandler.a(3);
    this.r.b(true, 3, false);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    EventCollector.getInstance().onViewClicked(paramView);
    int i;
    if ((paramAdapterView instanceof ReadInJoyXListView))
    {
      i = paramInt - ((ReadInJoyXListView)paramAdapterView).getHeaderViewsCount();
      if (i < 0) {
        i = paramInt;
      }
    }
    else
    {
      i = paramInt;
    }
    Object localObject = this.t.getItem(i);
    if ((localObject instanceof BaseArticleInfo))
    {
      localObject = (AbsBaseArticleInfo)localObject;
      if (RIJFeedsType.O((AbsBaseArticleInfo)localObject)) {
        return;
      }
      if (((AbsBaseArticleInfo)localObject).mFeedType == 20) {
        return;
      }
    }
    else
    {
      localObject = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onItemClick pos : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", id : ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", data : ");
    localStringBuilder.append(localObject);
    QLog.d("ReadInJoyListViewGroup", 1, localStringBuilder.toString());
    a(paramAdapterView, (AbsBaseArticleInfo)localObject, paramView, paramInt, i);
    if (localObject != null) {
      ((AbsBaseArticleInfo)localObject).invalidateProteusTemplateBean();
    }
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  public void p()
  {
    if (this.d != null) {
      this.d.j();
    }
  }
  
  public void q()
  {
    if (this.d != null) {
      this.d.a(HardCodeUtil.a(2131910461));
    }
  }
  
  public boolean r()
  {
    Boolean localBoolean = this.k.j();
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    return this.q.h();
  }
  
  public void s()
  {
    QLog.d("ReadInJoyListViewGroup", 1, "invalidAllArticles");
    ReadInJoyArticleAdapter localReadInJoyArticleAdapter = this.t;
    if (localReadInJoyArticleAdapter != null) {
      localReadInJoyArticleAdapter.U();
    }
  }
  
  public void setNotifyEndRefresh(NotifyEndRefresh paramNotifyEndRefresh)
  {
    this.l = paramNotifyEndRefresh;
  }
  
  public void setRefreshHeader(int paramInt)
  {
    this.q.a(paramInt, this.d, getCurrentActivity(), this.a);
  }
  
  public void setSkinHeader(int paramInt, boolean paramBoolean)
  {
    this.q.a(paramInt, paramBoolean, this.d, getCurrentActivity(), this.a);
  }
  
  public void t()
  {
    this.t.t();
  }
  
  public void u()
  {
    this.t.u();
  }
  
  public void v()
  {
    this.t.w();
  }
  
  public void w()
  {
    this.t.x();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup
 * JD-Core Version:    0.7.0.1
 */