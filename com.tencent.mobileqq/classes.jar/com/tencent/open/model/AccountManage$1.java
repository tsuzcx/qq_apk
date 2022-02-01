package com.tencent.open.model;

import android.os.Bundle;
import bjpm;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.SSOAccountObserver;

public class AccountManage$1
  implements Runnable
{
  public AccountManage$1(bjpm parambjpm, WeakReference paramWeakReference, String paramString1, String paramString2, Bundle paramBundle) {}
  
  public void run()
  {
    SSOAccountObserver localSSOAccountObserver = (SSOAccountObserver)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localSSOAccountObserver != null)
    {
      localSSOAccountObserver.onGetTicketNoPasswd(this.jdField_a_of_type_JavaLangString, this.b.getBytes(), 4096, this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    QLog.d("open_log", 1, "delegateGetTicketNoPasswd observer1 == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.model.AccountManage.1
 * JD-Core Version:    0.7.0.1
 */