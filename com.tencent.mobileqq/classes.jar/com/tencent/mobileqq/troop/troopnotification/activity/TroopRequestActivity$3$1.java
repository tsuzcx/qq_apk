package com.tencent.mobileqq.troop.troopnotification.activity;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;

class TroopRequestActivity$3$1
  implements Runnable
{
  TroopRequestActivity$3$1(TroopRequestActivity.3 param3, Card paramCard) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationActivityTroopRequestActivity$3.this$0.isFinishing()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
      TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationActivityTroopRequestActivity$3.this$0, this.jdField_a_of_type_ComTencentMobileqqDataCard);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataCard;
    if ((localObject == null) || (((Card)localObject).iQQLevel <= 0))
    {
      localObject = (IProfileProtocolService)TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationActivityTroopRequestActivity$3.this$0).getRuntimeService(IProfileProtocolService.class, "");
      if (localObject != null)
      {
        byte b = (byte)TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationActivityTroopRequestActivity$3.this$0.getApplication(), TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationActivityTroopRequestActivity$3.this$0).getCurrentAccountUin());
        ((IProfileProtocolService)localObject).requestProfileCard(TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationActivityTroopRequestActivity$3.this$0).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationActivityTroopRequestActivity$3.this$0.b, 1, 0L, (byte)1, 0L, 0L, new byte[] { 0 }, "", 1L, 10004, new byte[] { 0 }, b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.3.1
 * JD-Core Version:    0.7.0.1
 */