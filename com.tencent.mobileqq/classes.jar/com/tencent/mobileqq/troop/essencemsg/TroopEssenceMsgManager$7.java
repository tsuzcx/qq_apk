package com.tencent.mobileqq.troop.essencemsg;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemKey;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemValue;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgPushItem;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class TroopEssenceMsgManager$7
  implements TroopEssenceMsgManager.callbackInMainThread
{
  TroopEssenceMsgManager$7(TroopEssenceMsgManager paramTroopEssenceMsgManager, TroopEssenceMsgItem.TroopEssenceMsgPushItem paramTroopEssenceMsgPushItem) {}
  
  public void a(long paramLong, HashMap<TroopEssenceMsgItem.TroopEssenceMsgItemKey, TroopEssenceMsgItem.TroopEssenceMsgItemValue> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem$TroopEssenceMsgPushItem.a.opType == 1)
    {
      if (!TroopEssenceMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager, this.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem$TroopEssenceMsgPushItem.a))
      {
        paramHashMap = new StringBuilder();
        paramHashMap.append("AddEssenceMsgGrayTip repeat msgItem:");
        paramHashMap.append(this.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem$TroopEssenceMsgPushItem.toString());
        QLog.i("TroopEssenceMsgManager", 1, paramHashMap.toString());
        TroopEssenceMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager, this.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem$TroopEssenceMsgPushItem.a);
        return;
      }
      ThreadManager.excute(new TroopEssenceMsgManager.7.1(this), 32, null, true);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem$TroopEssenceMsgPushItem.a.opType == 2)
    {
      if (TroopEssenceMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager, this.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem$TroopEssenceMsgPushItem.a)) {
        TroopEssenceMsgManager.b(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager, this.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem$TroopEssenceMsgPushItem);
      }
      TroopEssenceMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager, this.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem$TroopEssenceMsgPushItem.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.7
 * JD-Core Version:    0.7.0.1
 */