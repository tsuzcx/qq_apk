package com.tencent.mobileqq.kandian.biz.reward.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/api/IRIJRewardTaskConfig;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getMaxTaskTimeForArticleInMs", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJRewardTaskConfig
  extends QRouteApi
{
  public abstract int getMaxTaskTimeForArticleInMs();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.api.IRIJRewardTaskConfig
 * JD-Core Version:    0.7.0.1
 */