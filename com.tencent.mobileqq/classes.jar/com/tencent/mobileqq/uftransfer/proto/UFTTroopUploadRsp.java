package com.tencent.mobileqq.uftransfer.proto;

import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import java.util.List;

public class UFTTroopUploadRsp
{
  private int a = 0;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private byte[] g;
  private int h;
  private List<String> i;
  private List<String> j;
  private int k = 0;
  
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
    this.b = paramString;
  }
  
  public void a(List<String> paramList)
  {
    this.i = paramList;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.g = paramArrayOfByte;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public void b(List<String> paramList)
  {
    this.j = paramList;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public void c(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public void d(String paramString)
  {
    this.e = paramString;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public void e(String paramString)
  {
    this.f = paramString;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public byte[] g()
  {
    return this.g;
  }
  
  public List<String> h()
  {
    return this.i;
  }
  
  public List<String> i()
  {
    return this.j;
  }
  
  public int j()
  {
    return this.k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UFTTroopUploadRsp{retCode=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", retMsg='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", clientWording='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileId='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uploadIp='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", serverDns='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", checkKey=");
    localStringBuilder.append(UFTDependFeatureApi.a(this.g));
    localStringBuilder.append(", busid=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", lanIpV4List=");
    Object localObject = this.i;
    String str = "null";
    if (localObject != null) {
      localObject = localObject.toString();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", lanIpV6List=");
    List localList = this.j;
    localObject = str;
    if (localList != null) {
      localObject = localList.toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", lanPort=");
    localStringBuilder.append(this.k);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.proto.UFTTroopUploadRsp
 * JD-Core Version:    0.7.0.1
 */