package com.tencent.mobileqq.uftransfer.task.taskinfo;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.proto.UFTTroopUploadRsp;
import java.util.List;

public class UFTUploadSrvBusiProp$TroopUploadSrvBusiProp
  extends UFTUploadSrvBusiProp.BaseUploadSrvBusiProp
{
  private boolean a = false;
  private String b;
  private String c;
  private UFTTroopUploadRsp d;
  
  public UFTUploadSrvBusiProp$TroopUploadSrvBusiProp(UFTTroopUploadRsp paramUFTTroopUploadRsp)
  {
    this.d = paramUFTTroopUploadRsp;
  }
  
  public void c(String paramString)
  {
    this.b = paramString;
  }
  
  public void d(String paramString)
  {
    this.c = paramString;
  }
  
  public String g()
  {
    return this.b;
  }
  
  public String h()
  {
    return this.c;
  }
  
  public byte[] i()
  {
    UFTTroopUploadRsp localUFTTroopUploadRsp = this.d;
    if (localUFTTroopUploadRsp != null) {
      return localUFTTroopUploadRsp.g();
    }
    return null;
  }
  
  public String j()
  {
    UFTTroopUploadRsp localUFTTroopUploadRsp = this.d;
    if (localUFTTroopUploadRsp != null) {
      return localUFTTroopUploadRsp.d();
    }
    return "";
  }
  
  public byte[] k()
  {
    UFTTroopUploadRsp localUFTTroopUploadRsp = this.d;
    if ((localUFTTroopUploadRsp != null) && (!TextUtils.isEmpty(localUFTTroopUploadRsp.d()))) {
      return this.d.d().getBytes();
    }
    return null;
  }
  
  public List<String> l()
  {
    UFTTroopUploadRsp localUFTTroopUploadRsp = this.d;
    if (localUFTTroopUploadRsp != null) {
      return localUFTTroopUploadRsp.h();
    }
    return null;
  }
  
  public List<String> m()
  {
    UFTTroopUploadRsp localUFTTroopUploadRsp = this.d;
    if (localUFTTroopUploadRsp != null) {
      return localUFTTroopUploadRsp.i();
    }
    return null;
  }
  
  public int n()
  {
    UFTTroopUploadRsp localUFTTroopUploadRsp = this.d;
    if (localUFTTroopUploadRsp != null) {
      return localUFTTroopUploadRsp.j();
    }
    return 0;
  }
  
  public String o()
  {
    UFTTroopUploadRsp localUFTTroopUploadRsp = this.d;
    if (localUFTTroopUploadRsp != null) {
      return localUFTTroopUploadRsp.e();
    }
    return "";
  }
  
  public String p()
  {
    UFTTroopUploadRsp localUFTTroopUploadRsp = this.d;
    if (localUFTTroopUploadRsp != null) {
      return localUFTTroopUploadRsp.f();
    }
    return "";
  }
  
  public byte[] q()
  {
    UFTTroopUploadRsp localUFTTroopUploadRsp = this.d;
    if (localUFTTroopUploadRsp != null) {
      return localUFTTroopUploadRsp.g();
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopUploadSrvBusiProp{");
    localStringBuilder.append(super.toString());
    localStringBuilder.append("fileExist=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", strCheckSum='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", strSHA='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uploadRsp=");
    Object localObject = this.d;
    if (localObject != null) {
      localObject = ((UFTTroopUploadRsp)localObject).toString();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.TroopUploadSrvBusiProp
 * JD-Core Version:    0.7.0.1
 */