package com.tencent.mobileqq.troop.essencemsg;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgPushItem;
import mqq.os.MqqHandler;

class TroopEssenceMsgManager$7$1
  implements Runnable
{
  TroopEssenceMsgManager$7$1(TroopEssenceMsgManager.7 param7) {}
  
  public void run()
  {
    long l = this.a.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem$TroopEssenceMsgPushItem.a.troopUin;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem$TroopEssenceMsgPushItem.b = TroopEssenceUtil.a(TroopEssenceMsgManager.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager), String.valueOf(l), String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem$TroopEssenceMsgPushItem.a.msgSenderUin), this.a.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem$TroopEssenceMsgPushItem.b);
    ThreadManager.getUIHandler().post(new TroopEssenceMsgManager.7.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.7.1
 * JD-Core Version:    0.7.0.1
 */