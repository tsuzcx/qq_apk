package com.tencent.qqprotect.qsec;

import java.util.concurrent.atomic.AtomicInteger;

public class RundownProtection
{
  private AtomicInteger a = new AtomicInteger(0);
  
  public boolean a()
  {
    int i;
    do
    {
      i = this.a.get();
      if ((i & 0x1) != 0) {
        return false;
      }
    } while (!this.a.compareAndSet(i, i + 2));
    return true;
  }
  
  public void b()
  {
    int i;
    do
    {
      i = this.a.get();
      if ((i & 0xFFFFFFFE) == 0) {
        return;
      }
      if ((i & 0x1) != 0)
      {
        if ((this.a.addAndGet(-2) & 0xFFFFFFFE) != 0) {
          break;
        }
        synchronized (this.a)
        {
          this.a.notifyAll();
          return;
        }
      }
    } while (!this.a.compareAndSet(i, i - 2));
  }
  
  public void c()
  {
    if (this.a.compareAndSet(0, 1)) {
      return;
    }
    if (this.a.compareAndSet(1, 1)) {
      return;
    }
    int i;
    do
    {
      i = this.a.get();
    } while (!this.a.compareAndSet(i, i | 0x1));
    try
    {
      synchronized (this.a)
      {
        this.a.wait();
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
      return;
    }
    for (;;)
    {
      throw localInterruptedException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.RundownProtection
 * JD-Core Version:    0.7.0.1
 */