package com.tencent.mobileqq.troop.data;

import azqs;
import bbrh;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.AccountDetail;
import syb;

public class TroopEntranceBar$1
  implements Runnable
{
  public TroopEntranceBar$1(bbrh parambbrh) {}
  
  public void run()
  {
    String str1 = "";
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      String str2 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      AccountDetail localAccountDetail = syb.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
      if (localAccountDetail != null) {
        str1 = localAccountDetail.uin;
      }
      azqs.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "interest_data", "exp_tribechat_aio", 0, 0, str2, str1, "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopEntranceBar.1
 * JD-Core Version:    0.7.0.1
 */