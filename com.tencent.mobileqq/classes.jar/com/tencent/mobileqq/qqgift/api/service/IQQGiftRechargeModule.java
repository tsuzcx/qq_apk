package com.tencent.mobileqq.qqgift.api.service;

import com.tencent.mobileqq.qqgift.api.IQQGiftModule;
import com.tencent.mobileqq.qqgift.callback.IQQGiftRechargeCallback;
import java.util.HashMap;

public abstract interface IQQGiftRechargeModule
  extends IQQGiftModule
{
  public abstract void a(@IQQGiftRechargeModule.RechargeSource int paramInt, IQQGiftRechargeCallback paramIQQGiftRechargeCallback);
  
  public abstract void a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString);
  
  public abstract void a(HashMap<String, String> paramHashMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule
 * JD-Core Version:    0.7.0.1
 */