package com.tencent.mobileqq.msf.sdk;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CommandCallbackerInfo
  extends JceStruct
{
  static ArrayList cache_cmds;
  public ArrayList cmds = null;
  public String uin = "";
  
  public CommandCallbackerInfo() {}
  
  public CommandCallbackerInfo(String paramString, ArrayList paramArrayList)
  {
    this.uin = paramString;
    this.cmds = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.readString(1, true);
    if (cache_cmds == null)
    {
      cache_cmds = new ArrayList();
      cache_cmds.add("");
    }
    this.cmds = ((ArrayList)paramJceInputStream.read(cache_cmds, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.cmds, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.CommandCallbackerInfo
 * JD-Core Version:    0.7.0.1
 */