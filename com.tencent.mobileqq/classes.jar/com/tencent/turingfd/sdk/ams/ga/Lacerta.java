package com.tencent.turingfd.sdk.ams.ga;

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
      ??? = this.this$0.b((IBinder)this.Vd.get());
    }
    catch (Throwable localThrowable1)
    {
      label21:
      label64:
      label97:
      break label21;
    }
    this.Te.set(Integer.valueOf(-102));
    ??? = "";
    this.Ue.set(???);
    try
    {
      this.od.unbindService((ServiceConnection)this.Wd.get());
    }
    catch (Throwable localThrowable2)
    {
      break label64;
    }
    this.Te.set(Integer.valueOf(-103));
    try
    {
      synchronized (this.Ve)
      {
        this.Ve.notifyAll();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Lacerta
 * JD-Core Version:    0.7.0.1
 */