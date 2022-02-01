package com.tencent.mobileqq.onlinestatus;

import android.content.res.Resources;
import ayzg;
import ayzp;
import azbj;
import azfe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.onlinestatus.view.AutoStatusHintFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

public class AccountPanel$18$1
  implements Runnable
{
  public AccountPanel$18$1(ayzp paramayzp, boolean paramBoolean, AppRuntime.Status paramStatus) {}
  
  public void run()
  {
    long l;
    if (this.jdField_a_of_type_Boolean)
    {
      l = azbj.a().a(ayzg.a(this.jdField_a_of_type_Ayzp.a));
      if ((ayzg.a(this.jdField_a_of_type_Ayzp.a) != 1000L) || (l != 1000L)) {
        break label296;
      }
    }
    label296:
    for (int i = 0;; i = 1)
    {
      int j = i;
      if (ayzg.a(this.jdField_a_of_type_Ayzp.a) == 1040L)
      {
        j = i;
        if (l == 1040L) {
          j = 0;
        }
      }
      if (l == 40001L) {
        j = 0;
      }
      if (!ayzg.b(this.jdField_a_of_type_Ayzp.a))
      {
        ayzg.c(this.jdField_a_of_type_Ayzp.a, true);
        if (l == 40001L) {
          AutoStatusHintFragment.a(ayzg.a(this.jdField_a_of_type_Ayzp.a));
        }
      }
      if ((j != 0) && (ayzg.a(this.jdField_a_of_type_Ayzp.a)))
      {
        String str = azbj.a().a(l, this.jdField_a_of_type_MqqAppAppRuntime$Status);
        str = ayzg.a(this.jdField_a_of_type_Ayzp.a).getResources().getString(2131698167, new Object[] { str });
        QQToast.a(ayzg.a(this.jdField_a_of_type_Ayzp.a), 2, str, 1).a();
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "Show toast in account panel onSetOnlineStatus");
        }
      }
      azfe.a().a(ayzg.a(this.jdField_a_of_type_Ayzp.a), l);
      ayzg.a(this.jdField_a_of_type_Ayzp.a, l);
      for (;;)
      {
        this.jdField_a_of_type_Ayzp.a.c();
        return;
        QQToast.a(ayzg.a(this.jdField_a_of_type_Ayzp.a), 1, 2131698154, 1).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.18.1
 * JD-Core Version:    0.7.0.1
 */