package com.tencent.mobileqq.kandian.repo.feeds;

import android.os.Bundle;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/RIJFeedsRefreshUtil;", "", "()V", "TAG", "", "getArticleRetainedNumber", "", "channelId", "getDeleteArticleSeqList", "", "", "articleInfoMap", "Ljava/util/concurrent/ConcurrentMap;", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "reservedNum", "getDeleteSql", "reservedArticleSeqList", "getReservedArticleSeqList", "getSortedSeqList", "", "isAbleToReserveArticle", "", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "isAutoRefresh", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsRefreshUtil
{
  public static final RIJFeedsRefreshUtil a = new RIJFeedsRefreshUtil();
  
  private final List<Long> a(ConcurrentMap<Long, AbsBaseArticleInfo> paramConcurrentMap)
  {
    List localList = (List)new ArrayList();
    if (paramConcurrentMap != null)
    {
      if (paramConcurrentMap.isEmpty()) {
        return localList;
      }
      paramConcurrentMap = ((Map)paramConcurrentMap).entrySet().iterator();
      while (paramConcurrentMap.hasNext())
      {
        Long localLong = (Long)((Map.Entry)paramConcurrentMap.next()).getKey();
        Intrinsics.checkExpressionValueIsNotNull(localLong, "key");
        localList.add(localLong);
      }
      CollectionsKt.sort(localList);
    }
    return localList;
  }
  
  private final boolean a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null) {
      paramToServiceMsg = paramToServiceMsg.getAttribute("request_extra_data_key");
    } else {
      paramToServiceMsg = null;
    }
    boolean bool2 = paramToServiceMsg instanceof Bundle;
    boolean bool1 = true;
    int i;
    if (bool2) {
      i = ((Bundle)paramToServiceMsg).getInt("FeedsRefreshType", 1);
    } else {
      i = 1;
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("[isAutoRefresh] refreshType = ");
    paramToServiceMsg.append(i);
    QLog.i("RIJFeedsRefreshUtil", 1, paramToServiceMsg.toString());
    if (i != 2)
    {
      if (i == 3) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public final int a(int paramInt)
  {
    int i = 0;
    if ((paramInt != 0) && (!DailyModeConfigHandler.b(paramInt)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[getArticleRetainedNumber] channelId = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", retainNumber = ");
      ((StringBuilder)localObject).append(0);
      QLog.i("RIJFeedsRefreshUtil", 1, ((StringBuilder)localObject).toString());
      return 0;
    }
    Object localObject = Aladdin.getConfig(256);
    if (localObject != null) {
      i = ((AladdinConfig)localObject).getIntegerFromString("number_of_articles_retained", 0);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[getArticleRetainedNumber] channelId = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", retainNumber = ");
    ((StringBuilder)localObject).append(i);
    QLog.i("RIJFeedsRefreshUtil", 1, ((StringBuilder)localObject).toString());
    return i;
  }
  
  @NotNull
  public final String a(@NotNull List<Long> paramList, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "reservedArticleSeqList");
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int j = ((Collection)paramList).size();
    int i = 0;
    while (i < j)
    {
      localStringBuilder2.append(((Number)paramList.get(i)).longValue());
      if (i != paramList.size() - 1) {
        localStringBuilder2.append(", ");
      }
      i += 1;
    }
    localStringBuilder1.append("DELETE FROM ");
    localStringBuilder1.append("ArticleInfo");
    localStringBuilder1.append(" WHERE mChannelID = ");
    localStringBuilder1.append(paramInt);
    localStringBuilder1.append(" AND mRecommendSeq NOT IN (");
    localStringBuilder1.append((CharSequence)localStringBuilder2);
    localStringBuilder1.append(")");
    paramList = localStringBuilder1.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramList, "deleteSql.toString()");
    return paramList;
  }
  
  @NotNull
  public final List<Long> a(@Nullable ConcurrentMap<Long, AbsBaseArticleInfo> paramConcurrentMap, int paramInt)
  {
    paramConcurrentMap = a(paramConcurrentMap);
    int i = 0;
    while (i < paramInt)
    {
      if ((((Collection)paramConcurrentMap).isEmpty() ^ true)) {
        paramConcurrentMap.remove(paramConcurrentMap.size() - 1);
      }
      i += 1;
    }
    return paramConcurrentMap;
  }
  
  public final boolean a(int paramInt, @Nullable ToServiceMsg paramToServiceMsg)
  {
    int i = a(paramInt);
    boolean bool2 = a(paramToServiceMsg);
    boolean bool1;
    if ((i > 0) && (bool2)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("[isAbleToReserveArticle] channelId = ");
    paramToServiceMsg.append(paramInt);
    paramToServiceMsg.append(", retainNumber = ");
    paramToServiceMsg.append(i);
    paramToServiceMsg.append(", ");
    paramToServiceMsg.append("isAutoRefresh = ");
    paramToServiceMsg.append(bool2);
    paramToServiceMsg.append(", res = ");
    paramToServiceMsg.append(bool1);
    QLog.i("RIJFeedsRefreshUtil", 1, paramToServiceMsg.toString());
    return bool1;
  }
  
  @NotNull
  public final List<Long> b(@Nullable ConcurrentMap<Long, AbsBaseArticleInfo> paramConcurrentMap, int paramInt)
  {
    paramConcurrentMap = a(paramConcurrentMap);
    int i = paramConcurrentMap.size() - paramInt;
    if (i > 0)
    {
      paramInt = 0;
      while (paramInt < i)
      {
        if ((((Collection)paramConcurrentMap).isEmpty() ^ true)) {
          paramConcurrentMap.remove(0);
        }
        paramInt += 1;
      }
    }
    return paramConcurrentMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsRefreshUtil
 * JD-Core Version:    0.7.0.1
 */