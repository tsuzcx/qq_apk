package com.tencent.mobileqq.subaccount.api.impl;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.MessageObserverCallback;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.subaccount.logic.SubAccountThirdQQBackProtocData;

class SubAccountApiImpl$5
  extends MessageObserver
{
  SubAccountApiImpl$5(SubAccountApiImpl paramSubAccountApiImpl, ISubAccountApi.MessageObserverCallback paramMessageObserverCallback) {}
  
  public void onGetSubAccountMsg(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    this.a.a(paramBoolean, paramString, paramSubAccountBackProtocData);
  }
  
  public void onPushSubAccountMsg(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    this.a.b(paramBoolean, paramString, paramSubAccountBackProtocData);
  }
  
  public void onSubAccountMsgNumConfirm(boolean paramBoolean, String paramString1, String paramString2)
  {
    this.a.a(paramBoolean, paramString1, paramString2);
  }
  
  public void onSubAccountThirdQQUnreadMsgNum(boolean paramBoolean, String paramString, SubAccountThirdQQBackProtocData paramSubAccountThirdQQBackProtocData)
  {
    this.a.a(paramBoolean, paramString, paramSubAccountThirdQQBackProtocData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.impl.SubAccountApiImpl.5
 * JD-Core Version:    0.7.0.1
 */