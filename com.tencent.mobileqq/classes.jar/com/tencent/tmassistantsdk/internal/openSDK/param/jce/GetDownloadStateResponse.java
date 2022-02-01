package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetDownloadStateResponse
  extends JceStruct
{
  static IPCBaseParam cache_requestParam;
  public int errorCode = 0;
  public String errorMsg = "";
  public IPCBaseParam requestParam = null;
  public int state = 0;
  
  public GetDownloadStateResponse() {}
  
  public GetDownloadStateResponse(IPCBaseParam paramIPCBaseParam, int paramInt1, int paramInt2, String paramString)
  {
    this.requestParam = paramIPCBaseParam;
    this.state = paramInt1;
    this.errorCode = paramInt2;
    this.errorMsg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_requestParam == null) {
      cache_requestParam = new IPCBaseParam();
    }
    this.requestParam = ((IPCBaseParam)paramJceInputStream.read(cache_requestParam, 0, true));
    this.state = paramJceInputStream.read(this.state, 1, false);
    this.errorCode = paramJceInputStream.read(this.errorCode, 2, false);
    this.errorMsg = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.requestParam, 0);
    paramJceOutputStream.write(this.state, 1);
    paramJceOutputStream.write(this.errorCode, 2);
    String str = this.errorMsg;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.param.jce.GetDownloadStateResponse
 * JD-Core Version:    0.7.0.1
 */