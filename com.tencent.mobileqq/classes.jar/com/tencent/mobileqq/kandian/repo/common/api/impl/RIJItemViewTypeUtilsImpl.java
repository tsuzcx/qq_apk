package com.tencent.mobileqq.kandian.repo.common.api.impl;

import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.api.IRIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/common/api/impl/RIJItemViewTypeUtilsImpl;", "Lcom/tencent/mobileqq/kandian/repo/common/api/IRIJItemViewTypeUtils;", "()V", "isHotSearchCard", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "isUGC", "isUGCFeeds", "feedsType", "", "originFeedsType", "", "isUGCRecommendTopic", "isUGCRecommendTopicSocial", "isUGCSocial", "isUgcVideoFeedsEmpty", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJItemViewTypeUtilsImpl
  implements IRIJItemViewTypeUtils
{
  public boolean isHotSearchCard(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return RIJBaseItemViewType.c(paramAbsBaseArticleInfo);
  }
  
  public boolean isUGC(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo);
  }
  
  public boolean isUGCFeeds(int paramInt, long paramLong)
  {
    return RIJItemViewTypeUtils.a(paramInt, paramLong);
  }
  
  public boolean isUGCRecommendTopic(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo);
  }
  
  public boolean isUGCRecommendTopicSocial(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo);
  }
  
  public boolean isUGCSocial(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo);
  }
  
  public boolean isUgcVideoFeedsEmpty(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return RIJItemViewTypeUtils.x(paramAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.api.impl.RIJItemViewTypeUtilsImpl
 * JD-Core Version:    0.7.0.1
 */