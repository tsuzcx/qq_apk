package com.tencent.mobileqq.troop.shortcutbar.essencemsg;

import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemKey;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemValue;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.callbackInMainThread;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

class EssenceMsgProcessor$3
  implements TroopEssenceMsgManager.callbackInMainThread
{
  EssenceMsgProcessor$3(EssenceMsgProcessor paramEssenceMsgProcessor) {}
  
  public void a(long paramLong, HashMap<TroopEssenceMsgItem.TroopEssenceMsgItemKey, TroopEssenceMsgItem.TroopEssenceMsgItemValue> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    paramLong = 0L;
    int i = 0;
    paramHashMap = paramHashMap.values().iterator();
    while (paramHashMap.hasNext())
    {
      TroopEssenceMsgItem.TroopEssenceMsgItemValue localTroopEssenceMsgItemValue = (TroopEssenceMsgItem.TroopEssenceMsgItemValue)paramHashMap.next();
      if ((localTroopEssenceMsgItemValue.jdField_a_of_type_Int == 1) && (paramLong < localTroopEssenceMsgItemValue.jdField_a_of_type_Long))
      {
        paramLong = localTroopEssenceMsgItemValue.jdField_a_of_type_Long;
        i = 1;
      }
    }
    if (i != 0) {
      EssenceMsgProcessor.a(this.a, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.essencemsg.EssenceMsgProcessor.3
 * JD-Core Version:    0.7.0.1
 */