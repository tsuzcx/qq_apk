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
  protected ReadInJoyObserver a = new KanDianViewController.KandianViewControllerObserver(this);
  private ReadInJoyBaseListViewGroup i;
  private boolean j = false;
  private boolean k = true;
  private Activity l;
  private ViewGroup m;
  private ReadInJoyRainAnimationController n;
  private KanDianViewController.SkinChangedHandler o;
  private String p;
  private boolean q = false;
  private VideoPlayManager r;
  private VideoUIManager s;
  private RIJRewardTaskVideoTimer t;
  private Map<String, Integer> u = new HashMap();
  
  public KanDianViewController(Activity paramActivity)
  {
    super(paramActivity);
    this.l = paramActivity;
  }
  
  private long a(ListView paramListView, int paramInt)
  {
    paramInt = paramInt + paramListView.getHeaderViewsCount() - paramListView.getFirstVisiblePosition();
    if ((paramInt >= 0) && (paramInt < paramListView.getChildCount()) && (paramListView.getChildAt(paramInt) != null)) {
      paramInt = paramListView.getChildAt(paramInt).getHeight();
    } else {
      paramInt = 0;
    }
    int i1 = paramInt;
    if (paramInt <= 0)
    {
      QLog.i("KanDianViewController", 1, "[getScreenCenterOffset] viewHeight is less than 0, make it 600.");
      i1 = 600;
    }
    long l3 = DeviceInfoUtil.E();
    long l2 = 0L;
    long l1 = l3;
    if (l3 <= 0L)
    {
      QLog.i("KanDianViewController", 1, "[getScreenCenterOffset] deviceHeight is less than 0, make it 1920.");
      l1 = 1920L;
    }
    l3 = (l1 - i1) / 2L;
    paramListView = new StringBuilder();
    paramListView.append("[getScreenCenterOffset] deviceHeight = ");
    paramListView.append(l1);
    paramListView.append(", viewHeight = ");
    paramListView.append(i1);
    paramListView.append(", res = ");
    paramListView.append(l3);
    QLog.i("KanDianViewController", 1, paramListView.toString());
    l1 = l2;
    if (l3 >= 0L) {
      l1 = l3;
    }
    return l1;
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
    if ((this.u.containsKey(paramString)) && (Aladdin.getConfig(451).getIntegerFromString("auto_scroll", 0) == 1))
    {
      if (paramInt != 1) {
        a(((Integer)this.u.get(paramString)).intValue());
      }
      this.u.remove(paramString);
    }
  }
  
  private void a(IInsertArticleCallback paramIInsertArticleCallback)
  {
    RIJDataFetchManager localRIJDataFetchManager = this.i.getDataFetchManager();
    List localList = x();
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
    long l1 = paramListView.getItemIdAtPosition(paramListView.getFirstVisiblePosition());
    ReadInJoyLogicEngine.a().a(l1, 0);
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
            int i1 = RIJFeedsDynamicInsertController.INSTANCE.findReqSourceByRowkey(localAbsBaseArticleInfo.innerUniqueID);
            if (i1 == 1) {
              RIJFeedsDynamicInsertController.INSTANCE.requestDynamicInsertInTL(localAbsBaseArticleInfo, new RIJFeedsInsertAction(ActionType.ACTION_FOLLOW, 0, 0, 0));
            } else {
              RIJFeedsDynamicInsertController.INSTANCE.requestInsertArticlesAndRecordAction(localAbsBaseArticleInfo.innerUniqueID, new RIJFeedsInsertAction(ActionType.ACTION_FOLLOW, 0, 0, 0), i1);
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
      Object localObject = ((ReadInJoyListViewGroup)this.i).getAdapter().E().b();
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
  
  private void u()
  {
    Object localObject = this.l;
    if ((localObject instanceof BaseActivity))
    {
      localObject = ((BaseActivity)localObject).getAppInterface();
      if (localObject != null)
      {
        ReadInJoySkinManager localReadInJoySkinManager = (ReadInJoySkinManager)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
        this.n = new ReadInJoyRainAnimationController(this.i, this.l);
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
  
  private void v()
  {
    Object localObject = this.l;
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
  
  private void w()
  {
    ((KandianMergeManager)ReadInJoyUtils.b().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).o();
  }
  
  private List<AbsBaseArticleInfo> x()
  {
    Object localObject = ReadInJoyLogicEngine.a().ab();
    if ((localObject != null) && (((ArticleInfoModule)localObject).i() != null))
    {
      localObject = ((ArticleInfoModule)localObject).i().b(Integer.valueOf(0));
      return ReadInJoyLogicEngine.a().a(Integer.valueOf(0), (List)localObject);
    }
    return null;
  }
  
  private void y()
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = this.i;
    if ((localReadInJoyBaseListViewGroup != null) && ((localReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)localReadInJoyBaseListViewGroup).a(new KanDianViewController.PullRefreshCompleteListener(this));
    }
  }
  
  public void a()
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = this.i;
    if ((localReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)localReadInJoyBaseListViewGroup).u();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.i.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    ((ReadInJoyListViewGroup)this.i).setRefreshHeader(paramInt);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    this.m = paramViewGroup;
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    paramLogoutReason = this.i;
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
    this.q = false;
    this.i.a(paramBoolean, paramInt);
  }
  
  public void b()
  {
    super.b();
    Object localObject = this.i;
    Integer localInteger = Integer.valueOf(0);
    if (localObject != null)
    {
      ((ReadInJoyBaseListViewGroup)localObject).a(c(localInteger), d(localInteger));
      this.i.c(this.f);
      this.i.b(this.d);
      localObject = this.i;
      if ((localObject instanceof ReadInJoyListViewGroup))
      {
        localObject = ((ReadInJoyListViewGroup)localObject).getAdapter().S();
        if (localObject != null) {
          ((IRecommendADVideoFeedsManager)localObject).a();
        }
      }
    }
    if (!this.k) {
      w();
    }
    this.k = false;
  }
  
  public void c()
  {
    super.c();
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = this.i;
    if (localReadInJoyBaseListViewGroup != null) {
      localReadInJoyBaseListViewGroup.a(d(Integer.valueOf(0)), b(Integer.valueOf(0)));
    }
  }
  
  public Activity cQ_()
  {
    return this.l;
  }
  
  public void cR_()
  {
    Object localObject = this.i;
    if ((localObject instanceof ReadInJoyListViewGroup))
    {
      localObject = (ReadInJoyListViewGroup)localObject;
      Map localMap1 = a(Integer.valueOf(0));
      Map localMap2 = ReadinjoyReportUtils.a(0);
      ThreadManager.executeOnSubThread(new KanDianViewController.5(this, (ReadInJoyListViewGroup)localObject, localMap1, b(Integer.valueOf(0)), localMap2, RIJKanDianFolderStatus.getFolderStatus(0)));
      d(Integer.valueOf(0)).clear();
      ((ReadInJoyListViewGroup)localObject).d(this.f);
      this.f.clear();
      this.c.clear();
      a(((ReadInJoyListViewGroup)localObject).getListView());
      localObject = (FrameworkHandler)((ReadInJoyListViewGroup)localObject).getInvokeHandler().a(2);
      if (localObject != null) {
        ((FrameworkHandler)localObject).x();
      }
    }
  }
  
  public void cT_()
  {
    super.cT_();
    this.r = new VideoPlayManager(this.b);
    Map localMap = this.d;
    int i1 = 0;
    localMap.put(Integer.valueOf(0), Boolean.valueOf(true));
    if (ChannelCoverInfoModule.g() != -1) {
      i1 = ChannelCoverInfoModule.g();
    }
    this.i = new ReadInJoyListViewGroup(this, i1, null);
    ((ReadInJoyListViewGroup)this.i).setNotifyEndRefresh(new KanDianViewController.1(this));
    ((ReadInJoyListViewGroup)this.i).a(new KanDianViewController.PullRefreshCompleteListener(this));
    u();
    this.s = new VideoUIManager((FrameLayout)this.i.findViewById(2131449704), (ReadInJoyBaseListView)this.i.findViewById(2131446630), this.b);
    this.r.a(this.s);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.a);
    ReadInJoyLogicEngine.a().v();
    b();
    this.o = new KanDianViewController.SkinChangedHandler(this);
    this.t = new RIJRewardTaskVideoTimer();
    this.t.a(this.r);
    ReadinjoySPEventReport.ForeBackGround.a(this);
  }
  
  public void cU_()
  {
    QLog.d("KanDianViewController", 2, "[onAppStatusChange] switch to background, report and clear");
    cR_();
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = this.i;
    if ((localReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)localReadInJoyBaseListViewGroup).t();
    }
  }
  
  public void e()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.a);
    super.e();
    v();
    Object localObject = this.r;
    if (localObject != null) {
      ((VideoPlayManager)localObject).w();
    }
    this.i.a(d(Integer.valueOf(0)), b(Integer.valueOf(0)));
    this.i.a(this.d);
    this.i.f();
    this.c.clear();
    this.e.clear();
    this.d.clear();
    this.f.clear();
    localObject = this.n;
    if (localObject != null) {
      ((ReadInJoyRainAnimationController)localObject).a();
    }
    ReadinjoySPEventReport.ForeBackGround.b(this);
    ReadInJoyPTSCostHelper.b();
  }
  
  public void f()
  {
    super.f();
    this.i.d();
    this.j = true;
  }
  
  public void g()
  {
    super.g();
    this.i.e();
    this.j = false;
  }
  
  public void h()
  {
    super.h();
    Object localObject = this.t;
    if (localObject != null) {
      ((RIJRewardTaskVideoTimer)localObject).b();
    }
    localObject = this.r;
    if (localObject != null) {
      ((VideoPlayManager)localObject).z();
    }
    this.i.c();
    localObject = this.l;
    if ((localObject instanceof BaseActivity))
    {
      localObject = ((BaseActivity)localObject).getAppInterface();
      if ((localObject != null) && (((ReadInJoySkinManager)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).c() == 1) && (this.n != null)) {
        ThreadManager.post(new KanDianViewController.2(this), 8, null, true);
      }
    }
    localObject = this.i;
    if ((localObject instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)localObject).j();
    }
  }
  
  public void i()
  {
    super.i();
    Object localObject1 = this.i;
    if ((localObject1 instanceof ReadInJoyListViewGroup)) {
      localObject1 = ((ReadInJoyListViewGroup)localObject1).getAdapter();
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.t;
    if (localObject2 != null) {
      ((RIJRewardTaskVideoTimer)localObject2).a();
    }
    localObject2 = this.r;
    if ((localObject2 != null) && (localObject1 != null))
    {
      localObject2 = ((VideoPlayManager)localObject2).a();
      if ((localObject2 != null) && (((VideoPlayParam)localObject2).M)) {
        ((ReadInJoyBaseAdapter)localObject1).e(true);
      }
    }
    localObject1 = this.r;
    if (localObject1 != null) {
      ((VideoPlayManager)localObject1).d(0);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.a);
    this.i.b();
    localObject1 = this.i;
    if ((localObject1 instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)localObject1).k();
    }
    RIJFeedsDynamicInsertController.INSTANCE.requestDynamicInsertBackToTL();
  }
  
  public VideoPlayManager j()
  {
    return this.r;
  }
  
  public boolean k()
  {
    return this.q;
  }
  
  public ViewGroup l()
  {
    return this.i;
  }
  
  public void m()
  {
    if (this.j) {
      w();
    }
  }
  
  public void n()
  {
    Object localObject = this.l;
    if ((localObject instanceof BaseActivity))
    {
      localObject = ((BaseActivity)localObject).getAppInterface();
      if ((localObject != null) && (((ReadInJoySkinManager)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).c() == 1) && (this.n != null)) {
        ThreadManager.post(new KanDianViewController.3(this), 8, null, true);
      }
    }
    localObject = this.t;
    if (localObject != null) {
      ((RIJRewardTaskVideoTimer)localObject).b();
    }
    localObject = this.r;
    if (localObject != null)
    {
      ((VideoPlayManager)localObject).a(ReportConstants.VideoEndType.EXIT_SCENE);
      this.r.z();
    }
    localObject = this.i;
    if (localObject != null) {
      ((ReadInJoyBaseListViewGroup)localObject).c();
    }
    localObject = this.i;
    if ((localObject instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)localObject).j();
    }
  }
  
  public boolean p()
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = this.i;
    if ((localReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      return ((ReadInJoyListViewGroup)localReadInJoyBaseListViewGroup).r();
    }
    return false;
  }
  
  public void q()
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = this.i;
    if ((localReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)localReadInJoyBaseListViewGroup).v();
    }
  }
  
  public void r()
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = this.i;
    if ((localReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)localReadInJoyBaseListViewGroup).w();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.KanDianViewController
 * JD-Core Version:    0.7.0.1
 */