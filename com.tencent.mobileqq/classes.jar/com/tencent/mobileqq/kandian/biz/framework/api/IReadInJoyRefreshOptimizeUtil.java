package com.tencent.mobileqq.kandian.biz.framework.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/framework/api/IReadInJoyRefreshOptimizeUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getOptimizeId", "", "isPreloadOptimizeEnable", "", "optimizeID", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyRefreshOptimizeUtil
  extends QRouteApi
{
  public abstract long getOptimizeId();
  
  public abstract boolean isPreloadOptimizeEnable(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyRefreshOptimizeUtil
 * JD-Core Version:    0.7.0.1
 */