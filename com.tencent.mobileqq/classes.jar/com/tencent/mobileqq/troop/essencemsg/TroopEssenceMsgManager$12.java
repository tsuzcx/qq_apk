package com.tencent.mobileqq.troop.essencemsg;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemKey;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemValue;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class TroopEssenceMsgManager$12
  implements TroopEssenceMsgManager.callbackInMainThread
{
  TroopEssenceMsgManager$12(TroopEssenceMsgManager paramTroopEssenceMsgManager, ArrayList paramArrayList) {}
  
  public void a(long paramLong, HashMap<TroopEssenceMsgItem.TroopEssenceMsgItemKey, TroopEssenceMsgItem.TroopEssenceMsgItemValue> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (TroopEssenceMsgItem)localIterator.next();
      if (localObject != null)
      {
        TroopEssenceMsgItem.TroopEssenceMsgItemKey localTroopEssenceMsgItemKey = new TroopEssenceMsgItem.TroopEssenceMsgItemKey(((TroopEssenceMsgItem)localObject).troopUin, ((TroopEssenceMsgItem)localObject).msgSeq, ((TroopEssenceMsgItem)localObject).msgRandom);
        TroopEssenceMsgItem.TroopEssenceMsgItemValue localTroopEssenceMsgItemValue = (TroopEssenceMsgItem.TroopEssenceMsgItemValue)paramHashMap.get(localTroopEssenceMsgItemKey);
        if (localTroopEssenceMsgItemValue != null)
        {
          if (localTroopEssenceMsgItemValue.jdField_a_of_type_Int == ((TroopEssenceMsgItem)localObject).opType)
          {
            QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosByBatchSet 本地已经存在且状态一致 直接丢弃");
            QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosByBatchSet key:" + localTroopEssenceMsgItemKey.toString() + " oldValue:" + localTroopEssenceMsgItemValue.toString());
            return;
          }
          if (((TroopEssenceMsgItem)localObject).opTime == 0L) {
            ((TroopEssenceMsgItem)localObject).opTime = localTroopEssenceMsgItemValue.jdField_a_of_type_Long;
          }
          ((TroopEssenceMsgItem)localObject).graytipuniseq = localTroopEssenceMsgItemValue.b;
        }
        localObject = new TroopEssenceMsgItem.TroopEssenceMsgItemValue(((TroopEssenceMsgItem)localObject).opType, ((TroopEssenceMsgItem)localObject).msgSenderUin, ((TroopEssenceMsgItem)localObject).opUin, ((TroopEssenceMsgItem)localObject).opTime, ((TroopEssenceMsgItem)localObject).graytipuniseq);
        paramHashMap.put(localTroopEssenceMsgItemKey, localObject);
        QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosByBatchSet key:" + localTroopEssenceMsgItemKey.toString() + " value:" + ((TroopEssenceMsgItem.TroopEssenceMsgItemValue)localObject).toString());
        this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager.a(new TroopEssenceMsgItem(localTroopEssenceMsgItemKey, (TroopEssenceMsgItem.TroopEssenceMsgItemValue)localObject));
      }
    }
    TroopEssenceMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager, paramLong);
    ((TroopHandler)TroopEssenceMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).notifyUI(TroopNotificationConstants.cd, true, Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.12
 * JD-Core Version:    0.7.0.1
 */