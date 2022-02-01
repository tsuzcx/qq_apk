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
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.ValueReference;
import com.tencent.mobileqq.kandian.biz.ad.IRIJAdvertisementRequestProxy;
import com.tencent.mobileqq.kandian.biz.biu.RIJBiuAndCommentMixPBModule;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentPBModule;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.ReadinjoyFixPosArticleManager;
import com.tencent.mobileqq.kandian.biz.feeds.UserReadUnReadInfoManager;
import com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelBannerModule;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertModule;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsInsertModule;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsInsertUtil;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.DynamicChannelDataModule;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.DynamicChannelHeaderModule;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.biz.pts.network.PTSGeneralRequestModule;
import com.tencent.mobileqq.kandian.biz.pts.realtime.RealTimeTemplateFactory;
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
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo;
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
  private static long jdField_a_of_type_Long;
  private static ReadInJoyLogicEngine jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine;
  private static HashMap<Integer, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private IRIJAdvertisementInfoModule jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRIJAdvertisementInfoModule;
  private ReadInJoyMSFService jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService;
  private RIJBiuAndCommentMixPBModule jdField_a_of_type_ComTencentMobileqqKandianBizBiuRIJBiuAndCommentMixPBModule;
  private ReadInJoyCommentPBModule jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule;
  private RIJChannelBannerModule jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerModule;
  private RIJFeedsDynamicInsertModule jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsRIJFeedsDynamicInsertModule;
  private RIJFeedsInsertModule jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsRIJFeedsInsertModule;
  private DynamicChannelDataModule jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsDataDynamicChannelDataModule;
  private DynamicChannelHeaderModule jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsDataDynamicChannelHeaderModule;
  private PTSGeneralRequestModule jdField_a_of_type_ComTencentMobileqqKandianBizPtsNetworkPTSGeneralRequestModule;
  private AdvertisementInfoModuleRequestProxy jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineAdvertisementInfoModuleRequestProxy;
  private ReadInJoyFollowingMemberPrefetcher jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyFollowingMemberPrefetcher;
  private RIJUserLevelRequestModule jdField_a_of_type_ComTencentMobileqqKandianRepoAccountRIJUserLevelRequestModule;
  private RIJCommentReportModule jdField_a_of_type_ComTencentMobileqqKandianRepoCommentRIJCommentReportModule;
  private FreeNetFlowInfoModule jdField_a_of_type_ComTencentMobileqqKandianRepoCommonFreeNetFlowInfoModule;
  private InterestLabelInfoModule jdField_a_of_type_ComTencentMobileqqKandianRepoCommonInterestLabelInfoModule;
  private RIJLiveStatusModule jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJLiveStatusModule;
  private RIJUserApproveModule jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJUserApproveModule;
  private ReadInJoyUserInfoModule jdField_a_of_type_ComTencentMobileqqKandianRepoCommonReadInJoyUserInfoModule;
  private SelfInfoModule jdField_a_of_type_ComTencentMobileqqKandianRepoCommonSelfInfoModule;
  private DailyDynamicHeaderModule jdField_a_of_type_ComTencentMobileqqKandianRepoDailyDailyDynamicHeaderModule;
  private ReadInJoyDianDianEntranceModule jdField_a_of_type_ComTencentMobileqqKandianRepoDiandianReadInJoyDianDianEntranceModule;
  private FastWebModule jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebFastWebModule;
  private ArticleInfoModule jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
  private ArticleReadInfoModule jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleReadInfoModule;
  private BannerInfoModule jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsBannerInfoModule;
  private ChannelCoverInfoModule jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelCoverInfoModule;
  private ChannelInfoModule jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelInfoModule;
  private SelectPositionModule jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSelectPositionModule;
  private SubscriptionInfoModule jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSubscriptionInfoModule;
  private FeedsPreloadDataModule jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsPreloadFeedsPreloadDataModule;
  private FollowCoverInfoModule jdField_a_of_type_ComTencentMobileqqKandianRepoFollowFollowCoverInfoModule;
  private FollowListInfoModule jdField_a_of_type_ComTencentMobileqqKandianRepoFollowFollowListInfoModule;
  private RecommendFollowForChangeModule jdField_a_of_type_ComTencentMobileqqKandianRepoFollowRecommendFollowForChangeModule;
  private UserOperationModule jdField_a_of_type_ComTencentMobileqqKandianRepoReportUserOperationModule;
  private RIJCoinInfoModule jdField_a_of_type_ComTencentMobileqqKandianRepoRewardRIJCoinInfoModule;
  private KingShareReadInjoyModule jdField_a_of_type_ComTencentMobileqqKandianRepoShareKingShareReadInjoyModule;
  private RIJUGCAccountCreateModule jdField_a_of_type_ComTencentMobileqqKandianRepoUgcRIJUGCAccountCreateModule;
  private ReadInJoyDraftboxModule jdField_a_of_type_ComTencentMobileqqKandianRepoUgcReadInJoyDraftboxModule;
  private RIJWeChatVideoSeeLaterModule jdField_a_of_type_ComTencentMobileqqKandianRepoVideoRIJWeChatVideoSeeLaterModule;
  private VideoArticleModule jdField_a_of_type_ComTencentMobileqqKandianRepoVideoVideoArticleModule;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private String jdField_a_of_type_JavaLangString = "";
  private ConcurrentHashMap<String, Parcelable> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private ConcurrentHashMap<String, Integer> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean = false;
  private int c;
  
  private void A()
  {
    RIJLiveStatusModule localRIJLiveStatusModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJLiveStatusModule;
    if (localRIJLiveStatusModule != null)
    {
      localRIJLiveStatusModule.unInitialize();
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJLiveStatusModule = null;
    }
  }
  
  private void B()
  {
    RIJWeChatVideoSeeLaterModule localRIJWeChatVideoSeeLaterModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoRIJWeChatVideoSeeLaterModule;
    if (localRIJWeChatVideoSeeLaterModule != null)
    {
      localRIJWeChatVideoSeeLaterModule.unInitialize();
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoRIJWeChatVideoSeeLaterModule = null;
    }
  }
  
  private void C()
  {
    RIJCommentReportModule localRIJCommentReportModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommentRIJCommentReportModule;
    if (localRIJCommentReportModule != null)
    {
      localRIJCommentReportModule.unInitialize();
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommentRIJCommentReportModule = null;
    }
  }
  
  private void D()
  {
    RIJFeedsDynamicInsertModule localRIJFeedsDynamicInsertModule = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsRIJFeedsDynamicInsertModule;
    if (localRIJFeedsDynamicInsertModule != null) {
      localRIJFeedsDynamicInsertModule.unInitialize();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsRIJFeedsDynamicInsertModule = null;
  }
  
  private void E()
  {
    AdvertisementInfoModuleRequestProxy localAdvertisementInfoModuleRequestProxy = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineAdvertisementInfoModuleRequestProxy;
    if (localAdvertisementInfoModuleRequestProxy != null)
    {
      localAdvertisementInfoModuleRequestProxy.unInitialize();
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineAdvertisementInfoModuleRequestProxy = null;
    }
  }
  
  private void F()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSelectPositionModule;
    if (localObject != null)
    {
      ((SelectPositionModule)localObject).unInitialize();
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSelectPositionModule = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuRIJBiuAndCommentMixPBModule;
    if (localObject != null)
    {
      ((RIJBiuAndCommentMixPBModule)localObject).unInitialize();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuRIJBiuAndCommentMixPBModule = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJUserApproveModule;
    if (localObject != null)
    {
      ((RIJUserApproveModule)localObject).unInitialize();
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJUserApproveModule = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoUgcRIJUGCAccountCreateModule;
    if (localObject != null)
    {
      ((RIJUGCAccountCreateModule)localObject).unInitialize();
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoUgcRIJUGCAccountCreateModule = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonReadInJoyUserInfoModule;
    if (localObject != null)
    {
      ((ReadInJoyUserInfoModule)localObject).unInitialize();
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonReadInJoyUserInfoModule = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowRecommendFollowForChangeModule;
    if (localObject != null)
    {
      ((RecommendFollowForChangeModule)localObject).unInitialize();
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowRecommendFollowForChangeModule = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsBannerInfoModule;
    if (localObject != null)
    {
      ((BannerInfoModule)localObject).unInitialize();
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsBannerInfoModule = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonFreeNetFlowInfoModule;
    if (localObject != null) {
      ((FreeNetFlowInfoModule)localObject).unInitialize();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsDataDynamicChannelDataModule;
    if (localObject != null)
    {
      ((DynamicChannelDataModule)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsDataDynamicChannelDataModule = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsDataDynamicChannelHeaderModule;
    if (localObject != null)
    {
      ((DynamicChannelHeaderModule)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsDataDynamicChannelHeaderModule = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsPreloadFeedsPreloadDataModule;
    if (localObject != null)
    {
      ((FeedsPreloadDataModule)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsPreloadFeedsPreloadDataModule = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoDailyDailyDynamicHeaderModule;
    if (localObject != null)
    {
      ((DailyDynamicHeaderModule)localObject).unInitialize();
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoDailyDailyDynamicHeaderModule = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localObject != null)
    {
      ((ArticleInfoModule)localObject).unInitialize();
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoReportUserOperationModule;
    if (localObject != null)
    {
      ((UserOperationModule)localObject).unInitialize();
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoReportUserOperationModule = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleReadInfoModule;
    if (localObject != null)
    {
      ((ArticleReadInfoModule)localObject).unInitialize();
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleReadInfoModule = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonInterestLabelInfoModule;
    if (localObject != null)
    {
      ((InterestLabelInfoModule)localObject).unInitialize();
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonInterestLabelInfoModule = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSubscriptionInfoModule;
    if (localObject != null)
    {
      ((SubscriptionInfoModule)localObject).unInitialize();
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSubscriptionInfoModule = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelInfoModule;
    if (localObject != null)
    {
      ((ChannelInfoModule)localObject).unInitialize();
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelInfoModule = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRIJAdvertisementInfoModule;
    if (localObject != null)
    {
      ((IRIJAdvertisementInfoModule)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRIJAdvertisementInfoModule = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelCoverInfoModule;
    if (localObject != null)
    {
      ((ChannelCoverInfoModule)localObject).unInitialize();
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelCoverInfoModule = null;
    }
  }
  
  public static ReadInJoyLogicEngine a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine == null)
      {
        jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine = new ReadInJoyLogicEngine();
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
      }
      ReadInJoyLogicEngine localReadInJoyLogicEngine = jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine;
      return localReadInJoyLogicEngine;
    }
    finally {}
  }
  
  private void a(Context paramContext)
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
      label31:
      break label31;
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
      this.jdField_a_of_type_Int = 1;
      return;
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  private void d(long paramLong, int paramInt)
  {
    if (paramInt == 2) {
      ThreadManager.getUIHandler().post(new ReadInJoyLogicEngine.8(this, paramLong));
    }
  }
  
  public static void d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
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
      localFeedsReportData.jdField_a_of_type_Long = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null) {
        localFeedsReportData.jdField_b_of_type_Long = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
      }
      localFeedsReportData.jdField_a_of_type_Int = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      localFeedsReportData.jdField_b_of_type_Int = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      localReportInfo.mFeedsReportData = localFeedsReportData;
    }
    localArrayList.add(localReportInfo);
    a().a(localArrayList);
  }
  
  private void k(int paramInt)
  {
    QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "onLoadMoreArticleFalse, channelID = ", Integer.valueOf(paramInt) });
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.post(new ReadInJoyLogicEngine.2(this, paramInt));
    }
  }
  
  public static void n()
  {
    jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
  }
  
  private void v()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestRefreshChannelIfNeed: ");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    QLog.d("ReadInJoyLogicEngine", 1, localStringBuilder.toString());
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      l();
    }
  }
  
  private void w()
  {
    RIJChannelBannerModule localRIJChannelBannerModule = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerModule;
    if (localRIJChannelBannerModule != null)
    {
      localRIJChannelBannerModule.unInitialize();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerModule = null;
    }
  }
  
  private void x()
  {
    RIJFeedsInsertModule localRIJFeedsInsertModule = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsRIJFeedsInsertModule;
    if (localRIJFeedsInsertModule != null)
    {
      localRIJFeedsInsertModule.unInitialize();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsRIJFeedsInsertModule = null;
    }
  }
  
  private void y()
  {
    PTSGeneralRequestModule localPTSGeneralRequestModule = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsNetworkPTSGeneralRequestModule;
    if (localPTSGeneralRequestModule != null)
    {
      localPTSGeneralRequestModule.unInitialize();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsNetworkPTSGeneralRequestModule = null;
    }
  }
  
  private void z()
  {
    RIJCoinInfoModule localRIJCoinInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoRewardRIJCoinInfoModule;
    if (localRIJCoinInfoModule != null)
    {
      localRIJCoinInfoModule.unInitialize();
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoRewardRIJCoinInfoModule = null;
    }
  }
  
  public int a()
  {
    SubscriptionInfoModule localSubscriptionInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSubscriptionInfoModule;
    if (localSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionUnReadNum mSubscriptionInfoModule is null!");
      }
      return 0;
    }
    return localSubscriptionInfoModule.a();
  }
  
  public int a(Integer paramInteger)
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getRefreshedArticleInfoSize mArticleInfoModule is null!");
      }
      return 0;
    }
    return localArticleInfoModule.a().a(paramInteger);
  }
  
  public Parcelable a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.a());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "getLeaveChannelPosInfo mLeavePosCache is null.");
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLogicEngine", 2, new Object[] { "getPosInfo, key: ", localObject, ", state: ", this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject) });
    }
    return (Parcelable)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
  }
  
  public Pair<Integer, Integer> a(int paramInt)
  {
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRIJAdvertisementInfoModule;
    if (localIRIJAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getLocalAdvertisementRange mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return localIRIJAdvertisementInfoModule.a(paramInt);
  }
  
  public Pair<Integer, Integer> a(int paramInt1, int paramInt2)
  {
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRIJAdvertisementInfoModule;
    if (localIRIJAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getPreloadAdvertisementAtPostion mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return localIRIJAdvertisementInfoModule.a(paramInt1, paramInt2);
  }
  
  public AdvertisementInfo a(int paramInt1, int paramInt2)
  {
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRIJAdvertisementInfoModule;
    if (localIRIJAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getAdvertisementInfo mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return localIRIJAdvertisementInfoModule.a(paramInt1, paramInt2);
  }
  
  public IRIJAdvertisementInfoModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRIJAdvertisementInfoModule;
  }
  
  public IRIJAdvertisementRequestProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineAdvertisementInfoModuleRequestProxy;
  }
  
  public RIJBiuAndCommentMixPBModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuRIJBiuAndCommentMixPBModule;
  }
  
  @Nullable
  public ReadInJoyCommentPBModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule;
  }
  
  public RIJChannelBannerModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerModule;
  }
  
  public RIJFeedsDynamicInsertModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsRIJFeedsDynamicInsertModule;
  }
  
  public RIJFeedsInsertModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsRIJFeedsInsertModule;
  }
  
  public DynamicChannelDataModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsDataDynamicChannelDataModule;
  }
  
  public DynamicChannelHeaderModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsDataDynamicChannelHeaderModule;
  }
  
  public PTSGeneralRequestModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsNetworkPTSGeneralRequestModule;
  }
  
  public RIJUserLevelRequestModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoAccountRIJUserLevelRequestModule;
  }
  
  public FreeNetFlowInfoModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonFreeNetFlowInfoModule;
  }
  
  public RIJLiveStatusModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJLiveStatusModule;
  }
  
  public RIJUserApproveModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJUserApproveModule;
  }
  
  @Nullable
  public ReadInJoyUserInfoModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonReadInJoyUserInfoModule;
  }
  
  public ReadInJoyDianDianEntranceModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoDiandianReadInJoyDianDianEntranceModule;
  }
  
  public FastWebModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebFastWebModule;
  }
  
  public ArticleInfoModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
  }
  
  public BannerInfoModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsBannerInfoModule;
  }
  
  public SelectPositionModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSelectPositionModule;
  }
  
  public AbsBaseArticleInfo a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    if (ReadinjoyFixPosArticleManager.isFixPosArticleSeq(paramLong)) {
      return ReadinjoyFixPosArticleManager.getInstant().getSpecialArticleInfo(paramInt, paramLong);
    }
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a().a(Integer.valueOf(paramInt), Long.valueOf(paramLong));
  }
  
  public AbsBaseArticleInfo a(Integer paramInteger)
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getLastReadArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    return localArticleInfoModule.a().a(paramInteger);
  }
  
  public ChannelInfo a(int paramInt)
  {
    ChannelInfoModule localChannelInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelInfoModule;
    if (localChannelInfoModule != null) {
      return localChannelInfoModule.a(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public FeedsPreloadDataModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsPreloadFeedsPreloadDataModule;
  }
  
  public FollowListInfoModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowFollowListInfoModule;
  }
  
  public UserOperationModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoReportUserOperationModule;
  }
  
  public RIJUGCAccountCreateModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoUgcRIJUGCAccountCreateModule;
  }
  
  public ReadInJoyDraftboxModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoUgcReadInJoyDraftboxModule;
  }
  
  public RIJWeChatVideoSeeLaterModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoRIJWeChatVideoSeeLaterModule;
  }
  
  public EntityManagerFactory a()
  {
    Object localObject1 = RIJQQAppInterfaceUtil.a();
    if (localObject1 != null) {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) || (!TextUtils.equals(((ReadInJoyEntityManagerFactory)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory).name, (CharSequence)localObject1)))
        {
          localObject1 = new ReadInJoyEntityManagerFactory((String)localObject1);
          ThreadManager.post(new ReadInJoyLogicEngine.1(this, (ReadInJoyEntityManagerFactory)localObject1), 8, null, false);
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = ((EntityManagerFactory)localObject1);
        }
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
      }
      finally {}
    }
    throw new IllegalStateException("Can not create a entity factory, the account is null.");
  }
  
  public String a()
  {
    FollowCoverInfoModule localFollowCoverInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowFollowCoverInfoModule;
    if (localFollowCoverInfoModule != null) {
      return localFollowCoverInfoModule.a();
    }
    return "";
  }
  
  public HashMap<Long, Long> a()
  {
    FollowCoverInfoModule localFollowCoverInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowFollowCoverInfoModule;
    if (localFollowCoverInfoModule != null) {
      return localFollowCoverInfoModule.a();
    }
    return null;
  }
  
  public List<ChannelSection> a()
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelCoverInfoModule;
    if (localChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChannelCoverSectionList mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return localChannelCoverInfoModule.d();
  }
  
  public List<ChannelCoverInfo> a(int paramInt)
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelCoverInfoModule;
    if (localChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return localChannelCoverInfoModule.b(paramInt);
  }
  
  public List<Long> a(Integer paramInteger)
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localArticleInfoModule != null) {
      return localArticleInfoModule.a().c(paramInteger);
    }
    return null;
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
  
  public JSONObject a()
  {
    DailyDynamicHeaderModule localDailyDynamicHeaderModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoDailyDailyDynamicHeaderModule;
    if (localDailyDynamicHeaderModule != null) {
      return localDailyDynamicHeaderModule.b();
    }
    return null;
  }
  
  public oidb_cmd0x68b.ReqAdvertisePara a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, int paramInt1, int paramInt2, int paramInt3, int paramInt4, AdRequestData paramAdRequestData)
  {
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRIJAdvertisementInfoModule;
    if (localIRIJAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "makeReqAdvertisePara mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return (oidb_cmd0x68b.ReqAdvertisePara)localIRIJAdvertisementInfoModule.a(paramRequest0x68bParams, paramInt1, paramInt2, paramInt3, paramInt4, paramAdRequestData);
  }
  
  public void a()
  {
    this.jdField_c_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelCoverInfoModule;
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
    ChannelInfoModule localChannelInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelInfoModule;
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
      localChannelInfoModule.c();
      return;
    }
    localChannelInfoModule.b(true);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRIJAdvertisementInfoModule;
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
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRIJAdvertisementInfoModule;
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
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelArticleFromDB mArticleInfoModule is null!");
      }
      return;
    }
    localArticleInfoModule.a().a(paramInt1, paramInt2, paramLong, paramBoolean, ReadInJoyUtils.a());
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localArticleInfoModule != null) {
      localArticleInfoModule.a().a(paramInt1, paramInt2, paramLong1, paramBoolean, paramLong2, ReadInJoyUtils.a());
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
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelCoverInfoModule;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "moveChannelToFront mChannelCoverInfoModule is null!");
      }
      return;
    }
    List localList = ((ChannelCoverInfoModule)localObject1).d();
    Object localObject2 = null;
    if ((localList != null) && (localList.size() > 0))
    {
      int j = -1;
      Object localObject4 = localList.iterator();
      int k;
      do
      {
        localObject1 = localObject2;
        i = j;
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject3 = (ChannelSection)((Iterator)localObject4).next();
        k = CollectionUtils.a(((ChannelSection)localObject3).jdField_a_of_type_JavaUtilList, new ReadInJoyLogicEngine.3(this, paramInt1));
      } while (k < 0);
      localObject2 = (TabChannelCoverInfo)((ChannelSection)localObject3).jdField_a_of_type_JavaUtilList.get(k);
      if (((TabChannelCoverInfo)localObject2).reason == 4) {
        return;
      }
      ((ChannelSection)localObject3).jdField_a_of_type_JavaUtilList.remove(k);
      localObject1 = localObject2;
      int i = j;
      if (localObject3 == localList.get(0))
      {
        i = k;
        localObject1 = localObject2;
      }
      localObject2 = (ChannelSection)localList.get(0);
      paramInt1 = CollectionUtils.a(((ChannelSection)localObject2).jdField_a_of_type_JavaUtilList, new ReadInJoyLogicEngine.4(this));
      if (QLog.isColorLevel())
      {
        localObject3 = ((ChannelSection)localObject2).jdField_a_of_type_JavaUtilList;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(" firstUnLockPosition : ");
        ((StringBuilder)localObject4).append(paramInt1);
        ChannelCoverInfoModule.a((List)localObject3, ((StringBuilder)localObject4).toString());
      }
      Object localObject3 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 != null) && (((ChannelSection)localObject2).jdField_a_of_type_JavaUtilList != null))
      {
        ChannelListDynamicOrderConfigHandler.a(RIJQQAppInterfaceUtil.a(), ((TabChannelCoverInfo)localObject1).mChannelCoverId);
        if ((paramInt1 >= 0) && (!paramBoolean1)) {
          ((ChannelSection)localObject2).jdField_a_of_type_JavaUtilList.add(paramInt1, localObject1);
        } else {
          ((ChannelSection)localObject2).jdField_a_of_type_JavaUtilList.add(localObject1);
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009A59", "0X8009A59", 0, 0, "", "", "", RIJTransMergeKanDianReport.a().addStringNotThrow("uin", ((QQAppInterface)localObject3).getCurrentAccountUin()).addChannelId(((TabChannelCoverInfo)localObject1).mChannelCoverId).addStringNotThrow("source", paramInt2).addStringNotThrow("fromposition", i).build(), false);
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
    ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.a());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "updateLeaveChannelPosInfo mLeavePosCache is null.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLogicEngine", 2, new Object[] { "updatePosInfo, key: ", localObject, ", state: ", paramParcelable });
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, paramParcelable);
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    a(paramInt, paramAbsBaseArticleInfo, Boolean.valueOf(true));
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2)
  {
    if ((paramAbsBaseArticleInfo1 != null) && (paramAbsBaseArticleInfo2 != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a(true, paramInt, Arrays.asList(new Long[] { Long.valueOf(paramAbsBaseArticleInfo1.mArticleID) }), Arrays.asList(new AbsBaseArticleInfo[] { paramAbsBaseArticleInfo2 }), false);
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
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule != null)
    {
      if (RIJFeedsType.A(paramAbsBaseArticleInfo))
      {
        localObject = paramAbsBaseArticleInfo.mGroupSubArticleList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)((Iterator)localObject).next();
          this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a().a(paramInt, localAbsBaseArticleInfo.mRecommendSeq);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a().a(paramInt, paramAbsBaseArticleInfo.mRecommendSeq);
    }
    else
    {
      QLog.d("ArticleInfoModule", 2, "ReadinjoyLogicEngine articleInfoModule is null !");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleReadInfoModule != null) && (paramBoolean.booleanValue()))
    {
      if (RIJFeedsType.A(paramAbsBaseArticleInfo))
      {
        paramBoolean = paramAbsBaseArticleInfo.mGroupSubArticleList.iterator();
        while (paramBoolean.hasNext())
        {
          localObject = (AbsBaseArticleInfo)paramBoolean.next();
          this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleReadInfoModule.a(((AbsBaseArticleInfo)localObject).mArticleID);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleReadInfoModule.a(paramAbsBaseArticleInfo.mArticleID);
    }
    else
    {
      QLog.d("ArticleInfoModule", 2, "ReadinjoyLogicEngine articleReadInfoModule is null !");
    }
    RIJFeedsInsertUtil.a.a(paramInt, paramAbsBaseArticleInfo);
  }
  
  public void a(int paramInt, String paramString)
  {
    List localList = a();
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i = 0;
      while (i < localList.size())
      {
        ChannelSection localChannelSection = (ChannelSection)localList.get(i);
        int j = 0;
        while (j < localChannelSection.jdField_a_of_type_JavaUtilList.size())
        {
          if (paramInt == ((TabChannelCoverInfo)localChannelSection.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverId) {
            ((TabChannelCoverInfo)localChannelSection.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverName = paramString;
          }
          j += 1;
        }
        i += 1;
      }
    }
    a(localList, true);
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelCoverInfoModule;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localObject == null)
    {
      QLog.d("Q.readinjoy.info_module", 1, "refreshChannelArticlesFormServer mArticleInfoModule is null!");
      return;
    }
    List localList = ((ArticleInfoModule)localObject).a().c(Integer.valueOf(paramInt1));
    long l = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a().a(Integer.valueOf(paramInt1));
    localObject = new ReadInJoyRequestParams.Request0x68bParams();
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_b_of_type_Int = paramInt1;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_a_of_type_Long = -1L;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_b_of_type_Boolean = true;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_a_of_type_JavaUtilList = localList;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_c_of_type_Boolean = false;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_b_of_type_JavaUtilList = paramList;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_h_of_type_Int = paramInt2;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_d_of_type_Boolean = true;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_e_of_type_Boolean = true;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_f_of_type_Boolean = paramBoolean1;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a().a(Integer.valueOf(paramInt1));
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_g_of_type_Boolean = paramBoolean2;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_b_of_type_ArrayOfByte = ArticleInfoModuleUtils.a();
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_c_of_type_Int = paramInt3;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_a_of_type_JavaLangString = paramString1;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_c_of_type_Long = paramLong1;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_b_of_type_JavaLangString = paramString2;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_d_of_type_Int = paramInt4;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_d_of_type_Long = paramLong2;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_e_of_type_Long = paramLong3;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_c_of_type_JavaLangString = paramString3;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_i_of_type_Boolean = paramBoolean3;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLebaKDCellInfo = paramLebaKDCellInfo;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_i_of_type_Int |= paramInt6;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_d_of_type_JavaUtilList = paramList2;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_a_of_type_AndroidOsBundle = paramBundle;
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd(paramInt1)) {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_h_of_type_Boolean = true;
    }
    paramInt2 = paramInt5;
    if (paramInt5 == 1001) {
      paramInt2 = 3;
    }
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_g_of_type_Int = paramInt2;
    if (l == -1L) {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_b_of_type_Long = -1L;
    } else {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_b_of_type_Long = (l + 1L);
    }
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_f_of_type_Int |= 0x10;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_f_of_type_Int |= 0x20;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_f_of_type_Int |= 0x100;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_f_of_type_Int |= 0x40;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_f_of_type_Int |= 0x400;
    if (paramInt1 == 56) {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_f_of_type_Int |= 0x1080;
    }
    if (paramInt1 == 0) {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_f_of_type_Int |= 0x800;
    }
    if ((paramInt1 == 40677) || (paramInt4 == 7)) {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).j = 2;
    }
    if (DailyModeConfigHandler.c(paramInt1)) {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).j = 3;
    }
    if (paramList1 != null) {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_c_of_type_JavaUtilList.addAll(paramList1);
    }
    if ((((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_i_of_type_Int & 0x100) != 0)
    {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).j = 4;
      QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "feedsPreload, params service type = ", Integer.valueOf(((ReadInJoyRequestParams.Request0x68bParams)localObject).j), ", beginRecommendSeq = ", Long.valueOf(((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_a_of_type_Long), ", endRecommendSeq = ", Long.valueOf(((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_b_of_type_Long) });
    }
    if (!RIJShowKanDianTabSp.c()) {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_i_of_type_Int |= 0x200;
    }
    QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "68b params recommendFlag = ", Integer.valueOf(((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_i_of_type_Int) });
    if (paramInt1 == 41695)
    {
      paramLebaKDCellInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSelectPositionModule;
      if (paramLebaKDCellInfo != null)
      {
        paramLebaKDCellInfo = paramLebaKDCellInfo.a();
        if (paramLebaKDCellInfo != null)
        {
          if (QLog.isColorLevel())
          {
            paramList1 = new StringBuilder();
            paramList1.append("refreshChannelArticlesFormServer positionData = ");
            paramList1.append(paramLebaKDCellInfo);
            QLog.i("ReadInJoyLogicEngine", 2, paramList1.toString());
          }
          ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPositionData = new PositionData();
          ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPositionData.copy(paramLebaKDCellInfo);
        }
      }
    }
    if ((((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_i_of_type_Int & 0x1000) != 0)
    {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadUnRead = UserReadUnReadInfoManager.a().a();
      UserReadUnReadInfoManager.a().a();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a((ReadInJoyRequestParams.Request0x68bParams)localObject);
    RIJFeedsInsertUtil.a.a(((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_b_of_type_Int, ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_c_of_type_Int, ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_i_of_type_Int);
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
    paramList.append(RIJAppSetting.a(paramString2));
    paramList.append(" recommendFlag is : ");
    paramList.append(((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_i_of_type_Int);
    paramList.append(" pushContext：");
    paramList.append(paramString3);
    paramList.append(" channelID : ");
    paramList.append(paramInt1);
    QLog.i("ArticleInfoModule", 1, paramList.toString());
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRIJAdvertisementInfoModule;
    if (localIRIJAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "setChannelNeedRequestAdvertisement mAdvertisementInfoModule is null!");
      }
      return;
    }
    localIRIJAdvertisementInfoModule.a(paramInt, paramBoolean);
  }
  
  public void a(long paramLong)
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestIndividualArticlesFormServer mArticleInfoModule is null!");
      }
      return;
    }
    localArticleInfoModule.a(paramLong, 1);
  }
  
  public void a(long paramLong, int paramInt)
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localArticleInfoModule != null) {
      localArticleInfoModule.a().a(paramLong, paramInt);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
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
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoRewardRIJCoinInfoModule != null)
    {
      ReadInJoyRequestParams.Request0xed4Params localRequest0xed4Params = new ReadInJoyRequestParams.Request0xed4Params();
      localRequest0xed4Params.jdField_a_of_type_Int = 3;
      localRequest0xed4Params.jdField_a_of_type_JavaLangString = paramString;
      localRequest0xed4Params.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyRequestParams$Request0xed4Params$CoinRewardReq = new ReadInJoyRequestParams.Request0xed4Params.CoinRewardReq();
      localRequest0xed4Params.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyRequestParams$Request0xed4Params$CoinRewardReq.jdField_a_of_type_Long = paramLong;
      localRequest0xed4Params.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyRequestParams$Request0xed4Params$CoinRewardReq.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoRewardRIJCoinInfoModule.a(localRequest0xed4Params, paramBundle);
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
    localObject = a().createEntityManager().query(BaseArticleInfo.class, true, (String)localObject, null, null, null, "mRecommendSeq desc", null);
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
      int i;
      if (localAbsBaseArticleInfo.mSocialFeedInfo != null)
      {
        if ((localAbsBaseArticleInfo.mSocialFeedInfo.jdField_h_of_type_Int != 2) && (paramInt == 2)) {
          i = 1;
        } else {
          i = 0;
        }
        localAbsBaseArticleInfo.mSocialFeedInfo.jdField_h_of_type_Int = paramInt;
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
        j = 1;
      }
      else
      {
        j = 0;
        i = 0;
      }
      int k = j;
      int j = i;
      if (localAbsBaseArticleInfo.mPolymericInfo != null)
      {
        j = i;
        if (localAbsBaseArticleInfo.mPolymericInfo.e != 2)
        {
          j = i;
          if (paramInt == 2) {
            j = 1;
          }
        }
        localAbsBaseArticleInfo.mPolymericInfo.e = paramInt;
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
        k = 1;
      }
      if (k != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.updateEntity(localAbsBaseArticleInfo);
        localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a().a(localAbsBaseArticleInfo, (int)localAbsBaseArticleInfo.mChannelID);
        if ((j != 0) && (localAbsBaseArticleInfo != null)) {
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
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).post(new ReadInJoyLogicEngine.7(this));
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    ArticleReadInfoModule localArticleReadInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleReadInfoModule;
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
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule != null) && (paramBiuInfo != null))
    {
      if (paramLong4 == -1L) {
        paramLong4 = 0L;
      }
      if ((!TextUtils.isEmpty(paramString2)) && (paramInt1 == 17))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a(paramLong1, paramString2, paramInt1, paramString1, null, paramBoolean);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a(paramLong1, paramLong2, paramBiuInfo, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramAbsBaseArticleInfo, paramBoolean);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.info_module", 2, "requestMultiBiu mArticleInfoModule is null!");
    }
  }
  
  public void a(long paramLong1, long paramLong2, com.tencent.mobileqq.kandian.repo.handler.BiuInfo paramBiuInfo, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a(paramLong1, paramLong2, paramBiuInfo, paramString);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    long l = paramLong1;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "autoRefreshForNewBiuCard | mArticleInfoModule is null!");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((l != -1L) && (l != 0L))
    {
      localArrayList.add(Long.valueOf(paramLong1));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("autoRefreshForNewBiuCard | unique_articleId : ");
      ((StringBuilder)localObject).append(l);
      QLog.d("ReadInJoyLogicEngine", 2, ((StringBuilder)localObject).toString());
      paramLong1 = l;
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
      ((JSONObject)localObject).put("biuUin", RIJQQAppInterfaceUtil.a());
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
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
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
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a(paramLong, paramString1, paramInt, paramString2, paramArrayList, paramBoolean);
  }
  
  public void a(long paramLong, List<? extends DislikeParam> paramList)
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
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
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
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
    RecommendFollowForChangeModule localRecommendFollowForChangeModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowRecommendFollowForChangeModule;
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
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRIJAdvertisementInfoModule;
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
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    String str = RIJQQAppInterfaceUtil.a();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangString.equals(str)) && (paramAppInterface == this.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = MonitorTimeExecutor.a();
    EntityManager localEntityManager = a().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService = ReadInJoyMSFService.getInstance();
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule = new ArticleInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoReportUserOperationModule = new UserOperationModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleReadInfoModule = new ArticleReadInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonInterestLabelInfoModule = new InterestLabelInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSubscriptionInfoModule = new SubscriptionInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelInfoModule = new ChannelInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRIJAdvertisementInfoModule = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createAdvertisementInfoModule();
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineAdvertisementInfoModuleRequestProxy = new AdvertisementInfoModuleRequestProxy(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelCoverInfoModule = new ChannelCoverInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonSelfInfoModule = new SelfInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowFollowCoverInfoModule = new FollowCoverInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoShareKingShareReadInjoyModule = new KingShareReadInjoyModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebFastWebModule = new FastWebModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonReadInJoyUserInfoModule = new ReadInJoyUserInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowRecommendFollowForChangeModule = new RecommendFollowForChangeModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowFollowListInfoModule = new FollowListInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsBannerInfoModule = new BannerInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoVideoArticleModule = new VideoArticleModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoUgcReadInJoyDraftboxModule = new ReadInJoyDraftboxModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonFreeNetFlowInfoModule = new FreeNetFlowInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule = new ReadInJoyCommentPBModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsDataDynamicChannelDataModule = new DynamicChannelDataModule(localEntityManager, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsDataDynamicChannelHeaderModule = new DynamicChannelHeaderModule(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsPreloadFeedsPreloadDataModule = new FeedsPreloadDataModule(this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoDailyDailyDynamicHeaderModule = new DailyDynamicHeaderModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSelectPositionModule = new SelectPositionModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoDiandianReadInJoyDianDianEntranceModule = new ReadInJoyDianDianEntranceModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuRIJBiuAndCommentMixPBModule = new RIJBiuAndCommentMixPBModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJUserApproveModule = new RIJUserApproveModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoUgcRIJUGCAccountCreateModule = new RIJUGCAccountCreateModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerModule = new RIJChannelBannerModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsRIJFeedsInsertModule = new RIJFeedsInsertModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsNetworkPTSGeneralRequestModule = new PTSGeneralRequestModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoRewardRIJCoinInfoModule = new RIJCoinInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJLiveStatusModule = new RIJLiveStatusModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommentRIJCommentReportModule = new RIJCommentReportModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoAccountRIJUserLevelRequestModule = new RIJUserLevelRequestModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoRIJWeChatVideoSeeLaterModule = new RIJWeChatVideoSeeLaterModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsRIJFeedsDynamicInsertModule = new RIJFeedsDynamicInsertModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    DailyModeConfigHandler.a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    ReadInJoyCommentDataManager.f();
    TemplateFactory.a();
    RealTimeTemplateFactory.b();
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyFollowingMemberPrefetcher = new ReadInJoyFollowingMemberPrefetcher(paramAppInterface, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowFollowListInfoModule);
    paramAppInterface = new StringBuilder();
    paramAppInterface.append("readinjoy logic engine init finish ! account : ");
    paramAppInterface.append(str);
    QLog.d("ReadInJoyLogicEngine", 2, paramAppInterface.toString());
    v();
  }
  
  public void a(com.tencent.mobileqq.kandian.repo.biu.BiuInfo paramBiuInfo)
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
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
    RIJCommentReportModule localRIJCommentReportModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommentRIJCommentReportModule;
    if (localRIJCommentReportModule != null) {
      localRIJCommentReportModule.a(paramCommentReportInfo);
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localArticleInfoModule == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "resetBiuBreathAnimationFlag | mArticleInfoModule is null!");
      return;
    }
    localArticleInfoModule.a().a(paramAbsBaseArticleInfo);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestSubmitComment mArticleInfoModule is null!");
      }
      return;
    }
    if ((paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a(paramAbsBaseArticleInfo, paramString);
      return;
    }
    QLog.d("Q.readinjoy.info_module", 2, "requestSubmitComment articleinfo or commentinfo is null!");
  }
  
  public void a(ChannelInfo paramChannelInfo)
  {
    ChannelInfoModule localChannelInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelInfoModule;
    if (localChannelInfoModule != null) {
      localChannelInfoModule.a(paramChannelInfo);
    }
  }
  
  @UiThread
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelCoverInfoModule;
    if (localChannelCoverInfoModule == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "updateChannel mChannelCoverInfoModule is null!");
      return;
    }
    localChannelCoverInfoModule.a(paramTabChannelCoverInfo);
  }
  
  public void a(TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo)
  {
    FollowCoverInfoModule localFollowCoverInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowFollowCoverInfoModule;
    if (localFollowCoverInfoModule != null) {
      localFollowCoverInfoModule.a(paramTopicRecommendFeedsInfo);
    }
  }
  
  public void a(TopicInfo paramTopicInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localObject != null)
    {
      ((ArticleInfoModule)localObject).a(paramTopicInfo);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("searchUgcTopicByKeyword: mArticleInfoModule is null when create ugc topic: ");
    ((StringBuilder)localObject).append(paramTopicInfo);
    QLog.d("ReadInJoyLogicEngine", 2, ((StringBuilder)localObject).toString());
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle)
  {
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRIJAdvertisementInfoModule;
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
    SubscriptionInfoModule localSubscriptionInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSubscriptionInfoModule;
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
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule == null)
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
        paramString = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
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
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a(paramString, paramInt, -1, true);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, ArrayList<BiuCommentInfo> paramArrayList, AccountProfileInfo paramAccountProfileInfo)
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
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
    SubscriptionInfoModule localSubscriptionInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSubscriptionInfoModule;
    if (localSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unFollowSubscribeAccount mSubscriptionInfoModule is null!");
      }
      return;
    }
    localSubscriptionInfoModule.a(paramString, paramContext);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8006113", "0X8006113", 0, 0, "", "", "", "");
  }
  
  public void a(String paramString1, String paramString2)
  {
    KingShareReadInjoyModule localKingShareReadInjoyModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoShareKingShareReadInjoyModule;
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
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
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
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localArticleInfoModule != null)
    {
      localArticleInfoModule.a(paramArrayList, 1, paramLong, paramString);
      return;
    }
    paramArrayList = new StringBuilder();
    paramArrayList.append("shareAQinviteFriends, uin = ");
    paramArrayList.append(paramLong);
    QLog.d("ReadInJoyLogicEngine", 2, paramArrayList.toString());
  }
  
  public void a(List<? extends ReportInfo> paramList)
  {
    UserOperationModule localUserOperationModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoReportUserOperationModule;
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
    ChannelCoverInfoModule localChannelCoverInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelCoverInfoModule;
    if (localChannelCoverInfoModule == null)
    {
      QLog.d("ReadInJoyLogicEngine", 2, "updateRecommendAndMyChannelListsToServer failed, mChannelCoverInfoModule is null!");
      return;
    }
    localChannelCoverInfoModule.a(a().a(), paramList, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelCoverInfoModule.a(paramList, paramInt);
  }
  
  public void a(List<ReportInfo> paramList, String paramString)
  {
    UserOperationModule localUserOperationModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoReportUserOperationModule;
    if (localUserOperationModule == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "mUserOperationModule is null.");
      return;
    }
    localUserOperationModule.request0x64eFeedsPreloadReport(paramList, paramString);
  }
  
  public void a(List<ChannelSection> paramList, boolean paramBoolean)
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelCoverInfoModule;
    if (localChannelCoverInfoModule == null)
    {
      QLog.d("ReadInJoyLogicEngine", 2, "updateRecommendAndMyChannelListsToServer failed, mChannelCoverInfoModule is null!");
      return;
    }
    localChannelCoverInfoModule.a(a().a(), paramList, paramBoolean);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(-1) > 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unInit fail, referenceCount is : ");
        localStringBuilder.append(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
        QLog.d("ReadInJoyLogicEngine", 2, localStringBuilder.toString());
        return;
      }
      jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine = null;
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = null;
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService.unInitialize();
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService = null;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      }
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyFollowingMemberPrefetcher != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyFollowingMemberPrefetcher.n();
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyFollowingMemberPrefetcher = null;
      }
      w();
      x();
      y();
      z();
      A();
      C();
      F();
      B();
      D();
      E();
      FeedsPreloadManager.a().b();
      DailyModeConfigHandler.a();
      QLog.d("ReadInJoyLogicEngine", 2, "readinjoy logic engine uninit success!");
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    ChannelInfoModule localChannelInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelInfoModule;
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
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
      localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      if (localObject1 != null) {
        ((KandianMergeManager)((AppInterface)localObject1).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(-1);
      }
      localObject1 = a();
      l1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a().a(Integer.valueOf(70));
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
      l1 = ((ArticleInfoModule)localObject1).a().b(Integer.valueOf(70));
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
    List localList = b(Integer.valueOf(70));
    Object localObject2 = localObject3;
    if (localList != null)
    {
      localObject2 = localObject3;
      if (!localList.isEmpty()) {
        localObject2 = ((AbsBaseArticleInfo)localList.get(localList.size() - 1)).mFeedCookie;
      }
    }
    this.jdField_c_of_type_Int += 1;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a(l1, l2, this.jdField_c_of_type_Int, (HashMap)localObject1, c(), paramString, a(), (String)localObject2);
  }
  
  public boolean a(int paramInt)
  {
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRIJAdvertisementInfoModule;
    if (localIRIJAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "needRequestAdvertisement mAdvertisementInfoModule is null!");
      }
      return true;
    }
    return localIRIJAdvertisementInfoModule.a(paramInt);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localArticleInfoModule == null) {
      return false;
    }
    return localArticleInfoModule.a().a(paramInt1, paramInt2);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localArticleInfoModule == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "loadMoreArticle return false, mArticleInfoModule = null");
      k(paramInt1);
      return false;
    }
    long l = localArticleInfoModule.a().b(Integer.valueOf(paramInt1));
    if (l == -1L)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "loadMoreArticle return false, minRecommendSeq = -1.");
      k(paramInt1);
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a(paramInt1, 20, l - 1L, true, paramInt2, paramInt3, 0, paramInt4, paramInt5);
    return true;
  }
  
  public boolean a(long paramLong)
  {
    ArticleReadInfoModule localArticleReadInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleReadInfoModule;
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
    if (this.jdField_a_of_type_Int == -1) {
      a(paramContext);
    }
    return this.jdField_a_of_type_Int > 0;
  }
  
  public boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localArticleInfoModule == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "isArticleFromRecommendFeeds | mArticleInfoModule is null!");
      return false;
    }
    return localArticleInfoModule.a().a(paramAbsBaseArticleInfo);
  }
  
  public boolean a(ExtraBiuBriefInfo paramExtraBiuBriefInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
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
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localArticleInfoModule != null) {
      return localArticleInfoModule.a().a(paramInteger, paramList, paramBoolean);
    }
    return false;
  }
  
  public boolean a(Long paramLong)
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "isArticleNeedHighLight mArticleInfoModule is null!");
      }
      return false;
    }
    return localArticleInfoModule.a(paramLong);
  }
  
  public int b()
  {
    ChannelInfoModule localChannelInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelInfoModule;
    if (localChannelInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadAllChannelListFromCache mChannelInfoModule is null!");
      }
      return -1;
    }
    return localChannelInfoModule.b();
  }
  
  public AdvertisementInfo b(int paramInt1, int paramInt2)
  {
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRIJAdvertisementInfoModule;
    if (localIRIJAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getAdvertisementInfo mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return localIRIJAdvertisementInfoModule.b(paramInt1, paramInt2);
  }
  
  public AbsBaseArticleInfo b(int paramInt, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    localObject = ((ArticleInfoModule)localObject).a().b(Integer.valueOf(paramInt));
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
  
  public List<TabChannelCoverInfo> b()
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelCoverInfoModule;
    if (localChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getMyChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return localChannelCoverInfoModule.a();
  }
  
  public List<TabChannelCoverInfo> b(int paramInt)
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelCoverInfoModule;
    if (localChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getRecommendChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return localChannelCoverInfoModule.a(paramInt);
  }
  
  public List<AbsBaseArticleInfo> b(Integer paramInteger)
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localArticleInfoModule != null) {
      return localArticleInfoModule.a().b(paramInteger);
    }
    return null;
  }
  
  public void b()
  {
    ArticleReadInfoModule localArticleReadInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleReadInfoModule;
    if (localArticleReadInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadArticleReadInfoList mArticleReadInfoModule is null!");
      }
      return;
    }
    localArticleReadInfoModule.a();
  }
  
  public void b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = a();
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i = 0;
      while (i < localList.size())
      {
        ChannelSection localChannelSection1 = (ChannelSection)localList.get(i);
        ChannelSection localChannelSection2 = new ChannelSection(localChannelSection1.jdField_a_of_type_Long, localChannelSection1.jdField_a_of_type_JavaLangString, localChannelSection1.jdField_b_of_type_JavaLangString);
        int j = 0;
        while (j < localChannelSection1.jdField_a_of_type_JavaUtilList.size())
        {
          if (paramInt != ((TabChannelCoverInfo)localChannelSection1.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverId) {
            localChannelSection2.jdField_a_of_type_JavaUtilList.add(localChannelSection1.jdField_a_of_type_JavaUtilList.get(j));
          }
          j += 1;
        }
        localArrayList.add(localChannelSection2);
        i += 1;
      }
    }
    a(localArrayList, true);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (ChannelCoverInfoModule.a(paramInt1)) {
      c(paramInt1, paramInt2);
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    ChannelInfoModule localChannelInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelInfoModule;
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
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localArticleInfoModule != null) {
      localArticleInfoModule.a().a(paramInt1, paramInt2, paramLong, paramBoolean);
    }
  }
  
  public void b(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localArticleInfoModule != null) {
      localArticleInfoModule.a().a(paramInt, paramAbsBaseArticleInfo);
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    SelfInfoModule localSelfInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonSelfInfoModule;
    if (localSelfInfoModule != null) {
      localSelfInfoModule.a(paramInt, paramString, null);
    }
  }
  
  public void b(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
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
  
  public void b(long paramLong, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyFollowingMemberPrefetcher;
    if (localObject != null) {
      ((ReadInJoyFollowingMemberPrefetcher)localObject).a(paramLong, paramInt);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowFollowListInfoModule;
    if (localObject != null) {
      ((FollowListInfoModule)localObject).a(paramLong, paramInt);
    }
  }
  
  public void b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateArticleInfo mArticleInfoModule is null!");
      }
      return;
    }
    localArticleInfoModule.a().b(paramAbsBaseArticleInfo);
  }
  
  public void b(String paramString)
  {
    SubscriptionInfoModule localSubscriptionInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSubscriptionInfoModule;
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
  
  public int c()
  {
    FollowCoverInfoModule localFollowCoverInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowFollowCoverInfoModule;
    if (localFollowCoverInfoModule != null) {
      return localFollowCoverInfoModule.a();
    }
    return 0;
  }
  
  public List<FollowingMember> c()
  {
    FollowListInfoModule localFollowListInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowFollowListInfoModule;
    if (localFollowListInfoModule == null) {
      return new ArrayList();
    }
    return localFollowListInfoModule.a();
  }
  
  public void c()
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelTopCookieList mArticleInfoModule is null!");
      }
      return;
    }
    localArticleInfoModule.a().b();
  }
  
  public void c(int paramInt)
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelCoverInfoModule;
    if (localChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelAdvertisementFromDB mChannelCoverInfoModule is null!");
      }
      return;
    }
    localChannelCoverInfoModule.b(paramInt);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, false, true);
  }
  
  public void c(long paramLong, int paramInt)
  {
    a(paramLong, paramInt, false);
  }
  
  public void c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateWatchLaterInfo mArticleInfoModule is null!");
      }
      return;
    }
    localArticleInfoModule.a().b(paramAbsBaseArticleInfo);
  }
  
  public void c(String paramString)
  {
    SubscriptionInfoModule localSubscriptionInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSubscriptionInfoModule;
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
    ChannelCoverInfoModule localChannelCoverInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelCoverInfoModule;
    if (localChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getMyChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return;
    }
    localChannelCoverInfoModule.a(paramBoolean);
  }
  
  public int d()
  {
    String str = RIJQQAppInterfaceUtil.a();
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "getLeaveKanDianTabInfo mLeaveKanDianTabCache is null.");
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLogicEngine", 2, new Object[] { "getLeaveKanDianTabInfo, key: ", str, ", tabIndex: ", this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str) });
    }
    return ((Integer)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).intValue();
  }
  
  public void d()
  {
    InterestLabelInfoModule localInterestLabelInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonInterestLabelInfoModule;
    if (localInterestLabelInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestGetInterestLabelInfoList mInterestLabelInfoModule is null!");
      }
      return;
    }
    localInterestLabelInfoModule.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonInterestLabelInfoModule.a(1, 1, 1, false);
  }
  
  public void d(int paramInt)
  {
    ThreadManager.executeOnSubThread(new ReadInJoyLogicEngine.5(this, paramInt));
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a().a(paramInt1, paramInt2);
  }
  
  public void d(String paramString)
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
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
    FollowCoverInfoModule localFollowCoverInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowFollowCoverInfoModule;
    if (localFollowCoverInfoModule != null) {
      localFollowCoverInfoModule.a(paramBoolean);
    }
  }
  
  public void e()
  {
    SubscriptionInfoModule localSubscriptionInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSubscriptionInfoModule;
    if (localSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionFeedList mSubscriptionInfoModule is null!");
      }
      return;
    }
    localSubscriptionInfoModule.e();
  }
  
  public void e(int paramInt)
  {
    if (paramInt != 40677) {
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyLogicEngine.6(this, paramInt));
  }
  
  public void e(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a().b(paramAbsBaseArticleInfo);
  }
  
  public void e(String paramString)
  {
    FollowCoverInfoModule localFollowCoverInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowFollowCoverInfoModule;
    if (localFollowCoverInfoModule != null) {
      localFollowCoverInfoModule.a(paramString);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    ReadInJoyFollowingMemberPrefetcher localReadInJoyFollowingMemberPrefetcher = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyFollowingMemberPrefetcher;
    if (localReadInJoyFollowingMemberPrefetcher != null) {
      localReadInJoyFollowingMemberPrefetcher.c(paramBoolean);
    }
  }
  
  public void f()
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshKanDianUnReadNum mArticleInfoModule is null!");
      }
      return;
    }
    localArticleInfoModule.f();
  }
  
  public void f(int paramInt)
  {
    FollowCoverInfoModule localFollowCoverInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowFollowCoverInfoModule;
    if (localFollowCoverInfoModule != null) {
      localFollowCoverInfoModule.a(paramInt);
    }
  }
  
  public void f(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
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
  
  public void g()
  {
    SubscriptionInfoModule localSubscriptionInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSubscriptionInfoModule;
    if (localSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionUnReadNum mSubscriptionInfoModule is null!");
      }
      return;
    }
    localSubscriptionInfoModule.f();
  }
  
  public void g(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void g(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
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
  
  public void h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mArticleInfoModule is null!");
      }
      return;
    }
    ((ArticleInfoModule)localObject).d();
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSubscriptionInfoModule;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mSubscriptionInfoModule is null!");
      }
      return;
    }
    ((SubscriptionInfoModule)localObject).c();
  }
  
  public void h(int paramInt)
  {
    String str = RIJQQAppInterfaceUtil.a();
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "updateLeaveKanDianTabInfo mLeaveKanDianTabCache is null.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLogicEngine", 2, new Object[] { "updateLeaveKanDianTabInfo, key: ", str, ", tabIndex: ", Integer.valueOf(paramInt) });
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Integer.valueOf(paramInt));
  }
  
  public void h(String paramString)
  {
    DailyDynamicHeaderModule localDailyDynamicHeaderModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoDailyDailyDynamicHeaderModule;
    if (localDailyDynamicHeaderModule != null) {
      localDailyDynamicHeaderModule.a(paramString);
    }
  }
  
  public void i()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mArticleInfoModule is null!");
      }
    }
    else {
      ((ArticleInfoModule)localObject).e();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSubscriptionInfoModule;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mSubscriptionInfoModule is null!");
      }
    }
    else {
      ((SubscriptionInfoModule)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRIJAdvertisementInfoModule;
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
  
  public void i(int paramInt)
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localArticleInfoModule != null) {
      localArticleInfoModule.a().d(paramInt);
    }
  }
  
  public void i(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoRewardRIJCoinInfoModule != null)
    {
      ReadInJoyRequestParams.Request0xed4Params localRequest0xed4Params = new ReadInJoyRequestParams.Request0xed4Params();
      localRequest0xed4Params.jdField_a_of_type_Int = 4;
      localRequest0xed4Params.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoRewardRIJCoinInfoModule.a(localRequest0xed4Params, null);
    }
  }
  
  public void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mArticleInfoModule is null!");
      }
      return;
    }
    ((ArticleInfoModule)localObject).b();
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSubscriptionInfoModule;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mSubscriptionInfoModule is null!");
      }
      return;
    }
    ((SubscriptionInfoModule)localObject).a();
  }
  
  public void j(int paramInt)
  {
    b(paramInt, "");
  }
  
  public void j(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoRewardRIJCoinInfoModule != null)
    {
      ReadInJoyRequestParams.Request0xed4Params localRequest0xed4Params = new ReadInJoyRequestParams.Request0xed4Params();
      localRequest0xed4Params.jdField_a_of_type_Int = 5;
      localRequest0xed4Params.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoRewardRIJCoinInfoModule.a(localRequest0xed4Params);
    }
  }
  
  public void k()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mArticleInfoModule is null!");
      }
      return;
    }
    ((ArticleInfoModule)localObject).c();
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSubscriptionInfoModule;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mSubscriptionInfoModule is null!");
      }
      return;
    }
    ((SubscriptionInfoModule)localObject).b();
  }
  
  public void l()
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelCoverInfoModule;
    if (localChannelCoverInfoModule == null)
    {
      QLog.d("Q.readinjoy.info_module", 1, "refreshRecommendAnMyCoverListFromServer mChannelCoverInfoModule is null!");
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    localChannelCoverInfoModule.a();
  }
  
  public void m()
  {
    ChannelCoverInfoModule localChannelCoverInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelCoverInfoModule;
    if (localChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadAllChannelCoverListFromDb mChannelCoverInfoModule is null!");
      }
      return;
    }
    localChannelCoverInfoModule.b();
  }
  
  public void o()
  {
    String str = ShareReport.a.b();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    long l = RIJQQAppInterfaceUtil.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a(l, str);
  }
  
  public void p()
  {
    ArticleInfoModule localArticleInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule;
    if (localArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestFollowTab0x8c8UpdateUpvoteAndComment mArticleInfoModule is null!");
      }
      return;
    }
    localArticleInfoModule.a("-1", 0, 70);
  }
  
  public void q()
  {
    FollowListInfoModule localFollowListInfoModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowFollowListInfoModule;
    if (localFollowListInfoModule != null) {
      localFollowListInfoModule.a(300, 2);
    }
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonSelfInfoModule != null) {
      RIJYoungsterModule.a();
    }
  }
  
  public void s()
  {
    ExecutorService localExecutorService = this.jdField_a_of_type_JavaUtilConcurrentExecutorService;
    if ((localExecutorService != null) && (!localExecutorService.isShutdown()) && (!this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isTerminated()))
    {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ReadInJoyLogicEngine.9(this));
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 1, "startFeedsPreload, executorService is not available.");
  }
  
  public void t()
  {
    DailyDynamicHeaderModule localDailyDynamicHeaderModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoDailyDailyDynamicHeaderModule;
    if (localDailyDynamicHeaderModule != null)
    {
      localDailyDynamicHeaderModule.a();
      return;
    }
    QLog.e("ReadInJoyLogicEngine", 1, "[requestDailyDynamicHeaderData] mDailyDynamicHeaderModule == null");
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoRewardRIJCoinInfoModule != null)
    {
      ReadInJoyRequestParams.Request0xed4Params localRequest0xed4Params = new ReadInJoyRequestParams.Request0xed4Params();
      localRequest0xed4Params.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoRewardRIJCoinInfoModule.a(localRequest0xed4Params);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine
 * JD-Core Version:    0.7.0.1
 */