package com.tencent.mobileqq.onlinestatus;

import android.content.res.Resources;
import axsv;
import axtd;
import axuy;
import axys;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

public class AccountPanel$17$1
  implements Runnable
{
  public AccountPanel$17$1(axtd paramaxtd, boolean paramBoolean, AppRuntime.Status paramStatus) {}
  
  public void run()
  {
    long l;
    if (this.jdField_a_of_type_Boolean)
    {
      l = axuy.a().a(axsv.a(this.jdField_a_of_type_Axtd.a));
      if ((axsv.a(this.jdField_a_of_type_Axtd.a) != 1000L) || (l != 1000L)) {
        break label219;
      }
    }
    label219:
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (axsv.a(this.jdField_a_of_type_Axtd.a)))
      {
        String str = axuy.a().a(l, this.jdField_a_of_type_MqqAppAppRuntime$Status);
        str = axsv.a(this.jdField_a_of_type_Axtd.a).getResources().getString(2131697884, new Object[] { str });
        QQToast.a(axsv.a(this.jdField_a_of_type_Axtd.a), 2, str, 1).a();
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "Show toast in account panel mAccountObserver");
        }
      }
      axsv.a(this.jdField_a_of_type_Axtd.a);
      axys.a().a(axsv.a(this.jdField_a_of_type_Axtd.a), l);
      axsv.a(this.jdField_a_of_type_Axtd.a, l);
      for (;;)
      {
        this.jdField_a_of_type_Axtd.a.c();
        return;
        QQToast.a(axsv.a(this.jdField_a_of_type_Axtd.a), 1, 2131697871, 1).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.17.1
 * JD-Core Version:    0.7.0.1
 */