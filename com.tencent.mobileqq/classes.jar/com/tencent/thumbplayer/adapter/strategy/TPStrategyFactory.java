package com.tencent.thumbplayer.adapter.strategy;

import com.tencent.thumbplayer.adapter.strategy.model.TPStrategyConfig;
import com.tencent.thumbplayer.adapter.strategy.utils.TPStrategyUtils;
import java.util.Queue;

public class TPStrategyFactory
{
  public static ITPStrategy createExternStrategy(Queue<Integer> paramQueue)
  {
    return new TPExtStrategy(paramQueue);
  }
  
  public static ITPStrategy createStrategy(TPStrategyConfig paramTPStrategyConfig)
  {
    if (TPStrategyUtils.isTVPlatform()) {
      return new TPTVStrategy(paramTPStrategyConfig);
    }
    return new TPPhoneStrategy(paramTPStrategyConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.TPStrategyFactory
 * JD-Core Version:    0.7.0.1
 */