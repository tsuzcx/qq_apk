package com.vivo.push.util;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class m
  implements n
{
  private static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder("(");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append(")");
    a = localStringBuilder.toString();
  }
  
  private void a(Context paramContext, String paramString, int paramInt)
  {
    com.vivo.push.b.n localn = new com.vivo.push.b.n();
    localn.b(paramString);
    localn.a(paramInt);
    if (paramInt > 0) {
      d("LogController", paramString);
    }
    if (paramContext.getPackageName().equals("com.vivo.pushservice"))
    {
      localn.a(true);
      paramString = com.vivo.push.d.a.a().b().iterator();
      while (paramString.hasNext()) {
        com.vivo.push.a.a.a(paramContext, localn, (String)paramString.next());
      }
      return;
    }
    localn.a(false);
    com.vivo.push.a.a.a(paramContext, localn, paramContext.getPackageName());
  }
  
  private static boolean a()
  {
    o.a();
    return com.vivo.push.d.a.a().c();
  }
  
  public final int a(String paramString1, String paramString2)
  {
    paramString1 = "VivoPush.".concat(String.valueOf(paramString1));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(paramString2);
    return Log.e(paramString1, localStringBuilder.toString());
  }
  
  public final int a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    paramString1 = "VivoPush.".concat(String.valueOf(paramString1));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(paramString2);
    return Log.e(paramString1, localStringBuilder.toString(), paramThrowable);
  }
  
  public final int a(String paramString, Throwable paramThrowable)
  {
    return Log.e("VivoPush.".concat(String.valueOf(paramString)), Log.getStackTraceString(paramThrowable));
  }
  
  public final String a(Throwable paramThrowable)
  {
    return Log.getStackTraceString(paramThrowable);
  }
  
  public final void a(Context paramContext, String paramString)
  {
    if (a()) {
      a(paramContext, paramString, 0);
    }
  }
  
  public final int b(String paramString1, String paramString2)
  {
    paramString1 = "VivoPush.".concat(String.valueOf(paramString1));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(paramString2);
    return Log.w(paramString1, localStringBuilder.toString());
  }
  
  public final int b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (o.a())
    {
      paramString1 = "VivoPush.".concat(String.valueOf(paramString1));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(paramString2);
      return Log.i(paramString1, localStringBuilder.toString(), paramThrowable);
    }
    return -1;
  }
  
  public final void b(Context paramContext, String paramString)
  {
    if (a()) {
      a(paramContext, paramString, 1);
    }
  }
  
  public final int c(String paramString1, String paramString2)
  {
    paramString1 = "VivoPush.".concat(String.valueOf(paramString1));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(paramString2);
    return Log.d(paramString1, localStringBuilder.toString());
  }
  
  public final void c(Context paramContext, String paramString)
  {
    if (a()) {
      a(paramContext, paramString, 2);
    }
  }
  
  public final int d(String paramString1, String paramString2)
  {
    if (o.a())
    {
      paramString1 = "VivoPush.".concat(String.valueOf(paramString1));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(paramString2);
      return Log.i(paramString1, localStringBuilder.toString());
    }
    return -1;
  }
  
  public final int e(String paramString1, String paramString2)
  {
    if (o.a())
    {
      paramString1 = "VivoPush.".concat(String.valueOf(paramString1));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(paramString2);
      return Log.v(paramString1, localStringBuilder.toString());
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.m
 * JD-Core Version:    0.7.0.1
 */