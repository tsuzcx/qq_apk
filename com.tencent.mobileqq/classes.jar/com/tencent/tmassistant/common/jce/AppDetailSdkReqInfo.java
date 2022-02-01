package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AppDetailSdkReqInfo
  extends JceStruct
{
  public String channelId = "";
  public String packageName = "";
  
  public AppDetailSdkReqInfo() {}
  
  public AppDetailSdkReqInfo(String paramString1, String paramString2)
  {
    this.channelId = paramString1;
    this.packageName = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.channelId = paramJceInputStream.readString(0, false);
    this.packageName = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.channelId;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.packageName;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.AppDetailSdkReqInfo
 * JD-Core Version:    0.7.0.1
 */