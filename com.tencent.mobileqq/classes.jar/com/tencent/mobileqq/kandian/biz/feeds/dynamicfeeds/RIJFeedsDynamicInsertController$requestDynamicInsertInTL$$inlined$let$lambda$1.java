package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds;

import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.RIJFeedsInsertArticle;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsDynamicInsertController$requestDynamicInsertInTL$1$1", "Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsDynamicInsertModule$Companion$IFeedsDynamicInsertCallback;", "insert", "", "feedsInsertArticle", "Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/data/RIJFeedsInsertArticle;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsDynamicInsertController$requestDynamicInsertInTL$$inlined$let$lambda$1
  implements RIJFeedsDynamicInsertModule.Companion.IFeedsDynamicInsertCallback
{
  RIJFeedsDynamicInsertController$requestDynamicInsertInTL$$inlined$let$lambda$1(String paramString, ActionType paramActionType, int paramInt1, int paramInt2, RIJFeedsInsertAction paramRIJFeedsInsertAction) {}
  
  public void a(@Nullable RIJFeedsInsertArticle paramRIJFeedsInsertArticle)
  {
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("reqSource: 1, rowkey: ");
    ((StringBuilder)localObject3).append(this.a);
    ((StringBuilder)localObject3).append(", articles from server: ");
    Object localObject2 = null;
    if (paramRIJFeedsInsertArticle != null) {
      localObject1 = paramRIJFeedsInsertArticle.c();
    } else {
      localObject1 = null;
    }
    ((StringBuilder)localObject3).append((String)localObject1);
    QLog.d("RIJFeedsDynamicInsertController", 1, ((StringBuilder)localObject3).toString());
    localObject3 = RIJFeedsDynamicInsertController.INSTANCE;
    if (paramRIJFeedsInsertArticle != null)
    {
      localObject1 = paramRIJFeedsInsertArticle.a();
      if (localObject1 != null)
      {
        localObject1 = (ArrayList)((SortedMap)localObject1).get(new RIJFeedsInsertAction(this.b, this.c, 0, this.d));
        break label122;
      }
    }
    Object localObject1 = null;
    label122:
    List localList = (List)localObject1;
    String str = this.a;
    if (str == null) {
      Intrinsics.throwNpe();
    }
    RIJFeedsInsertAction localRIJFeedsInsertAction = this.e;
    localObject1 = localObject2;
    if (paramRIJFeedsInsertArticle != null) {
      localObject1 = paramRIJFeedsInsertArticle.b();
    }
    ((RIJFeedsDynamicInsertController)localObject3).insertArticleInMainTL(localList, 1, str, localRIJFeedsInsertAction, (String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController.requestDynamicInsertInTL..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */