package com.tencent.mobileqq.troop.essencemsg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class TroopEssenceMsgManager$13$1
  implements Runnable
{
  TroopEssenceMsgManager$13$1(TroopEssenceMsgManager.13 param13, HashMap paramHashMap) {}
  
  public void run()
  {
    this.b.this$0.d.put(Long.valueOf(this.b.a), this.a);
    Object localObject = (ArrayList)this.b.this$0.e.get(Long.valueOf(this.b.a));
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TroopEssenceMsgManager.callbackInMainThread)((Iterator)localObject).next()).a(this.b.a, this.a);
      }
      this.b.this$0.e.remove(Long.valueOf(this.b.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.13.1
 * JD-Core Version:    0.7.0.1
 */