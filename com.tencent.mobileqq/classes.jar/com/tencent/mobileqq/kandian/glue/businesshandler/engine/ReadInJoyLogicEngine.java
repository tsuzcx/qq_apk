package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.entity.IRIJAdvertisementInfoModule;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.api.IReadInJoyEngineModuleConstants;
import com.tencent.mobileqq.kandian.base.utils.CollectionUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJLogUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.ValueReference;
import com.tencent.mobileqq.kandian.biz.ad.IRIJAdvertisementRequestProxy;
import com.tencent.mobileqq.kandian.biz.biu.RIJBiuAndCommentMixPBModule;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentPBModule;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.ReadinjoyFixPosArticleManager;
import com.tencent.mobileqq.kandian.biz.feeds.UserReadUnReadInfoManager;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyChannelActivity;
import com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelBannerModule;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertModule;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsInsertModule;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsInsertUtil;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.DynamicChannelDataModule;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.DynamicChannelHeaderModule;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.biz.pts.network.PTSGeneralRequestModule;
import com.tencent.mobileqq.kandian.biz.pts.realtime.RealTimeTemplateFactory;
import com.tencent.mobileqq.kandian.biz.xtab.msgboard.RIJXTabMessageBoardModule;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelRequestModule;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.ChannelListDynamicOrderConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.comment.CommentReportInfo;
import com.tencent.mobileqq.kandian.repo.comment.RIJCommentReportModule;
import com.tencent.mobileqq.kandian.repo.common.FreeNetFlowInfoModule;
import com.tencent.mobileqq.kandian.repo.common.InterestLabelInfoModule;
import com.tencent.mobileqq.kandian.repo.common.RIJLiveStatusModule;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.common.RIJUserApproveModule;
import com.tencent.mobileqq.kandian.repo.common.RIJYoungsterModule;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.common.SelfInfoModule;
import com.tencent.mobileqq.kandian.repo.daily.DailyDynamicHeaderModule;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.ChannelSection;
import com.tencent.mobileqq.kandian.repo.db.struct.VisibleSetParam;
import com.tencent.mobileqq.kandian.repo.diandian.ReadInJoyDianDianEntranceModule;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeParam;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModuleUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleReadInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.BannerInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ChannelInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.SelectPositionModule;
import com.tencent.mobileqq.kandian.repo.feeds.SubscriptionInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AccountProfileInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ExtraBiuBriefInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.InsertArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.LebaKDCellInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PositionData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.PkgInstallInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.Request0xed4Params;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.Request0xed4Params.CoinRewardReq;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.preload.FeedsPreloadDataModule;
import com.tencent.mobileqq.kandian.repo.feeds.preload.FeedsPreloadManager;
import com.tencent.mobileqq.kandian.repo.follow.FollowCoverInfoModule;
import com.tencent.mobileqq.kandian.repo.follow.FollowListInfoModule;
import com.tencent.mobileqq.kandian.repo.follow.FollowingMember;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowForChangeModule;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.message.PackMsgProcessor;
import com.tencent.mobileqq.kandian.repo.report.FeedsReportData;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.kandian.repo.reward.RIJCoinInfoModule;
import com.tencent.mobileqq.kandian.repo.share.KingShareReadInjoyModule;
import com.tencent.mobileqq.kandian.repo.share.ShareReport;
import com.tencent.mobileqq.kandian.repo.ugc.RIJUGCAccountCreateModule;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxModule;
import com.tencent.mobileqq.kandian.repo.ugc.ResultRecord;
import com.tencent.mobileqq.kandian.repo.video.RIJWeChatVideoSeeLaterModule;
import com.tencent.mobileqq.kandian.repo.video.VideoArticleModule;
import com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqAdvertisePara;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;

public class ReadInJoyLogicEngine
  implements IReadInJoyEngineModuleConstants, IReadInJoyLogicEngine
{
  private static ReadInJoyLogicEngine W;
  private static AtomicInteger X;
  private static long ae;
  private static HashMap<Integer, Long> af = new HashMap();
  private FreeNetFlowInfoModule A;
  private DynamicChannelDataModule B;
  private DynamicChannelHeaderModule C;
  private FeedsPreloadDataModule D;
  private DailyDynamicHeaderModule E;
  private SelectPositionModule F;
  private RIJBiuAndCommentMixPBModule G;
  private RIJUserApproveModule H;
  private RIJUGCAccountCreateModule I;
  private RIJChannelBannerModule J;
  private RIJFeedsInsertModule K;
  private PTSGeneralRequestModule L;
  private RIJCoinInfoModule M;
  private RIJLiveStatusModule N;
  private RIJCommentReportModule O;
  private RIJWeChatVideoSeeLaterModule P;
  private RIJFeedsDynamicInsertModule Q;
  private RIJXTabMessageBoardModule R;
  private EntityManagerFactory S;
  private ReadInJoyFollowingMemberPrefetcher T;
  private String U = "";
  private boolean V = false;
  private int Y = -1;
  private ConcurrentHashMap<String, Parcelable> Z = new ConcurrentHashMap();
  private AppInterface a;
  private ConcurrentHashMap<String, Integer> aa = new ConcurrentHashMap();
  private int ab;
  private int ac;
  private boolean ad = false;
  private Handler b;
  private ReadInJoyMSFService c;
  private ExecutorService d;
  private ArticleInfoModule e;
  private UserOperationModule f;
  private ArticleReadInfoModule g;
  private InterestLabelInfoModule h;
  private SubscriptionInfoModule i;
  private ChannelInfoModule j;
  private AdvertisementInfoModuleRequestProxy k;
  private IRIJAdvertisementInfoModule l;
  private ChannelCoverInfoModule m;
  private SelfInfoModule n;
  private FastWebModule o;
  private ReadInJoyUserInfoModule p;
  private RecommendFollowForChangeModule q;
  private FollowListInfoModule r;
  private ReadInJoyCommentPBModule s;
  private ReadInJoyDianDianEntranceModule t;
  private RIJUserLevelRequestModule u;
  private FollowCoverInfoModule v;
  private KingShareReadInjoyModule w;
  private BannerInfoModule x;
  private VideoArticleModule y;
  private ReadInJoyDraftboxModule z;
  
  public static void L()
  {
    ae = NetConnInfoCenter.getServerTimeMillis();
  }
  
  @NonNull
  public static ReadInJoyLogicEngine a()
  {
    try
    {
      if (W == null)
      {
        W = new ReadInJoyLogicEngine();
        X = new AtomicInteger(0);
      }
      ReadInJoyLogicEngine localReadInJoyLogicEngine = W;
      return localReadInJoyLogicEngine;
    }
    finally {}
  }
  
  private void an()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestRefreshChannelIfNeed: ");
    localStringBuilder.append(this.ad);
    QLog.d("ReadInJoyLogicEngine", 1, localStringBuilder.toString());
    if (this.ad)
    {
      this.ad = false;
      I();
    }
  }
  
  private void ao()
  {
    RIJChannelBannerModule localRIJChannelBannerModule = this.J;
    if (localRIJChannelBannerModule != null)
    {
      localRIJChannelBannerModule.unInitialize();
      this.J = null;
    }
  }
  
  private void ap()
  {
    RIJFeedsInsertModule localRIJFeedsInsertModule = this.K;
    if (localRIJFeedsInsertModule != null)
    {
      localRIJFeedsInsertModule.unInitialize();
      this.K = null;
    }
  }
  
  private void aq()
  {
    PTSGeneralRequestModule localPTSGeneralRequestModule = this.L;
    if (localPTSGeneralRequestModule != null)
    {
      localPTSGeneralRequestModule.unInitialize();
      this.L = null;
    }
  }
  
  private void ar()
  {
    RIJCoinInfoModule localRIJCoinInfoModule = this.M;
    if (localRIJCoinInfoModule != null)
    {
      localRIJCoinInfoModule.unInitialize();
      this.M = null;
    }
  }
  
  private void as()
  {
    RIJLiveStatusModule localRIJLiveStatusModule = this.N;
    if (localRIJLiveStatusModule != null)
    {
      localRIJLiveStatusModule.unInitialize();
      this.N = null;
    }
  }
  
  private void at()
  {
    RIJWeChatVideoSeeLaterModule localRIJWeChatVideoSeeLaterModule = this.P;
    if (localRIJWeChatVideoSeeLaterModule != null)
    {
      localRIJWeChatVideoSeeLaterModule.unInitialize();
      this.P = null;
    }
  }
  
  private void au()
  {
    RIJCommentReportModule localRIJCommentReportModule = this.O;
    if (localRIJCommentReportModule != null)
    {
      localRIJCommentReportModule.unInitialize();
      this.O = null;
    }
  }
  
  private void av()
  {
    RIJFeedsDynamicInsertModule localRIJFeedsDynamicInsertModule = this.Q;
    if (localRIJFeedsDynamicInsertModule != null) {
      localRIJFeedsDynamicInsertModule.unInitialize();
    }
    this.Q = null;
  }
  
  private void aw()
  {
    AdvertisementInfoModuleRequestProxy localAdvertisementInfoModuleRequestProxy = this.k;
    if (localAdvertisementInfoModuleRequestProxy != null)
    {
      localAdvertisementInfoModuleRequestProxy.unInitialize();
      this.k = null;
    }
  }
  
  private void ax()
  {
    Object localObject = this.F;
    if (localObject != null)
    {
      ((SelectPositionModule)localObject).unInitialize();
      this.F = null;
    }
    localObject = this.G;
    if (localObject != null)
    {
      ((RIJBiuAndCommentMixPBModule)localObject).unInitialize();
      this.G = null;
    }
    localObject = this.H;
    if (localObject != null)
    {
      ((RIJUserApproveModule)localObject).unInitialize();
      this.H = null;
    }
    localObject = this.I;
    if (localObject != null)
    {
      ((RIJUGCAccountCreateModule)localObject).unInitialize();
      this.I = null;
    }
    localObject = this.p;
    if (localObject != null)
    {
      ((ReadInJoyUserInfoModule)localObject).unInitialize();
      this.p = null;
    }
    localObject = this.q;
    if (localObject != null)
    {
      ((RecommendFollowForChangeModule)localObject).unInitialize();
      this.q = null;
    }
    localObject = this.x;
    if (localObject != null)
    {
      ((BannerInfoModule)localObject).unInitialize();
      this.x = null;
    }
    localObject = this.A;
    if (localObject != null) {
      ((FreeNetFlowInfoModule)localObject).unInitialize();
    }
    localObject = this.B;
    if (localObject != null)
    {
      ((DynamicChannelDataModule)localObject).b();
      this.B = null;
    }
    localObject = this.C;
    if (localObject != null)
    {
      ((DynamicChannelHeaderModule)localObject).b();
      this.C = null;
    }
    localObject = this.D;
    if (localObject != null)
    {
      ((FeedsPreloadDataModule)localObject).b();
      this.D = null;
    }
    localObject = this.E;
    if (localObject != null)
    {
      ((DailyDynamicHeaderModule)localObject).unInitialize();
      this.E = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((ArticleInfoModule)localObject).unInitialize();
      this.e = null;
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((UserOperationModule)localObject).unInitialize();
      this.f = null;
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((ArticleReadInfoModule)localObject).unInitialize();
      this.g = null;
    }
    localObject = this.h;
    if (localObject != null)
    {
      ((InterestLabelInfoModule)localObject).unInitialize();
      this.h = null;
    }
    localObject = this.i;
    if (localObject != null)
    {
      ((SubscriptionInfoModule)localObject).unInitialize();
      this.i = null;
    }
    localObject = this.j;
    if (localObject != null)
    {
      ((ChannelInfoModule)localObject).unInitialize();
      this.j = null;
    }
    localObject = this.l;
    if (localObject != null)
    {
      ((IRIJAdvertisementInfoModule)localObject).a();
      this.l = null;
    }
    localObject = this.m;
    if (localObject != null)
    {
      ((ChannelCoverInfoModule)localObject).unInitialize();
      this.m = null;
    }
  }
  
  private void ay()
  {
    RIJXTabMessageBoardModule localRIJXTabMessageBoardModule = this.R;
    if (localRIJXTabMessageBoardModule != null)
    {
      localRIJXTabMessageBoardModule.unInitialize();
      this.R = null;
    }
  }
  
  private void b(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = (LocationManager)paramContext.getSystemService("location");
    if (paramContext == null) {
      return;
    }
    try
    {
      bool = paramContext.isProviderEnabled("gps");
    }
    catch (Throwable paramContext)
    {
      boolean bool;
      label32:
      break label32;
    }
    bool = false;
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("GPS Open ");
      paramContext.append(bool);
      QLog.i("LBS", 2, paramContext.toString());
    }
    if (bool)
    {
      this.Y = 1;
      return;
    }
    this.Y = 0;
  }
  
  private void d(long paramLong, int paramInt)
  {
    if (paramInt == 2) {
      ThreadManager.getUIHandler().post(new ReadInJoyLogicEngine.8(this, paramLong));
    }
  }
  
  public static void e(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = RIJQQAppInterfaceUtil.c();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramAbsBaseArticleInfo.mArticleID;
    localReportInfo.mChannelId = ((int)paramAbsBaseArticleInfo.mChannelID);
    localReportInfo.mAlgorithmId = ((int)paramAbsBaseArticleInfo.mAlgorithmID);
    localReportInfo.mStrategyId = paramAbsBaseArticleInfo.mStrategyId;
    localReportInfo.mOperation = 30;
    if (paramAbsBaseArticleInfo.mChannelID == 70L) {
      localReportInfo.mOpSource = 13;
    } else if (paramAbsBaseArticleInfo.mChannelID == 56L) {
      localReportInfo.mOpSource = 11;
    } else {
      localReportInfo.mOpSource = 0;
    }
    localReportInfo.mChannelId = ((int)paramAbsBaseArticleInfo.mChannelID);
    if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
    {
      FeedsReportData localFeedsReportData = new FeedsReportData();
      localFeedsReportData.a = paramAbsBaseArticleInfo.mSocialFeedInfo.a;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.c != null) {
        localFeedsReportData.b = paramAbsBaseArticleInfo.mSocialFeedInfo.c.a;
      }
      localFeedsReportData.d = paramAbsBaseArticleInfo.mSocialFeedInfo.h;
      localFeedsReportData.e = paramAbsBaseArticleInfo.mSocialFeedInfo.j;
      localReportInfo.mFeedsReportData = localFeedsReportData;
    }
    localArrayList.add(localReportInfo);
    a().a(localArrayList);
  }
  
  private void q(int paramInt)
  {
    QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "onLoadMoreArticleFalse, channelID = ", Integer.valueOf(paramInt) });
    Handler localHandler = this.b;
    if (localHandler != null) {
      localHandler.post(new ReadInJoyLogicEngine.2(this, paramInt));
    }
  }
  
  public void A()
  {
    SubscriptionInfoModule localSubscriptionInfoModule = this.i;
    if (localSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionUnReadNum mSubscriptionInfoModule is null!");
      }
      return;
    }
    localSubscriptionInfoModule.f();
  }
  
  public int B()
  {
    SubscriptionInfoModule localSubscriptionInfoModule = this.i;
    if (localSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionUnReadNum mSubscriptionInfoModule is null!");
      }
      return 0;
    }
    return localSubscriptionInfoModule.g();
  }
  
  public void C()
  {
    Object localObject = this.e;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mArticleInfoModule is null!");
      }
      return;
    }
    ((ArticleInfoModule)localObject).g();
    localObject = this.i;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mSubscriptionInfoModule is null!");
      }
      return;
    }
    ((SubscriptionInfoModule)localObject).c();
  }
  
  public void D()
  {
    Object localObject = this.e;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mArticleInfoModule is null!");
      }
    }
    else {
      ((ArticleInfoModule)localObject).h();
    }
    localObject = this.i;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mSubscriptionInfoModule is null!");
      }
    }
    else {
      ((SubscriptionInfoModule)localObject).d();
    }
    localObject = this.l;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mAdvertisementInfoModule is null!");
      }
    }
    else {
      ((IRIJAdvertisementInfoModule)localObject).b();
    }
  }
  
  public void E()
  {
    Object localObject = this.e;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mArticleInfoModule is null!");
      }
      return;
    }
    ((ArticleInfoModule)localObject).e();
    localObject = this.i;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mSubscriptionInfoModule is null!");
      }
      return;
    }
    ((SubscriptionInfoModule)localObject).a();
  }
  
  public void F()
  {
    Object localObject = this.e;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mArticleInfoModule is null!");
      }
      return;
    }
    ((ArticleInfoModule)localObject).f();
    localObject = this.i;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mSubscriptionInfoModule is null!");
      }
      return;
    }
    ((SubscriptionInfoModule)localObject).b();
  }
  
  public int G()
  {
    ChannelInfoModule localChannelInfoModule = this.j;
    if (localChannelInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadAllChannelListFromCache mChannelInfoModule is null!");
      }
      return -1;
    }
    return localChannelInfoModule.k();
  }
  
  public List<ChannelSection> H()
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.m;
    if (localChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChannelCoverSectionList mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return localChannelCoverInfoModule.f();
  }
  
  public void I()
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.m;
    if (localChannelCoverInfoModule == null)
    {
      QLog.d("Q.readinjoy.info_module", 1, "refreshRecommendAnMyCoverListFromServer mChannelCoverInfoModule is null!");
      this.ad = true;
      return;
    }
    localChannelCoverInfoModule.a();
  }
  
  public List<TabChannelCoverInfo> J()
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.m;
    if (localChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getMyChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return localChannelCoverInfoModule.b();
  }
  
  public void K()
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.m;
    if (localChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadAllChannelCoverListFromDb mChannelCoverInfoModule is null!");
      }
      return;
    }
    localChannelCoverInfoModule.c();
  }
  
  public IRIJAdvertisementInfoModule M()
  {
    return this.l;
  }
  
  public IRIJAdvertisementRequestProxy N()
  {
    return this.k;
  }
  
  public void O()
  {
    String str = ShareReport.a.c();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    long l1 = RIJQQAppInterfaceUtil.c();
    this.e.a(l1, str);
  }
  
  public void P()
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestFollowTab0x8c8UpdateUpvoteAndComment mArticleInfoModule is null!");
      }
      return;
    }
    localArticleInfoModule.a("-1", 0, 70);
  }
  
  public String Q()
  {
    FollowCoverInfoModule localFollowCoverInfoModule = this.v;
    if (localFollowCoverInfoModule != null) {
      return localFollowCoverInfoModule.b();
    }
    return "";
  }
  
  public int R()
  {
    FollowCoverInfoModule localFollowCoverInfoModule = this.v;
    if (localFollowCoverInfoModule != null) {
      return localFollowCoverInfoModule.a();
    }
    return 0;
  }
  
  public HashMap<Long, Long> S()
  {
    FollowCoverInfoModule localFollowCoverInfoModule = this.v;
    if (localFollowCoverInfoModule != null) {
      return localFollowCoverInfoModule.c();
    }
    return null;
  }
  
  public int T()
  {
    String str = RIJQQAppInterfaceUtil.d();
    if (this.aa == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "getLeaveKanDianTabInfo mLeaveKanDianTabCache is null.");
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLogicEngine", 2, new Object[] { "getLeaveKanDianTabInfo, key: ", str, ", tabIndex: ", this.aa.get(str) });
    }
    return ((Integer)this.aa.get(str)).intValue();
  }
  
  public FreeNetFlowInfoModule U()
  {
    return this.A;
  }
  
  public void V()
  {
    FollowListInfoModule localFollowListInfoModule = this.r;
    if (localFollowListInfoModule != null) {
      localFollowListInfoModule.a(300, 2);
    }
  }
  
  public FollowListInfoModule W()
  {
    return this.r;
  }
  
  public List<FollowingMember> X()
  {
    FollowListInfoModule localFollowListInfoModule = this.r;
    if (localFollowListInfoModule == null) {
      return new ArrayList();
    }
    return localFollowListInfoModule.a();
  }
  
  public void Y()
  {
    if (this.n != null) {
      RIJYoungsterModule.a();
    }
  }
  
  public ReadInJoyDraftboxModule Z()
  {
    return this.z;
  }
  
  public AbsBaseArticleInfo a(int paramInt, long paramLong)
  {
    if (this.e == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    if (ReadinjoyFixPosArticleManager.isFixPosArticleSeq(paramLong)) {
      return ReadinjoyFixPosArticleManager.getInstant().getSpecialArticleInfo(paramInt, paramLong);
    }
    return this.e.i().a(Integer.valueOf(paramInt), Long.valueOf(paramLong));
  }
  
  public AbsBaseArticleInfo a(Integer paramInteger)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getLastReadArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    return localArticleInfoModule.i().f(paramInteger);
  }
  
  public List<AbsBaseArticleInfo> a(Integer paramInteger, List<Long> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return localArrayList;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (Long)paramList.next();
        localObject = a(paramInteger.intValue(), ((Long)localObject).longValue());
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
      return PackMsgProcessor.a(localArrayList);
    }
    return localArrayList;
  }
  
  public oidb_cmd0x68b.ReqAdvertisePara a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, int paramInt1, int paramInt2, int paramInt3, int paramInt4, AdRequestData paramAdRequestData)
  {
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = this.l;
    if (localIRIJAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "makeReqAdvertisePara mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return (oidb_cmd0x68b.ReqAdvertisePara)localIRIJAdvertisementInfoModule.a(paramRequest0x68bParams, paramInt1, paramInt2, paramInt3, paramInt4, paramAdRequestData);
  }
  
  public void a(int paramInt)
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.m;
    if (localChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelCoverListFromServer mChannelCoverInfoModule is null!");
      }
      return;
    }
    localChannelCoverInfoModule.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ChannelInfoModule localChannelInfoModule = this.j;
    if (localChannelInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelListFromServer mChannelInfoModule is null!");
      }
      return;
    }
    if (paramInt1 != -1)
    {
      if (paramInt1 != 1) {
        return;
      }
      localChannelInfoModule.l();
      return;
    }
    localChannelInfoModule.b(true);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = this.l;
    if (localIRIJAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "setLocalAdvertisementRange mAdvertisementInfoModule is null!");
      }
      return;
    }
    localIRIJAdvertisementInfoModule.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject)
  {
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = this.l;
    if (localIRIJAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelAdvertisementFormServer mAdvertisementInfoModule is null!");
      }
      return;
    }
    localIRIJAdvertisementInfoModule.a(paramInt1, paramInt2, paramInt3, paramInt4, (AdRequestData)paramObject);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelArticleFromDB mArticleInfoModule is null!");
      }
      return;
    }
    localArticleInfoModule.i().a(paramInt1, paramInt2, paramLong, paramBoolean, ReadInJoyUtils.g());
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule != null) {
      localArticleInfoModule.i().a(paramInt1, paramInt2, paramLong1, paramBoolean, paramLong2, ReadInJoyUtils.g());
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("moveChannelToFront() called with: channelCoverId = [");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append("], source = [");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append("], addAtEnd = [");
    ((StringBuilder)localObject1).append(paramBoolean1);
    ((StringBuilder)localObject1).append("]");
    QLog.i("ReadInJoyLogicEngine", 1, ((StringBuilder)localObject1).toString());
    localObject1 = this.m;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "moveChannelToFront mChannelCoverInfoModule is null!");
      }
      return;
    }
    List localList = ((ChannelCoverInfoModule)localObject1).f();
    Object localObject2 = null;
    if ((localList != null) && (localList.size() > 0))
    {
      int i2 = -1;
      Object localObject4 = localList.iterator();
      int i3;
      do
      {
        localObject1 = localObject2;
        i1 = i2;
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject3 = (ChannelSection)((Iterator)localObject4).next();
        i3 = CollectionUtils.b(((ChannelSection)localObject3).d, new ReadInJoyLogicEngine.3(this, paramInt1));
      } while (i3 < 0);
      localObject2 = (TabChannelCoverInfo)((ChannelSection)localObject3).d.get(i3);
      if (((TabChannelCoverInfo)localObject2).reason == 4) {
        return;
      }
      ((ChannelSection)localObject3).d.remove(i3);
      localObject1 = localObject2;
      int i1 = i2;
      if (localObject3 == localList.get(0))
      {
        i1 = i3;
        localObject1 = localObject2;
      }
      localObject2 = (ChannelSection)localList.get(0);
      paramInt1 = CollectionUtils.b(((ChannelSection)localObject2).d, new ReadInJoyLogicEngine.4(this));
      if (QLog.isColorLevel())
      {
        localObject3 = ((ChannelSection)localObject2).d;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(" firstUnLockPosition : ");
        ((StringBuilder)localObject4).append(paramInt1);
        ChannelCoverInfoModule.a((List)localObject3, ((StringBuilder)localObject4).toString());
      }
      Object localObject3 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 != null) && (((ChannelSection)localObject2).d != null))
      {
        ChannelListDynamicOrderConfigHandler.a(RIJQQAppInterfaceUtil.e(), ((TabChannelCoverInfo)localObject1).mChannelCoverId);
        if ((paramInt1 >= 0) && (!paramBoolean1)) {
          ((ChannelSection)localObject2).d.add(paramInt1, localObject1);
        } else {
          ((ChannelSection)localObject2).d.add(localObject1);
        }
        PublicAccountReportUtils.a(null, "", "0X8009A59", "0X8009A59", 0, 0, "", "", "", RIJTransMergeKanDianReport.g().addStringNotThrow("uin", ((QQAppInterface)localObject3).getCurrentAccountUin()).addChannelId(((TabChannelCoverInfo)localObject1).mChannelCoverId).addStringNotThrow("source", paramInt2).addStringNotThrow("fromposition", i1).build(), false);
      }
      a(localList, 2, paramBoolean2);
    }
  }
  
  public void a(int paramInt, Parcelable paramParcelable)
  {
    if (DailyModeConfigHandler.c(paramInt)) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.d());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    if (this.Z == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "updateLeaveChannelPosInfo mLeavePosCache is null.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLogicEngine", 2, new Object[] { "updatePosInfo, key: ", localObject, ", state: ", paramParcelable });
    }
    this.Z.put(localObject, paramParcelable);
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    a(paramInt, paramAbsBaseArticleInfo, Boolean.valueOf(true));
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2)
  {
    if ((paramAbsBaseArticleInfo1 != null) && (paramAbsBaseArticleInfo2 != null))
    {
      this.e.a(true, paramInt, Arrays.asList(new Long[] { Long.valueOf(paramAbsBaseArticleInfo1.mArticleID) }), Arrays.asList(new AbsBaseArticleInfo[] { paramAbsBaseArticleInfo2 }), false);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("###insertAfterTarget error for null, targetArticleInfo:");
      localStringBuilder.append(paramAbsBaseArticleInfo1);
      localStringBuilder.append("     valueArticleInfo:");
      localStringBuilder.append(paramAbsBaseArticleInfo2);
      QLog.e("ReadInJoyLogicEngine", 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, Boolean paramBoolean)
  {
    Object localObject;
    if (this.e != null)
    {
      if (RIJFeedsType.G(paramAbsBaseArticleInfo))
      {
        localObject = paramAbsBaseArticleInfo.mGroupSubArticleList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)((Iterator)localObject).next();
          this.e.i().a(paramInt, localAbsBaseArticleInfo.mRecommendSeq);
        }
      }
      this.e.i().a(paramInt, paramAbsBaseArticleInfo.mRecommendSeq);
    }
    else
    {
      QLog.d("ArticleInfoModule", 2, "ReadinjoyLogicEngine articleInfoModule is null !");
    }
    if ((this.g != null) && (paramBoolean.booleanValue()))
    {
      if (RIJFeedsType.G(paramAbsBaseArticleInfo))
      {
        paramBoolean = paramAbsBaseArticleInfo.mGroupSubArticleList.iterator();
        while (paramBoolean.hasNext())
        {
          localObject = (AbsBaseArticleInfo)paramBoolean.next();
          this.g.b(((AbsBaseArticleInfo)localObject).mArticleID);
        }
      }
      this.g.b(paramAbsBaseArticleInfo.mArticleID);
    }
    else
    {
      QLog.d("ArticleInfoModule", 2, "ReadinjoyLogicEngine articleReadInfoModule is null !");
    }
    RIJFeedsInsertUtil.a.a(paramInt, paramAbsBaseArticleInfo);
  }
  
  public void a(int paramInt, String paramString)
  {
    List localList = H();
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i1 = 0;
      while (i1 < localList.size())
      {
        ChannelSection localChannelSection = (ChannelSection)localList.get(i1);
        int i2 = 0;
        while (i2 < localChannelSection.d.size())
        {
          if (paramInt == ((TabChannelCoverInfo)localChannelSection.d.get(i2)).mChannelCoverId) {
            ((TabChannelCoverInfo)localChannelSection.d.get(i2)).mChannelCoverName = paramString;
          }
          i2 += 1;
        }
        i1 += 1;
      }
    }
    a(localList, true);
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.m;
    if (localChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateMainChannelCoverInfo mChannelCoverInfoModule is null!");
      }
      return;
    }
    localChannelCoverInfoModule.a(paramInt, paramString, paramLong);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6)
  {
    a(paramInt1, paramList, paramInt2, paramBoolean1, paramBoolean2, paramInt3, paramString1, paramLong1, paramString2, paramInt4, paramLong2, paramLong3, paramString3, paramInt5, paramBoolean3, paramLebaKDCellInfo, paramInt6, null);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6, List<InsertArticleInfo> paramList1)
  {
    a(paramInt1, paramList, paramInt2, paramBoolean1, paramBoolean2, paramInt3, paramString1, paramLong1, paramString2, paramInt4, paramLong2, paramLong3, paramString3, paramInt5, paramBoolean3, paramLebaKDCellInfo, paramInt6, paramList1, null, null);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6, List<InsertArticleInfo> paramList1, List<ReadInJoyRequestParams.PkgInstallInfo> paramList2, Bundle paramBundle)
  {
    Object localObject = this.e;
    if (localObject == null)
    {
      QLog.d("Q.readinjoy.info_module", 1, "refreshChannelArticlesFormServer mArticleInfoModule is null!");
      return;
    }
    List localList = ((ArticleInfoModule)localObject).i().h(Integer.valueOf(paramInt1));
    long l1 = this.e.i().d(Integer.valueOf(paramInt1));
    localObject = new ReadInJoyRequestParams.Request0x68bParams();
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).b = paramInt1;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).c = -1L;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).f = true;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).g = localList;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).h = false;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).i = paramList;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).D = paramInt2;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).j = true;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).k = true;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).l = paramBoolean1;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).m = this.e.i().a(Integer.valueOf(paramInt1));
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).n = paramBoolean2;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).o = ArticleInfoModuleUtils.b();
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).p = paramInt3;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).s = paramString1;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).q = paramLong1;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).t = paramString2;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).r = paramInt4;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).u = paramLong2;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).v = paramLong3;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).x = paramString3;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).B = paramBoolean3;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).C = paramLebaKDCellInfo;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).F |= paramInt6;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).J = paramList2;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).H = paramBundle;
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd(paramInt1)) {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).z = true;
    }
    paramInt2 = paramInt5;
    if (paramInt5 == 1001) {
      paramInt2 = 3;
    }
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).A = paramInt2;
    if (l1 == -1L) {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).d = -1L;
    } else {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).d = (l1 + 1L);
    }
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).y |= 0x10;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).y |= 0x20;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).y |= 0x100;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).y |= 0x40;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).y |= 0x400;
    if (paramInt1 == 56) {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).y |= 0x1080;
    }
    if (paramInt1 == 0) {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).y |= 0x800;
    }
    if ((paramInt1 == 40677) || (paramInt4 == 7)) {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).G = 2;
    }
    if (DailyModeConfigHandler.c(paramInt1)) {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).G = 3;
    }
    if (paramList1 != null) {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).E.addAll(paramList1);
    }
    if ((((ReadInJoyRequestParams.Request0x68bParams)localObject).F & 0x100) != 0)
    {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).G = 4;
      QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "feedsPreload, params service type = ", Integer.valueOf(((ReadInJoyRequestParams.Request0x68bParams)localObject).G), ", beginRecommendSeq = ", Long.valueOf(((ReadInJoyRequestParams.Request0x68bParams)localObject).c), ", endRecommendSeq = ", Long.valueOf(((ReadInJoyRequestParams.Request0x68bParams)localObject).d) });
    }
    if (!RIJShowKanDianTabSp.c()) {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).F |= 0x200;
    }
    if (RIJXTabConfigHandler.INSTANCE.isBigImageMode()) {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).F |= 0x80000;
    }
    if (ReadInJoyChannelActivity.d()) {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).F |= 0x100000;
    }
    QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "68b params recommendFlag = ", Integer.valueOf(((ReadInJoyRequestParams.Request0x68bParams)localObject).F) });
    if (paramInt1 == 41695)
    {
      paramLebaKDCellInfo = this.F;
      if (paramLebaKDCellInfo != null)
      {
        paramLebaKDCellInfo = paramLebaKDCellInfo.b();
        if (paramLebaKDCellInfo != null)
        {
          if (QLog.isColorLevel())
          {
            paramList1 = new StringBuilder();
            paramList1.append("refreshChannelArticlesFormServer positionData = ");
            paramList1.append(paramLebaKDCellInfo);
            QLog.i("ReadInJoyLogicEngine", 2, paramList1.toString());
          }
          ((ReadInJoyRequestParams.Request0x68bParams)localObject).K = new PositionData();
          ((ReadInJoyRequestParams.Request0x68bParams)localObject).K.copy(paramLebaKDCellInfo);
        }
      }
    }
    if ((((ReadInJoyRequestParams.Request0x68bParams)localObject).F & 0x1000) != 0)
    {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).I = UserReadUnReadInfoManager.a().d();
      UserReadUnReadInfoManager.a().e();
    }
    this.e.a((ReadInJoyRequestParams.Request0x68bParams)localObject);
    RIJFeedsInsertUtil.a.a(((ReadInJoyRequestParams.Request0x68bParams)localObject).b, ((ReadInJoyRequestParams.Request0x68bParams)localObject).p, ((ReadInJoyRequestParams.Request0x68bParams)localObject).F);
    paramLebaKDCellInfo = new StringBuilder("SelectedKandianArticleIds : ");
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramList1 = (Long)paramList.next();
        paramList2 = new StringBuilder();
        paramList2.append(paramList1);
        paramList2.append(" , ");
        paramLebaKDCellInfo.append(paramList2.toString());
      }
    }
    paramList = new StringBuilder();
    paramList.append("refreshChannelArticlesFormServer kandianArticleID : ");
    paramList.append(paramLebaKDCellInfo.toString());
    paramList.append(" innerUniqId is : ");
    paramList.append(paramString1);
    paramList.append(" subscribeArticleID is : ");
    paramList.append(paramLong1);
    paramList.append(" subscribeArticleTitle : ");
    paramList.append(RIJAppSetting.b(paramString2));
    paramList.append(" recommendFlag is : ");
    paramList.append(((ReadInJoyRequestParams.Request0x68bParams)localObject).F);
    paramList.append(" pushContext：");
    paramList.append(paramString3);
    paramList.append(" channelID : ");
    paramList.append(paramInt1);
    QLog.i("ArticleInfoModule", 1, paramList.toString());
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = this.l;
    if (localIRIJAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "setChannelNeedRequestAdvertisement mAdvertisementInfoModule is null!");
      }
      return;
    }
    localIRIJAdvertisementInfoModule.a(paramInt, paramBoolean);
  }
  
  public void a(long paramLong, int paramInt)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule != null) {
      localArticleInfoModule.i().a(paramLong, paramInt);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteFastWebArticle mArticleInfoModule is null!");
      }
      return;
    }
    localArticleInfoModule.a(paramLong, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.M != null)
    {
      ReadInJoyRequestParams.Request0xed4Params localRequest0xed4Params = new ReadInJoyRequestParams.Request0xed4Params();
      localRequest0xed4Params.a = 3;
      localRequest0xed4Params.b = paramString;
      localRequest0xed4Params.c = new ReadInJoyRequestParams.Request0xed4Params.CoinRewardReq();
      localRequest0xed4Params.c.a = paramLong;
      localRequest0xed4Params.c.b = paramInt;
      this.M.a(localRequest0xed4Params, paramBundle);
    }
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    b(paramLong, paramInt);
    d(paramLong, paramInt);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("publishUin = ");
    ((StringBuilder)localObject).append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    localObject = b().createEntityManager().query(BaseArticleInfo.class, true, (String)localObject, null, null, null, "mRecommendSeq desc", null);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("no soical feeds to update article.publishUin:");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("ReadInJoyLogicEngine", 1, ((StringBuilder)localObject).toString());
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)((Iterator)localObject).next();
      int i1;
      if (localAbsBaseArticleInfo.mSocialFeedInfo != null)
      {
        if ((localAbsBaseArticleInfo.mSocialFeedInfo.o != 2) && (paramInt == 2)) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        localAbsBaseArticleInfo.mSocialFeedInfo.o = paramInt;
        articlesummary.SocializeFeedsInfo localSocializeFeedsInfo = new articlesummary.SocializeFeedsInfo();
        try
        {
          localSocializeFeedsInfo.mergeFrom(localAbsBaseArticleInfo.mSocialFeedInfoByte);
          localSocializeFeedsInfo.uint32_follow_status.set(paramInt, true);
          localAbsBaseArticleInfo.mSocialFeedInfoByte = localSocializeFeedsInfo.toByteArray();
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
        {
          localInvalidProtocolBufferMicroException1.printStackTrace();
        }
        i2 = 1;
      }
      else
      {
        i2 = 0;
        i1 = 0;
      }
      int i3 = i2;
      int i2 = i1;
      if (localAbsBaseArticleInfo.mPolymericInfo != null)
      {
        i2 = i1;
        if (localAbsBaseArticleInfo.mPolymericInfo.p != 2)
        {
          i2 = i1;
          if (paramInt == 2) {
            i2 = 1;
          }
        }
        localAbsBaseArticleInfo.mPolymericInfo.p = paramInt;
        articlesummary.PackInfo localPackInfo = new articlesummary.PackInfo();
        try
        {
          localPackInfo.mergeFrom(localAbsBaseArticleInfo.mPackInfoBytes);
          localPackInfo.uint32_follow_status.set(paramInt, true);
          localAbsBaseArticleInfo.mPackInfoBytes = localPackInfo.toByteArray();
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateArticleFollowStatusByAccount article.mPackInfoBytes convert error article.publishUin:");
          localStringBuilder.append(paramLong);
          localStringBuilder.append(" e = ");
          localStringBuilder.append(localInvalidProtocolBufferMicroException2);
          QLog.e("ReadInJoyLogicEngine", 1, localStringBuilder.toString());
          localInvalidProtocolBufferMicroException2.printStackTrace();
        }
        i3 = 1;
      }
      if (i3 != 0)
      {
        this.e.updateEntity(localAbsBaseArticleInfo);
        localAbsBaseArticleInfo = this.e.i().a(localAbsBaseArticleInfo, (int)localAbsBaseArticleInfo.mChannelID);
        if ((i2 != 0) && (localAbsBaseArticleInfo != null)) {
          localAbsBaseArticleInfo.isNeedShowBtnWhenFollowed = true;
        }
        if (localAbsBaseArticleInfo != null) {
          localAbsBaseArticleInfo.invalidateProteusTemplateBean();
        }
        if ((paramBoolean) && (localAbsBaseArticleInfo != null)) {
          localAbsBaseArticleInfo.needShowFollwedButton = false;
        }
      }
    }
    localObject = this.b;
    if (localObject != null) {
      ((Handler)localObject).post(new ReadInJoyLogicEngine.7(this));
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    ArticleReadInfoModule localArticleReadInfoModule = this.g;
    if (localArticleReadInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateArticleReadInfo mArticleReadInfoModule is null!");
      }
      return;
    }
    localArticleReadInfoModule.a(paramLong1, paramLong2);
  }
  
  public void a(long paramLong1, long paramLong2, com.tencent.mobileqq.kandian.repo.handler.BiuInfo paramBiuInfo, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    a(paramLong1, paramLong2, paramBiuInfo, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramAbsBaseArticleInfo, false);
  }
  
  public void a(long paramLong1, long paramLong2, com.tencent.mobileqq.kandian.repo.handler.BiuInfo paramBiuInfo, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    if ((this.e != null) && (paramBiuInfo != null))
    {
      if (paramLong4 == -1L) {
        paramLong4 = 0L;
      }
      if ((!TextUtils.isEmpty(paramString2)) && (paramInt1 == 17))
      {
        this.e.a(paramLong1, paramString2, paramInt1, paramString1, null, paramBoolean);
        return;
      }
      this.e.a(paramLong1, paramLong2, paramBiuInfo, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramAbsBaseArticleInfo, paramBoolean);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.info_module", 2, "requestMultiBiu mArticleInfoModule is null!");
    }
  }
  
  public void a(long paramLong1, long paramLong2, com.tencent.mobileqq.kandian.repo.handler.BiuInfo paramBiuInfo, String paramString)
  {
    this.e.a(paramLong1, paramLong2, paramBiuInfo, paramString);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    long l1 = paramLong1;
    if (this.e == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "autoRefreshForNewBiuCard | mArticleInfoModule is null!");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((l1 != -1L) && (l1 != 0L))
    {
      localArrayList.add(Long.valueOf(paramLong1));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("autoRefreshForNewBiuCard | unique_articleId : ");
      ((StringBuilder)localObject).append(l1);
      QLog.d("ReadInJoyLogicEngine", 2, ((StringBuilder)localObject).toString());
      paramLong1 = l1;
    }
    else
    {
      localArrayList.add(Long.valueOf(paramLong2));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("autoRefreshForNewBiuCard | unique_feedsId : ");
      ((StringBuilder)localObject).append(paramLong2);
      QLog.d("ReadInJoyLogicEngine", 2, ((StringBuilder)localObject).toString());
      paramLong1 = paramLong2;
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("BiuSetTop", "1");
      ((JSONObject)localObject).put("FeedsId", paramLong2);
      ((JSONObject)localObject).put("ArticleId", paramLong1);
      ((JSONObject)localObject).put("biuUin", RIJQQAppInterfaceUtil.d());
      ((JSONObject)localObject).put("rowKey", paramString);
      paramString = new JSONObject();
      paramString.put("socialFeedsType", 3);
      ((JSONObject)localObject).put("extension", paramString.toString());
    }
    catch (JSONException paramString)
    {
      QLog.d("ReadInJoyLogicEngine", 2, paramString.getMessage());
    }
    paramString = new StringBuilder();
    paramString.append("autoRefreshForNewBiuCard | pushContext: ");
    paramString.append(((JSONObject)localObject).toString());
    QLog.d("ReadInJoyLogicEngine", 2, paramString.toString());
    a(0, localArrayList, 14, true, false, 0, null, -1L, null, 0, 0L, 0L, ((JSONObject)localObject).toString(), 6, false, null, 0, null);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteAction mArticleInfoModule is null!");
      }
      return;
    }
    localArticleInfoModule.a(paramLong1, paramLong2, paramBoolean, paramAbsBaseArticleInfo);
  }
  
  public void a(long paramLong, DislikeParam paramDislikeParam)
  {
    if (paramDislikeParam == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "sendShieldArticle mArticleInfoModule is null!");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramDislikeParam);
    a(paramLong, localArrayList);
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String paramString2, ArrayList<BiuCommentInfo> paramArrayList, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.atlas.", 2, "requestAtlasBiu rowKey is null!");
      }
      return;
    }
    this.e.a(paramLong, paramString1, paramInt, paramString2, paramArrayList, paramBoolean);
  }
  
  public void a(long paramLong, List<? extends DislikeParam> paramList)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "sendShieldArticle mArticleInfoModule is null!");
      }
      return;
    }
    localArticleInfoModule.a(paramLong, paramList);
  }
  
  public void a(long paramLong, boolean paramBoolean, FastWebArticleInfo paramFastWebArticleInfo)
  {
    a(paramLong, paramBoolean, paramFastWebArticleInfo, 0);
  }
  
  public void a(long paramLong, boolean paramBoolean, FastWebArticleInfo paramFastWebArticleInfo, int paramInt)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteFastWebArticle mArticleInfoModule is null!");
      }
      return;
    }
    localArticleInfoModule.a(paramLong, paramBoolean, paramFastWebArticleInfo, paramInt);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    RecommendFollowForChangeModule localRecommendFollowForChangeModule = this.q;
    if (localRecommendFollowForChangeModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "changeRecommendFollow mRecommendFollowForChangeModule is null!");
      }
      return;
    }
    localRecommendFollowForChangeModule.a(paramLong, paramArrayOfByte);
  }
  
  public void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, long paramLong, ArrayList<DislikeInfo> paramArrayList, boolean paramBoolean)
  {
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = this.l;
    if (localIRIJAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "doUninterestAdvertisement mAdvertisementInfoModule is null!");
      }
      return;
    }
    localIRIJAdvertisementInfoModule.a(paramContext, paramAdvertisementInfo, paramLong, paramArrayList, paramBoolean);
  }
  
  protected void a(AppInterface paramAppInterface)
  {
    QLog.i("ReadInJoyLogicEngine", 1, "[initialize]: ");
    X.addAndGet(1);
    String str = RIJQQAppInterfaceUtil.d();
    if ((this.V) && (this.U.equals(str)) && (paramAppInterface == this.a)) {
      return;
    }
    this.V = true;
    this.U = str;
    this.a = paramAppInterface;
    this.b = new Handler(Looper.getMainLooper());
    this.d = MonitorTimeExecutor.a();
    EntityManager localEntityManager = b().createEntityManager();
    this.c = ReadInJoyMSFService.getInstance();
    this.e = new ArticleInfoModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.f = new UserOperationModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.g = new ArticleReadInfoModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.h = new InterestLabelInfoModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.i = new SubscriptionInfoModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.j = new ChannelInfoModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.l = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createAdvertisementInfoModule();
    this.k = new AdvertisementInfoModuleRequestProxy(this.a, localEntityManager, this.d, this.c, this.b);
    this.m = new ChannelCoverInfoModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.n = new SelfInfoModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.v = new FollowCoverInfoModule(this.a);
    this.w = new KingShareReadInjoyModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.o = new FastWebModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.p = new ReadInJoyUserInfoModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.q = new RecommendFollowForChangeModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.r = new FollowListInfoModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.x = new BannerInfoModule(this.a, localEntityManager, this.d, this.c, this.b, this.e);
    this.y = new VideoArticleModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.z = new ReadInJoyDraftboxModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.A = new FreeNetFlowInfoModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.s = new ReadInJoyCommentPBModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.B = new DynamicChannelDataModule(localEntityManager, this.b);
    this.C = new DynamicChannelHeaderModule(this.b);
    this.D = new FeedsPreloadDataModule(this.d);
    this.E = new DailyDynamicHeaderModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.F = new SelectPositionModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.t = new ReadInJoyDianDianEntranceModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.G = new RIJBiuAndCommentMixPBModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.H = new RIJUserApproveModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.I = new RIJUGCAccountCreateModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.J = new RIJChannelBannerModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.K = new RIJFeedsInsertModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.L = new PTSGeneralRequestModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.M = new RIJCoinInfoModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.N = new RIJLiveStatusModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.O = new RIJCommentReportModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.u = new RIJUserLevelRequestModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.P = new RIJWeChatVideoSeeLaterModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.Q = new RIJFeedsDynamicInsertModule(this.a, localEntityManager, this.d, this.c, this.b);
    this.R = new RIJXTabMessageBoardModule(this.a, localEntityManager, this.d, this.c, this.b);
    DailyModeConfigHandler.f();
    this.Z = new ConcurrentHashMap();
    this.aa = new ConcurrentHashMap();
    ReadInJoyCommentDataManager.r();
    TemplateFactory.d();
    RealTimeTemplateFactory.h();
    this.T = new ReadInJoyFollowingMemberPrefetcher(paramAppInterface, this.r);
    paramAppInterface = new StringBuilder();
    paramAppInterface.append("readinjoy logic engine init finish ! account : ");
    paramAppInterface.append(RIJLogUtil.a.a(str));
    QLog.d("ReadInJoyLogicEngine", 2, paramAppInterface.toString());
    an();
  }
  
  public void a(com.tencent.mobileqq.kandian.repo.biu.BiuInfo paramBiuInfo)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "transformNewBiuCardInRecommendFeeds | mArticleInfoModule is null!");
      return;
    }
    if (paramBiuInfo == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "transformNewBiuCardInRecommendFeeds |  biuInfo is null!");
      return;
    }
    localArticleInfoModule.a(paramBiuInfo);
  }
  
  public void a(CommentReportInfo paramCommentReportInfo)
  {
    RIJCommentReportModule localRIJCommentReportModule = this.O;
    if (localRIJCommentReportModule != null) {
      localRIJCommentReportModule.a(paramCommentReportInfo);
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "resetBiuBreathAnimationFlag | mArticleInfoModule is null!");
      return;
    }
    localArticleInfoModule.i().b(paramAbsBaseArticleInfo);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    if (this.e == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestSubmitComment mArticleInfoModule is null!");
      }
      return;
    }
    if ((paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramString)))
    {
      this.e.a(paramAbsBaseArticleInfo, paramString);
      return;
    }
    QLog.d("Q.readinjoy.info_module", 2, "requestSubmitComment articleinfo or commentinfo is null!");
  }
  
  public void a(ChannelInfo paramChannelInfo)
  {
    ChannelInfoModule localChannelInfoModule = this.j;
    if (localChannelInfoModule != null) {
      localChannelInfoModule.a(paramChannelInfo);
    }
  }
  
  @UiThread
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.m;
    if (localChannelCoverInfoModule == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "updateChannel mChannelCoverInfoModule is null!");
      return;
    }
    localChannelCoverInfoModule.a(paramTabChannelCoverInfo);
  }
  
  public void a(TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo)
  {
    FollowCoverInfoModule localFollowCoverInfoModule = this.v;
    if (localFollowCoverInfoModule != null) {
      localFollowCoverInfoModule.a(paramTopicRecommendFeedsInfo);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle)
  {
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = this.l;
    if (localIRIJAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "handleAdvertisementResp mAdvertisementInfoModule is null!");
      }
      return;
    }
    localIRIJAdvertisementInfoModule.a(paramToServiceMsg, paramRspChannelArticle, 0, 0, true, new ValueReference(Boolean.valueOf(false)));
  }
  
  public void a(String paramString)
  {
    SubscriptionInfoModule localSubscriptionInfoModule = this.i;
    if (localSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "stickySubscriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    localSubscriptionInfoModule.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.e == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpdateSocialFeedInfo mArticleInfoModule is null!");
      }
      return;
    }
    if ("-1".equals(paramString))
    {
      if ((RIJJumpUtils.a != null) && (RIJJumpUtils.a.mFeedId != 0L))
      {
        paramString = this.e;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(RIJJumpUtils.a.mFeedId);
        paramString.a(localStringBuilder.toString(), RIJJumpUtils.a.mFeedType, -1, true);
        RIJJumpUtils.a = null;
        return;
      }
      paramString = new StringBuilder();
      paramString.append(" clicked articleInfo  ");
      paramString.append(RIJJumpUtils.a);
      QLog.w("Q.readinjoy.info_module", 2, paramString.toString());
      return;
    }
    this.e.a(paramString, paramInt, -1, true);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, ArrayList<BiuCommentInfo> paramArrayList, AccountProfileInfo paramAccountProfileInfo)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUGC mArticleInfoModule is null!");
      }
      return;
    }
    localArticleInfoModule.a(paramString1, null, null, null, paramString2, null, null, null, null, paramArrayList, false, paramInt, 0, paramAccountProfileInfo, 0);
  }
  
  public void a(String paramString, Context paramContext)
  {
    SubscriptionInfoModule localSubscriptionInfoModule = this.i;
    if (localSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unFollowSubscribeAccount mSubscriptionInfoModule is null!");
      }
      return;
    }
    localSubscriptionInfoModule.a(paramString, paramContext);
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8006113", "0X8006113", 0, 0, "", "", "", "");
  }
  
  public void a(String paramString1, String paramString2)
  {
    KingShareReadInjoyModule localKingShareReadInjoyModule = this.w;
    if (localKingShareReadInjoyModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "get king moment module is null!");
      }
      return;
    }
    localKingShareReadInjoyModule.a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, ArrayList<BiuCommentInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUpMasterVideo mArticleInfoModule is null!");
      }
      return;
    }
    localArticleInfoModule.a(paramString1, paramString2, paramBundle, paramArrayList, paramBoolean1, paramBoolean2, paramTroopBarPOI, paramVisibleSetParam);
  }
  
  public void a(ArrayList<ResultRecord> paramArrayList, long paramLong, String paramString)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule != null)
    {
      localArticleInfoModule.a(paramArrayList, 1, paramLong, paramString);
      return;
    }
    paramArrayList = new StringBuilder();
    paramArrayList.append("shareAQinviteFriends, uin = ");
    paramArrayList.append(RIJLogUtil.a.a(paramLong));
    QLog.d("ReadInJoyLogicEngine", 2, paramArrayList.toString());
  }
  
  public void a(List<? extends ReportInfo> paramList)
  {
    UserOperationModule localUserOperationModule = this.f;
    if (localUserOperationModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "userOperationReport mUserOperationModule is null!");
      }
      return;
    }
    localUserOperationModule.request0x64eUserOperationReport(paramList);
  }
  
  public void a(List<ChannelSection> paramList, int paramInt, boolean paramBoolean)
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.m;
    if (localChannelCoverInfoModule == null)
    {
      QLog.d("ReadInJoyLogicEngine", 2, "updateRecommendAndMyChannelListsToServer failed, mChannelCoverInfoModule is null!");
      return;
    }
    localChannelCoverInfoModule.a(a().H(), paramList, paramBoolean);
    this.m.a(paramList, paramInt);
  }
  
  public void a(List<ReportInfo> paramList, String paramString)
  {
    UserOperationModule localUserOperationModule = this.f;
    if (localUserOperationModule == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "mUserOperationModule is null.");
      return;
    }
    localUserOperationModule.request0x64eFeedsPreloadReport(paramList, paramString);
  }
  
  public void a(List<ChannelSection> paramList, boolean paramBoolean)
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.m;
    if (localChannelCoverInfoModule == null)
    {
      QLog.d("ReadInJoyLogicEngine", 2, "updateRecommendAndMyChannelListsToServer failed, mChannelCoverInfoModule is null!");
      return;
    }
    localChannelCoverInfoModule.a(a().H(), paramList, paramBoolean);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      if (X.addAndGet(-1) > 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unInit fail, referenceCount is : ");
        localStringBuilder.append(X.get());
        QLog.d("ReadInJoyLogicEngine", 2, localStringBuilder.toString());
        return;
      }
      W = null;
      this.a = null;
      this.U = null;
      this.V = false;
      this.S = null;
      if (this.b != null)
      {
        this.b.removeCallbacksAndMessages(null);
        this.b = null;
      }
      if (this.c != null)
      {
        this.c.unInitialize();
        this.c = null;
      }
      if (this.Z != null) {
        this.Z.clear();
      }
      if (this.aa != null) {
        this.aa.clear();
      }
      if (this.T != null)
      {
        this.T.o();
        this.T = null;
      }
      ao();
      ap();
      aq();
      ar();
      as();
      au();
      ax();
      at();
      av();
      aw();
      ay();
      FeedsPreloadManager.a().c();
      DailyModeConfigHandler.f();
      QLog.d("ReadInJoyLogicEngine", 2, "readinjoy logic engine uninit success!");
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    ChannelInfoModule localChannelInfoModule = this.j;
    if (localChannelInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "followUnfollowChildChannel mChannelInfoModule is null!");
      }
      return;
    }
    localChannelInfoModule.a(paramBoolean, paramInt1, paramInt2);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    Object localObject1 = this.e;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "equestFollowList mArticleInfoModule is null!");
      }
      return;
    }
    Object localObject3 = null;
    long l1;
    long l2;
    if (paramBoolean)
    {
      localObject1 = this.a;
      if (localObject1 != null) {
        ((KandianMergeManager)((AppInterface)localObject1).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b(-1);
      }
      localObject1 = S();
      l1 = this.e.i().d(Integer.valueOf(70));
      if (l1 != -1L) {
        l1 = 1L + l1;
      } else {
        l1 = 0L;
      }
      l2 = l1;
      l1 = 0L;
    }
    else
    {
      l1 = ((ArticleInfoModule)localObject1).i().e(Integer.valueOf(70));
      if (l1 != -1L)
      {
        l1 -= 1L;
        localObject1 = null;
        l2 = 0L;
      }
      else
      {
        localObject1 = null;
        l1 = 0L;
        l2 = l1;
      }
    }
    List localList = d(Integer.valueOf(70));
    Object localObject2 = localObject3;
    if (localList != null)
    {
      localObject2 = localObject3;
      if (!localList.isEmpty()) {
        localObject2 = ((AbsBaseArticleInfo)localList.get(localList.size() - 1)).mFeedCookie;
      }
    }
    this.ac += 1;
    this.e.a(l1, l2, this.ac, (HashMap)localObject1, R(), paramString, Q(), (String)localObject2);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "loadMoreArticle return false, mArticleInfoModule = null");
      q(paramInt1);
      return false;
    }
    long l1 = localArticleInfoModule.i().e(Integer.valueOf(paramInt1));
    if (l1 == -1L)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "loadMoreArticle return false, minRecommendSeq = -1.");
      q(paramInt1);
      return false;
    }
    this.e.a(paramInt1, 20, l1 - 1L, true, paramInt2, paramInt3, 0, paramInt4, paramInt5);
    return true;
  }
  
  public boolean a(long paramLong)
  {
    ArticleReadInfoModule localArticleReadInfoModule = this.g;
    if (localArticleReadInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadArticleReadInfoList mArticleReadInfoModule is null!");
      }
      return false;
    }
    return localArticleReadInfoModule.a(paramLong);
  }
  
  public boolean a(Context paramContext)
  {
    if (this.Y == -1) {
      b(paramContext);
    }
    return this.Y > 0;
  }
  
  public boolean a(ExtraBiuBriefInfo paramExtraBiuBriefInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadMoreBius mArticleInfoModule is null!");
      }
      return false;
    }
    localArticleInfoModule.a(paramExtraBiuBriefInfo, paramAbsBaseArticleInfo);
    return true;
  }
  
  public boolean a(Integer paramInteger, List<AbsBaseArticleInfo> paramList, boolean paramBoolean)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule != null) {
      return localArticleInfoModule.i().a(paramInteger, paramList, paramBoolean);
    }
    return false;
  }
  
  public boolean a(Long paramLong)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "isArticleNeedHighLight mArticleInfoModule is null!");
      }
      return false;
    }
    return localArticleInfoModule.a(paramLong);
  }
  
  public void aa()
  {
    ExecutorService localExecutorService = this.d;
    if ((localExecutorService != null) && (!localExecutorService.isShutdown()) && (!this.d.isTerminated()))
    {
      this.d.execute(new ReadInJoyLogicEngine.9(this));
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 1, "startFeedsPreload, executorService is not available.");
  }
  
  public ArticleInfoModule ab()
  {
    return this.e;
  }
  
  public void ac()
  {
    DailyDynamicHeaderModule localDailyDynamicHeaderModule = this.E;
    if (localDailyDynamicHeaderModule != null)
    {
      localDailyDynamicHeaderModule.a();
      return;
    }
    QLog.e("ReadInJoyLogicEngine", 1, "[requestDailyDynamicHeaderData] mDailyDynamicHeaderModule == null");
  }
  
  public JSONObject ad()
  {
    DailyDynamicHeaderModule localDailyDynamicHeaderModule = this.E;
    if (localDailyDynamicHeaderModule != null) {
      return localDailyDynamicHeaderModule.c();
    }
    return null;
  }
  
  public void ae()
  {
    if (this.M != null)
    {
      ReadInJoyRequestParams.Request0xed4Params localRequest0xed4Params = new ReadInJoyRequestParams.Request0xed4Params();
      localRequest0xed4Params.a = 1;
      this.M.a(localRequest0xed4Params);
    }
  }
  
  public RIJUserLevelRequestModule af()
  {
    return this.u;
  }
  
  public RIJFeedsDynamicInsertModule ag()
  {
    return this.Q;
  }
  
  public RIJXTabMessageBoardModule ah()
  {
    return this.R;
  }
  
  public int b(Integer paramInteger)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getRefreshedArticleInfoSize mArticleInfoModule is null!");
      }
      return 0;
    }
    return localArticleInfoModule.i().g(paramInteger);
  }
  
  public AbsBaseArticleInfo b(int paramInt, long paramLong)
  {
    Object localObject = this.e;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    localObject = ((ArticleInfoModule)localObject).i().c(Integer.valueOf(paramInt));
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      paramInt = 0;
      while (paramInt < ((List)localObject).size())
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)((List)localObject).get(paramInt);
        if (localAbsBaseArticleInfo.mArticleID == paramLong) {
          return localAbsBaseArticleInfo;
        }
        paramInt += 1;
      }
    }
    return null;
  }
  
  public EntityManagerFactory b()
  {
    Object localObject1 = RIJQQAppInterfaceUtil.d();
    if (localObject1 != null) {
      try
      {
        if ((this.S == null) || (!TextUtils.equals(((ReadInJoyEntityManagerFactory)this.S).name, (CharSequence)localObject1)))
        {
          localObject1 = new ReadInJoyEntityManagerFactory((String)localObject1);
          ThreadManager.post(new ReadInJoyLogicEngine.1(this, (ReadInJoyEntityManagerFactory)localObject1), 8, null, false);
          this.S = ((EntityManagerFactory)localObject1);
        }
        return this.S;
      }
      finally {}
    }
    throw new IllegalStateException("Can not create a entity factory, the account is null.");
  }
  
  public void b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = H();
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i1 = 0;
      while (i1 < localList.size())
      {
        ChannelSection localChannelSection1 = (ChannelSection)localList.get(i1);
        ChannelSection localChannelSection2 = new ChannelSection(localChannelSection1.a, localChannelSection1.b, localChannelSection1.c);
        int i2 = 0;
        while (i2 < localChannelSection1.d.size())
        {
          if (paramInt != ((TabChannelCoverInfo)localChannelSection1.d.get(i2)).mChannelCoverId) {
            localChannelSection2.d.add(localChannelSection1.d.get(i2));
          }
          i2 += 1;
        }
        localArrayList.add(localChannelSection2);
        i1 += 1;
      }
    }
    a(localArrayList, true);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (ChannelCoverInfoModule.e(paramInt1)) {
      c(paramInt1, paramInt2);
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    ChannelInfoModule localChannelInfoModule = this.j;
    if (localChannelInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChildChannelFollowStatus mChannelInfoModule is null!");
      }
      return;
    }
    localChannelInfoModule.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void b(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule != null) {
      localArticleInfoModule.i().c(paramInt1, paramInt2, paramLong, paramBoolean);
    }
  }
  
  public void b(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule != null) {
      localArticleInfoModule.i().a(paramInt, paramAbsBaseArticleInfo);
    }
  }
  
  public void b(int paramInt, String paramString, long paramLong)
  {
    SelfInfoModule localSelfInfoModule = this.n;
    if (localSelfInfoModule != null) {
      localSelfInfoModule.a(paramInt, paramString, null, paramLong);
    }
  }
  
  public void b(long paramLong)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestIndividualArticlesFormServer mArticleInfoModule is null!");
      }
      return;
    }
    localArticleInfoModule.a(paramLong, 1);
  }
  
  public void b(long paramLong, int paramInt)
  {
    Object localObject = this.T;
    if (localObject != null) {
      ((ReadInJoyFollowingMemberPrefetcher)localObject).b(paramLong, paramInt);
    }
    localObject = this.r;
    if (localObject != null) {
      ((FollowListInfoModule)localObject).a(paramLong, paramInt);
    }
  }
  
  public void b(String paramString)
  {
    SubscriptionInfoModule localSubscriptionInfoModule = this.i;
    if (localSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unstickySubscriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    localSubscriptionInfoModule.b(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    a(paramBoolean, null);
  }
  
  public boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "isArticleFromRecommendFeeds | mArticleInfoModule is null!");
      return false;
    }
    return localArticleInfoModule.i().a(paramAbsBaseArticleInfo);
  }
  
  public UserOperationModule c()
  {
    return this.f;
  }
  
  public List<ChannelCoverInfo> c(int paramInt)
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.m;
    if (localChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return localChannelCoverInfoModule.c(paramInt);
  }
  
  public List<Long> c(Integer paramInteger)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule != null) {
      return localArticleInfoModule.i().h(paramInteger);
    }
    return null;
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, false, true);
  }
  
  public void c(long paramLong)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      ((ArticleInfoModule)localObject).a(paramLong);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("searchUgcTagsByTopicId: mArticleInfoModule is null when search ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.d("ReadInJoyLogicEngine", 2, ((StringBuilder)localObject).toString());
  }
  
  public void c(long paramLong, int paramInt)
  {
    a(paramLong, paramInt, false);
  }
  
  public void c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateArticleInfo mArticleInfoModule is null!");
      }
      return;
    }
    localArticleInfoModule.i().c(paramAbsBaseArticleInfo);
  }
  
  public void c(String paramString)
  {
    SubscriptionInfoModule localSubscriptionInfoModule = this.i;
    if (localSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "removeSubsciriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    localSubscriptionInfoModule.c(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.m;
    if (localChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getMyChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return;
    }
    localChannelCoverInfoModule.a(paramBoolean);
  }
  
  public AdvertisementInfo d(int paramInt1, int paramInt2)
  {
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = this.l;
    if (localIRIJAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getAdvertisementInfo mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return localIRIJAdvertisementInfoModule.a(paramInt1, paramInt2);
  }
  
  public FastWebModule d()
  {
    return this.o;
  }
  
  public List<TabChannelCoverInfo> d(int paramInt)
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.m;
    if (localChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getRecommendChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return localChannelCoverInfoModule.b(paramInt);
  }
  
  public List<AbsBaseArticleInfo> d(Integer paramInteger)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule != null) {
      return localArticleInfoModule.i().c(paramInteger);
    }
    return null;
  }
  
  public void d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateWatchLaterInfo mArticleInfoModule is null!");
      }
      return;
    }
    localArticleInfoModule.i().c(paramAbsBaseArticleInfo);
  }
  
  public void d(String paramString)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "request0xc6dInteractiveAreaCards mArticleInfoModule is null!");
      }
      return;
    }
    localArticleInfoModule.a(paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    FollowCoverInfoModule localFollowCoverInfoModule = this.v;
    if (localFollowCoverInfoModule != null) {
      localFollowCoverInfoModule.a(paramBoolean);
    }
  }
  
  public AdvertisementInfo e(int paramInt1, int paramInt2)
  {
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = this.l;
    if (localIRIJAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getAdvertisementInfo mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return localIRIJAdvertisementInfoModule.b(paramInt1, paramInt2);
  }
  
  @Nullable
  public ReadInJoyUserInfoModule e()
  {
    return this.p;
  }
  
  public void e(int paramInt)
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.m;
    if (localChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelAdvertisementFromDB mChannelCoverInfoModule is null!");
      }
      return;
    }
    localChannelCoverInfoModule.d(paramInt);
  }
  
  public void e(String paramString)
  {
    FollowCoverInfoModule localFollowCoverInfoModule = this.v;
    if (localFollowCoverInfoModule != null) {
      localFollowCoverInfoModule.a(paramString);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    ReadInJoyFollowingMemberPrefetcher localReadInJoyFollowingMemberPrefetcher = this.T;
    if (localReadInJoyFollowingMemberPrefetcher != null) {
      localReadInJoyFollowingMemberPrefetcher.d(paramBoolean);
    }
  }
  
  public Pair<Integer, Integer> f(int paramInt1, int paramInt2)
  {
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = this.l;
    if (localIRIJAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getPreloadAdvertisementAtPostion mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return localIRIJAdvertisementInfoModule.c(paramInt1, paramInt2);
  }
  
  public DynamicChannelDataModule f()
  {
    return this.B;
  }
  
  public void f(int paramInt)
  {
    ThreadManager.executeOnSubThread(new ReadInJoyLogicEngine.5(this, paramInt));
  }
  
  public void f(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.e.i().c(paramAbsBaseArticleInfo);
  }
  
  public void f(String paramString)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      ((ArticleInfoModule)localObject).b(paramString);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("searchUgcTagsByKeyword: mArticleInfoModule is null when search ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("ReadInJoyLogicEngine", 2, ((StringBuilder)localObject).toString());
  }
  
  public DynamicChannelHeaderModule g()
  {
    return this.C;
  }
  
  public void g(int paramInt)
  {
    if (paramInt != 40677) {
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyLogicEngine.6(this, paramInt));
  }
  
  public void g(String paramString)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      ((ArticleInfoModule)localObject).c(paramString);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("searchUgcTopicByKeyword: mArticleInfoModule is null when search: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("ReadInJoyLogicEngine", 2, ((StringBuilder)localObject).toString());
  }
  
  public boolean g(int paramInt1, int paramInt2)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule == null) {
      return false;
    }
    return localArticleInfoModule.i().a(paramInt1, paramInt2);
  }
  
  public Pair<Integer, Integer> h(int paramInt)
  {
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = this.l;
    if (localIRIJAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getLocalAdvertisementRange mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return localIRIJAdvertisementInfoModule.e(paramInt);
  }
  
  public FeedsPreloadDataModule h()
  {
    return this.D;
  }
  
  public void h(int paramInt1, int paramInt2)
  {
    this.e.i().b(paramInt1, paramInt2);
  }
  
  public void h(String paramString)
  {
    DailyDynamicHeaderModule localDailyDynamicHeaderModule = this.E;
    if (localDailyDynamicHeaderModule != null) {
      localDailyDynamicHeaderModule.a(paramString);
    }
  }
  
  public BannerInfoModule i()
  {
    return this.x;
  }
  
  public void i(String paramString)
  {
    if (this.M != null)
    {
      ReadInJoyRequestParams.Request0xed4Params localRequest0xed4Params = new ReadInJoyRequestParams.Request0xed4Params();
      localRequest0xed4Params.a = 4;
      localRequest0xed4Params.b = paramString;
      this.M.a(localRequest0xed4Params, null);
    }
  }
  
  public boolean i(int paramInt)
  {
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = this.l;
    if (localIRIJAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "needRequestAdvertisement mAdvertisementInfoModule is null!");
      }
      return true;
    }
    return localIRIJAdvertisementInfoModule.f(paramInt);
  }
  
  public SelectPositionModule j()
  {
    return this.F;
  }
  
  public ChannelInfo j(int paramInt)
  {
    ChannelInfoModule localChannelInfoModule = this.j;
    if (localChannelInfoModule != null) {
      return localChannelInfoModule.a(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public void j(String paramString)
  {
    if (this.M != null)
    {
      ReadInJoyRequestParams.Request0xed4Params localRequest0xed4Params = new ReadInJoyRequestParams.Request0xed4Params();
      localRequest0xed4Params.a = 5;
      localRequest0xed4Params.b = paramString;
      this.M.a(localRequest0xed4Params);
    }
  }
  
  @Nullable
  public ReadInJoyCommentPBModule k()
  {
    return this.s;
  }
  
  public void k(int paramInt)
  {
    FollowCoverInfoModule localFollowCoverInfoModule = this.v;
    if (localFollowCoverInfoModule != null) {
      localFollowCoverInfoModule.a(paramInt);
    }
  }
  
  public ReadInJoyDianDianEntranceModule l()
  {
    return this.t;
  }
  
  public void l(int paramInt)
  {
    this.ab = paramInt;
  }
  
  public Parcelable m(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.d());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    if (this.Z == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "getLeaveChannelPosInfo mLeavePosCache is null.");
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLogicEngine", 2, new Object[] { "getPosInfo, key: ", localObject, ", state: ", this.Z.get(localObject) });
    }
    return (Parcelable)this.Z.get(localObject);
  }
  
  public RIJBiuAndCommentMixPBModule m()
  {
    return this.G;
  }
  
  public RIJUserApproveModule n()
  {
    return this.H;
  }
  
  public void n(int paramInt)
  {
    String str = RIJQQAppInterfaceUtil.d();
    if (this.aa == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "updateLeaveKanDianTabInfo mLeaveKanDianTabCache is null.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLogicEngine", 2, new Object[] { "updateLeaveKanDianTabInfo, key: ", str, ", tabIndex: ", Integer.valueOf(paramInt) });
    }
    this.aa.put(str, Integer.valueOf(paramInt));
  }
  
  public RIJUGCAccountCreateModule o()
  {
    return this.I;
  }
  
  public void o(int paramInt)
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule != null) {
      localArticleInfoModule.i().g(paramInt);
    }
  }
  
  public RIJChannelBannerModule p()
  {
    return this.J;
  }
  
  public void p(int paramInt)
  {
    b(paramInt, "", 0L);
  }
  
  public RIJFeedsInsertModule q()
  {
    return this.K;
  }
  
  public PTSGeneralRequestModule r()
  {
    return this.L;
  }
  
  public RIJLiveStatusModule s()
  {
    return this.N;
  }
  
  public RIJWeChatVideoSeeLaterModule t()
  {
    return this.P;
  }
  
  public void u()
  {
    this.ac = 0;
  }
  
  public void v()
  {
    ArticleReadInfoModule localArticleReadInfoModule = this.g;
    if (localArticleReadInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadArticleReadInfoList mArticleReadInfoModule is null!");
      }
      return;
    }
    localArticleReadInfoModule.a();
  }
  
  public void w()
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelTopCookieList mArticleInfoModule is null!");
      }
      return;
    }
    localArticleInfoModule.i().b();
  }
  
  public void x()
  {
    InterestLabelInfoModule localInterestLabelInfoModule = this.h;
    if (localInterestLabelInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestGetInterestLabelInfoList mInterestLabelInfoModule is null!");
      }
      return;
    }
    localInterestLabelInfoModule.a();
    this.h.a(1, 1, 1, false);
  }
  
  public void y()
  {
    SubscriptionInfoModule localSubscriptionInfoModule = this.i;
    if (localSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionFeedList mSubscriptionInfoModule is null!");
      }
      return;
    }
    localSubscriptionInfoModule.e();
  }
  
  public void z()
  {
    ArticleInfoModule localArticleInfoModule = this.e;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshKanDianUnReadNum mArticleInfoModule is null!");
      }
      return;
    }
    localArticleInfoModule.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine
 * JD-Core Version:    0.7.0.1
 */