package com.tencent.mobileqq.kandian.repo.daily.api.impl;

import com.tencent.mobileqq.kandian.repo.daily.api.IDailyModeConfigHandler;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/daily/api/impl/DailyModeConfigHandlerImpl;", "Lcom/tencent/mobileqq/kandian/repo/daily/api/IDailyModeConfigHandler;", "()V", "isDaily", "", "channelId", "", "isDailyUnlimitChannel", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DailyModeConfigHandlerImpl
  implements IDailyModeConfigHandler
{
  public boolean isDaily(int paramInt)
  {
    return this.$$delegate_0.isDaily(paramInt);
  }
  
  public boolean isDailyUnlimitChannel(int paramInt)
  {
    return this.$$delegate_0.isDailyUnlimitChannel(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.daily.api.impl.DailyModeConfigHandlerImpl
 * JD-Core Version:    0.7.0.1
 */