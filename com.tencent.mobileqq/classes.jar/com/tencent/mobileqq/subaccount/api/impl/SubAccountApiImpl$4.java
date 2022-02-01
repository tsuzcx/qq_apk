package com.tencent.mobileqq.subaccount.api.impl;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.MessageObserverInterface;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.subaccount.logic.SubAccountThirdQQBackProtocData;

class SubAccountApiImpl$4
  extends MessageObserver
{
  SubAccountApiImpl$4(SubAccountApiImpl paramSubAccountApiImpl, ISubAccountApi.MessageObserverInterface paramMessageObserverInterface) {}
  
  public void onGetSubAccountMsg(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    ISubAccountApi.MessageObserverInterface localMessageObserverInterface = this.jdField_a_of_type_ComTencentMobileqqSubaccountApiISubAccountApi$MessageObserverInterface;
    boolean bool;
    if (paramSubAccountBackProtocData == null) {
      bool = true;
    } else {
      bool = false;
    }
    localMessageObserverInterface.a(paramBoolean, paramString, bool);
  }
  
  public void onSubAccountMsgNumConfirm(boolean paramBoolean, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqSubaccountApiISubAccountApi$MessageObserverInterface.a(paramBoolean, paramString1, paramString2);
  }
  
  public void onSubAccountThirdQQUnreadMsgNum(boolean paramBoolean, String paramString, SubAccountThirdQQBackProtocData paramSubAccountThirdQQBackProtocData)
  {
    ISubAccountApi.MessageObserverInterface localMessageObserverInterface = this.jdField_a_of_type_ComTencentMobileqqSubaccountApiISubAccountApi$MessageObserverInterface;
    boolean bool;
    if (paramSubAccountThirdQQBackProtocData == null) {
      bool = true;
    } else {
      bool = false;
    }
    localMessageObserverInterface.b(paramBoolean, paramString, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.impl.SubAccountApiImpl.4
 * JD-Core Version:    0.7.0.1
 */