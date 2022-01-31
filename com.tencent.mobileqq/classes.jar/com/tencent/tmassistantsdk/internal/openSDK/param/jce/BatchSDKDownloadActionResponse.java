package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class BatchSDKDownloadActionResponse
  extends JceStruct
{
  static ArrayList<IPCSDKDownloadInfo> a = new ArrayList();
  public ArrayList<IPCSDKDownloadInfo> batchData = null;
  public int batchRequestType = 0;
  
  static
  {
    IPCSDKDownloadInfo localIPCSDKDownloadInfo = new IPCSDKDownloadInfo();
    a.add(localIPCSDKDownloadInfo);
  }
  
  public BatchSDKDownloadActionResponse() {}
  
  public BatchSDKDownloadActionResponse(int paramInt, ArrayList<IPCSDKDownloadInfo> paramArrayList)
  {
    this.batchRequestType = paramInt;
    this.batchData = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.batchRequestType = paramJceInputStream.read(this.batchRequestType, 0, true);
    this.batchData = ((ArrayList)paramJceInputStream.read(a, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.batchRequestType, 0);
    if (this.batchData != null) {
      paramJceOutputStream.write(this.batchData, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchSDKDownloadActionResponse
 * JD-Core Version:    0.7.0.1
 */