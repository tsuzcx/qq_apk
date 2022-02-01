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
    paramTPStrategyConfig = this.mPlayerList;
    if ((paramTPStrategyConfig == null) || (paramTPStrategyConfig.length == 0)) {
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
    int i = this.mCurId;
    Object localObject = this.mPlayerList;
    if (i >= localObject.length)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("strategyForDec error, decType:");
      ((StringBuilder)localObject).append(arrayOfInt[0]);
      TPLogUtil.i("TPThumbPlayer[TPExtStrategy.java]", ((StringBuilder)localObject).toString());
      return arrayOfInt;
    }
    if ((localObject[i] != 1) && (localObject[i] != 2))
    {
      if (localObject[i] == 3) {
        arrayOfInt[0] = 101;
      }
    }
    else {
      arrayOfInt[0] = 102;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("strategyForDec, decType:");
    ((StringBuilder)localObject).append(arrayOfInt[0]);
    TPLogUtil.i("TPThumbPlayer[TPExtStrategy.java]", ((StringBuilder)localObject).toString());
    return arrayOfInt;
  }
  
  public int strategyForOpen(TPPlaybackInfo paramTPPlaybackInfo)
  {
    int[] arrayOfInt = this.mPlayerList;
    int i = arrayOfInt.length;
    int j = this.mCurId;
    if (i > j) {
      i = arrayOfInt[j];
    } else {
      i = 0;
    }
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
    paramTPPlaybackInfo = new StringBuilder();
    paramTPPlaybackInfo.append("strategyForOpen, playerType:");
    paramTPPlaybackInfo.append(j);
    TPLogUtil.i("TPThumbPlayer[TPExtStrategy.java]", paramTPPlaybackInfo.toString());
    return j;
  }
  
  public int strategyForRetry(TPPlaybackInfo paramTPPlaybackInfo, TPStrategyContext paramTPStrategyContext)
  {
    if ((paramTPStrategyContext != null) && (paramTPStrategyContext.getPlayerType() == 0)) {
      return strategyForOpen(paramTPPlaybackInfo);
    }
    paramTPStrategyContext = this.mPlayerList;
    int i = paramTPStrategyContext.length;
    int j = this.mCurId;
    if (i - 1 > j)
    {
      i = j + 1;
      this.mCurId = i;
      i = paramTPStrategyContext[i];
    }
    else
    {
      i = 0;
    }
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
    paramTPPlaybackInfo = new StringBuilder();
    paramTPPlaybackInfo.append("strategyForRetry, playerType:");
    paramTPPlaybackInfo.append(j);
    TPLogUtil.i("TPThumbPlayer[TPExtStrategy.java]", paramTPPlaybackInfo.toString());
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.TPExtStrategy
 * JD-Core Version:    0.7.0.1
 */