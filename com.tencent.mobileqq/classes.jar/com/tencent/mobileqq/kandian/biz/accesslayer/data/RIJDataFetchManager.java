package com.tencent.mobileqq.kandian.biz.accesslayer.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.webviewplugin.PubAccountPreloadPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.biz.biu.RIJBiuAndCommentMixDataManager;
import com.tencent.mobileqq.kandian.biz.comment.ArticleCommentModule;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListFragment;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyPageItemCache;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.daily.DailyTipsFoldUtils;
import com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyXListView;
import com.tencent.mobileqq.kandian.biz.feeds.ReadinjoyFixPosArticleManager;
import com.tencent.mobileqq.kandian.biz.feeds.UserReadUnReadInfoManager;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJChannelStayTimeMonitor;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyBaseViewController;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsInsertController;
import com.tencent.mobileqq.kandian.biz.feeds.entity.SerializableMap;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.RIJFrameworkHeaderManager;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsViewHolder;
import com.tencent.mobileqq.kandian.glue.businesshandler.DiandianTopConfigManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianDailyManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianSubscribeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.RIJWeiShiLegacyUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.router.ReadInJoyChannelGuidingManager;
import com.tencent.mobileqq.kandian.glue.structmsg.FeedsStructMsg;
import com.tencent.mobileqq.kandian.glue.video.VideoRecommendManager;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJBiuAndCommentAladdinUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianUserDataAladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.ChannelModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.biu.RIJNewBiuCardTransformManager;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfoKt;
import com.tencent.mobileqq.kandian.repo.diandian.ReadInJoyDianDianEntranceModule;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.BannerInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.FeedsSPUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.api.IInsertArticleCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleInsertInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.InsertArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.LebaKDCellInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.PkgInstallInfo;
import com.tencent.mobileqq.kandian.repo.webarticle.DataPreloadModule;
import com.tencent.mobileqq.kandian.repo.webarticle.RIJWebArticlePreloadUtil;
import com.tencent.mobileqq.kandian.repo.webarticle.RIJWebArticleUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJDataFetchManager
{
  private RIJDataFetchManager.Builder jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder;
  private RIJBiuAndCommentMixDataManager jdField_a_of_type_ComTencentMobileqqKandianBizBiuRIJBiuAndCommentMixDataManager;
  
  public RIJDataFetchManager(RIJDataFetchManager.Builder paramBuilder)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder = paramBuilder;
  }
  
  private long a()
  {
    if ((d()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getIntExtra("channel_from", -1) == 4))
    {
      Object localObject = (SerializableMap)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getSerializableExtra("channel_map_data");
      if ((localObject != null) && (((SerializableMap)localObject).getMap() != null))
      {
        localObject = ((SerializableMap)localObject).getMap();
        long l = ((Long)((Map)localObject).get("param_key_ariticle_id")).longValue();
        if (((Integer)((Map)localObject).get("param_key_channel_cover_style")).intValue() == 1) {
          return l;
        }
      }
    }
    return -1L;
  }
  
  public static void a(int paramInt)
  {
    ThreadManager.getUIHandler().postDelayed(new RIJDataFetchManager.3(paramInt), 3000L);
  }
  
  private void a(int paramInt, @NotNull RIJDataFetchManager.FunctionData paramFunctionData, @NotNull List<InsertArticleInfo> paramList)
  {
    Object localObject = paramFunctionData.jdField_a_of_type_AndroidUtilPair;
    String str2 = null;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = paramFunctionData.jdField_a_of_type_AndroidUtilPair.first;
    }
    String str1;
    if (paramFunctionData.jdField_a_of_type_AndroidUtilPair == null) {
      str1 = null;
    } else {
      str1 = (String)paramFunctionData.jdField_a_of_type_AndroidUtilPair.second;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 70)
    {
      ReadInJoyLogicEngine.a().a(true, paramFunctionData.jdField_a_of_type_JavaLangString);
      DiandianTopConfigManager.a().a(true);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().setNoMoreData(false);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().setCurrentStatus(1);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.c() == 6) || (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.c() == 7)) {
      paramFunctionData.jdField_a_of_type_Int |= 0x800;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("FeedsRefreshType", this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.c());
    ReadInJoyLogicEngine localReadInJoyLogicEngine = ReadInJoyLogicEngine.a();
    int i = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d();
    List localList = paramFunctionData.jdField_a_of_type_JavaUtilList;
    int j = paramFunctionData.jdField_b_of_type_Int;
    boolean bool = paramFunctionData.jdField_a_of_type_Boolean;
    int k = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.b();
    if ((localObject instanceof String)) {
      str2 = (String)localObject;
    }
    long l;
    if ((localObject instanceof Long)) {
      l = ((Long)localObject).longValue();
    } else {
      l = -1L;
    }
    localReadInJoyLogicEngine.a(i, localList, j, true, bool, k, str2, l, str1, a(), paramFunctionData.jdField_a_of_type_Long, paramFunctionData.jdField_b_of_type_Long, paramFunctionData.jdField_a_of_type_JavaLangString, paramInt, paramFunctionData.jdField_b_of_type_Boolean, paramFunctionData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLebaKDCellInfo, paramFunctionData.jdField_a_of_type_Int, paramList, b(), localBundle);
  }
  
  private void a(int paramInt, List<Long> paramList, RIJDataFetchManager.Builder paramBuilder)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      a(ReadInJoyLogicEngine.a().a(Integer.valueOf(paramBuilder.d()), paramList), 1);
      Object localObject1;
      if (paramInt == 70)
      {
        localObject1 = ReadInJoyUtils.a();
        if (localObject1 != null)
        {
          paramInt = ((KandianMergeManager)((AppRuntime)localObject1).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
          if ((paramInt >= 0) && (paramList.size() >= paramInt)) {
            paramBuilder.a().setNoMoreData(true);
          }
        }
      }
      Object localObject2;
      StringBuilder localStringBuilder;
      if (!paramList.isEmpty())
      {
        localObject1 = (Long)paramList.get(0);
        localObject2 = ReadInJoyLogicEngine.a().a(paramBuilder.d(), ((Long)localObject1).longValue());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("load history successful ! first article title : ");
        if (localObject2 != null) {
          localObject1 = ((AbsBaseArticleInfo)localObject2).mTitle;
        } else {
          localObject1 = "";
        }
        localStringBuilder.append(RIJAppSetting.a((String)localObject1));
        localObject1 = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(" articleID : ");
        if (localObject2 != null) {
          localObject1 = Long.valueOf(((AbsBaseArticleInfo)localObject2).mArticleID);
        } else {
          localObject1 = "-1";
        }
        localStringBuilder.append(localObject1);
        localObject1 = localStringBuilder.toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("RIJDataFetchManager_");
        ((StringBuilder)localObject2).append(paramBuilder.d());
        QLog.d(((StringBuilder)localObject2).toString(), 1, (String)localObject1);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder("onChannelArticleLoaded ");
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject2 = (Long)paramList.next();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("recommendSeq = ");
          localStringBuilder.append(localObject2);
          localStringBuilder.append(",\n ");
          ((StringBuilder)localObject1).append(localStringBuilder.toString());
        }
        paramList = new StringBuilder();
        paramList.append("RIJDataFetchManager_");
        paramList.append(paramBuilder.d());
        QLog.d(paramList.toString(), 1, ((StringBuilder)localObject1).toString());
      }
      paramList = ReadInJoyLogicEngine.a().a();
      if (paramList != null) {
        paramBuilder.a().a(paramList.a(paramBuilder.d()), paramBuilder.a(), paramBuilder.a(), paramBuilder.d(), paramBuilder.a());
      }
    }
  }
  
  public static void a(Context paramContext, int paramInt, Runnable paramRunnable)
  {
    int j = 0;
    int i = ((Integer)RIJSPUtils.a("readinjoy_user_data_state", Integer.valueOf(0))).intValue();
    long l1 = ((Long)RIJSPUtils.a("readinjoy_user_data_time", Long.valueOf(0L))).longValue();
    int k = ((Integer)RIJSPUtils.a("readinjoy_user_data_switch", Integer.valueOf(1))).intValue();
    if ((RIJKanDianUserDataAladdinConfig.a.a() == 1) && (k == 1))
    {
      long l2 = System.currentTimeMillis();
      if (l2 - l1 >= RIJKanDianUserDataAladdinConfig.a.c() * 86400000L) {
        i = 0;
      }
      k = 1 << paramInt;
      if ((i & k) == 0)
      {
        RIJSPUtils.a("readinjoy_user_data_time", Long.valueOf(l2));
        RIJSPUtils.a("readinjoy_user_data_state", Integer.valueOf(i | k));
        QQCustomDialog localQQCustomDialog = DialogUtil.a(paramContext, 230);
        localQQCustomDialog.setTitle(null);
        localQQCustomDialog.setMessage(RIJKanDianUserDataAladdinConfig.a.a(paramContext));
        localQQCustomDialog.setPositiveButton(paramContext.getString(2131720389), new RIJDataFetchManager.1(paramInt, paramRunnable));
        localQQCustomDialog.setNegativeButton(paramContext.getString(2131720399), new RIJDataFetchManager.2(paramInt, paramRunnable));
        localQQCustomDialog.show();
        paramContext = new JSONObject();
        if (paramInt != 1) {
          break label322;
        }
        paramInt = j;
      }
    }
    for (;;)
    {
      try
      {
        paramContext.put("exp_src", paramInt);
        paramContext.put("user_data_alert_interval", RIJKanDianUserDataAladdinConfig.a.c());
      }
      catch (JSONException paramRunnable)
      {
        paramRunnable.printStackTrace();
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800A808", "0X800A808", 0, 0, "", "", "", paramContext.toString(), false);
      return;
      if (paramRunnable != null)
      {
        paramRunnable.run();
        return;
        if (paramRunnable != null) {
          paramRunnable.run();
        }
      }
      return;
      label322:
      paramInt = 1;
    }
  }
  
  private void a(Intent paramIntent)
  {
    QLog.d("RIJDataFetchManager", 1, "back from readInJoyList");
    int i;
    if (paramIntent.getIntExtra("click_comment_edit_src", -1) == 2) {
      i = 1;
    } else {
      i = 2;
    }
    AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramIntent.getParcelableExtra("comment_article_info");
    if (localAbsBaseArticleInfo != null)
    {
      k();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuRIJBiuAndCommentMixDataManager = new RIJBiuAndCommentMixDataManager();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuRIJBiuAndCommentMixDataManager.a(new RIJDataFetchManager.4(this, localAbsBaseArticleInfo));
      ReadInJoyCommentListFragment.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuRIJBiuAndCommentMixDataManager, 7, true, localAbsBaseArticleInfo, 1, i);
      return;
    }
    QLog.e("RIJDataFetchManager", 1, "handleMainFeedCommentRequest articleInfo is NULL");
  }
  
  private void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull KandianMergeManager paramKandianMergeManager, @NotNull RIJDataFetchManager.FunctionData paramFunctionData)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() != 0) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() != ChannelCoverInfoModule.a()))
    {
      if ((a()) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.f())) {
        b(paramFunctionData, paramQQAppInterface);
      } else if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 70) {
        d(paramFunctionData);
      } else if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 56) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.b() == 1001L)) {
        a(paramFunctionData, paramKandianMergeManager);
      } else if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 40677) {
        a(paramFunctionData, paramQQAppInterface);
      }
    }
    else {
      b(paramFunctionData, paramKandianMergeManager);
    }
    a(paramFunctionData);
  }
  
  private void a(@NotNull RIJDataFetchManager.FunctionData paramFunctionData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 40830)
    {
      c(paramFunctionData);
      return;
    }
    if (DailyModeConfigHandler.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d()))
    {
      b(paramFunctionData);
      return;
    }
    long l = a();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a() != null)
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a(0);
      if ((l != -1L) && (localAbsBaseArticleInfo != null) && (l != localAbsBaseArticleInfo.mArticleID))
      {
        paramFunctionData.jdField_a_of_type_JavaUtilList = new ArrayList();
        paramFunctionData.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l));
        paramFunctionData.jdField_b_of_type_Int = 6;
      }
    }
  }
  
  private void a(RIJDataFetchManager.FunctionData paramFunctionData, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = RIJWeiShiLegacyUtils.a.a();
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      paramFunctionData.jdField_a_of_type_JavaUtilList = new ArrayList(paramQQAppInterface);
      paramFunctionData.jdField_b_of_type_Int = 8;
      if (!TextUtils.isEmpty(RIJWeiShiLegacyUtils.a.a())) {
        paramFunctionData.jdField_a_of_type_JavaLangString = RIJWeiShiLegacyUtils.a.a();
      }
    }
    RIJWeiShiLegacyUtils.a.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a());
  }
  
  private void a(RIJDataFetchManager.FunctionData paramFunctionData, KandianMergeManager paramKandianMergeManager)
  {
    paramFunctionData.jdField_a_of_type_Int |= 0x2;
    KandianRedDotInfo localKandianRedDotInfo = paramKandianMergeManager.c();
    if (localKandianRedDotInfo != null)
    {
      if (localKandianRedDotInfo.hasArticleID())
      {
        paramFunctionData.jdField_a_of_type_JavaUtilList = localKandianRedDotInfo.articleIDList;
        paramFunctionData.jdField_a_of_type_JavaLangString = localKandianRedDotInfo.cookie;
        paramFunctionData.jdField_a_of_type_Long = localKandianRedDotInfo.algorithmID;
        paramFunctionData.jdField_b_of_type_Long = localKandianRedDotInfo.strategyID;
        paramFunctionData.jdField_b_of_type_Int = 1;
        paramFunctionData.jdField_a_of_type_Int |= 0x8;
      }
      else
      {
        paramFunctionData.jdField_a_of_type_Int |= 0x4;
      }
      paramKandianMergeManager.n();
    }
  }
  
  private void a(@NotNull RIJDataFetchManager.FunctionData paramFunctionData, @NotNull KandianMergeManager paramKandianMergeManager, @NotNull List<InsertArticleInfo> paramList)
  {
    if (c())
    {
      paramList.addAll(paramKandianMergeManager.b());
      paramFunctionData.jdField_a_of_type_Int |= 0x80;
    }
    if (UserReadUnReadInfoManager.a().a()) {
      paramFunctionData.jdField_a_of_type_Int |= 0x1000;
    }
  }
  
  private static void a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt1, List<AbsBaseArticleInfo> paramList, int paramInt2, IInsertArticleCallback paramIInsertArticleCallback, RIJFrameworkHeaderManager paramRIJFrameworkHeaderManager)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramReadInJoyBaseAdapter.b().iterator();
    while (localIterator.hasNext())
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)localIterator.next();
      if (!a(localAbsBaseArticleInfo)) {
        localArrayList.add(localAbsBaseArticleInfo);
      }
    }
    a(paramReadInJoyBaseAdapter, paramInt1, paramList, localArrayList, paramInt2, paramIInsertArticleCallback, paramRIJFrameworkHeaderManager);
  }
  
  public static void a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt1, List<AbsBaseArticleInfo> paramList1, List<AbsBaseArticleInfo> paramList2, int paramInt2, IInsertArticleCallback paramIInsertArticleCallback, RIJFrameworkHeaderManager paramRIJFrameworkHeaderManager)
  {
    List localList = ReadinjoyFixPosArticleManager.getInstant().insertFixPosArticles(paramInt1, paramList1, paramList2, paramInt2);
    paramList1 = localList;
    if (localList != null) {
      paramList1 = RIJFeedsInsertController.a.a(paramReadInJoyBaseAdapter, localList, paramIInsertArticleCallback);
    }
    if (!ReadinjoyFixPosArticleManager.isNotSameData(paramList1, paramList2))
    {
      QLog.d("RIJDataFetchManager", 1, "setAdapterData same data!");
      return;
    }
    if ((paramInt1 == 0) || (DailyModeConfigHandler.b(DailyModeConfigHandler.b()))) {
      paramReadInJoyBaseAdapter.d(true);
    }
    f(paramList1);
    paramReadInJoyBaseAdapter.a(paramList1);
    paramReadInJoyBaseAdapter.notifyDataSetChanged();
    if (paramRIJFrameworkHeaderManager != null) {
      paramRIJFrameworkHeaderManager.a(8);
    }
    paramReadInJoyBaseAdapter = new StringBuilder();
    paramReadInJoyBaseAdapter.append("setAdapterData! oldData size=");
    paramReadInJoyBaseAdapter.append(paramList2.size());
    paramReadInJoyBaseAdapter.append(" newData size=");
    paramReadInJoyBaseAdapter.append(paramList1.size());
    QLog.d("RIJDataFetchManager", 1, paramReadInJoyBaseAdapter.toString());
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt != 70) && (paramInt != 56) && (paramInt != 40677) && (!DailyModeConfigHandler.c(paramInt));
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null)
    {
      QLog.d("RIJDataFetchManager", 1, "isDynamicCard error! articleInfo is null!");
      return false;
    }
    if (paramAbsBaseArticleInfo.articleInsertInfo.jdField_a_of_type_Boolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("title =");
      localStringBuilder.append(paramAbsBaseArticleInfo.mTitle);
      localStringBuilder.append(", rowkey=");
      localStringBuilder.append(paramAbsBaseArticleInfo.innerUniqueID);
      localStringBuilder.append(", articleInsertInfo=");
      localStringBuilder.append(paramAbsBaseArticleInfo.articleInsertInfo);
      QLog.d("RIJDataFetchManager", 1, localStringBuilder.toString());
    }
    return paramAbsBaseArticleInfo.articleInsertInfo.jdField_a_of_type_Boolean;
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a() != null)
    {
      Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getIntent();
      bool = paramBoolean;
      if (localIntent != null)
      {
        bool = false;
        if (localIntent.getIntExtra("launch_from", 0) == 15) {
          bool = true;
        }
      }
    }
    return bool;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool5 = h();
    Object localObject = (KandianMergeManager)((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a()).app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    long l;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 70) {
      l = ((Integer)RIJSPUtils.a("sp_key_kandian_subscribe_auto_refresh_config", Integer.valueOf(600))).intValue() * 1000;
    } else {
      l = 300000L;
    }
    if (DailyModeConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d())) {
      l = b();
    }
    boolean bool3;
    if (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().d > l) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    boolean bool6 = g();
    boolean bool2;
    if ((a()) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.f())) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool1 = ((Boolean)RIJSPUtils.a("key_sp_entrance_follow", Boolean.valueOf(false))).booleanValue();
    if (bool1) {
      RIJSPUtils.a("key_sp_entrance_follow", Boolean.valueOf(false));
    }
    boolean bool4;
    if ((ReadInJoyHelper.l()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 56) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.b() == 1001L) && (((KandianMergeManager)localObject).g())) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    boolean bool7 = a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.e());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.c(bool7);
    if ((!paramBoolean1) && (!bool3) && (!bool6) && (!bool5) && (!bool2) && (!bool4) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.e()) && (!bool1)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("RIJDataFetchManager_");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d());
    QLog.d(((StringBuilder)localObject).toString(), 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool3), Boolean.valueOf(bool6), Boolean.valueOf(bool5), Boolean.valueOf(bool2), Boolean.valueOf(bool4) }));
    if (e())
    {
      bool3 = ((IRIJChannelStayTimeMonitor)QRoute.api(IRIJChannelStayTimeMonitor.class)).isLastExitChannelOverTimeLimit(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d());
      if ((!paramBoolean1) && (!bool3) && (!bool6) && (!bool5) && (!bool2) && (!bool4) && (!paramBoolean2)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      QLog.d("RIJDataFetchManager", 1, String.format("new channel tab, loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s, isNeedRefreshChannel=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool3), Boolean.valueOf(bool6), Boolean.valueOf(bool5), Boolean.valueOf(bool2), Boolean.valueOf(bool4), Boolean.valueOf(paramBoolean2) }));
      return bool1;
    }
    if (a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d())) {
      bool1 = true;
    }
    return bool1;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (d()) {
      return a(paramBoolean2, paramBoolean3);
    }
    return b(paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  private long b()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(161);
    if (localAladdinConfig != null)
    {
      int i = localAladdinConfig.getIntegerFromString("is_auto_refresh", 0);
      int j = localAladdinConfig.getIntegerFromString("daily_refresh_interval", 0);
      QLog.d("RIJDataFetchManager", 1, new Object[] { "getDailyRefreshTimeLimit, isAutoRefresh = ", Integer.valueOf(i), ", refreshInterval = ", Integer.valueOf(j) });
      if (i == 1)
      {
        l = j * 60 * 1000;
        break label92;
      }
    }
    long l = 9223372036854775807L;
    label92:
    QLog.d("RIJDataFetchManager", 1, new Object[] { "getDailyRefreshTimeLimit, res = ", Long.valueOf(l) });
    return l;
  }
  
  private List<ReadInJoyRequestParams.PkgInstallInfo> b()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 56)
    {
      ReadInJoyRequestParams.PkgInstallInfo localPkgInstallInfo = new ReadInJoyRequestParams.PkgInstallInfo();
      localPkgInstallInfo.jdField_a_of_type_JavaLangString = "com.tencent.weishi";
      localPkgInstallInfo.jdField_a_of_type_Boolean = PackageUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a(), localPkgInstallInfo.jdField_a_of_type_JavaLangString);
      localArrayList.add(localPkgInstallInfo);
    }
    return localArrayList;
  }
  
  private void b(@NotNull RIJDataFetchManager.FunctionData paramFunctionData)
  {
    KandianRedDotInfo localKandianRedDotInfo = (KandianRedDotInfo)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getSerializableExtra("kandian_feeds_red_pnt_info");
    if ((localKandianRedDotInfo != null) && (!localKandianRedDotInfo.shouldRemoveFloatingRedPntArticleId()))
    {
      paramFunctionData.jdField_a_of_type_Long = localKandianRedDotInfo.algorithmID;
      paramFunctionData.jdField_b_of_type_Long = localKandianRedDotInfo.strategyID;
      paramFunctionData.jdField_a_of_type_JavaUtilList = localKandianRedDotInfo.articleIDList;
      paramFunctionData.jdField_b_of_type_Int = 1;
      paramFunctionData.jdField_a_of_type_JavaLangString = localKandianRedDotInfo.cookie;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().removeExtra("kandian_feeds_red_pnt_info");
    }
  }
  
  private void b(RIJDataFetchManager.FunctionData paramFunctionData, QQAppInterface paramQQAppInterface)
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.b(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a(true);
    if (bool)
    {
      Object localObject = (AbsBaseArticleInfo)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().getParcelableExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO");
      if (localObject != null)
      {
        paramFunctionData.jdField_a_of_type_AndroidUtilPair = new Pair(((AbsBaseArticleInfo)localObject).getInnerUniqueID(), ((AbsBaseArticleInfo)localObject).mTitle);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("ArticleId", RIJStringUtils.a(((AbsBaseArticleInfo)localObject).mArticleID));
          localJSONObject.put("FeedsId", RIJStringUtils.a(((AbsBaseArticleInfo)localObject).mFeedId));
          localJSONObject.put("algorithmIds", 0);
          localJSONObject.put("biuUin", 0);
          localObject = new JSONObject();
          ((JSONObject)localObject).put("socialFeedsType", 1);
          localJSONObject.put("extension", localObject);
          localJSONObject.put("feedsType", 1);
          localJSONObject.put("id", 0);
          localJSONObject.put("network_type", 1);
          localJSONObject.put("orange", "");
          localJSONObject.put("pushMessage", "");
          localJSONObject.put("push_type", 0);
          localJSONObject.put("strategyIds", 0);
          localJSONObject.put("title", "");
          localJSONObject.put("uin", paramQQAppInterface.getLongAccountUin());
          paramFunctionData.jdField_a_of_type_JavaLangString = localJSONObject.toString();
        }
        catch (JSONException paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          paramFunctionData.jdField_a_of_type_JavaLangString = null;
        }
      }
    }
    else
    {
      paramFunctionData.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramFunctionData.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l));
    }
    paramFunctionData.jdField_b_of_type_Int = 5;
  }
  
  private void b(RIJDataFetchManager.FunctionData paramFunctionData, KandianMergeManager paramKandianMergeManager)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().jdField_a_of_type_Boolean;
    int i = 0;
    int j = 0;
    if (bool)
    {
      paramFunctionData.jdField_a_of_type_JavaUtilList = a();
      paramFunctionData.jdField_a_of_type_Boolean = f();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getIntExtra("launch_from", -1) == 8) {
        bool = true;
      } else {
        bool = false;
      }
      paramFunctionData.jdField_b_of_type_Boolean = bool;
      paramFunctionData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLebaKDCellInfo = ((LebaKDCellInfo)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getSerializableExtra("param_leba_cell_articleinfo"));
    }
    if (paramFunctionData.jdField_a_of_type_JavaUtilList == null)
    {
      paramFunctionData.jdField_a_of_type_JavaUtilList = paramKandianMergeManager.a();
      if ((paramFunctionData.jdField_a_of_type_JavaUtilList != null) && (paramFunctionData.jdField_a_of_type_JavaUtilList.size() > 2))
      {
        paramFunctionData.jdField_a_of_type_Long = ((Long)paramFunctionData.jdField_a_of_type_JavaUtilList.get(paramFunctionData.jdField_a_of_type_JavaUtilList.size() - 2)).longValue();
        paramFunctionData.jdField_b_of_type_Long = ((Long)paramFunctionData.jdField_a_of_type_JavaUtilList.get(paramFunctionData.jdField_a_of_type_JavaUtilList.size() - 1)).longValue();
        paramFunctionData.jdField_a_of_type_JavaUtilList = paramFunctionData.jdField_a_of_type_JavaUtilList.subList(0, paramFunctionData.jdField_a_of_type_JavaUtilList.size() - 2);
        paramFunctionData.jdField_b_of_type_Int = 1;
        paramFunctionData.jdField_a_of_type_JavaLangString = paramKandianMergeManager.a();
      }
      i = j;
      if (b())
      {
        Object localObject = paramKandianMergeManager.a();
        i = j;
        if (localObject != null)
        {
          ArrayList localArrayList = ((KandianRedDotInfo)localObject).articleIDList;
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            paramFunctionData.jdField_a_of_type_JavaUtilList = new ArrayList();
            paramFunctionData.jdField_a_of_type_JavaLangString = ((KandianRedDotInfo)localObject).cookie;
            i = localArrayList.size() - 1;
            while (i >= 0)
            {
              localObject = (Long)localArrayList.get(i);
              paramFunctionData.jdField_a_of_type_JavaUtilList.add(0, localObject);
              i -= 1;
            }
          }
          i = 1;
        }
      }
      paramKandianMergeManager.g();
      paramKandianMergeManager.f();
    }
    paramFunctionData.jdField_a_of_type_AndroidUtilPair = paramKandianMergeManager.a();
    paramKandianMergeManager.l();
    if (i != 0) {
      paramFunctionData.jdField_a_of_type_Int |= 0x20;
    }
  }
  
  private boolean b(int paramInt)
  {
    ArticleInfoModule localArticleInfoModule = ReadInJoyLogicEngine.a().a();
    if (localArticleInfoModule != null)
    {
      localArticleInfoModule.a().b(paramInt);
      localArticleInfoModule.a().a();
      return true;
    }
    return false;
  }
  
  private boolean b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1 = ((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a()).app;
    Object localObject2 = (KandianMergeManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    boolean bool1 = ReadInJoyHelper.a((AppInterface)localObject1);
    boolean bool4 = false;
    if (bool1)
    {
      bool1 = ((KandianMergeManager)localObject2).b();
    }
    else
    {
      localObject2 = a();
      if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    boolean bool5 = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a() instanceof ReadInJoyNewFeedsActivity;
    long l;
    if (bool5) {
      l = ReadInJoyHelper.e((AppRuntime)localObject1);
    } else {
      l = ReadInJoyHelper.d((AppRuntime)localObject1);
    }
    int i;
    if (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().c > l) {
      i = 1;
    } else {
      i = 0;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getIntent();
    boolean bool6 = ((Intent)localObject1).getBooleanExtra("from_search", false);
    boolean bool3;
    if ((c()) && (((Intent)localObject1).getBooleanExtra("force_refresh", false))) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    if (c()) {
      ((Intent)localObject1).removeExtra("force_refresh");
    }
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getIntExtra("launch_from", -1) == 8) {
      j = 1;
    } else {
      j = 0;
    }
    boolean bool2 = e();
    int k = 6;
    if (bool2)
    {
      bool4 = ((IRIJChannelStayTimeMonitor)QRoute.api(IRIJChannelStayTimeMonitor.class)).isLastExitChannelOverTimeLimit(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d());
      if ((!paramBoolean2) && (!bool1) && (!bool6) && (!bool4) && (j == 0) && (!bool3) && (!paramBoolean3)) {
        bool2 = false;
      } else {
        bool2 = true;
      }
      QLog.d("RIJDataFetchManager", 1, String.format("new channel tab, loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, hasPushMsg=%s, fromSearch=%s, isLastExitChannelOverTimeLimit=%s, isInMessageKandian=%s, fromDaily=%s, isNeedRefreshChannel=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean2), Boolean.valueOf(bool1), Boolean.valueOf(bool6), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool3), Boolean.valueOf(paramBoolean3) }));
      paramBoolean3 = bool2;
    }
    else
    {
      if ((!paramBoolean2) && (!bool1) && (!bool6) && ((i == 0) || (!paramBoolean1)) && (j == 0) && (!bool3)) {
        paramBoolean3 = false;
      } else {
        paramBoolean3 = true;
      }
      bool2 = bool4;
      if (i != 0)
      {
        bool2 = bool4;
        if (paramBoolean1) {
          bool2 = true;
        }
      }
      QLog.d("RIJDataFetchManager", 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, hasPushMsg=%s, fromSearch=%s, lastExitKandianOver10min=%s, isInMessageKandian=%s, fromDaily=%s", new Object[] { Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean2), Boolean.valueOf(bool1), Boolean.valueOf(bool6), Boolean.valueOf(bool2), Boolean.valueOf(bool5), Boolean.valueOf(bool3) }));
    }
    if ((i != 0) && (paramBoolean1)) {
      i = k;
    } else {
      i = 1;
    }
    if (paramBoolean3) {
      RIJThreadHandler.a(i);
    }
    return paramBoolean3;
  }
  
  private void c(RIJDataFetchManager.FunctionData paramFunctionData)
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getIntent();
    if (localIntent != null)
    {
      SerializableMap localSerializableMap = (SerializableMap)localIntent.getSerializableExtra("channel_map_data");
      if (localSerializableMap != null)
      {
        Long localLong = (Long)localSerializableMap.getMap().remove("articleID");
        if (localLong != null)
        {
          paramFunctionData.jdField_a_of_type_JavaUtilList = new ArrayList();
          paramFunctionData.jdField_a_of_type_JavaUtilList.add(localLong);
          localIntent.putExtra("channel_map_data", localSerializableMap);
        }
        paramFunctionData.jdField_b_of_type_Int = 9;
        paramFunctionData.jdField_a_of_type_JavaLangString = ((String)localSerializableMap.getMap().get("pushContext"));
      }
    }
  }
  
  private void d(RIJDataFetchManager.FunctionData paramFunctionData)
  {
    KandianRedDotInfo localKandianRedDotInfo = (KandianRedDotInfo)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getSerializableExtra("kandian_feeds_red_pnt_info");
    if (localKandianRedDotInfo != null)
    {
      paramFunctionData.jdField_a_of_type_JavaLangString = localKandianRedDotInfo.cookie;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().removeExtra("kandian_feeds_red_pnt_info");
    }
  }
  
  private void e(List<Long> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 0) || (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 70) || (DailyModeConfigHandler.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d()))))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.b(NetConnInfoCenter.getServerTime());
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a(ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d(), ((Long)paramList.get(0)).longValue()));
      paramList = (QQAppInterface)ReadInJoyUtils.a();
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a() != null) && (paramList != null))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 0)
        {
          paramList = FeedsStructMsg.a(paramList, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a());
          String str = FeedsStructMsg.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a());
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createFakeStructingMsgWithFields(((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a()).app, str, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a()), paramList, false);
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 70)
        {
          ((KandianSubscribeManager)paramList.getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a());
          return;
        }
        if (DailyModeConfigHandler.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d())) {
          ((KandianDailyManager)paramList.getManager(QQManagerFactory.KANDIAN_DAILY_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a());
        }
      }
    }
  }
  
  private static void f(List<AbsBaseArticleInfo> paramList)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setAdapterData: srcData size ");
      int i;
      if (paramList != null) {
        i = paramList.size();
      } else {
        i = 0;
      }
      ((StringBuilder)localObject).append(i);
      QLog.d("RIJDataFetchManager", 2, ((StringBuilder)localObject).toString());
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (AbsBaseArticleInfo)paramList.next();
          if (localObject != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("setAdapterData: ");
            localStringBuilder.append(((AbsBaseArticleInfo)localObject).mTitle);
            localStringBuilder.append(" type: ");
            localStringBuilder.append(((AbsBaseArticleInfo)localObject).mFeedType);
            QLog.d("RIJDataFetchManager", 2, localStringBuilder.toString());
          }
        }
      }
    }
  }
  
  private boolean f()
  {
    Object localObject = (List)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().getSerializableExtra("subscription_all_article_id");
    boolean bool = false;
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      localObject = (Long)((List)localObject).get(0);
    } else {
      localObject = Long.valueOf(-1L);
    }
    if (((Long)localObject).longValue() != 0L) {
      bool = true;
    }
    return bool;
  }
  
  private boolean g()
  {
    if ((d()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getIntExtra("channel_from", -1) == 4))
    {
      Object localObject = (SerializableMap)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getSerializableExtra("channel_map_data");
      if ((localObject != null) && (((SerializableMap)localObject).getMap() != null))
      {
        localObject = ((SerializableMap)localObject).getMap();
        ((Long)((Map)localObject).get("param_key_ariticle_id")).longValue();
        if (((Integer)((Map)localObject).get("param_key_channel_cover_style")).intValue() == 1) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean h()
  {
    Object localObject = ((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a()).app;
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() != 70) && (!DailyModeConfigHandler.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d())))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 40677)
      {
        localObject = RIJWeiShiLegacyUtils.a.a();
        if ((localObject != null) && (((List)localObject).size() > 0)) {
          return true;
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 40830)
      {
        return true;
      }
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().hasExtra("kandian_feeds_red_pnt_info");
  }
  
  private void k()
  {
    RIJBiuAndCommentMixDataManager localRIJBiuAndCommentMixDataManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuRIJBiuAndCommentMixDataManager;
    if (localRIJBiuAndCommentMixDataManager != null) {
      localRIJBiuAndCommentMixDataManager.a();
    }
  }
  
  private void l()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a() != null) {
      try
      {
        Parcelable localParcelable = ((ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d());
        if (localParcelable != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().onRestoreInstanceState(localParcelable);
          QLog.d("RIJDataFetchManager", 1, new Object[] { "channelID: ", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d()), " restoreToHistoryPos." });
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.d("RIJDataFetchManager", 1, "restoreToHistoryPos Exception.");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("RIJDataFetchManager", 2, new Object[] { "restoreToHistoryPos cost: ", Long.valueOf(System.currentTimeMillis() - l) });
    }
  }
  
  private void m()
  {
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a();
    if (localReadInJoyBaseAdapter != null)
    {
      RIJDataManager localRIJDataManager = localReadInJoyBaseAdapter.a();
      if (localRIJDataManager != null)
      {
        localRIJDataManager.a();
        localReadInJoyBaseAdapter.notifyDataSetChanged();
        QLog.d("RIJDataFetchManager", 1, "clearListViewArticles!");
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a() != -1) {
      return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getIntExtra("channel_type", 0);
  }
  
  public RIJDataFetchManager.Builder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder;
  }
  
  public List<Long> a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent();
    Long localLong = Long.valueOf(((Intent)localObject).getLongExtra("subscription_click_article_id", -1L));
    int i = ((Intent)localObject).getIntExtra("channel_id", 0);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == i) {
      localObject = (List)((Intent)localObject).getSerializableExtra("subscription_all_article_id");
    } else {
      localObject = null;
    }
    if ((localLong.longValue() > 0L) && (localObject != null) && (((List)localObject).size() > 0))
    {
      ((List)localObject).remove(localLong);
      ((List)localObject).add(0, localLong);
    }
    return localObject;
  }
  
  public void a()
  {
    k();
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, Intent paramIntent)
  {
    if ((RIJBiuAndCommentAladdinUtils.a()) && (paramInt == 1699) && (RIJNewBiuCardTransformManager.b(paramAbsBaseArticleInfo)) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 0))
    {
      a(paramIntent);
      return;
    }
    ReadInJoyCommentUtils.a(((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a()).app, paramIntent, paramInt);
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString1, String paramString2)
  {
    if ((paramAbsBaseArticleInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == paramAbsBaseArticleInfo.mChannelID))
    {
      if (paramInt == 0)
      {
        ReadInJoyCommentUtils.a(paramAbsBaseArticleInfo, ArticleCommentModule.buildFeedsOutsideComment(paramAbsBaseArticleInfo, paramString1), false);
        ReadInJoyCommentUtils.a(paramAbsBaseArticleInfo, paramString1);
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a(), 0, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getString(2131717822), 0).a();
        QLog.d("RIJDataFetchManager", 2, "onSubmitCommentResult succeed ");
        return;
      }
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append("onSubmitCommentResult failed ");
      paramAbsBaseArticleInfo.append(paramInt);
      QLog.d("RIJDataFetchManager", 2, paramAbsBaseArticleInfo.toString());
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a(), 1, paramString2, 0).a();
    }
  }
  
  public void a(int paramInt, List<Long> paramList, RIJDataFetchManager.DataFetchManagerCallback paramDataFetchManagerCallback)
  {
    a(paramInt, paramList, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder);
    e(paramList);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().jdField_b_of_type_Long = 0L;
    boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.c() ^ true, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder, paramDataFetchManagerCallback);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.f(bool);
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).isChannelRefreshing(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d(), bool);
    if (bool)
    {
      if (DailyModeConfigHandler.c(paramInt)) {
        ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).refreshDailyReqAndRefreshNum();
      }
      if (paramInt == 0) {
        ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).refreshMainFeedsReqAndRefreshNum();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getIntExtra("launch_from", 5) == 11) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    int i;
    try
    {
      i = ((KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).e();
      if (i > 0) {
        i = 1;
      }
    }
    catch (Exception paramDataFetchManagerCallback)
    {
      paramDataFetchManagerCallback.printStackTrace();
      i = 0;
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a() instanceof ReadInJoyNewFeedsActivity)) && (paramInt == 0)) {
      bool = RIJAppSetting.a(((ReadInJoyNewFeedsActivity)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a()).b());
    } else {
      bool = true;
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.b()) && (bool)) {
      if ((paramInt == 0) && (i != 0))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() != 0) {
          l();
        }
      }
      else {
        l();
      }
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.b()) {
      DailyTipsFoldUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a(0), this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a());
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.c()) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.e(true);
    }
    a(paramList);
    g();
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 0) && (UserReadUnReadInfoManager.a().b())) {
      f();
    }
  }
  
  public void a(List<Long> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 40677) && (paramList != null) && (!paramList.isEmpty()))
    {
      long l = NetConnInfoCenter.getServerTime();
      QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
      if (localQQAppInterface != null)
      {
        paramList = ((ReadInJoyLogicManager)localQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d(), ((Long)paramList.get(0)).longValue());
        if (paramList != null) {
          RIJWeiShiLegacyUtils.a.a(RIJWeiShiLegacyUtils.a(localQQAppInterface, paramList), l);
        }
      }
    }
  }
  
  public void a(List<AbsBaseArticleInfo> paramList, int paramInt)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d(), paramList, paramInt, null, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a());
  }
  
  public void a(List<AbsBaseArticleInfo> paramList, int paramInt, IInsertArticleCallback paramIInsertArticleCallback)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d(), paramList, paramInt, paramIInsertArticleCallback, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a());
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<AbsBaseArticleInfo> paramList1)
  {
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0) && (paramInt == 56))
    {
      int k = 0;
      int i = 0;
      for (paramInt = -1; i < this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a().getChildCount(); paramInt = j)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a().getChildAt(i);
        j = paramInt;
        if (localObject != null)
        {
          j = paramInt;
          if (((View)localObject).getTag() != null)
          {
            j = paramInt;
            if ((((View)localObject).getTag() instanceof VideoFeedsViewHolder))
            {
              localObject = (VideoFeedsViewHolder)((View)localObject).getTag();
              j = paramInt;
              if (paramLong == ((VideoFeedsViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.c) {
                j = ((VideoFeedsViewHolder)localObject).jdField_a_of_type_Int;
              }
            }
          }
        }
        i += 1;
      }
      int j = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a().getHeaderViewsCount();
      i = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a().getFirstVisiblePosition() - j;
      if (i < 0) {
        i = k;
      }
      k = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a().getLastVisiblePosition() - j;
      int m = paramInt + 1;
      if ((m >= i) && (m <= k))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d()), paramList));
        this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a(m);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d()), paramList));
        this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().notifyDataSetChanged();
      }
      paramList = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a();
      if (paramList != null) {
        paramList.a(paramList1);
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("onVideoRealtimeRelpaceListRefreshed success!  reqArticleID=");
        paramList.append(paramLong);
        paramList.append(", positionRequested=");
        paramList.append(paramInt);
        paramList.append(", firstVisiblePosi=");
        paramList.append(i);
        paramList.append(", lastVisblePosi=");
        paramList.append(k);
        paramList.append("， headerCount=");
        paramList.append(j);
        QLog.d("RIJDataFetchManager", 2, paramList.toString());
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramList != null)) {
      a(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d()), paramList), 2);
    }
    if ((paramBoolean1) && (paramList == null)) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    boolean bool = paramBoolean1;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 70)
    {
      if ((!paramBoolean1) && (!paramBoolean2)) {
        paramBoolean1 = false;
      } else {
        paramBoolean1 = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().jdField_b_of_type_Boolean = paramBoolean1;
      bool = paramBoolean1;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a(bool ^ true);
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.b(NetConnInfoCenter.getServerTime());
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("autoLoad:");
      paramList.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a());
      paramList.append(" noMoreData:");
      paramList.append(bool);
      paramList.append(" fore:");
      paramList.append(GesturePWDUtils.isAppOnForeground(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a()));
      QLog.d("RIJDataFetchManager", 2, paramList.toString());
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a()) && (bool) && (GesturePWDUtils.isAppOnForeground(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a())) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() != 70))
    {
      paramList = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getResources().getString(2131717752);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getApplicationContext(), paramList, 0).a();
    }
    if ((DailyModeConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d())) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a() instanceof ReadInJoyDailyXListView))) {
      ((ReadInJoyDailyXListView)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a()).j();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.g(false);
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (!ChannelModeConfigHandler.b()) {
      ReadInJoyLogicEngineEventDispatcher.a().k();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().jdField_a_of_type_Long = System.currentTimeMillis();
    ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d(), this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().jdField_a_of_type_Long, (QQAppInterface)ReadInJoyUtils.a());
    Object localObject1 = new RIJDataFetchManager.FunctionData(null);
    Object localObject2 = ((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a()).app;
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    a((QQAppInterface)localObject2, localKandianMergeManager, (RIJDataFetchManager.FunctionData)localObject1);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().d(paramBoolean1);
    }
    localObject2 = new ArrayList();
    a((RIJDataFetchManager.FunctionData)localObject1, localKandianMergeManager, (List)localObject2);
    a(paramInt, (RIJDataFetchManager.FunctionData)localObject1, (List)localObject2);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder;
    ((RIJDataFetchManager.Builder)localObject1).c(((RIJDataFetchManager.Builder)localObject1).b() + 1);
    ReadinjoyReportUtils.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d(), this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a(), paramBoolean2, -this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getScrollY());
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 56) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L) != 0L);
  }
  
  public boolean a(boolean paramBoolean, RIJDataFetchManager.Builder paramBuilder, RIJDataFetchManager.DataFetchManagerCallback paramDataFetchManagerCallback)
  {
    if ((paramBuilder.d() == 56) && (!paramBuilder.a().f())) {
      return false;
    }
    long l = System.currentTimeMillis();
    boolean bool;
    if (paramBuilder.a().getCount() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramBoolean = a(paramBoolean, bool, ReadInJoyChannelViewPagerController.a(paramBuilder.d()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[loadFinishedRefresh], forceRefresh = ");
    localStringBuilder.append(paramBoolean);
    QLog.i("RIJDataFetchManager", 1, localStringBuilder.toString());
    int i;
    if ((!paramBoolean) && (!ReadInJoyChannelGuidingManager.a(paramBuilder.d()))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      if ((paramBuilder.d() == 0) || (DailyModeConfigHandler.c(paramBuilder.d()))) {
        ReadinjoySPEventReport.a().a.jdField_a_of_type_Boolean = true;
      }
      if ((DailyModeConfigHandler.c(paramBuilder.d())) && (!DailyModeConfigHandler.a()))
      {
        b(true, 1, false);
        return true;
      }
      paramDataFetchManagerCallback.a(true, 2);
      return true;
    }
    paramDataFetchManagerCallback = paramBuilder.a();
    if (paramBuilder.a().jdField_a_of_type_Long != 0L) {
      l = paramBuilder.a().jdField_a_of_type_Long;
    }
    paramDataFetchManagerCallback.jdField_a_of_type_Long = l;
    return false;
  }
  
  public void b()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.c();
    int j = 0;
    boolean bool;
    if (i != 0) {
      bool = true;
    } else {
      bool = false;
    }
    if ((RIJQQAppInterfaceUtil.a()) && (!d()) && (!bool)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      i = 3;
    } else {
      i = 1001;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.c() != 2)
    {
      Object localObject;
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a() instanceof ReadInJoyNewFeedsActivity))
      {
        localObject = (ReadInJoyNewFeedsActivity)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a();
        ((ReadInJoyNewFeedsActivity)localObject).d(1);
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 0) {
          ((ReadInJoyNewFeedsActivity)localObject).b(false);
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a() instanceof SplashActivity))
      {
        ReadInJoyLogicEngineEventDispatcher.a().a(2, null);
        localObject = (RIJTabFrameBase)RIJJumpUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a());
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.c() != 3) {
          j = 1;
        }
        if ((localObject != null) && (j != 0)) {
          ((RIJTabFrameBase)localObject).b(1);
        }
      }
      RIJThreadHandler.a(3);
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a() instanceof SplashActivity)) {
        ReadInJoyLogicEngineEventDispatcher.a().a(2, null);
      }
      i = 1;
    }
    b(true, i, bool);
  }
  
  public void b(int paramInt)
  {
    boolean bool = b(paramInt);
    if (bool) {
      m();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("deleteArticleInStudyMode, hasCleared=");
    localStringBuilder.append(bool);
    QLog.d("RIJDataFetchManager", 1, localStringBuilder.toString());
  }
  
  public void b(List<Long> paramList)
  {
    Object localObject = ReadInJoyUtils.a();
    if (FeedsSPUtils.a((AppRuntime)localObject))
    {
      if (!ReadInJoyHelper.D((AppRuntime)localObject)) {
        return;
      }
      if (paramList != null)
      {
        if (paramList.isEmpty()) {
          return;
        }
        int j = Math.min(paramList.size(), 5);
        localObject = new ArrayList();
        int i = 0;
        while (i < j)
        {
          long l = ((Long)paramList.get(i)).longValue();
          AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d(), l);
          if ((localAbsBaseArticleInfo != null) && (!RIJFeedsType.a(localAbsBaseArticleInfo))) {
            ((ArrayList)localObject).add(localAbsBaseArticleInfo);
          }
          i += 1;
        }
        paramList = ReadInJoyLogicEngine.a().a();
        if (paramList != null) {
          paramList.a((List)localObject);
        }
      }
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a();
    int i;
    if (DailyModeConfigHandler.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d())) {
      i = 2;
    } else {
      i = 1;
    }
    a(localActivity, i, new RIJDataFetchManager.5(this, paramBoolean1, paramInt, paramBoolean2));
  }
  
  public boolean b()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getIntExtra("launch_from", -1);
    return (i == 9) || (i == 6);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a() != null) {
      try
      {
        if ((ReadInJoyHelper.l()) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a() instanceof SplashActivity))) {
          return;
        }
        Parcelable localParcelable = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().onSaveInstanceState();
        ReadInJoyLogicManager localReadInJoyLogicManager = (ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
        localReadInJoyLogicManager.getReadInJoyLogicEngine().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d(), localParcelable);
        localReadInJoyLogicManager.getReadInJoyLogicEngine().g(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getPaddingTop());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.d("RIJDataFetchManager", 1, "updateLeaveChannelPosInfo Exception.");
      }
    }
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 0) && (paramInt != 2))
    {
      if (ReadInJoyHelper.v())
      {
        ReadInJoyLogicEngine.a().a().b(ReadInJoyHelper.e());
        return;
      }
      ReadInJoyLogicEngineEventDispatcher.a().f(2);
    }
  }
  
  public void c(List<Long> paramList)
  {
    if (!RIJWebArticleUtil.a.a()) {
      return;
    }
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      int j = Math.min(paramList.size(), 4);
      int i = 0;
      while (i < j)
      {
        long l = ((Long)paramList.get(i)).longValue();
        AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d(), l);
        if (localAbsBaseArticleInfo != null)
        {
          RIJWebArticlePreloadUtil.a.a(localAbsBaseArticleInfo);
          DataPreloadModule.INSTANCE.preloadArticle(localAbsBaseArticleInfo);
        }
        i += 1;
      }
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getIntExtra("launch_from", -1) == 13;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 56)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.b(false);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a(false);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
    }
  }
  
  public void d(int paramInt)
  {
    FastWebModule localFastWebModule = ((ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().a();
    if (localFastWebModule != null) {
      localFastWebModule.a(paramInt);
    }
  }
  
  public void d(List<Long> paramList)
  {
    if (!PreloadManager.a().a()) {
      return;
    }
    PreloadManager.a().e();
    int j = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a();
    if ((paramList != null) && (paramList.size() >= 5))
    {
      int i = 0;
      while (i < 5)
      {
        long l = ((Long)paramList.get(i)).longValue();
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a(j, l);
        if ((localObject != null) && (!RIJFeedsType.a(((AbsBaseArticleInfo)localObject).mArticleContentUrl, ((AbsBaseArticleInfo)localObject).mChannelID, (AbsBaseArticleInfo)localObject)) && (!RIJFeedsType.a((AbsBaseArticleInfo)localObject)) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a(j, ((AbsBaseArticleInfo)localObject).mArticleID)))
        {
          localObject = ((AbsBaseArticleInfo)localObject).mArticleContentUrl;
          if (PubAccountPreloadPlugin.a((String)localObject)) {
            PreloadManager.a().a((String)localObject);
          }
        }
        i += 1;
      }
    }
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() != 0;
  }
  
  public void e()
  {
    if ((d()) && (g()))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a(0);
      if (localAbsBaseArticleInfo != null) {
        ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d(), localAbsBaseArticleInfo.mTitle, localAbsBaseArticleInfo.mArticleID);
      }
    }
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a() instanceof SplashActivity;
  }
  
  public void f()
  {
    if ((UserReadUnReadInfoManager.a().a()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().getFirstVisiblePosition() == 0) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d()))
    {
      b(true, 0, false);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d(true);
      return;
    }
    UserReadUnReadInfoManager.a().a();
  }
  
  public void g()
  {
    if (a())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().getIntExtra("channel_from", 0) == 1004)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("RIJDataFetchManager_");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d());
          QLog.d(((StringBuilder)localObject1).toString(), 2, "handleJump2VideoChannelForceInsert(): 从主feeds点点流入口跳转过来，跳过强插.");
        }
        return;
      }
      long l = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      int j = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().getIntExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a();
      int i = 1;
      Object localObject1 = localObject2;
      if (j == 2)
      {
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((AbsBaseArticleInfo)localObject2).mSubArticleList != null)
          {
            localObject1 = localObject2;
            if (((AbsBaseArticleInfo)localObject2).mSubArticleList.size() == 1) {
              localObject1 = (AbsBaseArticleInfo)((AbsBaseArticleInfo)localObject2).mSubArticleList.get(0);
            }
          }
        }
      }
      if (localObject1 != null)
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = ((AbsBaseArticleInfo)localObject1).clone();
        localObject2 = ReadInJoyLogicEngine.a().a(Integer.valueOf(56));
        List localList = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().b();
        if ((localList != null) && (!localList.isEmpty()) && (localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          Object localObject3;
          if (((List)localObject2).contains(Long.valueOf(l)))
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("RIJDataFetchManager_");
              ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d());
              localObject2 = ((StringBuilder)localObject2).toString();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("handleJump2VideoChannelForceInsert(): 发现强插重复, need to delete old, sourceArticleInfo =");
              ((StringBuilder)localObject3).append(localObject1);
              QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
            }
            localObject2 = ReadInJoyLogicEngine.a().b(Integer.valueOf(56));
            if (localObject2 != null)
            {
              localObject3 = ((List)localObject2).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject2 = (AbsBaseArticleInfo)((Iterator)localObject3).next();
                if (((AbsBaseArticleInfo)localObject2).mArticleID == l) {
                  break label432;
                }
              }
            }
            localObject2 = null;
            label432:
            if (localObject2 != null)
            {
              ReadInJoyLogicEngine.a().a(56, (AbsBaseArticleInfo)localObject2, Boolean.valueOf(false));
              boolean bool = localList.remove(localObject2);
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("RIJDataFetchManager_");
                ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d());
                localObject3 = ((StringBuilder)localObject3).toString();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("delete duplicateArticleInfo: ");
                localStringBuilder.append(localObject2);
                localStringBuilder.append(", deleteDuplicateSuccess= ");
                localStringBuilder.append(bool);
                QLog.d((String)localObject3, 2, localStringBuilder.toString());
              }
            }
          }
          l = ((AbsBaseArticleInfo)localList.get(0)).mRecommendSeq;
          localAbsBaseArticleInfo.mRecommendSeq = (1L + l);
          localAbsBaseArticleInfo.mChannelID = 56L;
          if (BaseArticleInfoKt.b(localAbsBaseArticleInfo)) {
            localAbsBaseArticleInfo.mSubArticleList = null;
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("RIJDataFetchManager_");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d());
            localObject2 = ((StringBuilder)localObject2).toString();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("handleJump2VideoChannelForceInsert(): sourceArticleInfo =");
            ((StringBuilder)localObject3).append(localObject1);
            ((StringBuilder)localObject3).append(",firtstArticleSeq=");
            ((StringBuilder)localObject3).append(l);
            ((StringBuilder)localObject3).append("， insert cloneInfo=");
            ((StringBuilder)localObject3).append(localAbsBaseArticleInfo);
            QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
          }
          localObject1 = new ArrayList();
          ((List)localObject1).add(localAbsBaseArticleInfo);
          ReadInJoyLogicEngine.a().a(Integer.valueOf(56), (List)localObject1, true);
          localList.add(0, localAbsBaseArticleInfo);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().notifyDataSetChanged();
          this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a());
          if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().a() == null) {
            i = 0;
          }
          this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().setSelectionFromTop(i, 0);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a(), ReadInJoyBaseAdapter.jdField_b_of_type_Int);
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("RIJDataFetchManager_");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d());
          QLog.d(((StringBuilder)localObject1).toString(), 2, "handleJump2VideoChannelForceInsert(): adapterSeqList is empty, just ignore.");
        }
      }
    }
  }
  
  public void h()
  {
    ThreadManager.executeOnSubThread(new RIJDataFetchManager.6(this));
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().jdField_b_of_type_Long = System.currentTimeMillis();
    if (d())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 56)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().d = ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a());
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a().d = ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d());
    }
  }
  
  public void j()
  {
    if (d())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d() == 56)
      {
        ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), System.currentTimeMillis(), this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.a());
        return;
      }
      ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), System.currentTimeMillis(), this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager$Builder.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager
 * JD-Core Version:    0.7.0.1
 */