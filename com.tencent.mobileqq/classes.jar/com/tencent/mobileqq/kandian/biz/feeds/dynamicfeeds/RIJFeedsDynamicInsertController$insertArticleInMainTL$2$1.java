package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds;

import com.tencent.mobileqq.kandian.repo.feeds.api.IInsertArticleCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsDynamicInsertController$insertArticleInMainTL$2$1", "Lcom/tencent/mobileqq/kandian/repo/feeds/api/IInsertArticleCallback;", "insertArticle", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsDynamicInsertController$insertArticleInMainTL$2$1
  implements IInsertArticleCallback
{
  public void a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      Object localObject = this.a.a;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)((Iterator)localObject).next();
          if (RIJFeedsInsertUtil.a.a(localAbsBaseArticleInfo, paramAbsBaseArticleInfo)) {
            RIJFeedsDynamicInsertController.INSTANCE.report64e(paramAbsBaseArticleInfo);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController.insertArticleInMainTL.2.1
 * JD-Core Version:    0.7.0.1
 */