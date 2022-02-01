package com.tencent.mobileqq.kandian.biz.feeds.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/api/IFeedsPreloadHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isFeedsPreloadRequest", "", "any", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IFeedsPreloadHelper
  extends QRouteApi
{
  public abstract boolean isFeedsPreloadRequest(@Nullable Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.api.IFeedsPreloadHelper
 * JD-Core Version:    0.7.0.1
 */