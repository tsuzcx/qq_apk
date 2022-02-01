package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class BatchDownloadActionResponse
  extends JceStruct
{
  static ArrayList<IPCQueryDownloadInfo> cache_batchData;
  public ArrayList<IPCQueryDownloadInfo> batchData = null;
  public int batchRequestType = 0;
  
  public BatchDownloadActionResponse() {}
  
  public BatchDownloadActionResponse(int paramInt, ArrayList<IPCQueryDownloadInfo> paramArrayList)
  {
    this.batchRequestType = paramInt;
    this.batchData = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.batchRequestType = paramJceInputStream.read(this.batchRequestType, 0, true);
    if (cache_batchData == null)
    {
      cache_batchData = new ArrayList();
      IPCQueryDownloadInfo localIPCQueryDownloadInfo = new IPCQueryDownloadInfo();
      cache_batchData.add(localIPCQueryDownloadInfo);
    }
    this.batchData = ((ArrayList)paramJceInputStream.read(cache_batchData, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.batchRequestType, 0);
    ArrayList localArrayList = this.batchData;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchDownloadActionResponse
 * JD-Core Version:    0.7.0.1
 */