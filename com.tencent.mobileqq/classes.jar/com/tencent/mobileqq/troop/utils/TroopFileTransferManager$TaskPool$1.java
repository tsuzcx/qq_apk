package com.tencent.mobileqq.troop.utils;

import bfbv;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class TroopFileTransferManager$TaskPool$1
  implements Runnable
{
  public TroopFileTransferManager$TaskPool$1(bfbv parambfbv) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      for (;;)
      {
        if (this.this$0.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
        {
          this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
          return;
        }
        TroopFileTransferManager.Task localTask = (TroopFileTransferManager.Task)this.this$0.jdField_a_of_type_JavaUtilLinkedList.remove(0);
        localTask.run();
        if (localTask.a != 0) {
          continue;
        }
        try
        {
          Thread.sleep(200L);
        }
        catch (InterruptedException localInterruptedException) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskPool.1
 * JD-Core Version:    0.7.0.1
 */