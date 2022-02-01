package com.tencent.thumbplayer.adapter.strategy;

import com.tencent.thumbplayer.adapter.TPPlaybackInfo;
import com.tencent.thumbplayer.adapter.strategy.model.TPStrategyContext;

public abstract interface ITPStrategy
{
  public abstract int[] strategyForDec();
  
  public abstract int strategyForOpen(TPPlaybackInfo paramTPPlaybackInfo);
  
  public abstract int strategyForRetry(TPPlaybackInfo paramTPPlaybackInfo, TPStrategyContext paramTPStrategyContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.ITPStrategy
 * JD-Core Version:    0.7.0.1
 */