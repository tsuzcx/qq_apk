package com.tencent.mobileqq.kandian.repo.daily.api.impl;

import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.daily.api.IDailyModeConfigHandler;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/daily/api/impl/DailyModeConfigHandlerSingleton;", "Lcom/tencent/mobileqq/kandian/repo/daily/api/IDailyModeConfigHandler;", "()V", "CHANNEL_ID_DAILY", "", "getCHANNEL_ID_DAILY", "()I", "isDaily", "", "channelId", "isDailyNormalChannel", "isDailyUnlimitChannel", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DailyModeConfigHandlerSingleton
  implements IDailyModeConfigHandler
{
  private static final int CHANNEL_ID_DAILY = 41505;
  public static final DailyModeConfigHandlerSingleton INSTANCE = new DailyModeConfigHandlerSingleton();
  
  public final int getCHANNEL_ID_DAILY()
  {
    return CHANNEL_ID_DAILY;
  }
  
  public boolean isDaily(int paramInt)
  {
    if (isDailyNormalChannel(paramInt)) {
      return true;
    }
    return isDailyUnlimitChannel(paramInt);
  }
  
  public final boolean isDailyNormalChannel(int paramInt)
  {
    return paramInt == CHANNEL_ID_DAILY;
  }
  
  public boolean isDailyUnlimitChannel(int paramInt)
  {
    boolean bool2 = isDailyNormalChannel(DailyModeConfigHandler.a);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (DailyModeConfigHandler.a == paramInt) {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.daily.api.impl.DailyModeConfigHandlerSingleton
 * JD-Core Version:    0.7.0.1
 */