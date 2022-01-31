package com.tencent.mobileqq.utils;

import bdno;
import bdnp;
import java.util.ArrayList;
import java.util.Iterator;

class SyncLoadTask$1$1
  implements Runnable
{
  SyncLoadTask$1$1(SyncLoadTask.1 param1, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bdno)localIterator.next()).setComplete(true);
    }
    localIterator = this.b.iterator();
    for (boolean bool = true; localIterator.hasNext(); bool = false) {
      ((bdno)localIterator.next()).setComplete(false);
    }
    this.this$0.a.a(bool, this.this$0.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SyncLoadTask.1.1
 * JD-Core Version:    0.7.0.1
 */