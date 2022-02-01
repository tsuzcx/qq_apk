package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetInstallStateResponse
  extends JceStruct
{
  static IPCBaseParam cache_requestParam = new IPCBaseParam();
  public IPCBaseParam requestParam = null;
  public int state = 0;
  
  public GetInstallStateResponse() {}
  
  public GetInstallStateResponse(IPCBaseParam paramIPCBaseParam, int paramInt)
  {
    this.requestParam = paramIPCBaseParam;
    this.state = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.requestParam = ((IPCBaseParam)paramJceInputStream.read(cache_requestParam, 0, true));
    this.state = paramJceInputStream.read(this.state, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.requestParam, 0);
    paramJceOutputStream.write(this.state, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.param.jce.GetInstallStateResponse
 * JD-Core Version:    0.7.0.1
 */