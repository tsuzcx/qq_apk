package com.tencent.turingfd.sdk.ams.ga;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.atomic.AtomicReference;

public class Hydra
  implements ServiceConnection
{
  public Hydra(LeoMinor paramLeoMinor, AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2, Object paramObject) {}
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    this.Vd.set(paramIBinder);
    this.Wd.set(this);
    try
    {
      synchronized (this.Xd)
      {
        this.Xd.notifyAll();
      }
    }
    catch (Throwable paramIBinder)
    {
      label37:
      break label37;
    }
    return;
    throw paramIBinder;
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Hydra
 * JD-Core Version:    0.7.0.1
 */