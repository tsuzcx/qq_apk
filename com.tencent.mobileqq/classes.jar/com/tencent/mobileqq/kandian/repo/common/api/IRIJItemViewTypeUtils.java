package com.tencent.mobileqq.kandian.repo.common.api;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/common/api/IRIJItemViewTypeUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isHotSearchCard", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "isUGC", "isUGCFeeds", "feedsType", "", "originFeedsType", "", "isUGCRecommendTopic", "isUGCRecommendTopicSocial", "isUGCSocial", "isUgcVideoFeedsEmpty", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJItemViewTypeUtils
  extends QRouteApi
{
  public abstract boolean isHotSearchCard(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isUGC(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isUGCFeeds(int paramInt, long paramLong);
  
  public abstract boolean isUGCRecommendTopic(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isUGCRecommendTopicSocial(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isUGCSocial(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isUgcVideoFeedsEmpty(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.api.IRIJItemViewTypeUtils
 * JD-Core Version:    0.7.0.1
 */