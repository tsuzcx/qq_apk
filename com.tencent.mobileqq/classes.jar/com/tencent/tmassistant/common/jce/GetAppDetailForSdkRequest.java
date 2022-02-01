package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

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
    Object localObject = this.reqList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.biz;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.GetAppDetailForSdkRequest
 * JD-Core Version:    0.7.0.1
 */