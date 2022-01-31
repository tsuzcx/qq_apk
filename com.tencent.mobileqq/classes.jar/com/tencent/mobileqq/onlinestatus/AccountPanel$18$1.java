package com.tencent.mobileqq.onlinestatus;

import android.content.res.Resources;
import atjj;
import atjs;
import atlb;
import bbmy;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.app.AppRuntime.Status;

public class AccountPanel$18$1
  implements Runnable
{
  public AccountPanel$18$1(atjs paramatjs, boolean paramBoolean, AppRuntime.Status paramStatus) {}
  
  public void run()
  {
    long l;
    if (this.jdField_a_of_type_Boolean)
    {
      l = atlb.a().a(atjj.a(this.jdField_a_of_type_Atjs.a));
      if ((atjj.a(this.jdField_a_of_type_Atjs.a) != 1000L) || (l != 1000L)) {
        break label153;
      }
    }
    label153:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        String str = atlb.a().a(l, this.jdField_a_of_type_MqqAppAppRuntime$Status);
        str = atjj.a(this.jdField_a_of_type_Atjs.a).getResources().getString(2131632711, new Object[] { str });
        bbmy.a(atjj.a(this.jdField_a_of_type_Atjs.a), 2, str, 1).a();
      }
      atjj.a(this.jdField_a_of_type_Atjs.a, l);
      return;
      bbmy.a(atjj.a(this.jdField_a_of_type_Atjs.a), 1, 2131632706, 1).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.18.1
 * JD-Core Version:    0.7.0.1
 */