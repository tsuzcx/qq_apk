package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.atomic.AtomicReference;

public class Lacerta
  extends Thread
{
  public Lacerta(LeoMinor paramLeoMinor, AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2, AtomicReference paramAtomicReference3, Context paramContext, AtomicReference paramAtomicReference4, Object paramObject) {}
  
  public void run()
  {
    try
    {
      ??? = this.this$0.a((IBinder)this.Hd.get());
    }
    catch (Throwable localThrowable1)
    {
      label21:
      label64:
      label97:
      break label21;
    }
    this.rf.set(Integer.valueOf(-102));
    ??? = "";
    this.sf.set(???);
    try
    {
      this.Yc.unbindService((ServiceConnection)this.Id.get());
    }
    catch (Throwable localThrowable2)
    {
      break label64;
    }
    this.rf.set(Integer.valueOf(-103));
    try
    {
      synchronized (this.tf)
      {
        this.tf.notifyAll();
      }
    }
    catch (Throwable localThrowable3)
    {
      break label97;
    }
    return;
    throw localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.Lacerta
 * JD-Core Version:    0.7.0.1
 */