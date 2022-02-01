package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetAppDetailForSdkResponse
  extends JceStruct
{
  static ArrayList<AppDetailSdkInfo> cache_detailList = new ArrayList();
  public ArrayList<AppDetailSdkInfo> detailList = null;
  public int ret = 0;
  
  static
  {
    AppDetailSdkInfo localAppDetailSdkInfo = new AppDetailSdkInfo();
    cache_detailList.add(localAppDetailSdkInfo);
  }
  
  public GetAppDetailForSdkResponse() {}
  
  public GetAppDetailForSdkResponse(int paramInt, ArrayList<AppDetailSdkInfo> paramArrayList)
  {
    this.ret = paramInt;
    this.detailList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.detailList = ((ArrayList)paramJceInputStream.read(cache_detailList, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    ArrayList localArrayList = this.detailList;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.GetAppDetailForSdkResponse
 * JD-Core Version:    0.7.0.1
 */