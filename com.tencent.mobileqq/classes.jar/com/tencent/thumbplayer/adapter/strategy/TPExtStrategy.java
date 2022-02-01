package com.tencent.thumbplayer.adapter.strategy;

import android.text.TextUtils;
import com.tencent.thumbplayer.adapter.TPPlaybackInfo;
import com.tencent.thumbplayer.adapter.strategy.model.TPStrategyConfig;
import com.tencent.thumbplayer.adapter.strategy.model.TPStrategyContext;
import com.tencent.thumbplayer.utils.TPLogUtil;

public class TPExtStrategy
  extends TPBaseStrategy
{
  private static final String TAG = "TPThumbPlayer[TPExtStrategy.java]";
  private int mCurId = 0;
  private int[] mPlayerList;
  
  public TPExtStrategy(TPStrategyConfig paramTPStrategyConfig)
  {
    super(paramTPStrategyConfig);
    this.mPlayerList = paramTPStrategyConfig.getPlayerList();
    if ((this.mPlayerList == null) || (this.mPlayerList.length == 0)) {
      this.mPlayerList = new int[1];
    }
  }
  
  private boolean isUseSoftDec(String paramString)
  {
    return (TextUtils.equals(paramString, "hd")) || (TextUtils.equals(paramString, "sd")) || (TextUtils.equals(paramString, "msd"));
  }
  
  public int[] strategyForDec()
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = -1;
    if (this.mCurId >= this.mPlayerList.length)
    {
      TPLogUtil.i("TPThumbPlayer[TPExtStrategy.java]", "strategyForDec error, decType:" + arrayOfInt[0]);
      return arrayOfInt;
    }
    if ((this.mPlayerList[this.mCurId] == 1) || (this.mPlayerList[this.mCurId] == 2)) {
      arrayOfInt[0] = 102;
    }
    for (;;)
    {
      TPLogUtil.i("TPThumbPlayer[TPExtStrategy.java]", "strategyForDec, decType:" + arrayOfInt[0]);
      return arrayOfInt;
      if (this.mPlayerList[this.mCurId] == 3) {
        arrayOfInt[0] = 101;
      }
    }
  }
  
  public int strategyForOpen(TPPlaybackInfo paramTPPlaybackInfo)
  {
    if (this.mPlayerList.length > this.mCurId) {}
    for (int i = this.mPlayerList[this.mCurId];; i = 0)
    {
      int j;
      if (i != 2)
      {
        j = i;
        if (i != 3) {}
      }
      else
      {
        j = i;
        if (!isThumbPlayerEnable(paramTPPlaybackInfo)) {
          j = 0;
        }
      }
      TPLogUtil.i("TPThumbPlayer[TPExtStrategy.java]", "strategyForOpen, playerType:" + j);
      return j;
    }
  }
  
  public int strategyForRetry(TPPlaybackInfo paramTPPlaybackInfo, TPStrategyContext paramTPStrategyContext)
  {
    if ((paramTPStrategyContext != null) && (paramTPStrategyContext.getPlayerType() == 0)) {
      return strategyForOpen(paramTPPlaybackInfo);
    }
    if (this.mPlayerList.length - 1 > this.mCurId)
    {
      paramTPStrategyContext = this.mPlayerList;
      i = this.mCurId + 1;
      this.mCurId = i;
    }
    for (int i = paramTPStrategyContext[i];; i = 0)
    {
      int j;
      if (i != 2)
      {
        j = i;
        if (i != 3) {}
      }
      else
      {
        j = i;
        if (!isThumbPlayerEnable(paramTPPlaybackInfo)) {
          j = 0;
        }
      }
      TPLogUtil.i("TPThumbPlayer[TPExtStrategy.java]", "strategyForRetry, playerType:" + j);
      return j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.TPExtStrategy
 * JD-Core Version:    0.7.0.1
 */