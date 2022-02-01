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

class TroopEssenceMsgManager$11
  implements TroopEssenceMsgManager.callbackInMainThread
{
  TroopEssenceMsgManager$11(TroopEssenceMsgManager paramTroopEssenceMsgManager, TroopEssenceMsgItem paramTroopEssenceMsgItem) {}
  
  public void a(long paramLong, HashMap<TroopEssenceMsgItem.TroopEssenceMsgItemKey, TroopEssenceMsgItem.TroopEssenceMsgItemValue> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    TroopEssenceMsgItem.TroopEssenceMsgItemKey localTroopEssenceMsgItemKey = new TroopEssenceMsgItem.TroopEssenceMsgItemKey(this.a.troopUin, this.a.msgSeq, this.a.msgRandom);
    TroopEssenceMsgItem.TroopEssenceMsgItemValue localTroopEssenceMsgItemValue = (TroopEssenceMsgItem.TroopEssenceMsgItemValue)paramHashMap.get(localTroopEssenceMsgItemKey);
    if (localTroopEssenceMsgItemValue != null)
    {
      if (localTroopEssenceMsgItemValue.a == this.a.opType)
      {
        QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosBySet 本地已经存在且状态一致 直接丢弃");
        paramHashMap = new StringBuilder();
        paramHashMap.append("updateEssenceMsgInfosBySet key:");
        paramHashMap.append(localTroopEssenceMsgItemKey.toString());
        paramHashMap.append(" oldValue:");
        paramHashMap.append(localTroopEssenceMsgItemValue.toString());
        QLog.i("TroopEssenceMsgManager", 1, paramHashMap.toString());
        return;
      }
      if (this.a.opTime == 0L) {
        this.a.opTime = localTroopEssenceMsgItemValue.d;
      }
      this.a.graytipuniseq = localTroopEssenceMsgItemValue.e;
    }
    localTroopEssenceMsgItemValue = new TroopEssenceMsgItem.TroopEssenceMsgItemValue(this.a.opType, this.a.msgSenderUin, this.a.opUin, this.a.opTime, this.a.graytipuniseq);
    paramHashMap.put(localTroopEssenceMsgItemKey, localTroopEssenceMsgItemValue);
    paramHashMap = new StringBuilder();
    paramHashMap.append("updateEssenceMsgInfosBySet key:");
    paramHashMap.append(localTroopEssenceMsgItemKey.toString());
    paramHashMap.append(" value:");
    paramHashMap.append(localTroopEssenceMsgItemValue.toString());
    QLog.i("TroopEssenceMsgManager", 1, paramHashMap.toString());
    TroopEssenceMsgManager.a(this.b, this.a.troopUin);
    this.b.a(new TroopEssenceMsgItem(localTroopEssenceMsgItemKey, localTroopEssenceMsgItemValue));
    TroopEssenceMsgManager.a(this.b).getBusinessHandler(BusinessHandlerFactory.TROOP_ESSENCE_MSG_HANDLER).notifyUI(TroopEssenceMsgObserver.g, true, Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.11
 * JD-Core Version:    0.7.0.1
 */