package com.tencent.mobileqq.subaccount.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.subaccount.SubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.SubAccountObserver;

class SubAccountBindHandler$1
  extends SubAccountObserver
{
  SubAccountBindHandler$1(SubAccountBindHandler paramSubAccountBindHandler, SubAccountBackProtocData paramSubAccountBackProtocData, ISubAccountService paramISubAccountService, boolean paramBoolean) {}
  
  protected void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if ((paramString3 != null) && (paramString2 != null) && (paramString1 != null))
    {
      if ((SubAccountBindHandler.a(this.jdField_a_of_type_ComTencentMobileqqSubaccountApiImplSubAccountBindHandler) != null) && (paramString2.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqSubaccountLogicSubAccountBackProtocData.c)) && (paramString1.equalsIgnoreCase(SubAccountBindHandler.a(this.jdField_a_of_type_ComTencentMobileqqSubaccountApiImplSubAccountBindHandler).getAccount())))
      {
        this.jdField_a_of_type_ComTencentMobileqqSubaccountApiISubAccountService.updateA2(paramString2, paramString3, this.jdField_a_of_type_Boolean);
        SubAccountControllUtil.a(SubAccountBindHandler.a(this.jdField_a_of_type_ComTencentMobileqqSubaccountApiImplSubAccountBindHandler), (byte)1, paramString2);
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqSubaccountLogicSubAccountBackProtocData;
        paramString1.b = true;
        this.jdField_a_of_type_ComTencentMobileqqSubaccountApiImplSubAccountBindHandler.notifyUI(2, true, paramString1);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramString3 = new StringBuilder();
        paramString3.append("handlerGetBindSubAccount() onGetKeyBack error happen 1 ? =>app:");
        if (SubAccountBindHandler.a(this.jdField_a_of_type_ComTencentMobileqqSubaccountApiImplSubAccountBindHandler) == null) {
          bool1 = true;
        }
        paramString3.append(bool1);
        paramString3.append(" subUin:");
        paramString3.append(paramString2.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqSubaccountLogicSubAccountBackProtocData.c));
        paramString3.append(" mainAccount:");
        paramString3.append(paramString1.equalsIgnoreCase(SubAccountBindHandler.a(this.jdField_a_of_type_ComTencentMobileqqSubaccountApiImplSubAccountBindHandler).getAccount()));
        QLog.d("SUB_ACCOUNT", 2, paramString3.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqSubaccountApiImplSubAccountBindHandler.notifyUI(2, true, this.jdField_a_of_type_ComTencentMobileqqSubaccountLogicSubAccountBackProtocData);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handlerGetBindSubAccount() onGetKeyBack key is null or ? happen 0 ? =>");
      if (paramString3 == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localStringBuilder.append(bool1);
      if (paramString2 == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localStringBuilder.append(bool1);
      bool1 = bool2;
      if (paramString1 == null) {
        bool1 = true;
      }
      localStringBuilder.append(bool1);
      QLog.e("SUB_ACCOUNT", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqSubaccountApiImplSubAccountBindHandler.notifyUI(2, true, this.jdField_a_of_type_ComTencentMobileqqSubaccountLogicSubAccountBackProtocData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.impl.SubAccountBindHandler.1
 * JD-Core Version:    0.7.0.1
 */