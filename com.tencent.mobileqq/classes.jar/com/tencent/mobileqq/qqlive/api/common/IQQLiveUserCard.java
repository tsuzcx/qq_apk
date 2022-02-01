package com.tencent.mobileqq.qqlive.api.common;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.common.IQQLiveUserCardInfoCallback;

public abstract interface IQQLiveUserCard
  extends IQQLiveModule
{
  public abstract void getUserCardInfo(long paramLong, IQQLiveUserCardInfoCallback paramIQQLiveUserCardInfoCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.common.IQQLiveUserCard
 * JD-Core Version:    0.7.0.1
 */