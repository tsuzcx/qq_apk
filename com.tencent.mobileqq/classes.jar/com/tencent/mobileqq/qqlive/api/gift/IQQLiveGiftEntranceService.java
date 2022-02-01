package com.tencent.mobileqq.qqlive.api.gift;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.gift.OnQueryGiftIconCallback;

public abstract interface IQQLiveGiftEntranceService
  extends IQQLiveModule
{
  public abstract void needShowGiftIcon(long paramLong, int paramInt1, int paramInt2, String paramString, OnQueryGiftIconCallback paramOnQueryGiftIconCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.gift.IQQLiveGiftEntranceService
 * JD-Core Version:    0.7.0.1
 */