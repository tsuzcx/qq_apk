package com.tencent.mobileqq.onlinestatus;

import atjg;
import atkc;
import bbmy;
import java.util.List;

public class AccountOnlineStateActivity$4$1
  implements Runnable
{
  public AccountOnlineStateActivity$4$1(atjg paramatjg, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      if (AccountOnlineStateActivity.a(this.jdField_a_of_type_Atjg.a) != null) {
        AccountOnlineStateActivity.a(this.jdField_a_of_type_Atjg.a).a(this.jdField_a_of_type_JavaUtilList);
      }
    }
    while (AccountOnlineStateActivity.a(this.jdField_a_of_type_Atjg.a) == null) {
      return;
    }
    bbmy.a(AccountOnlineStateActivity.a(this.jdField_a_of_type_Atjg.a), 1, 2131624746, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity.4.1
 * JD-Core Version:    0.7.0.1
 */