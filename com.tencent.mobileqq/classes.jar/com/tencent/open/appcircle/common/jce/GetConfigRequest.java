package com.tencent.open.appcircle.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetConfigRequest
  extends JceStruct
{
  static ArrayList cache_typeList = new ArrayList();
  public ArrayList typeList;
  
  static
  {
    cache_typeList.add(Integer.valueOf(0));
  }
  
  public GetConfigRequest() {}
  
  public GetConfigRequest(ArrayList paramArrayList)
  {
    this.typeList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.typeList = ((ArrayList)paramJceInputStream.read(cache_typeList, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.typeList, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.appcircle.common.jce.GetConfigRequest
 * JD-Core Version:    0.7.0.1
 */