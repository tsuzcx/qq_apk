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
    this.jdField_a_of_type_ComTencentMobileqqSubaccountApiISubAccountApi$MessageObserverCallback.a(paramBoolean, paramString, paramSubAccountBackProtocData);
  }
  
  public void onPushSubAccountMsg(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    this.jdField_a_of_type_ComTencentMobileqqSubaccountApiISubAccountApi$MessageObserverCallback.b(paramBoolean, paramString, paramSubAccountBackProtocData);
  }
  
  public void onSubAccountMsgNumConfirm(boolean paramBoolean, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqSubaccountApiISubAccountApi$MessageObserverCallback.a(paramBoolean, paramString1, paramString2);
  }
  
  public void onSubAccountThirdQQUnreadMsgNum(boolean paramBoolean, String paramString, SubAccountThirdQQBackProtocData paramSubAccountThirdQQBackProtocData)
  {
    this.jdField_a_of_type_ComTencentMobileqqSubaccountApiISubAccountApi$MessageObserverCallback.a(paramBoolean, paramString, paramSubAccountThirdQQBackProtocData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.impl.SubAccountApiImpl.5
 * JD-Core Version:    0.7.0.1
 */