package com.tencent.mobileqq.richstatus;

import java.util.Iterator;
import java.util.LinkedList;

class StatusManager$3$2$1
  implements Runnable
{
  StatusManager$3$2$1(StatusManager.3.2 param2) {}
  
  public void run()
  {
    if (StatusManager.i(this.a.b.a) != null)
    {
      Iterator localIterator = StatusManager.i(this.a.b.a).iterator();
      while (localIterator.hasNext())
      {
        IStatusListener localIStatusListener = (IStatusListener)localIterator.next();
        int i;
        if (this.a.a) {
          i = 100;
        } else {
          i = -1;
        }
        localIStatusListener.a(i, RichStatus.getEmptyStatus(), null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager.3.2.1
 * JD-Core Version:    0.7.0.1
 */