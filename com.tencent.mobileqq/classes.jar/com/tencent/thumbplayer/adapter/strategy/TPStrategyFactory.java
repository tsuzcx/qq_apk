package com.tencent.thumbplayer.adapter.strategy;

import com.tencent.thumbplayer.adapter.strategy.model.TPStrategyConfig;

public class TPStrategyFactory
{
  public static ITPStrategy createStrategy(TPStrategyConfig paramTPStrategyConfig)
  {
    if (paramTPStrategyConfig.isExtPlayerList()) {
      return new TPExtStrategy(paramTPStrategyConfig);
    }
    return new TPDefaultStrategy(paramTPStrategyConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.TPStrategyFactory
 * JD-Core Version:    0.7.0.1
 */