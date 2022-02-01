package com.tencent.mobileqq.kandian.biz.feeds.api;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/api/IRIJFeedsInsertUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getLastClickChannelId", "", "requestRecommendArticleInfoList", "", "channelId", "updateLastClickArticleInfo", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "updateReqParams", "followPuin", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJFeedsInsertUtil
  extends QRouteApi
{
  public abstract long getLastClickChannelId();
  
  public abstract void requestRecommendArticleInfoList(long paramLong);
  
  public abstract void updateLastClickArticleInfo(long paramLong, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract void updateReqParams(long paramLong, @NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.api.IRIJFeedsInsertUtil
 * JD-Core Version:    0.7.0.1
 */