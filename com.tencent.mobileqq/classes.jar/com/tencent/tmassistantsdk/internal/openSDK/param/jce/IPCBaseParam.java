package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class IPCBaseParam
  extends JceStruct
{
  public String channelId = "";
  public String extra = "";
  public String hostAppId = "";
  public String taskAppId = "";
  public String taskPackageName = "";
  public String taskVersion = "";
  public String uin = "";
  public String uinType = "";
  public String via = "";
  
  public IPCBaseParam() {}
  
  public IPCBaseParam(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    this.hostAppId = paramString1;
    this.taskAppId = paramString2;
    this.taskVersion = paramString3;
    this.taskPackageName = paramString4;
    this.uin = paramString5;
    this.uinType = paramString6;
    this.via = paramString7;
    this.channelId = paramString8;
    this.extra = paramString9;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.hostAppId = paramJceInputStream.readString(0, true);
    this.taskAppId = paramJceInputStream.readString(1, false);
    this.taskVersion = paramJceInputStream.readString(2, true);
    this.taskPackageName = paramJceInputStream.readString(3, true);
    this.uin = paramJceInputStream.readString(4, false);
    this.uinType = paramJceInputStream.readString(5, false);
    this.via = paramJceInputStream.readString(6, false);
    this.channelId = paramJceInputStream.readString(7, false);
    this.extra = paramJceInputStream.readString(8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.hostAppId, 0);
    if (this.taskAppId != null) {
      paramJceOutputStream.write(this.taskAppId, 1);
    }
    paramJceOutputStream.write(this.taskVersion, 2);
    paramJceOutputStream.write(this.taskPackageName, 3);
    if (this.uin != null) {
      paramJceOutputStream.write(this.uin, 4);
    }
    if (this.uinType != null) {
      paramJceOutputStream.write(this.uinType, 5);
    }
    if (this.via != null) {
      paramJceOutputStream.write(this.via, 6);
    }
    if (this.channelId != null) {
      paramJceOutputStream.write(this.channelId, 7);
    }
    if (this.extra != null) {
      paramJceOutputStream.write(this.extra, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam
 * JD-Core Version:    0.7.0.1
 */