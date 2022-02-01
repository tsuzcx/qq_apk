package com.tencent.mobileqq.kandian.biz.skin.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/skin/api/IRefreshRes;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getRefreshLengthType", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRefreshRes
  extends QRouteApi
{
  public abstract boolean getRefreshLengthType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.api.IRefreshRes
 * JD-Core Version:    0.7.0.1
 */