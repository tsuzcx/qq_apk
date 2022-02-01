package com.tencent.mobileqq.kandian.repo.feeds.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/api/IFeedsRefreshUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getContentFlushNumDay", "", "currentTimeMillis", "", "getContentFlushNumProcess", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IFeedsRefreshUtil
  extends QRouteApi
{
  public abstract int getContentFlushNumDay(long paramLong);
  
  public abstract int getContentFlushNumProcess(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.api.IFeedsRefreshUtil
 * JD-Core Version:    0.7.0.1
 */