package com.tencent.mobileqq.kandian.biz.feeds.api.impl;

import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJFeedsInsertUtil;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsInsertUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/api/impl/RIJFeedsInsertUtilImpl;", "Lcom/tencent/mobileqq/kandian/biz/feeds/api/IRIJFeedsInsertUtil;", "()V", "getLastClickChannelId", "", "requestRecommendArticleInfoList", "", "channelId", "updateLastClickArticleInfo", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "updateReqParams", "followPuin", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsInsertUtilImpl
  implements IRIJFeedsInsertUtil
{
  public long getLastClickChannelId()
  {
    return RIJFeedsInsertUtil.a.a();
  }
  
  public void requestRecommendArticleInfoList(long paramLong)
  {
    RIJFeedsInsertUtil.a.a(paramLong);
  }
  
  public void updateLastClickArticleInfo(long paramLong, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    RIJFeedsInsertUtil.a.b(paramLong, paramAbsBaseArticleInfo);
  }
  
  public void updateReqParams(long paramLong, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "followPuin");
    RIJFeedsInsertUtil.a.a(paramLong, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.api.impl.RIJFeedsInsertUtilImpl
 * JD-Core Version:    0.7.0.1
 */