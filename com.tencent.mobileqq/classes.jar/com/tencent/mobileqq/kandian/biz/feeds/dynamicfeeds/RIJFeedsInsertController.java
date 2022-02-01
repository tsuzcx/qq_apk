package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.api.IInsertArticleCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleInsertInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsInsertController;", "", "()V", "TAG", "", "addToListFilterDuplicate", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "articleInfoList", "", "index", "", "insertArticleCallback", "Lcom/tencent/mobileqq/kandian/repo/feeds/api/IInsertArticleCallback;", "filterAd", "insertArticleInfo", "getInsertArticleInfoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "insertAfterArticleInfo", "feedsInsertInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getNewArticleInfoListWithInsertFeeds", "adapter", "Lcom/tencent/mobileqq/kandian/biz/framework/ReadInJoyBaseAdapter;", "hasAdInDistance", "distance", "articleList", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsInsertController
{
  public static final RIJFeedsInsertController a = new RIJFeedsInsertController();
  
  private final ArrayList<AbsBaseArticleInfo> a(AbsBaseArticleInfo paramAbsBaseArticleInfo, ConcurrentHashMap<String, ArrayList<AbsBaseArticleInfo>> paramConcurrentHashMap)
  {
    if (paramAbsBaseArticleInfo != null) {
      localObject1 = paramAbsBaseArticleInfo.innerUniqueID;
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = (ArrayList)paramConcurrentHashMap.get(paramAbsBaseArticleInfo.innerUniqueID);
    if (localObject2 != null) {
      return localObject2;
    }
    Object localObject3 = paramAbsBaseArticleInfo.mSubArticleList;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((List)localObject3).iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (ArrayList)paramConcurrentHashMap.get(((AbsBaseArticleInfo)((Iterator)localObject3).next()).innerUniqueID);
        if (localObject1 != null) {
          localObject2 = localObject1;
        }
      }
    }
    if (localObject1 != null) {
      return localObject1;
    }
    localObject2 = paramAbsBaseArticleInfo.mNewPolymericInfo;
    paramAbsBaseArticleInfo = (AbsBaseArticleInfo)localObject1;
    if (localObject2 != null)
    {
      localObject2 = ((NewPolymericInfo)localObject2).p;
      paramAbsBaseArticleInfo = (AbsBaseArticleInfo)localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          paramAbsBaseArticleInfo = (AbsBaseArticleInfo)localObject1;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          paramAbsBaseArticleInfo = (ArrayList)paramConcurrentHashMap.get(((NewPolymericInfo.PackArticleInfo)((Iterator)localObject2).next()).l);
          if (paramAbsBaseArticleInfo != null) {
            localObject1 = paramAbsBaseArticleInfo;
          }
        }
      }
    }
    return paramAbsBaseArticleInfo;
  }
  
  private final boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo, List<? extends AbsBaseArticleInfo> paramList)
  {
    boolean bool2 = RIJFeedsDynamicInsertController.INSTANCE.isReadAd();
    boolean bool1;
    if (paramAbsBaseArticleInfo.articleInsertInfo.b)
    {
      if (bool2) {
        bool1 = true;
      } else {
        bool1 = a(paramAbsBaseArticleInfo.articleInsertInfo.c, paramList);
      }
      if (paramAbsBaseArticleInfo.articleInsertInfo.d)
      {
        QLog.d("RIJFeedsInsertController", 1, "filterAd, hadBeenFiltered!");
        bool1 = true;
      }
      paramAbsBaseArticleInfo.articleInsertInfo.d = bool1;
    }
    else
    {
      bool1 = false;
    }
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append("filterAd！ flag=");
    paramAbsBaseArticleInfo.append(bool1);
    paramAbsBaseArticleInfo.append(", hasRead=");
    paramAbsBaseArticleInfo.append(bool2);
    QLog.d("RIJFeedsInsertController", 1, paramAbsBaseArticleInfo.toString());
    return bool1;
  }
  
  private final boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo, List<? extends AbsBaseArticleInfo> paramList, int paramInt, IInsertArticleCallback paramIInsertArticleCallback)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)localIterator.next();
      if (RIJFeedsInsertUtil.a.a(paramAbsBaseArticleInfo, localAbsBaseArticleInfo))
      {
        paramList = new StringBuilder();
        paramList.append("[addToListFilterDuplicate] has duplicate, articleInfo = ");
        paramList.append(RIJFeedsInsertUtil.a.a(paramAbsBaseArticleInfo));
        QLog.i("RIJFeedsInsertController", 1, paramList.toString());
        return false;
      }
      if (a(paramAbsBaseArticleInfo, paramList))
      {
        QLog.d("RIJFeedsInsertController", 1, "addToListFilterDuplicate!  filterAd");
        return false;
      }
    }
    if (paramList != null)
    {
      TypeIntrinsics.asMutableList(paramList).add(paramInt, paramAbsBaseArticleInfo);
      if (paramIInsertArticleCallback != null) {
        paramIInsertArticleCallback.a(paramAbsBaseArticleInfo);
      }
      paramList = new StringBuilder();
      paramList.append("[addToListFilterDuplicate], index = ");
      paramList.append(paramInt);
      paramList.append(", articleInfo = ");
      paramList.append(RIJFeedsInsertUtil.a.a(paramAbsBaseArticleInfo));
      QLog.i("RIJFeedsInsertController", 1, paramList.toString());
      return true;
    }
    paramAbsBaseArticleInfo = new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableList<com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo>");
    for (;;)
    {
      throw paramAbsBaseArticleInfo;
    }
  }
  
  @NotNull
  public final List<AbsBaseArticleInfo> a(@NotNull ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @NotNull List<? extends AbsBaseArticleInfo> paramList, @Nullable IInsertArticleCallback paramIInsertArticleCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramReadInJoyBaseAdapter, "adapter");
    Intrinsics.checkParameterIsNotNull(paramList, "articleInfoList");
    long l = System.currentTimeMillis();
    int i = paramReadInJoyBaseAdapter.c();
    if (!RIJFeedsInsertUtil.a.a(i))
    {
      paramReadInJoyBaseAdapter = new StringBuilder();
      paramReadInJoyBaseAdapter.append("[getNewArticleInfoListWithInsertFeeds] channelId = ");
      paramReadInJoyBaseAdapter.append(i);
      paramReadInJoyBaseAdapter.append(", do not insert...");
      QLog.i("RIJFeedsInsertController", 1, paramReadInJoyBaseAdapter.toString());
      return paramList;
    }
    paramReadInJoyBaseAdapter = ReadInJoyUtils.b();
    if (paramReadInJoyBaseAdapter != null)
    {
      paramReadInJoyBaseAdapter = (ReadInJoyLogicManager)((QQAppInterface)paramReadInJoyBaseAdapter).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if (paramReadInJoyBaseAdapter != null)
      {
        paramReadInJoyBaseAdapter = paramReadInJoyBaseAdapter.getReadInJoyLogicEngine();
        if (paramReadInJoyBaseAdapter != null)
        {
          paramReadInJoyBaseAdapter = paramReadInJoyBaseAdapter.q();
          if (paramReadInJoyBaseAdapter != null)
          {
            paramReadInJoyBaseAdapter = paramReadInJoyBaseAdapter.a(i);
            break label132;
          }
        }
      }
      paramReadInJoyBaseAdapter = null;
      label132:
      if (paramReadInJoyBaseAdapter != null)
      {
        i = paramList.size() - 1;
        int j = 0;
        while (j <= i)
        {
          AbsBaseArticleInfo localAbsBaseArticleInfo1 = (AbsBaseArticleInfo)paramList.get(j);
          Object localObject = a.a(localAbsBaseArticleInfo1, paramReadInJoyBaseAdapter);
          int k = i;
          if (localObject != null)
          {
            localObject = ((ArrayList)localObject).iterator();
            for (;;)
            {
              k = i;
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              AbsBaseArticleInfo localAbsBaseArticleInfo2 = (AbsBaseArticleInfo)((Iterator)localObject).next();
              RIJFeedsInsertController localRIJFeedsInsertController = a;
              Intrinsics.checkExpressionValueIsNotNull(localAbsBaseArticleInfo2, "insertArticleInfo");
              k = j + 1;
              if (localRIJFeedsInsertController.a(localAbsBaseArticleInfo2, paramList, k, paramIInsertArticleCallback))
              {
                ReadInJoyLogicEngineEventDispatcher.a().c(localAbsBaseArticleInfo1.innerUniqueID, k);
                i += 1;
              }
            }
          }
          j += 1;
          i = k;
        }
      }
      if (QLog.isColorLevel())
      {
        paramReadInJoyBaseAdapter = new StringBuilder();
        paramReadInJoyBaseAdapter.append("[getNewArticleInfoListWithInsertFeeds], time cost = ");
        paramReadInJoyBaseAdapter.append(System.currentTimeMillis() - l);
        paramReadInJoyBaseAdapter.append(" ms");
        QLog.i("RIJFeedsInsertController", 1, paramReadInJoyBaseAdapter.toString());
      }
      return paramList;
    }
    paramReadInJoyBaseAdapter = new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    for (;;)
    {
      throw paramReadInJoyBaseAdapter;
    }
  }
  
  public final boolean a(int paramInt, @NotNull List<? extends AbsBaseArticleInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "articleList");
    int i = RIJFeedsInsertUtil.a.a(paramList);
    int j = paramInt + i;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i >= 0) {
      if (j >= paramList.size())
      {
        bool1 = bool2;
      }
      else
      {
        bool1 = bool2;
        if (i <= j)
        {
          paramInt = i;
          for (;;)
          {
            if ((paramList.get(paramInt) instanceof AdvertisementInfo))
            {
              bool1 = true;
              break;
            }
            bool1 = bool2;
            if (paramInt == j) {
              break;
            }
            paramInt += 1;
          }
        }
      }
    }
    paramList = new StringBuilder();
    paramList.append("filterAd！ currentPosition=");
    paramList.append(i);
    paramList.append(", endPosition");
    paramList.append(j);
    paramList.append(",flag=");
    paramList.append(bool1);
    QLog.d("RIJFeedsInsertController", 1, paramList.toString());
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsInsertController
 * JD-Core Version:    0.7.0.1
 */