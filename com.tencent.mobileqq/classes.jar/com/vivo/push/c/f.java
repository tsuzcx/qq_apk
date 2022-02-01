package com.vivo.push.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.vivo.push.b.j;
import com.vivo.push.l;
import com.vivo.push.sdk.a;
import com.vivo.push.util.s;
import java.util.List;

final class f
  extends l
{
  f(com.vivo.push.o paramo)
  {
    super(paramo);
  }
  
  public static boolean a(Context paramContext)
  {
    Object localObject = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
    ((Intent)localObject).setPackage(paramContext.getPackageName());
    List localList = paramContext.getPackageManager().queryIntentServices((Intent)localObject, 576);
    if ((localList != null) && (localList.size() > 0))
    {
      localObject = paramContext.getPackageManager();
      paramContext = new ComponentName(paramContext, ((ResolveInfo)localList.get(0)).serviceInfo.name);
      if (((PackageManager)localObject).getComponentEnabledSetting(paramContext) != 1)
      {
        ((PackageManager)localObject).setComponentEnabledSetting(paramContext, 1, 1);
        com.vivo.push.util.o.d("OnChangePushStatusTask", "enableService push service.");
        return true;
      }
      com.vivo.push.util.o.d("OnChangePushStatusTask", "push service has enabled");
      return false;
    }
    com.vivo.push.util.o.a("OnChangePushStatusTask", "enableService error: can not find push service.");
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    Object localObject = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
    ((Intent)localObject).setPackage(paramContext.getPackageName());
    List localList = paramContext.getPackageManager().queryIntentServices((Intent)localObject, 576);
    if ((localList != null) && (localList.size() > 0))
    {
      localObject = paramContext.getPackageManager();
      paramContext = new ComponentName(paramContext, ((ResolveInfo)localList.get(0)).serviceInfo.name);
      if (((PackageManager)localObject).getComponentEnabledSetting(paramContext) != 2)
      {
        ((PackageManager)localObject).setComponentEnabledSetting(paramContext, 2, 1);
        com.vivo.push.util.o.d("OnChangePushStatusTask", "disableService push service.");
        return true;
      }
      com.vivo.push.util.o.d("OnChangePushStatusTask", "push service has disabled");
      return false;
    }
    com.vivo.push.util.o.a("OnChangePushStatusTask", "disableService error: can not find push service.");
    return false;
  }
  
  private static List<ResolveInfo> c(Context paramContext)
  {
    Object localObject1 = new Intent("com.vivo.pushservice.action.RECEIVE");
    ((Intent)localObject1).setPackage(paramContext.getPackageName());
    try
    {
      localObject1 = paramContext.getPackageManager().queryBroadcastReceivers((Intent)localObject1, 576);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          Object localObject2 = paramContext.getPackageManager().queryBroadcastReceivers((Intent)localObject2, 576);
          return localObject2;
        }
        catch (Exception paramContext) {}
        localException = localException;
      }
      return localException;
    }
    localObject1 = null;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((List)localObject1).size() > 0) {}
    }
    else
    {
      localObject2 = new Intent("com.vivo.pushclient.action.RECEIVE");
      ((Intent)localObject2).setPackage(paramContext.getPackageName());
    }
  }
  
  protected final void a(com.vivo.push.o paramo)
  {
    Object localObject1 = s.b(this.a);
    if (this.a.getPackageName().equals(localObject1)) {
      return;
    }
    paramo = (j)paramo;
    int i = paramo.d();
    int j = paramo.e();
    paramo = new StringBuilder("OnChangePushStatusTask serviceStatus is ");
    paramo.append(i);
    paramo.append(" ; receiverStatus is ");
    paramo.append(j);
    com.vivo.push.util.o.d("OnChangePushStatusTask", paramo.toString());
    Object localObject2;
    if (i == 2)
    {
      b(this.a);
    }
    else if (i == 1)
    {
      a(this.a);
    }
    else if (i == 0)
    {
      paramo = this.a;
      localObject1 = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
      ((Intent)localObject1).setPackage(paramo.getPackageName());
      localObject2 = paramo.getPackageManager().queryIntentServices((Intent)localObject1, 576);
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject1 = paramo.getPackageManager();
        paramo = new ComponentName(paramo, ((ResolveInfo)((List)localObject2).get(0)).serviceInfo.name);
        if (((PackageManager)localObject1).getComponentEnabledSetting(paramo) != 0)
        {
          ((PackageManager)localObject1).setComponentEnabledSetting(paramo, 0, 1);
          com.vivo.push.util.o.d("OnChangePushStatusTask", "defaultService push service.");
        }
        else
        {
          com.vivo.push.util.o.d("OnChangePushStatusTask", "push service has defaulted");
        }
      }
      else
      {
        com.vivo.push.util.o.a("OnChangePushStatusTask", "defaultService error: can not find push service.");
      }
    }
    if (j == 2)
    {
      paramo = this.a;
      localObject1 = c(paramo);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject2 = ((ResolveInfo)((List)localObject1).get(0)).activityInfo.name;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          com.vivo.push.util.o.d("OnChangePushStatusTask", "disableReceiver error: className is null. ");
        }
        else
        {
          localObject1 = paramo.getPackageManager();
          paramo = new ComponentName(paramo, (String)localObject2);
          if (((PackageManager)localObject1).getComponentEnabledSetting(paramo) != 2)
          {
            ((PackageManager)localObject1).setComponentEnabledSetting(paramo, 2, 1);
            com.vivo.push.util.o.d("OnChangePushStatusTask", "push service disableReceiver ");
          }
          else
          {
            com.vivo.push.util.o.d("OnChangePushStatusTask", "push service has disableReceiver ");
          }
        }
      }
      else
      {
        com.vivo.push.util.o.a("OnChangePushStatusTask", "disableReceiver error: can not find push service.");
      }
      a.a().b();
      return;
    }
    if (j == 1)
    {
      paramo = this.a;
      localObject1 = c(paramo);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject2 = ((ResolveInfo)((List)localObject1).get(0)).activityInfo.name;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          com.vivo.push.util.o.d("OnChangePushStatusTask", "enableReceiver error: className is null. ");
          return;
        }
        localObject1 = paramo.getPackageManager();
        paramo = new ComponentName(paramo, (String)localObject2);
        if (((PackageManager)localObject1).getComponentEnabledSetting(paramo) != 1)
        {
          ((PackageManager)localObject1).setComponentEnabledSetting(paramo, 1, 1);
          com.vivo.push.util.o.d("OnChangePushStatusTask", "push service enableReceiver ");
          return;
        }
        com.vivo.push.util.o.d("OnChangePushStatusTask", "push service has enableReceiver ");
        return;
      }
      com.vivo.push.util.o.a("OnChangePushStatusTask", "enableReceiver error: can not find push service.");
      return;
    }
    if (j == 0)
    {
      paramo = this.a;
      localObject1 = c(paramo);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject2 = ((ResolveInfo)((List)localObject1).get(0)).activityInfo.name;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          com.vivo.push.util.o.d("OnChangePushStatusTask", "defaultReceiver error: className is null. ");
          return;
        }
        localObject1 = paramo.getPackageManager();
        paramo = new ComponentName(paramo, (String)localObject2);
        if (((PackageManager)localObject1).getComponentEnabledSetting(paramo) != 0)
        {
          ((PackageManager)localObject1).setComponentEnabledSetting(paramo, 0, 1);
          com.vivo.push.util.o.d("OnChangePushStatusTask", "push service defaultReceiver ");
          return;
        }
        com.vivo.push.util.o.d("OnChangePushStatusTask", "push service has defaulted");
        return;
      }
      com.vivo.push.util.o.a("OnChangePushStatusTask", "defaultReceiver error: can not find push service.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.c.f
 * JD-Core Version:    0.7.0.1
 */