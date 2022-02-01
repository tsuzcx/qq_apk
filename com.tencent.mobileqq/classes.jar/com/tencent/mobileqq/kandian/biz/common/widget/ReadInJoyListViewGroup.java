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
import com.tencent.mobileqq.studymode.StudyModeManager;
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
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ReadInJoyListViewGroup.8(this);
  protected IFaceDecoder a;
  RIJDataFetchManager jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager;
  private ReadInJoyArticleAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter;
  NotifyEndRefresh jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkNotifyEndRefresh;
  RIJFrameworkHeaderManager jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJFrameworkHeaderManager;
  RIJListViewGroupHandlerClick.Builder jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick$Builder;
  RIJListViewGroupHandlerClick jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick;
  RIJInvokeHandler jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler;
  RIJTipMessageManager jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager;
  private ColumnSubscribeChangeObserver jdField_a_of_type_ComTencentMobileqqKandianBizUgcManagecolumnColumnSubscribeChangeObserver = new ReadInJoyListViewGroup.11(this);
  RIJFrameworkReportManager jdField_a_of_type_ComTencentMobileqqKandianGlueReportRIJFrameworkReportManager;
  RIJVideoReportManager jdField_a_of_type_ComTencentMobileqqKandianGlueVideoReportRIJVideoReportManager;
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyListViewGroup.10(this);
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new ReadInJoyListViewGroup.6(this);
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Function1<Canvas, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1 = new ReadInJoyListViewGroup.12(this);
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private Function1<Canvas, Unit> jdField_b_of_type_KotlinJvmFunctionsFunction1 = new ReadInJoyListViewGroup.13(this);
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = -1L;
  
  public ReadInJoyListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt1, int paramInt2, int paramInt3, ReadInJoyPageItemCache paramReadInJoyPageItemCache)
  {
    this(paramReadInJoyBaseViewController, paramInt1, paramInt2, paramInt3, paramReadInJoyPageItemCache, 2131560288);
  }
  
  public ReadInJoyListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt1, int paramInt2, int paramInt3, ReadInJoyPageItemCache paramReadInJoyPageItemCache, int paramInt4)
  {
    super(paramReadInJoyBaseViewController, paramInt1, paramReadInJoyPageItemCache);
    this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(paramInt4, this);
    this.jdField_b_of_type_Long = paramInt3;
    setId(2131376095);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler = new RIJInvokeHandler();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueReportRIJFrameworkReportManager = new RIJFrameworkReportManager();
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoReportRIJVideoReportManager = new RIJVideoReportManager();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick = new RIJListViewGroupHandlerClick();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJFrameworkHeaderManager = new RIJFrameworkHeaderManager();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache.jdField_c_of_type_Long = ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager = new RIJDataFetchManager(new RIJDataFetchManager.Builder().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache).a(this.jdField_a_of_type_Int).a(a()).a(this.jdField_b_of_type_Long).d(paramInt2).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJFrameworkHeaderManager).a(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick$Builder = new RIJListViewGroupHandlerClick.Builder().a(this.jdField_a_of_type_Int).a(a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager = new RIJTipMessageManager(new RIJTipMessageManager.Builder().a(this.jdField_a_of_type_Int).a(a()));
    a(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick$Builder.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView);
  }
  
  public ReadInJoyListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt1, int paramInt2, ReadInJoyPageItemCache paramReadInJoyPageItemCache)
  {
    this(paramReadInJoyBaseViewController, paramInt1, paramInt2, -1, paramReadInJoyPageItemCache);
  }
  
  public ReadInJoyListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt, ReadInJoyPageItemCache paramReadInJoyPageItemCache)
  {
    this(paramReadInJoyBaseViewController, paramInt, -1, paramReadInJoyPageItemCache);
  }
  
  public static AbsBaseArticleInfo a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return RIJListViewGroupHandlerClick.a(paramAbsBaseArticleInfo);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131378123));
    if (paramInt1 == 41695)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJFrameworkHeaderManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView, a());
      RIJDataFetchManager.a(this.jdField_a_of_type_Int);
    }
    if (paramInt1 == 56) {
      this.jdField_a_of_type_Long = a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
    }
    if (DailyModeConfigHandler.c(this.jdField_a_of_type_Int)) {
      ReadinjoySensorUtils.a().a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)((BaseActivity)a()).app.getRuntimeService(IQQAvatarService.class, "")).getInstance(((BaseActivity)a()).app);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter = new ReadInJoyArticleAdapter(a(), a().getLayoutInflater(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a());
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler;
    ((RIJInvokeHandler)localObject).a(((RIJInvokeHandler)localObject).a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView, this.jdField_b_of_type_Long);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initUI before mListView.setPadding :");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController);
      ((StringBuilder)localObject).append(a());
      QLog.d("ReadInJoyListViewGroup", 2, ((StringBuilder)localObject).toString());
    }
    s();
    b(paramInt2);
    u();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJFrameworkHeaderManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView, a(), this.jdField_a_of_type_Int);
    ((BaseActivity)a()).app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager.i();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcManagecolumnColumnSubscribeChangeObserver);
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
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        QLog.d(((StringBuilder)localObject).toString(), 1, localStringBuilder1.toString());
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter.b) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter.a(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter.b = true;
      VideoBehaviorsReporter.a().c(true);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter.b(0);
      a(paramInt1, paramBoolean);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter.isEmpty())
    {
      if (this.jdField_a_of_type_Int == 70)
      {
        a(getResources().getString(2131717926), getResources().getDrawable(2130849691));
        return;
      }
      a(getResources().getString(2131718010));
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (((paramInt == 56) || (paramInt == 0)) && (ReadInJoyUtils.a() != null)) {
      ((IRIJADExposureService)RIJQQAppInterfaceUtil.a().getRuntimeService(IRIJADExposureService.class)).reportInvalidADExposure(getContext(), paramInt);
    }
    if (paramInt == 70) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setNoMoreData(paramBoolean);
    }
    if ((paramInt == 0) || (DailyModeConfigHandler.c(this.jdField_a_of_type_Int))) {
      ReadinjoySPEventReport.a().a.a(2, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView);
    }
  }
  
  private void a(String paramString)
  {
    a(paramString, null);
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    findViewById(2131373730).setVisibility(8);
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = ((ViewStub)findViewById(2131371772)).inflate();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376052));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376051));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setEmptyView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    if (paramDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      if (this.jdField_a_of_type_Int == 70)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-4473925);
        ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = AIOUtils.b(20.0F, getResources());
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130839274));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166925));
      ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = AIOUtils.b(10.0F, getResources());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJFrameworkHeaderManager.a(this, this.jdField_a_of_type_Int);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter.c(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter.c(this.jdField_b_of_type_Long);
    ListenerBuilder localListenerBuilder = new ListenerBuilder().a(this).a(this).a(this).a(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter.a(localListenerBuilder);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter);
  }
  
  private void b(boolean paramBoolean, int paramInt)
  {
    if (b())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.g();
      return;
    }
    String str;
    if (this.jdField_a_of_type_Int == 70)
    {
      if ((paramBoolean) && (paramInt > 0)) {
        str = getResources().getString(2131717930);
      } else {
        str = getResources().getString(2131717929);
      }
    }
    else if (this.jdField_a_of_type_Int == 40677)
    {
      if ((paramBoolean) && (paramInt > 0)) {
        str = String.format(getResources().getString(2131717753), new Object[] { Integer.valueOf(paramInt * 2) });
      } else {
        str = getResources().getString(2131717752);
      }
    }
    else if (this.jdField_a_of_type_Int == 40531)
    {
      if ((paramBoolean) && (paramInt > 0)) {
        str = String.format(getResources().getString(2131717753), new Object[] { Integer.valueOf(paramInt) });
      } else {
        str = getResources().getString(2131717751);
      }
    }
    else if ((paramBoolean) && (paramInt > 0)) {
      str = String.format(getResources().getString(2131717753), new Object[] { Integer.valueOf(paramInt) });
    } else {
      str = getResources().getString(2131717752);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.a(true, str);
    if (RIJShowKanDianTabSp.c()) {
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.5(this), 1500L);
    }
  }
  
  private boolean b()
  {
    boolean bool = a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", false);
    a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", false);
    return bool;
  }
  
  private void c(int paramInt)
  {
    if (RecommendFeedsDiandianEntranceManager.isFollowOrTribeFeedsType(ReadInJoyHelper.e()))
    {
      QLog.d("ReadInJoyListViewGroup", 1, "request 0xdcb");
      RecommendFeedsDiandianEntranceManager.getInstance().checkAndReqRefreshDianDianIcon();
      return;
    }
    QLog.d("ReadInJoyListViewGroup", 1, "request 0x6cf");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.c(paramInt);
  }
  
  private void s()
  {
    if (!RIJKanDianOverDrawOptimizeAladdinConfig.a())
    {
      QLog.d("ReadInJoyListViewGroup", 2, "ListView overdraw switch close");
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setContentBackground(2130838739);
      int i = Color.parseColor("#f8f8f8");
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setBackgroundColor(i);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.a(0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setChannelId(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setRefreshCallback(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setOnItemLongClickListener(this);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setOverScrollTouchMode(1);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setOverScrollFlingMode(1);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a);
    if ((this.jdField_a_of_type_Int == 0) || (DailyModeConfigHandler.c(this.jdField_a_of_type_Int))) {
      UserActionCollector.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView, this.jdField_a_of_type_Int);
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_Int == 70) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.jdField_c_of_type_Int = 0;
    }
    if ((this.jdField_a_of_type_Int == 56) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a().g()))
    {
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJFrameworkHeaderManager.a() == null) {
        i = 0;
      } else {
        i = 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setSelectionFromTop(i, 0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a().a(false);
    }
    if ((DailyModeConfigHandler.a(this.jdField_a_of_type_Int)) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView instanceof ReadInJoyDailyXListView))) {
      ((ReadInJoyDailyXListView)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView).j();
    }
  }
  
  private void u()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = findViewById(2131373730);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJFrameworkHeaderManager.a(this, this.jdField_a_of_type_Int);
  }
  
  public RIJDataFetchManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager;
  }
  
  public ReadInJoyArticleAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter;
  }
  
  public RIJFrameworkHeaderManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJFrameworkHeaderManager;
  }
  
  public RIJInvokeHandler a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler;
  }
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkNotifyEndRefresh;
    if (localObject != null) {
      ((NotifyEndRefresh)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a().c());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter;
    if (localObject != null) {
      ((ReadInJoyArticleAdapter)localObject).a(2, null);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.e();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshListByChannelID channelID = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" mChannelID = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.i("ReadInJoyListViewGroup", 2, localStringBuilder.toString());
    }
    if ((paramInt == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter != null)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.b(true, 1001, true);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(paramInt1, paramInt2, paramIntent);
    RIJActivityResultHandler localRIJActivityResultHandler = new RIJActivityResultHandler(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter, a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager);
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter.a(paramInt, paramIntent);
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a(paramInt, paramAbsBaseArticleInfo, paramString1, paramString2);
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    PublicTracker.a(null, "KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED");
    if (paramInt == this.jdField_a_of_type_Int)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(paramInt, paramList);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a(paramInt, paramList, new ReadInJoyListViewGroup.4(this));
      PublicTracker.a("KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED", null);
      PublicTracker.a("KANDIAN_NEW_FEEDS_LOAD_ARTICLE", null);
      PublicTracker.a(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE_FINISH_TO_MEASURE");
    }
  }
  
  public void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(paramContext, paramAbsBaseArticleInfo, paramString, paramInt2);
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((paramConfiguration != null) && (paramConfiguration.hashCode() != this.jdField_c_of_type_Int))
    {
      if ((!LiuHaiUtils.e()) && (!LiuHaiUtils.d())) {
        return;
      }
      this.jdField_c_of_type_Int = paramConfiguration.hashCode();
      ThreadManager.getUIHandler().post(new ReadInJoyListViewGroup.7(this));
    }
  }
  
  public void a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(paramView, paramAbsBaseArticleInfo, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick.a(paramView, paramAbsBaseArticleInfo, paramInt, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick$Builder);
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a().b(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(paramReadInJoyBaseListView, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueReportRIJFrameworkReportManager.a(this.jdField_a_of_type_Int, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.b();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.h();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJFrameworkHeaderManager.a();
    if (this.jdField_a_of_type_Int == 0) {
      ReadinjoyReportUtils.d();
    }
    c(paramInt);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam1, VideoPlayParam paramVideoPlayParam2)
  {
    ((FrameworkHandler)this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(2)).l();
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, View paramView, int paramInt, long paramLong)
  {
    if (RIJFeedsType.h(paramAbsBaseArticleInfo))
    {
      boolean bool = RIJFeedsType.D(paramAbsBaseArticleInfo);
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
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick.b(paramAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick$Builder);
          paramInt = i;
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick.a(paramAbsBaseArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick$Builder);
        paramInt = 4;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick$Builder);
      return;
    }
    a(null, paramAbsBaseArticleInfo, paramView, paramInt, paramLong);
    if (paramAbsBaseArticleInfo != null) {
      paramAbsBaseArticleInfo.invalidateProteusTemplateBean();
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJFrameworkHeaderManager.a(paramTopBannerInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView, a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter);
  }
  
  public void a(AdapterView<?> paramAdapterView, AbsBaseArticleInfo paramAbsBaseArticleInfo, View paramView, int paramInt, long paramLong)
  {
    ValueReference localValueReference = new ValueReference(Integer.valueOf(0));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick.a(paramView);
    if (paramAbsBaseArticleInfo != null)
    {
      String str = paramAbsBaseArticleInfo.innerUniqueID;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(paramAdapterView, paramView, paramInt, paramLong);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick.a(paramAbsBaseArticleInfo, this.jdField_a_of_type_Int);
      com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = paramAbsBaseArticleInfo;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick.a(paramAbsBaseArticleInfo, paramView, paramInt, localValueReference, paramAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick$Builder, this.jdField_a_of_type_AndroidOsHandler)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick.a(paramInt, paramAbsBaseArticleInfo, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick$Builder);
      paramAdapterView = str;
    }
    else
    {
      paramAdapterView = "";
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick.a(((Integer)localValueReference.a()).intValue(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick$Builder);
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append("onItemClick, rowkey= ");
    paramAbsBaseArticleInfo.append(paramAdapterView);
    QLog.d("ReadInJoyListViewGroup", 1, paramAbsBaseArticleInfo.toString());
  }
  
  public void a(IAnimManager.PullRefreshComplete paramPullRefreshComplete)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJFrameworkHeaderManager.a(paramPullRefreshComplete, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView);
  }
  
  public void a(Map<Integer, Boolean> paramMap) {}
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ReadInJoyListViewGroup_");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d(localStringBuilder.toString(), 2, "detachFromViewGroup()");
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(paramMap, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueReportRIJFrameworkReportManager.a(paramMap, paramBoolean, ReadinjoyReportUtils.a(this.jdField_a_of_type_Int), RIJKanDianFolderStatus.getFolderStatus(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.e(), this.jdField_a_of_type_Int, getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a().a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a().e(), this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.j();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.b(false);
    }
    a().getIntent().putExtra("from_search", false);
  }
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean, Map<Long, ReadinjoyReportUtils.ExposureReportItem> paramMap1, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueReportRIJFrameworkReportManager.a(paramMap, paramBoolean, paramMap1, paramString, getContext(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a().a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a().e(), this.jdField_a_of_type_Long);
  }
  
  public void a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ReadInJoyListViewGroup_");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d(((StringBuilder)localObject).toString(), 2, "attachToViewGroup()");
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(paramSet, paramMap);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter;
    if (localObject != null) {
      ((ReadInJoyArticleAdapter)localObject).a(paramSet, paramMap);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.i();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager.b();
    PublicTracker.a(null, "KANDIAN_FEEDS_STAGE_2_COST");
    if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.e()) {
      i();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, 1);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramInt == 8)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.f();
      if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a().d()) {
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(paramBoolean, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.post(new ReadInJoyListViewGroup.1(this, paramBoolean));
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.b(paramInt);
      return;
    }
    a(2, null);
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<AbsBaseArticleInfo> paramList1)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a(paramBoolean, paramInt, paramLong, paramList, paramList1);
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if (paramInt == this.jdField_a_of_type_Int)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(paramBoolean1, paramInt, paramList, paramBoolean2);
      int j = ReadInJoyLogicEngine.a().a(Integer.valueOf(paramInt));
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a().d())
      {
        if ((paramList != null) && (j == 1)) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter.a(0);
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a().d(false);
      }
      UserReadUnReadInfoManager.a().a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onChannelRefreshed, success = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(", refreshedArticleSize = ");
      localStringBuilder.append(j);
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
        a(paramInt, paramList, paramBoolean2, j);
      } else if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter.isEmpty()) {
        a(getResources().getString(2131717971));
      }
      b(paramBoolean1, j);
      t();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.d(paramList);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.b(paramList);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.c(paramList);
      AbstractGifImage.resumeAll();
      ReadInJoyChannelGuidingManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter.a(0), this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter);
      DailyTipsFoldUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter.a(0), this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView);
      if (paramInt == 0) {
        ReadInJoySessionManager.a.a();
      }
    }
  }
  
  public boolean a()
  {
    Boolean localBoolean = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a();
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJFrameworkHeaderManager.a();
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ReadInJoyListViewGroup_");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d(((StringBuilder)localObject).toString(), 2, "OnResume()");
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "onResume, mChannelID= ", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.b();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.e()) {
      i();
    }
    if (System.currentTimeMillis() - this.jdField_c_of_type_Long > 10000L)
    {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.2(this));
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter;
    if (localObject != null) {
      ((ReadInJoyArticleAdapter)localObject).e();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJFrameworkHeaderManager.b();
    if (StudyModeManager.a()) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager.c();
    } else {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.invalidate();
    if ((this.jdField_a_of_type_Int == 0) || (DailyModeConfigHandler.c(this.jdField_a_of_type_Int))) {
      UserActionCollector.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView, this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager.j();
    UGRuleManager.a(a());
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if ((paramInt == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter != null))
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
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
          QLog.d(((StringBuilder)localObject).toString(), 1, localStringBuilder1.toString());
        }
        VideoBehaviorsReporter.a().c(true);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter.b(0);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter.isEmpty()) {
        a(getResources().getString(2131718010));
      }
    }
  }
  
  public void b(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    paramReadInJoyBaseListView = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a();
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
      paramReadInJoyBaseListView.append(this.jdField_a_of_type_Int);
      paramReadInJoyBaseListView.append(" ");
      paramReadInJoyBaseListView.append(paramInt);
      paramReadInJoyBaseListView.append(" ");
      paramReadInJoyBaseListView.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.jdField_c_of_type_Int);
      QLog.d("ReadInJoyListViewGroup", 2, paramReadInJoyBaseListView.toString());
    }
    paramReadInJoyBaseListView = ReadInJoyUtils.a();
    if ((paramReadInJoyBaseListView != null) && (this.jdField_a_of_type_Int == 56) && (this.jdField_b_of_type_Long == 1001L))
    {
      if (!((KandianMergeManager)paramReadInJoyBaseListView.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).g()) {
        i = 0;
      }
      i = 0x2 | i;
    }
    else
    {
      i = 0;
    }
    int j;
    if ((this.jdField_a_of_type_Int != 40830) && (!DailyModeConfigHandler.c(this.jdField_a_of_type_Int)))
    {
      j = 1;
    }
    else
    {
      j = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = (j + 1);
    }
    ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a().a(), paramInt, i, j);
    RIJFrameworkReportManager.a(this.jdField_a_of_type_Int);
  }
  
  public void b(Map<Integer, Boolean> paramMap)
  {
    paramMap.put(Integer.valueOf(this.jdField_a_of_type_Int), Boolean.valueOf(true));
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((paramInt == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.b(paramBoolean1, paramInt, paramList, paramBoolean2);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a(paramBoolean1, paramInt, paramList, paramBoolean2);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a().g(false);
  }
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ReadInJoyListViewGroup_");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d(((StringBuilder)localObject).toString(), 2, "onPause()");
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.c();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter;
    if (localObject != null) {
      ((ReadInJoyArticleAdapter)localObject).f();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJFrameworkHeaderManager.c();
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.c();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "mListView onSaveInstanceState cost: ", Long.valueOf(System.currentTimeMillis() - l) });
    }
  }
  
  public void c(int paramInt, List<Long> paramList)
  {
    if ((paramInt == this.jdField_a_of_type_Int) && (paramList != null))
    {
      ReadInJoyArticleAdapter localReadInJoyArticleAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter;
      if (localReadInJoyArticleAdapter == null) {
        return;
      }
      localReadInJoyArticleAdapter.b(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter.notifyDataSetChanged();
    }
  }
  
  public void c(Map<Integer, BaseReportData> paramMap)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(paramMap);
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ReadInJoyListViewGroup_");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d(localStringBuilder.toString(), 2, "onStart()");
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.d();
    UserReadUnReadInfoManager.a().b();
    if ((this.jdField_a_of_type_Int == 0) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a().d())) {
      a(1500, new ReadInJoyListViewGroup.3(this));
    }
  }
  
  public void d(Map<Integer, BaseReportData> paramMap)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueReportRIJFrameworkReportManager.a(paramMap);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      RIJBlackWhiteModeHelper.a.a(paramCanvas, true, this.jdField_b_of_type_KotlinJvmFunctionsFunction1);
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    DailyTipsFoldUtils.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView, this.jdField_a_of_type_Int);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      RIJBlackWhiteModeHelper.a.a(paramCanvas, true, this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
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
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d(localStringBuilder.toString(), 2, "onStop()");
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.d();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.e();
    UserReadUnReadInfoManager.a().c();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a();
    ReadInJoyHelper.a(System.currentTimeMillis(), (QQAppInterface)ReadInJoyUtils.a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.d(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick$Builder.a());
    ((BaseActivity)a()).app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter.c();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter.b();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter.a(null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter.l();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter = null;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView != null)
    {
      DailyTipsFoldUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setDrawFinishedListener(null);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setRefreshCallback(null);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.c();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null)
    {
      ((IFaceDecoder)localObject).destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
    }
    ReadInJoyHelper.b(((BaseActivity)a()).app);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager;
    if (localObject != null) {
      ((RIJTipMessageManager)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJFrameworkHeaderManager;
    if (localObject != null) {
      ((RIJFrameworkHeaderManager)localObject).d();
    }
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).unRegisterReceiver();
    VideoPlayControlUtils.f(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView);
    if (DailyModeConfigHandler.c(a())) {
      ReadinjoySensorUtils.a().b();
    }
    UGRuleManager.b(a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.a();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcManagecolumnColumnSubscribeChangeObserver);
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager.e();
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.e();
  }
  
  public void l()
  {
    ((FrameworkHandler)this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(2)).k();
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView == null) {
      return;
    }
    a(true);
  }
  
  public void n()
  {
    ReadInJoyArticleAdapter localReadInJoyArticleAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter;
    if (localReadInJoyArticleAdapter != null) {
      localReadInJoyArticleAdapter.notifyDataSetChanged();
    }
  }
  
  public void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJFrameworkHeaderManager.e();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131371770) {
      return;
    }
    u();
    RIJThreadHandler.a(3);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager.b(true, 3, false);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter.getItem(i);
    if ((localObject instanceof BaseArticleInfo))
    {
      localObject = (AbsBaseArticleInfo)localObject;
      if (RIJFeedsType.I((AbsBaseArticleInfo)localObject)) {
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
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.i();
    }
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.a(HardCodeUtil.a(2131712891));
    }
  }
  
  public void r()
  {
    QLog.d("ReadInJoyListViewGroup", 1, "invalidAllArticles");
    ReadInJoyArticleAdapter localReadInJoyArticleAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyArticleAdapter;
    if (localReadInJoyArticleAdapter != null) {
      localReadInJoyArticleAdapter.j();
    }
  }
  
  public void setNotifyEndRefresh(NotifyEndRefresh paramNotifyEndRefresh)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkNotifyEndRefresh = paramNotifyEndRefresh;
  }
  
  public void setRefreshHeader(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJFrameworkHeaderManager.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView, a(), this.jdField_a_of_type_Int);
  }
  
  public void setSkinHeader(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJFrameworkHeaderManager.a(paramInt, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView, a(), this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup
 * JD-Core Version:    0.7.0.1
 */