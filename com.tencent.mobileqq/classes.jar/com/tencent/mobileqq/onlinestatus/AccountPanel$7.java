package com.tencent.mobileqq.onlinestatus;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.qphone.base.remote.SimpleAccount;

class AccountPanel$7
  implements Runnable
{
  AccountPanel$7(AccountPanel paramAccountPanel, QQAppInterface paramQQAppInterface, SimpleAccount paramSimpleAccount) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().c(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin(), 7000);
    SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null, this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.7
 * JD-Core Version:    0.7.0.1
 */