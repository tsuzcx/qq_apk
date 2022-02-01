package com.tencent.mobileqq.troop.essencemsg;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemKey;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemValue;
import com.tencent.mobileqq.troop.observer.TroopEssenceMsgObserver;
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
    TroopEssenceMsgItem.TroopEssenceMsgItemKey localTroopEssenceMsgItemKey = new TroopEssenceMsgItem.TroopEssenceMsgItemKey(this.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem.msgSeq, this.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem.msgRandom);
    TroopEssenceMsgItem.TroopEssenceMsgItemValue localTroopEssenceMsgItemValue = new TroopEssenceMsgItem.TroopEssenceMsgItemValue(this.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem.opType, this.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem.msgSenderUin, this.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem.opUin, this.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem.opTime, this.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem.graytipuniseq);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateEssenceMsgInfosByPush msgInfo:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem.toString());
    QLog.i("TroopEssenceMsgManager", 1, ((StringBuilder)localObject).toString());
    localObject = (TroopEssenceMsgItem.TroopEssenceMsgItemValue)paramHashMap.get(localTroopEssenceMsgItemKey);
    if ((localObject != null) && (localTroopEssenceMsgItemValue.a <= ((TroopEssenceMsgItem.TroopEssenceMsgItemValue)localObject).a))
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("updateEssenceMsgInfosByPush oldValue.opTime:");
      paramHashMap.append(((TroopEssenceMsgItem.TroopEssenceMsgItemValue)localObject).a);
      QLog.i("TroopEssenceMsgManager", 1, paramHashMap.toString());
      return;
    }
    paramHashMap.put(localTroopEssenceMsgItemKey, localTroopEssenceMsgItemValue);
    TroopEssenceMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager, paramLong);
    this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager.a(new TroopEssenceMsgItem(localTroopEssenceMsgItemKey, localTroopEssenceMsgItemValue));
    TroopEssenceMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager).getBusinessHandler(BusinessHandlerFactory.TROOP_ESSENCE_MSG_HANDLER).notifyUI(TroopEssenceMsgObserver.f, true, Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.10
 * JD-Core Version:    0.7.0.1
 */