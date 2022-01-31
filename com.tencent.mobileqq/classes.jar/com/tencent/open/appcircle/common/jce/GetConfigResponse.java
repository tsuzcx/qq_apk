package com.tencent.open.appcircle.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetConfigResponse
  extends JceStruct
{
  static ArrayList cache_settingList = new ArrayList();
  public int ret;
  public ArrayList settingList;
  
  static
  {
    ConfigItem localConfigItem = new ConfigItem();
    cache_settingList.add(localConfigItem);
  }
  
  public GetConfigResponse() {}
  
  public GetConfigResponse(int paramInt, ArrayList paramArrayList)
  {
    this.ret = paramInt;
    this.settingList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.settingList = ((ArrayList)paramJceInputStream.read(cache_settingList, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.settingList, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.appcircle.common.jce.GetConfigResponse
 * JD-Core Version:    0.7.0.1
 */