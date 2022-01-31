package com.tencent.mobileqq.onlinestatus;

import android.content.res.Resources;
import avyo;
import avyw;
import awaf;
import awar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

public class AccountPanel$18$1
  implements Runnable
{
  public AccountPanel$18$1(avyw paramavyw, boolean paramBoolean, AppRuntime.Status paramStatus) {}
  
  public void run()
  {
    long l;
    if (this.jdField_a_of_type_Boolean)
    {
      l = awaf.a().a(avyo.a(this.jdField_a_of_type_Avyw.a));
      if ((avyo.a(this.jdField_a_of_type_Avyw.a) != 1000L) || (l != 1000L)) {
        break label197;
      }
    }
    label197:
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (avyo.c(this.jdField_a_of_type_Avyw.a)))
      {
        String str = awaf.a().a(l, this.jdField_a_of_type_MqqAppAppRuntime$Status);
        str = avyo.a(this.jdField_a_of_type_Avyw.a).getResources().getString(2131698752, new Object[] { str });
        QQToast.a(avyo.a(this.jdField_a_of_type_Avyw.a), 2, str, 1).a();
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "Show toast in account panel mAccountObserver");
        }
      }
      awar.a().a(avyo.a(this.jdField_a_of_type_Avyw.a), l);
      avyo.a(this.jdField_a_of_type_Avyw.a, l);
      return;
      QQToast.a(avyo.a(this.jdField_a_of_type_Avyw.a), 1, 2131698743, 1).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.18.1
 * JD-Core Version:    0.7.0.1
 */