package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetAppDetailForSdkRequest
  extends JceStruct
{
  static ArrayList<AppDetailSdkReqInfo> cache_reqList = new ArrayList();
  public String biz = "";
  public ArrayList<AppDetailSdkReqInfo> reqList = null;
  
  static
  {
    AppDetailSdkReqInfo localAppDetailSdkReqInfo = new AppDetailSdkReqInfo();
    cache_reqList.add(localAppDetailSdkReqInfo);
  }
  
  public GetAppDetailForSdkRequest() {}
  
  public GetAppDetailForSdkRequest(ArrayList<AppDetailSdkReqInfo> paramArrayList, String paramString)
  {
    this.reqList = paramArrayList;
    this.biz = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reqList = ((ArrayList)paramJceInputStream.read(cache_reqList, 0, false));
    this.biz = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.reqList != null) {
      paramJceOutputStream.write(this.reqList, 0);
    }
    if (this.biz != null) {
      paramJceOutputStream.write(this.biz, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.GetAppDetailForSdkRequest
 * JD-Core Version:    0.7.0.1
 */