package com.tencent.mobileqq.kandian.biz.feeds.api.impl;

import com.tencent.mobileqq.kandian.biz.feeds.api.IArticleInfoHelper;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfoKt;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeParam;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/api/impl/ArticleInfoHelperImpl;", "Lcom/tencent/mobileqq/kandian/biz/feeds/api/IArticleInfoHelper;", "()V", "isBaseArticleInfo", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "", "makeDislikeParam", "Lcom/tencent/mobileqq/kandian/repo/dislike/DislikeParam;", "dislikeInfos", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/kandian/repo/dislike/DislikeInfo;", "rowkey", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ArticleInfoHelperImpl
  implements IArticleInfoHelper
{
  public boolean isBaseArticleInfo(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return paramAbsBaseArticleInfo instanceof BaseArticleInfo;
  }
  
  public boolean isBaseArticleInfo(@Nullable Object paramObject)
  {
    return paramObject instanceof BaseArticleInfo;
  }
  
  @Nullable
  public DislikeParam makeDislikeParam(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ArrayList<DislikeInfo> paramArrayList, @Nullable String paramString)
  {
    if (paramAbsBaseArticleInfo != null) {
      return BaseArticleInfoKt.a(paramAbsBaseArticleInfo, paramArrayList, paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.api.impl.ArticleInfoHelperImpl
 * JD-Core Version:    0.7.0.1
 */