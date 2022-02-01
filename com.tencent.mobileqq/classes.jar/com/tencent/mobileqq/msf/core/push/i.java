package com.tencent.mobileqq.msf.core.push;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.a.a;

class i
  extends Thread
{
  i(g paramg) {}
  
  public void run()
  {
    try
    {
      long l = a.D();
      if (l > 0L) {
        Thread.sleep(l);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    if (NetConnInfoCenter.isNetSupport()) {
      synchronized (this.a.z)
      {
        this.a.z.notify();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.push.i
 * JD-Core Version:    0.7.0.1
 */