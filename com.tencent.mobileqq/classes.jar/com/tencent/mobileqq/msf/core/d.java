package com.tencent.mobileqq.msf.core;

import com.tencent.msf.service.protocol.serverconfig.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d
{
  public static final int a = 0;
  public static final int b = 1;
  public static final String c = "00000";
  public static final String d = "http";
  public static final String e = "socket";
  public static final String f = "quic";
  public byte g = 1;
  public byte h;
  public boolean i;
  public String j = "";
  public String k = "";
  public String l = "";
  public AtomicInteger m = new AtomicInteger();
  long n = 0L;
  public boolean o;
  private String p = "socket";
  private String q;
  private int r;
  private int s = 20000;
  private boolean t;
  
  public static d a(j paramj, int paramInt)
  {
    d locald = new d();
    if ((paramj.e == 2) || (paramj.e == 3))
    {
      locald.p = "http";
      locald.q = paramj.a;
      locald.r = paramj.b;
      locald.j = "";
      locald.g = 0;
      locald.h = paramj.d;
      if (paramj.f <= 20) {
        break label151;
      }
      locald.s = 20000;
      label81:
      if (paramInt != 0) {
        break label184;
      }
      locald.j = "00000";
      locald.a(true);
    }
    for (;;)
    {
      if (paramj.g == 1) {
        locald.t = true;
      }
      locald.k = paramj.h;
      locald.l = paramj.i;
      return locald;
      if ((paramj.e != 0) && (paramj.e != 1)) {
        break;
      }
      locald.p = "socket";
      break;
      label151:
      if (paramj.f < 5)
      {
        locald.s = 5000;
        break label81;
      }
      locald.s = (paramj.f * 1000);
      break label81;
      label184:
      locald.a(false);
    }
  }
  
  public static d a(String paramString)
  {
    Object localObject = paramString.toLowerCase();
    paramString = new d();
    localObject = Pattern.compile("([a-zA-Z]+)://([a-zA-Z0-9.]+)(:([0-9]+))?(#([0-9_]*))?(:([0-9]+))?(:([0-9]+))?(:([0-9]+))?(:([a-zA-Z]+))?(:([a-zA-Z]+))?(:([a-zA-Z]+))?").matcher((CharSequence)localObject);
    if (((Matcher)localObject).matches())
    {
      if (((Matcher)localObject).group(1) != null) {
        paramString.p = ((Matcher)localObject).group(1);
      }
      if (((Matcher)localObject).group(2) != null) {
        paramString.q = ((Matcher)localObject).group(2);
      }
      if (((Matcher)localObject).group(4) == null) {
        break label248;
      }
    }
    label248:
    for (paramString.r = Integer.parseInt(((Matcher)localObject).group(4));; paramString.r = 80)
    {
      if (((Matcher)localObject).group(6) != null) {
        paramString.j = ((Matcher)localObject).group(6);
      }
      if (((Matcher)localObject).group(8) != null) {
        paramString.g = Byte.parseByte(((Matcher)localObject).group(8));
      }
      if (((Matcher)localObject).group(10) != null) {
        paramString.h = Byte.parseByte(((Matcher)localObject).group(10));
      }
      if (((Matcher)localObject).group(12) != null) {
        paramString.s = (Integer.parseInt(((Matcher)localObject).group(12)) * 1000);
      }
      if (((Matcher)localObject).group(14) != null) {
        paramString.t = Boolean.parseBoolean(((Matcher)localObject).group(14));
      }
      if (((Matcher)localObject).group(16) != null) {
        paramString.k = ((Matcher)localObject).group(16);
      }
      if (((Matcher)localObject).group(18) != null) {
        paramString.l = ((Matcher)localObject).group(18);
      }
      paramString.a(paramString.j.equals("00000"));
      return paramString;
    }
  }
  
  public String a()
  {
    return this.q + ":" + this.r;
  }
  
  public void a(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public boolean a(com.tencent.qphone.base.a parama)
  {
    boolean bool = false;
    long l1 = System.currentTimeMillis();
    if ((parama == com.tencent.qphone.base.a.d) || (parama == com.tencent.qphone.base.a.c)) {
      if ((this.n == 0L) || (l1 - this.n > 600000L))
      {
        this.n = l1;
        this.m.incrementAndGet();
      }
    }
    for (;;)
    {
      if (this.m.get() > 19)
      {
        this.m.set(0);
        bool = true;
      }
      return bool;
      this.m.addAndGet(com.tencent.mobileqq.msf.core.a.a.aR());
      continue;
      if (parama == com.tencent.qphone.base.a.e) {
        this.m.addAndGet(com.tencent.mobileqq.msf.core.a.a.aS());
      } else if (parama == com.tencent.qphone.base.a.B) {
        this.m.addAndGet(com.tencent.mobileqq.msf.core.a.a.aT());
      } else if (parama == com.tencent.qphone.base.a.p) {
        this.m.addAndGet(com.tencent.mobileqq.msf.core.a.a.aU());
      } else if (parama == com.tencent.qphone.base.a.j) {
        this.m.addAndGet(com.tencent.mobileqq.msf.core.a.a.aV());
      } else if (parama == com.tencent.qphone.base.a.i) {
        this.m.addAndGet(com.tencent.mobileqq.msf.core.a.a.aW());
      }
    }
  }
  
  public String b()
  {
    return this.p;
  }
  
  public void b(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void b(String paramString)
  {
    this.p = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public String c()
  {
    return this.q;
  }
  
  public void c(String paramString)
  {
    this.q = paramString;
  }
  
  public int d()
  {
    return this.r;
  }
  
  public int e()
  {
    return this.s;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof d)) && (((d)paramObject).toString().equals(toString()));
  }
  
  public void f()
  {
    this.n = System.currentTimeMillis();
  }
  
  public boolean g()
  {
    return this.o;
  }
  
  public boolean h()
  {
    return this.t;
  }
  
  public int hashCode()
  {
    return toString().hashCode();
  }
  
  public String toString()
  {
    return this.p + "://" + this.q + ":" + this.r + "#" + this.j + ":" + this.g + ":" + this.h + ":" + this.s / 1000 + ":" + this.t + ":" + this.k + ":" + this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d
 * JD-Core Version:    0.7.0.1
 */