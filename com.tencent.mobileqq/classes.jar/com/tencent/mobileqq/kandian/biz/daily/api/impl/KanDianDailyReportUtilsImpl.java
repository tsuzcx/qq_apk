package com.tencent.mobileqq.kandian.biz.daily.api.impl;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.daily.api.IKanDianDailyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/daily/api/impl/KanDianDailyReportUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/daily/api/IKanDianDailyReportUtils;", "()V", "getChannelId", "", "reportForClick", "", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "reportPushRedDotExposure", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KanDianDailyReportUtilsImpl
  implements IKanDianDailyReportUtils
{
  @Nullable
  public String getChannelId()
  {
    return KandianDailyReportUtils.b();
  }
  
  public void reportForClick(@Nullable MessageRecord paramMessageRecord)
  {
    KandianDailyReportUtils.a(paramMessageRecord);
  }
  
  public void reportPushRedDotExposure() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.api.impl.KanDianDailyReportUtilsImpl
 * JD-Core Version:    0.7.0.1
 */