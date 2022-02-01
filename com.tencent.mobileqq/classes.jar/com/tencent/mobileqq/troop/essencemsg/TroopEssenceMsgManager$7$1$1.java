package com.tencent.mobileqq.troop.essencemsg;

import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem.TroopEssenceMsgPushItem;
import com.tencent.qphone.base.util.QLog;

class TroopEssenceMsgManager$7$1$1
  implements Runnable
{
  TroopEssenceMsgManager$7$1$1(TroopEssenceMsgManager.7.1 param1) {}
  
  public void run()
  {
    if (TroopEssenceMsgManager.a(this.a.a.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager, this.a.a.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem$TroopEssenceMsgPushItem.a))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopEssenceMsgManager", 2, "AddEssenceMsgGrayTip");
      }
      TroopEssenceMsgManager.b(this.a.a.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager, this.a.a.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem$TroopEssenceMsgPushItem);
      MessageForUniteGrayTip localMessageForUniteGrayTip = TroopEssenceUtil.a(TroopEssenceMsgManager.a(this.a.a.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager), this.a.a.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem$TroopEssenceMsgPushItem);
      if (localMessageForUniteGrayTip != null)
      {
        UniteGrayTipUtil.a(TroopEssenceMsgManager.a(this.a.a.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager), localMessageForUniteGrayTip);
        this.a.a.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem$TroopEssenceMsgPushItem.a.graytipuniseq = localMessageForUniteGrayTip.uniseq;
      }
    }
    TroopEssenceMsgManager.a(this.a.a.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager, this.a.a.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem$TroopEssenceMsgPushItem.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.7.1.1
 * JD-Core Version:    0.7.0.1
 */