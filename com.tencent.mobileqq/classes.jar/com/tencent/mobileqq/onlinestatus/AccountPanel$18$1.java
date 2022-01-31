package com.tencent.mobileqq.onlinestatus;

import android.content.res.Resources;
import auhi;
import auhr;
import auja;
import bcpw;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

public class AccountPanel$18$1
  implements Runnable
{
  public AccountPanel$18$1(auhr paramauhr, boolean paramBoolean, AppRuntime.Status paramStatus) {}
  
  public void run()
  {
    long l;
    if (this.jdField_a_of_type_Boolean)
    {
      l = auja.a().a(auhi.a(this.jdField_a_of_type_Auhr.a));
      if ((auhi.a(this.jdField_a_of_type_Auhr.a) != 1000L) || (l != 1000L)) {
        break label180;
      }
    }
    label180:
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (auhi.c(this.jdField_a_of_type_Auhr.a)))
      {
        String str = auja.a().a(l, this.jdField_a_of_type_MqqAppAppRuntime$Status);
        str = auhi.a(this.jdField_a_of_type_Auhr.a).getResources().getString(2131698447, new Object[] { str });
        bcpw.a(auhi.a(this.jdField_a_of_type_Auhr.a), 2, str, 1).a();
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "Show toast in account panel mAccountObserver");
        }
      }
      auhi.a(this.jdField_a_of_type_Auhr.a, l);
      return;
      bcpw.a(auhi.a(this.jdField_a_of_type_Auhr.a), 1, 2131698442, 1).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.18.1
 * JD-Core Version:    0.7.0.1
 */