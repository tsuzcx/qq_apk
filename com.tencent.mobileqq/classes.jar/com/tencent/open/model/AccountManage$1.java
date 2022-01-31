package com.tencent.open.model;

import android.os.Bundle;
import bdnb;
import java.lang.ref.WeakReference;
import mqq.observer.SSOAccountObserver;

public class AccountManage$1
  implements Runnable
{
  public AccountManage$1(bdnb parambdnb, WeakReference paramWeakReference, String paramString1, String paramString2, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    SSOAccountObserver localSSOAccountObserver = (SSOAccountObserver)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localSSOAccountObserver != null) {
      localSSOAccountObserver.onGetTicketNoPasswd(this.jdField_a_of_type_JavaLangString, this.b.getBytes(), this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.model.AccountManage.1
 * JD-Core Version:    0.7.0.1
 */