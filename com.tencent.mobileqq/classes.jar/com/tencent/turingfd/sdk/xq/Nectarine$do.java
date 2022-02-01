package com.tencent.turingfd.sdk.xq;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.atomic.AtomicReference;

public class Nectarine$do
  implements ServiceConnection
{
  public Nectarine$do(AtomicReference paramAtomicReference, long paramLong, Object paramObject) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    new Nectarine.do.do(this, paramIBinder).start();
  }
  
  public void onServiceDisconnected(ComponentName arg1)
  {
    this.a.set(Mango.b(-2004));
    synchronized (this.c)
    {
      this.c.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Nectarine.do
 * JD-Core Version:    0.7.0.1
 */