package com.tencent.mobileqq.troop.essencemsg;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemKey;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemValue;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class TroopEssenceMsgManager$11
  implements TroopEssenceMsgManager.callbackInMainThread
{
  TroopEssenceMsgManager$11(TroopEssenceMsgManager paramTroopEssenceMsgManager, TroopEssenceMsgItem paramTroopEssenceMsgItem) {}
  
  public void a(long paramLong, HashMap<TroopEssenceMsgItem.TroopEssenceMsgItemKey, TroopEssenceMsgItem.TroopEssenceMsgItemValue> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    TroopEssenceMsgItem.TroopEssenceMsgItemKey localTroopEssenceMsgItemKey = new TroopEssenceMsgItem.TroopEssenceMsgItemKey(this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem.msgSeq, this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem.msgRandom);
    TroopEssenceMsgItem.TroopEssenceMsgItemValue localTroopEssenceMsgItemValue = (TroopEssenceMsgItem.TroopEssenceMsgItemValue)paramHashMap.get(localTroopEssenceMsgItemKey);
    if (localTroopEssenceMsgItemValue != null)
    {
      if (localTroopEssenceMsgItemValue.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem.opType)
      {
        QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosBySet 本地已经存在且状态一致 直接丢弃");
        QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosBySet key:" + localTroopEssenceMsgItemKey.toString() + " oldValue:" + localTroopEssenceMsgItemValue.toString());
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem.opTime == 0L) {
        this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem.opTime = localTroopEssenceMsgItemValue.jdField_a_of_type_Long;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem.graytipuniseq = localTroopEssenceMsgItemValue.b;
    }
    localTroopEssenceMsgItemValue = new TroopEssenceMsgItem.TroopEssenceMsgItemValue(this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem.opType, this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem.msgSenderUin, this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem.opUin, this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem.opTime, this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem.graytipuniseq);
    paramHashMap.put(localTroopEssenceMsgItemKey, localTroopEssenceMsgItemValue);
    QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosBySet key:" + localTroopEssenceMsgItemKey.toString() + " value:" + localTroopEssenceMsgItemValue.toString());
    TroopEssenceMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager, this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem.troopUin);
    this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager.a(new TroopEssenceMsgItem(localTroopEssenceMsgItemKey, localTroopEssenceMsgItemValue));
    ((TroopHandler)TroopEssenceMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).notifyUI(TroopNotificationConstants.cd, true, Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.11
 * JD-Core Version:    0.7.0.1
 */