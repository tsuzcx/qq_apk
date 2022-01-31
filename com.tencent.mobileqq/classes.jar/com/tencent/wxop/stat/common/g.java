package com.tencent.wxop.stat.common;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import java.lang.reflect.Method;

public class g
{
  private static volatile g c = null;
  private int a = 10;
  private int b = 0;
  private Context d = null;
  private boolean e = false;
  
  private g(Context paramContext)
  {
    this.d = paramContext.getApplicationContext();
    try
    {
      this.e = r.a(this.d, "android.permission.WRITE_SETTINGS");
      if ((this.e) && (Build.VERSION.SDK_INT >= 23))
      {
        paramContext = Settings.System.class.getDeclaredMethod("canWrite", new Class[] { Context.class });
        paramContext.setAccessible(true);
        this.e = ((Boolean)paramContext.invoke(null, new Object[] { this.d })).booleanValue();
      }
      return;
    }
    catch (Throwable paramContext)
    {
      int i;
      do
      {
        i = this.b;
        this.b = (i + 1);
      } while (i >= this.a);
      paramContext.printStackTrace();
    }
  }
  
  public static g a(Context paramContext)
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new g(paramContext);
      }
      return c;
    }
    finally {}
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = Settings.System.getString(this.d.getContentResolver(), paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      int i = this.b;
      this.b = (i + 1);
      if (i < this.a) {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (this.e) {
      try
      {
        boolean bool = Settings.System.putString(this.d.getContentResolver(), paramString1, paramString2);
        return bool;
      }
      catch (Throwable paramString1)
      {
        int i = this.b;
        this.b = (i + 1);
        if (i < this.a) {
          paramString1.printStackTrace();
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.common.g
 * JD-Core Version:    0.7.0.1
 */