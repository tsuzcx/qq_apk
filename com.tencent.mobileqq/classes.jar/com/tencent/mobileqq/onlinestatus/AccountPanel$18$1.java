package com.tencent.mobileqq.onlinestatus;

import android.content.res.Resources;
import auhk;
import auht;
import aujc;
import bcql;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

public class AccountPanel$18$1
  implements Runnable
{
  public AccountPanel$18$1(auht paramauht, boolean paramBoolean, AppRuntime.Status paramStatus) {}
  
  public void run()
  {
    long l;
    if (this.jdField_a_of_type_Boolean)
    {
      l = aujc.a().a(auhk.a(this.jdField_a_of_type_Auht.a));
      if ((auhk.a(this.jdField_a_of_type_Auht.a) != 1000L) || (l != 1000L)) {
        break label180;
      }
    }
    label180:
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (auhk.c(this.jdField_a_of_type_Auht.a)))
      {
        String str = aujc.a().a(l, this.jdField_a_of_type_MqqAppAppRuntime$Status);
        str = auhk.a(this.jdField_a_of_type_Auht.a).getResources().getString(2131698457, new Object[] { str });
        bcql.a(auhk.a(this.jdField_a_of_type_Auht.a), 2, str, 1).a();
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "Show toast in account panel mAccountObserver");
        }
      }
      auhk.a(this.jdField_a_of_type_Auht.a, l);
      return;
      bcql.a(auhk.a(this.jdField_a_of_type_Auht.a), 1, 2131698452, 1).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.18.1
 * JD-Core Version:    0.7.0.1
 */