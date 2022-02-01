package com.tencent.mobileqq.kandian.repo.daily.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/daily/api/IDailyModeConfigHandler;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isDaily", "", "channelId", "", "isDailyUnlimitChannel", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IDailyModeConfigHandler
  extends QRouteApi
{
  public abstract boolean isDaily(int paramInt);
  
  public abstract boolean isDailyUnlimitChannel(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.daily.api.IDailyModeConfigHandler
 * JD-Core Version:    0.7.0.1
 */