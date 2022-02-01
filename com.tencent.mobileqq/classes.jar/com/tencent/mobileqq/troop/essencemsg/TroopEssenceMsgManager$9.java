package com.tencent.mobileqq.troop.essencemsg;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class TroopEssenceMsgManager$9
  implements Runnable
{
  TroopEssenceMsgManager$9(TroopEssenceMsgManager paramTroopEssenceMsgManager, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    TroopEssenceMsgManager.a(this.this$0).getMessageFacade().b(String.valueOf(this.a), 1, this.b);
    ThreadManager.getUIHandler().post(new TroopEssenceMsgManager.9.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.9
 * JD-Core Version:    0.7.0.1
 */