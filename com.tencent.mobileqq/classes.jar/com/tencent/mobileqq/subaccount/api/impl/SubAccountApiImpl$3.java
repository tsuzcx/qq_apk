package com.tencent.mobileqq.subaccount.api.impl;

import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.SubAccountBindObserverInterface;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;

class SubAccountApiImpl$3
  extends SubAccountBindObserver
{
  SubAccountApiImpl$3(SubAccountApiImpl paramSubAccountApiImpl, ISubAccountApi.SubAccountBindObserverInterface paramSubAccountBindObserverInterface) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    ISubAccountApi.SubAccountBindObserverInterface localSubAccountBindObserverInterface = this.jdField_a_of_type_ComTencentMobileqqSubaccountApiISubAccountApi$SubAccountBindObserverInterface;
    boolean bool;
    if (paramSubAccountBackProtocData == null) {
      bool = true;
    } else {
      bool = false;
    }
    localSubAccountBindObserverInterface.a(paramBoolean, bool);
  }
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    ISubAccountApi.SubAccountBindObserverInterface localSubAccountBindObserverInterface = this.jdField_a_of_type_ComTencentMobileqqSubaccountApiISubAccountApi$SubAccountBindObserverInterface;
    boolean bool;
    if (paramSubAccountBackProtocData == null) {
      bool = true;
    } else {
      bool = false;
    }
    localSubAccountBindObserverInterface.b(paramBoolean, bool);
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    ISubAccountApi.SubAccountBindObserverInterface localSubAccountBindObserverInterface = this.jdField_a_of_type_ComTencentMobileqqSubaccountApiISubAccountApi$SubAccountBindObserverInterface;
    boolean bool;
    if (paramSubAccountBackProtocData == null) {
      bool = true;
    } else {
      bool = false;
    }
    localSubAccountBindObserverInterface.c(paramBoolean, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.impl.SubAccountApiImpl.3
 * JD-Core Version:    0.7.0.1
 */