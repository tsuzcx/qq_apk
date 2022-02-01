package com.tencent.mobileqq.qqgift.sso;

import com.tencent.mobileqq.qqgift.api.IQQGiftModule;

public abstract interface IQQGiftSsoModule
  extends IQQGiftModule
{
  public abstract void a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, QQGiftBusinessObserver paramQQGiftBusinessObserver);
  
  public abstract void a(String paramString1, String paramString2, byte[] paramArrayOfByte, QQGiftBusinessObserver paramQQGiftBusinessObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.sso.IQQGiftSsoModule
 * JD-Core Version:    0.7.0.1
 */