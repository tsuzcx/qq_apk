package com.tencent.tvkbeacon.g;

import android.content.Context;

public final class a
{
  private static a u;
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private String j = "";
  private boolean k = false;
  private String l = "";
  private String m = "";
  private String n = "";
  private String o = "";
  private String p = "";
  private String q = "";
  private String r = "";
  private String s = "";
  private String t = "";
  
  private a(Context paramContext)
  {
    this.b = com.tencent.tvkbeacon.core.info.c.a(paramContext).a();
    com.tencent.tvkbeacon.core.info.d.a(paramContext);
    this.c = com.tencent.tvkbeacon.core.info.d.e(paramContext);
    this.d = com.tencent.tvkbeacon.core.info.d.c(paramContext);
    this.e = com.tencent.tvkbeacon.core.info.d.d(paramContext);
    if ("".equals(this.c)) {
      this.f = com.tencent.tvkbeacon.core.info.d.d();
    }
    this.g = com.tencent.tvkbeacon.core.info.c.a(paramContext).h();
    this.h = com.tencent.tvkbeacon.core.info.d.b();
    this.i = com.tencent.tvkbeacon.core.info.d.e();
    this.j = com.tencent.tvkbeacon.core.info.d.a();
    this.l = com.tencent.tvkbeacon.core.info.d.h();
    this.m = com.tencent.tvkbeacon.core.info.d.j(paramContext);
    try
    {
      paramContext = d.a(paramContext);
      if ((paramContext != null) && (!"".equals(paramContext))) {
        this.a = paramContext;
      }
      return;
    }
    catch (Exception paramContext)
    {
      com.tencent.tvkbeacon.core.c.c.d("load qimei error ", new Object[] { paramContext });
    }
  }
  
  public static a a(Context paramContext)
  {
    try
    {
      if (u == null) {
        u = new a(paramContext);
      }
      paramContext = u;
      return paramContext;
    }
    finally {}
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final void a(String paramString)
  {
    this.a = paramString;
  }
  
  public final String b()
  {
    return this.a;
  }
  
  public final String c()
  {
    return this.b;
  }
  
  public final String d()
  {
    return this.c;
  }
  
  public final String e()
  {
    return this.d;
  }
  
  public final String f()
  {
    return this.e;
  }
  
  public final String g()
  {
    return this.j;
  }
  
  public final String h()
  {
    return this.g;
  }
  
  public final String i()
  {
    return this.h;
  }
  
  public final String j()
  {
    return this.i;
  }
  
  public final String k()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.g.a
 * JD-Core Version:    0.7.0.1
 */