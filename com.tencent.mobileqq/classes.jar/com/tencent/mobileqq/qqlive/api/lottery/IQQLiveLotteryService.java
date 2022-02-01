package com.tencent.mobileqq.qqlive.api.lottery;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.lottery.IQQLiveHideLotteryCallback;
import com.tencent.mobileqq.qqlive.callback.lottery.IQQLiveLotteryCallback;
import java.util.Map;

public abstract interface IQQLiveLotteryService
  extends IQQLiveModule
{
  public abstract void getLotteryPendant(long paramLong1, long paramLong2, String paramString, Map<String, String> paramMap, IQQLiveLotteryCallback paramIQQLiveLotteryCallback);
  
  public abstract void notifyHideLotteryResult(String paramString1, String paramString2, String paramString3);
  
  public abstract void registerHideLottery(IQQLiveHideLotteryCallback paramIQQLiveHideLotteryCallback);
  
  public abstract void unRegisterHideLottery(IQQLiveHideLotteryCallback paramIQQLiveHideLotteryCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.lottery.IQQLiveLotteryService
 * JD-Core Version:    0.7.0.1
 */