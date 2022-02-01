package com.tencent.turingfd.sdk.xq;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class Core
  extends Thread
{
  public Core(Cranberry paramCranberry, byte[] paramArrayOfByte, AtomicBoolean paramAtomicBoolean, AtomicReference paramAtomicReference, Object paramObject) {}
  
  public void run()
  {
    Object localObject3 = Cranberry.a(this.this$0).n();
    try
    {
      Object localObject1 = this.Cj;
      localObject3 = (throws)localObject3;
      localObject1 = ((throws)localObject3).a(3, (byte[])localObject1, 8120, 18120);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ??? = long.do.a(-100, new byte[0]);
      }
      this.Ej.set(???);
      synchronized (this.Fj)
      {
        this.Fj.notify();
        return;
      }
    }
    if (this.Dj.get()) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Core
 * JD-Core Version:    0.7.0.1
 */