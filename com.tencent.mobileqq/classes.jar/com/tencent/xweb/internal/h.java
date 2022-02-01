package com.tencent.xweb.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.a;
import java.util.ArrayList;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;

public class h
{
  static h h;
  int a = 0;
  int b = 0;
  long c = 0L;
  ArrayList<Long> d = new ArrayList();
  WebView.c e;
  long f = 0L;
  boolean g = false;
  
  private h(WebView.c paramc, String paramString)
  {
    this.e = paramc;
    if (this.e == WebView.c.d)
    {
      this.g = false;
      return;
    }
    if ((!"tools".equals(WebView.getCurStrModule())) && (!"toolsmp".equals(WebView.getCurStrModule())))
    {
      this.g = false;
      return;
    }
    this.g = k();
    this.f = a(this.e).getLong("SP_KEY_NEED_SWITCH_TIME", 0L);
    if (Math.abs(System.currentTimeMillis() - this.f) < 43200000L) {
      this.a = 3;
    }
  }
  
  static SharedPreferences a(WebView.c paramc)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(XWalkEnvironment.getProcessName());
      localStringBuilder.append("_LOAD_URL_");
      localStringBuilder.append(paramc);
      paramc = XWalkEnvironment.getProcessSafePreferences(localStringBuilder.toString(), 4);
      return paramc;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public static h a()
  {
    try
    {
      if (h == null) {
        h = new h(WebView.getCurWebType(), WebView.getCurStrModule());
      }
      h localh = h;
      return localh;
    }
    finally {}
  }
  
  public static void a(WebView.c paramc, String paramString)
  {
    try
    {
      h = new h(paramc, paramString);
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  static boolean k()
  {
    String str = a.a("enable_err_watchdog", "tools");
    return (str != null) && (str.trim().toLowerCase().equals("true"));
  }
  
  public void b()
  {
    try
    {
      this.c = System.currentTimeMillis();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c()
  {
    try
    {
      boolean bool = this.g;
      if (!bool) {
        return;
      }
      if (NetworkUtil.isNetworkAvailable()) {
        this.d.add(Long.valueOf(System.currentTimeMillis()));
      }
      if (this.d.size() >= 3)
      {
        long l = ((Long)this.d.get(this.d.size() - 3)).longValue();
        if (Math.abs(System.currentTimeMillis() - l) < 120000L)
        {
          this.a = 1;
          if (this.e == WebView.c.b) {
            com.tencent.xweb.util.h.a(220L, 1);
          } else if (this.e == WebView.c.c) {
            com.tencent.xweb.util.h.a(226L, 1);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public int d()
  {
    try
    {
      int i = this.a;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean e()
  {
    try
    {
      int i = d();
      boolean bool2 = true;
      if ((i == 3) || (d() == 2)) {
        if (this.e == WebView.c.b) {
          com.tencent.xweb.util.h.a(222L, 1);
        } else if (this.e == WebView.c.c) {
          com.tencent.xweb.util.h.a(228L, 1);
        }
      }
      boolean bool1 = bool2;
      if (d() != 1)
      {
        bool1 = bool2;
        if (d() != 3)
        {
          i = d();
          if (i == 2) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public boolean f()
  {
    try
    {
      int i = d();
      boolean bool;
      if (i == 2) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean g()
  {
    try
    {
      int i = d();
      boolean bool;
      if (i == 3) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void h()
  {
    try
    {
      boolean bool = this.g;
      if (!bool) {
        return;
      }
      this.c = 0L;
      this.d.clear();
      this.f = 0L;
      this.a = 0;
      return;
    }
    finally {}
  }
  
  public void i()
  {
    try
    {
      boolean bool = this.g;
      if (!bool) {
        return;
      }
      int i = this.a;
      if (1 != i) {
        return;
      }
      if (this.d.size() >= 1)
      {
        long l = ((Long)this.d.get(this.d.size() - 1)).longValue();
        if (Math.abs(System.currentTimeMillis() - l) < 60000L)
        {
          if (this.e == WebView.c.b) {
            com.tencent.xweb.util.h.a(221L, 1);
          } else if (this.e == WebView.c.c) {
            com.tencent.xweb.util.h.a(227L, 1);
          }
          this.c = 0L;
          this.d.clear();
          this.a = 2;
          this.f = System.currentTimeMillis();
          a(this.e).edit().putLong("SP_KEY_NEED_SWITCH_TIME", this.f).commit();
          return;
        }
      }
      this.a = 0;
      return;
    }
    finally {}
  }
  
  public void j()
  {
    try
    {
      boolean bool = this.g;
      if (!bool) {
        return;
      }
      int i = this.a;
      if (1 != i) {
        return;
      }
      this.c = 0L;
      this.d.clear();
      this.a = 0;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.internal.h
 * JD-Core Version:    0.7.0.1
 */