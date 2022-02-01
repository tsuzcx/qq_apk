package com.tencent.mobileqq.onlinestatus;

import android.content.res.Resources;
import azfn;
import azfv;
import azhq;
import azlk;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

public class AccountPanel$17$1
  implements Runnable
{
  public AccountPanel$17$1(azfv paramazfv, boolean paramBoolean, AppRuntime.Status paramStatus) {}
  
  public void run()
  {
    long l;
    if (this.jdField_a_of_type_Boolean)
    {
      l = azhq.a().a(azfn.a(this.jdField_a_of_type_Azfv.a));
      if ((azfn.a(this.jdField_a_of_type_Azfv.a) != 1000L) || (l != 1000L)) {
        break label219;
      }
    }
    label219:
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (azfn.a(this.jdField_a_of_type_Azfv.a)))
      {
        String str = azhq.a().a(l, this.jdField_a_of_type_MqqAppAppRuntime$Status);
        str = azfn.a(this.jdField_a_of_type_Azfv.a).getResources().getString(2131697738, new Object[] { str });
        QQToast.a(azfn.a(this.jdField_a_of_type_Azfv.a), 2, str, 1).a();
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "Show toast in account panel mAccountObserver");
        }
      }
      azfn.a(this.jdField_a_of_type_Azfv.a);
      azlk.a().a(azfn.a(this.jdField_a_of_type_Azfv.a), l);
      azfn.a(this.jdField_a_of_type_Azfv.a, l);
      for (;;)
      {
        this.jdField_a_of_type_Azfv.a.c();
        return;
        QQToast.a(azfn.a(this.jdField_a_of_type_Azfv.a), 1, 2131697725, 1).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.17.1
 * JD-Core Version:    0.7.0.1
 */