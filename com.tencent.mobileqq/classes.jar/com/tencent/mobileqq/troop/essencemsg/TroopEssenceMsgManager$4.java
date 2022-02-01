package com.tencent.mobileqq.troop.essencemsg;

import bflb;
import bflc;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class TroopEssenceMsgManager$4
  implements Runnable
{
  public TroopEssenceMsgManager$4(bflc parambflc) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.this$0.a.size())
    {
      QLog.i("TroopEssenceMsgManager", 1, "handleEssenceMsgGroupPushMain push holdMsg msgItem:" + ((bflb)this.this$0.a.get(i)).toString());
      bflc.a(this.this$0, (bflb)this.this$0.a.get(i));
      i += 1;
    }
    this.this$0.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.4
 * JD-Core Version:    0.7.0.1
 */