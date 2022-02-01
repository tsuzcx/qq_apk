package com.tencent.mobileqq.uftransfer.proto;

public class UFTDiscUploadRsp
{
  private int a = 0;
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private int g = 0;
  private String h = "";
  private String i = null;
  private short j = 0;
  private String k = "";
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(short paramShort)
  {
    this.j = paramShort;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
  }
  
  public String c()
  {
    return this.e;
  }
  
  public void c(String paramString)
  {
    this.e = paramString;
  }
  
  public String d()
  {
    return this.f;
  }
  
  public void d(String paramString)
  {
    this.f = paramString;
  }
  
  public int e()
  {
    return this.g;
  }
  
  public void e(String paramString)
  {
    this.h = paramString;
  }
  
  public String f()
  {
    return this.b;
  }
  
  public void f(String paramString)
  {
    this.b = paramString;
  }
  
  public String g()
  {
    return this.i;
  }
  
  public void g(String paramString)
  {
    this.i = paramString;
  }
  
  public short h()
  {
    return this.j;
  }
  
  public void h(String paramString)
  {
    this.k = paramString;
  }
  
  public String i()
  {
    return this.k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UFTDiscUploadRsp{retCode=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", retMsg='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileId='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileKey='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", strCkeckSum='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", strHost='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", port=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", strFileName='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", strHttpsDomain='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", httpsPort=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", strIPv6Domain='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.proto.UFTDiscUploadRsp
 * JD-Core Version:    0.7.0.1
 */