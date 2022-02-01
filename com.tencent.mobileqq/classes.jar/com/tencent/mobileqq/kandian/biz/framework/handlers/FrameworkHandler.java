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
import com.tencent.mobileqq.kandian.biz.account.api.ICellFactory;
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
import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyPTSCostHelper;
import com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteItemViewBuilder;
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
  private int jdField_a_of_type_Int = 8;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RIJChannelBannerController jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController;
  private RIJChannelBannerView jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerView;
  private FrameworkHandler.ItemViewBuilder jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler$ItemViewBuilder = new FrameworkHandler.ItemViewBuilder(this);
  private PTSLiteItemViewBuilder jdField_a_of_type_ComTencentMobileqqKandianBizPtsLitePTSLiteItemViewBuilder;
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new FrameworkHandler.1(this);
  private StudyModeChangeListener jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener;
  boolean jdField_a_of_type_Boolean = false;
  public boolean b;
  public boolean c;
  private boolean d = true;
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366758));
    if ((a() instanceof ReadInJoyListViewGroup)) {
      ReadInJoyDropFrameHelper.a().a(a(), (FrameworkHandler)((ReadInJoyListViewGroup)a()).a().a());
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    if ((ReadInJoyHelper.j()) && (a() == 0))
    {
      localObject = a();
      if (localObject != null) {}
    }
    else
    {
      bool = false;
      break label43;
    }
    ((RIJDataFetchManager)localObject).b(a());
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
  
  private void b(int paramInt) {}
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369293));
    if ((a() == 0) && (ReadInJoyHelper.m()))
    {
      paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramView.setMargins(paramView.leftMargin, paramView.topMargin, ViewUtils.a(34.0F), ViewUtils.a(184.0F));
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramView);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new FrameworkHandler.3(this));
  }
  
  private void b(List<ChannelBannerInfo> paramList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController == null) {
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController.a(true);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController.a((ChannelBannerInfo)paramList.get(0));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController.a(false);
  }
  
  private void b(boolean paramBoolean)
  {
    label163:
    label168:
    label173:
    for (;;)
    {
      try
      {
        bool2 = StudyModeManager.a();
        if ((bool2 == this.jdField_a_of_type_Boolean) && (!paramBoolean)) {
          return;
        }
        if (a().a().a() == null) {
          return;
        }
        this.jdField_a_of_type_Boolean = bool2;
        if (DailyModeConfigHandler.c(a()))
        {
          if (paramBoolean) {
            break label163;
          }
          return;
        }
        bool1 = this.jdField_a_of_type_Boolean;
        if (a() == 0) {
          break label173;
        }
        if (paramBoolean) {
          break label168;
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
      a().a().a().a(a().a().a(), (ReadInJoyXListView)a(), a().a().a(), a(), bool1, paramBoolean);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController != null) && ((a() instanceof ListView)))
    {
      RIJChannelBannerView localRIJChannelBannerView = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController.a();
      ListView localListView = (ListView)a();
      if (paramBoolean) {
        localListView.removeHeaderView(localRIJChannelBannerView);
      }
    }
    d(paramBoolean);
  }
  
  private void d(boolean paramBoolean)
  {
    boolean bool = a(paramBoolean);
    RIJDataFetchManager localRIJDataFetchManager = a();
    if ((bool) && (!paramBoolean) && (localRIJDataFetchManager != null)) {
      a(true);
    }
  }
  
  private void m()
  {
    if ((a().a().a() instanceof KanDianViewController))
    {
      Activity localActivity = a().a().a();
      if (localActivity.findViewById(2131362020) != null)
      {
        b(true);
        return;
      }
      if (localActivity.findViewById(2131362021) != null) {
        a().a().a().a(a().a().a(), (ReadInJoyXListView)a(), a().a().a(), a());
      }
    }
    else if ((a().a().a() instanceof ReadInJoyDailyViewController))
    {
      ((ReadInJoyDailyViewController)a().a().a()).a((ReadInJoyXListView)a(), a().a().a());
    }
  }
  
  private void n()
  {
    int i;
    if ((!this.b) && (this.c))
    {
      this.b = true;
      this.c = false;
      if (a() == ChannelCoverInfoModule.a())
      {
        PublicTracker.jdField_a_of_type_Int = 1;
      }
      else
      {
        i = a();
        if (i != 0)
        {
          if (i != 56)
          {
            if (i == 70) {
              PublicTracker.jdField_a_of_type_Int = 3;
            }
          }
          else {
            PublicTracker.jdField_a_of_type_Int = 2;
          }
        }
        else {
          PublicTracker.jdField_a_of_type_Int = 1;
        }
      }
      PublicTracker.a("KANDIAN_NEW_FEEDS_LIST_VIEW_GROUP_MEASURE_LAYOUT_DRAW", null);
      PublicTracker.a("KANDIAN_FEEDS_STAGE_2_COST", null);
      PublicTracker.a("KANDIAN_FEEDS_COST", null);
      if (a() == 56) {
        PublicTracker.a("video_tab_cost", null);
      }
    }
    if (this.d)
    {
      this.d = false;
      if (a() == ChannelCoverInfoModule.a())
      {
        PublicTracker.a("recommend_tab_cost", null);
        return;
      }
      i = a();
      if (i != 0)
      {
        if (i != 56)
        {
          if (i != 70) {
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
  
  private void o()
  {
    if (a() != null) {
      VideoPlayControlUtils.a(a(), null, true);
    }
  }
  
  private void p()
  {
    Activity localActivity = a().a().a();
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
      if (ReadInJoyHelper.m()) {
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
  
  private void q()
  {
    if (a() == 0)
    {
      if (RIJNewBiuCardTransformManager.a().a())
      {
        a(false, 1);
        QLog.d("FrameworkHandler", 2, "transformCommentBiuCard | shouldAutoRefresh and backToTop");
      }
      ThreadManager.getUIHandler().postDelayed(new FrameworkHandler.5(this), 500L);
      return;
    }
    RIJNewBiuCardTransformManager.a().c();
    QLog.d("FrameworkHandler", 2, "transformCommentBiuCard | not in recommend feeds and clear biuinfo");
  }
  
  private void r()
  {
    new Handler(Looper.getMainLooper()).post(new FrameworkHandler.6(this));
  }
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerView = new RIJChannelBannerView(a());
    if ((a() instanceof ListView))
    {
      ((ListView)a()).addHeaderView(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerView, 2);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener = new FrameworkHandler.7(this);
      StudyModeManager.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener);
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController != null)
    {
      QLog.i("FrameworkHandler", 1, "[initRijChannelBannerController] controller is not null, do not init again.");
      return;
    }
    if ((PTSLiteSwitchManager.a().a()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController = new RIJChannelBannerController(a(), a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerView);
    }
  }
  
  private void u()
  {
    RIJChannelBannerController localRIJChannelBannerController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController;
    if (localRIJChannelBannerController != null) {
      localRIJChannelBannerController.a();
    }
  }
  
  private void v()
  {
    if ((a() == 0) || (DailyModeConfigHandler.c(a())))
    {
      ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = a();
      if (localReadInJoyBaseListViewGroup != null)
      {
        localReadInJoyBaseListViewGroup.setFocusableInTouchMode(true);
        localReadInJoyBaseListViewGroup.requestFocus();
        localReadInJoyBaseListViewGroup.setOnKeyListener(new FrameworkHandler.8(this));
      }
    }
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    System.currentTimeMillis();
    int j = a(paramInt).intValue();
    AbsBaseArticleInfo localAbsBaseArticleInfo1 = (AbsBaseArticleInfo)a(paramInt);
    AbsBaseArticleInfo localAbsBaseArticleInfo2 = (AbsBaseArticleInfo)a(paramInt + 1);
    if (localAbsBaseArticleInfo1 != null) {
      localAbsBaseArticleInfo1.mResolvedFeedType = j;
    }
    paramViewGroup = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler$ItemViewBuilder.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsLitePTSLiteItemViewBuilder != null) && (PTSLiteItemViewBuilder.b(localAbsBaseArticleInfo1)))
    {
      paramViewGroup = new ReadInJoyModelImpl(a(), localAbsBaseArticleInfo1, j, a(), b(), paramInt, a(), c(), localAbsBaseArticleInfo2, a());
      return this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsLitePTSLiteItemViewBuilder.a(paramView, localAbsBaseArticleInfo1, paramInt, paramViewGroup);
    }
    int i;
    if ((j == 123) && (!ProteusSupportUtil.a(a().a(), j, localAbsBaseArticleInfo1))) {
      i = 1;
    } else {
      i = 0;
    }
    long l;
    if ((i == 0) && (ProteusSupportUtil.a(j)))
    {
      l = System.currentTimeMillis();
      paramView = FrameworkHandler.ItemViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler$ItemViewBuilder, paramView, localAbsBaseArticleInfo1, localAbsBaseArticleInfo2, j, paramInt);
      ((IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class)).printCost("FrameworkHandler", String.valueOf(j), "getProteusNormalView", System.currentTimeMillis() - l);
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
    else if (FrameworkHandler.ItemViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler$ItemViewBuilder).a(j))
    {
      l = System.currentTimeMillis();
      paramView = FrameworkHandler.ItemViewBuilder.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler$ItemViewBuilder, paramView, localAbsBaseArticleInfo1, localAbsBaseArticleInfo2, j, paramInt);
      ((IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class)).printCost("FrameworkHandler", String.valueOf(j), "getDynamicProteusView", System.currentTimeMillis() - l);
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
      if (j == 38)
      {
        l = System.currentTimeMillis();
        paramViewGroup = FrameworkHandler.ItemViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler$ItemViewBuilder, paramView, localAbsBaseArticleInfo1, paramInt);
        ((IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class)).printCost("FrameworkHandler", String.valueOf(j), "getArkAppView", System.currentTimeMillis() - l);
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
        if (!((ICellFactory)QRoute.api(ICellFactory.class)).cellRebuildCompleted(j)) {
          return paramViewGroup;
        }
        l = System.currentTimeMillis();
        paramViewGroup = FrameworkHandler.ItemViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler$ItemViewBuilder, paramView, localAbsBaseArticleInfo1, j, paramInt);
        ((IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class)).printCost("FrameworkHandler", String.valueOf(j), "cellRebuildCompleted", System.currentTimeMillis() - l);
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
  
  public void a()
  {
    QLog.d("FrameworkHandler", 2, "doStart!");
  }
  
  public void a(int paramInt)
  {
    VideoPlayControlUtils.d(a());
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    super.a(paramInt, paramList);
    paramList = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController;
    if (paramList != null) {
      paramList.c();
    }
  }
  
  public void a(View paramView, ListView paramListView)
  {
    v();
  }
  
  public void a(View paramView, ListView paramListView, long paramLong)
  {
    a(paramView);
    b(paramView);
    m();
    PTSDeviceUtil.init(a());
    if (PTSLiteSwitchManager.a().a()) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsLitePTSLiteItemViewBuilder = new PTSLiteItemViewBuilder(a(), a());
    }
    s();
    t();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    super.a(paramAbsListView, paramInt);
    if ((a() == 0) || (DailyModeConfigHandler.c(a()))) {
      ReadinjoySPEventReport.a().a.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1);
    if ((a() == 0) || (DailyModeConfigHandler.c(a()))) {
      ReadinjoySPEventReport.a().a.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)a((int)paramLong);
    if ((DailyModeConfigHandler.c(a())) || (a() == 0))
    {
      ReadinjoySPEventReport.UserOptInfo localUserOptInfo = ReadinjoySPEventReport.a().a;
      paramAdapterView = (AbsListView)paramAdapterView;
      localUserOptInfo.a(paramView, paramAdapterView, localAbsBaseArticleInfo);
      UserActionCollector.a().a(paramView, paramAdapterView, localAbsBaseArticleInfo);
    }
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      localTextView.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void a(List<? extends AbsBaseArticleInfo> paramList)
  {
    this.c = false;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.d = true;
    if ((a() == 0) || (DailyModeConfigHandler.c(a())))
    {
      ReadinjoySPEventReport.UserOptInfo localUserOptInfo = ReadinjoySPEventReport.a().a;
      ListView localListView;
      if (a() != null) {
        localListView = a().a();
      } else {
        localListView = null;
      }
      localUserOptInfo.onScrollStateChanged(localListView, 6);
    }
    VideoPlayControlUtils.d(a());
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramInt, paramList, paramBoolean2);
    t();
    paramList = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController;
    if (paramList != null) {
      paramList.b();
    }
  }
  
  public boolean a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler$ItemViewBuilder.a();
    boolean bool2 = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdProteusView(paramInt);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((ProteusSupportUtil.a(paramInt)) || (FrameworkHandler.ItemViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler$ItemViewBuilder).a(paramInt)) || (38 == paramInt) || (((ICellFactory)QRoute.api(ICellFactory.class)).cellRebuildCompleted(paramInt)) || (PTSLiteItemViewBuilder.a(paramInt))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void b()
  {
    this.d = true;
    RIJChannelBannerController localRIJChannelBannerController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController;
    if (localRIJChannelBannerController != null) {
      localRIJChannelBannerController.e();
    }
    q();
    r();
    p();
    b(false);
    o();
  }
  
  public void b(int paramInt, List<ChannelBannerInfo> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onRijChannelBannerRefreshed], channelId = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", list size = ");
    int i;
    if (paramList != null) {
      i = paramList.size();
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    QLog.i("FrameworkHandler", 1, localStringBuilder.toString());
    if (paramInt != a())
    {
      paramList = new StringBuilder();
      paramList.append("[onRijChannelBannerRefreshed], do not refresh, current channel id = ");
      paramList.append(a());
      QLog.i("FrameworkHandler", 1, paramList.toString());
      return;
    }
    RIJThreadHandler.b().post(new FrameworkHandler.2(this, paramList));
  }
  
  public void c()
  {
    ReadInJoyVoicePlayController.a().a();
    if ((a() == 0) || (DailyModeConfigHandler.c(a())))
    {
      ReadinjoySPEventReport.UserOptInfo localUserOptInfo = ReadinjoySPEventReport.a().a;
      ListView localListView;
      if (a() != null) {
        localListView = a().a();
      } else {
        localListView = null;
      }
      localUserOptInfo.onScrollStateChanged(localListView, 5);
    }
    VideoPlayControlUtils.b(a());
  }
  
  public int d()
  {
    return 2;
  }
  
  public void d() {}
  
  public void e()
  {
    ReadInJoyDropFrameHelper.a().b(a(), this);
    PTSLiteItemViewBuilder localPTSLiteItemViewBuilder = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsLitePTSLiteItemViewBuilder;
    if (localPTSLiteItemViewBuilder != null) {
      localPTSLiteItemViewBuilder.a();
    }
    i();
    j();
    u();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  public void f()
  {
    n();
    if ((a() == 0) || (DailyModeConfigHandler.c(a())))
    {
      ReadinjoySPEventReport.UserOptInfo localUserOptInfo = ReadinjoySPEventReport.a().a;
      ListView localListView;
      if (a() != null) {
        localListView = a().a();
      } else {
        localListView = null;
      }
      localUserOptInfo.a(4, localListView);
    }
  }
  
  public void g()
  {
    VideoPlayControlUtils.a(a());
  }
  
  public void h()
  {
    super.h();
    if ((a() == 0) || (DailyModeConfigHandler.c(a()))) {
      ReadinjoySPEventReport.a().a.a();
    }
  }
  
  public void i()
  {
    RIJChannelBannerController localRIJChannelBannerController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController;
    if (localRIJChannelBannerController != null) {
      localRIJChannelBannerController.d();
    }
  }
  
  public void j()
  {
    StudyModeChangeListener localStudyModeChangeListener = this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener;
    if (localStudyModeChangeListener != null) {
      StudyModeManager.b(localStudyModeChangeListener);
    }
  }
  
  public void k() {}
  
  public void l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.FrameworkHandler
 * JD-Core Version:    0.7.0.1
 */