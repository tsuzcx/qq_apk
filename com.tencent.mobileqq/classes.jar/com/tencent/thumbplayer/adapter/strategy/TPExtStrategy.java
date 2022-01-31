package com.tencent.thumbplayer.adapter.strategy;

import com.tencent.thumbplayer.adapter.TPPlaybackInfo;
import com.tencent.thumbplayer.adapter.strategy.model.TPStrategyContext;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

public class TPExtStrategy
  implements ITPStrategy
{
  private static final String TAG = "TPThumbPlayer[TPExtStrategy.java]";
  private Queue<Integer> mPlayerList;
  
  public TPExtStrategy(Queue<Integer> paramQueue)
  {
    this.mPlayerList = paramQueue;
    if (this.mPlayerList == null) {
      this.mPlayerList = new ArrayDeque();
    }
  }
  
  public int[] strategyForDec()
  {
    return new int[] { 102, 101 };
  }
  
  public int strategyForOpen(TPPlaybackInfo paramTPPlaybackInfo)
  {
    try
    {
      int i = ((Integer)this.mPlayerList.remove()).intValue();
      return i;
    }
    catch (NoSuchElementException paramTPPlaybackInfo)
    {
      TPLogUtil.e("TPThumbPlayer[TPExtStrategy.java]", paramTPPlaybackInfo);
    }
    return 0;
  }
  
  public int strategyForRetry(TPPlaybackInfo paramTPPlaybackInfo, TPStrategyContext paramTPStrategyContext)
  {
    try
    {
      int i = ((Integer)this.mPlayerList.remove()).intValue();
      return i;
    }
    catch (NoSuchElementException paramTPPlaybackInfo)
    {
      TPLogUtil.e("TPThumbPlayer[TPExtStrategy.java]", paramTPPlaybackInfo);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.TPExtStrategy
 * JD-Core Version:    0.7.0.1
 */