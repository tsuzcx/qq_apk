package com.tencent.thumbplayer.adapter.strategy.model;

import com.tencent.thumbplayer.adapter.TPPlaybackParams;
import com.tencent.thumbplayer.adapter.strategy.utils.TPStrategyUtils;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamLong;

public class TPStrategyConfig
{
  int decStrategy = 2;
  int playerStrategy = 2;
  
  public TPStrategyConfig(TPPlaybackParams paramTPPlaybackParams)
  {
    if (TPStrategyUtils.isTVPlatform())
    {
      this.playerStrategy = 4;
      this.decStrategy = 2;
    }
    if (paramTPPlaybackParams != null)
    {
      TPOptionalParam localTPOptionalParam = paramTPPlaybackParams.getOptionalParam(202);
      if ((localTPOptionalParam != null) && (localTPOptionalParam.getParamType() == 2) && (isPlayerStrategyVaild(localTPOptionalParam.getParamLong().value))) {
        this.playerStrategy = ((int)localTPOptionalParam.getParamLong().value);
      }
      paramTPPlaybackParams = paramTPPlaybackParams.getOptionalParam(203);
      if ((paramTPPlaybackParams != null) && (paramTPPlaybackParams.getParamType() == 2) && (isDecStrategyVaild(paramTPPlaybackParams.getParamLong().value))) {
        this.decStrategy = ((int)paramTPPlaybackParams.getParamLong().value);
      }
      checkParamsIllegal(this.playerStrategy, this.decStrategy);
    }
  }
  
  private void checkParamsIllegal(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 3) && (paramInt2 == 3)) {
      throw new IllegalArgumentException("can not soft with systemplayer");
    }
  }
  
  private boolean isDecStrategyVaild(long paramLong)
  {
    return (paramLong > 0L) && (paramLong < 5L);
  }
  
  private boolean isPlayerStrategyVaild(long paramLong)
  {
    return (paramLong > 0L) && (paramLong < 5L);
  }
  
  public int getDecStrategy()
  {
    return this.decStrategy;
  }
  
  public int getPlayerStrategy()
  {
    return this.playerStrategy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.model.TPStrategyConfig
 * JD-Core Version:    0.7.0.1
 */