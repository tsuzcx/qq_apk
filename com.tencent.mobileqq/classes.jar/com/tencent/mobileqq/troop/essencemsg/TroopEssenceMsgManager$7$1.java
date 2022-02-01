package com.tencent.mobileqq.troop.essencemsg;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgPushItem;
import mqq.os.MqqHandler;

class TroopEssenceMsgManager$7$1
  implements Runnable
{
  TroopEssenceMsgManager$7$1(TroopEssenceMsgManager.7 param7) {}
  
  public void run()
  {
    long l = this.a.a.a.troopUin;
    this.a.a.d = TroopEssenceUtil.a(TroopEssenceMsgManager.a(this.a.b), String.valueOf(l), String.valueOf(this.a.a.a.msgSenderUin), this.a.a.d);
    ThreadManager.getUIHandler().post(new TroopEssenceMsgManager.7.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.7.1
 * JD-Core Version:    0.7.0.1
 */