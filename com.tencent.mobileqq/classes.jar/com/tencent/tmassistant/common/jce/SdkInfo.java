package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SdkInfo
  extends JceStruct
{
  public String builderNum = "";
  public String channel = "";
  public String name = "";
  public String subChannel = "";
  public int versionCode = 0;
  public String versionName = "";
  
  public SdkInfo() {}
  
  public SdkInfo(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    this.name = paramString1;
    this.versionName = paramString2;
    this.versionCode = paramInt;
    this.channel = paramString3;
    this.subChannel = paramString4;
    this.builderNum = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.name = paramJceInputStream.readString(0, false);
    this.versionName = paramJceInputStream.readString(1, false);
    this.versionCode = paramJceInputStream.read(this.versionCode, 2, false);
    this.channel = paramJceInputStream.readString(3, false);
    this.subChannel = paramJceInputStream.readString(4, false);
    this.builderNum = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 0);
    }
    if (this.versionName != null) {
      paramJceOutputStream.write(this.versionName, 1);
    }
    paramJceOutputStream.write(this.versionCode, 2);
    if (this.channel != null) {
      paramJceOutputStream.write(this.channel, 3);
    }
    if (this.subChannel != null) {
      paramJceOutputStream.write(this.subChannel, 4);
    }
    if (this.builderNum != null) {
      paramJceOutputStream.write(this.builderNum, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.SdkInfo
 * JD-Core Version:    0.7.0.1
 */