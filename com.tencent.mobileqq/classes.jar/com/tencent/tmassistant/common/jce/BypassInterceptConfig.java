package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class BypassInterceptConfig
  extends JceStruct
{
  static ArrayList<String> a = new ArrayList();
  public ArrayList<String> pkgList = null;
  public int status = 0;
  
  static
  {
    a.add("");
  }
  
  public BypassInterceptConfig() {}
  
  public BypassInterceptConfig(int paramInt, ArrayList<String> paramArrayList)
  {
    this.status = paramInt;
    this.pkgList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.status = paramJceInputStream.read(this.status, 0, true);
    this.pkgList = ((ArrayList)paramJceInputStream.read(a, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.status, 0);
    paramJceOutputStream.write(this.pkgList, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.BypassInterceptConfig
 * JD-Core Version:    0.7.0.1
 */