package com.tencent.mobileqq.troop.essencemsg;

import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem.TroopBatchEssenceMsgPushItem;
import java.util.ArrayList;

class TroopEssenceMsgManager$8$1
  implements Runnable
{
  TroopEssenceMsgManager$8$1(TroopEssenceMsgManager.8 param8, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject = TroopEssenceUtil.a(TroopEssenceMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager$8.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager), this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager$8.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem$TroopBatchEssenceMsgPushItem);
    if (localObject != null) {
      UniteGrayTipUtil.a(TroopEssenceMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager$8.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager), (MessageForUniteGrayTip)localObject);
    }
    localObject = this.jdField_a_of_type_JavaUtilArrayList;
    TroopEssenceMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager$8.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager$8.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem$TroopBatchEssenceMsgPushItem.a, (ArrayList)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.8.1
 * JD-Core Version:    0.7.0.1
 */