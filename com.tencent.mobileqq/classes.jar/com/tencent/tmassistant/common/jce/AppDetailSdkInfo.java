package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AppDetailSdkInfo
  extends JceStruct
{
  public String apkDownUrl = "";
  public long apkId = 0L;
  public String apkMd5 = "";
  public long appId = 0L;
  public String appName = "";
  public String channelId = "";
  public long fileSize = 0L;
  public String iconUrl = "";
  public String packageName = "";
  public String signatureMd5 = "";
  public int versionCode = 0;
  
  public AppDetailSdkInfo() {}
  
  public AppDetailSdkInfo(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, long paramLong3, String paramString6, String paramString7)
  {
    this.appId = paramLong1;
    this.apkId = paramLong2;
    this.appName = paramString1;
    this.iconUrl = paramString2;
    this.packageName = paramString3;
    this.versionCode = paramInt;
    this.signatureMd5 = paramString4;
    this.apkMd5 = paramString5;
    this.fileSize = paramLong3;
    this.apkDownUrl = paramString6;
    this.channelId = paramString7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appId = paramJceInputStream.read(this.appId, 0, false);
    this.apkId = paramJceInputStream.read(this.apkId, 1, false);
    this.appName = paramJceInputStream.readString(2, false);
    this.iconUrl = paramJceInputStream.readString(3, false);
    this.packageName = paramJceInputStream.readString(4, false);
    this.versionCode = paramJceInputStream.read(this.versionCode, 5, false);
    this.signatureMd5 = paramJceInputStream.readString(6, false);
    this.apkMd5 = paramJceInputStream.readString(7, false);
    this.fileSize = paramJceInputStream.read(this.fileSize, 8, false);
    this.apkDownUrl = paramJceInputStream.readString(9, false);
    this.channelId = paramJceInputStream.readString(10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appId, 0);
    paramJceOutputStream.write(this.apkId, 1);
    String str = this.appName;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.iconUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.packageName;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    paramJceOutputStream.write(this.versionCode, 5);
    str = this.signatureMd5;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    str = this.apkMd5;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    paramJceOutputStream.write(this.fileSize, 8);
    str = this.apkDownUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
    str = this.channelId;
    if (str != null) {
      paramJceOutputStream.write(str, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.AppDetailSdkInfo
 * JD-Core Version:    0.7.0.1
 */