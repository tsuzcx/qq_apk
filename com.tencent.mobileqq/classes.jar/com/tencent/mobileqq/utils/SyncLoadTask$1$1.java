package com.tencent.mobileqq.utils;

import java.util.ArrayList;
import java.util.Iterator;

class SyncLoadTask$1$1
  implements Runnable
{
  SyncLoadTask$1$1(SyncLoadTask.1 param1, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    boolean bool1;
    for (;;)
    {
      boolean bool2 = localIterator.hasNext();
      bool1 = true;
      if (!bool2) {
        break;
      }
      ((SyncLoadTask)localIterator.next()).setComplete(true);
    }
    localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      ((SyncLoadTask)localIterator.next()).setComplete(false);
      bool1 = false;
    }
    this.this$0.c.a(bool1, this.this$0.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SyncLoadTask.1.1
 * JD-Core Version:    0.7.0.1
 */