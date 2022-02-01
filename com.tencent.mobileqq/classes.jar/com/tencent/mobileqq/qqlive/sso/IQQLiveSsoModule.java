package com.tencent.mobileqq.qqlive.sso;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;

public abstract interface IQQLiveSsoModule
  extends IQQLiveModule
{
  public abstract void a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, QQLiveBusinessObserver paramQQLiveBusinessObserver);
  
  public abstract void a(String paramString1, String paramString2, byte[] paramArrayOfByte, QQLiveBusinessObserver paramQQLiveBusinessObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule
 * JD-Core Version:    0.7.0.1
 */