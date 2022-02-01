package com.tencent.open.model;

import android.os.Bundle;
import java.lang.ref.WeakReference;
import mqq.observer.SSOAccountObserver;

class AccountManage$1
  implements Runnable
{
  AccountManage$1(AccountManage paramAccountManage, WeakReference paramWeakReference, String paramString1, String paramString2, Bundle paramBundle) {}
  
  public void run()
  {
    SSOAccountObserver localSSOAccountObserver = (SSOAccountObserver)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localSSOAccountObserver != null) {
      localSSOAccountObserver.onGetTicketNoPasswd(this.jdField_a_of_type_JavaLangString, this.b.getBytes(), 4096, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.model.AccountManage.1
 * JD-Core Version:    0.7.0.1
 */