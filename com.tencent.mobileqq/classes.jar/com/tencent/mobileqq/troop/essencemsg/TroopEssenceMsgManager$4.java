package com.tencent.mobileqq.troop.essencemsg;

import bedy;
import bedz;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class TroopEssenceMsgManager$4
  implements Runnable
{
  public TroopEssenceMsgManager$4(bedz parambedz) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.this$0.a.size())
    {
      QLog.i("TroopEssenceMsgManager", 1, "handleEssenceMsgGroupPushMain push holdMsg msgItem:" + ((bedy)this.this$0.a.get(i)).toString());
      bedz.a(this.this$0, (bedy)this.this$0.a.get(i));
      i += 1;
    }
    this.this$0.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.4
 * JD-Core Version:    0.7.0.1
 */