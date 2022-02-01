package com.tencent.mobileqq.troop.essencemsg;

import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgPushItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class TroopEssenceMsgManager$5
  implements Runnable
{
  TroopEssenceMsgManager$5(TroopEssenceMsgManager paramTroopEssenceMsgManager) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.this$0.f.size())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleEssenceMsgGroupPushMain push holdMsg msgItem:");
      ((StringBuilder)localObject).append(((TroopEssenceMsgItem.TroopEssenceMsgPushItem)this.this$0.f.get(i)).toString());
      QLog.i("TroopEssenceMsgManager", 1, ((StringBuilder)localObject).toString());
      localObject = this.this$0;
      TroopEssenceMsgManager.a((TroopEssenceMsgManager)localObject, (TroopEssenceMsgItem.TroopEssenceMsgPushItem)((TroopEssenceMsgManager)localObject).f.get(i));
      i += 1;
    }
    this.this$0.f.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.5
 * JD-Core Version:    0.7.0.1
 */