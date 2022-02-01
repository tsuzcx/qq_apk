package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ShareUrlConfig
  extends JceStruct
{
  static ArrayList<String> cache_blackList = new ArrayList();
  public ArrayList<String> blackList = null;
  
  static
  {
    cache_blackList.add("");
  }
  
  public ShareUrlConfig() {}
  
  public ShareUrlConfig(ArrayList<String> paramArrayList)
  {
    this.blackList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.blackList = ((ArrayList)paramJceInputStream.read(cache_blackList, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.blackList, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.ShareUrlConfig
 * JD-Core Version:    0.7.0.1
 */