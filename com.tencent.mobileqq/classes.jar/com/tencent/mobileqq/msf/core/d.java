package com.tencent.mobileqq.msf.core;

import android.text.TextUtils;
import com.tencent.msf.service.protocol.serverconfig.i;
import com.tencent.msf.service.protocol.serverconfig.k;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d
{
  public static final String a = "http";
  public static final String b = "socket";
  public static final String c = "quic";
  public static final String d = "00000";
  private static final String k = "EndpointKey";
  private static final Pattern l = Pattern.compile("([a-zA-Z]+)://([a-zA-Z0-9.]+|\\[[a-zA-Z0-9:]+\\])(:([0-9]+))?(#([0-9_]*))?(:([0-9]+))?(:([0-9]+))?(:([0-9]+))?(:([a-zA-Z]+))?(:([a-zA-Z]+))?(:([a-zA-Z]+))?");
  private static final Pattern m = Pattern.compile("[a-fA-F0-9:][a-fA-F0-9.:]+");
  public byte e = 1;
  public byte f = 0;
  public boolean g = false;
  public String h = "";
  public String i = "";
  public String j = "";
  private String n = "socket";
  private String o;
  private boolean p = false;
  private int q = 0;
  private int r;
  private int s = 20000;
  private boolean t = false;
  private AtomicInteger u = new AtomicInteger();
  private long v = 0L;
  private boolean w = false;
  
  public static d a(i parami, String paramString, int paramInt)
  {
    d locald = new d();
    a(locald, parami.e, parami.a, paramInt, parami.b, parami.d, parami.f, parami.g, parami.h, parami.i, paramString);
    return locald;
  }
  
  public static d a(k paramk, String paramString, int paramInt)
  {
    d locald = new d();
    a(locald, paramk.e, paramk.a, paramInt, paramk.b, paramk.d, paramk.f, paramk.g, paramk.h, paramk.i, paramString);
    return locald;
  }
  
  public static d a(String paramString)
  {
    boolean bool = false;
    Object localObject = paramString.toLowerCase();
    paramString = new d();
    localObject = l.matcher((CharSequence)localObject);
    if (((Matcher)localObject).find())
    {
      if (((Matcher)localObject).group(1) != null) {
        paramString.n = ((Matcher)localObject).group(1);
      }
      if (((Matcher)localObject).group(2) != null)
      {
        paramString.o = ((Matcher)localObject).group(2);
        if ((!paramString.o.startsWith("[")) || (!paramString.o.endsWith("]"))) {
          break label303;
        }
        paramString.o = paramString.o.substring(1, paramString.o.length() - 1);
        paramString.q = 2;
        paramString.p = false;
      }
      if (((Matcher)localObject).group(4) == null) {
        break label363;
      }
    }
    label303:
    label363:
    for (paramString.r = Integer.parseInt(((Matcher)localObject).group(4));; paramString.r = 80)
    {
      for (;;)
      {
        if (((Matcher)localObject).group(6) != null) {
          paramString.h = ((Matcher)localObject).group(6);
        }
        if (((Matcher)localObject).group(8) != null) {
          paramString.e = Byte.parseByte(((Matcher)localObject).group(8));
        }
        if (((Matcher)localObject).group(10) != null) {
          paramString.f = Byte.parseByte(((Matcher)localObject).group(10));
        }
        if (((Matcher)localObject).group(12) != null) {
          paramString.s = (Integer.parseInt(((Matcher)localObject).group(12)) * 1000);
        }
        if (((Matcher)localObject).group(14) != null) {
          paramString.t = Boolean.parseBoolean(((Matcher)localObject).group(14));
        }
        if (((Matcher)localObject).group(16) != null) {
          paramString.i = ((Matcher)localObject).group(16);
        }
        if (((Matcher)localObject).group(18) != null) {
          paramString.j = ((Matcher)localObject).group(18);
        }
        paramString.a(paramString.h.equals("00000"));
        return paramString;
        if (!m.matcher(paramString.o).matches()) {
          bool = true;
        }
        paramString.p = bool;
        paramString.q = 1;
        if (paramString.p) {
          break;
        }
        try
        {
          if (!(InetAddress.getByName(paramString.o) instanceof Inet6Address)) {
            break;
          }
          paramString.q = 2;
        }
        catch (UnknownHostException localUnknownHostException) {}
      }
      break;
    }
  }
  
  private static void a(d paramd, byte paramByte1, String paramString1, int paramInt1, int paramInt2, byte paramByte2, int paramInt3, byte paramByte3, String paramString2, String paramString3, String paramString4)
  {
    boolean bool;
    if ((paramByte1 == 2) || (paramByte1 == 3))
    {
      paramd.n = "http";
      paramd.o = paramString1;
      paramd.q = paramInt1;
      if (m.matcher(paramString1).matches()) {
        break label148;
      }
      bool = true;
      label42:
      paramd.p = bool;
      paramd.r = paramInt2;
      paramd.e = 0;
      paramd.f = paramByte2;
      if (paramInt3 <= 20) {
        break label154;
      }
      paramd.s = 20000;
    }
    for (;;)
    {
      if (paramByte3 == 1) {
        paramd.t = true;
      }
      paramd.i = paramString2;
      paramd.j = paramString3;
      paramd.h = "";
      if (!"Wifi".equals(paramString4)) {
        break label183;
      }
      paramd.h = "00000";
      paramd.a(true);
      return;
      if ((paramByte1 != 0) && (paramByte1 != 1)) {
        break;
      }
      paramd.n = "socket";
      break;
      label148:
      bool = false;
      break label42;
      label154:
      if (paramInt3 < 5) {
        paramd.s = 5000;
      } else {
        paramd.s = (paramInt3 * 1000);
      }
    }
    label183:
    paramd.a(false);
  }
  
  public String a()
  {
    if ((2 == this.q) && (!this.p)) {}
    for (String str = "[" + this.o + "]";; str = this.o) {
      return str + ":" + this.r;
    }
  }
  
  public void a(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public boolean a(com.tencent.qphone.base.a parama)
  {
    boolean bool = false;
    long l1 = System.currentTimeMillis();
    if ((parama == com.tencent.qphone.base.a.d) || (parama == com.tencent.qphone.base.a.c)) {
      if ((this.v == 0L) || (l1 - this.v > 600000L))
      {
        this.v = l1;
        this.u.incrementAndGet();
      }
    }
    for (;;)
    {
      if (this.u.get() > 19)
      {
        this.u.set(0);
        bool = true;
      }
      return bool;
      this.u.addAndGet(com.tencent.mobileqq.msf.core.a.a.aS());
      continue;
      if (parama == com.tencent.qphone.base.a.e) {
        this.u.addAndGet(com.tencent.mobileqq.msf.core.a.a.aT());
      } else if (parama == com.tencent.qphone.base.a.B) {
        this.u.addAndGet(com.tencent.mobileqq.msf.core.a.a.aU());
      } else if (parama == com.tencent.qphone.base.a.p) {
        this.u.addAndGet(com.tencent.mobileqq.msf.core.a.a.aV());
      } else if (parama == com.tencent.qphone.base.a.j) {
        this.u.addAndGet(com.tencent.mobileqq.msf.core.a.a.aW());
      } else if (parama == com.tencent.qphone.base.a.i) {
        this.u.addAndGet(com.tencent.mobileqq.msf.core.a.a.aX());
      }
    }
  }
  
  public String b()
  {
    return this.n;
  }
  
  public void b(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void b(String paramString)
  {
    this.n = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public String c()
  {
    return this.o;
  }
  
  public void c(String paramString)
  {
    this.o = paramString;
  }
  
  public int d()
  {
    return this.q;
  }
  
  public boolean e()
  {
    return this.p;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof d)) && (((d)paramObject).toString().equals(toString()));
  }
  
  public int f()
  {
    return this.r;
  }
  
  public int g()
  {
    return this.s;
  }
  
  public void h()
  {
    this.v = System.currentTimeMillis();
  }
  
  public int hashCode()
  {
    return toString().hashCode();
  }
  
  public boolean i()
  {
    return this.w;
  }
  
  public boolean j()
  {
    return this.t;
  }
  
  public boolean k()
  {
    return (!TextUtils.isEmpty(this.o)) && (!"null".equals(this.o));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.n).append("://");
    if ((2 == this.q) && (!this.p)) {}
    for (String str = "[" + this.o + "]";; str = this.o) {
      return str + ":" + this.r + "#" + this.h + ":" + this.e + ":" + this.f + ":" + this.s / 1000 + ":" + this.t + ":" + this.i + ":" + this.j + ":" + this.q + ":" + this.p;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d
 * JD-Core Version:    0.7.0.1
 */