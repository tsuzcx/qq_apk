package com.tencent.mobileqq.troop.data;

import bdll;
import bfqz;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.AccountDetail;
import tzq;

public class TroopEntranceBar$1
  implements Runnable
{
  public TroopEntranceBar$1(bfqz parambfqz) {}
  
  public void run()
  {
    String str1 = "";
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      String str2 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      AccountDetail localAccountDetail = tzq.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
      if (localAccountDetail != null) {
        str1 = localAccountDetail.uin;
      }
      bdll.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "interest_data", "exp_tribechat_aio", 0, 0, str2, str1, "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopEntranceBar.1
 * JD-Core Version:    0.7.0.1
 */