package com.tencent.mobileqq.onlinestatus;

import auhf;
import auib;
import bcpw;
import java.util.List;

public class AccountOnlineStateActivity$4$1
  implements Runnable
{
  public AccountOnlineStateActivity$4$1(auhf paramauhf, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      if (AccountOnlineStateActivity.a(this.jdField_a_of_type_Auhf.a) != null) {
        AccountOnlineStateActivity.a(this.jdField_a_of_type_Auhf.a).a(this.jdField_a_of_type_JavaUtilList);
      }
    }
    while (AccountOnlineStateActivity.a(this.jdField_a_of_type_Auhf.a) == null) {
      return;
    }
    bcpw.a(AccountOnlineStateActivity.a(this.jdField_a_of_type_Auhf.a), 1, 2131690307, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity.4.1
 * JD-Core Version:    0.7.0.1
 */