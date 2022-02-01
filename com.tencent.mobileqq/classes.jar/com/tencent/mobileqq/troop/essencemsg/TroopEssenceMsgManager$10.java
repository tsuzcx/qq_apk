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

class TroopEssenceMsgManager$10
  implements TroopEssenceMsgManager.callbackInMainThread
{
  TroopEssenceMsgManager$10(TroopEssenceMsgManager paramTroopEssenceMsgManager, TroopEssenceMsgItem paramTroopEssenceMsgItem) {}
  
  public void a(long paramLong, HashMap<TroopEssenceMsgItem.TroopEssenceMsgItemKey, TroopEssenceMsgItem.TroopEssenceMsgItemValue> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    TroopEssenceMsgItem.TroopEssenceMsgItemKey localTroopEssenceMsgItemKey = new TroopEssenceMsgItem.TroopEssenceMsgItemKey(this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem.msgSeq, this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem.msgRandom);
    TroopEssenceMsgItem.TroopEssenceMsgItemValue localTroopEssenceMsgItemValue1 = new TroopEssenceMsgItem.TroopEssenceMsgItemValue(this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem.opType, this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem.msgSenderUin, this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem.opUin, this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem.opTime, this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem.graytipuniseq);
    QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosByPush msgInfo:" + this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem.toString());
    TroopEssenceMsgItem.TroopEssenceMsgItemValue localTroopEssenceMsgItemValue2 = (TroopEssenceMsgItem.TroopEssenceMsgItemValue)paramHashMap.get(localTroopEssenceMsgItemKey);
    if ((localTroopEssenceMsgItemValue2 != null) && (localTroopEssenceMsgItemValue1.a <= localTroopEssenceMsgItemValue2.a))
    {
      QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosByPush oldValue.opTime:" + localTroopEssenceMsgItemValue2.a);
      return;
    }
    paramHashMap.put(localTroopEssenceMsgItemKey, localTroopEssenceMsgItemValue1);
    TroopEssenceMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager, paramLong);
    this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager.a(new TroopEssenceMsgItem(localTroopEssenceMsgItemKey, localTroopEssenceMsgItemValue1));
    ((TroopHandler)TroopEssenceMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).notifyUI(TroopNotificationConstants.cd, true, Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.10
 * JD-Core Version:    0.7.0.1
 */