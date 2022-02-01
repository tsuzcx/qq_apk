package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsInsertUtil;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/data/RIJFeedsInsertArticle;", "", "()V", "actionArticleMap", "Ljava/util/SortedMap;", "Lcom/tencent/mobileqq/kandian/repo/feeds/RIJFeedsInsertAction;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "Lkotlin/collections/ArrayList;", "getActionArticleMap", "()Ljava/util/SortedMap;", "setActionArticleMap", "(Ljava/util/SortedMap;)V", "seqNo", "", "getSeqNo", "()Ljava/lang/String;", "setSeqNo", "(Ljava/lang/String;)V", "toSimpleString", "toString", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsInsertArticle
{
  @Nullable
  private SortedMap<RIJFeedsInsertAction, ArrayList<AbsBaseArticleInfo>> a = Collections.synchronizedSortedMap((SortedMap)new TreeMap());
  @Nullable
  private String b;
  
  @Nullable
  public final SortedMap<RIJFeedsInsertAction, ArrayList<AbsBaseArticleInfo>> a()
  {
    return this.a;
  }
  
  public final void a(@Nullable String paramString)
  {
    this.b = paramString;
  }
  
  public final void a(@Nullable SortedMap<RIJFeedsInsertAction, ArrayList<AbsBaseArticleInfo>> paramSortedMap)
  {
    this.a = paramSortedMap;
  }
  
  @Nullable
  public final String b()
  {
    return this.b;
  }
  
  @NotNull
  public final String c()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("RIJFeedsInsertArticle(actionArticleMap=\n");
    Object localObject2 = this.a;
    if (localObject2 != null)
    {
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append('[');
        ((StringBuilder)localObject4).append((RIJFeedsInsertAction)((Map.Entry)localObject3).getKey());
        ((StringBuilder)localObject4).append(":{");
        ((StringBuilder)localObject1).append(((StringBuilder)localObject4).toString());
        localObject3 = ((ArrayList)((Map.Entry)localObject3).getValue()).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (AbsBaseArticleInfo)((Iterator)localObject3).next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[title:");
          localStringBuilder.append(((AbsBaseArticleInfo)localObject4).mTitle);
          localStringBuilder.append(" , rowkey:");
          RIJFeedsInsertUtil localRIJFeedsInsertUtil = RIJFeedsInsertUtil.a;
          Intrinsics.checkExpressionValueIsNotNull(localObject4, "article");
          localStringBuilder.append(localRIJFeedsInsertUtil.b((AbsBaseArticleInfo)localObject4));
          localStringBuilder.append(" ,isAD:");
          localStringBuilder.append(localObject4 instanceof AdvertisementInfo);
          localStringBuilder.append(']');
          ((StringBuilder)localObject1).append(localStringBuilder.toString());
        }
        ((StringBuilder)localObject1).append("\n");
      }
    }
    ((StringBuilder)localObject1).append(")");
    localObject1 = ((StringBuilder)localObject1).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "simepleStringBuilder.toString()");
    return localObject1;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RIJFeedsInsertArticle(actionArticleMap=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.RIJFeedsInsertArticle
 * JD-Core Version:    0.7.0.1
 */