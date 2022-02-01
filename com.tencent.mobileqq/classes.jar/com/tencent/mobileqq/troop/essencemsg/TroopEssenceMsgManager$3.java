package com.tencent.mobileqq.troop.essencemsg;

import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemKey;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemValue;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class TroopEssenceMsgManager$3
  implements TroopEssenceMsgManager.callbackInMainThread
{
  TroopEssenceMsgManager$3(TroopEssenceMsgManager paramTroopEssenceMsgManager, TroopEssenceMsgItem.TroopEssenceMsgItemKey paramTroopEssenceMsgItemKey) {}
  
  public void a(long paramLong, HashMap<TroopEssenceMsgItem.TroopEssenceMsgItemKey, TroopEssenceMsgItem.TroopEssenceMsgItemValue> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    paramHashMap = (TroopEssenceMsgItem.TroopEssenceMsgItemValue)paramHashMap.get(this.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem$TroopEssenceMsgItemKey);
    if ((paramHashMap != null) && (paramHashMap.a == 1))
    {
      if (QLog.isColorLevel())
      {
        paramHashMap = new StringBuilder();
        paramHashMap.append("isEssenceMsg refreshAio key:");
        paramHashMap.append(paramLong);
        QLog.i("TroopEssenceMsgManager", 2, paramHashMap.toString());
      }
      TroopEssenceMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.3
 * JD-Core Version:    0.7.0.1
 */