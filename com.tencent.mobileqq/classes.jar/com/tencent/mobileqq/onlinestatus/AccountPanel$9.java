package com.tencent.mobileqq.onlinestatus;

import awcx;
import bacu;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.SimpleAccount;

public class AccountPanel$9
  implements Runnable
{
  public AccountPanel$9(awcx paramawcx, QQAppInterface paramQQAppInterface, SimpleAccount paramSimpleAccount) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin(), 7000);
    bacu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null, this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.9
 * JD-Core Version:    0.7.0.1
 */