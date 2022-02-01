package com.tencent.xweb.xwalk.updater;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import java.nio.channels.FileLock;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public class h
{
  static boolean a = false;
  static FileLock b;
  
  public static boolean a()
  {
    try
    {
      if (a)
      {
        XWalkInitializer.addXWalkInitializeLog("current process is in updating progress");
        return true;
      }
      Object localObject1 = c();
      int i = ((SharedPreferences)localObject1).getInt("UpdatingProcessId", -1);
      if (i == Process.myPid())
      {
        XWalkInitializer.addXWalkInitializeLog("error current process is in updating progress");
        return true;
      }
      if (i < 0) {
        return false;
      }
      Object localObject3 = (ActivityManager)XWalkEnvironment.getApplicationContext().getSystemService("activity");
      if ((localObject3 != null) && (((ActivityManager)localObject3).getRunningAppProcesses() != null))
      {
        Process.myPid();
        int j = Process.myUid();
        localObject3 = ((ActivityManager)localObject3).getRunningAppProcesses().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject3).next();
          if (localRunningAppProcessInfo.pid == i) {
            if (localRunningAppProcessInfo.uid == j)
            {
              XWalkInitializer.addXWalkInitializeLog("some process is in updating progress");
              return true;
            }
          }
        }
        Process.myPid();
        localObject1 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject1).remove("UpdatingProcessId");
        ((SharedPreferences.Editor)localObject1).commit();
        return false;
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public static boolean b()
  {
    try
    {
      if (a())
      {
        XWalkEnvironment.addXWalkInitializeLog("is updating, start updating progress failed");
        return false;
      }
      a = true;
      int i = Process.myPid();
      SharedPreferences.Editor localEditor = c().edit();
      localEditor.putInt("UpdatingProcessId", i);
      localEditor.putLong("Start_Time", System.currentTimeMillis());
      localEditor.commit();
      XWalkInitializer.addXWalkInitializeLog("onInUpdatingProgress suc");
      return true;
    }
    finally {}
  }
  
  public static SharedPreferences c()
  {
    return XWalkEnvironment.getMMKVSharedPreferences("XWEB_UPDATING_TAG");
  }
  
  public static void d()
  {
    try
    {
      boolean bool = a;
      if (!bool) {
        return;
      }
      a = false;
      Process.myPid();
      SharedPreferences.Editor localEditor = c().edit();
      localEditor.remove("UpdatingProcessId");
      localEditor.commit();
      XWalkInitializer.addXWalkInitializeLog("finish updating progress");
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.h
 * JD-Core Version:    0.7.0.1
 */