package com.tencent.securemodule;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.securemodule.impl.AppInfo;
import com.tencent.securemodule.impl.SecureService;
import com.tencent.securemodule.ui.TransparentActivity;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

public class ay
{
  public static void a(Context paramContext)
  {
    a(paramContext, 17301628, "QQ安全登录扫描中...", "QQ安全登录扫描中...", "");
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("危险！QQ安全登录发现");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("个病毒");
    localObject = ((StringBuilder)localObject).toString();
    a(paramContext, 17301642, (String)localObject, (String)localObject, "");
  }
  
  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = b(paramContext, paramInt, paramString1, paramString2, paramString3, PendingIntent.getActivity(paramContext, 0, new Intent(), 134217728));
    if (paramString1 == null) {
      return;
    }
    paramString1.flags = 16;
    paramContext = (NotificationManager)paramContext.getSystemService("notification");
    paramContext.cancel(1);
    paramContext.notify(1, paramString1);
    paramContext.cancel(1);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, PendingIntent paramPendingIntent)
  {
    paramString1 = b(paramContext, paramInt, paramString1, paramString2, paramString3, paramPendingIntent);
    if (paramString1 == null) {
      return;
    }
    paramString1.flags = 16;
    paramContext = (NotificationManager)paramContext.getSystemService("notification");
    paramContext.cancel(2);
    paramContext.notify(2, paramString1);
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    PendingIntent localPendingIntent = PendingIntent.getActivity(paramContext, 0, new Intent(), 134217728);
    if (paramBundle != null)
    {
      long l1 = paramBundle.getLong("key_total");
      long l2 = paramBundle.getLong("key_completed");
      int i = paramBundle.getInt("key_progress");
      paramBundle = new StringBuffer();
      paramBundle.append("下载：");
      paramBundle.append(az.a(paramContext, l2));
      paramBundle.append("/");
      paramBundle.append(az.a(paramContext, l1));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("    ");
      localStringBuilder.append(i);
      localStringBuilder.append("%");
      paramBundle.append(localStringBuilder.toString());
      paramBundle = paramBundle.toString();
    }
    else
    {
      paramBundle = "";
    }
    paramBundle = b(paramContext, 17301633, null, "腾讯手机管家", paramBundle, localPendingIntent);
    if (paramBundle == null) {
      return;
    }
    paramBundle.flags = 16;
    ((NotificationManager)paramContext.getSystemService("notification")).notify(2, paramBundle);
  }
  
  public static void a(Context paramContext, AppInfo paramAppInfo)
  {
    String str = paramAppInfo.getPkgName();
    Object localObject = new Intent();
    ((Intent)localObject).setClass(paramContext, TransparentActivity.class);
    ((Intent)localObject).setAction("1000041");
    ((Intent)localObject).putExtra("data", paramAppInfo);
    localObject = PendingIntent.getActivity(paramContext, 0, (Intent)localObject, 134217728);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("“");
    localStringBuilder.append(paramAppInfo.getSoftName());
    localStringBuilder.append("应用”已被病毒感染");
    paramAppInfo = b(paramContext, 17301642, null, "QQ安全登录发现病毒", localStringBuilder.toString(), (PendingIntent)localObject);
    if (paramAppInfo == null) {
      return;
    }
    paramAppInfo.flags = 16;
    ((NotificationManager)paramContext.getSystemService("notification")).notify(str.hashCode() + 1, paramAppInfo);
  }
  
  public static Notification b(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, PendingIntent paramPendingIntent)
  {
    try
    {
      localObject2 = Class.forName("android.support.v4.app.NotificationCompat$Builder");
    }
    catch (Exception paramString1)
    {
      Object localObject2;
      Object localObject1;
      label52:
      Method localMethod1;
      Method localMethod2;
      paramContext = null;
    }
    try
    {
      localObject1 = ((Class)localObject2).getConstructor(new Class[] { Context.class, String.class }).newInstance(new Object[] { paramContext, g(paramContext) });
      paramContext = (Context)localObject1;
    }
    catch (Exception localException)
    {
      break label52;
    }
    paramContext = ((Class)localObject2).getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
    localObject1 = ((Class)localObject2).getDeclaredMethod("setContentTitle", new Class[] { CharSequence.class });
    localMethod1 = ((Class)localObject2).getDeclaredMethod("setContentText", new Class[] { CharSequence.class });
    localMethod2 = ((Class)localObject2).getDeclaredMethod("setContentIntent", new Class[] { PendingIntent.class });
    localObject2 = ((Class)localObject2).getDeclaredMethod("build", new Class[0]);
    ((Method)localObject1).invoke(paramContext, new Object[] { paramString2 });
    localMethod1.invoke(paramContext, new Object[] { paramString3 });
    localMethod2.invoke(paramContext, new Object[] { paramPendingIntent });
    paramContext = (Notification)((Method)localObject2).invoke(paramContext, new Object[0]);
    try
    {
      paramContext.icon = paramInt;
      paramContext.when = System.currentTimeMillis();
      paramContext.tickerText = paramString1;
      return paramContext;
    }
    catch (Exception paramString1) {}
    paramString1.printStackTrace();
    return paramContext;
  }
  
  public static void b(Context paramContext)
  {
    a(paramContext, 17301628, "QQ安全登录扫描正常，请放心使用", "QQ安全登录扫描正常，请放心使用", "");
  }
  
  public static void b(Context paramContext, Bundle paramBundle)
  {
    d(paramContext);
  }
  
  public static void c(Context paramContext)
  {
    a(paramContext, 17301642, "QQ安全登录扫描联网超时，无法判断风险", "QQ安全登录扫描联网超时，无法判断风险", "");
  }
  
  public static void d(Context paramContext)
  {
    ((NotificationManager)paramContext.getSystemService("notification")).cancel(2);
  }
  
  public static void e(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, SecureService.class);
    localIntent.setAction("1000011");
    a(paramContext, 17301642, "腾讯手机管家下载失败", "腾讯手机管家下载失败", "点击继续下载？", PendingIntent.getService(paramContext, 0, localIntent, 134217728));
  }
  
  public static void f(Context paramContext)
  {
    Toast.makeText(paramContext, "开始下载手机管家", 0).show();
  }
  
  private static String g(Context paramContext)
  {
    Object localObject = null;
    try
    {
      paramContext = (NotificationManager)paramContext.getSystemService("notification");
      Class localClass = Class.forName("android.app.NotificationChannel");
      List localList = (List)NotificationManager.class.getMethod("getNotificationChannels", new Class[0]).invoke(paramContext, new Object[0]);
      paramContext = (Context)localObject;
      if (localList != null)
      {
        paramContext = (Context)localObject;
        if (localList.size() > 0)
        {
          paramContext = localList.get(0);
          paramContext = (String)localClass.getMethod("getId", new Class[0]).invoke(paramContext, new Object[0]);
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      paramContext = (Context)localObject;
    }
    localObject = paramContext;
    if (paramContext == null) {
      localObject = "sm";
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.securemodule.ay
 * JD-Core Version:    0.7.0.1
 */