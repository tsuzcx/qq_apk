package com.tencent.tfd.sdk.wxa;

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
    this.Hd.set(paramIBinder);
    this.Id.set(this);
    try
    {
      synchronized (this.Jd)
      {
        this.Jd.notifyAll();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.Hydra
 * JD-Core Version:    0.7.0.1
 */