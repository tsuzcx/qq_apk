package com.tencent.mobileqq.kandian.biz.daily.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/daily/api/IReadInJoyDailySettingModel;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getKvResult", "", "channelID", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyDailySettingModel
  extends QRouteApi
{
  @Nullable
  public abstract String getKvResult(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.api.IReadInJoyDailySettingModel
 * JD-Core Version:    0.7.0.1
 */