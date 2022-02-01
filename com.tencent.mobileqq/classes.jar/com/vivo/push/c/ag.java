package com.vivo.push.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import com.vivo.push.a.a;
import com.vivo.push.b.c;
import com.vivo.push.b.w;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.l;
import com.vivo.push.util.r;
import com.vivo.push.util.s;
import java.util.List;

final class ag
  extends l
{
  ag(com.vivo.push.o paramo)
  {
    super(paramo);
  }
  
  protected final void a(com.vivo.push.o paramo)
  {
    if (this.a == null)
    {
      localObject1 = new StringBuilder("SendCommandTask ");
      ((StringBuilder)localObject1).append(paramo);
      ((StringBuilder)localObject1).append(" ; mContext is Null");
      com.vivo.push.util.o.d("SendCommandTask", ((StringBuilder)localObject1).toString());
      return;
    }
    if (paramo == null)
    {
      com.vivo.push.util.o.d("SendCommandTask", "SendCommandTask pushCommand is Null");
      return;
    }
    com.vivo.push.model.b localb = s.a(this.a);
    int i = paramo.b();
    if (i != 0)
    {
      if (i != 2009)
      {
        if (i != 2011) {
          switch (i)
          {
          default: 
            break;
          case 2002: 
          case 2003: 
          case 2004: 
          case 2005: 
            if ((localb != null) && (!localb.c()))
            {
              localObject1 = (c)paramo;
              i = r.a((c)localObject1);
              if (i != 0) {
                com.vivo.push.e.a().a(((c)localObject1).h(), i);
              }
            }
            else
            {
              com.vivo.push.e.a().a(((c)paramo).h(), 1005);
            }
            break;
          }
        } else {
          com.vivo.push.util.o.a(ClientConfigManagerImpl.getInstance(this.a).isDebug(((w)paramo).d()));
        }
      }
      else
      {
        com.vivo.push.util.o.a(ClientConfigManagerImpl.getInstance(this.a).isDebug());
        if (com.vivo.push.util.o.a())
        {
          com.vivo.push.e.a().i();
          localObject1 = new com.vivo.push.util.b();
          ((com.vivo.push.util.b)localObject1).a(this.a, "com.vivo.push_preferences.hybridapptoken_v1");
          ((com.vivo.push.util.b)localObject1).a();
          localObject1 = new com.vivo.push.util.b();
          ((com.vivo.push.util.b)localObject1).a(this.a, "com.vivo.push_preferences.appconfig_v1");
          ((com.vivo.push.util.b)localObject1).a();
          if (!com.vivo.push.e.a().e()) {
            ClientConfigManagerImpl.getInstance(this.a).clearPush();
          }
        }
      }
    }
    else if (com.vivo.push.e.a().e())
    {
      localObject1 = this.a;
      localObject2 = new Intent();
      ((Intent)localObject2).setPackage(((Context)localObject1).getPackageName());
      ((Intent)localObject2).setClassName(((Context)localObject1).getPackageName(), "com.vivo.push.sdk.service.CommandService");
      List localList = ((Context)localObject1).getPackageManager().queryIntentServices((Intent)localObject2, 128);
      if ((localList != null) && (localList.size() > 0))
      {
        localObject2 = ((Context)localObject1).getPackageManager();
        localObject1 = new ComponentName((Context)localObject1, ((ResolveInfo)localList.get(0)).serviceInfo.name);
        if (((PackageManager)localObject2).getComponentEnabledSetting((ComponentName)localObject1) != 2) {
          ((PackageManager)localObject2).setComponentEnabledSetting((ComponentName)localObject1, 2, 1);
        }
      }
      else
      {
        com.vivo.push.util.o.d("ModuleUtil", "disableDeprecatedService is null");
      }
      localObject1 = this.a;
      localObject2 = new Intent();
      ((Intent)localObject2).setPackage(((Context)localObject1).getPackageName());
      ((Intent)localObject2).setClassName(((Context)localObject1).getPackageName(), "com.vivo.push.sdk.service.LinkProxyActivity");
      localList = ((Context)localObject1).getPackageManager().queryIntentActivities((Intent)localObject2, 128);
      if ((localList != null) && (localList.size() > 0))
      {
        localObject2 = ((Context)localObject1).getPackageManager();
        localObject1 = new ComponentName((Context)localObject1, ((ResolveInfo)localList.get(0)).activityInfo.name);
        if (((PackageManager)localObject2).getComponentEnabledSetting((ComponentName)localObject1) != 2) {
          ((PackageManager)localObject2).setComponentEnabledSetting((ComponentName)localObject1, 2, 1);
        }
      }
      else
      {
        com.vivo.push.util.o.d("ModuleUtil", "disableDeprecatedActivity is null");
      }
    }
    if (localb == null)
    {
      localObject1 = new StringBuilder("SendCommandTask ");
      ((StringBuilder)localObject1).append(paramo);
      ((StringBuilder)localObject1).append(" ; pushPkgInfo is Null");
      com.vivo.push.util.o.d("SendCommandTask", ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject2 = localb.a();
    Object localObject1 = paramo;
    if (localb.c())
    {
      com.vivo.push.e.a().a(((c)paramo).h(), 1004);
      localObject1 = new com.vivo.push.b.e();
      paramo = new StringBuilder("SendCommandTask ");
      paramo.append(localObject1);
      paramo.append(" ; pkgName is InBlackList ");
      com.vivo.push.util.o.d("SendCommandTask", paramo.toString());
    }
    a.a(this.a, (String)localObject2, (com.vivo.push.o)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.c.ag
 * JD-Core Version:    0.7.0.1
 */