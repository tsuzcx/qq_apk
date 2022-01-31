package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class AppExtInfoParam
  extends JceStruct
{
  static ArrayList<String> cache_targetFileNameList = new ArrayList();
  public int flag = 0;
  public String oftenUsedPath = "";
  public ArrayList<String> targetFileNameList = null;
  
  static
  {
    cache_targetFileNameList.add("");
  }
  
  public AppExtInfoParam() {}
  
  public AppExtInfoParam(int paramInt, String paramString, ArrayList<String> paramArrayList)
  {
    this.flag = paramInt;
    this.oftenUsedPath = paramString;
    this.targetFileNameList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.flag = paramJceInputStream.read(this.flag, 0, false);
    this.oftenUsedPath = paramJceInputStream.readString(1, false);
    this.targetFileNameList = ((ArrayList)paramJceInputStream.read(cache_targetFileNameList, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.flag, 0);
    if (this.oftenUsedPath != null) {
      paramJceOutputStream.write(this.oftenUsedPath, 1);
    }
    if (this.targetFileNameList != null) {
      paramJceOutputStream.write(this.targetFileNameList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.AppExtInfoParam
 * JD-Core Version:    0.7.0.1
 */