package com.tencent.mobileqq.troop.essencemsg;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

class TroopEssenceMsgManager$13
  implements Runnable
{
  TroopEssenceMsgManager$13(TroopEssenceMsgManager paramTroopEssenceMsgManager, long paramLong) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    HashMap localHashMap = this.this$0.c(this.a);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("readEntity costTime");
      localStringBuilder.append(System.currentTimeMillis() - l);
      QLog.i("TroopEssenceMsgManager", 2, localStringBuilder.toString());
    }
    ThreadManager.getUIHandler().post(new TroopEssenceMsgManager.13.1(this, localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.13
 * JD-Core Version:    0.7.0.1
 */