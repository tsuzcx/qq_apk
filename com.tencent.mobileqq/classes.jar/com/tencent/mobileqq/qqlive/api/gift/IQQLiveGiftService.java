package com.tencent.mobileqq.qqlive.api.gift;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;

public abstract interface IQQLiveGiftService
  extends IQQLiveModule
{
  public abstract void addReceiveGiftMessageListener(ReceiveGiftMessageListener paramReceiveGiftMessageListener);
  
  public abstract void delReceiveGiftMessageListener(ReceiveGiftMessageListener paramReceiveGiftMessageListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.gift.IQQLiveGiftService
 * JD-Core Version:    0.7.0.1
 */