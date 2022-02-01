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
  private static boolean a = false;
  private static volatile boolean b = false;
  private static volatile int c = -1;
  private RIJShareConfigHandler A;
  private IFindRemovedEntity<AbsBaseArticleInfo> B = new ArticleInfoModule.1(this);
  private ArticleInfoModule.LoadMorePreDealListener d;
  private RIJArticleInfoRepo e;
  private RIJModifyBiuHandler f;
  private RIJInteractiveCardsHandler g;
  private RIJRefreshTopicInfoHandler h;
  private RIJGetPrivacyListHandler i;
  private RIJCreateUGCTopicHandler j;
  private RIJLimitFriendHandler k;
  private RIJSearchUGCTopicHandler l;
  private RIJInviteFriendHandler m;
  private RIJGetMoreBiuHandler n;
  private RIJSearchUGCTagsHandler o;
  private RIJUpvoteAndCommentHandler p;
  private RIJDislikeArticleHandler q;
  private RIJGetIndividualArticleHandler r;
  private RIJCommentInLikeFeedMultiBiuHandler s;
  private RIJCommentInLikeFeedBiuAtlasHandler t;
  private RIJCommentInLikeFeedUgcDeliverHandler u;
  private RIJCommentInLikeFeedMasterDeliverHandler v;
  private RIJCommentInLikeFeedCommentSubmitHandler w;
  private RIJCommentInLikeFeedUpvoteArticleHandler x;
  private RIJCommentInLikeFeedUpvoteActionHandler y;
  private RIJGetArticleListHandler z;
  
  public ArticleInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    k();
    registerEntityFinder(BaseArticleInfo.class, this.B);
  }
  
  public static void a(int paramInt)
  {
    c = paramInt;
  }
  
  public static void a(boolean paramBoolean)
  {
    a = paramBoolean;
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
    List localList2 = this.e.c(Integer.valueOf(paramInt));
    ArticleInfoModule.LoadMorePreDealListener localLoadMorePreDealListener = this.d;
    if (localLoadMorePreDealListener != null) {
      localList1 = localLoadMorePreDealListener.a(paramInt, localList2, paramList);
    }
    if ((localList1 != null) && (!localList1.isEmpty())) {
      this.e.a(Integer.valueOf(paramInt), localList1, true);
    }
    this.e.a(Integer.valueOf(paramInt), paramList, true);
    boolean bool = paramList.isEmpty();
    paramBoolean1 = bool;
    if (paramInt == 70) {
      if ((!bool) && (!paramBoolean2)) {
        paramBoolean1 = false;
      } else {
        paramBoolean1 = true;
      }
    }
    localList1 = this.e.b(Integer.valueOf(paramInt));
    if ((paramInt == 70) && (this.mApp != null) && (paramBoolean1)) {
      ((KandianMergeManager)this.mApp.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b(localList1.size());
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
    return a;
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
    if (paramBiuInfo.e == null)
    {
      QLog.d("ArticleInfoModule", 2, "transformNormalToNewBiuCard | originArticleInfo is null!");
      return;
    }
    long l1 = paramBiuInfo.e.mFeedId;
    long l2 = paramBiuInfo.e.mFeedType;
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramBiuInfo.e;
    localAbsBaseArticleInfo.mCardJumpUrl = paramBiuInfo.i;
    localAbsBaseArticleInfo.commentBtnJumpUrl = paramBiuInfo.g;
    localAbsBaseArticleInfo.commentShareUrl = paramBiuInfo.h;
    localAbsBaseArticleInfo.isCardJumpUrlAvailable = paramBiuInfo.j;
    localAbsBaseArticleInfo.mProteusTemplateBean = null;
    localAbsBaseArticleInfo.mAbandonRepeatFlag = 1;
    localAbsBaseArticleInfo.mFeedType = 36;
    Object localObject1 = localAbsBaseArticleInfo.mSocialFeedInfo;
    localAbsBaseArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
    if (localObject1 != null)
    {
      localAbsBaseArticleInfo.mSocialFeedInfo.c.b = ((SocializeFeedsInfo)localObject1).c.b;
      localAbsBaseArticleInfo.mSocialFeedInfo.t = ((SocializeFeedsInfo)localObject1).t;
      localAbsBaseArticleInfo.mSocialFeedInfo.s = ((SocializeFeedsInfo)localObject1).s;
    }
    localAbsBaseArticleInfo.mSocialFeedInfo.c.a = RIJQQAppInterfaceUtil.c();
    localAbsBaseArticleInfo.mSocialFeedInfo.c.e = 1;
    localAbsBaseArticleInfo.mSocialFeedInfo.n = new com.tencent.mobileqq.kandian.repo.handler.BiuInfo();
    localAbsBaseArticleInfo.mFeedId = paramBiuInfo.b;
    localAbsBaseArticleInfo.mSocialFeedInfo.a = paramBiuInfo.b;
    localAbsBaseArticleInfo.mSocialFeedInfo.n.c = Long.valueOf(l2);
    localAbsBaseArticleInfo.mSocialFeedInfo.n.b = Long.valueOf(l1);
    localAbsBaseArticleInfo.mSocialFeedInfo.n.a = new ArrayList();
    localObject1 = new BiuCommentInfo();
    Object localObject2 = new String(Base64Util.decode(paramBiuInfo.c, 0));
    ((BiuCommentInfo)localObject1).mBiuComment = EmotionCodecUtils.c((String)localObject2);
    ((BiuCommentInfo)localObject1).mUin = Long.valueOf(RIJQQAppInterfaceUtil.c());
    ((BiuCommentInfo)localObject1).mFeedId = Long.valueOf(paramBiuInfo.b);
    ((BiuCommentInfo)localObject1).mBiuTime = 0;
    ((BiuCommentInfo)localObject1).mOrigBiuComment = ((String)localObject2);
    ((BiuCommentInfo)localObject1).mFeedsType = 36;
    localAbsBaseArticleInfo.mSocialFeedInfo.n.a.add(localObject1);
    localAbsBaseArticleInfo.articleViewModel = ArticleViewModel.a(localAbsBaseArticleInfo);
    paramBiuInfo = new StringBuilder();
    paramBiuInfo.append("transformNormalToNewBiuCard | newArticleInfo:");
    paramBiuInfo.append(localAbsBaseArticleInfo);
    QLog.d("ArticleInfoModule", 2, paramBiuInfo.toString());
    paramBiuInfo = i().d(0);
    localObject1 = new ArrayList();
    if (paramBiuInfo != null)
    {
      int i1;
      if (paramBiuInfo.containsKey(Long.valueOf(localAbsBaseArticleInfo.mRecommendSeq)))
      {
        paramBiuInfo.put(Long.valueOf(localAbsBaseArticleInfo.mRecommendSeq), localAbsBaseArticleInfo);
        this.e.b(0, paramBiuInfo);
        i1 = 1;
      }
      else
      {
        i1 = 0;
      }
      localObject2 = paramBiuInfo.values().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add((AbsBaseArticleInfo)((Iterator)localObject2).next());
      }
      if (i1 != 0)
      {
        this.e.a(Integer.valueOf(0), (List)localObject1, true);
        localObject1 = this.e.b(Integer.valueOf(0));
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
  
  public static int c()
  {
    return c;
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
        if ((((AbsBaseArticleInfo)localObject).mSocialFeedInfo != null) && (((AbsBaseArticleInfo)localObject).mSocialFeedInfo.t != null) && (((AbsBaseArticleInfo)localObject).mSocialFeedInfo.t.a != null) && (((AbsBaseArticleInfo)localObject).mSocialFeedInfo.t.a.size() > 0))
        {
          localObject = ((AbsBaseArticleInfo)localObject).mSocialFeedInfo.t.a.iterator();
          while (((Iterator)localObject).hasNext())
          {
            PGCVideoInfo localPGCVideoInfo = ((PGCPicInfo)((Iterator)localObject).next()).i;
            if ((localPGCVideoInfo != null) && (!TextUtils.isEmpty(localPGCVideoInfo.e)))
            {
              VideoUrlInfo localVideoUrlInfo = ThirdVideoManager.b(localPGCVideoInfo.e);
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
  
  public static void d()
  {
    c = -1;
  }
  
  private void k()
  {
    this.e = new RIJArticleInfoRepo(this.mExecutorService, this.mEntityManager, this.mMainThreadHandler, this, this.mApp);
    l();
  }
  
  private void l()
  {
    this.f = new RIJModifyBiuHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.g = new RIJInteractiveCardsHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.h = new RIJRefreshTopicInfoHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.i = new RIJGetPrivacyListHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.j = new RIJCreateUGCTopicHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.k = new RIJLimitFriendHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.l = new RIJSearchUGCTopicHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.m = new RIJInviteFriendHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.n = new RIJGetMoreBiuHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.o = new RIJSearchUGCTagsHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.p = new RIJUpvoteAndCommentHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.q = new RIJDislikeArticleHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.r = new RIJGetIndividualArticleHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.s = new RIJCommentInLikeFeedMultiBiuHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.t = new RIJCommentInLikeFeedBiuAtlasHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.u = new RIJCommentInLikeFeedUgcDeliverHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.v = new RIJCommentInLikeFeedMasterDeliverHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.w = new RIJCommentInLikeFeedCommentSubmitHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.x = new RIJCommentInLikeFeedUpvoteArticleHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.y = new RIJCommentInLikeFeedUpvoteActionHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.z = new RIJGetArticleListHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
    this.A = new RIJShareConfigHandler(this, this.mMainThreadHandler, this.mApp, this.mEntityManager, this.mMSFService, this.mExecutorService);
  }
  
  public void a(long paramLong)
  {
    this.o.a(paramLong);
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.r.a(paramLong, paramInt);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.i.a(paramLong, paramInt1, paramInt2);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, HashMap<Long, Long> paramHashMap, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    this.z.a(paramLong1, paramLong2, paramInt1, paramHashMap, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public void a(long paramLong1, long paramLong2, com.tencent.mobileqq.kandian.repo.handler.BiuInfo paramBiuInfo, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    this.s.a(paramLong1, paramLong2, paramBiuInfo, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramAbsBaseArticleInfo, paramBoolean);
  }
  
  public void a(long paramLong1, long paramLong2, com.tencent.mobileqq.kandian.repo.handler.BiuInfo paramBiuInfo, String paramString)
  {
    this.f.a(paramLong1, paramLong2, paramBiuInfo, paramString);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.y.a(paramLong1, paramLong2, paramBoolean, paramAbsBaseArticleInfo);
  }
  
  public void a(long paramLong, String paramString)
  {
    this.A.a(paramLong, paramString);
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String paramString2, ArrayList<BiuCommentInfo> paramArrayList, boolean paramBoolean)
  {
    this.t.a(paramLong, paramString1, paramInt, paramString2, paramArrayList, paramBoolean);
  }
  
  public void a(long paramLong, List<? extends DislikeParam> paramList)
  {
    this.q.a(paramLong, paramList);
  }
  
  public void a(long paramLong, boolean paramBoolean, FastWebArticleInfo paramFastWebArticleInfo, int paramInt)
  {
    this.x.a(paramLong, paramBoolean, paramFastWebArticleInfo, paramInt);
  }
  
  public void a(com.tencent.mobileqq.kandian.repo.biu.BiuInfo paramBiuInfo)
  {
    if (paramBiuInfo == null)
    {
      QLog.d("ArticleInfoModule", 2, "transformNewBiuCard | biuInfo is null!");
      return;
    }
    if (paramBiuInfo.e == null)
    {
      QLog.d("ArticleInfoModule", 2, "transformNewBiuCard | originArticleInfo is null!");
      return;
    }
    boolean bool2 = paramBiuInfo.a;
    boolean bool1 = bool2;
    if (!paramBiuInfo.a)
    {
      localObject = this.e.d(0);
      bool1 = bool2;
      if (localObject != null)
      {
        if (((ConcurrentMap)localObject).containsKey(Long.valueOf(paramBiuInfo.e.mRecommendSeq))) {
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
          } while ((localAbsBaseArticleInfo == null) || ((localAbsBaseArticleInfo.mArticleID != paramBiuInfo.e.mArticleID) && ((TextUtils.isEmpty(localAbsBaseArticleInfo.innerUniqueID)) || (!localAbsBaseArticleInfo.innerUniqueID.equalsIgnoreCase(paramBiuInfo.e.innerUniqueID)))));
          paramBiuInfo.e = localAbsBaseArticleInfo;
          bool1 = true;
        }
      }
    }
    if ((paramBiuInfo != null) && (paramBiuInfo.e != null))
    {
      paramBiuInfo.e.invalidateProteusTemplateBean();
      paramBiuInfo.e.showBreathAnimation = true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("transformNewBiuCard | fromRecommendFeeds:");
    ((StringBuilder)localObject).append(bool1);
    QLog.d("ArticleInfoModule", 2, ((StringBuilder)localObject).toString());
    if (bool1)
    {
      if ((paramBiuInfo != null) && (RIJNewBiuCardTransformManager.a(paramBiuInfo.e)))
      {
        paramBiuInfo.e.commentSrc = paramBiuInfo.f;
        b(paramBiuInfo);
      }
      else
      {
        QLog.d("ArticleInfoModule", 2, "transformNormalToNewBiuCard | invalid card type");
      }
    }
    else {
      ReadInJoyLogicEngine.a().a(paramBiuInfo.e.mArticleID, paramBiuInfo.b, paramBiuInfo.e.innerUniqueID);
    }
    RIJNewBiuCardTransformManager.a().e();
    QLog.d("ArticleInfoModule", 2, "transformNewBiuCard | clearBiuInfo");
  }
  
  public void a(ArticleInfoModule.LoadMorePreDealListener paramLoadMorePreDealListener)
  {
    this.d = paramLoadMorePreDealListener;
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    this.w.a(paramAbsBaseArticleInfo, paramString);
  }
  
  public void a(ExtraBiuBriefInfo paramExtraBiuBriefInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.n.a(paramExtraBiuBriefInfo, paramAbsBaseArticleInfo);
  }
  
  public void a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams)
  {
    this.z.a(paramRequest0x68bParams);
  }
  
  public void a(String paramString)
  {
    this.g.a(paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1, paramInt2, false);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.p.a(paramString, paramInt1, paramInt2, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, ArrayList<BiuCommentInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam)
  {
    this.v.a(paramString1, paramString2, paramBundle, paramArrayList, paramBoolean1, paramBoolean2, paramTroopBarPOI, paramVisibleSetParam);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, List<Integer> paramList, String paramString4, String paramString5, String[] paramArrayOfString1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString2, ArrayList<BiuCommentInfo> paramArrayList, boolean paramBoolean, int paramInt1, int paramInt2, AccountProfileInfo paramAccountProfileInfo, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam, int paramInt3)
  {
    this.u.a(paramString1, paramString2, paramString3, paramList, paramString4, paramString5, paramArrayOfString1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString2, paramArrayList, paramBoolean, paramInt1, paramInt2, paramAccountProfileInfo, paramTroopBarPOI, paramVisibleSetParam, paramInt3);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, List<Integer> paramList, String paramString4, String[] paramArrayOfString1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString2, ArrayList<BiuCommentInfo> paramArrayList, boolean paramBoolean, int paramInt1, int paramInt2, AccountProfileInfo paramAccountProfileInfo, int paramInt3)
  {
    a(paramString1, paramString2, paramString3, paramList, paramString4, "", paramArrayOfString1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString2, paramArrayList, paramBoolean, paramInt1, paramInt2, paramAccountProfileInfo, null, VisibleSetParam.a, paramInt3);
  }
  
  public void a(ArrayList<ResultRecord> paramArrayList, int paramInt, long paramLong, String paramString)
  {
    this.m.a(paramArrayList, paramInt, paramLong, paramString);
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
    return this.z.a(paramInt1, paramInt2, paramLong, paramBoolean, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public boolean a(Long paramLong)
  {
    return false;
  }
  
  public void b(String paramString)
  {
    this.o.a(paramString);
  }
  
  public void c(String paramString)
  {
    this.l.a(paramString);
  }
  
  public void e() {}
  
  public void f()
  {
    if (this.mApp == null) {
      return;
    }
    boolean bool = this.mApp instanceof QQAppInterface;
  }
  
  public void g()
  {
    if (this.mApp == null) {
      return;
    }
    if ((!(this.mApp instanceof QQAppInterface)) && (QLog.isColorLevel())) {
      QLog.d("ArticleInfoModule", 2, "mApp isn't instanceof QQAppInterface init model failed!");
    }
  }
  
  public void h() {}
  
  @NonNull
  public RIJArticleInfoRepo i()
  {
    return this.e;
  }
  
  public void j()
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
      this.z.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbf7"))
    {
      QLog.d("ArticleInfoModule", 1, "onReceive 0xbf7");
      this.z.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xcba"))
    {
      QLog.d("ArticleInfoModule", 1, "onReceive 0xcba");
      this.z.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x83e"))
    {
      if (paramToServiceMsg.getAttribute("biu_deliver", Integer.valueOf(0)).equals(Integer.valueOf(1)))
      {
        this.s.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.getAttribute("biu_deliver", Integer.valueOf(0)).equals(Integer.valueOf(2)))
      {
        this.t.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.getAttribute("ugc_deliver", Integer.valueOf(0)).equals(Integer.valueOf(1)))
      {
        this.u.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.getAttribute("up_master_deliver", Integer.valueOf(0)).equals(Integer.valueOf(1)))
      {
        this.v.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.getAttribute("submit_comment", Integer.valueOf(0)).equals(Integer.valueOf(1)))
      {
        this.w.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.getAttribute("0x83e_upvote_fast_web_article", Integer.valueOf(0)).equals(Integer.valueOf(1)))
      {
        this.x.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      this.y.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x46f"))
    {
      this.q.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x75e"))
    {
      this.r.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x8c8"))
    {
      this.p.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xb83"))
    {
      this.o.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbbd"))
    {
      this.n.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbd4_1"))
    {
      this.m.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbde"))
    {
      this.l.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbd6_1"))
    {
      this.k.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc16"))
    {
      this.j.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc32"))
    {
      this.i.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xa6e"))
    {
      this.h.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc6d"))
    {
      this.g.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc5b_2"))
    {
      this.f.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xf34")) {
      this.A.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize()
  {
    this.e.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule
 * JD-Core Version:    0.7.0.1
 */