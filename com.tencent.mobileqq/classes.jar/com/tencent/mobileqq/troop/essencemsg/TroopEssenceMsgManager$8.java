package com.tencent.mobileqq.troop.essencemsg;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopBatchEssenceMsgPushItem;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemKey;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.os.MqqHandler;

class TroopEssenceMsgManager$8
  implements TroopEssenceMsgManager.callbackInMainThread
{
  TroopEssenceMsgManager$8(TroopEssenceMsgManager paramTroopEssenceMsgManager, TroopEssenceMsgItem.TroopBatchEssenceMsgPushItem paramTroopBatchEssenceMsgPushItem) {}
  
  public void a(long paramLong, HashMap<TroopEssenceMsgItem.TroopEssenceMsgItemKey, TroopEssenceMsgItem.TroopEssenceMsgItemValue> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    paramHashMap = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem$TroopBatchEssenceMsgPushItem.a.iterator();
    while (localIterator.hasNext())
    {
      TroopEssenceMsgItem localTroopEssenceMsgItem = (TroopEssenceMsgItem)localIterator.next();
      if ((localTroopEssenceMsgItem != null) && (TroopEssenceMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager, localTroopEssenceMsgItem))) {
        paramHashMap.add(localTroopEssenceMsgItem);
      }
    }
    ThreadManager.getUIHandler().post(new TroopEssenceMsgManager.8.1(this, paramHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.8
 * JD-Core Version:    0.7.0.1
 */