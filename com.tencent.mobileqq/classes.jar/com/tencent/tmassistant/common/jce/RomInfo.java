package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RomInfo
  extends JceStruct
{
  public int rootFlag = 0;
  public String sysId = "";
  public String sysVersionCode = "";
  public String sysVersionName = "";
  
  public RomInfo() {}
  
  public RomInfo(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.sysId = paramString1;
    this.sysVersionName = paramString2;
    this.sysVersionCode = paramString3;
    this.rootFlag = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sysId = paramJceInputStream.readString(0, false);
    this.sysVersionName = paramJceInputStream.readString(1, false);
    this.sysVersionCode = paramJceInputStream.readString(2, false);
    this.rootFlag = paramJceInputStream.read(this.rootFlag, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sysId != null) {
      paramJceOutputStream.write(this.sysId, 0);
    }
    if (this.sysVersionName != null) {
      paramJceOutputStream.write(this.sysVersionName, 1);
    }
    if (this.sysVersionCode != null) {
      paramJceOutputStream.write(this.sysVersionCode, 2);
    }
    paramJceOutputStream.write(this.rootFlag, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.RomInfo
 * JD-Core Version:    0.7.0.1
 */