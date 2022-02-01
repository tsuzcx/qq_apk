package com.tencent.mobileqq.msf.core.net.c;

import android.os.Build.VERSION;
import com.tencent.mobileqq.msf.core.o;

class c$d
{
  public c.d.a a = c.d.a.a;
  public String b;
  public int c;
  public long d;
  public long e;
  public long f;
  public long g;
  public long h;
  public String i;
  public String j;
  public String k;
  public long l;
  public String m;
  
  c$d()
  {
    String str = Build.VERSION.RELEASE.replaceAll("|", "_").replaceAll("#", "_").replace("*", "_");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c.e());
    localStringBuilder.append(",");
    localStringBuilder.append(c.d());
    localStringBuilder.append(",");
    localStringBuilder.append(str);
    this.b = localStringBuilder.toString();
    this.c = 0;
    this.d = 0L;
    this.e = 0L;
    this.f = 0L;
    this.g = 0L;
    this.h = 0L;
    this.i = "";
    this.j = "0.0.0.0";
    this.k = o.e();
    this.l = 0L;
    this.m = "0,0";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append(this.a);
    localStringBuilder.append(":");
    localStringBuilder.append(5);
    localStringBuilder.append("|");
    localStringBuilder.append(this.i);
    localStringBuilder.append("|");
    localStringBuilder.append(this.j);
    localStringBuilder.append("|");
    localStringBuilder.append(this.k);
    localStringBuilder.append("|");
    localStringBuilder.append(this.l);
    localStringBuilder.append("|");
    localStringBuilder.append(this.m);
    localStringBuilder.append("|");
    localStringBuilder.append(this.e);
    localStringBuilder.append("|");
    localStringBuilder.append(this.d);
    localStringBuilder.append("|");
    localStringBuilder.append(this.f);
    localStringBuilder.append("|");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    localStringBuilder.append(this.g);
    localStringBuilder.append("|");
    localStringBuilder.append(this.h);
    localStringBuilder.append("#");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.c.d
 * JD-Core Version:    0.7.0.1
 */