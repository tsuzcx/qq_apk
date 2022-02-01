package com.tencent.mobileqq.kandian.biz.common.api.impl;

import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.kandian.biz.common.api.IWeiShiReportUtil;
import com.tencent.mobileqq.kandian.glue.report.WeishiReportUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/impl/WeiShiReportUtilImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/api/IWeiShiReportUtil;", "()V", "reportEnter", "", "reportExit", "reportMsgExposure", "data", "Lcom/tencent/mobileqq/activity/recent/RecentBaseData;", "reportFrom", "", "reportWeiShiDelete", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class WeiShiReportUtilImpl
  implements IWeiShiReportUtil
{
  public void reportEnter() {}
  
  public void reportExit() {}
  
  public void reportMsgExposure(@Nullable RecentBaseData paramRecentBaseData, int paramInt)
  {
    WeishiReportUtil.a(paramRecentBaseData, paramInt);
  }
  
  public void reportWeiShiDelete() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.impl.WeiShiReportUtilImpl
 * JD-Core Version:    0.7.0.1
 */