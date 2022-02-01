package com.tencent.qapmsdk.impl.a.a;

import com.tencent.qapmsdk.impl.b.b;
import com.tencent.qapmsdk.impl.b.d;
import com.tencent.qapmsdk.impl.instrumentation.l.d;

public class a
{
  private String A;
  private final long a;
  private final long b;
  private final String c = a(paramString1);
  private final String d;
  private int e;
  private final int f;
  private int g;
  private int h;
  private final Object i = new Object();
  private final long j;
  private final long k;
  private final String l;
  private d m;
  private b n;
  private final String o;
  private int p;
  private int q = -1;
  private String r;
  private int s;
  private String t;
  private int u;
  private int v;
  private int w;
  private String x;
  private String y = "";
  private l.d z;
  
  public a(String paramString1, String paramString2, long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, String paramString3, String paramString4, String paramString5, d paramd, b paramb, int paramInt4, String paramString6, int paramInt5, int paramInt6, int paramInt7, String paramString7, String paramString8, int paramInt8, String paramString9, String paramString10, int paramInt9)
  {
    this.d = paramString2;
    this.a = paramLong1;
    this.e = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
    this.j = paramLong2;
    this.k = paramLong3;
    this.l = paramString3;
    this.b = System.currentTimeMillis();
    this.o = paramString4;
    this.m = paramd;
    this.n = paramb;
    this.s = paramInt4;
    this.t = paramString6;
    this.u = paramInt5;
    this.v = paramInt6;
    this.w = paramInt7;
    this.y = paramString7;
    this.x = paramString8;
    this.f = paramInt8;
    this.z = this.z;
    this.A = paramString9;
    this.r = paramString10;
    this.p = paramInt9;
  }
  
  private String a(String paramString)
  {
    int i2 = paramString.indexOf("?");
    int i1 = i2;
    if (i2 < 0)
    {
      i2 = paramString.indexOf(";");
      i1 = i2;
      if (i2 < 0) {
        i1 = paramString.length();
      }
    }
    return paramString.substring(0, i1);
  }
  
  public String a()
  {
    return this.r;
  }
  
  public void a(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void a(b paramb)
  {
    this.n = paramb;
  }
  
  public String b()
  {
    return this.x;
  }
  
  public void b(int paramInt)
  {
    this.v = paramInt;
  }
  
  public int c()
  {
    return this.s;
  }
  
  public void c(int paramInt)
  {
    this.u = paramInt;
  }
  
  public int d()
  {
    return this.u;
  }
  
  public void d(int paramInt)
  {
    this.w = paramInt;
  }
  
  public int e()
  {
    return this.v;
  }
  
  public void e(int paramInt)
  {
    synchronized (this.i)
    {
      this.h = paramInt;
      return;
    }
  }
  
  public int f()
  {
    return this.w;
  }
  
  public String g()
  {
    return this.c;
  }
  
  public int h()
  {
    return this.g;
  }
  
  public int i()
  {
    synchronized (this.i)
    {
      int i1 = this.h;
      return i1;
    }
  }
  
  public int j()
  {
    return this.e;
  }
  
  public long k()
  {
    return this.a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("url:" + this.c).append(" carrier:" + this.d).append(" time:" + this.e).append(" statusCode:" + this.g).append(" errorCode:" + this.h).append(" byteSent:" + this.j).append(" bytesReceived:" + this.k).append(" appData:" + this.l).append(" formattedUrlParams:" + this.o).append(" requestMethodType:" + this.m).append(" cdnHeaderName :" + this.y).append("contentType : " + this.x);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.a.a.a
 * JD-Core Version:    0.7.0.1
 */