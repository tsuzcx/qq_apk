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
    Object localObject = paramString.toLowerCase();
    paramString = new d();
    localObject = l.matcher((CharSequence)localObject);
    if (((Matcher)localObject).find())
    {
      if (((Matcher)localObject).group(1) != null)
      {
        paramString.n = ((Matcher)localObject).group(1);
        if (TextUtils.equals("https", paramString.n)) {
          paramString.n = "http";
        }
      }
      if (((Matcher)localObject).group(2) != null)
      {
        paramString.o = ((Matcher)localObject).group(2);
        if ((paramString.o.startsWith("[")) && (paramString.o.endsWith("]")))
        {
          String str = paramString.o;
          paramString.o = str.substring(1, str.length() - 1);
          paramString.q = 2;
          paramString.p = false;
        }
        else if ((!"msfwifiv6.3g.qq.com".equals(paramString.o)) && (!"msfxgv6.3g.qq.com".equals(paramString.o)))
        {
          paramString.p = (m.matcher(paramString.o).matches() ^ true);
          paramString.q = 1;
          if (paramString.p) {
            break label229;
          }
        }
      }
    }
    try
    {
      if (!(InetAddress.getByName(paramString.o) instanceof Inet6Address)) {
        break label229;
      }
      paramString.q = 2;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      label216:
      break label216;
    }
    break label229;
    paramString.q = 2;
    paramString.p = true;
    label229:
    if (((Matcher)localObject).group(4) != null) {
      paramString.r = Integer.parseInt(((Matcher)localObject).group(4));
    } else {
      paramString.r = 80;
    }
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
  }
  
  private static void a(d paramd, byte paramByte1, String paramString1, int paramInt1, int paramInt2, byte paramByte2, int paramInt3, byte paramByte3, String paramString2, String paramString3, String paramString4)
  {
    if ((paramByte1 != 2) && (paramByte1 != 3))
    {
      if ((paramByte1 == 0) || (paramByte1 == 1)) {
        paramd.n = "socket";
      }
    }
    else {
      paramd.n = "http";
    }
    paramd.o = paramString1;
    paramd.q = paramInt1;
    paramd.p = (m.matcher(paramString1).matches() ^ true);
    paramd.r = paramInt2;
    paramd.e = 0;
    paramd.f = paramByte2;
    if (paramInt3 > 20) {
      paramd.s = 20000;
    } else if (paramInt3 < 5) {
      paramd.s = 5000;
    } else {
      paramd.s = (paramInt3 * 1000);
    }
    if (paramByte3 == 1) {
      paramd.t = true;
    }
    paramd.i = paramString2;
    paramd.j = paramString3;
    paramd.h = "";
    if ("Wifi".equals(paramString4))
    {
      paramd.h = "00000";
      paramd.a(true);
      return;
    }
    paramd.a(false);
  }
  
  public String a()
  {
    if ((2 == this.q) && (!this.p))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.o);
      ((StringBuilder)localObject).append("]");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = this.o;
    }
    Object localObject = new StringBuilder((String)localObject);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(this.r);
    return ((StringBuilder)localObject).toString();
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
    long l1 = System.currentTimeMillis();
    if ((parama != com.tencent.qphone.base.a.d) && (parama != com.tencent.qphone.base.a.c))
    {
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
    else
    {
      long l2 = this.v;
      if ((l2 != 0L) && (l1 - l2 <= 600000L))
      {
        this.u.addAndGet(com.tencent.mobileqq.msf.core.a.a.aS());
      }
      else
      {
        this.v = l1;
        this.u.incrementAndGet();
      }
    }
    if (this.u.get() > 19)
    {
      this.u.set(0);
      return true;
    }
    return false;
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
    StringBuilder localStringBuilder = new StringBuilder(this.n);
    localStringBuilder.append("://");
    Object localObject;
    if ((2 == this.q) && (!this.p))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.o);
      ((StringBuilder)localObject).append("]");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = this.o;
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(":");
    localStringBuilder.append(this.r);
    localStringBuilder.append("#");
    localStringBuilder.append(this.h);
    localStringBuilder.append(":");
    localStringBuilder.append(this.e);
    localStringBuilder.append(":");
    localStringBuilder.append(this.f);
    localStringBuilder.append(":");
    localStringBuilder.append(this.s / 1000);
    localStringBuilder.append(":");
    localStringBuilder.append(this.t);
    localStringBuilder.append(":");
    localStringBuilder.append(this.i);
    localStringBuilder.append(":");
    localStringBuilder.append(this.j);
    localStringBuilder.append(":");
    localStringBuilder.append(this.q);
    localStringBuilder.append(":");
    localStringBuilder.append(this.p);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d
 * JD-Core Version:    0.7.0.1
 */