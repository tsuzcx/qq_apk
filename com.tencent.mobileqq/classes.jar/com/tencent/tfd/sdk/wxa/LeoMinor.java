package com.tencent.tfd.sdk.wxa;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.atomic.AtomicReference;

public abstract class LeoMinor
  implements Eridanus
{
  public Gemini Ed;
  
  public final Gemini Q(Context paramContext)
  {
    AtomicReference localAtomicReference1 = new AtomicReference();
    localAtomicReference1.set("");
    try
    {
      localAtomicReference2 = new AtomicReference();
      localAtomicReference3 = new AtomicReference();
      j = a(paramContext, localAtomicReference2, localAtomicReference3);
      i = j;
      if (j != 0) {}
    }
    catch (Throwable paramContext)
    {
      AtomicReference localAtomicReference2;
      AtomicReference localAtomicReference3;
      label65:
      label67:
      break label65;
    }
    try
    {
      i = a(paramContext, localAtomicReference2, localAtomicReference3, localAtomicReference1);
    }
    catch (Throwable paramContext)
    {
      i = j;
      break label67;
    }
    i = -1;
    return new Gemini((String)localAtomicReference1.get(), i);
  }
  
  public final int a(Context paramContext, AtomicReference<IBinder> paramAtomicReference, AtomicReference<ServiceConnection> paramAtomicReference1)
  {
    Object localObject1 = new Object();
    Object localObject2 = (Lynx)this;
    localObject2 = new Intent(const.get(const.ya));
    ((Intent)localObject2).setComponent(new ComponentName(const.get(const.ua), const.get(const.va)));
    if (!paramContext.bindService((Intent)localObject2, new Hydra(this, paramAtomicReference, paramAtomicReference1, localObject1), 1)) {
      return -100;
    }
    if (paramAtomicReference.get() == null) {}
    try
    {
      try
      {
        localObject1.wait(1000L);
      }
      finally
      {
        break label111;
      }
    }
    catch (Throwable paramContext)
    {
      label105:
      break label105;
    }
    break label116;
    label111:
    throw paramContext;
    label116:
    if (paramAtomicReference.get() == null) {
      return -105;
    }
    return 0;
  }
  
  public final int a(Context paramContext, AtomicReference<IBinder> paramAtomicReference, AtomicReference<ServiceConnection> paramAtomicReference1, AtomicReference<String> paramAtomicReference2)
  {
    Object localObject = new Object();
    AtomicReference localAtomicReference = new AtomicReference(Integer.valueOf(0));
    new Lacerta(this, paramAtomicReference, localAtomicReference, paramAtomicReference2, paramContext, paramAtomicReference1, localObject).start();
    try
    {
      try
      {
        localObject.wait(1000L);
      }
      finally
      {
        break label75;
      }
    }
    catch (Throwable paramContext)
    {
      label60:
      break label60;
    }
    return ((Integer)localAtomicReference.get()).intValue();
    label75:
    throw paramContext;
  }
  
  public abstract String a(IBinder paramIBinder);
  
  public void i(Context paramContext)
  {
    this.Ed = Q(paramContext);
  }
  
  public Gemini j(Context paramContext)
  {
    Gemini localGemini = this.Ed;
    if ((localGemini == null) || (localGemini.Oc != 0)) {
      this.Ed = Q(paramContext);
    }
    return this.Ed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.LeoMinor
 * JD-Core Version:    0.7.0.1
 */