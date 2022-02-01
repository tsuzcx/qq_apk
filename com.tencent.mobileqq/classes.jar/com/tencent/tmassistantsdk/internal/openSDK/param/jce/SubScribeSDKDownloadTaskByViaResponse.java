package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SubScribeSDKDownloadTaskByViaResponse
  extends JceStruct
{
  static ArrayList<String> cache_viaList = new ArrayList();
  public int subscribeType = 0;
  public ArrayList<String> viaList = null;
  
  static
  {
    cache_viaList.add("");
  }
  
  public SubScribeSDKDownloadTaskByViaResponse() {}
  
  public SubScribeSDKDownloadTaskByViaResponse(ArrayList<String> paramArrayList, int paramInt)
  {
    this.viaList = paramArrayList;
    this.subscribeType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.viaList = ((ArrayList)paramJceInputStream.read(cache_viaList, 0, true));
    this.subscribeType = paramJceInputStream.read(this.subscribeType, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.viaList, 0);
    paramJceOutputStream.write(this.subscribeType, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.param.jce.SubScribeSDKDownloadTaskByViaResponse
 * JD-Core Version:    0.7.0.1
 */