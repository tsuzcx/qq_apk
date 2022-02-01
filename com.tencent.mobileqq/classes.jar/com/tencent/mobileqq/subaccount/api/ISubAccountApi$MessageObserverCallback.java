package com.tencent.mobileqq.subaccount.api;

import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.subaccount.logic.SubAccountThirdQQBackProtocData;

public abstract interface ISubAccountApi$MessageObserverCallback
{
  public abstract void a(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData);
  
  public abstract void a(boolean paramBoolean, String paramString, SubAccountThirdQQBackProtocData paramSubAccountThirdQQBackProtocData);
  
  public abstract void a(boolean paramBoolean, String paramString1, String paramString2);
  
  public abstract void b(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.ISubAccountApi.MessageObserverCallback
 * JD-Core Version:    0.7.0.1
 */