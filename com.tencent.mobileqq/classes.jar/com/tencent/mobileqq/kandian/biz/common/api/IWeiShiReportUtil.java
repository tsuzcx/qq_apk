package com.tencent.mobileqq.kandian.biz.common.api;

import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/IWeiShiReportUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "reportEnter", "", "reportExit", "reportMsgExposure", "data", "Lcom/tencent/mobileqq/activity/recent/RecentBaseData;", "reportFrom", "", "reportWeiShiDelete", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IWeiShiReportUtil
  extends QRouteApi
{
  public abstract void reportEnter();
  
  public abstract void reportExit();
  
  public abstract void reportMsgExposure(@Nullable RecentBaseData paramRecentBaseData, int paramInt);
  
  public abstract void reportWeiShiDelete();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.IWeiShiReportUtil
 * JD-Core Version:    0.7.0.1
 */