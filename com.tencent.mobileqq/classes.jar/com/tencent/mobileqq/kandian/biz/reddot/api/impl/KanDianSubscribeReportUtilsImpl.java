package com.tencent.mobileqq.kandian.biz.reddot.api.impl;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.reddot.KandianSubscribeReportUtils;
import com.tencent.mobileqq.kandian.biz.reddot.api.IKanDianSubscribeReportUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reddot/api/impl/KanDianSubscribeReportUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/reddot/api/IKanDianSubscribeReportUtils;", "()V", "reportKanDianSubscribeClick", "", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "reportPushRedDotExposure", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KanDianSubscribeReportUtilsImpl
  implements IKanDianSubscribeReportUtils
{
  public void reportKanDianSubscribeClick(@Nullable MessageRecord paramMessageRecord)
  {
    KandianSubscribeReportUtils.a(paramMessageRecord);
  }
  
  public void reportPushRedDotExposure() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reddot.api.impl.KanDianSubscribeReportUtilsImpl
 * JD-Core Version:    0.7.0.1
 */