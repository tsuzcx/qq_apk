package com.tencent.xweb.util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

public class f
{
  @SuppressLint({"PrivateApi"})
  private static String a()
  {
    Object localObject = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
    ((Method)localObject).setAccessible(true);
    String str = null;
    localObject = ((Method)localObject).invoke(null, new Object[0]);
    if ((localObject instanceof String)) {
      str = (String)localObject;
    }
    return str;
  }
  
  public static String a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramContext = g.a("android.app.Application", "getProcessName");
      if (paramContext != null) {
        return paramContext.toString();
      }
    }
    try
    {
      paramContext = a();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label31:
      break label31;
    }
    return b();
  }
  
  private static String b()
  {
    Object localObject = XWalkEnvironment.getApplicationContext();
    int i = Process.myPid();
    if (localObject == null) {
      return null;
    }
    localObject = (ActivityManager)((Context)localObject).getSystemService("activity");
    if (localObject != null)
    {
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (localRunningAppProcessInfo.pid == i) {
            return localRunningAppProcessInfo.processName;
          }
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.util.f
 * JD-Core Version:    0.7.0.1
 */