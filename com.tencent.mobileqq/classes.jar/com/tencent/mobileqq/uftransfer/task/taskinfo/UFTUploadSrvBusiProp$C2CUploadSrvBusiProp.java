package com.tencent.mobileqq.uftransfer.task.taskinfo;

import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.proto.UFTC2CUploadRsp;

public class UFTUploadSrvBusiProp$C2CUploadSrvBusiProp
  extends UFTUploadSrvBusiProp.BaseUploadSrvBusiProp
{
  protected boolean a = false;
  protected final UFTC2CUploadRsp b;
  private boolean c = false;
  private String d;
  private String e;
  
  public UFTUploadSrvBusiProp$C2CUploadSrvBusiProp(UFTC2CUploadRsp paramUFTC2CUploadRsp)
  {
    this.b = paramUFTC2CUploadRsp;
    paramUFTC2CUploadRsp = this.b;
    if (paramUFTC2CUploadRsp != null)
    {
      this.c = paramUFTC2CUploadRsp.g();
      this.a = this.b.n();
      if ((this.b.h() != null) && (this.b.h().length > 0)) {
        this.e = UFTDependFeatureApi.b(this.b.h());
      }
    }
  }
  
  public void c(String paramString)
  {
    this.e = paramString;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public void d(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean g()
  {
    return this.c;
  }
  
  public byte[] h()
  {
    UFTC2CUploadRsp localUFTC2CUploadRsp = this.b;
    if (localUFTC2CUploadRsp != null) {
      return localUFTC2CUploadRsp.e();
    }
    return null;
  }
  
  public byte[] i()
  {
    UFTC2CUploadRsp localUFTC2CUploadRsp = this.b;
    if (localUFTC2CUploadRsp != null) {
      return localUFTC2CUploadRsp.h();
    }
    return null;
  }
  
  public String j()
  {
    return this.e;
  }
  
  public String k()
  {
    return this.d;
  }
  
  public int l()
  {
    UFTC2CUploadRsp localUFTC2CUploadRsp = this.b;
    if (localUFTC2CUploadRsp != null) {
      return localUFTC2CUploadRsp.i();
    }
    return 0;
  }
  
  public byte[] m()
  {
    UFTC2CUploadRsp localUFTC2CUploadRsp = this.b;
    if (localUFTC2CUploadRsp != null) {
      return localUFTC2CUploadRsp.f();
    }
    return null;
  }
  
  public boolean n()
  {
    return this.a;
  }
  
  public String o()
  {
    UFTC2CUploadRsp localUFTC2CUploadRsp = this.b;
    if (localUFTC2CUploadRsp != null) {
      return localUFTC2CUploadRsp.p();
    }
    return "";
  }
  
  public byte[] p()
  {
    UFTC2CUploadRsp localUFTC2CUploadRsp = this.b;
    if (localUFTC2CUploadRsp != null) {
      return localUFTC2CUploadRsp.o();
    }
    return null;
  }
  
  public byte[] q()
  {
    UFTC2CUploadRsp localUFTC2CUploadRsp = this.b;
    if (localUFTC2CUploadRsp != null) {
      return localUFTC2CUploadRsp.m();
    }
    return null;
  }
  
  public String r()
  {
    UFTC2CUploadRsp localUFTC2CUploadRsp = this.b;
    if (localUFTC2CUploadRsp != null) {
      return localUFTC2CUploadRsp.b();
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("C2CUploadSrvBusiProp{");
    localStringBuilder.append(super.toString());
    localStringBuilder.append("fileExist=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", strCheckSum='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", strSHA='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", useMediaPlatform=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", uploadRsp=");
    Object localObject = this.b;
    if (localObject != null) {
      localObject = ((UFTC2CUploadRsp)localObject).toString();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.C2CUploadSrvBusiProp
 * JD-Core Version:    0.7.0.1
 */