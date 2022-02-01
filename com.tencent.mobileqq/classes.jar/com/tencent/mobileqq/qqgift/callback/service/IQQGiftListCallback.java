package com.tencent.mobileqq.qqgift.callback.service;

import com.tencent.mobileqq.qqgift.callback.IQQGiftBaseCallback;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import java.util.List;

public abstract interface IQQGiftListCallback
  extends IQQGiftBaseCallback
{
  public abstract void a(List<GiftServiceData> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.callback.service.IQQGiftListCallback
 * JD-Core Version:    0.7.0.1
 */