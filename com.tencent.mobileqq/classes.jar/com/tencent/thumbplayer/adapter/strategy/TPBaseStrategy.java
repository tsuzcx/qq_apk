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
    return (TPStrategyUtils.isSystemPlayerEnable()) && (TPStrategyUtils.enablePlayBySystemPlayer(paramTPPlaybackInfo));
  }
  
  boolean isThumbPlayerEnable(TPPlaybackInfo paramTPPlaybackInfo)
  {
    return (TPStrategyUtils.isThumbPlayerEnable()) && (TPStrategyUtils.enablePlayByThumbPlayer(paramTPPlaybackInfo));
  }
  
  public int[] strategyForDec()
  {
    switch (this.tpStrategyConfig.getDecStrategy())
    {
    default: 
      return null;
    case 1: 
      return new int[] { 102 };
    case 2: 
      return new int[] { 102, 101 };
    case 3: 
      return new int[] { 101 };
    case 4: 
      return new int[] { 101, 102 };
    }
    return new int[] { 102, 101 };
  }
  
  public int strategyForOpen(TPPlaybackInfo paramTPPlaybackInfo)
  {
    int i = 2;
    switch (this.tpStrategyConfig.getPlayerStrategy())
    {
    default: 
      i = 0;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
          } while (isThumbPlayerEnable(paramTPPlaybackInfo));
          return 0;
        } while (isThumbPlayerEnable(paramTPPlaybackInfo));
        if (TPStrategyUtils.isSystemPlayerEnable()) {
          return 1;
        }
        return 0;
        if (isSystemPlayerEnable(paramTPPlaybackInfo)) {
          return 1;
        }
        return 0;
        if (isSystemPlayerEnable(paramTPPlaybackInfo)) {
          return 1;
        }
      } while (TPStrategyUtils.isThumbPlayerEnable());
      return 0;
    } while (isThumbPlayerEnable(paramTPPlaybackInfo));
    if (TPStrategyUtils.isSystemPlayerEnable()) {
      return 1;
    }
    return 0;
  }
  
  public int strategyForRetry(TPPlaybackInfo paramTPPlaybackInfo, TPStrategyContext paramTPStrategyContext)
  {
    int j = 0;
    int k = this.tpStrategyConfig.getPlayerStrategy();
    int i;
    if ((paramTPStrategyContext != null) && (paramTPStrategyContext.getPlayerType() == 0)) {
      i = strategyForOpen(paramTPPlaybackInfo);
    }
    label169:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return i;
                          i = j;
                        } while (!checkNeedDoRetry(paramTPStrategyContext));
                        i = j;
                        switch (k)
                        {
                        case 1: 
                        case 3: 
                        default: 
                          return 0;
                        case 0: 
                          if ((paramTPStrategyContext == null) || (paramTPStrategyContext.getPlayerType() != 1)) {
                            break label169;
                          }
                          i = j;
                        }
                      } while (!isThumbPlayerEnable(paramTPPlaybackInfo));
                      return 2;
                      i = j;
                    } while (paramTPStrategyContext == null);
                    i = j;
                  } while (paramTPStrategyContext.getPlayerType() != 2);
                  i = j;
                } while (!isSystemPlayerEnable(paramTPPlaybackInfo));
                return 1;
                i = j;
              } while (paramTPStrategyContext == null);
              i = j;
            } while (paramTPStrategyContext.getPlayerType() != 1);
            i = j;
          } while (!isThumbPlayerEnable(paramTPPlaybackInfo));
          return 2;
          i = j;
        } while (paramTPStrategyContext == null);
        i = j;
      } while (paramTPStrategyContext.getPlayerType() != 2);
      i = j;
    } while (!isSystemPlayerEnable(paramTPPlaybackInfo));
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.TPBaseStrategy
 * JD-Core Version:    0.7.0.1
 */