package com.tencent.tmassistantbase.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.tmassistantbase.common.a;
import com.tencent.tmassistantbase.common.e;

public class o
{
  private static boolean a = true;
  private static e b = new e();
  private static boolean c = false;
  
  public static int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if ((!paramString.equals("46000")) && (!paramString.equals("46002")) && (!paramString.equals("46007")))
      {
        if (paramString.equals("46001")) {
          return 1;
        }
        if (paramString.equals("46003")) {
          return 2;
        }
      }
      else
      {
        return 0;
      }
    }
    return -1;
  }
  
  public static boolean a()
  {
    return TextUtils.isEmpty(Proxy.getDefaultHost()) ^ true;
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isAvailable());
  }
  
  public static e b()
  {
    if (b.a == a.a) {
      c();
    }
    return b;
  }
  
  private static e b(Context paramContext)
  {
    e locale = new e();
    localObject2 = null;
    NetworkInfo localNetworkInfo = null;
    localObject1 = localObject2;
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager != null)
      {
        localObject1 = localObject2;
        localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      }
      if (localNetworkInfo != null)
      {
        localObject2 = localNetworkInfo;
        localObject1 = localNetworkInfo;
        if (localNetworkInfo.isAvailable()) {}
      }
      else
      {
        localObject1 = localNetworkInfo;
        a = false;
        localObject1 = localNetworkInfo;
        locale.a = a.m;
        return locale;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localObject2 = localObject1;
      }
    }
    a = true;
    if ((localObject2 != null) && (localObject2.getType() == 1))
    {
      locale.a = a.b;
      paramContext = (WifiManager)GlobalUtil.getInstance().getContext().getSystemService("wifi");
      if (paramContext != null) {
        try
        {
          paramContext = paramContext.getConnectionInfo();
          if (paramContext != null)
          {
            locale.e = paramContext.getBSSID();
            locale.f = paramContext.getSSID();
            return locale;
          }
        }
        catch (Throwable paramContext)
        {
          paramContext.printStackTrace();
        }
      }
      return locale;
    }
    return c(paramContext);
  }
  
  private static e c(Context paramContext)
  {
    e locale = new e();
    boolean bool = a();
    locale.d = bool;
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    String str = paramContext.getNetworkOperator();
    locale.b = str;
    int i = paramContext.getNetworkType();
    locale.c = i;
    int j = a(str);
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (bool)
          {
            locale.a = a.l;
            return locale;
          }
          locale.a = a.k;
          return locale;
        }
        if (i != 13)
        {
          if (bool)
          {
            locale.a = a.i;
            return locale;
          }
          locale.a = a.j;
          return locale;
        }
        if (bool)
        {
          locale.a = a.n;
          return locale;
        }
        locale.a = a.o;
        return locale;
      }
      if ((i != 1) && (i != 2))
      {
        if ((i != 3) && (i != 8) && (i != 10)) {
          if (i != 13)
          {
            if (i != 15)
            {
              if (bool)
              {
                locale.a = a.l;
                return locale;
              }
              locale.a = a.k;
              return locale;
            }
          }
          else
          {
            if (bool)
            {
              locale.a = a.n;
              return locale;
            }
            locale.a = a.o;
            return locale;
          }
        }
        if (bool)
        {
          locale.a = a.g;
          return locale;
        }
        locale.a = a.h;
        return locale;
      }
      if (bool)
      {
        locale.a = a.e;
        return locale;
      }
      locale.a = a.f;
      return locale;
    }
    if ((i != 1) && (i != 2))
    {
      if (i != 13)
      {
        if (i != 16)
        {
          if (bool)
          {
            locale.a = a.l;
            return locale;
          }
          locale.a = a.k;
          return locale;
        }
        if (bool)
        {
          locale.a = a.c;
          return locale;
        }
        locale.a = a.d;
        return locale;
      }
      if (bool)
      {
        locale.a = a.n;
        return locale;
      }
      locale.a = a.o;
      return locale;
    }
    if (bool)
    {
      locale.a = a.c;
      return locale;
    }
    locale.a = a.d;
    return locale;
  }
  
  public static void c()
  {
    if (GlobalUtil.getInstance().getContext() != null) {
      b = b(GlobalUtil.getInstance().getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.o
 * JD-Core Version:    0.7.0.1
 */