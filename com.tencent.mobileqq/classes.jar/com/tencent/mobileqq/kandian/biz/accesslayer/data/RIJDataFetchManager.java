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
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.daily.DailyTipsFoldUtils;
import com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyXListView;
import com.tencent.mobileqq.kandian.biz.feeds.ReadinjoyFixPosArticleManager;
import com.tencent.mobileqq.kandian.biz.feeds.UserReadUnReadInfoManager;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.feeds.api.impl.RIJChannelStayTimeMonitor;
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
  private RIJBiuAndCommentMixDataManager a;
  private RIJDataFetchManager.Builder b;
  
  public RIJDataFetchManager(RIJDataFetchManager.Builder paramBuilder)
  {
    this.b = paramBuilder;
  }
  
  private void A()
  {
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.b.p();
    if (localReadInJoyBaseAdapter != null)
    {
      RIJDataManager localRIJDataManager = localReadInJoyBaseAdapter.E();
      if (localRIJDataManager != null)
      {
        localRIJDataManager.d();
        localReadInJoyBaseAdapter.notifyDataSetChanged();
        QLog.d("RIJDataFetchManager", 1, "clearListViewArticles!");
      }
    }
  }
  
  public static void a(int paramInt)
  {
    ThreadManager.getUIHandler().postDelayed(new RIJDataFetchManager.3(paramInt), 3000L);
  }
  
  private void a(int paramInt, @NotNull RIJDataFetchManager.FunctionData paramFunctionData, @NotNull List<InsertArticleInfo> paramList)
  {
    Object localObject = paramFunctionData.f;
    String str2 = null;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = paramFunctionData.f.first;
    }
    String str1;
    if (paramFunctionData.f == null) {
      str1 = null;
    } else {
      str1 = (String)paramFunctionData.f.second;
    }
    if (this.b.r() == 70)
    {
      ReadInJoyLogicEngine.a().a(true, paramFunctionData.d);
      DiandianTopConfigManager.a().a(true);
      this.b.n().setNoMoreData(false);
      this.b.n().setCurrentStatus(1);
      return;
    }
    if ((this.b.m() == 6) || (this.b.m() == 7)) {
      paramFunctionData.i |= 0x800;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("FeedsRefreshType", this.b.m());
    ReadInJoyLogicEngine localReadInJoyLogicEngine = ReadInJoyLogicEngine.a();
    int i = this.b.r();
    List localList = paramFunctionData.a;
    int j = paramFunctionData.j;
    boolean bool = paramFunctionData.e;
    int k = this.b.l();
    if ((localObject instanceof String)) {
      str2 = (String)localObject;
    }
    long l;
    if ((localObject instanceof Long)) {
      l = ((Long)localObject).longValue();
    } else {
      l = -1L;
    }
    localReadInJoyLogicEngine.a(i, localList, j, true, bool, k, str2, l, str1, c(), paramFunctionData.b, paramFunctionData.c, paramFunctionData.d, paramInt, paramFunctionData.g, paramFunctionData.h, paramFunctionData.i, paramList, t(), localBundle);
  }
  
  private void a(int paramInt, List<Long> paramList, RIJDataFetchManager.Builder paramBuilder)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      a(ReadInJoyLogicEngine.a().a(Integer.valueOf(paramBuilder.r()), paramList), 1);
      Object localObject1;
      if (paramInt == 70)
      {
        localObject1 = ReadInJoyUtils.b();
        if (localObject1 != null)
        {
          paramInt = ((KandianMergeManager)((AppRuntime)localObject1).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b();
          if ((paramInt >= 0) && (paramList.size() >= paramInt)) {
            paramBuilder.n().setNoMoreData(true);
          }
        }
      }
      Object localObject2;
      StringBuilder localStringBuilder;
      if (!paramList.isEmpty())
      {
        localObject1 = (Long)paramList.get(0);
        localObject2 = ReadInJoyLogicEngine.a().a(paramBuilder.r(), ((Long)localObject1).longValue());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("load history successful ! first article title : ");
        if (localObject2 != null) {
          localObject1 = ((AbsBaseArticleInfo)localObject2).mTitle;
        } else {
          localObject1 = "";
        }
        localStringBuilder.append(RIJAppSetting.b((String)localObject1));
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
        ((StringBuilder)localObject2).append(paramBuilder.r());
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
        paramList.append(paramBuilder.r());
        QLog.d(paramList.toString(), 1, ((StringBuilder)localObject1).toString());
      }
      paramList = ReadInJoyLogicEngine.a().i();
      if (paramList != null) {
        paramBuilder.c().a(paramList.a(paramBuilder.r()), paramBuilder.n(), paramBuilder.q(), paramBuilder.r(), paramBuilder.p());
      }
    }
  }
  
  public static void a(Context paramContext, int paramInt, Runnable paramRunnable)
  {
    int j = 0;
    int i = ((Integer)RIJSPUtils.b("readinjoy_user_data_state", Integer.valueOf(0))).intValue();
    long l1 = ((Long)RIJSPUtils.b("readinjoy_user_data_time", Long.valueOf(0L))).longValue();
    int k = ((Integer)RIJSPUtils.b("readinjoy_user_data_switch", Integer.valueOf(1))).intValue();
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
        localQQCustomDialog.setPositiveButton(paramContext.getString(2131918065), new RIJDataFetchManager.1(paramInt, paramRunnable));
        localQQCustomDialog.setNegativeButton(paramContext.getString(2131918075), new RIJDataFetchManager.2(paramInt, paramRunnable));
        localQQCustomDialog.show();
        paramContext = new JSONObject();
        if (paramInt != 1) {
          break label311;
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
      PublicAccountReportUtils.a(null, "", "0X800A808", "0X800A808", 0, 0, "", "", "", paramContext.toString(), false);
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
      label311:
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
      s();
      this.a = new RIJBiuAndCommentMixDataManager();
      this.a.a(new RIJDataFetchManager.4(this, localAbsBaseArticleInfo));
      ReadInJoyCommentListFragment.a(paramIntent, this.a, 7, true, localAbsBaseArticleInfo, 1, i);
      return;
    }
    QLog.e("RIJDataFetchManager", 1, "handleMainFeedCommentRequest articleInfo is NULL");
  }
  
  private void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull KandianMergeManager paramKandianMergeManager, @NotNull RIJDataFetchManager.FunctionData paramFunctionData)
  {
    if ((this.b.r() != 0) && (this.b.r() != ChannelCoverInfoModule.g()))
    {
      if ((d()) && (!this.b.t())) {
        b(paramFunctionData, paramQQAppInterface);
      } else if (this.b.r() == 70) {
        d(paramFunctionData);
      } else if ((this.b.r() == 56) && (this.b.o() == 1001L)) {
        a(paramFunctionData, paramKandianMergeManager);
      } else if (this.b.r() == 40677) {
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
    if (this.b.r() == 40830)
    {
      c(paramFunctionData);
      return;
    }
    if (DailyModeConfigHandler.c(this.b.r()))
    {
      b(paramFunctionData);
      return;
    }
    long l = u();
    if (this.b.p() != null)
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.b.p().a(0);
      if ((l != -1L) && (localAbsBaseArticleInfo != null) && (l != localAbsBaseArticleInfo.mArticleID))
      {
        paramFunctionData.a = new ArrayList();
        paramFunctionData.a.add(Long.valueOf(l));
        paramFunctionData.j = 6;
      }
    }
  }
  
  private void a(RIJDataFetchManager.FunctionData paramFunctionData, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = RIJWeiShiLegacyUtils.a.a();
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      paramFunctionData.a = new ArrayList(paramQQAppInterface);
      paramFunctionData.j = 8;
      if (!TextUtils.isEmpty(RIJWeiShiLegacyUtils.a.c())) {
        paramFunctionData.d = RIJWeiShiLegacyUtils.a.c();
      }
    }
    RIJWeiShiLegacyUtils.a.a(this.b.q());
  }
  
  private void a(RIJDataFetchManager.FunctionData paramFunctionData, KandianMergeManager paramKandianMergeManager)
  {
    paramFunctionData.i |= 0x2;
    KandianRedDotInfo localKandianRedDotInfo = paramKandianMergeManager.L();
    if (localKandianRedDotInfo != null)
    {
      if (localKandianRedDotInfo.hasArticleID())
      {
        paramFunctionData.a = localKandianRedDotInfo.articleIDList;
        paramFunctionData.d = localKandianRedDotInfo.cookie;
        paramFunctionData.b = localKandianRedDotInfo.algorithmID;
        paramFunctionData.c = localKandianRedDotInfo.strategyID;
        paramFunctionData.j = 1;
        paramFunctionData.i |= 0x8;
      }
      else
      {
        paramFunctionData.i |= 0x4;
      }
      paramKandianMergeManager.K();
    }
  }
  
  private void a(@NotNull RIJDataFetchManager.FunctionData paramFunctionData, @NotNull KandianMergeManager paramKandianMergeManager, @NotNull List<InsertArticleInfo> paramList)
  {
    if (f())
    {
      paramList.addAll(paramKandianMergeManager.V());
      paramFunctionData.i |= 0x80;
    }
    if (UserReadUnReadInfoManager.a().b()) {
      paramFunctionData.i |= 0x1000;
    }
  }
  
  private static void a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt1, List<AbsBaseArticleInfo> paramList, int paramInt2, IInsertArticleCallback paramIInsertArticleCallback, RIJFrameworkHeaderManager paramRIJFrameworkHeaderManager)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramReadInJoyBaseAdapter.h().iterator();
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
    if ((paramInt1 == 0) || (DailyModeConfigHandler.b(DailyModeConfigHandler.j()))) {
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
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null)
    {
      QLog.d("RIJDataFetchManager", 1, "isDynamicCard error! articleInfo is null!");
      return false;
    }
    if (paramAbsBaseArticleInfo.articleInsertInfo.a)
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
    return paramAbsBaseArticleInfo.articleInsertInfo.a;
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (this.b.q() != null)
    {
      Intent localIntent = this.b.q().getIntent();
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
    boolean bool5 = x();
    Object localObject = (KandianMergeManager)((BaseActivity)this.b.q()).app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    long l;
    if (this.b.r() == 70) {
      l = ((Integer)RIJSPUtils.b("sp_key_kandian_subscribe_auto_refresh_config", Integer.valueOf(600))).intValue() * 1000;
    } else {
      l = 300000L;
    }
    if (DailyModeConfigHandler.a(this.b.r())) {
      l = y();
    }
    boolean bool3;
    if (System.currentTimeMillis() - this.b.s().g > l) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    boolean bool6 = w();
    boolean bool2;
    if ((d()) && (!this.b.t())) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool1 = ((Boolean)RIJSPUtils.b("key_sp_entrance_follow", Boolean.valueOf(false))).booleanValue();
    if (bool1) {
      RIJSPUtils.a("key_sp_entrance_follow", Boolean.valueOf(false));
    }
    boolean bool4;
    if ((ReadInJoyHelper.v()) && (this.b.r() == 56) && (this.b.o() == 1001L) && (((KandianMergeManager)localObject).M())) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    boolean bool7 = a(this.b.i());
    this.b.c(bool7);
    if ((!paramBoolean1) && (!bool3) && (!bool6) && (!bool5) && (!bool2) && (!bool4) && (!this.b.i()) && (!bool1)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("RIJDataFetchManager_");
    ((StringBuilder)localObject).append(this.b.r());
    QLog.d(((StringBuilder)localObject).toString(), 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool3), Boolean.valueOf(bool6), Boolean.valueOf(bool5), Boolean.valueOf(bool2), Boolean.valueOf(bool4) }));
    if (m())
    {
      bool3 = RIJChannelStayTimeMonitor.INSTANCE.isLastExitChannelOverTimeLimit(this.b.r());
      if ((!paramBoolean1) && (!bool3) && (!bool6) && (!bool5) && (!bool2) && (!bool4) && (!paramBoolean2)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      QLog.d("RIJDataFetchManager", 1, String.format("new channel tab, loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s, isNeedRefreshChannel=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool3), Boolean.valueOf(bool6), Boolean.valueOf(bool5), Boolean.valueOf(bool2), Boolean.valueOf(bool4), Boolean.valueOf(paramBoolean2) }));
      return bool1;
    }
    if (e(this.b.r())) {
      bool1 = true;
    }
    return bool1;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (h()) {
      return a(paramBoolean2, paramBoolean3);
    }
    return b(paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  private void b(@NotNull RIJDataFetchManager.FunctionData paramFunctionData)
  {
    KandianRedDotInfo localKandianRedDotInfo = (KandianRedDotInfo)this.b.q().getIntent().getSerializableExtra("kandian_feeds_red_pnt_info");
    if ((localKandianRedDotInfo != null) && (!localKandianRedDotInfo.shouldRemoveFloatingRedPntArticleId()))
    {
      paramFunctionData.b = localKandianRedDotInfo.algorithmID;
      paramFunctionData.c = localKandianRedDotInfo.strategyID;
      paramFunctionData.a = localKandianRedDotInfo.articleIDList;
      paramFunctionData.j = 1;
      paramFunctionData.d = localKandianRedDotInfo.cookie;
      this.b.q().getIntent().removeExtra("kandian_feeds_red_pnt_info");
    }
  }
  
  private void b(RIJDataFetchManager.FunctionData paramFunctionData, QQAppInterface paramQQAppInterface)
  {
    long l = this.b.j().cQ_().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
    boolean bool = this.b.j().cQ_().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", false);
    this.b.b(true);
    this.b.a(true);
    if (bool)
    {
      Object localObject = (AbsBaseArticleInfo)this.b.j().cQ_().getIntent().getParcelableExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO");
      if (localObject != null)
      {
        paramFunctionData.f = new Pair(((AbsBaseArticleInfo)localObject).getInnerUniqueID(), ((AbsBaseArticleInfo)localObject).mTitle);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("ArticleId", RIJStringUtils.b(((AbsBaseArticleInfo)localObject).mArticleID));
          localJSONObject.put("FeedsId", RIJStringUtils.b(((AbsBaseArticleInfo)localObject).mFeedId));
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
          paramFunctionData.d = localJSONObject.toString();
        }
        catch (JSONException paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          paramFunctionData.d = null;
        }
      }
    }
    else
    {
      paramFunctionData.a = new ArrayList();
      paramFunctionData.a.add(Long.valueOf(l));
    }
    paramFunctionData.j = 5;
  }
  
  private void b(RIJDataFetchManager.FunctionData paramFunctionData, KandianMergeManager paramKandianMergeManager)
  {
    boolean bool = this.b.s().e;
    int i = 0;
    int j = 0;
    if (bool)
    {
      paramFunctionData.a = g();
      paramFunctionData.e = v();
      this.b.s().e = false;
      if (this.b.q().getIntent().getIntExtra("launch_from", -1) == 8) {
        bool = true;
      } else {
        bool = false;
      }
      paramFunctionData.g = bool;
      paramFunctionData.h = ((LebaKDCellInfo)this.b.q().getIntent().getSerializableExtra("param_leba_cell_articleinfo"));
    }
    if (paramFunctionData.a == null)
    {
      paramFunctionData.a = paramKandianMergeManager.g();
      if ((paramFunctionData.a != null) && (paramFunctionData.a.size() > 2))
      {
        paramFunctionData.b = ((Long)paramFunctionData.a.get(paramFunctionData.a.size() - 2)).longValue();
        paramFunctionData.c = ((Long)paramFunctionData.a.get(paramFunctionData.a.size() - 1)).longValue();
        paramFunctionData.a = paramFunctionData.a.subList(0, paramFunctionData.a.size() - 2);
        paramFunctionData.j = 1;
        paramFunctionData.d = paramKandianMergeManager.h();
      }
      i = j;
      if (e())
      {
        Object localObject = paramKandianMergeManager.e();
        i = j;
        if (localObject != null)
        {
          ArrayList localArrayList = ((KandianRedDotInfo)localObject).articleIDList;
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            paramFunctionData.a = new ArrayList();
            paramFunctionData.d = ((KandianRedDotInfo)localObject).cookie;
            i = localArrayList.size() - 1;
            while (i >= 0)
            {
              localObject = (Long)localArrayList.get(i);
              paramFunctionData.a.add(0, localObject);
              i -= 1;
            }
          }
          i = 1;
        }
      }
      paramKandianMergeManager.r();
      paramKandianMergeManager.q();
    }
    paramFunctionData.f = paramKandianMergeManager.i();
    paramKandianMergeManager.I();
    if (i != 0) {
      paramFunctionData.i |= 0x20;
    }
  }
  
  private boolean b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1 = ((BaseActivity)this.b.q()).app;
    Object localObject2 = (KandianMergeManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    boolean bool1 = ReadInJoyHelper.a((AppInterface)localObject1);
    boolean bool4 = false;
    if (bool1)
    {
      bool1 = ((KandianMergeManager)localObject2).d();
    }
    else
    {
      localObject2 = g();
      if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    boolean bool5 = this.b.q() instanceof ReadInJoyNewFeedsActivity;
    long l;
    if (bool5) {
      l = ReadInJoyHelper.au((AppRuntime)localObject1);
    } else {
      l = ReadInJoyHelper.at((AppRuntime)localObject1);
    }
    int i;
    if (System.currentTimeMillis() - this.b.s().d > l) {
      i = 1;
    } else {
      i = 0;
    }
    localObject1 = this.b.q().getIntent();
    boolean bool6 = ((Intent)localObject1).getBooleanExtra("from_search", false);
    boolean bool3;
    if ((f()) && (((Intent)localObject1).getBooleanExtra("force_refresh", false))) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    if (f()) {
      ((Intent)localObject1).removeExtra("force_refresh");
    }
    int j;
    if (this.b.q().getIntent().getIntExtra("launch_from", -1) == 8) {
      j = 1;
    } else {
      j = 0;
    }
    boolean bool2 = m();
    int k = 6;
    if (bool2)
    {
      bool4 = RIJChannelStayTimeMonitor.INSTANCE.isLastExitChannelOverTimeLimit(this.b.r());
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
    Intent localIntent = this.b.q().getIntent();
    if (localIntent != null)
    {
      SerializableMap localSerializableMap = (SerializableMap)localIntent.getSerializableExtra("channel_map_data");
      if (localSerializableMap != null)
      {
        Long localLong = (Long)localSerializableMap.getMap().remove("articleID");
        if (localLong != null)
        {
          paramFunctionData.a = new ArrayList();
          paramFunctionData.a.add(localLong);
          localIntent.putExtra("channel_map_data", localSerializableMap);
        }
        paramFunctionData.j = 9;
        paramFunctionData.d = ((String)localSerializableMap.getMap().get("pushContext"));
      }
    }
  }
  
  private void d(RIJDataFetchManager.FunctionData paramFunctionData)
  {
    KandianRedDotInfo localKandianRedDotInfo = (KandianRedDotInfo)this.b.q().getIntent().getSerializableExtra("kandian_feeds_red_pnt_info");
    if (localKandianRedDotInfo != null)
    {
      paramFunctionData.d = localKandianRedDotInfo.cookie;
      this.b.q().getIntent().removeExtra("kandian_feeds_red_pnt_info");
    }
  }
  
  private void e(List<Long> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && ((this.b.r() == 0) || (this.b.r() == 70) || (DailyModeConfigHandler.c(this.b.r()))))
    {
      this.b.b(NetConnInfoCenter.getServerTime());
      this.b.a(ReadInJoyLogicEngine.a().a(this.b.r(), ((Long)paramList.get(0)).longValue()));
      paramList = (QQAppInterface)ReadInJoyUtils.b();
      if ((this.b.d() != null) && (paramList != null))
      {
        if (this.b.r() == 0)
        {
          paramList = FeedsStructMsg.a(paramList, this.b.d());
          String str = FeedsStructMsg.a(this.b.d());
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createFakeStructingMsgWithFields(((BaseActivity)this.b.j().cQ_()).app, str, String.valueOf(this.b.e()), paramList, false);
          return;
        }
        if (this.b.r() == 70)
        {
          ((KandianSubscribeManager)paramList.getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER)).a(this.b.d(), this.b.e());
          return;
        }
        if (DailyModeConfigHandler.c(this.b.r())) {
          ((KandianDailyManager)paramList.getManager(QQManagerFactory.KANDIAN_DAILY_MANAGER)).a(this.b.d());
        }
      }
    }
  }
  
  private boolean e(int paramInt)
  {
    return (paramInt != 70) && (paramInt != 56) && (paramInt != 40677) && (!DailyModeConfigHandler.c(paramInt));
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
  
  private boolean f(int paramInt)
  {
    ArticleInfoModule localArticleInfoModule = ReadInJoyLogicEngine.a().ab();
    if (localArticleInfoModule != null)
    {
      localArticleInfoModule.i().e(paramInt);
      localArticleInfoModule.i().a();
      return true;
    }
    return false;
  }
  
  private void s()
  {
    RIJBiuAndCommentMixDataManager localRIJBiuAndCommentMixDataManager = this.a;
    if (localRIJBiuAndCommentMixDataManager != null) {
      localRIJBiuAndCommentMixDataManager.a();
    }
  }
  
  private List<ReadInJoyRequestParams.PkgInstallInfo> t()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.b.r() == 56)
    {
      ReadInJoyRequestParams.PkgInstallInfo localPkgInstallInfo = new ReadInJoyRequestParams.PkgInstallInfo();
      localPkgInstallInfo.a = "com.tencent.weishi";
      localPkgInstallInfo.b = PackageUtil.a(this.b.q(), localPkgInstallInfo.a);
      localArrayList.add(localPkgInstallInfo);
    }
    return localArrayList;
  }
  
  private long u()
  {
    if ((h()) && (this.b.q().getIntent().getIntExtra("channel_from", -1) == 4))
    {
      Object localObject = (SerializableMap)this.b.q().getIntent().getSerializableExtra("channel_map_data");
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
  
  private boolean v()
  {
    Object localObject = (List)this.b.j().cQ_().getIntent().getSerializableExtra("subscription_all_article_id");
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
  
  private boolean w()
  {
    if ((h()) && (this.b.q().getIntent().getIntExtra("channel_from", -1) == 4))
    {
      Object localObject = (SerializableMap)this.b.q().getIntent().getSerializableExtra("channel_map_data");
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
  
  private boolean x()
  {
    Object localObject = ((BaseActivity)this.b.q()).app;
    if ((this.b.r() != 70) && (!DailyModeConfigHandler.c(this.b.r())))
    {
      if (this.b.r() == 40677)
      {
        localObject = RIJWeiShiLegacyUtils.a.a();
        if ((localObject != null) && (((List)localObject).size() > 0)) {
          return true;
        }
      }
      else if (this.b.r() == 40830)
      {
        return true;
      }
      return false;
    }
    return this.b.q().getIntent().hasExtra("kandian_feeds_red_pnt_info");
  }
  
  private long y()
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
        break label91;
      }
    }
    long l = 9223372036854775807L;
    label91:
    QLog.d("RIJDataFetchManager", 1, new Object[] { "getDailyRefreshTimeLimit, res = ", Long.valueOf(l) });
    return l;
  }
  
  private void z()
  {
    long l = System.currentTimeMillis();
    if (this.b.n() != null) {
      try
      {
        Parcelable localParcelable = ((ReadInJoyLogicManager)ReadInJoyUtils.b().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().m(this.b.r());
        if (localParcelable != null)
        {
          this.b.n().onRestoreInstanceState(localParcelable);
          QLog.d("RIJDataFetchManager", 1, new Object[] { "channelID: ", Integer.valueOf(this.b.r()), " restoreToHistoryPos." });
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
  
  public RIJDataFetchManager.Builder a()
  {
    return this.b;
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, Intent paramIntent)
  {
    if ((RIJBiuAndCommentAladdinUtils.a()) && (paramInt == 1699) && (RIJNewBiuCardTransformManager.b(paramAbsBaseArticleInfo)) && (this.b.r() == 0))
    {
      a(paramIntent);
      return;
    }
    ReadInJoyCommentUtils.a(((BaseActivity)this.b.q()).app, paramIntent, paramInt);
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString1, String paramString2)
  {
    if ((paramAbsBaseArticleInfo != null) && (this.b.r() == paramAbsBaseArticleInfo.mChannelID))
    {
      if (paramInt == 0)
      {
        ReadInJoyCommentUtils.a(paramAbsBaseArticleInfo, ArticleCommentModule.buildFeedsOutsideComment(paramAbsBaseArticleInfo, paramString1), false);
        ReadInJoyCommentUtils.a(paramAbsBaseArticleInfo, paramString1);
        QQToast.makeText(this.b.q(), 0, this.b.q().getString(2131915297), 0).show();
        QLog.d("RIJDataFetchManager", 2, "onSubmitCommentResult succeed ");
        return;
      }
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append("onSubmitCommentResult failed ");
      paramAbsBaseArticleInfo.append(paramInt);
      QLog.d("RIJDataFetchManager", 2, paramAbsBaseArticleInfo.toString());
      QQToast.makeText(this.b.q(), 1, paramString2, 0).show();
    }
  }
  
  public void a(int paramInt, List<Long> paramList, RIJDataFetchManager.DataFetchManagerCallback paramDataFetchManagerCallback)
  {
    a(paramInt, paramList, this.b);
    e(paramList);
    this.b.s().c = 0L;
    boolean bool = a(this.b.g() ^ true, this.b, paramDataFetchManagerCallback);
    this.b.f(bool);
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).isChannelRefreshing(this.b.r(), bool);
    if (bool)
    {
      if (DailyModeConfigHandler.c(paramInt)) {
        ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).refreshDailyReqAndRefreshNum();
      }
      if (paramInt == 0) {
        ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).refreshMainFeedsReqAndRefreshNum();
      }
    }
    if (this.b.q().getIntent().getIntExtra("launch_from", 5) == 11) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    int i;
    try
    {
      i = ((KandianMergeManager)ReadInJoyUtils.b().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).R();
      if (i > 0) {
        i = 1;
      }
    }
    catch (Exception paramDataFetchManagerCallback)
    {
      paramDataFetchManagerCallback.printStackTrace();
      i = 0;
    }
    if (((this.b.q() instanceof ReadInJoyNewFeedsActivity)) && (paramInt == 0)) {
      bool = RIJAppSetting.b(((ReadInJoyNewFeedsActivity)this.b.q()).p());
    } else {
      bool = true;
    }
    if ((!this.b.f()) && (bool)) {
      if ((paramInt == 0) && (i != 0))
      {
        if (this.b.r() != 0) {
          z();
        }
      }
      else {
        z();
      }
    }
    if (!this.b.f()) {
      DailyTipsFoldUtils.a(this.b.p().a(0), this.b.n());
    }
    if (!this.b.g()) {
      this.b.e(true);
    }
    a(paramList);
    o();
    if ((this.b.r() == 0) && (UserReadUnReadInfoManager.a().c())) {
      n();
    }
  }
  
  public void a(List<Long> paramList)
  {
    if ((this.b.r() == 40677) && (paramList != null) && (!paramList.isEmpty()))
    {
      long l = NetConnInfoCenter.getServerTime();
      QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.b();
      if (localQQAppInterface != null)
      {
        paramList = ((ReadInJoyLogicManager)localQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().a(this.b.r(), ((Long)paramList.get(0)).longValue());
        if (paramList != null) {
          RIJWeiShiLegacyUtils.a.a(RIJWeiShiLegacyUtils.a(localQQAppInterface, paramList), l);
        }
      }
    }
  }
  
  public void a(List<AbsBaseArticleInfo> paramList, int paramInt)
  {
    a(this.b.p(), this.b.r(), paramList, paramInt, null, this.b.c());
  }
  
  public void a(List<AbsBaseArticleInfo> paramList, int paramInt, IInsertArticleCallback paramIInsertArticleCallback)
  {
    a(this.b.p(), this.b.r(), paramList, paramInt, paramIInsertArticleCallback, this.b.c());
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<AbsBaseArticleInfo> paramList1)
  {
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0) && (paramInt == 56))
    {
      int k = 0;
      int i = 0;
      for (paramInt = -1; i < this.b.p().d().getChildCount(); paramInt = j)
      {
        Object localObject = this.b.p().d().getChildAt(i);
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
              if (paramLong == ((VideoFeedsViewHolder)localObject).t.j) {
                j = ((VideoFeedsViewHolder)localObject).P;
              }
            }
          }
        }
        i += 1;
      }
      int j = this.b.p().d().getHeaderViewsCount();
      i = this.b.p().d().getFirstVisiblePosition() - j;
      if (i < 0) {
        i = k;
      }
      k = this.b.p().d().getLastVisiblePosition() - j;
      int m = paramInt + 1;
      if ((m >= i) && (m <= k))
      {
        this.b.p().a(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.b.r()), paramList));
        this.b.p().q_(m);
      }
      else
      {
        this.b.p().a(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.b.r()), paramList));
        this.b.p().notifyDataSetChanged();
      }
      paramList = this.b.j().s();
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
      a(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.b.r()), paramList), 2);
    }
    if ((paramBoolean1) && (paramList == null)) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    boolean bool = paramBoolean1;
    if (this.b.r() == 70)
    {
      if ((!paramBoolean1) && (!paramBoolean2)) {
        paramBoolean1 = false;
      } else {
        paramBoolean1 = true;
      }
      this.b.n().j = paramBoolean1;
      bool = paramBoolean1;
    }
    this.b.n().a(bool ^ true);
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.b.b(NetConnInfoCenter.getServerTime());
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("autoLoad:");
      paramList.append(this.b.b());
      paramList.append(" noMoreData:");
      paramList.append(bool);
      paramList.append(" fore:");
      paramList.append(GesturePWDUtils.isAppOnForeground(this.b.q()));
      QLog.d("RIJDataFetchManager", 2, paramList.toString());
    }
    if ((!this.b.b()) && (bool) && (GesturePWDUtils.isAppOnForeground(this.b.q())) && (this.b.r() != 70))
    {
      paramList = this.b.q().getResources().getString(2131915227);
      QQToast.makeText(this.b.q().getApplicationContext(), paramList, 0).show();
    }
    if ((DailyModeConfigHandler.a(this.b.r())) && ((this.b.n() instanceof ReadInJoyDailyXListView))) {
      ((ReadInJoyDailyXListView)this.b.n()).k();
    }
    this.b.g(false);
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (!ChannelModeConfigHandler.b()) {
      ReadInJoyLogicEngineEventDispatcher.a().k();
    }
    this.b.s().b = System.currentTimeMillis();
    ReadInJoyHelper.a(this.b.r(), this.b.s().b, (QQAppInterface)ReadInJoyUtils.b());
    Object localObject1 = new RIJDataFetchManager.FunctionData(null);
    Object localObject2 = ((BaseActivity)this.b.q()).app;
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    a((QQAppInterface)localObject2, localKandianMergeManager, (RIJDataFetchManager.FunctionData)localObject1);
    if (this.b.p() != null) {
      this.b.p().d(paramBoolean1);
    }
    localObject2 = new ArrayList();
    a((RIJDataFetchManager.FunctionData)localObject1, localKandianMergeManager, (List)localObject2);
    a(paramInt, (RIJDataFetchManager.FunctionData)localObject1, (List)localObject2);
    localObject1 = this.b;
    ((RIJDataFetchManager.Builder)localObject1).c(((RIJDataFetchManager.Builder)localObject1).l() + 1);
    ReadinjoyReportUtils.a(paramInt, this.b.r(), this.b.q(), paramBoolean2, -this.b.n().getScrollY());
  }
  
  public boolean a(boolean paramBoolean, RIJDataFetchManager.Builder paramBuilder, RIJDataFetchManager.DataFetchManagerCallback paramDataFetchManagerCallback)
  {
    if ((paramBuilder.r() == 56) && (!paramBuilder.p().O())) {
      return false;
    }
    long l = System.currentTimeMillis();
    boolean bool;
    if (paramBuilder.p().getCount() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramBoolean = a(paramBoolean, bool, ReadInJoyChannelViewPagerController.e(paramBuilder.r()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[loadFinishedRefresh], forceRefresh = ");
    localStringBuilder.append(paramBoolean);
    QLog.i("RIJDataFetchManager", 1, localStringBuilder.toString());
    int i;
    if ((!paramBoolean) && (!ReadInJoyChannelGuidingManager.a(paramBuilder.r()))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      if ((paramBuilder.r() == 0) || (DailyModeConfigHandler.c(paramBuilder.r()))) {
        ReadinjoySPEventReport.a().f.i = true;
      }
      if ((DailyModeConfigHandler.c(paramBuilder.r())) && (!DailyModeConfigHandler.g()))
      {
        b(true, 1, false);
        return true;
      }
      paramDataFetchManagerCallback.a(true, 2);
      return true;
    }
    paramDataFetchManagerCallback = paramBuilder.s();
    if (paramBuilder.s().b != 0L) {
      l = paramBuilder.s().b;
    }
    paramDataFetchManagerCallback.b = l;
    return false;
  }
  
  public void b()
  {
    s();
  }
  
  public void b(int paramInt)
  {
    boolean bool = f(paramInt);
    if (bool) {
      A();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("deleteArticleInStudyMode, hasCleared=");
    localStringBuilder.append(bool);
    QLog.d("RIJDataFetchManager", 1, localStringBuilder.toString());
  }
  
  public void b(List<Long> paramList)
  {
    Object localObject = ReadInJoyUtils.b();
    if (FeedsSPUtils.a((AppRuntime)localObject))
    {
      if (!ReadInJoyHelper.ap((AppRuntime)localObject)) {
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
          AbsBaseArticleInfo localAbsBaseArticleInfo = this.b.p().a(this.b.r(), l);
          if ((localAbsBaseArticleInfo != null) && (!RIJFeedsType.a(localAbsBaseArticleInfo))) {
            ((ArrayList)localObject).add(localAbsBaseArticleInfo);
          }
          i += 1;
        }
        paramList = ReadInJoyLogicEngine.a().d();
        if (paramList != null) {
          paramList.a((List)localObject);
        }
      }
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Activity localActivity = this.b.q();
    int i;
    if (DailyModeConfigHandler.c(this.b.r())) {
      i = 2;
    } else {
      i = 1;
    }
    a(localActivity, i, new RIJDataFetchManager.5(this, paramBoolean1, paramInt, paramBoolean2));
  }
  
  public int c()
  {
    if (this.b.k() != -1) {
      return this.b.k();
    }
    return this.b.q().getIntent().getIntExtra("channel_type", 0);
  }
  
  public void c(int paramInt)
  {
    if ((this.b.r() == 0) && (paramInt != 2))
    {
      if (ReadInJoyHelper.L())
      {
        ReadInJoyLogicEngine.a().l().b(ReadInJoyHelper.K());
        return;
      }
      ReadInJoyLogicEngineEventDispatcher.a().e(2);
    }
  }
  
  public void c(List<Long> paramList)
  {
    if (!RIJWebArticleUtil.a.b()) {
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
        AbsBaseArticleInfo localAbsBaseArticleInfo = this.b.p().a(this.b.r(), l);
        if (localAbsBaseArticleInfo != null)
        {
          RIJWebArticlePreloadUtil.a.a(localAbsBaseArticleInfo);
          DataPreloadModule.INSTANCE.preloadArticle(localAbsBaseArticleInfo);
        }
        i += 1;
      }
    }
  }
  
  public void d(int paramInt)
  {
    FastWebModule localFastWebModule = ((ReadInJoyLogicManager)ReadInJoyUtils.b().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().d();
    if (localFastWebModule != null) {
      localFastWebModule.a(paramInt);
    }
  }
  
  public void d(List<Long> paramList)
  {
    if (!PreloadManager.a().f()) {
      return;
    }
    PreloadManager.a().h();
    int j = this.b.p().c();
    if ((paramList != null) && (paramList.size() >= 5))
    {
      int i = 0;
      while (i < 5)
      {
        long l = ((Long)paramList.get(i)).longValue();
        Object localObject = this.b.p().a(j, l);
        if ((localObject != null) && (!RIJFeedsType.a(((AbsBaseArticleInfo)localObject).mArticleContentUrl, ((AbsBaseArticleInfo)localObject).mChannelID, (AbsBaseArticleInfo)localObject)) && (!RIJFeedsType.a((AbsBaseArticleInfo)localObject)) && (!this.b.p().b(j, ((AbsBaseArticleInfo)localObject).mArticleID)))
        {
          localObject = ((AbsBaseArticleInfo)localObject).mArticleContentUrl;
          if (PubAccountPreloadPlugin.a((String)localObject)) {
            PreloadManager.a().b((String)localObject);
          }
        }
        i += 1;
      }
    }
  }
  
  public boolean d()
  {
    return (this.b.r() == 56) && (this.b.j().cQ_().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L) != 0L);
  }
  
  public boolean e()
  {
    int i = this.b.q().getIntent().getIntExtra("launch_from", -1);
    return (i == 9) || (i == 6);
  }
  
  public boolean f()
  {
    return this.b.q().getIntent().getIntExtra("launch_from", -1) == 13;
  }
  
  public List<Long> g()
  {
    Object localObject = this.b.j().cQ_().getIntent();
    Long localLong = Long.valueOf(((Intent)localObject).getLongExtra("subscription_click_article_id", -1L));
    int i = ((Intent)localObject).getIntExtra("channel_id", 0);
    if (this.b.r() == i) {
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
  
  public boolean h()
  {
    return this.b.r() != 0;
  }
  
  public void i()
  {
    int i = this.b.m();
    int j = 0;
    boolean bool;
    if (i != 0) {
      bool = true;
    } else {
      bool = false;
    }
    if ((RIJQQAppInterfaceUtil.g()) && (!h()) && (!bool)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      i = 3;
    } else {
      i = 1001;
    }
    if (this.b.m() != 2)
    {
      Object localObject;
      if ((this.b.q() instanceof ReadInJoyNewFeedsActivity))
      {
        localObject = (ReadInJoyNewFeedsActivity)this.b.q();
        ((ReadInJoyNewFeedsActivity)localObject).e(1);
        if (this.b.r() == 0) {
          ((ReadInJoyNewFeedsActivity)localObject).b(false);
        }
      }
      else if ((this.b.q() instanceof SplashActivity))
      {
        ReadInJoyLogicEngineEventDispatcher.a().a(2, null);
        localObject = (RIJTabFrameBase)RIJJumpUtils.a(this.b.q());
        if (this.b.m() != 3) {
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
      if ((this.b.q() instanceof SplashActivity)) {
        ReadInJoyLogicEngineEventDispatcher.a().a(2, null);
      }
      i = 1;
    }
    b(true, i, bool);
  }
  
  public void j()
  {
    if (this.b.n() != null) {
      try
      {
        if ((ReadInJoyHelper.v()) && ((this.b.j().cQ_() instanceof SplashActivity))) {
          return;
        }
        Parcelable localParcelable = this.b.n().onSaveInstanceState();
        ReadInJoyLogicManager localReadInJoyLogicManager = (ReadInJoyLogicManager)ReadInJoyUtils.b().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
        localReadInJoyLogicManager.getReadInJoyLogicEngine().a(this.b.r(), localParcelable);
        localReadInJoyLogicManager.getReadInJoyLogicEngine().l(this.b.n().getPaddingTop());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.d("RIJDataFetchManager", 1, "updateLeaveChannelPosInfo Exception.");
      }
    }
  }
  
  public void k()
  {
    if (this.b.r() == 56)
    {
      this.b.b(false);
      this.b.a(false);
      this.b.j().cQ_().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      this.b.j().cQ_().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
      this.b.j().cQ_().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
      this.b.j().cQ_().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
    }
  }
  
  public void l()
  {
    if ((h()) && (w()))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.b.p().a(0);
      if (localAbsBaseArticleInfo != null) {
        ReadInJoyLogicEngine.a().a(this.b.r(), localAbsBaseArticleInfo.mTitle, localAbsBaseArticleInfo.mArticleID);
      }
    }
  }
  
  public boolean m()
  {
    return this.b.q() instanceof SplashActivity;
  }
  
  public void n()
  {
    if ((UserReadUnReadInfoManager.a().b()) && (this.b.n().getFirstVisiblePosition() == 0) && (!this.b.h()))
    {
      b(true, 0, false);
      this.b.d(true);
      return;
    }
    UserReadUnReadInfoManager.a().e();
  }
  
  public void o()
  {
    if (d())
    {
      if (this.b.j().cQ_().getIntent().getIntExtra("channel_from", 0) == 1004)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("RIJDataFetchManager_");
          ((StringBuilder)localObject1).append(this.b.r());
          QLog.d(((StringBuilder)localObject1).toString(), 2, "handleJump2VideoChannelForceInsert(): 从主feeds点点流入口跳转过来，跳过强插.");
        }
        return;
      }
      long l = this.b.j().cQ_().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      int j = this.b.j().cQ_().getIntent().getIntExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
      Object localObject2 = this.b.p().L();
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
        localObject2 = ReadInJoyLogicEngine.a().c(Integer.valueOf(56));
        List localList = this.b.p().h();
        if ((localList != null) && (!localList.isEmpty()) && (localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          Object localObject3;
          if (((List)localObject2).contains(Long.valueOf(l)))
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("RIJDataFetchManager_");
              ((StringBuilder)localObject2).append(this.b.r());
              localObject2 = ((StringBuilder)localObject2).toString();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("handleJump2VideoChannelForceInsert(): 发现强插重复, need to delete old, sourceArticleInfo =");
              ((StringBuilder)localObject3).append(localObject1);
              QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
            }
            localObject2 = ReadInJoyLogicEngine.a().d(Integer.valueOf(56));
            if (localObject2 != null)
            {
              localObject3 = ((List)localObject2).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject2 = (AbsBaseArticleInfo)((Iterator)localObject3).next();
                if (((AbsBaseArticleInfo)localObject2).mArticleID == l) {
                  break label433;
                }
              }
            }
            localObject2 = null;
            label433:
            if (localObject2 != null)
            {
              ReadInJoyLogicEngine.a().a(56, (AbsBaseArticleInfo)localObject2, Boolean.valueOf(false));
              boolean bool = localList.remove(localObject2);
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("RIJDataFetchManager_");
                ((StringBuilder)localObject3).append(this.b.r());
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
            ((StringBuilder)localObject2).append(this.b.r());
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
          this.b.p().notifyDataSetChanged();
          this.b.n().setAdapter(this.b.p());
          if (this.b.c().a() == null) {
            i = 0;
          }
          this.b.n().setSelectionFromTop(i, 0);
          this.b.p().b(this.b.n(), ReadInJoyBaseAdapter.b);
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("RIJDataFetchManager_");
          ((StringBuilder)localObject1).append(this.b.r());
          QLog.d(((StringBuilder)localObject1).toString(), 2, "handleJump2VideoChannelForceInsert(): adapterSeqList is empty, just ignore.");
        }
      }
    }
  }
  
  public void p()
  {
    ThreadManager.executeOnSubThread(new RIJDataFetchManager.6(this));
  }
  
  public void q()
  {
    this.b.s().c = System.currentTimeMillis();
    if (h())
    {
      if (this.b.r() == 56)
      {
        this.b.s().g = ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.b(), this.b.q());
        return;
      }
      this.b.s().g = ReadInJoyHelper.b((QQAppInterface)ReadInJoyUtils.b(), this.b.r());
    }
  }
  
  public void r()
  {
    if (h())
    {
      if (this.b.r() == 56)
      {
        ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.b(), System.currentTimeMillis(), this.b.q());
        return;
      }
      ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.b(), System.currentTimeMillis(), this.b.r());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager
 * JD-Core Version:    0.7.0.1
 */