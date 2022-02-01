package com.tencent.mobileqq.onlinestatus;

import android.content.res.Resources;
import aymu;
import aync;
import ayox;
import aysz;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

public class AccountPanel$17$1
  implements Runnable
{
  public AccountPanel$17$1(aync paramaync, boolean paramBoolean, AppRuntime.Status paramStatus) {}
  
  public void run()
  {
    long l;
    if (this.jdField_a_of_type_Boolean)
    {
      l = ayox.a().a(aymu.a(this.jdField_a_of_type_Aync.a));
      if ((aymu.a(this.jdField_a_of_type_Aync.a) != 1000L) || (l != 1000L)) {
        break label219;
      }
    }
    label219:
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (aymu.a(this.jdField_a_of_type_Aync.a)))
      {
        String str = ayox.a().a(l, this.jdField_a_of_type_MqqAppAppRuntime$Status);
        str = aymu.a(this.jdField_a_of_type_Aync.a).getResources().getString(2131697654, new Object[] { str });
        QQToast.a(aymu.a(this.jdField_a_of_type_Aync.a), 2, str, 1).a();
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "Show toast in account panel mAccountObserver");
        }
      }
      aymu.a(this.jdField_a_of_type_Aync.a);
      aysz.a().a(aymu.a(this.jdField_a_of_type_Aync.a), l);
      aymu.a(this.jdField_a_of_type_Aync.a, l);
      for (;;)
      {
        this.jdField_a_of_type_Aync.a.c();
        return;
        QQToast.a(aymu.a(this.jdField_a_of_type_Aync.a), 1, 2131697641, 1).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.17.1
 * JD-Core Version:    0.7.0.1
 */