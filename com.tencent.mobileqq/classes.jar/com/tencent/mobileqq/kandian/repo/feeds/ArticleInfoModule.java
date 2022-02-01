package com.tencent.mobileqq.kandian.repo.feeds;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianShortContentGifStrategy;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.pts.PTSPreLayoutHandler;
import com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.account.RIJUserInfoUtil;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.biu.RIJNewBiuCardTransformManager;
import com.tencent.mobileqq.kandian.repo.comment.RIJUpvoteAndCommentHandler;
import com.tencent.mobileqq.kandian.repo.common.IFindRemovedEntity;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.VisibleSetParam;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeParam;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AccountProfileInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleViewModel;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ExtraBiuBriefInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCPicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.RIJCommentInLikeFeedBiuAtlasHandler;
import com.tencent.mobileqq.kandian.repo.handler.RIJCommentInLikeFeedCommentSubmitHandler;
import com.tencent.mobileqq.kandian.repo.handler.RIJCommentInLikeFeedMasterDeliverHandler;
import com.tencent.mobileqq.kandian.repo.handler.RIJCommentInLikeFeedMultiBiuHandler;
import com.tencent.mobileqq.kandian.repo.handler.RIJCommentInLikeFeedUgcDeliverHandler;
import com.tencent.mobileqq.kandian.repo.handler.RIJCommentInLikeFeedUpvoteActionHandler;
import com.tencent.mobileqq.kandian.repo.handler.RIJCommentInLikeFeedUpvoteArticleHandler;
import com.tencent.mobileqq.kandian.repo.handler.RIJCreateUGCTopicHandler;
import com.tencent.mobileqq.kandian.repo.handler.RIJDislikeArticleHandler;
import com.tencent.mobileqq.kandian.repo.handler.RIJGetArticleListHandler;
import com.tencent.mobileqq.kandian.repo.handler.RIJGetIndividualArticleHandler;
import com.tencent.mobileqq.kandian.repo.handler.RIJGetMoreBiuHandler;
import com.tencent.mobileqq.kandian.repo.handler.RIJGetPrivacyListHandler;
import com.tencent.mobileqq.kandian.repo.handler.RIJInteractiveCardsHandler;
import com.tencent.mobileqq.kandian.repo.handler.RIJInviteFriendHandler;
import com.tencent.mobileqq.kandian.repo.handler.RIJLimitFriendHandler;
import com.tencent.mobileqq.kandian.repo.handler.RIJModifyBiuHandler;
import com.tencent.mobileqq.kandian.repo.handler.RIJRefreshTopicInfoHandler;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo;
import com.tencent.mobileqq.kandian.repo.search.RIJSearchUGCTagsHandler;
import com.tencent.mobileqq.kandian.repo.search.RIJSearchUGCTopicHandler;
import com.tencent.mobileqq.kandian.repo.share.RIJShareConfigHandler;
import com.tencent.mobileqq.kandian.repo.ugc.ResultRecord;
import com.tencent.mobileqq.kandian.repo.video.entity.PGCVideoInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;

public class ArticleInfoModule
  extends ReadInJoyEngineModule
{
  private static volatile int jdField_a_of_type_Int = -1;
  private static boolean jdField_a_of_type_Boolean = false;
  private static volatile boolean b = false;
  private RIJUpvoteAndCommentHandler jdField_a_of_type_ComTencentMobileqqKandianRepoCommentRIJUpvoteAndCommentHandler;
  private IFindRemovedEntity<AbsBaseArticleInfo> jdField_a_of_type_ComTencentMobileqqKandianRepoCommonIFindRemovedEntity = new ArticleInfoModule.1(this);
  private ArticleInfoModule.LoadMorePreDealListener jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule$LoadMorePreDealListener;
  private RIJArticleInfoRepo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsRIJArticleInfoRepo;
  private RIJCommentInLikeFeedBiuAtlasHandler jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedBiuAtlasHandler;
  private RIJCommentInLikeFeedCommentSubmitHandler jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedCommentSubmitHandler;
  private RIJCommentInLikeFeedMasterDeliverHandler jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedMasterDeliverHandler;
  private RIJCommentInLikeFeedMultiBiuHandler jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedMultiBiuHandler;
  private RIJCommentInLikeFeedUgcDeliverHandler jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedUgcDeliverHandler;
  private RIJCommentInLikeFeedUpvoteActionHandler jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedUpvoteActionHandler;
  private RIJCommentInLikeFeedUpvoteArticleHandler jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedUpvoteArticleHandler;
  private RIJCreateUGCTopicHandler jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCreateUGCTopicHandler;
  private RIJDislikeArticleHandler jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJDislikeArticleHandler;
  private RIJGetArticleListHandler jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJGetArticleListHandler;
  private RIJGetIndividualArticleHandler jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJGetIndividualArticleHandler;
  private RIJGetMoreBiuHandler jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJGetMoreBiuHandler;
  private RIJGetPrivacyListHandler jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJGetPrivacyListHandler;
  private RIJInteractiveCardsHandler jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJInteractiveCardsHandler;
  private RIJInviteFriendHandler jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJInviteFriendHandler;
  private RIJLimitFriendHandler jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJLimitFriendHandler;
  private RIJModifyBiuHandler jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJModifyBiuHandler;
  private RIJRefreshTopicInfoHandler jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJRefreshTopicInfoHandler;
  private RIJSearchUGCTagsHandler jdField_a_of_type_ComTencentMobileqqKandianRepoSearchRIJSearchUGCTagsHandler;
  private RIJSearchUGCTopicHandler jdField_a_of_type_ComTencentMobileqqKandianRepoSearchRIJSearchUGCTopicHandler;
  private RIJShareConfigHandler jdField_a_of_type_ComTencentMobileqqKandianRepoShareRIJShareConfigHandler;
  
  public ArticleInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    g();
    registerEntityFinder(BaseArticleInfo.class, this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonIFindRemovedEntity);
  }
  
  public static int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public static void a()
  {
    jdField_a_of_type_Int = -1;
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List<AbsBaseArticleInfo> paramList, long paramLong1, long paramLong2)
  {
    List localList1 = null;
    if (!paramBoolean1)
    {
      ReadInJoyLogicEngineEventDispatcher.a().b(false, paramInt, null, false);
      return;
    }
    if (paramList == null)
    {
      ReadInJoyLogicEngineEventDispatcher.a().b(true, paramInt, null, true);
      return;
    }
    List localList2 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsRIJArticleInfoRepo.b(Integer.valueOf(paramInt));
    ArticleInfoModule.LoadMorePreDealListener localLoadMorePreDealListener = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule$LoadMorePreDealListener;
    if (localLoadMorePreDealListener != null) {
      localList1 = localLoadMorePreDealListener.a(paramInt, localList2, paramList);
    }
    if ((localList1 != null) && (!localList1.isEmpty())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsRIJArticleInfoRepo.a(Integer.valueOf(paramInt), localList1, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsRIJArticleInfoRepo.a(Integer.valueOf(paramInt), paramList, true);
    boolean bool = paramList.isEmpty();
    paramBoolean1 = bool;
    if (paramInt == 70) {
      if ((!bool) && (!paramBoolean2)) {
        paramBoolean1 = false;
      } else {
        paramBoolean1 = true;
      }
    }
    localList1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsRIJArticleInfoRepo.a(Integer.valueOf(paramInt));
    if ((paramInt == 70) && (this.mApp != null) && (paramBoolean1)) {
      ((KandianMergeManager)this.mApp.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(localList1.size());
    }
    if (paramInt == 0) {
      ReadinjoyReportUtils.a(paramList, localList1, false);
    } else if (DailyModeConfigHandler.c(paramInt)) {
      KandianDailyReportUtils.a(paramList, localList1, false);
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(true, paramInt, localList1, paramBoolean1);
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  private void b(int paramInt)
  {
    this.mMainThreadHandler.post(new ArticleInfoModule.2(this, paramInt));
  }
  
  private void b(com.tencent.mobileqq.kandian.repo.biu.BiuInfo paramBiuInfo)
  {
    if (paramBiuInfo == null)
    {
      QLog.d("ArticleInfoModule", 2, "transformNormalToNewBiuCard | biuInfo is null!");
      return;
    }
    if (paramBiuInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null)
    {
      QLog.d("ArticleInfoModule", 2, "transformNormalToNewBiuCard | originArticleInfo is null!");
      return;
    }
    long l1 = paramBiuInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId;
    long l2 = paramBiuInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedType;
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramBiuInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    localAbsBaseArticleInfo.mCardJumpUrl = paramBiuInfo.e;
    localAbsBaseArticleInfo.commentBtnJumpUrl = paramBiuInfo.c;
    localAbsBaseArticleInfo.commentShareUrl = paramBiuInfo.d;
    localAbsBaseArticleInfo.isCardJumpUrlAvailable = paramBiuInfo.b;
    localAbsBaseArticleInfo.mProteusTemplateBean = null;
    localAbsBaseArticleInfo.mAbandonRepeatFlag = 1;
    localAbsBaseArticleInfo.mFeedType = 36;
    Object localObject1 = localAbsBaseArticleInfo.mSocialFeedInfo;
    localAbsBaseArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
    if (localObject1 != null)
    {
      localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Int;
      localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo = ((SocializeFeedsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo;
      localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo = ((SocializeFeedsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo;
    }
    localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long = RIJQQAppInterfaceUtil.a();
    localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.c = 1;
    localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo = new com.tencent.mobileqq.kandian.repo.handler.BiuInfo();
    localAbsBaseArticleInfo.mFeedId = paramBiuInfo.jdField_a_of_type_Long;
    localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long = paramBiuInfo.jdField_a_of_type_Long;
    localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b = Long.valueOf(l2);
    localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaLangLong = Long.valueOf(l1);
    localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
    localObject1 = new BiuCommentInfo();
    Object localObject2 = new String(Base64Util.decode(paramBiuInfo.jdField_a_of_type_JavaLangString, 0));
    ((BiuCommentInfo)localObject1).mBiuComment = EmotionCodecUtils.b((String)localObject2);
    ((BiuCommentInfo)localObject1).mUin = Long.valueOf(RIJQQAppInterfaceUtil.a());
    ((BiuCommentInfo)localObject1).mFeedId = Long.valueOf(paramBiuInfo.jdField_a_of_type_Long);
    ((BiuCommentInfo)localObject1).mBiuTime = 0;
    ((BiuCommentInfo)localObject1).mOrigBiuComment = ((String)localObject2);
    ((BiuCommentInfo)localObject1).mFeedsType = 36;
    localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList.add(localObject1);
    localAbsBaseArticleInfo.articleViewModel = ArticleViewModel.a(localAbsBaseArticleInfo);
    paramBiuInfo = new StringBuilder();
    paramBiuInfo.append("transformNormalToNewBiuCard | newArticleInfo:");
    paramBiuInfo.append(localAbsBaseArticleInfo);
    QLog.d("ArticleInfoModule", 2, paramBiuInfo.toString());
    paramBiuInfo = a().c(0);
    localObject1 = new ArrayList();
    if (paramBiuInfo != null)
    {
      int i;
      if (paramBiuInfo.containsKey(Long.valueOf(localAbsBaseArticleInfo.mRecommendSeq)))
      {
        paramBiuInfo.put(Long.valueOf(localAbsBaseArticleInfo.mRecommendSeq), localAbsBaseArticleInfo);
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsRIJArticleInfoRepo.b(0, paramBiuInfo);
        i = 1;
      }
      else
      {
        i = 0;
      }
      localObject2 = paramBiuInfo.values().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add((AbsBaseArticleInfo)((Iterator)localObject2).next());
      }
      if (i != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsRIJArticleInfoRepo.a(Integer.valueOf(0), (List)localObject1, true);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsRIJArticleInfoRepo.a(Integer.valueOf(0));
        ReadInJoyLogicEngineEventDispatcher.a().b(0, (List)localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("transformNormalToNewBiuCard | update DB , cached biuCardArticleInfo: ");
        ((StringBuilder)localObject1).append(paramBiuInfo.get(Long.valueOf(localAbsBaseArticleInfo.mRecommendSeq)));
        QLog.d("ArticleInfoModule", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  private static void b(List<AbsBaseArticleInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramList.next();
        if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mFeedType == 29)) {
          QLog.d("ArticleInfoModule", 1, new Object[] { "printProteusOnline: \n", localAbsBaseArticleInfo.toProteusOnlineString() });
        }
      }
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static boolean b()
  {
    return b;
  }
  
  private void c(List<AbsBaseArticleInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (AbsBaseArticleInfo)paramList.next();
        if ((((AbsBaseArticleInfo)localObject).mSocialFeedInfo != null) && (((AbsBaseArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null) && (((AbsBaseArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a != null) && (((AbsBaseArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a.size() > 0))
        {
          localObject = ((AbsBaseArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a.iterator();
          while (((Iterator)localObject).hasNext())
          {
            PGCVideoInfo localPGCVideoInfo = ((PGCPicInfo)((Iterator)localObject).next()).a;
            if ((localPGCVideoInfo != null) && (!TextUtils.isEmpty(localPGCVideoInfo.e)))
            {
              VideoUrlInfo localVideoUrlInfo = ThirdVideoManager.a(localPGCVideoInfo.e);
              if ((localVideoUrlInfo == null) || (!localVideoUrlInfo.a(System.currentTimeMillis() / 1000L, 3600L))) {
                localArrayList.add(localPGCVideoInfo.e);
              }
            }
          }
        }
      }
    }
    if (localArrayList.size() > 0) {
      KandianShortContentGifStrategy.a().a((String[])localArrayList.toArray(new String[localArrayList.size()]), null);
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsRIJArticleInfoRepo = new RIJArticleInfoRepo(this.mExecutorService, this.mEntityManager, this.mMainThreadHandler, this, this.mApp);
    h();
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJModifyBiuHandler = new RIJModifyBiuHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJInteractiveCardsHandler = new RIJInteractiveCardsHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJRefreshTopicInfoHandler = new RIJRefreshTopicInfoHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJGetPrivacyListHandler = new RIJGetPrivacyListHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCreateUGCTopicHandler = new RIJCreateUGCTopicHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJLimitFriendHandler = new RIJLimitFriendHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoSearchRIJSearchUGCTopicHandler = new RIJSearchUGCTopicHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJInviteFriendHandler = new RIJInviteFriendHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJGetMoreBiuHandler = new RIJGetMoreBiuHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoSearchRIJSearchUGCTagsHandler = new RIJSearchUGCTagsHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommentRIJUpvoteAndCommentHandler = new RIJUpvoteAndCommentHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJDislikeArticleHandler = new RIJDislikeArticleHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJGetIndividualArticleHandler = new RIJGetIndividualArticleHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedMultiBiuHandler = new RIJCommentInLikeFeedMultiBiuHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedBiuAtlasHandler = new RIJCommentInLikeFeedBiuAtlasHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedUgcDeliverHandler = new RIJCommentInLikeFeedUgcDeliverHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedMasterDeliverHandler = new RIJCommentInLikeFeedMasterDeliverHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedCommentSubmitHandler = new RIJCommentInLikeFeedCommentSubmitHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedUpvoteArticleHandler = new RIJCommentInLikeFeedUpvoteArticleHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedUpvoteActionHandler = new RIJCommentInLikeFeedUpvoteActionHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJGetArticleListHandler = new RIJGetArticleListHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoShareRIJShareConfigHandler = new RIJShareConfigHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
  }
  
  @NonNull
  public RIJArticleInfoRepo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsRIJArticleInfoRepo;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoSearchRIJSearchUGCTagsHandler.a(paramLong);
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJGetIndividualArticleHandler.a(paramLong, paramInt);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJGetPrivacyListHandler.a(paramLong, paramInt1, paramInt2);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, HashMap<Long, Long> paramHashMap, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJGetArticleListHandler.a(paramLong1, paramLong2, paramInt1, paramHashMap, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public void a(long paramLong1, long paramLong2, com.tencent.mobileqq.kandian.repo.handler.BiuInfo paramBiuInfo, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedMultiBiuHandler.a(paramLong1, paramLong2, paramBiuInfo, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramAbsBaseArticleInfo, paramBoolean);
  }
  
  public void a(long paramLong1, long paramLong2, com.tencent.mobileqq.kandian.repo.handler.BiuInfo paramBiuInfo, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJModifyBiuHandler.a(paramLong1, paramLong2, paramBiuInfo, paramString);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedUpvoteActionHandler.a(paramLong1, paramLong2, paramBoolean, paramAbsBaseArticleInfo);
  }
  
  public void a(long paramLong, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoShareRIJShareConfigHandler.a(paramLong, paramString);
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String paramString2, ArrayList<BiuCommentInfo> paramArrayList, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedBiuAtlasHandler.a(paramLong, paramString1, paramInt, paramString2, paramArrayList, paramBoolean);
  }
  
  public void a(long paramLong, List<? extends DislikeParam> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJDislikeArticleHandler.a(paramLong, paramList);
  }
  
  public void a(long paramLong, boolean paramBoolean, FastWebArticleInfo paramFastWebArticleInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedUpvoteArticleHandler.a(paramLong, paramBoolean, paramFastWebArticleInfo, paramInt);
  }
  
  public void a(com.tencent.mobileqq.kandian.repo.biu.BiuInfo paramBiuInfo)
  {
    if (paramBiuInfo == null)
    {
      QLog.d("ArticleInfoModule", 2, "transformNewBiuCard | biuInfo is null!");
      return;
    }
    if (paramBiuInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null)
    {
      QLog.d("ArticleInfoModule", 2, "transformNewBiuCard | originArticleInfo is null!");
      return;
    }
    boolean bool2 = paramBiuInfo.jdField_a_of_type_Boolean;
    boolean bool1 = bool2;
    if (!paramBiuInfo.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsRIJArticleInfoRepo.c(0);
      bool1 = bool2;
      if (localObject != null)
      {
        if (((ConcurrentMap)localObject).containsKey(Long.valueOf(paramBiuInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mRecommendSeq))) {
          bool2 = true;
        }
        bool1 = bool2;
        if (!bool2)
        {
          localObject = ((ConcurrentMap)localObject).values().iterator();
          AbsBaseArticleInfo localAbsBaseArticleInfo;
          do
          {
            bool1 = bool2;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localAbsBaseArticleInfo = (AbsBaseArticleInfo)((Iterator)localObject).next();
          } while ((localAbsBaseArticleInfo == null) || ((localAbsBaseArticleInfo.mArticleID != paramBiuInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID) && ((TextUtils.isEmpty(localAbsBaseArticleInfo.innerUniqueID)) || (!localAbsBaseArticleInfo.innerUniqueID.equalsIgnoreCase(paramBiuInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID)))));
          paramBiuInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = localAbsBaseArticleInfo;
          bool1 = true;
        }
      }
    }
    if ((paramBiuInfo != null) && (paramBiuInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null))
    {
      paramBiuInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.invalidateProteusTemplateBean();
      paramBiuInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.showBreathAnimation = true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("transformNewBiuCard | fromRecommendFeeds:");
    ((StringBuilder)localObject).append(bool1);
    QLog.d("ArticleInfoModule", 2, ((StringBuilder)localObject).toString());
    if (bool1)
    {
      if ((paramBiuInfo != null) && (RIJNewBiuCardTransformManager.a(paramBiuInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)))
      {
        paramBiuInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.commentSrc = paramBiuInfo.jdField_a_of_type_Int;
        b(paramBiuInfo);
      }
      else
      {
        QLog.d("ArticleInfoModule", 2, "transformNormalToNewBiuCard | invalid card type");
      }
    }
    else {
      ReadInJoyLogicEngine.a().a(paramBiuInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID, paramBiuInfo.jdField_a_of_type_Long, paramBiuInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
    }
    RIJNewBiuCardTransformManager.a().c();
    QLog.d("ArticleInfoModule", 2, "transformNewBiuCard | clearBiuInfo");
  }
  
  public void a(ArticleInfoModule.LoadMorePreDealListener paramLoadMorePreDealListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule$LoadMorePreDealListener = paramLoadMorePreDealListener;
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedCommentSubmitHandler.a(paramAbsBaseArticleInfo, paramString);
  }
  
  public void a(ExtraBiuBriefInfo paramExtraBiuBriefInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJGetMoreBiuHandler.a(paramExtraBiuBriefInfo, paramAbsBaseArticleInfo);
  }
  
  public void a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJGetArticleListHandler.a(paramRequest0x68bParams);
  }
  
  public void a(TopicInfo paramTopicInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCreateUGCTopicHandler.a(paramTopicInfo);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJInteractiveCardsHandler.a(paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1, paramInt2, false);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommentRIJUpvoteAndCommentHandler.a(paramString, paramInt1, paramInt2, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, ArrayList<BiuCommentInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedMasterDeliverHandler.a(paramString1, paramString2, paramBundle, paramArrayList, paramBoolean1, paramBoolean2, paramTroopBarPOI, paramVisibleSetParam);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, List<Integer> paramList, String paramString4, String paramString5, String[] paramArrayOfString1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString2, ArrayList<BiuCommentInfo> paramArrayList, boolean paramBoolean, int paramInt1, int paramInt2, AccountProfileInfo paramAccountProfileInfo, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedUgcDeliverHandler.a(paramString1, paramString2, paramString3, paramList, paramString4, paramString5, paramArrayOfString1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString2, paramArrayList, paramBoolean, paramInt1, paramInt2, paramAccountProfileInfo, paramTroopBarPOI, paramVisibleSetParam, paramInt3);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, List<Integer> paramList, String paramString4, String[] paramArrayOfString1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString2, ArrayList<BiuCommentInfo> paramArrayList, boolean paramBoolean, int paramInt1, int paramInt2, AccountProfileInfo paramAccountProfileInfo, int paramInt3)
  {
    a(paramString1, paramString2, paramString3, paramList, paramString4, "", paramArrayOfString1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString2, paramArrayList, paramBoolean, paramInt1, paramInt2, paramAccountProfileInfo, null, VisibleSetParam.a, paramInt3);
  }
  
  public void a(ArrayList<ResultRecord> paramArrayList, int paramInt, long paramLong, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJInviteFriendHandler.a(paramArrayList, paramInt, paramLong, paramString);
  }
  
  public void a(boolean paramBoolean, int paramInt, List<Long> paramList, List<AbsBaseArticleInfo> paramList1)
  {
    a(paramBoolean, paramInt, paramList, paramList1, true);
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, List<AbsBaseArticleInfo> paramList1, boolean paramBoolean2)
  {
    this.mMainThreadHandler.post(new ArticleInfoModule.3(this, paramBoolean1, paramList, paramList1, paramInt, paramBoolean2));
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List<AbsBaseArticleInfo> paramList1, long paramLong1, long paramLong2, List<AbsBaseArticleInfo> paramList2, byte[] paramArrayOfByte, ToServiceMsg paramToServiceMsg)
  {
    PTSPreLayoutHandler.a(paramList1);
    RIJUserInfoUtil.a.a(paramList1, paramInt);
    this.mMainThreadHandler.post(new ArticleInfoModule.4(this, paramLong1, paramInt, paramArrayOfByte, paramBoolean1, paramList1, paramBoolean2, paramLong2, paramList2, paramToServiceMsg));
  }
  
  public boolean a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJGetArticleListHandler.a(paramInt1, paramInt2, paramLong, paramBoolean, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public boolean a(Long paramLong)
  {
    return false;
  }
  
  public void b() {}
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoSearchRIJSearchUGCTagsHandler.a(paramString);
  }
  
  public void c()
  {
    if (this.mApp == null) {
      return;
    }
    boolean bool = this.mApp instanceof QQAppInterface;
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoSearchRIJSearchUGCTopicHandler.a(paramString);
  }
  
  public void d()
  {
    if (this.mApp == null) {
      return;
    }
    if ((!(this.mApp instanceof QQAppInterface)) && (QLog.isColorLevel())) {
      QLog.d("ArticleInfoModule", 2, "mApp isn't instanceof QQAppInterface init model failed!");
    }
  }
  
  public void e() {}
  
  public void f()
  {
    if (this.mApp == null) {
      return;
    }
    b(((KandianMergeManager)((QQAppInterface)this.mApp).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(0));
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x68b"))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJGetArticleListHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbf7"))
    {
      QLog.d("ArticleInfoModule", 1, "onReceive 0xbf7");
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJGetArticleListHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xcba"))
    {
      QLog.d("ArticleInfoModule", 1, "onReceive 0xcba");
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJGetArticleListHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x83e"))
    {
      if (paramToServiceMsg.getAttribute("biu_deliver", Integer.valueOf(0)).equals(Integer.valueOf(1)))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedMultiBiuHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.getAttribute("biu_deliver", Integer.valueOf(0)).equals(Integer.valueOf(2)))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedBiuAtlasHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.getAttribute("ugc_deliver", Integer.valueOf(0)).equals(Integer.valueOf(1)))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedUgcDeliverHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.getAttribute("up_master_deliver", Integer.valueOf(0)).equals(Integer.valueOf(1)))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedMasterDeliverHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.getAttribute("submit_comment", Integer.valueOf(0)).equals(Integer.valueOf(1)))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedCommentSubmitHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.getAttribute("0x83e_upvote_fast_web_article", Integer.valueOf(0)).equals(Integer.valueOf(1)))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedUpvoteArticleHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCommentInLikeFeedUpvoteActionHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x46f"))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJDislikeArticleHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x75e"))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJGetIndividualArticleHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x8c8"))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommentRIJUpvoteAndCommentHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xb83"))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoSearchRIJSearchUGCTagsHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbbd"))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJGetMoreBiuHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbd4_1"))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJInviteFriendHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbde"))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoSearchRIJSearchUGCTopicHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbd6_1"))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJLimitFriendHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc16"))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJCreateUGCTopicHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc32"))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJGetPrivacyListHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xa6e"))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJRefreshTopicInfoHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc6d"))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJInteractiveCardsHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc5b_2"))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerRIJModifyBiuHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xf34")) {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoShareRIJShareConfigHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsRIJArticleInfoRepo.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule
 * JD-Core Version:    0.7.0.1
 */