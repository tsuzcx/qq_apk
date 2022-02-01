package com.tencent.thumbplayer.adapter.strategy;

import com.tencent.thumbplayer.adapter.TPPlaybackInfo;
import com.tencent.thumbplayer.adapter.strategy.model.TPStrategyConfig;
import com.tencent.thumbplayer.adapter.strategy.model.TPStrategyContext;
import com.tencent.thumbplayer.adapter.strategy.utils.TPStrategyUtils;

public abstract class TPBaseStrategy
  implements ITPStrategy
{
  protected TPStrategyConfig tpStrategyConfig;
  
  public TPBaseStrategy(TPStrategyConfig paramTPStrategyConfig)
  {
    this.tpStrategyConfig = paramTPStrategyConfig;
  }
  
  protected boolean checkNeedDoRetry(TPStrategyContext paramTPStrategyContext)
  {
    return false;
  }
  
  boolean isSystemPlayerEnable(TPPlaybackInfo paramTPPlaybackInfo)
  {
    if (TPStrategyUtils.isTVPlatform()) {
      return true;
    }
    return (TPStrategyUtils.isSystemPlayerEnable()) && (TPStrategyUtils.enablePlayBySystemPlayer(paramTPPlaybackInfo));
  }
  
  boolean isThumbPlayerEnable(TPPlaybackInfo paramTPPlaybackInfo)
  {
    if (TPStrategyUtils.isTVPlatform()) {
      return TPStrategyUtils.isThumbPlayerEnable();
    }
    return (TPStrategyUtils.isThumbPlayerEnable()) && (TPStrategyUtils.enablePlayByThumbPlayer(paramTPPlaybackInfo));
  }
  
  public int[] strategyForDec()
  {
    int i = this.tpStrategyConfig.getDecStrategy();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return null;
            }
            return new int[] { 101, 102 };
          }
          return new int[] { 101 };
        }
        return new int[] { 102, 101 };
      }
      return new int[] { 102 };
    }
    return new int[] { 102, 101 };
  }
  
  public int strategyForOpen(TPPlaybackInfo paramTPPlaybackInfo)
  {
    int i = this.tpStrategyConfig.getPlayerStrategy();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return 0;
            }
            if (isSystemPlayerEnable(paramTPPlaybackInfo)) {
              return 1;
            }
            if (TPStrategyUtils.isThumbPlayerEnable()) {
              return 2;
            }
            return 0;
          }
          if (isSystemPlayerEnable(paramTPPlaybackInfo)) {
            return 1;
          }
          return 0;
        }
        if (isThumbPlayerEnable(paramTPPlaybackInfo)) {
          return 2;
        }
        if (TPStrategyUtils.isSystemPlayerEnable()) {
          return 1;
        }
        return 0;
      }
      if (isThumbPlayerEnable(paramTPPlaybackInfo)) {
        return 2;
      }
      return 0;
    }
    if (isThumbPlayerEnable(paramTPPlaybackInfo)) {
      return 2;
    }
    if (TPStrategyUtils.isSystemPlayerEnable()) {
      return 1;
    }
    return 0;
  }
  
  public int strategyForRetry(TPPlaybackInfo paramTPPlaybackInfo, TPStrategyContext paramTPStrategyContext)
  {
    int i = this.tpStrategyConfig.getPlayerStrategy();
    if ((paramTPStrategyContext != null) && (paramTPStrategyContext.getPlayerType() == 0)) {
      return strategyForOpen(paramTPPlaybackInfo);
    }
    if (!checkNeedDoRetry(paramTPStrategyContext)) {
      return 0;
    }
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return 0;
            }
            if ((paramTPStrategyContext != null) && (paramTPStrategyContext.getPlayerType() == 1) && (isThumbPlayerEnable(paramTPPlaybackInfo))) {
              return 2;
            }
            return 0;
          }
        }
        else if ((paramTPStrategyContext != null) && (paramTPStrategyContext.getPlayerType() == 2) && (isSystemPlayerEnable(paramTPPlaybackInfo))) {
          return 1;
        }
      }
      return 0;
    }
    if ((paramTPStrategyContext != null) && (paramTPStrategyContext.getPlayerType() == 1))
    {
      if (isThumbPlayerEnable(paramTPPlaybackInfo)) {
        return 2;
      }
      return 0;
    }
    if ((paramTPStrategyContext != null) && (paramTPStrategyContext.getPlayerType() == 2) && (isSystemPlayerEnable(paramTPPlaybackInfo))) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.TPBaseStrategy
 * JD-Core Version:    0.7.0.1
 */