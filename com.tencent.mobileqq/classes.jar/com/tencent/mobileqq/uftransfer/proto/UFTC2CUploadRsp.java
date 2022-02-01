package com.tencent.mobileqq.uftransfer.proto;

import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import java.util.List;

public class UFTC2CUploadRsp
{
  private int a = 0;
  private String b = "";
  private long c = 0L;
  private long d = 0L;
  private long e = 0L;
  private String f = "";
  private short g = 0;
  private byte[] h = null;
  private byte[] i = null;
  private boolean j = false;
  private int k = 0;
  private byte[] l;
  private int m = -1;
  private byte[] n = null;
  private byte[] o = null;
  private int p = 0;
  private String q = "";
  private short r = 0;
  private String s = "";
  private String t = "";
  private byte[] u;
  private boolean v = false;
  private byte[] w = null;
  private String x = "";
  private List<String> y;
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(List<String> paramList)
  {
    this.y = paramList;
  }
  
  public void a(short paramShort)
  {
    this.g = paramShort;
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.h = paramArrayOfByte;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public void b(short paramShort)
  {
    this.r = paramShort;
  }
  
  public void b(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    this.i = paramArrayOfByte;
  }
  
  public String c()
  {
    return this.f;
  }
  
  public void c(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void c(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void c(String paramString)
  {
    this.q = paramString;
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    this.n = paramArrayOfByte;
  }
  
  public short d()
  {
    return this.g;
  }
  
  public void d(String paramString)
  {
    this.s = paramString;
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    this.u = paramArrayOfByte;
  }
  
  public void e(String paramString)
  {
    this.t = paramString;
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    this.w = paramArrayOfByte;
  }
  
  public byte[] e()
  {
    return this.h;
  }
  
  public void f(String paramString)
  {
    this.x = paramString;
  }
  
  public byte[] f()
  {
    return this.i;
  }
  
  public boolean g()
  {
    return this.j;
  }
  
  public byte[] h()
  {
    return this.n;
  }
  
  public int i()
  {
    return this.p;
  }
  
  public String j()
  {
    return this.q;
  }
  
  public short k()
  {
    return this.r;
  }
  
  public String l()
  {
    return this.s;
  }
  
  public byte[] m()
  {
    return this.u;
  }
  
  public boolean n()
  {
    return this.v;
  }
  
  public byte[] o()
  {
    return this.w;
  }
  
  public String p()
  {
    return this.x;
  }
  
  public List<String> q()
  {
    return this.y;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UFTC2CUploadRsp{retCode=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", retMsg='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", totalSpace=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", usedSpace=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", fileSize=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", strIP='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", port=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", uuid=");
    localStringBuilder.append(UFTDependFeatureApi.a(this.h));
    localStringBuilder.append(", key=");
    localStringBuilder.append(UFTDependFeatureApi.a(this.i));
    localStringBuilder.append(", fileExist=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", packetSize=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", md5=");
    localStringBuilder.append(UFTDependFeatureApi.a(this.l));
    localStringBuilder.append(", retStat=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", sha=");
    localStringBuilder.append(UFTDependFeatureApi.a(this.n));
    localStringBuilder.append(", sha3=");
    localStringBuilder.append(UFTDependFeatureApi.a(this.o));
    localStringBuilder.append(", httpsvrApiVer=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", strHttpsDomain='");
    localStringBuilder.append(this.q);
    localStringBuilder.append('\'');
    localStringBuilder.append(", httpsPort=");
    localStringBuilder.append(this.r);
    localStringBuilder.append(", dnsIPv6='");
    localStringBuilder.append(this.s);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lanIp='");
    localStringBuilder.append(this.t);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bufRspPbContent=");
    byte[] arrayOfByte = this.u;
    int i1;
    if (arrayOfByte != null) {
      i1 = arrayOfByte.length;
    } else {
      i1 = 0;
    }
    localStringBuilder.append(i1);
    localStringBuilder.append(", useMediaPlatform=");
    localStringBuilder.append(this.v);
    localStringBuilder.append(", mediaPlatformUploadKey=");
    localStringBuilder.append(UFTDependFeatureApi.a(this.w));
    localStringBuilder.append(", strFileidcrc='");
    localStringBuilder.append(this.x);
    localStringBuilder.append('\'');
    localStringBuilder.append(", listIp=");
    localStringBuilder.append(this.y);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.proto.UFTC2CUploadRsp
 * JD-Core Version:    0.7.0.1
 */