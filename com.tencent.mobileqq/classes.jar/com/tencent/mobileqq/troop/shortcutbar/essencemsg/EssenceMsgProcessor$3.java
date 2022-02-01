package com.tencent.mobileqq.troop.shortcutbar.essencemsg;

import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemKey;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemValue;
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
    if (paramHashMap == null) {}
    label85:
    label86:
    for (;;)
    {
      return;
      paramLong = 0L;
      paramHashMap = paramHashMap.values().iterator();
      int i = 0;
      if (paramHashMap.hasNext())
      {
        TroopEssenceMsgItem.TroopEssenceMsgItemValue localTroopEssenceMsgItemValue = (TroopEssenceMsgItem.TroopEssenceMsgItemValue)paramHashMap.next();
        if ((localTroopEssenceMsgItemValue.jdField_a_of_type_Int != 1) || (paramLong >= localTroopEssenceMsgItemValue.jdField_a_of_type_Long)) {
          break label85;
        }
        paramLong = localTroopEssenceMsgItemValue.jdField_a_of_type_Long;
        i = 1;
      }
      for (;;)
      {
        break;
        if (i == 0) {
          break label86;
        }
        EssenceMsgProcessor.a(this.a, paramLong);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.essencemsg.EssenceMsgProcessor.3
 * JD-Core Version:    0.7.0.1
 */