package com.tencent.mobileqq.kandian.repo.feeds;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyStringUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianDailyManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianSubscribeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.RIJWeiShiLegacyUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.ReadInJoyMSFHandlerUtils;
import com.tencent.mobileqq.kandian.glue.pts.PTSPreLayoutHandler;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.structmsg.FeedsStructMsg;
import com.tencent.mobileqq.kandian.repo.account.ArticleInfoHelper;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJDeleteArticleAfterRefreshAladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianFeedsExposureSwitchAladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.WhiteListBidConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.daily.PreLoader;
import com.tencent.mobileqq.kandian.repo.db.struct.ArticleExposureInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.ChannelTopCookie;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleViewModel;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.feeds.preload.FeedsPreloadDataReport;
import com.tencent.mobileqq.kandian.repo.message.PackMsgProcessor;
import com.tencent.mobileqq.kandian.repo.pts.PTSEventDispatcher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;>;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import mqq.os.MqqHandler;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;

public class RIJArticleInfoRepo
{
  private final ExecutorService a;
  private final EntityManager b;
  private final Handler c;
  private final ArticleInfoModule d;
  private final PackMsgProcessor e;
  private final AppInterface f;
  private RIJArticleInfoRepo.PreLoadDBListener g;
  private boolean h = false;
  private boolean i = false;
  private final Map<Integer, ChannelTopCookie> j = new LinkedHashMap();
  private final LinkedHashMap<Integer, ConcurrentMap<Long, Boolean>> k = new LinkedHashMap();
  private final LinkedHashMap<Integer, ConcurrentMap<String, ArticleExposureInfo>> l = new LinkedHashMap();
  private final LinkedHashMap<Integer, ConcurrentMap<Long, AbsBaseArticleInfo>> m = new LinkedHashMap();
  private final Map<Integer, CopyOnWriteArrayList<AbsBaseArticleInfo>> n = new HashMap();
  private final LinkedHashMap<Integer, ConcurrentHashMap<String, AbsBaseArticleInfo>> o = new LinkedHashMap();
  
  public RIJArticleInfoRepo(ExecutorService paramExecutorService, EntityManager paramEntityManager, Handler paramHandler, ArticleInfoModule paramArticleInfoModule, AppInterface paramAppInterface)
  {
    this.a = paramExecutorService;
    this.b = paramEntityManager;
    this.c = paramHandler;
    this.d = paramArticleInfoModule;
    this.f = paramAppInterface;
    this.e = new PackMsgProcessor(paramArticleInfoModule);
  }
  
  private void a(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      long l1 = NetConnInfoCenter.getServerTime();
      paramList = a(Integer.valueOf(paramInt), (Long)paramList.get(0));
      Object localObject;
      if ((paramInt == 0) && (paramList != null))
      {
        localObject = this.f;
        if ((localObject != null) && ((localObject instanceof QQAppInterface)))
        {
          localObject = FeedsStructMsg.a((QQAppInterface)localObject, paramList);
          String str = FeedsStructMsg.a(paramList);
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createFakeStructingMsgWithFields((QQAppInterface)this.f, str, String.valueOf(l1), (String)localObject, paramBoolean);
        }
      }
      if ((paramInt == 40677) && (paramList != null))
      {
        localObject = this.f;
        if ((localObject != null) && ((localObject instanceof QQAppInterface))) {
          RIJWeiShiLegacyUtils.a.a(RIJWeiShiLegacyUtils.a((QQAppInterface)this.f, paramList), l1);
        }
      }
      if ((paramInt == 70) && (paramList != null))
      {
        localObject = this.f;
        if ((localObject != null) && ((localObject instanceof QQAppInterface)))
        {
          localObject = (KandianSubscribeManager)((AppInterface)localObject).getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER);
          if (localObject != null) {
            ((KandianSubscribeManager)localObject).a(paramList, l1);
          }
        }
      }
      if (DailyModeConfigHandler.c(paramInt))
      {
        localObject = this.f;
        if (((localObject instanceof QQAppInterface)) && (paramList != null)) {
          ((KandianDailyManager)((AppInterface)localObject).getManager(QQManagerFactory.KANDIAN_DAILY_MANAGER)).a(paramList);
        }
      }
    }
  }
  
  private void a(ChannelTopCookie paramChannelTopCookie)
  {
    if (paramChannelTopCookie.mChannelID == 70) {
      if ((paramChannelTopCookie.mSetTopCookie != null) && (paramChannelTopCookie.mSetTopCookie.length > 0))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("save follow cookie is ");
          localStringBuilder.append(new String(paramChannelTopCookie.mSetTopCookie));
          QLog.d("RIJArticleInfoRepo", 2, localStringBuilder.toString());
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d("RIJArticleInfoRepo", 2, "save follow cookie is null");
      }
    }
    this.j.put(Integer.valueOf(paramChannelTopCookie.mChannelID), paramChannelTopCookie);
  }
  
  private void a(List<ChannelTopCookie> paramList)
  {
    Handler localHandler = this.c;
    if (localHandler == null) {
      return;
    }
    localHandler.post(new RIJArticleInfoRepo.3(this, paramList));
  }
  
  private void b(Integer paramInteger, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramInteger = (CopyOnWriteArrayList)this.n.get(paramInteger);
    if (paramInteger == null) {
      return;
    }
    Iterator localIterator = paramInteger.iterator();
    while (localIterator.hasNext())
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)localIterator.next();
      if (localAbsBaseArticleInfo.mArticleID == paramAbsBaseArticleInfo.mArticleID) {
        paramInteger.set(paramInteger.indexOf(localAbsBaseArticleInfo), paramAbsBaseArticleInfo);
      }
    }
  }
  
  private void b(List<AbsBaseArticleInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.listIterator();
    while (paramList.hasNext())
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo1 = (AbsBaseArticleInfo)paramList.next();
      AbsBaseArticleInfo localAbsBaseArticleInfo2 = d(localAbsBaseArticleInfo1);
      if (localAbsBaseArticleInfo2 == null)
      {
        paramList.remove();
      }
      else
      {
        if (localAbsBaseArticleInfo2 != localAbsBaseArticleInfo1) {
          paramList.set(localAbsBaseArticleInfo2);
        }
        PackMsgProcessor.a(localAbsBaseArticleInfo2);
        if (ProteusSupportUtil.a(RIJBaseItemViewType.c(localAbsBaseArticleInfo2))) {
          if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadManager.getSubThreadHandler().post(new RIJArticleInfoRepo.14(this, localAbsBaseArticleInfo2));
          } else {
            ProteusSupportUtil.a(localAbsBaseArticleInfo2);
          }
        }
        localAbsBaseArticleInfo1.articleViewModel = ArticleViewModel.a(localAbsBaseArticleInfo1);
      }
    }
  }
  
  private void b(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List<AbsBaseArticleInfo> paramList1, long paramLong1, long paramLong2, List<AbsBaseArticleInfo> paramList2, ToServiceMsg paramToServiceMsg)
  {
    if (paramBoolean1)
    {
      c(paramList1);
      Object localObject;
      if ((paramList1 != null) && (paramList1.size() > 0))
      {
        localObject = new CopyOnWriteArrayList(paramList1);
        this.n.put(Integer.valueOf(paramInt), localObject);
      }
      if (paramList1 != null)
      {
        paramLong1 = System.currentTimeMillis();
        localObject = paramList1.iterator();
        while (((Iterator)localObject).hasNext())
        {
          AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)((Iterator)localObject).next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramLong1);
          localStringBuilder.append("");
          localAbsBaseArticleInfo.mRefreshTime = localStringBuilder.toString();
        }
      }
      this.h = true;
      if ((paramInt != 70) && (paramInt != 41403) && (!DailyModeConfigHandler.a(paramInt)) && (!RIJShowKanDianTabSp.a(paramInt)))
      {
        if ((paramBoolean2) && (!RIJDeleteArticleAfterRefreshAladdinConfig.a(paramInt)))
        {
          a(Integer.valueOf(paramInt), paramList1, true);
          b(paramInt, paramList2);
          return;
        }
        if (QLog.isColorLevel())
        {
          paramList2 = new StringBuilder();
          paramList2.append("handleRefreshChannel clearChannelArticleInfo channelId=");
          paramList2.append(paramInt);
          QLog.e("RIJArticleInfoRepo", 2, paramList2.toString());
        }
        if ((paramList1 != null) && (paramList1.size() > 0))
        {
          this.i = false;
          if (RIJFeedsRefreshUtil.a.a(paramInt, paramToServiceMsg)) {
            f(paramInt);
          } else {
            e(paramInt);
          }
          a(Integer.valueOf(paramInt), paramList1, true);
        }
      }
      else
      {
        if ((paramList1 != null) && (paramList1.size() > 0))
        {
          e(paramInt);
          a(Integer.valueOf(paramInt), paramList1, true);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.e("RIJArticleInfoRepo", 2, "articleInfoList is wrong");
        }
        a(Integer.valueOf(paramInt), paramList1, true);
        b(paramInt, paramList2);
      }
    }
  }
  
  private void c(List<AbsBaseArticleInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)localIterator.next();
      if ((localAbsBaseArticleInfo != null) && (!WhiteListBidConfigHandler.a(localAbsBaseArticleInfo))) {
        localArrayList.add(localAbsBaseArticleInfo);
      }
    }
    if (!localArrayList.isEmpty()) {
      paramList.removeAll(localArrayList);
    }
  }
  
  private AbsBaseArticleInfo d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject = paramAbsBaseArticleInfo;
    if (ArticleInfoHelper.d(paramAbsBaseArticleInfo))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("过滤卡片: ");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo);
      ((StringBuilder)localObject).append("  social : ");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mSocialFeedInfo);
      QLog.d("RIJArticleInfoRepo", 1, ((StringBuilder)localObject).toString());
      localObject = null;
    }
    return localObject;
  }
  
  private List<AbsBaseArticleInfo> h(int paramInt)
  {
    if (this.b.tabbleIsExist("ArticleInfo")) {
      return this.b.query(BaseArticleInfo.class, true, "(mFeedType = ? OR mFeedType = ? OR mFeedType = ? OR mFeedType = ?) AND businessId = ?", new String[] { String.valueOf(17), String.valueOf(19), String.valueOf(0), String.valueOf(24), String.valueOf(paramInt) }, null, null, null, null);
    }
    return null;
  }
  
  private List<AbsBaseArticleInfo> i(int paramInt)
  {
    if (this.b.tabbleIsExist("ArticleInfo")) {
      return this.b.query(BaseArticleInfo.class, true, "(mFeedType = ? OR mFeedType = ?) AND businessId = ?", new String[] { String.valueOf(0), String.valueOf(4), String.valueOf(paramInt) }, null, null, null, null);
    }
    return null;
  }
  
  private void i(Integer paramInteger)
  {
    paramInteger = (ConcurrentMap)this.m.get(paramInteger);
    ArrayList localArrayList = new ArrayList(paramInteger.keySet());
    Collections.sort(localArrayList);
    int i2 = localArrayList.size();
    int i1 = 0;
    while (i1 < i2 - 30)
    {
      paramInteger.remove(localArrayList.get(i1));
      i1 += 1;
    }
  }
  
  private void j(int paramInt)
  {
    RIJArticleInfoRepo.PreLoadDBListener localPreLoadDBListener = this.g;
    if (localPreLoadDBListener != null) {
      localPreLoadDBListener.a(paramInt);
    }
  }
  
  public AbsBaseArticleInfo a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject2;
    if (paramInt == 0)
    {
      ConcurrentMap localConcurrentMap = (ConcurrentMap)this.m.get(Integer.valueOf(0));
      localObject1 = localObject2;
      if (localConcurrentMap != null)
      {
        localObject1 = localConcurrentMap.values().iterator();
        do
        {
          localObject2 = localObject3;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (AbsBaseArticleInfo)((Iterator)localObject1).next();
        } while ((((AbsBaseArticleInfo)localObject2).mRecommendSeq != paramAbsBaseArticleInfo.mRecommendSeq) || (((AbsBaseArticleInfo)localObject2).mArticleID != paramAbsBaseArticleInfo.mArticleID));
        if (localObject2 != null)
        {
          ((AbsBaseArticleInfo)localObject2).mSocialFeedInfoByte = paramAbsBaseArticleInfo.mSocialFeedInfoByte;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("mArticleID = ");
            ((StringBuilder)localObject1).append(((AbsBaseArticleInfo)localObject2).mArticleID);
            ((StringBuilder)localObject1).append(", old data = ");
            ((StringBuilder)localObject1).append(((AbsBaseArticleInfo)localObject2).mSocialFeedInfo);
            ((StringBuilder)localObject1).append(", new data = ");
            ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo.mSocialFeedInfo);
            QLog.d("RIJArticleInfoRepo", 2, ((StringBuilder)localObject1).toString());
          }
          ((AbsBaseArticleInfo)localObject2).mSocialFeedInfo = paramAbsBaseArticleInfo.mSocialFeedInfo;
          localObject1 = localObject2;
        }
        else
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("cannot update no-cached article id:");
            ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo.mArticleID);
            ((StringBuilder)localObject1).append(" title:");
            ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo.mTitle);
            QLog.d("RIJArticleInfoRepo", 2, ((StringBuilder)localObject1).toString());
            localObject1 = localObject2;
          }
        }
      }
    }
    localObject2 = (ConcurrentMap)this.m.get(Integer.valueOf(paramInt));
    localObject3 = localObject1;
    if (localObject2 != null)
    {
      localObject3 = ((ConcurrentMap)localObject2).values().iterator();
      do
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject2 = (AbsBaseArticleInfo)((Iterator)localObject3).next();
      } while ((((AbsBaseArticleInfo)localObject2).mFeedId == 0L) || (((AbsBaseArticleInfo)localObject2).mFeedId != paramAbsBaseArticleInfo.mSocialFeedInfo.a) || (((AbsBaseArticleInfo)localObject2).mFeedType != paramAbsBaseArticleInfo.mFeedType));
      if ((localObject2 != null) && (((AbsBaseArticleInfo)localObject2).mFeedId == paramAbsBaseArticleInfo.mSocialFeedInfo.a) && (((AbsBaseArticleInfo)localObject2).mFeedType == paramAbsBaseArticleInfo.mFeedType))
      {
        ((AbsBaseArticleInfo)localObject2).mSocialFeedInfoByte = paramAbsBaseArticleInfo.mSocialFeedInfoByte;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("mArticleID = ");
          ((StringBuilder)localObject1).append(((AbsBaseArticleInfo)localObject2).mArticleID);
          ((StringBuilder)localObject1).append(", old data = ");
          ((StringBuilder)localObject1).append(((AbsBaseArticleInfo)localObject2).mSocialFeedInfo);
          ((StringBuilder)localObject1).append(", new data = ");
          ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo.mSocialFeedInfo);
          QLog.d("RIJArticleInfoRepo", 2, ((StringBuilder)localObject1).toString());
        }
        ((AbsBaseArticleInfo)localObject2).mSocialFeedInfo = paramAbsBaseArticleInfo.mSocialFeedInfo;
        return localObject2;
      }
      localObject3 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("cannot update no-cached article id:");
        ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo.mArticleID);
        ((StringBuilder)localObject1).append(" title:");
        ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo.mTitle);
        QLog.d("RIJArticleInfoRepo", 2, ((StringBuilder)localObject1).toString());
        localObject3 = localObject2;
      }
    }
    return localObject3;
  }
  
  public AbsBaseArticleInfo a(Integer paramInteger, Long paramLong)
  {
    paramInteger = (ConcurrentMap)this.m.get(paramInteger);
    if (paramInteger == null) {
      return null;
    }
    return (AbsBaseArticleInfo)paramInteger.get(paramLong);
  }
  
  public List<Long> a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    Object localObject = b(paramInt1, paramInt2, paramLong, paramBoolean);
    if (((List)localObject).isEmpty()) {
      return null;
    }
    PreLoader.a().a((List)localObject);
    a(Integer.valueOf(paramInt1), (List)localObject, false);
    ArrayList localArrayList = new ArrayList(((List)localObject).size());
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)((Iterator)localObject).next();
      StringBuilder localStringBuilder;
      if (!localHashSet1.add(Long.valueOf(localAbsBaseArticleInfo.mArticleID)))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadChannelArticleSeqList articleID duplicated, channelID = ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(", seq = ");
        localStringBuilder.append(localAbsBaseArticleInfo.mRecommendSeq);
        localStringBuilder.append("articleID = ");
        localStringBuilder.append(localAbsBaseArticleInfo.mArticleID);
        QLog.d("RIJArticleInfoRepo", 2, localStringBuilder.toString());
      }
      else if (!localHashSet2.add(Long.valueOf(localAbsBaseArticleInfo.mRecommendSeq)))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadChannelArticleSeqList articleRecommendSeq duplicated, channelID = ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(", seq = ");
        localStringBuilder.append(localAbsBaseArticleInfo.mRecommendSeq);
        localStringBuilder.append("articleID = ");
        localStringBuilder.append(localAbsBaseArticleInfo.mArticleID);
        QLog.d("RIJArticleInfoRepo", 2, localStringBuilder.toString());
      }
      else
      {
        localArrayList.add(Long.valueOf(localAbsBaseArticleInfo.mRecommendSeq));
      }
    }
    this.e.a(Integer.valueOf(paramInt1), localArrayList);
    return localArrayList;
  }
  
  public ConcurrentMap<Long, Boolean> a(int paramInt)
  {
    return (ConcurrentMap)this.k.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    this.j.clear();
    this.m.clear();
    this.k.clear();
    this.n.clear();
    this.o.clear();
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, boolean paramBoolean1, long paramLong2, boolean paramBoolean2)
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (!((ExecutorService)localObject1).isShutdown()))
    {
      localObject1 = b(Integer.valueOf(paramInt1));
      Object localObject2;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        PreLoader.a().a(paramInt1, (List)localObject1);
        if ((Looper.myLooper() == Looper.getMainLooper()) && (paramBoolean2))
        {
          PTSEventDispatcher.a().a(paramInt1, (List)localObject1, paramLong2);
          return;
        }
        localObject2 = this.c;
        if (localObject2 != null)
        {
          ((Handler)localObject2).post(new RIJArticleInfoRepo.22(this, paramInt1, (List)localObject1, paramLong2));
          return;
        }
      }
      try
      {
        this.a.execute(new RIJArticleInfoRepo.23(this, paramInt1, (List)localObject1, paramInt2, paramLong1, paramBoolean1, paramLong2));
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[loadFeedsFromDB], e = ");
        ((StringBuilder)localObject2).append(localRejectedExecutionException);
        QLog.e("RIJArticleInfoRepo", 1, ((StringBuilder)localObject2).toString());
        return;
      }
    }
    QLog.i("RIJArticleInfoRepo", 1, "[loadFeedsFromDB], mExecutorService is null or shutDown.");
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      if (((ExecutorService)localObject1).isShutdown()) {
        return;
      }
      localObject1 = b(Integer.valueOf(paramInt1));
      Object localObject2 = ReadInJoyLogicEngine.a().a(Integer.valueOf(paramInt1), (List)localObject1);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        PreLoader.a().a(paramInt1, (List)localObject1);
        PTSPreLayoutHandler.a((List)localObject2);
        if ((Looper.myLooper() == Looper.getMainLooper()) && (paramBoolean2))
        {
          ReadInJoyLogicEngineEventDispatcher.a().a(paramInt1, (List)localObject1);
          return;
        }
        localObject2 = this.c;
        if (localObject2 != null)
        {
          ((Handler)localObject2).post(new RIJArticleInfoRepo.24(this, paramInt1, (List)localObject1));
          return;
        }
      }
      try
      {
        this.a.execute(new RIJArticleInfoRepo.25(this, paramInt1, (List)localObject1, paramInt2, paramLong, paramBoolean1));
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
        QLog.d("RIJArticleInfoRepo", 1, "loadChannelArticle Exception.");
        localRejectedExecutionException.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteChannelArticle channelId=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("recommendSeq=");
      ((StringBuilder)localObject).append(paramLong);
      QLog.e("RIJArticleInfoRepo", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramLong != -2L) && (paramLong != -3L))
    {
      localObject = (ConcurrentMap)this.m.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        return;
      }
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)((ConcurrentMap)localObject).get(Long.valueOf(paramLong));
      if (localAbsBaseArticleInfo == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("deleteChannelArticle connot find channelId=");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append("ArticleInfo with recommendSeq=");
          ((StringBuilder)localObject).append(paramLong);
          QLog.e("RIJArticleInfoRepo", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      a(Integer.valueOf(paramInt), localAbsBaseArticleInfo);
      ((ConcurrentMap)localObject).remove(Long.valueOf(paramLong));
      this.a.execute(new RIJArticleInfoRepo.8(this, localAbsBaseArticleInfo));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("RIJArticleInfoRepo", 2, "deleteChannelArticle recommendSeq is TOPIC/SUBSCRIBE recommendSeq");
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    Object localObject = (ConcurrentMap)this.m.get(Integer.valueOf(paramInt1));
    if (localObject == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList(((ConcurrentMap)localObject).size());
    Iterator localIterator = ((ConcurrentMap)localObject).values().iterator();
    AbsBaseArticleInfo localAbsBaseArticleInfo;
    while (localIterator.hasNext())
    {
      localAbsBaseArticleInfo = (AbsBaseArticleInfo)localIterator.next();
      if (localAbsBaseArticleInfo.mRecommendTime < paramLong) {
        localArrayList.add(localAbsBaseArticleInfo);
      }
    }
    int i2 = ((ConcurrentMap)localObject).size() - localArrayList.size();
    if (i2 < paramInt2)
    {
      Collections.sort(localArrayList, new RIJArticleInfoRepo.11(this));
      int i1 = 0;
      while (i1 < paramInt2 - i2)
      {
        if (localArrayList.size() <= 0) {
          return;
        }
        localArrayList.remove(0);
        i1 += 1;
      }
    }
    localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      localAbsBaseArticleInfo = (AbsBaseArticleInfo)localIterator.next();
      ((ConcurrentMap)localObject).remove(Long.valueOf(localAbsBaseArticleInfo.mRecommendSeq));
      a(Integer.valueOf(paramInt1), localAbsBaseArticleInfo);
    }
    localObject = b(Integer.valueOf(paramInt1));
    this.c.post(new RIJArticleInfoRepo.12(this, paramInt1, (List)localObject));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("delete outdated article cache , cnt ");
    ((StringBuilder)localObject).append(localArrayList.size());
    ((StringBuilder)localObject).append(", reservedCnt : ");
    paramInt1 = i2;
    if (i2 < paramInt2) {
      paramInt1 = paramInt2;
    }
    ((StringBuilder)localObject).append(paramInt1);
    QLog.d("RIJArticleInfoRepo", 2, ((StringBuilder)localObject).toString());
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject2 = (ConcurrentMap)this.l.get(Integer.valueOf(paramInt));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ConcurrentHashMap();
      this.l.put(Integer.valueOf(paramInt), localObject1);
    }
    if ((paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.innerUniqueID)))
    {
      if (((ConcurrentMap)localObject1).containsKey(paramAbsBaseArticleInfo.innerUniqueID))
      {
        ArticleExposureInfo localArticleExposureInfo = (ArticleExposureInfo)((ConcurrentMap)localObject1).get(paramAbsBaseArticleInfo.innerUniqueID);
        localObject2 = localArticleExposureInfo;
        if (localArticleExposureInfo != null)
        {
          localArticleExposureInfo.exposureTime = NetConnInfoCenter.getServerTimeMillis();
          localObject2 = localArticleExposureInfo;
        }
      }
      else
      {
        localObject2 = ArticleExposureInfo.createExposureInfoFromArticle(paramAbsBaseArticleInfo);
      }
      if (localObject2 != null)
      {
        ((ConcurrentMap)localObject1).put(paramAbsBaseArticleInfo.innerUniqueID, localObject2);
        ThreadManager.excute(new RIJArticleInfoRepo.4(this, (ArticleExposureInfo)localObject2), 32, null, true);
      }
    }
  }
  
  public void a(int paramInt, List<AbsBaseArticleInfo> paramList)
  {
    if (!RIJKanDianFeedsExposureSwitchAladdinConfig.a()) {
      return;
    }
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      if ((paramInt != 0) && (!DailyModeConfigHandler.c(paramInt))) {
        return;
      }
      Map localMap = (Map)this.l.get(Integer.valueOf(paramInt));
      if (localMap == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)localIterator.next();
        if ((!TextUtils.isEmpty(localAbsBaseArticleInfo.innerUniqueID)) && (localMap.containsKey(localAbsBaseArticleInfo.innerUniqueID)))
        {
          StringBuilder localStringBuilder;
          if ((localAbsBaseArticleInfo.isNeeaRealExposureFilter) && (localAbsBaseArticleInfo.mAbandonRepeatFlag != 1))
          {
            localArrayList.add(localAbsBaseArticleInfo);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[filterRealExposureArticle] 文章已真实曝光，需去重: ");
            localStringBuilder.append(localAbsBaseArticleInfo);
            localStringBuilder.append(", exposureInfo : ");
            localStringBuilder.append(localMap.get(localAbsBaseArticleInfo.innerUniqueID));
            QLog.d("RIJArticleInfoRepo", 1, localStringBuilder.toString());
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[filterRealExposureArticle] isReplaceFlag is true or isNeedRealExposureFilter flag is false, articleID : ");
            localStringBuilder.append(localAbsBaseArticleInfo.mArticleID);
            QLog.d("RIJArticleInfoRepo", 1, localStringBuilder.toString());
          }
        }
      }
      if (!localArrayList.isEmpty()) {
        paramList.removeAll(localArrayList);
      }
    }
  }
  
  public void a(int paramInt, ConcurrentMap<Long, Boolean> paramConcurrentMap)
  {
    this.k.put(Integer.valueOf(paramInt), paramConcurrentMap);
  }
  
  public void a(long paramLong, int paramInt)
  {
    List localList = c(Integer.valueOf(paramInt));
    if (localList == null) {
      return;
    }
    paramInt = 0;
    while ((paramInt < localList.size()) && ((localList.get(paramInt) == null) || (((AbsBaseArticleInfo)localList.get(paramInt)).mArticleID != paramLong))) {
      paramInt += 1;
    }
    paramInt += 15;
    while (paramInt < localList.size())
    {
      if (localList.get(paramInt) != null) {
        ((AbsBaseArticleInfo)localList.get(paramInt)).invalidateProteusTemplateBean();
      }
      paramInt += 1;
    }
  }
  
  public void a(RIJArticleInfoRepo.PreLoadDBListener paramPreLoadDBListener)
  {
    this.g = paramPreLoadDBListener;
  }
  
  public void a(Integer paramInteger, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramInteger = (CopyOnWriteArrayList)this.n.get(paramInteger);
    if (paramInteger != null) {
      paramInteger.remove(paramAbsBaseArticleInfo);
    }
  }
  
  public void a(Integer paramInteger, byte[] paramArrayOfByte)
  {
    ChannelTopCookie localChannelTopCookie2 = (ChannelTopCookie)this.j.get(paramInteger);
    ChannelTopCookie localChannelTopCookie1;
    if (localChannelTopCookie2 == null)
    {
      localChannelTopCookie2 = new ChannelTopCookie();
      localChannelTopCookie2.mChannelID = paramInteger.intValue();
      localChannelTopCookie1 = localChannelTopCookie2;
      if (paramInteger.intValue() == 70)
      {
        localChannelTopCookie1 = localChannelTopCookie2;
        if (paramArrayOfByte != null)
        {
          localChannelTopCookie2.mSetTopCookie = paramArrayOfByte;
          localChannelTopCookie1 = localChannelTopCookie2;
        }
      }
    }
    else
    {
      localChannelTopCookie1 = localChannelTopCookie2;
      if (paramInteger.intValue() == 70)
      {
        localChannelTopCookie1 = localChannelTopCookie2;
        if (paramArrayOfByte != null)
        {
          localChannelTopCookie2.mSetTopCookie = paramArrayOfByte;
          localChannelTopCookie1 = localChannelTopCookie2;
        }
      }
    }
    a(localChannelTopCookie1);
    try
    {
      this.a.execute(new RIJArticleInfoRepo.1(this, localChannelTopCookie1));
      return;
    }
    catch (Exception paramInteger)
    {
      paramInteger.printStackTrace();
    }
  }
  
  /* Error */
  public void a(List<AbsBaseArticleInfo> paramList, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 66	com/tencent/mobileqq/kandian/repo/feeds/RIJArticleInfoRepo:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   4: invokevirtual 757	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   7: invokevirtual 762	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   10: aload_1
    //   11: invokeinterface 355 1 0
    //   16: astore_1
    //   17: aload_1
    //   18: invokeinterface 260 1 0
    //   23: ifeq +116 -> 139
    //   26: aload_1
    //   27: invokeinterface 264 1 0
    //   32: checkcast 266	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo
    //   35: astore_3
    //   36: aload_3
    //   37: getfield 766	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mExtraBiuBriefInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/ExtraBiuBriefInfo;
    //   40: ifnull -23 -> 17
    //   43: aload_3
    //   44: getfield 766	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mExtraBiuBriefInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/ExtraBiuBriefInfo;
    //   47: getfield 771	com/tencent/mobileqq/kandian/repo/feeds/entity/ExtraBiuBriefInfo:a	Ljava/util/ArrayList;
    //   50: ifnull -33 -> 17
    //   53: aload_3
    //   54: getfield 766	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mExtraBiuBriefInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/ExtraBiuBriefInfo;
    //   57: getfield 771	com/tencent/mobileqq/kandian/repo/feeds/entity/ExtraBiuBriefInfo:a	Ljava/util/ArrayList;
    //   60: invokevirtual 666	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   63: astore_3
    //   64: aload_3
    //   65: invokeinterface 260 1 0
    //   70: ifeq -53 -> 17
    //   73: aload_3
    //   74: invokeinterface 264 1 0
    //   79: checkcast 773	com/tencent/mobileqq/kandian/repo/feeds/entity/ExtraBiuBriefInfo$BiuBriefInfoItem
    //   82: astore 4
    //   84: aload_0
    //   85: getfield 66	com/tencent/mobileqq/kandian/repo/feeds/RIJArticleInfoRepo:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   88: ldc_w 446
    //   91: ldc_w 775
    //   94: iconst_2
    //   95: anewarray 129	java/lang/String
    //   98: dup
    //   99: iconst_0
    //   100: iload_2
    //   101: invokestatic 451	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   104: aastore
    //   105: dup
    //   106: iconst_1
    //   107: aload 4
    //   109: getfield 776	com/tencent/mobileqq/kandian/repo/feeds/entity/ExtraBiuBriefInfo$BiuBriefInfoItem:a	J
    //   112: invokestatic 132	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   115: aastore
    //   116: invokevirtual 780	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   119: astore 4
    //   121: aload 4
    //   123: ifnull -59 -> 64
    //   126: aload_0
    //   127: getfield 66	com/tencent/mobileqq/kandian/repo/feeds/RIJArticleInfoRepo:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   130: aload 4
    //   132: invokevirtual 783	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   135: pop
    //   136: goto -72 -> 64
    //   139: aload_0
    //   140: getfield 66	com/tencent/mobileqq/kandian/repo/feeds/RIJArticleInfoRepo:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   143: invokevirtual 757	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   146: invokevirtual 786	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   149: aload_0
    //   150: getfield 66	com/tencent/mobileqq/kandian/repo/feeds/RIJArticleInfoRepo:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   153: invokevirtual 757	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   156: invokevirtual 789	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   159: return
    //   160: astore_1
    //   161: goto +46 -> 207
    //   164: astore_1
    //   165: aload_1
    //   166: invokevirtual 752	java/lang/Exception:printStackTrace	()V
    //   169: new 195	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   176: astore_3
    //   177: aload_3
    //   178: ldc_w 791
    //   181: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload_3
    //   186: aload_1
    //   187: invokevirtual 794	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   190: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: ldc 207
    //   196: iconst_2
    //   197: aload_3
    //   198: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 797	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: goto -55 -> 149
    //   207: aload_0
    //   208: getfield 66	com/tencent/mobileqq/kandian/repo/feeds/RIJArticleInfoRepo:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   211: invokevirtual 757	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   214: invokevirtual 789	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   217: goto +5 -> 222
    //   220: aload_1
    //   221: athrow
    //   222: goto -2 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	RIJArticleInfoRepo
    //   0	225	1	paramList	List<AbsBaseArticleInfo>
    //   0	225	2	paramInt	int
    //   35	163	3	localObject1	Object
    //   82	49	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	17	160	finally
    //   17	64	160	finally
    //   64	121	160	finally
    //   126	136	160	finally
    //   139	149	160	finally
    //   165	204	160	finally
    //   0	17	164	java/lang/Exception
    //   17	64	164	java/lang/Exception
    //   64	121	164	java/lang/Exception
    //   126	136	164	java/lang/Exception
    //   139	149	164	java/lang/Exception
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List<AbsBaseArticleInfo> paramList1, long paramLong1, long paramLong2, List<AbsBaseArticleInfo> paramList2, ToServiceMsg paramToServiceMsg)
  {
    b(paramBoolean1, paramInt, paramBoolean2, paramList1, paramLong1, paramLong2, paramList2, paramToServiceMsg);
    paramList2 = b(Integer.valueOf(paramInt));
    if ((paramInt == 70) && (this.f != null) && ((paramBoolean2) || ((paramList1 == null) && (paramBoolean1))) && (paramList2 != null)) {
      ((KandianMergeManager)this.f.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b(paramList2.size());
    }
    Object localObject = paramToServiceMsg.getAttribute("isRedRefreshReq");
    int i1 = 0;
    boolean bool;
    if ((localObject != null) && ((localObject instanceof Boolean))) {
      bool = ((Boolean)localObject).booleanValue();
    } else {
      bool = false;
    }
    if (paramInt == 0)
    {
      ReadinjoyReportUtils.a(paramList1, paramList2, bool);
      ReadinjoyReportUtils.a(paramList1);
    }
    else if (DailyModeConfigHandler.c(paramInt))
    {
      KandianDailyReportUtils.a(paramList1, paramList2, bool);
    }
    localObject = (List)paramToServiceMsg.getAttributes().get("SubscriptionArticles");
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      ReadInJoyLogicEngineEventDispatcher.a().a(paramBoolean1, (List)localObject, paramList1);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(paramBoolean1, paramInt, paramList2, paramBoolean2);
    PTSEventDispatcher.a().a(paramInt, paramList2, paramBoolean1, paramBoolean2, paramToServiceMsg);
    if (paramBoolean1)
    {
      if (paramList1 != null) {
        i1 = paramList1.size();
      }
      FeedsPreloadDataReport.a(paramToServiceMsg, i1);
    }
    a(paramInt, paramList2, paramBoolean1);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setRecommendTopicFollowTypeIntoDB topicID = ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("，followType=");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.d("RIJArticleInfoRepo", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (ArrayList)h(paramInt1);
    if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      ReadInJoyMSFHandlerUtils.d((List)localObject1);
      localArrayList.addAll((Collection)localObject1);
      paramInt1 = 0;
      while (paramInt1 < localArrayList.size())
      {
        int i1 = (int)((AbsBaseArticleInfo)localArrayList.get(paramInt1)).mChannelID;
        Object localObject2 = (ConcurrentMap)this.m.get(Integer.valueOf(i1));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ConcurrentHashMap();
          this.m.put(Integer.valueOf(i1), localObject1);
        }
        if ((((AbsBaseArticleInfo)localArrayList.get(paramInt1)).mTopicRecommendFeedsInfo != null) && (((AbsBaseArticleInfo)localArrayList.get(paramInt1)).mTopicRecommendFeedsInfo.g.size() > 0)) {
          ((TopicRecommendFeedsInfo.TopicRecommendInfo)((AbsBaseArticleInfo)localArrayList.get(paramInt1)).mTopicRecommendFeedsInfo.g.get(0)).g = paramInt2;
        }
        localObject2 = ((AbsBaseArticleInfo)localArrayList.get(paramInt1)).clone();
        if (((ConcurrentMap)localObject1).get(Long.valueOf(((AbsBaseArticleInfo)localObject2).mRecommendSeq)) != null) {
          a(Integer.valueOf(i1), (AbsBaseArticleInfo)localObject2);
        }
        localObject1 = (AbsBaseArticleInfo)((ConcurrentMap)localObject1).get(Long.valueOf(((AbsBaseArticleInfo)localObject2).mRecommendSeq));
        if (localObject1 != null)
        {
          if ((((AbsBaseArticleInfo)localObject1).mTopicRecommendFeedsInfo != null) && (((AbsBaseArticleInfo)localObject1).mTopicRecommendFeedsInfo.g != null) && (((AbsBaseArticleInfo)localObject1).mTopicRecommendFeedsInfo.g.size() > 0)) {
            ((TopicRecommendFeedsInfo.TopicRecommendInfo)((AbsBaseArticleInfo)localObject1).mTopicRecommendFeedsInfo.g.get(0)).g = paramInt2;
          }
          ((AbsBaseArticleInfo)localObject1).invalidateProteusTemplateBean();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("update memory articleInfo articleID = ");
            localStringBuilder.append(((AbsBaseArticleInfo)localObject1).mArticleID);
            localStringBuilder.append(", mRecommendSeq =");
            localStringBuilder.append(((AbsBaseArticleInfo)localObject1).mRecommendSeq);
            localStringBuilder.append("，followType=");
            localStringBuilder.append(paramInt2);
            QLog.d("RIJArticleInfoRepo", 2, localStringBuilder.toString());
          }
        }
        this.a.execute(new RIJArticleInfoRepo.17(this, (AbsBaseArticleInfo)localObject2));
        paramInt1 += 1;
      }
      this.c.post(new RIJArticleInfoRepo.18(this));
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e("RIJArticleInfoRepo", 2, "no recommend topic feeds in db");
    }
    return false;
  }
  
  public boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo != null)
    {
      Object localObject = this.m;
      bool1 = bool2;
      if (localObject != null)
      {
        localObject = (ConcurrentMap)((LinkedHashMap)localObject).get(Integer.valueOf(0));
        bool1 = bool2;
        if (localObject != null)
        {
          bool2 = ((ConcurrentMap)localObject).containsKey(Long.valueOf(paramAbsBaseArticleInfo.mRecommendSeq));
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
            } while ((localAbsBaseArticleInfo == null) || ((localAbsBaseArticleInfo.mArticleID != paramAbsBaseArticleInfo.mArticleID) && ((TextUtils.isEmpty(localAbsBaseArticleInfo.innerUniqueID)) || (!localAbsBaseArticleInfo.innerUniqueID.equalsIgnoreCase(paramAbsBaseArticleInfo.innerUniqueID)))));
            bool1 = true;
          }
        }
      }
    }
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append("isArticleFromRecommendFeeds : ");
    paramAbsBaseArticleInfo.append(bool1);
    QLog.d("RIJArticleInfoRepo", 2, paramAbsBaseArticleInfo.toString());
    return bool1;
  }
  
  public boolean a(Integer paramInteger, AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    if (!WhiteListBidConfigHandler.a(paramAbsBaseArticleInfo)) {
      return false;
    }
    Object localObject2 = (ConcurrentMap)this.m.get(paramInteger);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ConcurrentHashMap();
      this.m.put(paramInteger, localObject1);
    }
    if (((ConcurrentMap)localObject1).get(Long.valueOf(paramAbsBaseArticleInfo.mRecommendSeq)) != null)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mAbandonRepeatFlag == 0) {
        bool1 = true;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("saveArticleInfo, article duplicated, article been channelID=");
      ((StringBuilder)localObject2).append(paramInteger);
      ((StringBuilder)localObject2).append(", articleID=");
      ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mArticleID);
      ((StringBuilder)localObject2).append("，seq=");
      ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mRecommendSeq);
      ((StringBuilder)localObject2).append(", toDb=");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append("，isDupArticle =");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append("，title = ");
      ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mTitle);
      QLog.e("RIJArticleInfoRepo", 1, ((StringBuilder)localObject2).toString());
    }
    if ((paramInteger.intValue() != 70) && (paramInteger.intValue() != 0) && (paramInteger.intValue() != 9999) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mVideoVid)))
    {
      Object localObject3 = (ConcurrentHashMap)this.o.get(paramInteger);
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = new ConcurrentHashMap();
        this.o.put(paramInteger, localObject2);
      }
      if (((ConcurrentHashMap)localObject2).get(paramAbsBaseArticleInfo.mVideoVid) != null)
      {
        localObject3 = (AbsBaseArticleInfo)((ConcurrentHashMap)localObject2).get(paramAbsBaseArticleInfo.mVideoVid);
        if (((AbsBaseArticleInfo)localObject3).mArticleID != paramAbsBaseArticleInfo.mArticleID)
        {
          a(paramInteger.intValue(), ((AbsBaseArticleInfo)localObject3).mRecommendSeq);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("saveArticleInfo, find article vid duplicated! old article: channelID=");
            localStringBuilder.append(paramInteger);
            localStringBuilder.append(", id=");
            localStringBuilder.append(((AbsBaseArticleInfo)localObject3).mArticleID);
            localStringBuilder.append("，seq: ");
            localStringBuilder.append(((AbsBaseArticleInfo)localObject3).mRecommendSeq);
            localStringBuilder.append(", title: ");
            localStringBuilder.append(ReadInJoyStringUtils.b(((AbsBaseArticleInfo)localObject3).mTitle));
            localStringBuilder.append("，vid =");
            localStringBuilder.append(((AbsBaseArticleInfo)localObject3).mVideoVid);
            localStringBuilder.append("\n new article  id : ");
            localStringBuilder.append(paramAbsBaseArticleInfo.mArticleID);
            localStringBuilder.append(" seq : ");
            localStringBuilder.append(paramAbsBaseArticleInfo.mRecommendSeq);
            localStringBuilder.append(" title : ");
            localStringBuilder.append(ReadInJoyStringUtils.b(paramAbsBaseArticleInfo.mTitle));
            localStringBuilder.append("，vid =");
            localStringBuilder.append(paramAbsBaseArticleInfo.mVideoVid);
            QLog.e("RIJArticleInfoRepo", 2, localStringBuilder.toString());
          }
        }
      }
      ((ConcurrentHashMap)localObject2).put(paramAbsBaseArticleInfo.mVideoVid, paramAbsBaseArticleInfo);
    }
    if (!bool1)
    {
      ((ConcurrentMap)localObject1).put(Long.valueOf(paramAbsBaseArticleInfo.mRecommendSeq), paramAbsBaseArticleInfo);
      if (paramBoolean)
      {
        paramInteger = this.a;
        if ((paramInteger != null) && (!paramInteger.isShutdown()) && (!this.a.isTerminated()))
        {
          this.a.execute(new RIJArticleInfoRepo.6(this, paramAbsBaseArticleInfo));
          return true;
        }
        ThreadManager.executeOnSubThread(new RIJArticleInfoRepo.7(this, paramAbsBaseArticleInfo));
      }
    }
    return true;
  }
  
  public boolean a(Integer paramInteger, List<AbsBaseArticleInfo> paramList, boolean paramBoolean)
  {
    b(paramList);
    if ((paramInteger.intValue() != -1) && (paramList != null) && (paramList.size() != 0))
    {
      this.e.a(paramInteger, paramList, paramBoolean);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a(paramInteger, (AbsBaseArticleInfo)paramList.next(), paramBoolean);
      }
      if ((paramInteger.intValue() == 0) && (this.h))
      {
        this.h = false;
        if (((ConcurrentMap)this.m.get(paramInteger)).size() > 30) {
          i(paramInteger);
        }
      }
      return true;
    }
    this.n.remove(paramInteger);
    return false;
  }
  
  public byte[] a(Integer paramInteger)
  {
    paramInteger = (ChannelTopCookie)this.j.get(paramInteger);
    if (paramInteger == null) {
      return null;
    }
    return paramInteger.mSetTopCookie;
  }
  
  public List<AbsBaseArticleInfo> b(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      localObject1 = "mChannelID = ? and mRecommendSeq < ?";
    } else {
      localObject1 = "mChannelID = ? and mRecommendSeq > ?";
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loadChannelArticleSeqList with selection=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("channelId=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("recommendSeq=");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("count=");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.e("RIJArticleInfoRepo", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new ArrayList();
    Object localObject1 = this.b.query(BaseArticleInfo.class, true, (String)localObject1, new String[] { String.valueOf(paramInt1), String.valueOf(paramLong) }, null, null, "mRecommendSeq desc", String.valueOf(paramInt2));
    if (localObject1 != null)
    {
      ReadInJoyMSFHandlerUtils.d((List)localObject1);
      ((List)localObject2).addAll((Collection)localObject1);
    }
    if ((((List)localObject2).isEmpty()) && (QLog.isColorLevel())) {
      QLog.e("RIJArticleInfoRepo", 2, "loadChannelArticleSeqList mEntityManager.query return empty");
    }
    b(paramInt1);
    return localObject2;
  }
  
  public List<Long> b(Integer paramInteger)
  {
    Object localObject = c(paramInteger);
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      ArrayList localArrayList = new ArrayList(((List)localObject).size());
      HashSet localHashSet1 = new HashSet();
      HashSet localHashSet2 = new HashSet();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)((Iterator)localObject).next();
        if ((paramInteger.intValue() != 70) && (paramInteger.intValue() != 41403) && (!localHashSet1.add(Long.valueOf(localAbsBaseArticleInfo.mArticleID))))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getChannelArticleSeqList 有重复文章， channelID = ");
          localStringBuilder.append(paramInteger);
          localStringBuilder.append(", seq = ");
          localStringBuilder.append(localAbsBaseArticleInfo.mRecommendSeq);
          localStringBuilder.append("，articleID = ");
          localStringBuilder.append(localAbsBaseArticleInfo.mArticleID);
          QLog.d("RIJArticleInfoRepo", 2, localStringBuilder.toString());
          a(paramInteger, localAbsBaseArticleInfo);
        }
        else if ((paramInteger.intValue() == 41403) && (!localHashSet2.add(Long.valueOf(localAbsBaseArticleInfo.mFeedId))))
        {
          QLog.d("RIJArticleInfoRepo", 1, new Object[] { "getChannelArticleSeqList 有重复feeds, channelID = ", paramInteger, ", seq = ", Long.valueOf(localAbsBaseArticleInfo.mRecommendSeq), ", feedsId = ", Long.valueOf(localAbsBaseArticleInfo.mFeedId) });
          a(paramInteger, localAbsBaseArticleInfo);
        }
        else
        {
          localArrayList.add(Long.valueOf(localAbsBaseArticleInfo.mRecommendSeq));
        }
      }
      this.e.a(paramInteger, localArrayList);
      return localArrayList;
    }
    return null;
  }
  
  public void b()
  {
    this.a.execute(new RIJArticleInfoRepo.2(this));
  }
  
  public void b(int paramInt)
  {
    if (!RIJKanDianFeedsExposureSwitchAladdinConfig.a()) {
      return;
    }
    if ((paramInt != 0) && (!DailyModeConfigHandler.c(paramInt))) {
      return;
    }
    if ((ConcurrentMap)this.l.get(Integer.valueOf(paramInt)) != null)
    {
      QLog.d("RIJArticleInfoRepo", 1, "loadArticleExposureInfoFromDB has loaded!");
      return;
    }
    this.a.execute(new RIJArticleInfoRepo.5(this, paramInt));
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject1 = (ArrayList)i(paramInt1);
    if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      ReadInJoyMSFHandlerUtils.d((List)localObject1);
      localArrayList.addAll((Collection)localObject1);
      int i1 = 0;
      while (i1 < localArrayList.size())
      {
        int i2 = (int)((AbsBaseArticleInfo)localArrayList.get(i1)).mChannelID;
        Object localObject2 = (ConcurrentMap)this.m.get(Integer.valueOf(i2));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ConcurrentHashMap();
          this.m.put(Integer.valueOf(i2), localObject1);
        }
        if ((((AbsBaseArticleInfo)localArrayList.get(i1)).mTopicRecommendFeedsInfo != null) && (((AbsBaseArticleInfo)localArrayList.get(i1)).mTopicRecommendFeedsInfo.g.size() > 0)) {
          ((TopicRecommendFeedsInfo.TopicRecommendInfo)((AbsBaseArticleInfo)localArrayList.get(i1)).mTopicRecommendFeedsInfo.g.get(0)).g = paramInt2;
        }
        Object localObject3;
        if (((AbsBaseArticleInfo)localArrayList.get(i1)).mPolymericInfo != null)
        {
          int i3 = paramInt2 + 1;
          ((AbsBaseArticleInfo)localArrayList.get(i1)).mPolymericInfo.p = i3;
          localObject2 = new articlesummary.PackInfo();
          try
          {
            ((articlesummary.PackInfo)localObject2).mergeFrom(((AbsBaseArticleInfo)localArrayList.get(i1)).mPackInfoBytes);
            ((articlesummary.PackInfo)localObject2).uint32_follow_status.set(i3, true);
            ((AbsBaseArticleInfo)localArrayList.get(i1)).mPackInfoBytes = ((articlesummary.PackInfo)localObject2).toByteArray();
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("first setSmallVideoTopicFollowTypeIntoDB article.mPackInfoBytes convert error article.topicID:");
            ((StringBuilder)localObject3).append(paramInt1);
            ((StringBuilder)localObject3).append(" e = ");
            ((StringBuilder)localObject3).append(localInvalidProtocolBufferMicroException1);
            QLog.e("RIJArticleInfoRepo", 1, ((StringBuilder)localObject3).toString());
            localInvalidProtocolBufferMicroException1.printStackTrace();
          }
        }
        AbsBaseArticleInfo localAbsBaseArticleInfo = ((AbsBaseArticleInfo)localArrayList.get(i1)).clone();
        if (((ConcurrentMap)localObject1).get(Long.valueOf(localAbsBaseArticleInfo.mRecommendSeq)) != null)
        {
          a(Integer.valueOf(i2), localAbsBaseArticleInfo);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("recordArticleInfo, article duplicated, article been channelID=");
            ((StringBuilder)localObject3).append(i2);
            ((StringBuilder)localObject3).append(", articleID=");
            ((StringBuilder)localObject3).append(localAbsBaseArticleInfo.mArticleID);
            ((StringBuilder)localObject3).append("，seq=");
            ((StringBuilder)localObject3).append(localAbsBaseArticleInfo.mRecommendSeq);
            QLog.e("RIJArticleInfoRepo", 2, ((StringBuilder)localObject3).toString());
          }
        }
        localObject1 = (AbsBaseArticleInfo)((ConcurrentMap)localObject1).get(Long.valueOf(localAbsBaseArticleInfo.mRecommendSeq));
        if (localObject1 != null)
        {
          if ((((AbsBaseArticleInfo)localObject1).mTopicRecommendFeedsInfo != null) && (((AbsBaseArticleInfo)localObject1).mTopicRecommendFeedsInfo.g != null) && (((AbsBaseArticleInfo)localObject1).mTopicRecommendFeedsInfo.g.size() > 0)) {
            ((TopicRecommendFeedsInfo.TopicRecommendInfo)((AbsBaseArticleInfo)localObject1).mTopicRecommendFeedsInfo.g.get(0)).g = paramInt2;
          }
          if (((AbsBaseArticleInfo)localObject1).mPolymericInfo != null)
          {
            i2 = paramInt2 + 1;
            ((AbsBaseArticleInfo)localObject1).mPolymericInfo.p = i2;
            localObject3 = new articlesummary.PackInfo();
            try
            {
              ((articlesummary.PackInfo)localObject3).mergeFrom(((AbsBaseArticleInfo)localObject1).mPackInfoBytes);
              ((articlesummary.PackInfo)localObject3).uint32_follow_status.set(i2, true);
              ((AbsBaseArticleInfo)localObject1).mPackInfoBytes = ((articlesummary.PackInfo)localObject3).toByteArray();
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("first setSmallVideoTopicFollowTypeIntoDB article.mPackInfoBytes convert error article.topicID:");
              localStringBuilder.append(paramInt1);
              localStringBuilder.append(" e = ");
              localStringBuilder.append(localInvalidProtocolBufferMicroException2);
              QLog.e("RIJArticleInfoRepo", 1, localStringBuilder.toString());
              localInvalidProtocolBufferMicroException2.printStackTrace();
            }
          }
          ((AbsBaseArticleInfo)localObject1).invalidateProteusTemplateBean();
        }
        this.a.execute(new RIJArticleInfoRepo.19(this, localAbsBaseArticleInfo));
        i1 += 1;
      }
      this.c.post(new RIJArticleInfoRepo.20(this, paramInt1, paramInt2));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RIJArticleInfoRepo", 2, "no recommend topic feeds");
    }
  }
  
  public void b(int paramInt, List<AbsBaseArticleInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      Object localObject2;
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("deleteChannelArticleList channelID = ");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(" articleList");
        QLog.d("RIJArticleInfoRepo", 2, ((StringBuilder)localObject1).toString());
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (AbsBaseArticleInfo)((Iterator)localObject1).next();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("articleInfo.mArticleID = ");
          ((StringBuilder)localObject3).append(((AbsBaseArticleInfo)localObject2).mArticleID);
          QLog.d("RIJArticleInfoRepo", 2, ((StringBuilder)localObject3).toString());
        }
      }
      ConcurrentMap localConcurrentMap = (ConcurrentMap)this.m.get(Integer.valueOf(paramInt));
      if (localConcurrentMap == null) {
        return;
      }
      Object localObject1 = new StringBuilder();
      Iterator localIterator1 = paramList.iterator();
      paramList = (List<AbsBaseArticleInfo>)localObject1;
      if (localIterator1.hasNext())
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)localIterator1.next();
        Iterator localIterator2 = localConcurrentMap.entrySet().iterator();
        for (localObject1 = null; localIterator2.hasNext(); localObject1 = localObject2)
        {
          Map.Entry localEntry = (Map.Entry)localIterator2.next();
          if (((AbsBaseArticleInfo)localEntry.getValue()).mNewPolymericInfo != null)
          {
            localObject2 = ((AbsBaseArticleInfo)localEntry.getValue()).mNewPolymericInfo.p.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (NewPolymericInfo.PackArticleInfo)((Iterator)localObject2).next();
              long l1 = ((NewPolymericInfo.PackArticleInfo)localObject3).a;
              if (l1 == localAbsBaseArticleInfo.mArticleID)
              {
                localObject2 = (AbsBaseArticleInfo)localEntry.getValue();
                ((AbsBaseArticleInfo)localObject2).mNewPolymericInfo.p.remove(localObject3);
                localObject1 = paramList;
                break label413;
              }
            }
            localObject2 = localObject1;
            localObject1 = paramList;
          }
          else
          {
            localObject3 = paramList;
            localObject2 = localObject1;
            localObject1 = localObject3;
            if (((AbsBaseArticleInfo)localEntry.getValue()).mArticleID == localAbsBaseArticleInfo.mArticleID)
            {
              localObject1 = (AbsBaseArticleInfo)localEntry.getValue();
              break;
            }
          }
          label413:
          paramList = (List<AbsBaseArticleInfo>)localObject1;
        }
        if (localObject1 == null) {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("deleteChannelArticleList connot find channelId=");
            ((StringBuilder)localObject1).append(paramInt);
            ((StringBuilder)localObject1).append(" ArticleInfo with recommendSeq=");
            ((StringBuilder)localObject1).append(localAbsBaseArticleInfo.mRecommendSeq);
            ((StringBuilder)localObject1).append(" with articleID=");
            ((StringBuilder)localObject1).append(localAbsBaseArticleInfo.mArticleID);
            ((StringBuilder)localObject1).append('\n');
            paramList.append(((StringBuilder)localObject1).toString());
          }
        }
        for (;;)
        {
          break;
          if ((((AbsBaseArticleInfo)localObject1).mNewPolymericInfo != null) && (((RIJFeedsType.J((AbsBaseArticleInfo)localObject1)) && (((AbsBaseArticleInfo)localObject1).mNewPolymericInfo.p.size() >= 3)) || ((!RIJFeedsType.J((AbsBaseArticleInfo)localObject1)) && (((AbsBaseArticleInfo)localObject1).mNewPolymericInfo.p.size() >= 2))))
          {
            ((AbsBaseArticleInfo)localObject1).mNewPackInfoBytes = ((AbsBaseArticleInfo)localObject1).mNewPolymericInfo.a();
            b(Integer.valueOf(paramInt), (AbsBaseArticleInfo)localObject1);
            localConcurrentMap.put(Long.valueOf(((AbsBaseArticleInfo)localObject1).mRecommendSeq), localObject1);
            this.a.execute(new RIJArticleInfoRepo.15(this, (AbsBaseArticleInfo)localObject1));
          }
          else
          {
            a(Integer.valueOf(paramInt), (AbsBaseArticleInfo)localObject1);
            localConcurrentMap.remove(Long.valueOf(((AbsBaseArticleInfo)localObject1).mRecommendSeq));
            this.a.execute(new RIJArticleInfoRepo.16(this, (AbsBaseArticleInfo)localObject1));
          }
        }
      }
      if (paramList.length() > 0) {
        QLog.e("RIJArticleInfoRepo", 2, paramList.toString());
      }
    }
  }
  
  public void b(int paramInt, ConcurrentMap<Long, AbsBaseArticleInfo> paramConcurrentMap)
  {
    this.m.put(Integer.valueOf(paramInt), paramConcurrentMap);
  }
  
  public void b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (!paramAbsBaseArticleInfo.showBreathAnimation) {
        return;
      }
      Object localObject = (ConcurrentMap)this.m.get(Integer.valueOf(0));
      if (localObject != null)
      {
        int i1;
        if (((ConcurrentMap)localObject).containsKey(Long.valueOf(paramAbsBaseArticleInfo.mRecommendSeq)))
        {
          ((AbsBaseArticleInfo)((ConcurrentMap)localObject).get(Long.valueOf(paramAbsBaseArticleInfo.mRecommendSeq))).showBreathAnimation = false;
          a(Integer.valueOf(0), paramAbsBaseArticleInfo, true);
          QLog.d("RIJArticleInfoRepo", 2, "resetBiuBreathAnimationFlag | reset breathAnim for fastweb type");
          i1 = 1;
        }
        else
        {
          i1 = 0;
        }
        if (i1 == 0)
        {
          localObject = ((ConcurrentMap)localObject).values().iterator();
          while (((Iterator)localObject).hasNext())
          {
            AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)((Iterator)localObject).next();
            if ((localAbsBaseArticleInfo != null) && ((localAbsBaseArticleInfo.mArticleID == paramAbsBaseArticleInfo.mArticleID) || ((!TextUtils.isEmpty(localAbsBaseArticleInfo.innerUniqueID)) && (localAbsBaseArticleInfo.innerUniqueID.equalsIgnoreCase(paramAbsBaseArticleInfo.innerUniqueID)))))
            {
              localAbsBaseArticleInfo.showBreathAnimation = false;
              a(Integer.valueOf(0), paramAbsBaseArticleInfo, true);
              QLog.d("RIJArticleInfoRepo", 2, "resetBiuBreathAnimationFlag |  reset breathAnim for video or shortContent type");
            }
          }
        }
      }
    }
  }
  
  public List<AbsBaseArticleInfo> c(Integer paramInteger)
  {
    paramInteger = (ConcurrentMap)this.m.get(paramInteger);
    if ((paramInteger != null) && (paramInteger.size() != 0))
    {
      ArrayList localArrayList = new ArrayList(paramInteger.size());
      Iterator localIterator = paramInteger.keySet().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((AbsBaseArticleInfo)paramInteger.get((Long)localIterator.next()));
      }
      Collections.sort(localArrayList, new RIJArticleInfoRepo.13(this));
      return localArrayList;
    }
    return null;
  }
  
  public ConcurrentMap<String, ArticleExposureInfo> c(int paramInt)
  {
    return (ConcurrentMap)this.l.get(Integer.valueOf(paramInt));
  }
  
  public void c(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    Object localObject = this.a;
    if ((localObject != null) && (!((ExecutorService)localObject).isShutdown()))
    {
      localObject = b(Integer.valueOf(paramInt1));
      if (localObject != null)
      {
        if (((List)localObject).isEmpty()) {
          return;
        }
        try
        {
          this.a.execute(new RIJArticleInfoRepo.21(this, paramInt1, paramInt2, paramLong, paramBoolean));
          return;
        }
        catch (RejectedExecutionException localRejectedExecutionException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[preloadFeedsFromDB], e = ");
          localStringBuilder.append(localRejectedExecutionException);
          QLog.e("RIJArticleInfoRepo", 1, localStringBuilder.toString());
        }
      }
      return;
    }
    QLog.i("RIJArticleInfoRepo", 1, "[loadFeedsFromDB], mExecutorService is null or shutDown.");
  }
  
  public void c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null) {
      this.a.execute(new RIJArticleInfoRepo.26(this, paramAbsBaseArticleInfo));
    }
  }
  
  public long d(Integer paramInteger)
  {
    paramInteger = (ConcurrentMap)this.m.get(paramInteger);
    long l1 = -1L;
    if (paramInteger == null) {
      return -1L;
    }
    paramInteger = paramInteger.keySet().iterator();
    while (paramInteger.hasNext())
    {
      Long localLong = (Long)paramInteger.next();
      if (localLong.longValue() > l1) {
        l1 = localLong.longValue();
      }
    }
    return l1;
  }
  
  public ConcurrentMap<Long, AbsBaseArticleInfo> d(int paramInt)
  {
    return (ConcurrentMap)this.m.get(Integer.valueOf(paramInt));
  }
  
  public long e(Integer paramInteger)
  {
    paramInteger = (ConcurrentMap)this.m.get(paramInteger);
    if (paramInteger == null) {
      return -1L;
    }
    paramInteger = paramInteger.keySet().iterator();
    long l1 = 9223372036854775807L;
    while (paramInteger.hasNext())
    {
      Long localLong = (Long)paramInteger.next();
      if (localLong.longValue() < l1) {
        l1 = localLong.longValue();
      }
    }
    return l1;
  }
  
  public void e(int paramInt)
  {
    this.m.remove(Integer.valueOf(paramInt));
    this.a.execute(new RIJArticleInfoRepo.9(this, paramInt));
  }
  
  public AbsBaseArticleInfo f(Integer paramInteger)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[getRefreshedArticleInfo] channelID = ");
      ((StringBuilder)localObject).append(paramInteger);
      ((StringBuilder)localObject).append(", isReservedCacheFlag = ");
      ((StringBuilder)localObject).append(this.i);
      QLog.i("RIJArticleInfoRepo", 1, ((StringBuilder)localObject).toString());
    }
    if ((RIJDeleteArticleAfterRefreshAladdinConfig.a(paramInteger.intValue())) && (!this.i)) {
      return null;
    }
    Object localObject = (List)this.n.get(paramInteger);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      if (paramInteger.intValue() == 70)
      {
        int i1 = 0;
        while (i1 < ((List)localObject).size())
        {
          paramInteger = (AbsBaseArticleInfo)((List)localObject).get(i1);
          if (paramInteger.hintFlag) {
            return paramInteger;
          }
          i1 += 1;
        }
      }
      return (AbsBaseArticleInfo)((List)localObject).get(((List)localObject).size() - 1);
    }
    return null;
  }
  
  public void f(int paramInt)
  {
    int i1 = RIJFeedsRefreshUtil.a.a(paramInt);
    if (i1 <= 0) {
      return;
    }
    Object localObject1 = (ConcurrentMap)this.m.get(Integer.valueOf(paramInt));
    Object localObject2 = RIJFeedsRefreshUtil.a.a((ConcurrentMap)localObject1, i1);
    if (((List)localObject2).isEmpty()) {
      return;
    }
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)((ConcurrentMap)localObject1).remove((Long)((Iterator)localObject2).next());
      if (localAbsBaseArticleInfo != null) {
        a(Integer.valueOf(paramInt), localAbsBaseArticleInfo);
      }
    }
    localObject1 = RIJFeedsRefreshUtil.a.b((ConcurrentMap)localObject1, i1);
    localObject1 = RIJFeedsRefreshUtil.a.a((List)localObject1, paramInt);
    this.a.execute(new RIJArticleInfoRepo.10(this, (String)localObject1));
    this.i = true;
  }
  
  public int g(Integer paramInteger)
  {
    paramInteger = (List)this.n.get(paramInteger);
    if (paramInteger == null) {
      return 0;
    }
    return paramInteger.size();
  }
  
  public void g(int paramInt)
  {
    if (paramInt != 0)
    {
      this.m.remove(Integer.valueOf(paramInt));
      this.n.remove(Integer.valueOf(paramInt));
    }
  }
  
  public List<Long> h(Integer paramInteger)
  {
    Object localObject1 = c(paramInteger);
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (AbsBaseArticleInfo)((Iterator)localObject1).next();
        if ((!localArrayList.contains(Long.valueOf(((AbsBaseArticleInfo)localObject2).mArticleID))) && (((AbsBaseArticleInfo)localObject2).mRecommendSeq != -2L) && (((AbsBaseArticleInfo)localObject2).mRecommendSeq != -3L))
        {
          if (((AbsBaseArticleInfo)localObject2).mNewPolymericInfo != null)
          {
            localObject2 = ((AbsBaseArticleInfo)localObject2).mNewPolymericInfo.p;
            if (localObject2 != null)
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext()) {
                localArrayList.add(Long.valueOf(((NewPolymericInfo.PackArticleInfo)((Iterator)localObject2).next()).a));
              }
            }
          }
          else
          {
            localArrayList.add(Long.valueOf(((AbsBaseArticleInfo)localObject2).mArticleID));
          }
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getChannelArticleSeqList 有重复文章， channelID = ");
          localStringBuilder.append(paramInteger);
          localStringBuilder.append(", seq = ");
          localStringBuilder.append(((AbsBaseArticleInfo)localObject2).mRecommendSeq);
          localStringBuilder.append("articleID = ");
          localStringBuilder.append(((AbsBaseArticleInfo)localObject2).mArticleID);
          localStringBuilder.append(", title =");
          localStringBuilder.append(((AbsBaseArticleInfo)localObject2).mTitle);
          QLog.d("RIJArticleInfoRepo", 2, localStringBuilder.toString());
          a(paramInteger, (AbsBaseArticleInfo)localObject2);
        }
      }
      return localArrayList;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo
 * JD-Core Version:    0.7.0.1
 */