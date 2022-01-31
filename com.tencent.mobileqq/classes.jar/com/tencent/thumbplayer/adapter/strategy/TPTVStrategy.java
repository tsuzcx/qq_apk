package com.tencent.thumbplayer.adapter.strategy;

import com.tencent.thumbplayer.adapter.strategy.model.TPStrategyConfig;
import com.tencent.thumbplayer.adapter.strategy.model.TPStrategyContext;

public class TPTVStrategy
  extends TPBaseStrategy
{
  public TPTVStrategy(TPStrategyConfig paramTPStrategyConfig)
  {
    super(paramTPStrategyConfig);
  }
  
  protected boolean checkNeedDoRetry(TPStrategyContext paramTPStrategyContext)
  {
    int i = paramTPStrategyContext.errorType;
    return (1210 == i) || (1220 == i) || (1230 == i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.TPTVStrategy
 * JD-Core Version:    0.7.0.1
 */