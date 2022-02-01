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
    TroopEssenceMsgItem.TroopEssenceMsgItemKey localTroopEssenceMsgItemKey = new TroopEssenceMsgItem.TroopEssenceMsgItemKey(this.a.troopUin, this.a.msgSeq, this.a.msgRandom);
    TroopEssenceMsgItem.TroopEssenceMsgItemValue localTroopEssenceMsgItemValue = new TroopEssenceMsgItem.TroopEssenceMsgItemValue(this.a.opType, this.a.msgSenderUin, this.a.opUin, this.a.opTime, this.a.graytipuniseq);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateEssenceMsgInfosByPush msgInfo:");
    ((StringBuilder)localObject).append(this.a.toString());
    QLog.i("TroopEssenceMsgManager", 1, ((StringBuilder)localObject).toString());
    localObject = (TroopEssenceMsgItem.TroopEssenceMsgItemValue)paramHashMap.get(localTroopEssenceMsgItemKey);
    if ((localObject != null) && (localTroopEssenceMsgItemValue.d <= ((TroopEssenceMsgItem.TroopEssenceMsgItemValue)localObject).d))
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("updateEssenceMsgInfosByPush oldValue.opTime:");
      paramHashMap.append(((TroopEssenceMsgItem.TroopEssenceMsgItemValue)localObject).d);
      QLog.i("TroopEssenceMsgManager", 1, paramHashMap.toString());
      return;
    }
    paramHashMap.put(localTroopEssenceMsgItemKey, localTroopEssenceMsgItemValue);
    TroopEssenceMsgManager.a(this.b, paramLong);
    this.b.a(new TroopEssenceMsgItem(localTroopEssenceMsgItemKey, localTroopEssenceMsgItemValue));
    TroopEssenceMsgManager.a(this.b).getBusinessHandler(BusinessHandlerFactory.TROOP_ESSENCE_MSG_HANDLER).notifyUI(TroopEssenceMsgObserver.g, true, Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.10
 * JD-Core Version:    0.7.0.1
 */