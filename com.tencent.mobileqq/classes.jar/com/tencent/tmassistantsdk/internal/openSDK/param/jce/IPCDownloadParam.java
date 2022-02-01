package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class IPCDownloadParam
  extends JceStruct
{
  static IPCBaseParam cache_baseParam;
  public String actionFlag = "";
  public IPCBaseParam baseParam = null;
  public String opList = "";
  public String reverse = "";
  public String verifyType = "";
  
  public IPCDownloadParam() {}
  
  public IPCDownloadParam(IPCBaseParam paramIPCBaseParam, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.baseParam = paramIPCBaseParam;
    this.opList = paramString1;
    this.actionFlag = paramString2;
    this.verifyType = paramString3;
    this.reverse = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_baseParam == null) {
      cache_baseParam = new IPCBaseParam();
    }
    this.baseParam = ((IPCBaseParam)paramJceInputStream.read(cache_baseParam, 0, true));
    this.opList = paramJceInputStream.readString(1, false);
    this.actionFlag = paramJceInputStream.readString(2, false);
    this.verifyType = paramJceInputStream.readString(3, false);
    this.reverse = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.baseParam, 0);
    String str = this.opList;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.actionFlag;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.verifyType;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.reverse;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCDownloadParam
 * JD-Core Version:    0.7.0.1
 */