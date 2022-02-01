package com.tencent.mobileqq.msf.core.net.c;

import android.os.Build.VERSION;
import com.tencent.mobileqq.msf.core.o;

class f$d
{
  public f.d.a a = f.d.a.a;
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
  public String n;
  
  f$d()
  {
    String str = Build.VERSION.RELEASE.replaceAll("|", "_").replaceAll("#", "_").replace("*", "_");
    this.b = (f.e() + "," + f.d() + "," + str);
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
    this.n = "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append(this.a).append(":").append(6).append("|").append(this.i).append("|").append(this.j).append("|").append(this.k).append("|").append(this.l).append("|").append(this.m).append("|").append(this.n).append("|").append(this.e).append("|").append(this.d).append("|").append(this.f).append("|").append(this.c).append("|").append(this.b).append("|").append(this.g).append("|").append(this.h).append("#");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.f.d
 * JD-Core Version:    0.7.0.1
 */