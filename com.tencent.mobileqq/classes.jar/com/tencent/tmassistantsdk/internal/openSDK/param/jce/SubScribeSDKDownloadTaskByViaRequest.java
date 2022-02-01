package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SubScribeSDKDownloadTaskByViaRequest
  extends JceStruct
{
  static ArrayList<IPCSDKDownloadInfo> cache_data;
  static ArrayList<String> cache_viaList = new ArrayList();
  public ArrayList<IPCSDKDownloadInfo> data = null;
  public ArrayList<String> viaList = null;
  
  static
  {
    cache_viaList.add("");
    cache_data = new ArrayList();
    IPCSDKDownloadInfo localIPCSDKDownloadInfo = new IPCSDKDownloadInfo();
    cache_data.add(localIPCSDKDownloadInfo);
  }
  
  public SubScribeSDKDownloadTaskByViaRequest() {}
  
  public SubScribeSDKDownloadTaskByViaRequest(ArrayList<String> paramArrayList, ArrayList<IPCSDKDownloadInfo> paramArrayList1)
  {
    this.viaList = paramArrayList;
    this.data = paramArrayList1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.viaList = ((ArrayList)paramJceInputStream.read(cache_viaList, 0, true));
    this.data = ((ArrayList)paramJceInputStream.read(cache_data, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.viaList, 0);
    if (this.data != null) {
      paramJceOutputStream.write(this.data, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.param.jce.SubScribeSDKDownloadTaskByViaRequest
 * JD-Core Version:    0.7.0.1
 */