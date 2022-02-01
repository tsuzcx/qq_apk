package com.tencent.mobileqq.troop.essencemsg;

import bflc;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class TroopEssenceMsgManager$9
  implements Runnable
{
  public TroopEssenceMsgManager$9(bflc parambflc, long paramLong) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    HashMap localHashMap = this.this$0.a(this.a);
    if (QLog.isColorLevel()) {
      QLog.i("TroopEssenceMsgManager", 2, "readEntity costTime" + (System.currentTimeMillis() - l));
    }
    ThreadManager.getUIHandler().post(new TroopEssenceMsgManager.9.1(this, localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.9
 * JD-Core Version:    0.7.0.1
 */