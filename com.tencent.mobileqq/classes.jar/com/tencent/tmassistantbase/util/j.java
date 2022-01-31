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
import com.tencent.tmassistantbase.common.d;

public class j
{
  private static boolean a = true;
  private static d b = new d();
  private static boolean c = false;
  
  public static int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if ((paramString.equals("46000")) || (paramString.equals("46002")) || (paramString.equals("46007"))) {
        return 0;
      }
      if (paramString.equals("46001")) {
        return 1;
      }
      if (paramString.equals("46003")) {
        return 2;
      }
    }
    return -1;
  }
  
  private static d a(Context paramContext)
  {
    d locald = new d();
    for (;;)
    {
      try
      {
        Object localObject1 = (ConnectivityManager)paramContext.getSystemService("connectivity");
        Object localObject3;
        if (localObject1 != null)
        {
          localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
          if (localObject1 != null) {
            localObject3 = localObject1;
          }
        }
        Throwable localThrowable3;
        Object localObject2 = null;
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          if (((NetworkInfo)localObject1).isAvailable()) {
            continue;
          }
          a = false;
          locald.a = a.m;
          return locald;
        }
        catch (Throwable localThrowable2)
        {
          localThrowable3 = localThrowable1;
          continue;
        }
        localThrowable1 = localThrowable1;
        localObject3 = null;
        a = true;
        if ((localObject3 != null) && (localObject3.getType() == 1))
        {
          locald.a = a.b;
          paramContext = (WifiManager)GlobalUtil.getInstance().getContext().getSystemService("wifi");
          if (paramContext != null) {}
          try
          {
            paramContext = paramContext.getConnectionInfo();
            if (paramContext != null)
            {
              locald.e = paramContext.getBSSID();
              locald.f = paramContext.getSSID();
            }
          }
          catch (Throwable paramContext)
          {
            paramContext.printStackTrace();
            continue;
          }
          return locald;
        }
        return b(paramContext);
      }
    }
  }
  
  public static boolean a()
  {
    return !TextUtils.isEmpty(Proxy.getDefaultHost());
  }
  
  public static d b()
  {
    if (b.a == a.a) {
      c();
    }
    return b;
  }
  
  private static d b(Context paramContext)
  {
    d locald = new d();
    boolean bool = a();
    locald.d = bool;
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    String str = paramContext.getNetworkOperator();
    locald.b = str;
    int i = paramContext.getNetworkType();
    locald.c = i;
    switch (a(str))
    {
    default: 
      if (!bool) {
        break;
      }
    }
    for (locald.a = a.l;; locald.a = a.k)
    {
      return locald;
      switch (i)
      {
      default: 
        if (!bool) {
          break;
        }
      }
      for (locald.a = a.l;; locald.a = a.k)
      {
        return locald;
        if (bool) {}
        for (locald.a = a.n;; locald.a = a.o) {
          return locald;
        }
        if (bool) {}
        for (locald.a = a.c;; locald.a = a.d) {
          return locald;
        }
        if (bool) {}
        for (locald.a = a.c;; locald.a = a.d) {
          return locald;
        }
      }
      switch (i)
      {
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 9: 
      case 11: 
      case 12: 
      case 14: 
      default: 
        if (!bool) {
          break;
        }
      }
      for (locald.a = a.l;; locald.a = a.k)
      {
        return locald;
        if (bool) {}
        for (locald.a = a.n;; locald.a = a.o) {
          return locald;
        }
        if (bool) {}
        for (locald.a = a.g;; locald.a = a.h) {
          return locald;
        }
        if (bool) {}
        for (locald.a = a.e;; locald.a = a.f) {
          return locald;
        }
      }
      switch (i)
      {
      default: 
        if (!bool) {
          break;
        }
      }
      for (locald.a = a.i;; locald.a = a.j)
      {
        return locald;
        if (bool) {}
        for (locald.a = a.n;; locald.a = a.o) {
          return locald;
        }
      }
    }
  }
  
  public static void c()
  {
    if (GlobalUtil.getInstance().getContext() != null) {
      b = a(GlobalUtil.getInstance().getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.j
 * JD-Core Version:    0.7.0.1
 */