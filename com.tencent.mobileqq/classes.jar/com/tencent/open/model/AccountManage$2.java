package com.tencent.open.model;

import android.os.Bundle;
import mqq.observer.SSOAccountObserver;

class AccountManage$2
  implements Runnable
{
  AccountManage$2(AccountManage paramAccountManage, SSOAccountObserver paramSSOAccountObserver, String paramString1, String paramString2, Bundle paramBundle) {}
  
  public void run()
  {
    this.jdField_a_of_type_MqqObserverSSOAccountObserver.onGetTicketNoPasswd(this.jdField_a_of_type_JavaLangString, this.b.getBytes(), 4096, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.model.AccountManage.2
 * JD-Core Version:    0.7.0.1
 */