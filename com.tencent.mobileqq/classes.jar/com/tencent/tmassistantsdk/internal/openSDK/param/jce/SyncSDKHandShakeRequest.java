package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SyncSDKHandShakeRequest
  extends JceStruct
{
  public String extra = "";
  
  public SyncSDKHandShakeRequest() {}
  
  public SyncSDKHandShakeRequest(String paramString)
  {
    this.extra = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.extra = paramJceInputStream.readString(0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.extra, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.param.jce.SyncSDKHandShakeRequest
 * JD-Core Version:    0.7.0.1
 */