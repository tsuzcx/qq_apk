package com.tencent.turingfd.sdk.xq;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class Orange
  extends Thread
{
  public Orange(Papaya paramPapaya, byte[] paramArrayOfByte, AtomicBoolean paramAtomicBoolean, AtomicReference paramAtomicReference, Object paramObject) {}
  
  public void run()
  {
    ??? = this.e.c.b();
    try
    {
      byte[] arrayOfByte = this.a;
      ??? = ((interface)???).a(3, arrayOfByte, 8120, 18120);
      break label48;
    }
    finally {}
    ??? = new catch.do(-100, new byte[0]);
    label48:
    if (this.b.get()) {
      return;
    }
    this.c.set(???);
    synchronized (this.d)
    {
      this.d.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Orange
 * JD-Core Version:    0.7.0.1
 */