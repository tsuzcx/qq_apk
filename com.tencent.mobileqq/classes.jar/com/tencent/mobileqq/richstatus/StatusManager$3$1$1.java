package com.tencent.mobileqq.richstatus;

import java.util.Iterator;
import java.util.LinkedList;

class StatusManager$3$1$1
  implements Runnable
{
  StatusManager$3$1$1(StatusManager.3.1 param1, int paramInt, RichStatus paramRichStatus, TipsInfo paramTipsInfo) {}
  
  public void run()
  {
    if (StatusManager.i(this.d.c.a) != null)
    {
      Iterator localIterator = StatusManager.i(this.d.c.a).iterator();
      while (localIterator.hasNext()) {
        ((IStatusListener)localIterator.next()).a(this.a, this.b, this.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager.3.1.1
 * JD-Core Version:    0.7.0.1
 */