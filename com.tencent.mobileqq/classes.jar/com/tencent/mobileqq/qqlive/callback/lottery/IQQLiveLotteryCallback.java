package com.tencent.mobileqq.qqlive.callback.lottery;

import com.tencent.mobileqq.qqlive.data.lottery.QQLiveLotteryData;
import java.util.ArrayList;

public abstract interface IQQLiveLotteryCallback
{
  public abstract void a(long paramLong, String paramString);
  
  public abstract void a(ArrayList<QQLiveLotteryData> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.callback.lottery.IQQLiveLotteryCallback
 * JD-Core Version:    0.7.0.1
 */