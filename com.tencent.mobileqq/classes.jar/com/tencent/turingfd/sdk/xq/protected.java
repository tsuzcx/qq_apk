package com.tencent.turingfd.sdk.xq;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.atomic.AtomicReference;

public class protected
  implements ServiceConnection
{
  public protected(implements paramimplements, AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2, Object paramObject) {}
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    this.uc.set(paramIBinder);
    this.vc.set(this);
    try
    {
      synchronized (this.wc)
      {
        this.wc.notifyAll();
        label30:
        return;
      }
    }
    catch (Throwable paramIBinder)
    {
      break label30;
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.protected
 * JD-Core Version:    0.7.0.1
 */