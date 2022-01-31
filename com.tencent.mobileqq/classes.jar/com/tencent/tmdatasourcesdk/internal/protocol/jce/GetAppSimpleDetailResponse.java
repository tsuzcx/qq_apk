package com.tencent.tmdatasourcesdk.internal.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetAppSimpleDetailResponse
  extends JceStruct
{
  static ArrayList<AppSimpleDetail> a;
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
    if (a == null)
    {
      a = new ArrayList();
      AppSimpleDetail localAppSimpleDetail = new AppSimpleDetail();
      a.add(localAppSimpleDetail);
    }
    this.appSimpleDetailList = ((ArrayList)paramJceInputStream.read(a, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.appSimpleDetailList, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdatasourcesdk.internal.protocol.jce.GetAppSimpleDetailResponse
 * JD-Core Version:    0.7.0.1
 */