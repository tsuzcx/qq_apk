package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class IPCSDKDownloadInfo
  extends JceStruct
{
  public String appIconUrl = "";
  public String appId = "";
  public String appName = "";
  public int appState = 0;
  public long downloadFinishTime = 0L;
  public String extra = "";
  public String grayVersionCode = "";
  public long installFinishTime = 0L;
  public String packageName = "";
  public long receivedLen = 0L;
  public long totalLen = 0L;
  public String url = "";
  public String versionCode = "";
  public String via = "";
  
  public IPCSDKDownloadInfo() {}
  
  public IPCSDKDownloadInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    this.packageName = paramString1;
    this.appId = paramString2;
    this.appName = paramString3;
    this.appIconUrl = paramString4;
    this.appState = paramInt;
    this.receivedLen = paramLong1;
    this.totalLen = paramLong2;
    this.downloadFinishTime = paramLong3;
    this.installFinishTime = paramLong4;
    this.via = paramString5;
    this.extra = paramString6;
    this.url = paramString7;
    this.versionCode = paramString8;
    this.grayVersionCode = paramString9;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.packageName = paramJceInputStream.readString(0, true);
    this.appId = paramJceInputStream.readString(1, false);
    this.appName = paramJceInputStream.readString(3, false);
    this.appIconUrl = paramJceInputStream.readString(4, false);
    this.appState = paramJceInputStream.read(this.appState, 5, false);
    this.receivedLen = paramJceInputStream.read(this.receivedLen, 6, false);
    this.totalLen = paramJceInputStream.read(this.totalLen, 7, false);
    this.downloadFinishTime = paramJceInputStream.read(this.downloadFinishTime, 8, false);
    this.installFinishTime = paramJceInputStream.read(this.installFinishTime, 9, false);
    this.via = paramJceInputStream.readString(10, false);
    this.extra = paramJceInputStream.readString(11, false);
    this.url = paramJceInputStream.readString(12, false);
    this.versionCode = paramJceInputStream.readString(13, false);
    this.grayVersionCode = paramJceInputStream.readString(14, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.packageName, 0);
    String str = this.appId;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.appName;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.appIconUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    paramJceOutputStream.write(this.appState, 5);
    paramJceOutputStream.write(this.receivedLen, 6);
    paramJceOutputStream.write(this.totalLen, 7);
    paramJceOutputStream.write(this.downloadFinishTime, 8);
    paramJceOutputStream.write(this.installFinishTime, 9);
    str = this.via;
    if (str != null) {
      paramJceOutputStream.write(str, 10);
    }
    str = this.extra;
    if (str != null) {
      paramJceOutputStream.write(str, 11);
    }
    str = this.url;
    if (str != null) {
      paramJceOutputStream.write(str, 12);
    }
    str = this.versionCode;
    if (str != null) {
      paramJceOutputStream.write(str, 13);
    }
    str = this.grayVersionCode;
    if (str != null) {
      paramJceOutputStream.write(str, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCSDKDownloadInfo
 * JD-Core Version:    0.7.0.1
 */