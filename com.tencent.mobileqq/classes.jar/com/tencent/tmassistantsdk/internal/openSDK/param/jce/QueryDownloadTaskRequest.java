package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QueryDownloadTaskRequest
  extends JceStruct
{
  static IPCBaseParam a;
  public IPCBaseParam baseParam = null;
  
  public QueryDownloadTaskRequest() {}
  
  public QueryDownloadTaskRequest(IPCBaseParam paramIPCBaseParam)
  {
    this.baseParam = paramIPCBaseParam;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (a == null) {
      a = new IPCBaseParam();
    }
    this.baseParam = ((IPCBaseParam)paramJceInputStream.read(a, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.baseParam, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.param.jce.QueryDownloadTaskRequest
 * JD-Core Version:    0.7.0.1
 */