package com.tencent.mobileqq.onlinestatus;

import auhh;
import auid;
import bcql;
import java.util.List;

public class AccountOnlineStateActivity$4$1
  implements Runnable
{
  public AccountOnlineStateActivity$4$1(auhh paramauhh, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      if (AccountOnlineStateActivity.a(this.jdField_a_of_type_Auhh.a) != null) {
        AccountOnlineStateActivity.a(this.jdField_a_of_type_Auhh.a).a(this.jdField_a_of_type_JavaUtilList);
      }
    }
    while (AccountOnlineStateActivity.a(this.jdField_a_of_type_Auhh.a) == null) {
      return;
    }
    bcql.a(AccountOnlineStateActivity.a(this.jdField_a_of_type_Auhh.a), 1, 2131690307, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity.4.1
 * JD-Core Version:    0.7.0.1
 */