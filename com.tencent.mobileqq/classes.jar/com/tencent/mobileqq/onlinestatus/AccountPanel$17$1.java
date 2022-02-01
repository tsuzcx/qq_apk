package com.tencent.mobileqq.onlinestatus;

import android.content.res.Resources;
import ayzg;
import ayzo;
import azbj;
import azfe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

public class AccountPanel$17$1
  implements Runnable
{
  public AccountPanel$17$1(ayzo paramayzo, boolean paramBoolean, AppRuntime.Status paramStatus) {}
  
  public void run()
  {
    long l;
    if (this.jdField_a_of_type_Boolean)
    {
      l = azbj.a().a(ayzg.a(this.jdField_a_of_type_Ayzo.a));
      if ((ayzg.a(this.jdField_a_of_type_Ayzo.a) != 1000L) || (l != 1000L)) {
        break label219;
      }
    }
    label219:
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (ayzg.a(this.jdField_a_of_type_Ayzo.a)))
      {
        String str = azbj.a().a(l, this.jdField_a_of_type_MqqAppAppRuntime$Status);
        str = ayzg.a(this.jdField_a_of_type_Ayzo.a).getResources().getString(2131698167, new Object[] { str });
        QQToast.a(ayzg.a(this.jdField_a_of_type_Ayzo.a), 2, str, 1).a();
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "Show toast in account panel mAccountObserver");
        }
      }
      ayzg.a(this.jdField_a_of_type_Ayzo.a);
      azfe.a().a(ayzg.a(this.jdField_a_of_type_Ayzo.a), l);
      ayzg.a(this.jdField_a_of_type_Ayzo.a, l);
      for (;;)
      {
        this.jdField_a_of_type_Ayzo.a.c();
        return;
        QQToast.a(ayzg.a(this.jdField_a_of_type_Ayzo.a), 1, 2131698154, 1).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.17.1
 * JD-Core Version:    0.7.0.1
 */