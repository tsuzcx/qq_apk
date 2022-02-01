package com.tencent.mobileqq.troop.data;

import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;

class TroopEntranceBar$1
  implements Runnable
{
  TroopEntranceBar$1(TroopEntranceBar paramTroopEntranceBar) {}
  
  public void run()
  {
    String str1 = "";
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      String str2 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      AccountDetail localAccountDetail = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).queryAccountDetail(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
      if (localAccountDetail != null) {
        str1 = localAccountDetail.uin;
      }
      ReportController.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "interest_data", "exp_tribechat_aio", 0, 0, str2, str1, "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopEntranceBar.1
 * JD-Core Version:    0.7.0.1
 */