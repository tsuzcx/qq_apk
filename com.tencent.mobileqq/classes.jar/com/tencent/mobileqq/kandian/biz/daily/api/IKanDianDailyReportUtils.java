package com.tencent.mobileqq.kandian.biz.daily.api;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/daily/api/IKanDianDailyReportUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getChannelId", "", "reportForClick", "", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "reportPushRedDotExposure", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IKanDianDailyReportUtils
  extends QRouteApi
{
  @Nullable
  public abstract String getChannelId();
  
  public abstract void reportForClick(@Nullable MessageRecord paramMessageRecord);
  
  public abstract void reportPushRedDotExposure();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.api.IKanDianDailyReportUtils
 * JD-Core Version:    0.7.0.1
 */