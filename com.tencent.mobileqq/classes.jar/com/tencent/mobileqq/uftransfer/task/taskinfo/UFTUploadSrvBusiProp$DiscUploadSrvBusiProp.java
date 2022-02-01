package com.tencent.mobileqq.uftransfer.task.taskinfo;

import com.tencent.mobileqq.uftransfer.proto.UFTDiscUploadRsp;

public class UFTUploadSrvBusiProp$DiscUploadSrvBusiProp
  extends UFTUploadSrvBusiProp.BaseUploadSrvBusiProp
{
  private String a;
  private String b;
  private UFTDiscUploadRsp c;
  
  public UFTUploadSrvBusiProp$DiscUploadSrvBusiProp(UFTDiscUploadRsp paramUFTDiscUploadRsp)
  {
    this.c = paramUFTDiscUploadRsp;
  }
  
  public void c(String paramString)
  {
    this.a = paramString;
  }
  
  public void d(String paramString)
  {
    this.b = paramString;
  }
  
  public String g()
  {
    return this.a;
  }
  
  public String h()
  {
    return this.b;
  }
  
  public String i()
  {
    UFTDiscUploadRsp localUFTDiscUploadRsp = this.c;
    if (localUFTDiscUploadRsp != null) {
      return localUFTDiscUploadRsp.b();
    }
    return "";
  }
  
  public String j()
  {
    UFTDiscUploadRsp localUFTDiscUploadRsp = this.c;
    if (localUFTDiscUploadRsp != null) {
      return localUFTDiscUploadRsp.f();
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DiscUploadSrvBusiProp{");
    localStringBuilder.append(super.toString());
    localStringBuilder.append("strCheckSum='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", strSHA='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uploadRsp=");
    Object localObject = this.c;
    if (localObject != null) {
      localObject = ((UFTDiscUploadRsp)localObject).toString();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.DiscUploadSrvBusiProp
 * JD-Core Version:    0.7.0.1
 */