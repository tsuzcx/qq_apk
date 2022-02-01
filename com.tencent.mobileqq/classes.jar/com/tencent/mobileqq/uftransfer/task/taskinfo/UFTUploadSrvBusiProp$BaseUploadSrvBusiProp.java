package com.tencent.mobileqq.uftransfer.task.taskinfo;

import java.util.List;

public class UFTUploadSrvBusiProp$BaseUploadSrvBusiProp
{
  private List<String> a;
  private String b;
  private boolean c = false;
  private String d;
  private boolean e = false;
  private boolean f = false;
  
  public List<String> a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(List<String> paramList)
  {
    this.a = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.f;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", hostList=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", urlParam='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", useHttps=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", httpsDomain='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", useIpV6=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", useDnsIpV6=");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.BaseUploadSrvBusiProp
 * JD-Core Version:    0.7.0.1
 */