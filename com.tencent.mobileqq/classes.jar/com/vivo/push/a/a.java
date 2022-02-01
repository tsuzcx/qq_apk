package com.vivo.push.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.b;
import com.vivo.push.util.s;
import java.util.List;

public final class a
{
  private static void a(Context paramContext, Intent paramIntent)
  {
    if (paramContext != null) {
      try
      {
        paramContext.startService(paramIntent);
        return;
      }
      catch (Exception localException)
      {
        com.vivo.push.util.o.a("CommandBridge", "start service error", localException);
        paramIntent.setComponent(null);
        paramContext.sendBroadcast(paramIntent);
        return;
      }
    }
    com.vivo.push.util.o.d("CommandBridge", "enter startService context is null");
    throw new Exception("context is null");
  }
  
  public static void a(Context paramContext, com.vivo.push.o paramo, String paramString)
  {
    for (;;)
    {
      try
      {
        boolean bool = s.d(paramContext, paramString);
        if (bool)
        {
          str = "com.vivo.pushservice.action.RECEIVE";
          if (!TextUtils.isEmpty(paramString))
          {
            if ((!bool) && (!a(paramContext, str, paramString))) {
              break;
            }
            if (TextUtils.isEmpty(paramo.a())) {
              paramo.a(paramContext.getPackageName());
            }
            Intent localIntent = new Intent();
            localIntent.setFlags(1048576);
            if (!TextUtils.isEmpty(str)) {
              localIntent.setAction(str);
            }
            localIntent.setPackage(paramString);
            if (!bool) {
              break label190;
            }
            str = "com.vivo.push.sdk.service.CommandService";
            localIntent.setClassName(paramString, str);
            localIntent.putExtra("security_avoid_pull", com.vivo.push.util.a.a(paramContext).a("com.vivo.pushservice"));
            paramo.b(localIntent);
            localIntent.putExtra("command_type", "reflect_receiver");
            a(paramContext, localIntent);
            return;
          }
          com.vivo.push.util.o.c(paramContext, "消息接受者包名为空！");
          throw new Exception("消息接受者包名为空！");
        }
      }
      catch (Exception paramContext)
      {
        com.vivo.push.util.o.a("CommandBridge", "CommandBridge sendCommandToClient exception", paramContext);
        return;
      }
      String str = "com.vivo.pushclient.action.RECEIVE";
      continue;
      label190:
      str = "com.vivo.push.sdk.service.CommandClientService";
    }
  }
  
  public static void a(Context paramContext, String paramString, com.vivo.push.o paramo)
  {
    boolean bool1 = paramo.c();
    if (bool1) {
      localObject1 = "com.vivo.vms.upstageservice";
    } else {
      localObject1 = "com.vivo.vms.aidlservice";
    }
    Object localObject1 = b.a(paramContext, (String)localObject1);
    boolean bool2 = ((b)localObject1).a();
    if (TextUtils.isEmpty(paramo.a())) {
      paramo.a(paramContext.getPackageName());
    }
    if ((bool2) && (!"com.vivo.pushservice".equals(paramContext.getPackageName())))
    {
      localObject2 = new com.vivo.push.a(paramo.a(), paramString, new Bundle());
      paramo.a((com.vivo.push.a)localObject2);
      if (((b)localObject1).a(((com.vivo.push.a)localObject2).b())) {
        return;
      }
      com.vivo.push.util.o.b("CommandBridge", "send command error by aidl");
      com.vivo.push.util.o.c(paramContext, "send command error by aidl");
    }
    Object localObject2 = new Intent("com.vivo.pushservice.action.METHOD");
    ((Intent)localObject2).setPackage(paramString);
    if (bool1) {
      localObject1 = "com.vivo.push.sdk.service.UpstageService";
    } else {
      localObject1 = "com.vivo.push.sdk.service.PushService";
    }
    ((Intent)localObject2).setClassName(paramString, (String)localObject1);
    paramo.a((Intent)localObject2);
    try
    {
      a(paramContext, (Intent)localObject2);
      return;
    }
    catch (Exception paramContext)
    {
      com.vivo.push.util.o.a("CommandBridge", "CommandBridge startService exception: ", paramContext);
    }
  }
  
  private static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramString1);
    localIntent.setPackage(paramString2);
    try
    {
      paramContext = paramContext.getPackageManager().queryBroadcastReceivers(localIntent, 576);
      if (paramContext != null) {
        if (paramContext.size() > 0) {
          break label98;
        }
      }
      paramContext = new StringBuilder("action check error：action>>");
      paramContext.append(paramString1);
      paramContext.append(";pkgname>>");
      paramContext.append(paramString2);
      com.vivo.push.util.o.b("CommandBridge", paramContext.toString());
      return false;
    }
    catch (Exception paramContext)
    {
      label84:
      break label84;
    }
    com.vivo.push.util.o.b("CommandBridge", "queryBroadcastReceivers error");
    return false;
    label98:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.a.a
 * JD-Core Version:    0.7.0.1
 */