package com.tencent.mobileqq.troop.essencemsg;

import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem.TroopEssenceMsgPushItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class TroopEssenceMsgManager$5
  implements Runnable
{
  TroopEssenceMsgManager$5(TroopEssenceMsgManager paramTroopEssenceMsgManager) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.this$0.a.size())
    {
      QLog.i("TroopEssenceMsgManager", 1, "handleEssenceMsgGroupPushMain push holdMsg msgItem:" + ((TroopEssenceMsgItem.TroopEssenceMsgPushItem)this.this$0.a.get(i)).toString());
      TroopEssenceMsgManager.a(this.this$0, (TroopEssenceMsgItem.TroopEssenceMsgPushItem)this.this$0.a.get(i));
      i += 1;
    }
    this.this$0.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.5
 * JD-Core Version:    0.7.0.1
 */