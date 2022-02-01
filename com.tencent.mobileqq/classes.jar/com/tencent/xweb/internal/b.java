package com.tencent.xweb.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.util.h;
import com.tencent.xweb.util.h.b.a;
import com.tencent.xweb.v;
import java.util.Date;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

public class b
{
  public static HashMap<String, b> c = new HashMap();
  static String d = "";
  SharedPreferences a;
  boolean b = false;
  private String e;
  private String f;
  private String g;
  private long h;
  private long i;
  private long j;
  private String k;
  
  b(String paramString, WebView.c paramc)
  {
    this.a = b(paramString, paramc);
    paramc = new StringBuilder();
    paramc.append("INIT_START_TIME");
    paramc.append(paramString);
    this.e = paramc.toString();
    paramc = new StringBuilder();
    paramc.append("INIT_END_TIME");
    paramc.append(paramString);
    this.f = paramc.toString();
    paramc = new StringBuilder();
    paramc.append("INIT_TRY_COUNT");
    paramc.append(paramString);
    this.g = paramc.toString();
    this.k = paramString;
    paramString = this.a;
    if (paramString == null) {
      return;
    }
    this.h = paramString.getLong(this.e, 0L);
    this.i = this.a.getLong(this.f, 0L);
    this.j = this.a.getLong(this.g, 0L);
  }
  
  public static b a(String paramString, WebView.c paramc)
  {
    try
    {
      String str = c(paramString, paramc);
      b localb2 = (b)c.get(str);
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b(paramString, paramc);
        c.put(str, localb1);
      }
      return localb1;
    }
    finally {}
  }
  
  public static boolean a(WebView.c paramc)
  {
    try
    {
      boolean bool = v.a().c();
      if (bool) {
        return false;
      }
      if (a("LOAD_CORE", paramc).d())
      {
        h.a(paramc, h.b.a.b);
        return true;
      }
      if (new b("CREATE_WEBVIEW", paramc).d())
      {
        h.a(paramc, h.b.a.c);
        return true;
      }
      return false;
    }
    finally {}
  }
  
  static SharedPreferences b(String paramString, WebView.c paramc)
  {
    try
    {
      if (paramc != WebView.c.b)
      {
        WebView.c localc = WebView.c.d;
        if (paramc != localc) {
          return null;
        }
      }
      paramString = c(paramString, paramc);
      d = paramString;
      paramString = XWalkEnvironment.getMMKVSharedTransportOld(paramString);
      return paramString;
    }
    finally {}
  }
  
  private static String c(String paramString, WebView.c paramc)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("INIT_SP_TAG_");
    localStringBuilder.append(paramc.toString());
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    try
    {
      boolean bool = this.b;
      if (bool) {
        return;
      }
      this.b = true;
      Object localObject1 = this.a;
      if (localObject1 == null) {
        return;
      }
      localObject1 = this.a.edit();
      ((SharedPreferences.Editor)localObject1).putLong(this.g, this.j + 1L);
      long l = new Date().getTime();
      if (a(l))
      {
        ((SharedPreferences.Editor)localObject1).commit();
        return;
      }
      ((SharedPreferences.Editor)localObject1).putLong(this.e, l);
      ((SharedPreferences.Editor)localObject1).commit();
      return;
    }
    finally {}
  }
  
  boolean a(long paramLong)
  {
    try
    {
      long l = this.h;
      boolean bool = false;
      if (0L == l) {
        return false;
      }
      if ((this.i - this.h < 0L) && (Math.abs(paramLong - this.h) <= 10800000L))
      {
        paramLong = this.i;
        l = this.h;
        if (paramLong < l) {
          bool = true;
        }
        return bool;
      }
      return false;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      Object localObject1 = this.a;
      if (localObject1 == null) {
        return;
      }
      localObject1 = this.a.edit();
      ((SharedPreferences.Editor)localObject1).putLong(this.f, new Date().getTime());
      ((SharedPreferences.Editor)localObject1).putLong(this.g, 0L);
      ((SharedPreferences.Editor)localObject1).commit();
      this.a = null;
      return;
    }
    finally {}
  }
  
  public long c()
  {
    return this.j;
  }
  
  public boolean d()
  {
    try
    {
      Object localObject1 = this.a;
      if (localObject1 == null) {
        return false;
      }
      long l = new Date().getTime();
      boolean bool = a(l);
      if (!bool) {
        return false;
      }
      if (this.j > 4L)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Scene ");
        ((StringBuilder)localObject1).append(this.k);
        ((StringBuilder)localObject1).append(" crashed ");
        ((StringBuilder)localObject1).append((l - this.h) / 60000L);
        ((StringBuilder)localObject1).append(" minutes ago, try count = ");
        ((StringBuilder)localObject1).append(this.j);
        XWalkEnvironment.addXWalkInitializeLog(((StringBuilder)localObject1).toString());
        return true;
      }
      return false;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.internal.b
 * JD-Core Version:    0.7.0.1
 */