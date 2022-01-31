package com.tencent.mobileqq.onlinestatus;

import awcu;
import awdp;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class AccountOnlineStateActivity$4$1
  implements Runnable
{
  public AccountOnlineStateActivity$4$1(awcu paramawcu, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      if (AccountOnlineStateActivity.a(this.jdField_a_of_type_Awcu.a) != null) {
        AccountOnlineStateActivity.a(this.jdField_a_of_type_Awcu.a).a(this.jdField_a_of_type_JavaUtilList);
      }
    }
    while (AccountOnlineStateActivity.a(this.jdField_a_of_type_Awcu.a) == null) {
      return;
    }
    QQToast.a(AccountOnlineStateActivity.a(this.jdField_a_of_type_Awcu.a), 1, 2131690358, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity.4.1
 * JD-Core Version:    0.7.0.1
 */