package com.tencent.mobileqq.onlinestatus;

import android.content.res.Resources;
import awcx;
import awdf;
import aweo;
import awfa;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

public class AccountPanel$18$1
  implements Runnable
{
  public AccountPanel$18$1(awdf paramawdf, boolean paramBoolean, AppRuntime.Status paramStatus) {}
  
  public void run()
  {
    long l;
    if (this.jdField_a_of_type_Boolean)
    {
      l = aweo.a().a(awcx.a(this.jdField_a_of_type_Awdf.a));
      if ((awcx.a(this.jdField_a_of_type_Awdf.a) != 1000L) || (l != 1000L)) {
        break label197;
      }
    }
    label197:
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (awcx.c(this.jdField_a_of_type_Awdf.a)))
      {
        String str = aweo.a().a(l, this.jdField_a_of_type_MqqAppAppRuntime$Status);
        str = awcx.a(this.jdField_a_of_type_Awdf.a).getResources().getString(2131698764, new Object[] { str });
        QQToast.a(awcx.a(this.jdField_a_of_type_Awdf.a), 2, str, 1).a();
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "Show toast in account panel mAccountObserver");
        }
      }
      awfa.a().a(awcx.a(this.jdField_a_of_type_Awdf.a), l);
      awcx.a(this.jdField_a_of_type_Awdf.a, l);
      return;
      QQToast.a(awcx.a(this.jdField_a_of_type_Awdf.a), 1, 2131698755, 1).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.18.1
 * JD-Core Version:    0.7.0.1
 */