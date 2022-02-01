package com.tencent.mobileqq.kandian.biz.framework.handlers;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager.Builder;
import com.tencent.mobileqq.kandian.biz.account.api.impl.CellFactory;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListViewGroup;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyViewController;
import com.tencent.mobileqq.kandian.biz.debug.ReadInJoyDropFrameHelper;
import com.tencent.mobileqq.kandian.biz.debug.ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener;
import com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelBannerController;
import com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelBannerView;
import com.tencent.mobileqq.kandian.biz.feeds.controller.KanDianViewController;
import com.tencent.mobileqq.kandian.biz.framework.RIJFrameworkHeaderManager;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.UserActionCollector;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoPlayControlUtils;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteItemViewBuilder;
import com.tencent.mobileqq.kandian.biz.pts.network.ReadInJoyPTSCostHelper;
import com.tencent.mobileqq.kandian.biz.pts.util.DynamicItemViewHelper;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteSwitchManager;
import com.tencent.mobileqq.kandian.biz.push.activity.ReadInJoyLockScreenJumpDelegate;
import com.tencent.mobileqq.kandian.biz.push.activity.ReadinjoyJumpActivity;
import com.tencent.mobileqq.kandian.biz.ugc.voice.ReadInJoyVoicePlayController;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.UserOptInfo;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.biu.RIJNewBiuCardTransformManager;
import com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelBannerInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.os.MqqHandler;

public class FrameworkHandler
  extends BaseHandler
  implements ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener
{
  boolean a = false;
  public boolean b;
  public boolean c;
  private FrameworkHandler.ItemViewBuilder d = new FrameworkHandler.ItemViewBuilder(this);
  private PTSLiteItemViewBuilder e;
  private RIJChannelBannerController f;
  private StudyModeChangeListener g;
  private RIJChannelBannerView h;
  private ReadInJoyObserver i = new FrameworkHandler.1(this);
  private TextView j;
  private ImageView k;
  private int l = 8;
  private boolean m = true;
  
  private void B()
  {
    if ((a().a().j() instanceof KanDianViewController))
    {
      Activity localActivity = a().a().q();
      if (localActivity.findViewById(2131427598) != null)
      {
        b(true);
        return;
      }
      if (localActivity.findViewById(2131427599) != null) {
        a().a().c().a(a().a().q(), (ReadInJoyXListView)e(), a().a().a(), c());
      }
    }
    else if ((a().a().j() instanceof ReadInJoyDailyViewController))
    {
      ((ReadInJoyDailyViewController)a().a().j()).a((ReadInJoyXListView)e(), a().a().p());
    }
  }
  
  private void C()
  {
    int n;
    if ((!this.b) && (this.c))
    {
      this.b = true;
      this.c = false;
      if (c() == ChannelCoverInfoModule.g())
      {
        PublicTracker.f = 1;
      }
      else
      {
        n = c();
        if (n != 0)
        {
          if (n != 56)
          {
            if (n == 70) {
              PublicTracker.f = 3;
            }
          }
          else {
            PublicTracker.f = 2;
          }
        }
        else {
          PublicTracker.f = 1;
        }
      }
      PublicTracker.a("KANDIAN_NEW_FEEDS_LIST_VIEW_GROUP_MEASURE_LAYOUT_DRAW", null);
      PublicTracker.a("KANDIAN_FEEDS_STAGE_2_COST", null);
      PublicTracker.a("KANDIAN_FEEDS_COST", null);
      if (c() == 56) {
        PublicTracker.a("video_tab_cost", null);
      }
    }
    if (this.m)
    {
      this.m = false;
      if (c() == ChannelCoverInfoModule.g())
      {
        PublicTracker.a("recommend_tab_cost", null);
        return;
      }
      n = c();
      if (n != 0)
      {
        if (n != 56)
        {
          if (n != 70) {
            return;
          }
          PublicTracker.a("subscribe_tab_cost", null);
          return;
        }
        PublicTracker.a("video_tab_cost", null);
        return;
      }
      PublicTracker.a("recommend_tab_cost", null);
    }
  }
  
  private void D()
  {
    if (e() != null) {
      VideoPlayControlUtils.a(e(), null, true);
    }
  }
  
  private void E()
  {
    Activity localActivity = a().a().q();
    if (ReadinjoyJumpActivity.a(localActivity.getIntent()))
    {
      ReadinjoyJumpActivity.a(localActivity, localActivity.getIntent(), 500L);
      return;
    }
    Intent localIntent;
    if (ReadinjoyJumpActivity.b(localActivity.getIntent()))
    {
      localIntent = localActivity.getIntent();
      ReadInJoyLockScreenJumpDelegate.a(localActivity, localIntent);
      localIntent.removeExtra("daily_lock_screen_flag");
      return;
    }
    if (ReadinjoyJumpActivity.c(localActivity.getIntent()))
    {
      if (ReadInJoyHelper.w()) {
        return;
      }
      localIntent = localActivity.getIntent();
      if (localIntent.getIntExtra("launch_from", 0) == 9)
      {
        ReadInJoyLockScreenJumpDelegate.a(localActivity, localIntent);
        localIntent.removeExtra("kan_dian_lock_screen_flag");
      }
    }
  }
  
  private void F()
  {
    if (c() == 0)
    {
      if (RIJNewBiuCardTransformManager.a().b())
      {
        a(false, 1);
        QLog.d("FrameworkHandler", 2, "transformCommentBiuCard | shouldAutoRefresh and backToTop");
      }
      ThreadManager.getUIHandler().postDelayed(new FrameworkHandler.5(this), 500L);
      return;
    }
    RIJNewBiuCardTransformManager.a().e();
    QLog.d("FrameworkHandler", 2, "transformCommentBiuCard | not in recommend feeds and clear biuinfo");
  }
  
  private void G()
  {
    new Handler(Looper.getMainLooper()).post(new FrameworkHandler.6(this));
  }
  
  private void H()
  {
    this.h = new RIJChannelBannerView(i());
    if ((e() instanceof ListView))
    {
      ((ListView)e()).addHeaderView(this.h, 2);
      this.g = new FrameworkHandler.7(this);
      StudyModeManager.a(this.g);
    }
  }
  
  private void I()
  {
    if (this.f != null)
    {
      QLog.i("FrameworkHandler", 1, "[initRijChannelBannerController] controller is not null, do not init again.");
      return;
    }
    if ((PTSLiteSwitchManager.a().b()) && (this.h != null)) {
      this.f = new RIJChannelBannerController(c(), i(), this.h);
    }
  }
  
  private void J()
  {
    if (this.e != null) {
      return;
    }
    if (PTSLiteSwitchManager.a().b())
    {
      this.e = new PTSLiteItemViewBuilder(i(), g());
      QLog.i("FrameworkHandler", 1, "[initPtsLiteItemViewBuilder]");
    }
  }
  
  private void K()
  {
    RIJChannelBannerController localRIJChannelBannerController = this.f;
    if (localRIJChannelBannerController != null) {
      localRIJChannelBannerController.b();
    }
  }
  
  private void L()
  {
    if ((c() == 0) || (DailyModeConfigHandler.c(c())))
    {
      ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = d();
      if (localReadInJoyBaseListViewGroup != null)
      {
        localReadInJoyBaseListViewGroup.setFocusableInTouchMode(true);
        localReadInJoyBaseListViewGroup.requestFocus();
        localReadInJoyBaseListViewGroup.setOnKeyListener(new FrameworkHandler.8(this));
      }
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.j = ((TextView)paramView.findViewById(2131433080));
    if ((d() instanceof ReadInJoyListViewGroup)) {
      ReadInJoyDropFrameHelper.d().a(c(), (FrameworkHandler)((ReadInJoyListViewGroup)d()).getInvokeHandler().b());
    }
  }
  
  private void b(View paramView)
  {
    this.k = ((ImageView)paramView.findViewById(2131436279));
    if ((c() == 0) && (ReadInJoyHelper.w()))
    {
      paramView = (FrameLayout.LayoutParams)this.k.getLayoutParams();
      paramView.setMargins(paramView.leftMargin, paramView.topMargin, ViewUtils.dip2px(34.0F), ViewUtils.dip2px(184.0F));
      this.k.setLayoutParams(paramView);
    }
    this.k.setOnClickListener(new FrameworkHandler.3(this));
  }
  
  private void b(List<ChannelBannerInfo> paramList)
  {
    if (this.f == null) {
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.f.a(true);
      this.f.a((ChannelBannerInfo)paramList.get(0));
      return;
    }
    this.f.a(false);
  }
  
  private void b(boolean paramBoolean)
  {
    label164:
    label169:
    label174:
    for (;;)
    {
      try
      {
        bool2 = StudyModeManager.h();
        if ((bool2 == this.a) && (!paramBoolean)) {
          return;
        }
        if (a().a().q() == null) {
          return;
        }
        this.a = bool2;
        if (DailyModeConfigHandler.c(c()))
        {
          if (paramBoolean) {
            break label164;
          }
          return;
        }
        bool1 = this.a;
        if (c() == 0) {
          break label174;
        }
        if (paramBoolean) {
          break label169;
        }
        return;
      }
      catch (Exception localException)
      {
        boolean bool2;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("update ListViewPadding error, e=");
        localStringBuilder.append(localException);
        QLog.d("FrameworkHandler", 2, localStringBuilder.toString());
      }
      a().a().c().a(a().a().q(), (ReadInJoyXListView)e(), a().a().a(), c(), bool1, paramBoolean);
      if (bool2)
      {
        a(true);
        return;
      }
      return;
      boolean bool1 = false;
      continue;
      bool1 = false;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.f != null) && ((e() instanceof ListView)))
    {
      RIJChannelBannerView localRIJChannelBannerView = this.f.a();
      ListView localListView = (ListView)e();
      if (paramBoolean) {
        localListView.removeHeaderView(localRIJChannelBannerView);
      }
    }
    d(paramBoolean);
  }
  
  private void d(boolean paramBoolean)
  {
    boolean bool = e(paramBoolean);
    RIJDataFetchManager localRIJDataFetchManager = a();
    if ((bool) && (!paramBoolean) && (localRIJDataFetchManager != null)) {
      a(true);
    }
  }
  
  private void e(int paramInt) {}
  
  private boolean e(boolean paramBoolean)
  {
    if ((ReadInJoyHelper.t()) && (c() == 0))
    {
      localObject = a();
      if (localObject != null) {}
    }
    else
    {
      bool = false;
      break label43;
    }
    ((RIJDataFetchManager)localObject).b(c());
    boolean bool = true;
    label43:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("deleteArticleInStudyMode, isStudyMode=");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("  hasDeleted=");
    ((StringBuilder)localObject).append(bool);
    QLog.d("FrameworkHandler", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  public void A() {}
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    System.currentTimeMillis();
    int i1 = a(paramInt).intValue();
    AbsBaseArticleInfo localAbsBaseArticleInfo1 = (AbsBaseArticleInfo)b(paramInt);
    AbsBaseArticleInfo localAbsBaseArticleInfo2 = (AbsBaseArticleInfo)b(paramInt + 1);
    if (localAbsBaseArticleInfo1 != null) {
      localAbsBaseArticleInfo1.mResolvedFeedType = i1;
    }
    paramViewGroup = null;
    this.d.a();
    if ((this.e != null) && (PTSLiteItemViewBuilder.c(localAbsBaseArticleInfo1)))
    {
      paramViewGroup = new ReadInJoyModelImpl(i(), localAbsBaseArticleInfo1, i1, c(), f(), paramInt, u(), t(), localAbsBaseArticleInfo2, g());
      return this.e.a(paramView, localAbsBaseArticleInfo1, paramInt, paramViewGroup);
    }
    int n;
    if ((i1 == 123) && (!ProteusSupportUtil.b(g().F(), i1, localAbsBaseArticleInfo1))) {
      n = 1;
    } else {
      n = 0;
    }
    long l1;
    if ((n == 0) && (ProteusSupportUtil.a(i1)))
    {
      l1 = System.currentTimeMillis();
      paramView = FrameworkHandler.ItemViewBuilder.a(this.d, paramView, localAbsBaseArticleInfo1, localAbsBaseArticleInfo2, i1, paramInt);
      ReadInJoyPTSCostHelper.a("FrameworkHandler", String.valueOf(i1), "getProteusNormalView", System.currentTimeMillis() - l1);
      paramViewGroup = paramView;
      if (localAbsBaseArticleInfo1 != null)
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append("article is normalProteusView: ");
        paramViewGroup.append(localAbsBaseArticleInfo1.mTitle);
        QLog.d("FrameworkHandler", 2, paramViewGroup.toString());
        return paramView;
      }
    }
    else if (FrameworkHandler.ItemViewBuilder.a(this.d).a(i1))
    {
      l1 = System.currentTimeMillis();
      paramView = FrameworkHandler.ItemViewBuilder.b(this.d, paramView, localAbsBaseArticleInfo1, localAbsBaseArticleInfo2, i1, paramInt);
      ReadInJoyPTSCostHelper.a("FrameworkHandler", String.valueOf(i1), "getDynamicProteusView", System.currentTimeMillis() - l1);
      paramViewGroup = paramView;
      if (localAbsBaseArticleInfo1 != null)
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append("article is dynamicProteusView: ");
        paramViewGroup.append(localAbsBaseArticleInfo1.mTitle);
        QLog.d("FrameworkHandler", 2, paramViewGroup.toString());
        return paramView;
      }
    }
    else
    {
      if (i1 == 38)
      {
        l1 = System.currentTimeMillis();
        paramViewGroup = FrameworkHandler.ItemViewBuilder.a(this.d, paramView, localAbsBaseArticleInfo1, paramInt);
        ReadInJoyPTSCostHelper.a("FrameworkHandler", String.valueOf(i1), "getArkAppView", System.currentTimeMillis() - l1);
        paramView = paramViewGroup;
        if (localAbsBaseArticleInfo1 != null)
        {
          paramView = new StringBuilder();
          paramView.append("article is arkAppView: ");
          paramView.append(localAbsBaseArticleInfo1.mTitle);
          QLog.d("FrameworkHandler", 2, paramView.toString());
          paramView = paramViewGroup;
        }
      }
      else
      {
        if (!CellFactory.INSTANCE.cellRebuildCompleted(i1)) {
          return paramViewGroup;
        }
        l1 = System.currentTimeMillis();
        paramViewGroup = FrameworkHandler.ItemViewBuilder.a(this.d, paramView, localAbsBaseArticleInfo1, i1, paramInt);
        ReadInJoyPTSCostHelper.a("FrameworkHandler", String.valueOf(i1), "cellRebuildCompleted", System.currentTimeMillis() - l1);
        paramView = paramViewGroup;
        if (localAbsBaseArticleInfo1 != null)
        {
          paramView = new StringBuilder();
          paramView.append("article is cellRebuildView: ");
          paramView.append(localAbsBaseArticleInfo1.mTitle);
          QLog.d("FrameworkHandler", 2, paramView.toString());
          paramView = paramViewGroup;
        }
      }
      paramViewGroup = paramView;
    }
    return paramViewGroup;
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    super.a(paramInt, paramList);
    paramList = this.f;
    if (paramList != null) {
      paramList.d();
    }
  }
  
  public void a(View paramView, ListView paramListView)
  {
    L();
  }
  
  public void a(View paramView, ListView paramListView, long paramLong)
  {
    a(paramView);
    b(paramView);
    B();
    PTSDeviceUtil.init(i());
    J();
    H();
    I();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.i);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    super.a(paramAbsListView, paramInt);
    if ((c() == 0) || (DailyModeConfigHandler.c(c()))) {
      ReadinjoySPEventReport.a().f.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    e(paramInt1);
    if ((c() == 0) || (DailyModeConfigHandler.c(c()))) {
      ReadinjoySPEventReport.a().f.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)b((int)paramLong);
    if ((DailyModeConfigHandler.c(c())) || (c() == 0))
    {
      ReadinjoySPEventReport.UserOptInfo localUserOptInfo = ReadinjoySPEventReport.a().f;
      paramAdapterView = (AbsListView)paramAdapterView;
      localUserOptInfo.a(paramView, paramAdapterView, localAbsBaseArticleInfo);
      UserActionCollector.a().a(paramView, paramAdapterView, localAbsBaseArticleInfo);
    }
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.j;
    if (localTextView != null)
    {
      localTextView.setText(paramString);
      this.j.setVisibility(0);
    }
  }
  
  public void a(List<? extends AbsBaseArticleInfo> paramList)
  {
    this.c = false;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.m = true;
    if ((c() == 0) || (DailyModeConfigHandler.c(c())))
    {
      ReadinjoySPEventReport.UserOptInfo localUserOptInfo = ReadinjoySPEventReport.a().f;
      ListView localListView;
      if (g() != null) {
        localListView = g().d();
      } else {
        localListView = null;
      }
      localUserOptInfo.onScrollStateChanged(localListView, 6);
    }
    VideoPlayControlUtils.d(e());
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramInt, paramList, paramBoolean2);
    I();
    paramList = this.f;
    if (paramList != null) {
      paramList.c();
    }
  }
  
  public void b(int paramInt, List<ChannelBannerInfo> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onRijChannelBannerRefreshed], channelId = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", list size = ");
    int n;
    if (paramList != null) {
      n = paramList.size();
    } else {
      n = 0;
    }
    localStringBuilder.append(n);
    QLog.i("FrameworkHandler", 1, localStringBuilder.toString());
    if (paramInt != c())
    {
      paramList = new StringBuilder();
      paramList.append("[onRijChannelBannerRefreshed], do not refresh, current channel id = ");
      paramList.append(c());
      QLog.i("FrameworkHandler", 1, paramList.toString());
      return;
    }
    RIJThreadHandler.b().post(new FrameworkHandler.2(this, paramList));
  }
  
  public void c(int paramInt)
  {
    VideoPlayControlUtils.d(e());
  }
  
  public boolean d(int paramInt)
  {
    this.d.a();
    boolean bool2 = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdProteusView(paramInt);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((ProteusSupportUtil.a(paramInt)) || (FrameworkHandler.ItemViewBuilder.a(this.d).a(paramInt)) || (38 == paramInt) || (CellFactory.INSTANCE.cellRebuildCompleted(paramInt)) || (PTSLiteItemViewBuilder.a(paramInt))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void j()
  {
    QLog.d("FrameworkHandler", 2, "doStart!");
  }
  
  public void k()
  {
    this.m = true;
    RIJChannelBannerController localRIJChannelBannerController = this.f;
    if (localRIJChannelBannerController != null) {
      localRIJChannelBannerController.f();
    }
    F();
    G();
    E();
    b(false);
    D();
  }
  
  public void l()
  {
    ReadInJoyVoicePlayController.a().b();
    if ((c() == 0) || (DailyModeConfigHandler.c(c())))
    {
      ReadinjoySPEventReport.UserOptInfo localUserOptInfo = ReadinjoySPEventReport.a().f;
      ListView localListView;
      if (g() != null) {
        localListView = g().d();
      } else {
        localListView = null;
      }
      localUserOptInfo.onScrollStateChanged(localListView, 5);
    }
    VideoPlayControlUtils.b(e());
  }
  
  public void m() {}
  
  public void n()
  {
    ReadInJoyDropFrameHelper.d().b(c(), this);
    PTSLiteItemViewBuilder localPTSLiteItemViewBuilder = this.e;
    if (localPTSLiteItemViewBuilder != null) {
      localPTSLiteItemViewBuilder.b();
    }
    x();
    y();
    K();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.i);
  }
  
  public void o()
  {
    C();
    if ((c() == 0) || (DailyModeConfigHandler.c(c())))
    {
      ReadinjoySPEventReport.UserOptInfo localUserOptInfo = ReadinjoySPEventReport.a().f;
      ListView localListView;
      if (g() != null) {
        localListView = g().d();
      } else {
        localListView = null;
      }
      localUserOptInfo.a(4, localListView);
    }
  }
  
  public void q()
  {
    VideoPlayControlUtils.a(e());
  }
  
  public void r()
  {
    super.r();
    if ((c() == 0) || (DailyModeConfigHandler.c(c()))) {
      ReadinjoySPEventReport.a().f.c();
    }
  }
  
  public int s()
  {
    return 2;
  }
  
  public void x()
  {
    RIJChannelBannerController localRIJChannelBannerController = this.f;
    if (localRIJChannelBannerController != null) {
      localRIJChannelBannerController.e();
    }
  }
  
  public void y()
  {
    StudyModeChangeListener localStudyModeChangeListener = this.g;
    if (localStudyModeChangeListener != null) {
      StudyModeManager.b(localStudyModeChangeListener);
    }
  }
  
  public void z() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.FrameworkHandler
 * JD-Core Version:    0.7.0.1
 */