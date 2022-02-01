package com.tencent.mobileqq.onlinestatus;

import android.content.res.Resources;
import aymu;
import aynd;
import ayox;
import aysz;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.onlinestatus.view.AutoStatusHintFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

public class AccountPanel$18$1
  implements Runnable
{
  public AccountPanel$18$1(aynd paramaynd, boolean paramBoolean, AppRuntime.Status paramStatus) {}
  
  public void run()
  {
    long l;
    if (this.jdField_a_of_type_Boolean)
    {
      l = ayox.a().a(aymu.a(this.jdField_a_of_type_Aynd.a));
      if ((aymu.a(this.jdField_a_of_type_Aynd.a) != 1000L) || (l != 1000L)) {
        break label296;
      }
    }
    label296:
    for (int i = 0;; i = 1)
    {
      int j = i;
      if (aymu.a(this.jdField_a_of_type_Aynd.a) == 1040L)
      {
        j = i;
        if (l == 1040L) {
          j = 0;
        }
      }
      if (l == 40001L) {
        j = 0;
      }
      if (!aymu.b(this.jdField_a_of_type_Aynd.a))
      {
        aymu.c(this.jdField_a_of_type_Aynd.a, true);
        if (l == 40001L) {
          AutoStatusHintFragment.a(aymu.a(this.jdField_a_of_type_Aynd.a));
        }
      }
      if ((j != 0) && (aymu.a(this.jdField_a_of_type_Aynd.a)))
      {
        String str = ayox.a().a(l, this.jdField_a_of_type_MqqAppAppRuntime$Status);
        str = aymu.a(this.jdField_a_of_type_Aynd.a).getResources().getString(2131697654, new Object[] { str });
        QQToast.a(aymu.a(this.jdField_a_of_type_Aynd.a), 2, str, 1).a();
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "Show toast in account panel onSetOnlineStatus");
        }
      }
      aysz.a().a(aymu.a(this.jdField_a_of_type_Aynd.a), l);
      aymu.a(this.jdField_a_of_type_Aynd.a, l);
      for (;;)
      {
        this.jdField_a_of_type_Aynd.a.c();
        return;
        QQToast.a(aymu.a(this.jdField_a_of_type_Aynd.a), 1, 2131697641, 1).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.18.1
 * JD-Core Version:    0.7.0.1
 */