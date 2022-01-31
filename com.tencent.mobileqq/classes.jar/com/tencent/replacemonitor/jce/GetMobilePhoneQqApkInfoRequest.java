package com.tencent.replacemonitor.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetMobilePhoneQqApkInfoRequest
  extends JceStruct
{
  public long apkId = 0L;
  public long appId = 0L;
  public String downloadUrl = "";
  public String pkgName = "";
  
  public GetMobilePhoneQqApkInfoRequest() {}
  
  public GetMobilePhoneQqApkInfoRequest(long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    this.apkId = paramLong1;
    this.pkgName = paramString1;
    this.appId = paramLong2;
    this.downloadUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.apkId = paramJceInputStream.read(this.apkId, 0, false);
    this.pkgName = paramJceInputStream.readString(1, false);
    this.appId = paramJceInputStream.read(this.appId, 2, false);
    this.downloadUrl = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.apkId, 0);
    if (this.pkgName != null) {
      paramJceOutputStream.write(this.pkgName, 1);
    }
    paramJceOutputStream.write(this.appId, 2);
    if (this.downloadUrl != null) {
      paramJceOutputStream.write(this.downloadUrl, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.replacemonitor.jce.GetMobilePhoneQqApkInfoRequest
 * JD-Core Version:    0.7.0.1
 */