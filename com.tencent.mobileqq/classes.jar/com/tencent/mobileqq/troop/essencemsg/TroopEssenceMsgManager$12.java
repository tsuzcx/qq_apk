package com.tencent.mobileqq.troop.essencemsg;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemKey;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemValue;
import com.tencent.mobileqq.troop.observer.TroopEssenceMsgObserver;
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
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (TroopEssenceMsgItem)localIterator.next();
      if (localObject != null)
      {
        TroopEssenceMsgItem.TroopEssenceMsgItemKey localTroopEssenceMsgItemKey = new TroopEssenceMsgItem.TroopEssenceMsgItemKey(((TroopEssenceMsgItem)localObject).troopUin, ((TroopEssenceMsgItem)localObject).msgSeq, ((TroopEssenceMsgItem)localObject).msgRandom);
        TroopEssenceMsgItem.TroopEssenceMsgItemValue localTroopEssenceMsgItemValue = (TroopEssenceMsgItem.TroopEssenceMsgItemValue)paramHashMap.get(localTroopEssenceMsgItemKey);
        if (localTroopEssenceMsgItemValue != null)
        {
          if (localTroopEssenceMsgItemValue.a == ((TroopEssenceMsgItem)localObject).opType)
          {
            QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosByBatchSet 本地已经存在且状态一致 直接丢弃");
            paramHashMap = new StringBuilder();
            paramHashMap.append("updateEssenceMsgInfosByBatchSet key:");
            paramHashMap.append(localTroopEssenceMsgItemKey.toString());
            paramHashMap.append(" oldValue:");
            paramHashMap.append(localTroopEssenceMsgItemValue.toString());
            QLog.i("TroopEssenceMsgManager", 1, paramHashMap.toString());
            return;
          }
          if (((TroopEssenceMsgItem)localObject).opTime == 0L) {
            ((TroopEssenceMsgItem)localObject).opTime = localTroopEssenceMsgItemValue.d;
          }
          ((TroopEssenceMsgItem)localObject).graytipuniseq = localTroopEssenceMsgItemValue.e;
        }
        localTroopEssenceMsgItemValue = new TroopEssenceMsgItem.TroopEssenceMsgItemValue(((TroopEssenceMsgItem)localObject).opType, ((TroopEssenceMsgItem)localObject).msgSenderUin, ((TroopEssenceMsgItem)localObject).opUin, ((TroopEssenceMsgItem)localObject).opTime, ((TroopEssenceMsgItem)localObject).graytipuniseq);
        paramHashMap.put(localTroopEssenceMsgItemKey, localTroopEssenceMsgItemValue);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateEssenceMsgInfosByBatchSet key:");
        ((StringBuilder)localObject).append(localTroopEssenceMsgItemKey.toString());
        ((StringBuilder)localObject).append(" value:");
        ((StringBuilder)localObject).append(localTroopEssenceMsgItemValue.toString());
        QLog.i("TroopEssenceMsgManager", 1, ((StringBuilder)localObject).toString());
        this.b.a(new TroopEssenceMsgItem(localTroopEssenceMsgItemKey, localTroopEssenceMsgItemValue));
      }
    }
    TroopEssenceMsgManager.a(this.b, paramLong);
    TroopEssenceMsgManager.a(this.b).getBusinessHandler(BusinessHandlerFactory.TROOP_ESSENCE_MSG_HANDLER).notifyUI(TroopEssenceMsgObserver.g, true, Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.12
 * JD-Core Version:    0.7.0.1
 */