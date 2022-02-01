package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds;

import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.RIJFeedsInsertArticle;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/data/RIJFeedsInsertArticle;", "rowKey", "", "insertArticles", "Ljava/util/concurrent/ConcurrentHashMap;", "<anonymous parameter 2>", "invoke"}, k=3, mv={1, 1, 16})
final class RIJFeedsDynamicInsertModule$deleteFeedsDynamicInsertInfo$1
  extends Lambda
  implements Function3<String, ConcurrentHashMap<String, RIJFeedsInsertArticle>, RIJFeedsInsertArticle, RIJFeedsInsertArticle>
{
  public static final 1 INSTANCE = new 1();
  
  RIJFeedsDynamicInsertModule$deleteFeedsDynamicInsertInfo$1()
  {
    super(3);
  }
  
  @Nullable
  public final RIJFeedsInsertArticle invoke(@NotNull String paramString, @NotNull ConcurrentHashMap<String, RIJFeedsInsertArticle> paramConcurrentHashMap, @NotNull RIJFeedsInsertArticle paramRIJFeedsInsertArticle)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    Intrinsics.checkParameterIsNotNull(paramConcurrentHashMap, "insertArticles");
    Intrinsics.checkParameterIsNotNull(paramRIJFeedsInsertArticle, "<anonymous parameter 2>");
    return (RIJFeedsInsertArticle)paramConcurrentHashMap.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertModule.deleteFeedsDynamicInsertInfo.1
 * JD-Core Version:    0.7.0.1
 */