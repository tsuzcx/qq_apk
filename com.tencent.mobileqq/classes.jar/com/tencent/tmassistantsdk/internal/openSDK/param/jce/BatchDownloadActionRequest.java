package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class BatchDownloadActionRequest
  extends JceStruct
{
  static ArrayList<IPCDownloadParam> cache_batchData;
  public ArrayList<IPCDownloadParam> batchData = null;
  public int batchRequestType = 0;
  public String uin = "";
  public String uinType = "";
  public String via = "";
  
  public BatchDownloadActionRequest() {}
  
  public BatchDownloadActionRequest(int paramInt, ArrayList<IPCDownloadParam> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    this.batchRequestType = paramInt;
    this.batchData = paramArrayList;
    this.uin = paramString1;
    this.uinType = paramString2;
    this.via = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.batchRequestType = paramJceInputStream.read(this.batchRequestType, 0, true);
    if (cache_batchData == null)
    {
      cache_batchData = new ArrayList();
      IPCDownloadParam localIPCDownloadParam = new IPCDownloadParam();
      cache_batchData.add(localIPCDownloadParam);
    }
    this.batchData = ((ArrayList)paramJceInputStream.read(cache_batchData, 1, false));
    this.uin = paramJceInputStream.readString(2, false);
    this.uinType = paramJceInputStream.readString(3, false);
    this.via = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.batchRequestType, 0);
    Object localObject = this.batchData;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    localObject = this.uin;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.uinType;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.via;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchDownloadActionRequest
 * JD-Core Version:    0.7.0.1
 */