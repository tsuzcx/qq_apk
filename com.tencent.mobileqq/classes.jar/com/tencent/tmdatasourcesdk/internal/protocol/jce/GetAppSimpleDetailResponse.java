package com.tencent.tmdatasourcesdk.internal.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetAppSimpleDetailResponse
  extends JceStruct
{
  static ArrayList<AppSimpleDetail> cache_appSimpleDetailList;
  public ArrayList<AppSimpleDetail> appSimpleDetailList = null;
  public int ret = 0;
  
  public GetAppSimpleDetailResponse() {}
  
  public GetAppSimpleDetailResponse(int paramInt, ArrayList<AppSimpleDetail> paramArrayList)
  {
    this.ret = paramInt;
    this.appSimpleDetailList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    if (cache_appSimpleDetailList == null)
    {
      cache_appSimpleDetailList = new ArrayList();
      AppSimpleDetail localAppSimpleDetail = new AppSimpleDetail();
      cache_appSimpleDetailList.add(localAppSimpleDetail);
    }
    this.appSimpleDetailList = ((ArrayList)paramJceInputStream.read(cache_appSimpleDetailList, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.appSimpleDetailList, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdatasourcesdk.internal.protocol.jce.GetAppSimpleDetailResponse
 * JD-Core Version:    0.7.0.1
 */