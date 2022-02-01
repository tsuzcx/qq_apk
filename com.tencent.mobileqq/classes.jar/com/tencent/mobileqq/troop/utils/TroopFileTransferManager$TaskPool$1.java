package com.tencent.mobileqq.troop.utils;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

class TroopFileTransferManager$TaskPool$1
  implements Runnable
{
  TroopFileTransferManager$TaskPool$1(TroopFileTransferManager.TaskPool paramTaskPool) {}
  
  public void run()
  {
    for (;;)
    {
      synchronized (this.this$0)
      {
        if (this.this$0.c.isEmpty())
        {
          this.this$0.a.decrementAndGet();
          return;
        }
        TroopFileTransferManager.Task localTask = (TroopFileTransferManager.Task)this.this$0.c.remove(0);
        localTask.run();
        if (localTask.b != 0) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskPool.1
 * JD-Core Version:    0.7.0.1
 */