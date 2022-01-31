package com.tencent.tvkbeacon.core.c;

import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public final class f
{
  private static f b = null;
  private boolean a;
  
  protected f()
  {
    String str = Build.TAGS;
    if ((str != null) && (str.contains("test-keys"))) {
      c.b("[core] test-keys}", new Object[0]);
    }
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (c()) || (d())) {
        bool = true;
      }
      this.a = bool;
      return;
    }
  }
  
  public static f a()
  {
    try
    {
      if (b == null) {
        b = new f();
      }
      f localf = b;
      return localf;
    }
    finally {}
  }
  
  private static boolean c()
  {
    boolean bool = false;
    try
    {
      if (new File("/system/app/Superuser.apk").exists())
      {
        c.b("[core] super_apk}", new Object[0]);
        bool = true;
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private static boolean d()
  {
    Object localObject = e();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        c.b(str, new Object[0]);
        if (str.contains("not found")) {
          return false;
        }
      }
      c.b("[core] sufile}", new Object[0]);
      return true;
    }
    c.b("[core] no response}", new Object[0]);
    return false;
  }
  
  private static ArrayList<String> e()
  {
    ArrayList localArrayList = new ArrayList();
    String str;
    Object localObject;
    try
    {
      Process localProcess = Runtime.getRuntime().exec(new String[] { "/system/bin/sh", "-c", "type su" });
      localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
      for (;;)
      {
        str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localArrayList.add(str);
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      c.a(localThrowable);
      localObject = null;
    }
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(((Process)localObject).getErrorStream()));
    for (;;)
    {
      str = localBufferedReader.readLine();
      localObject = localArrayList;
      if (str == null) {
        break;
      }
      localArrayList.add(str);
    }
  }
  
  public final boolean b()
  {
    try
    {
      boolean bool = this.a;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.c.f
 * JD-Core Version:    0.7.0.1
 */