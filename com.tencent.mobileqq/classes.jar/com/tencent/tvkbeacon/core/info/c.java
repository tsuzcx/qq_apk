package com.tencent.tvkbeacon.core.info;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.tvkbeacon.core.b.h;
import com.tencent.tvkbeacon.core.c.i;

public final class c
{
  public static String a = "";
  public static String b = "";
  private static c c = null;
  private final Context d;
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private String j = "";
  private String k = "";
  private String l = "";
  private String m = "";
  
  private c(Context paramContext)
  {
    if (paramContext == null) {
      com.tencent.tvkbeacon.core.c.c.d("[core] create detail user info failed.", new Object[0]);
    }
    this.d = paramContext;
    d.a(paramContext);
    this.i = d.d(paramContext);
    this.g = d.e(paramContext);
    if (i.a(this.g)) {
      this.g = d.d();
    }
    this.h = d.c(paramContext);
    this.k = d.e();
    this.l = (d.f() + "m");
    if (h.a(paramContext).a()) {
      this.j = d.h();
    }
    for (;;)
    {
      d.a(paramContext);
      this.f = d.b(paramContext);
      if (!i.a(this.f)) {}
      try
      {
        paramContext = com.tencent.tvkbeacon.core.a.c.a(paramContext);
        if (i.a(paramContext.a("IMEI_DENGTA", ""))) {
          paramContext.a().a("IMEI_DENGTA", this.f).b();
        }
        com.tencent.tvkbeacon.core.c.c.a("[core] imei: " + this.f, new Object[0]);
        return;
        this.j = "";
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
  }
  
  public static c a(Context paramContext)
  {
    try
    {
      if (c == null) {
        c = new c(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  public final String a()
  {
    try
    {
      if (i.a(this.f)) {
        this.f = com.tencent.tvkbeacon.core.a.c.a(this.d).a("IMEI_DENGTA", "");
      }
      String str = this.f;
      return str;
    }
    finally {}
  }
  
  public final String b()
  {
    try
    {
      String str = this.g;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String c()
  {
    try
    {
      String str = this.h;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String d()
  {
    try
    {
      String str = this.i;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String e()
  {
    return this.j;
  }
  
  public final String f()
  {
    try
    {
      if (i.a(this.e)) {
        this.e = this.d.getApplicationInfo().targetSdkVersion;
      }
      String str = this.e;
      return str;
    }
    finally {}
  }
  
  public final String g()
  {
    try
    {
      String str = a;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String h()
  {
    try
    {
      String str = b;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.info.c
 * JD-Core Version:    0.7.0.1
 */