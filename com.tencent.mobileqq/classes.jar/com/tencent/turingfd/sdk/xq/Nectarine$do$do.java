package com.tencent.turingfd.sdk.xq;

import android.os.IBinder;
import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

public class Nectarine$do$do
  extends Thread
{
  public Nectarine$do$do(Nectarine.do paramdo, IBinder paramIBinder) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    ??? = Loquat.do.a;
    if (localObject1 == null)
    {
      localObject1 = null;
    }
    else
    {
      ??? = ((IBinder)localObject1).queryLocalInterface(Loquat.do.a);
      if ((??? != null) && ((??? instanceof Loquat))) {
        localObject1 = (Loquat)???;
      } else {
        localObject1 = new Loquat.do.do((IBinder)localObject1);
      }
    }
    try
    {
      if (!((Loquat)localObject1).c(2000)) {
        ((Loquat)localObject1).a(2000);
      }
      ??? = Nectarine.a(((Loquat)localObject1).b(2000).c);
      int i = ((Nectarine.if)???).a;
      if (i != 0)
      {
        this.b.a.set(Mango.b(i));
      }
      else
      {
        ??? = ((Nectarine.if)???).b;
        i = ((Loquat)localObject1).a();
        this.b.a.set(new Mango(0, 200, System.currentTimeMillis() - this.b.b, ((Melon)???).h, i));
      }
    }
    finally
    {
      label172:
      break label172;
    }
    this.b.a.set(Mango.b(-2003));
    synchronized (this.b.c)
    {
      this.b.c.notify();
      try
      {
        ((Loquat)localObject1).d(2000);
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
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Nectarine.do.do
 * JD-Core Version:    0.7.0.1
 */