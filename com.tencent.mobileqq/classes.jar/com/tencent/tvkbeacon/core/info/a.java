package com.tencent.tvkbeacon.core.info;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import com.tencent.tvkbeacon.core.c.i;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public static boolean a = false;
  private static String b = null;
  private static String c = null;
  private static Boolean d = null;
  private static int e = 0;
  private static String f = "";
  
  public static String a()
  {
    if (!"".equals(f)) {
      return f;
    }
    try
    {
      if (e == 0) {
        e = Process.myPid();
      }
      f = f + e + "_";
      f += new Date().getTime();
    }
    catch (Exception localException)
    {
      label89:
      break label89;
    }
    return f;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        com.tencent.tvkbeacon.core.c.c.d("[core] context is null", new Object[0]);
        return bool2;
      }
      finally {}
      boolean bool1 = bool3;
      try
      {
        com.tencent.tvkbeacon.core.a.c localc = com.tencent.tvkbeacon.core.a.c.a(paramContext);
        bool1 = bool3;
        String str = localc.a("APPKEY_DENGTA", null);
        bool1 = bool3;
        paramContext = b.a(paramContext).b();
        if (str != null)
        {
          bool1 = bool3;
          if (str.equals(paramContext)) {}
        }
        else
        {
          bool1 = true;
          bool2 = true;
          localc.a().a("APPKEY_DENGTA", paramContext).b();
        }
      }
      catch (Exception paramContext)
      {
        com.tencent.tvkbeacon.core.c.c.d("[core] updateLocalAPPKEY fail!", new Object[0]);
        com.tencent.tvkbeacon.core.c.c.a(paramContext);
        bool2 = bool1;
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool3 = true;
    boolean bool1;
    boolean bool2;
    if (paramContext != null) {
      if (paramContext.checkPermission(paramString, Process.myPid(), Process.myUid()) == 0)
      {
        bool1 = true;
        bool2 = bool1;
        if (bool1) {}
      }
    }
    label152:
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096).requestedPermissions;
        if (paramContext == null) {
          break label152;
        }
        int j = paramContext.length;
        int i = 0;
        if (i >= j) {
          break label152;
        }
        bool2 = paramString.equals(paramContext[i]);
        if (bool2)
        {
          bool1 = bool3;
          com.tencent.tvkbeacon.core.c.c.b("[core] end", new Object[0]);
          bool2 = bool1;
          return bool2;
          bool1 = false;
          break;
        }
        i += 1;
        continue;
      }
      catch (Throwable paramContext)
      {
        com.tencent.tvkbeacon.core.c.c.a(paramContext);
        return bool1;
      }
      finally
      {
        com.tencent.tvkbeacon.core.c.c.b("[core] end", new Object[0]);
      }
      return false;
    }
  }
  
  public static boolean b(Context paramContext)
  {
    if (paramContext == null) {
      com.tencent.tvkbeacon.core.c.c.d("[core] context is null", new Object[0]);
    }
    for (;;)
    {
      return false;
      try
      {
        com.tencent.tvkbeacon.core.a.c localc = com.tencent.tvkbeacon.core.a.c.a(paramContext);
        String str = localc.a("APPVER_DENGTA", null);
        paramContext = b.a(paramContext).b(null);
        if (str != null)
        {
          bool = str.equals(paramContext);
          if (bool) {}
        }
        else
        {
          bool = true;
          com.tencent.tvkbeacon.core.c.c.d("[core] updateLocalAPPVER fail!", new Object[0]);
        }
      }
      catch (Exception paramContext)
      {
        try
        {
          localc.a().a("APPVER_DENGTA", paramContext).b();
          return true;
        }
        catch (Exception paramContext)
        {
          boolean bool;
          break;
        }
        paramContext = paramContext;
        bool = false;
      }
    }
    com.tencent.tvkbeacon.core.c.c.a(paramContext);
    return bool;
  }
  
  private static boolean b(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.trim().length() <= 0)) {
      return false;
    }
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if ((paramContext == null) || (paramContext.size() == 0))
      {
        com.tencent.tvkbeacon.core.c.c.c("[core] no running proc", new Object[0]);
        return false;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        Object localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject).importance == 100)
        {
          localObject = ((ActivityManager.RunningAppProcessInfo)localObject).pkgList;
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            boolean bool = paramString.equals(localObject[i]);
            if (bool) {
              return true;
            }
            i += 1;
          }
        }
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      com.tencent.tvkbeacon.core.c.c.a(paramContext);
      com.tencent.tvkbeacon.core.c.c.d("[core] Failed to judge [%s]", new Object[] { paramContext.getLocalizedMessage() });
    }
  }
  
  public static String c(Context paramContext)
  {
    if (b == null) {
      b = h(paramContext);
    }
    return b;
  }
  
  public static boolean d(Context paramContext)
  {
    try
    {
      if (d == null) {
        d = Boolean.valueOf(a(paramContext, "android.permission.READ_PHONE_STATE"));
      }
      com.tencent.tvkbeacon.core.c.c.b("[core] Read phone state permission: " + d, new Object[0]);
      boolean bool = d.booleanValue();
      return bool;
    }
    finally {}
  }
  
  public static boolean e(Context paramContext)
  {
    return b(paramContext, paramContext.getPackageName());
  }
  
  public static int f(Context paramContext)
  {
    try
    {
      if (e == 0) {
        e = Process.myPid();
      }
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == e)
        {
          int i = localRunningAppProcessInfo.importance;
          return i;
        }
      }
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static String g(Context paramContext)
  {
    if (c != null) {
      return c;
    }
    try
    {
      if (e == 0) {
        e = Process.myPid();
      }
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == e)
        {
          paramContext = localRunningAppProcessInfo.processName;
          c = paramContext;
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      com.tencent.tvkbeacon.core.c.c.a(paramContext);
    }
    return "";
  }
  
  private static String h(Context paramContext)
  {
    int i = 0;
    Object localObject;
    if (paramContext == null) {
      localObject = null;
    }
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo((String)localObject, 0);
        localObject = paramContext.versionName;
        m = paramContext.versionCode;
        if ((localObject != null) && (((String)localObject).trim().length() > 0)) {
          continue;
        }
        paramContext = String.valueOf(m);
      }
      catch (Exception paramContext)
      {
        int m;
        String str;
        com.tencent.tvkbeacon.core.c.c.a(paramContext);
        com.tencent.tvkbeacon.core.c.c.d(paramContext.toString(), new Object[0]);
        paramContext = "";
        continue;
      }
      finally {}
      return paramContext;
      str = paramContext.getPackageName();
      localObject = str;
      if (i.a(str))
      {
        localObject = "";
        continue;
        paramContext = ((String)localObject).trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C");
        localObject = paramContext.toCharArray();
      }
    }
    int k;
    for (int j = 0;; j = k)
    {
      if (i < localObject.length)
      {
        k = j;
        if (localObject[i] == '.') {
          k = j + 1;
        }
      }
      else
      {
        if (j < 3)
        {
          com.tencent.tvkbeacon.core.c.c.b("[core] add versionCode: %s", new Object[] { Integer.valueOf(m) });
          paramContext = paramContext + "." + m;
        }
        for (;;)
        {
          com.tencent.tvkbeacon.core.c.c.b("[core] final Version: %s", new Object[] { paramContext });
          break;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.info.a
 * JD-Core Version:    0.7.0.1
 */