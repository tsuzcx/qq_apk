package com.vivo.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.vivo.push.util.o;
import com.vivo.push.util.s;
import com.vivo.push.util.z;
import com.vivo.vms.IPCInvoke;
import com.vivo.vms.IPCInvoke.Stub;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
  implements ServiceConnection
{
  private static final Object a = new Object();
  private static Map<String, b> b = new HashMap();
  private boolean c;
  private String d = null;
  private Context e;
  private AtomicInteger f;
  private volatile IPCInvoke g;
  private Object h = new Object();
  private String i;
  private Handler j = null;
  
  private b(Context paramContext, String paramString)
  {
    this.e = paramContext;
    this.i = paramString;
    boolean bool = true;
    this.f = new AtomicInteger(1);
    this.j = new Handler(Looper.getMainLooper(), new c(this));
    this.d = s.b(paramContext);
    if ((!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.i)))
    {
      if (z.a(paramContext, this.d) < 1260L) {
        bool = false;
      }
      this.c = bool;
      b();
      return;
    }
    paramContext = this.e;
    paramString = new StringBuilder("init error : push pkgname is ");
    paramString.append(this.d);
    paramString.append(" ; action is ");
    paramString.append(this.i);
    o.c(paramContext, paramString.toString());
    this.c = false;
  }
  
  public static b a(Context paramContext, String paramString)
  {
    Object localObject1 = (b)b.get(paramString);
    if (localObject1 == null) {
      synchronized (a)
      {
        b localb = (b)b.get(paramString);
        localObject1 = localb;
        if (localb == null)
        {
          localObject1 = new b(paramContext, paramString);
          b.put(paramString, localObject1);
        }
        return localObject1;
      }
    }
    return localObject1;
  }
  
  private void a(int paramInt)
  {
    this.f.set(paramInt);
  }
  
  private void b()
  {
    int k = this.f.get();
    o.d("AidlManager", "Enter connect, Connection Status: ".concat(String.valueOf(k)));
    if ((k != 4) && (k != 2) && (k != 3))
    {
      if (k == 5) {
        return;
      }
      if (this.c)
      {
        a(2);
        if (!c())
        {
          a(1);
          o.a("AidlManager", "bind core service fail");
          return;
        }
        d();
      }
    }
  }
  
  private boolean c()
  {
    Intent localIntent = new Intent(this.i);
    localIntent.setPackage(this.d);
    try
    {
      boolean bool = this.e.bindService(localIntent, this, 1);
      return bool;
    }
    catch (Exception localException)
    {
      o.a("AidlManager", "bind core error", localException);
    }
    return false;
  }
  
  private void d()
  {
    this.j.removeMessages(1);
    this.j.sendEmptyMessageDelayed(1, 3000L);
  }
  
  private void e()
  {
    this.j.removeMessages(1);
  }
  
  private void f()
  {
    try
    {
      this.e.unbindService(this);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("On unBindServiceException:");
      localStringBuilder.append(localException.getMessage());
      o.a("AidlManager", localStringBuilder.toString());
    }
  }
  
  public final boolean a()
  {
    this.d = s.b(this.e);
    boolean bool2 = TextUtils.isEmpty(this.d);
    boolean bool1 = false;
    if (bool2)
    {
      o.c(this.e, "push pkgname is null");
      return false;
    }
    if (z.a(this.e, this.d) >= 1260L) {
      bool1 = true;
    }
    this.c = bool1;
    return this.c;
  }
  
  public final boolean a(Bundle paramBundle)
  {
    b();
    if (this.f.get() == 2)
    {
      try
      {
        synchronized (this.h)
        {
          this.h.wait(2000L);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      throw paramBundle;
    }
    try
    {
      k = this.f.get();
      if (k == 4)
      {
        this.j.removeMessages(2);
        this.j.sendEmptyMessageDelayed(2, 30000L);
        this.g.asyncCall(paramBundle, null);
        return true;
      }
      o.d("AidlManager", "invoke error : connect status = ".concat(String.valueOf(k)));
    }
    catch (Exception paramBundle)
    {
      o.a("AidlManager", "invoke error ", paramBundle);
      int k = this.f.get();
      o.d("AidlManager", "Enter disconnect, Connection Status: ".concat(String.valueOf(k)));
      if (k != 1) {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k == 4)
            {
              a(1);
              f();
            }
          }
          else {
            a(1);
          }
        }
        else
        {
          e();
          a(1);
        }
      }
    }
    return false;
  }
  
  public final void onBindingDied(ComponentName paramComponentName)
  {
    o.b("AidlManager", "onBindingDied : ".concat(String.valueOf(paramComponentName)));
  }
  
  public final void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    e();
    this.g = IPCInvoke.Stub.asInterface(paramIBinder);
    if (this.g == null)
    {
      o.d("AidlManager", "onServiceConnected error : aidl must not be null.");
      f();
      this.f.set(1);
      return;
    }
    if (this.f.get() == 2) {
      a(4);
    } else if (this.f.get() != 4) {
      f();
    }
    synchronized (this.h)
    {
      this.h.notifyAll();
      return;
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.g = null;
    a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.b
 * JD-Core Version:    0.7.0.1
 */