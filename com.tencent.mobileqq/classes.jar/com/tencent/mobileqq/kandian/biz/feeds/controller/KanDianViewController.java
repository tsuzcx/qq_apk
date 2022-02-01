package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IRecommendADVideoFeedsManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyRainAnimationController;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListViewGroup;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup;
import com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyArticleAdapter;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsInsertModule;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsInsertUtil;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.handlers.FrameworkHandler;
import com.tencent.mobileqq.kandian.biz.framework.handlers.RIJInvokeHandler;
import com.tencent.mobileqq.kandian.biz.pts.network.ReadInJoyPTSCostHelper;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskVideoTimer;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager.OnRefreshChangedListener;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager.OnSkinChangedListener;
import com.tencent.mobileqq.kandian.biz.video.VideoUIManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ForeBackGround;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.IForeBackGroundCallback;
import com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.api.IInsertArticleCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;

public class KanDianViewController
  extends ReadInJoyBaseViewController
  implements ReadInJoyRefreshManager.OnRefreshChangedListener, ReadInJoySkinManager.OnSkinChangedListener, IForeBackGroundCallback
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ReadInJoyRainAnimationController jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyRainAnimationController;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
  private KanDianViewController.SkinChangedHandler jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController$SkinChangedHandler;
  private RIJRewardTaskVideoTimer jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskVideoTimer;
  private VideoUIManager jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager;
  private VideoPlayManager jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
  protected ReadInJoyObserver a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private Activity jdField_b_of_type_AndroidAppActivity;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c;
  private Map<String, Integer> e = new HashMap();
  
  public KanDianViewController(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new KanDianViewController.KandianViewControllerObserver(this);
    this.jdField_b_of_type_AndroidAppActivity = paramActivity;
  }
  
  private long a(ListView paramListView, int paramInt)
  {
    paramInt = paramInt + paramListView.getHeaderViewsCount() - paramListView.getFirstVisiblePosition();
    if ((paramInt >= 0) && (paramInt < paramListView.getChildCount()) && (paramListView.getChildAt(paramInt) != null)) {
      paramInt = paramListView.getChildAt(paramInt).getHeight();
    } else {
      paramInt = 0;
    }
    int i = paramInt;
    if (paramInt <= 0)
    {
      QLog.i("KanDianViewController", 1, "[getScreenCenterOffset] viewHeight is less than 0, make it 600.");
      i = 600;
    }
    long l3 = DeviceInfoUtil.j();
    long l2 = 0L;
    long l1 = l3;
    if (l3 <= 0L)
    {
      QLog.i("KanDianViewController", 1, "[getScreenCenterOffset] deviceHeight is less than 0, make it 1920.");
      l1 = 1920L;
    }
    l3 = (l1 - i) / 2L;
    paramListView = new StringBuilder();
    paramListView.append("[getScreenCenterOffset] deviceHeight = ");
    paramListView.append(l1);
    paramListView.append(", viewHeight = ");
    paramListView.append(i);
    paramListView.append(", res = ");
    paramListView.append(l3);
    QLog.i("KanDianViewController", 1, paramListView.toString());
    l1 = l2;
    if (l3 >= 0L) {
      l1 = l3;
    }
    return l1;
  }
  
  private List<AbsBaseArticleInfo> a()
  {
    Object localObject = ReadInJoyLogicEngine.a().a();
    if ((localObject != null) && (((ArticleInfoModule)localObject).a() != null))
    {
      localObject = ((ArticleInfoModule)localObject).a().a(Integer.valueOf(0));
      return ReadInJoyLogicEngine.a().a(Integer.valueOf(0), (List)localObject);
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    ThreadManager.getUIHandler().postDelayed(new KanDianViewController.4(this, paramInt), 850L);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scrollListToPos, pos=");
    localStringBuilder.append(paramInt);
    QLog.d("KanDianViewController", 1, localStringBuilder.toString());
  }
  
  private void a(int paramInt, String paramString)
  {
    if ((this.e.containsKey(paramString)) && (Aladdin.getConfig(451).getIntegerFromString("auto_scroll", 0) == 1))
    {
      if (paramInt != 1) {
        a(((Integer)this.e.get(paramString)).intValue());
      }
      this.e.remove(paramString);
    }
  }
  
  private void a(IInsertArticleCallback paramIInsertArticleCallback)
  {
    RIJDataFetchManager localRIJDataFetchManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.a();
    List localList = a();
    if ((localList != null) && (localRIJDataFetchManager != null))
    {
      localRIJDataFetchManager.a(localList, 3, paramIInsertArticleCallback);
      return;
    }
    QLog.d("KanDianViewController", 1, "setInsertAdaterData error!");
  }
  
  private void a(ListView paramListView)
  {
    if (paramListView == null) {
      return;
    }
    long l = paramListView.getItemIdAtPosition(paramListView.getFirstVisiblePosition());
    ReadInJoyLogicEngine.a().a(l, 0);
  }
  
  private void a(Long paramLong, List<AbsBaseArticleInfo> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramList.next();
        if (localAbsBaseArticleInfo != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramLong);
          localStringBuilder.append("");
          if (TextUtils.equals(localStringBuilder.toString(), localAbsBaseArticleInfo.mSubscribeID))
          {
            int i = RIJFeedsDynamicInsertController.INSTANCE.findReqSourceByRowkey(localAbsBaseArticleInfo.innerUniqueID);
            if (i == 1) {
              RIJFeedsDynamicInsertController.INSTANCE.requestDynamicInsertInTL(localAbsBaseArticleInfo, new RIJFeedsInsertAction(ActionType.ACTION_FOLLOW, 0, 0, 0));
            } else {
              RIJFeedsDynamicInsertController.INSTANCE.requestInsertArticlesAndRecordAction(localAbsBaseArticleInfo.innerUniqueID, new RIJFeedsInsertAction(ActionType.ACTION_FOLLOW, 0, 0, 0), i);
            }
          }
        }
      }
    }
  }
  
  private boolean a(String paramString, List<AbsBaseArticleInfo> paramList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramList != null)
    {
      Object localObject = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup).a().a().a();
      paramList = RIJFeedsInsertUtil.a.a((List)localObject, paramList);
      localObject = RIJFeedsDynamicInsertController.INSTANCE.getFeedsInsertModule();
      if (localObject != null) {
        ((RIJFeedsInsertModule)localObject).a(0L, paramString, paramList);
      }
      paramString = new StringBuilder();
      paramString.append("saveDynamicArticles, size: ");
      paramString.append(paramList.size());
      QLog.d("KanDianViewController", 1, paramString.toString());
      bool1 = bool2;
      if (paramList.size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void l()
  {
    Object localObject = this.jdField_b_of_type_AndroidAppActivity;
    if ((localObject instanceof BaseActivity))
    {
      localObject = ((BaseActivity)localObject).getAppInterface();
      if (localObject != null)
      {
        ReadInJoySkinManager localReadInJoySkinManager = (ReadInJoySkinManager)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyRainAnimationController = new ReadInJoyRainAnimationController(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup, this.jdField_b_of_type_AndroidAppActivity);
        if (localReadInJoySkinManager != null) {
          localReadInJoySkinManager.a(this);
        }
        localObject = (ReadInJoyRefreshManager)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
        if (localObject != null) {
          ((ReadInJoyRefreshManager)localObject).a(this);
        }
      }
    }
  }
  
  private void n()
  {
    Object localObject = this.jdField_b_of_type_AndroidAppActivity;
    if ((localObject instanceof BaseActivity))
    {
      localObject = ((BaseActivity)localObject).getAppInterface();
      if (localObject != null)
      {
        ReadInJoySkinManager localReadInJoySkinManager = (ReadInJoySkinManager)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
        localReadInJoySkinManager.b(this);
        localReadInJoySkinManager.a();
        localObject = (ReadInJoyRefreshManager)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
        ((ReadInJoyRefreshManager)localObject).b(this);
        ((ReadInJoyRefreshManager)localObject).a();
      }
    }
  }
  
  private void o()
  {
    ((KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).d();
  }
  
  private void p()
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if ((localReadInJoyBaseListViewGroup != null) && ((localReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)localReadInJoyBaseListViewGroup).a(new KanDianViewController.PullRefreshCompleteListener(this));
    }
  }
  
  public Activity a()
  {
    return this.jdField_b_of_type_AndroidAppActivity;
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
  }
  
  public VideoPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup).setRefreshHeader(paramInt);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    paramLogoutReason = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if ((paramLogoutReason != null) && ((paramLogoutReason instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)paramLogoutReason).o();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    a(paramBoolean, 1);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    super.a(paramBoolean, paramInt);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.a(paramBoolean, paramInt);
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void aw_()
  {
    super.aw_();
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager = new VideoPlayManager(this.jdField_a_of_type_AndroidAppActivity);
    Map localMap = this.jdField_b_of_type_JavaUtilMap;
    int i = 0;
    localMap.put(Integer.valueOf(0), Boolean.valueOf(true));
    if (ChannelCoverInfoModule.a() != -1) {
      i = ChannelCoverInfoModule.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup = new ReadInJoyListViewGroup(this, i, null);
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup).setNotifyEndRefresh(new KanDianViewController.1(this));
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup).a(new KanDianViewController.PullRefreshCompleteListener(this));
    l();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager = new VideoUIManager((FrameLayout)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.findViewById(2131380736), (ReadInJoyBaseListView)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.findViewById(2131378123), this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    ReadInJoyLogicEngine.a().b();
    b();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController$SkinChangedHandler = new KanDianViewController.SkinChangedHandler(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskVideoTimer = new RIJRewardTaskVideoTimer();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskVideoTimer.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager);
    ReadinjoySPEventReport.ForeBackGround.a(this);
  }
  
  public void ax_()
  {
    QLog.d("KanDianViewController", 2, "[onAppStatusChange] switch to background, report and clear");
    k();
  }
  
  public void b()
  {
    super.b();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    Integer localInteger = Integer.valueOf(0);
    if (localObject != null)
    {
      ((ReadInJoyBaseListViewGroup)localObject).a(a(localInteger), b(localInteger));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.c(this.d);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.b(this.jdField_b_of_type_JavaUtilMap);
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
      if ((localObject instanceof ReadInJoyListViewGroup))
      {
        localObject = ((ReadInJoyListViewGroup)localObject).a().a();
        if (localObject != null) {
          ((IRecommendADVideoFeedsManager)localObject).a();
        }
      }
    }
    if (!this.jdField_b_of_type_Boolean) {
      o();
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean b()
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if ((localReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      return ((ReadInJoyListViewGroup)localReadInJoyBaseListViewGroup).a();
    }
    return false;
  }
  
  public void c()
  {
    super.c();
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if (localReadInJoyBaseListViewGroup != null) {
      localReadInJoyBaseListViewGroup.a(b(Integer.valueOf(0)), a(Integer.valueOf(0)));
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Boolean) {
      o();
    }
  }
  
  public void e()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    super.e();
    n();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if (localObject != null) {
      ((VideoPlayManager)localObject).d();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.a(b(Integer.valueOf(0)), a(Integer.valueOf(0)));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.a(this.jdField_b_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.f();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.d.clear();
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyRainAnimationController;
    if (localObject != null) {
      ((ReadInJoyRainAnimationController)localObject).a();
    }
    ReadinjoySPEventReport.ForeBackGround.b(this);
    ReadInJoyPTSCostHelper.b();
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.d();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.e();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void h()
  {
    super.h();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskVideoTimer;
    if (localObject != null) {
      ((RIJRewardTaskVideoTimer)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if (localObject != null) {
      ((VideoPlayManager)localObject).e();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.c();
    localObject = this.jdField_b_of_type_AndroidAppActivity;
    if ((localObject instanceof BaseActivity))
    {
      localObject = ((BaseActivity)localObject).getAppInterface();
      if ((localObject != null) && (((ReadInJoySkinManager)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a() == 1) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyRainAnimationController != null)) {
        ThreadManager.post(new KanDianViewController.2(this), 8, null, true);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if ((localObject instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)localObject).j();
    }
  }
  
  public void i()
  {
    super.i();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if ((localObject1 instanceof ReadInJoyListViewGroup)) {
      localObject1 = ((ReadInJoyListViewGroup)localObject1).a();
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskVideoTimer;
    if (localObject2 != null) {
      ((RIJRewardTaskVideoTimer)localObject2).a();
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if ((localObject2 != null) && (localObject1 != null))
    {
      localObject2 = ((VideoPlayManager)localObject2).a();
      if ((localObject2 != null) && (((VideoPlayParam)localObject2).jdField_b_of_type_Boolean)) {
        ((ReadInJoyBaseAdapter)localObject1).e(true);
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if (localObject1 != null) {
      ((VideoPlayManager)localObject1).d(0);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.b();
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if ((localObject1 instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)localObject1).k();
    }
    RIJFeedsDynamicInsertController.INSTANCE.requestDynamicInsertBackToTL();
  }
  
  public void j()
  {
    Object localObject = this.jdField_b_of_type_AndroidAppActivity;
    if ((localObject instanceof BaseActivity))
    {
      localObject = ((BaseActivity)localObject).getAppInterface();
      if ((localObject != null) && (((ReadInJoySkinManager)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a() == 1) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyRainAnimationController != null)) {
        ThreadManager.post(new KanDianViewController.3(this), 8, null, true);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskVideoTimer;
    if (localObject != null) {
      ((RIJRewardTaskVideoTimer)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if (localObject != null)
    {
      ((VideoPlayManager)localObject).a(ReportConstants.VideoEndType.EXIT_SCENE);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.e();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if (localObject != null) {
      ((ReadInJoyBaseListViewGroup)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if ((localObject instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)localObject).j();
    }
  }
  
  public void k()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if ((localObject instanceof ReadInJoyListViewGroup))
    {
      localObject = (ReadInJoyListViewGroup)localObject;
      Map localMap1 = a(Integer.valueOf(0));
      Map localMap2 = ReadinjoyReportUtils.a(0);
      ThreadManager.executeOnSubThread(new KanDianViewController.5(this, (ReadInJoyListViewGroup)localObject, localMap1, a(Integer.valueOf(0)), localMap2, RIJKanDianFolderStatus.getFolderStatus(0)));
      b(Integer.valueOf(0)).clear();
      ((ReadInJoyListViewGroup)localObject).d(this.d);
      this.d.clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
      a(((ReadInJoyListViewGroup)localObject).a());
      localObject = (FrameworkHandler)((ReadInJoyListViewGroup)localObject).a().a(2);
      if (localObject != null) {
        ((FrameworkHandler)localObject).i();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.KanDianViewController
 * JD-Core Version:    0.7.0.1
 */