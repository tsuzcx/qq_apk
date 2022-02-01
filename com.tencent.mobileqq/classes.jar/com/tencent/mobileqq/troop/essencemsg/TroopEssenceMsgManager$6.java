package com.tencent.mobileqq.troop.essencemsg;

import bfuo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class TroopEssenceMsgManager$6
  implements Runnable
{
  public TroopEssenceMsgManager$6(bfuo parambfuo, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    bfuo.a(this.this$0).a().b(String.valueOf(this.a), 1, this.b);
    ThreadManager.getUIHandler().post(new TroopEssenceMsgManager.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.6
 * JD-Core Version:    0.7.0.1
 */