package com.tencent.mobileqq.onlinestatus;

import android.content.res.Resources;
import axsv;
import axte;
import axuy;
import axys;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.onlinestatus.view.AutoStatusHintFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

public class AccountPanel$18$1
  implements Runnable
{
  public AccountPanel$18$1(axte paramaxte, boolean paramBoolean, AppRuntime.Status paramStatus) {}
  
  public void run()
  {
    long l;
    if (this.jdField_a_of_type_Boolean)
    {
      l = axuy.a().a(axsv.a(this.jdField_a_of_type_Axte.a));
      if ((axsv.a(this.jdField_a_of_type_Axte.a) != 1000L) || (l != 1000L)) {
        break label296;
      }
    }
    label296:
    for (int i = 0;; i = 1)
    {
      int j = i;
      if (axsv.a(this.jdField_a_of_type_Axte.a) == 1040L)
      {
        j = i;
        if (l == 1040L) {
          j = 0;
        }
      }
      if (l == 40001L) {
        j = 0;
      }
      if (!axsv.b(this.jdField_a_of_type_Axte.a))
      {
        axsv.c(this.jdField_a_of_type_Axte.a, true);
        if (l == 40001L) {
          AutoStatusHintFragment.a(axsv.a(this.jdField_a_of_type_Axte.a));
        }
      }
      if ((j != 0) && (axsv.a(this.jdField_a_of_type_Axte.a)))
      {
        String str = axuy.a().a(l, this.jdField_a_of_type_MqqAppAppRuntime$Status);
        str = axsv.a(this.jdField_a_of_type_Axte.a).getResources().getString(2131697884, new Object[] { str });
        QQToast.a(axsv.a(this.jdField_a_of_type_Axte.a), 2, str, 1).a();
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "Show toast in account panel onSetOnlineStatus");
        }
      }
      axys.a().a(axsv.a(this.jdField_a_of_type_Axte.a), l);
      axsv.a(this.jdField_a_of_type_Axte.a, l);
      for (;;)
      {
        this.jdField_a_of_type_Axte.a.c();
        return;
        QQToast.a(axsv.a(this.jdField_a_of_type_Axte.a), 1, 2131697871, 1).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.18.1
 * JD-Core Version:    0.7.0.1
 */