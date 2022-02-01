package com.tencent.mobileqq.onlinestatus;

import android.content.res.Resources;
import azfn;
import azfw;
import azhq;
import azlk;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.onlinestatus.view.AutoStatusHintFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

public class AccountPanel$18$1
  implements Runnable
{
  public AccountPanel$18$1(azfw paramazfw, boolean paramBoolean, AppRuntime.Status paramStatus) {}
  
  public void run()
  {
    long l;
    if (this.jdField_a_of_type_Boolean)
    {
      l = azhq.a().a(azfn.a(this.jdField_a_of_type_Azfw.a));
      if ((azfn.a(this.jdField_a_of_type_Azfw.a) != 1000L) || (l != 1000L)) {
        break label296;
      }
    }
    label296:
    for (int i = 0;; i = 1)
    {
      int j = i;
      if (azfn.a(this.jdField_a_of_type_Azfw.a) == 1040L)
      {
        j = i;
        if (l == 1040L) {
          j = 0;
        }
      }
      if (l == 40001L) {
        j = 0;
      }
      if (!azfn.b(this.jdField_a_of_type_Azfw.a))
      {
        azfn.c(this.jdField_a_of_type_Azfw.a, true);
        if (l == 40001L) {
          AutoStatusHintFragment.a(azfn.a(this.jdField_a_of_type_Azfw.a));
        }
      }
      if ((j != 0) && (azfn.a(this.jdField_a_of_type_Azfw.a)))
      {
        String str = azhq.a().a(l, this.jdField_a_of_type_MqqAppAppRuntime$Status);
        str = azfn.a(this.jdField_a_of_type_Azfw.a).getResources().getString(2131697738, new Object[] { str });
        QQToast.a(azfn.a(this.jdField_a_of_type_Azfw.a), 2, str, 1).a();
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "Show toast in account panel onSetOnlineStatus");
        }
      }
      azlk.a().a(azfn.a(this.jdField_a_of_type_Azfw.a), l);
      azfn.a(this.jdField_a_of_type_Azfw.a, l);
      for (;;)
      {
        this.jdField_a_of_type_Azfw.a.c();
        return;
        QQToast.a(azfn.a(this.jdField_a_of_type_Azfw.a), 1, 2131697725, 1).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.18.1
 * JD-Core Version:    0.7.0.1
 */