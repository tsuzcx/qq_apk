package com.tencent.mobileqq.troop.utils.api.impl;

import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BizTroopDBUtilsApiImpl$LimitQueuedRunnablePool
  implements ThreadExcutor.IThreadListener
{
  ConcurrentLinkedQueue<Runnable> a = new ConcurrentLinkedQueue();
  private int b;
  private int c;
  private int d;
  
  public BizTroopDBUtilsApiImpl$LimitQueuedRunnablePool(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.d = paramInt2;
    this.c = 0;
  }
  
  public void a()
  {
    if (this.c < this.b)
    {
      Runnable localRunnable = (Runnable)this.a.poll();
      if (localRunnable != null)
      {
        this.c += 1;
        ThreadManager.excute(localRunnable, this.d, this, false);
      }
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    this.a.offer(paramRunnable);
    a();
  }
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    this.c -= 1;
    a();
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.api.impl.BizTroopDBUtilsApiImpl.LimitQueuedRunnablePool
 * JD-Core Version:    0.7.0.1
 */