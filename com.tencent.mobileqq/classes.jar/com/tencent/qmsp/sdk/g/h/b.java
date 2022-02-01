package com.tencent.qmsp.sdk.g.h;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.qmsp.sdk.base.c;

public class b
{
  private static String e = "SDI";
  public static String f = "SI";
  public b.b a = null;
  private ServiceConnection b;
  private Context c = null;
  public a d;
  
  public b(Context paramContext, b.b paramb)
  {
    if (paramContext != null)
    {
      this.c = paramContext;
      this.a = paramb;
      this.b = new b.a(this);
      return;
    }
    throw new NullPointerException("Context can not be null.");
  }
  
  public String a()
  {
    Object localObject1 = this.c;
    if (localObject1 != null)
    {
      localObject1 = ((Context)localObject1).getPackageName();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(f);
      ((StringBuilder)localObject2).append("apackage：");
      ((StringBuilder)localObject2).append((String)localObject1);
      c.a(((StringBuilder)localObject2).toString());
      if ((localObject1 == null) || (((String)localObject1).equals(""))) {}
    }
    try
    {
      if (this.d == null) {
        break label176;
      }
      localObject2 = this.d.a((String)localObject1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(f);
      localStringBuilder.append(" getAAID Package: ");
      localStringBuilder.append((String)localObject1);
      c.a(localStringBuilder.toString());
      return localObject2;
    }
    catch (Exception localException)
    {
      label122:
      break label122;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(f);
    Object localObject2 = " geta error, RemoteException!";
    break label163;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(f);
    localObject2 = " input package is null!";
    label163:
    ((StringBuilder)localObject1).append((String)localObject2);
    c.c(((StringBuilder)localObject1).toString());
    label176:
    return null;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(f);
    ((StringBuilder)localObject1).append(" Context is null.");
    c.c(((StringBuilder)localObject1).toString());
    throw new IllegalArgumentException("Context is null, must be new SxCore first");
  }
  
  public String b()
  {
    if (this.c != null)
    {
      try
      {
        if (this.d != null)
        {
          String str = this.d.a();
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(e);
          localStringBuilder2.append(" geto call");
          c.c(localStringBuilder2.toString());
          return str;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(f);
        localStringBuilder2.append(" geto error, RemoteException!");
        c.c(localStringBuilder2.toString());
        localException.printStackTrace();
      }
      return null;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(f);
    localStringBuilder1.append(" Context is null.");
    c.c(localStringBuilder1.toString());
    throw new IllegalArgumentException("Context is null, must be new SxCore first");
  }
  
  public void c()
  {
    Object localObject = new Intent();
    ((Intent)localObject).setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
    if (this.c.bindService((Intent)localObject, this.b, 1))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(f);
    }
    for (String str = " bindService Successful!";; str = " bindService Failed!")
    {
      ((StringBuilder)localObject).append(str);
      c.c(((StringBuilder)localObject).toString());
      return;
      this.a.a(this);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(f);
    }
  }
  
  public boolean d()
  {
    try
    {
      if (this.d == null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(f);
        localStringBuilder.append(" Device not support opendeviceid");
        c.c(localStringBuilder.toString());
        return false;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(f);
      localStringBuilder.append(" Device support opendeviceid");
      c.c(localStringBuilder.toString());
      return true;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder;
      label71:
      break label71;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(f);
    localStringBuilder.append(" isSupport error, RemoteException!");
    c.c(localStringBuilder.toString());
    return false;
  }
  
  public void e()
  {
    try
    {
      this.c.unbindService(this.b);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(f);
      localStringBuilder.append(" unBind Service successful");
      c.c(localStringBuilder.toString());
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      StringBuilder localStringBuilder;
      label44:
      break label44;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(f);
    localStringBuilder.append(" unBind Service exception");
    c.c(localStringBuilder.toString());
    this.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.h.b
 * JD-Core Version:    0.7.0.1
 */