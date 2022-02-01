package com.tencent.mobileqq.kandian.biz.common.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/IRIJStudyModeUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getUserMode", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJStudyModeUtils
  extends QRouteApi
{
  public abstract int getUserMode();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.IRIJStudyModeUtils
 * JD-Core Version:    0.7.0.1
 */