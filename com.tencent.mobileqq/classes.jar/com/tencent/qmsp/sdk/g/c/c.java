package com.tencent.qmsp.sdk.g.c;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

public class c
{
  private static String e = "LXOP";
  private Context a = null;
  public a b;
  private ServiceConnection c;
  public c.b d = null;
  
  public c(Context paramContext, c.b paramb)
  {
    if (paramContext != null)
    {
      this.a = paramContext;
      this.d = paramb;
      this.c = new c.a(this);
      paramContext = new Intent();
      paramContext.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
      if (this.a.bindService(paramContext, this.c, 1)) {}
      for (paramContext = "bindService Successful!";; paramContext = "bindService Failed!!!")
      {
        b(paramContext);
        return;
        paramContext = this.d;
        if (paramContext != null) {
          paramContext.a(this);
        }
      }
    }
    paramContext = new NullPointerException("Context can not be null.");
    for (;;)
    {
      throw paramContext;
    }
  }
  
  private void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString);
    com.tencent.qmsp.sdk.base.c.b(localStringBuilder.toString());
  }
  
  private void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString);
    com.tencent.qmsp.sdk.base.c.a(localStringBuilder.toString());
  }
  
  public String a()
  {
    if (this.a != null)
    {
      try
      {
        if (this.b != null)
        {
          String str = this.b.g();
          return str;
        }
      }
      catch (Exception localException)
      {
        a("getOAID error, RemoteException!");
        localException.printStackTrace();
      }
      return null;
    }
    a("Context is null.");
    throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
  }
  
  public boolean b()
  {
    try
    {
      a locala = this.b;
      if (locala == null) {
        return false;
      }
      b("Device support opendeviceid");
      boolean bool = this.b.c();
      return bool;
    }
    catch (Exception localException)
    {
      label29:
      break label29;
    }
    a("isSupport error, RemoteException!");
    return false;
  }
  
  public String c()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((Context)localObject).getPackageName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("liufeng, getAAID package：");
      localStringBuilder.append((String)localObject);
      b(localStringBuilder.toString());
      if ((localObject == null) || (((String)localObject).equals(""))) {}
    }
    try
    {
      if (this.b == null) {
        break label94;
      }
      localObject = this.b.b((String)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      label79:
      break label79;
    }
    a("getAAID error, RemoteException!");
    break label94;
    b("input package is null!");
    label94:
    return null;
    b("Context is null.");
    throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
  }
  
  public void d()
  {
    try
    {
      this.a.unbindService(this.c);
      b("unBind Service successful");
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label20:
      break label20;
    }
    a("unBind Service exception");
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.c.c
 * JD-Core Version:    0.7.0.1
 */