package com.tencent.turingfd.sdk.ams.ga;

import android.os.IBinder;
import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

public class Sagittarius
  extends Thread
{
  public Sagittarius(Scorpius paramScorpius, IBinder paramIBinder) {}
  
  public void run()
  {
    Norma.do.do localdo = (Norma.do.do)Norma.do.a(this.We);
    try
    {
      if (!localdo.k(2000)) {
        localdo.i(2000);
      }
      ??? = Sculptor.f(localdo.j(2000).ye);
      if (((Sculptor.do)???).cd != 0)
      {
        this.this$0.Bc.set(Orion.n(((Sculptor.do)???).cd));
      }
      else
      {
        ??? = ((Sculptor.do)???).He;
        int i = localdo.getVersion();
        this.this$0.Bc.set(new Orion(0, 200, System.currentTimeMillis() - this.this$0.Ge, ((Pyxis)???).Ee, i));
      }
    }
    catch (Throwable localThrowable)
    {
      label120:
      break label120;
    }
    this.this$0.Bc.set(Orion.n(-2003));
    synchronized (this.this$0.Cc)
    {
      this.this$0.Cc.notify();
      try
      {
        localdo.l(2000);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Sagittarius
 * JD-Core Version:    0.7.0.1
 */