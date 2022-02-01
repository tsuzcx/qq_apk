package com.tencent.turingfd.sdk.xq;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.atomic.AtomicReference;

public class Cantaloupe
  implements ServiceConnection
{
  public Cantaloupe(Casaba paramCasaba, AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2, Object paramObject) {}
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    this.vh.set(paramIBinder);
    this.wh.set(this);
    try
    {
      synchronized (this.xh)
      {
        this.xh.notifyAll();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Cantaloupe
 * JD-Core Version:    0.7.0.1
 */