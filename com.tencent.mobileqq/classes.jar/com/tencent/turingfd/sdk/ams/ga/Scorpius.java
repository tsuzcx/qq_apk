package com.tencent.turingfd.sdk.ams.ga;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.atomic.AtomicReference;

public final class Scorpius
  implements ServiceConnection
{
  public Scorpius(AtomicReference paramAtomicReference, long paramLong, Object paramObject) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    new Sagittarius(this, paramIBinder).start();
  }
  
  public void onServiceDisconnected(ComponentName arg1)
  {
    this.Bc.set(Orion.n(-2004));
    synchronized (this.Cc)
    {
      this.Cc.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Scorpius
 * JD-Core Version:    0.7.0.1
 */