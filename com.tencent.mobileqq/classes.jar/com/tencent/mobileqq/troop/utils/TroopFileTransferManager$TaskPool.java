package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class TroopFileTransferManager$TaskPool
{
  public AtomicInteger a = new AtomicInteger();
  public int b;
  public LinkedList<TroopFileTransferManager.Task> c = new LinkedList();
  
  public TroopFileTransferManager$TaskPool(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(TroopFileTransferManager.Task paramTask)
  {
    try
    {
      this.c.add(paramTask);
      if (this.a.incrementAndGet() > this.b)
      {
        this.a.decrementAndGet();
        return;
      }
      ThreadManager.post(new TroopFileTransferManager.TaskPool.1(this), 5, null, true);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskPool
 * JD-Core Version:    0.7.0.1
 */