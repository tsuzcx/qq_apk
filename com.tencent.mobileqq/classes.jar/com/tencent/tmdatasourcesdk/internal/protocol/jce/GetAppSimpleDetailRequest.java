package com.tencent.tmdatasourcesdk.internal.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetAppSimpleDetailRequest
  extends JceStruct
{
  static ArrayList<AppDetailParam> cache_appReqList;
  public ArrayList<AppDetailParam> appReqList = null;
  
  public GetAppSimpleDetailRequest() {}
  
  public GetAppSimpleDetailRequest(ArrayList<AppDetailParam> paramArrayList)
  {
    this.appReqList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_appReqList == null)
    {
      cache_appReqList = new ArrayList();
      AppDetailParam localAppDetailParam = new AppDetailParam();
      cache_appReqList.add(localAppDetailParam);
    }
    this.appReqList = ((ArrayList)paramJceInputStream.read(cache_appReqList, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.appReqList;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdatasourcesdk.internal.protocol.jce.GetAppSimpleDetailRequest
 * JD-Core Version:    0.7.0.1
 */