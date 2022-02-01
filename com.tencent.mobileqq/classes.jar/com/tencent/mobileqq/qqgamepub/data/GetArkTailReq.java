package com.tencent.mobileqq.qqgamepub.data;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetArkTailReq
  extends JceStruct
{
  public String appid = "";
  public String qqVersion = "";
  public int sceneId = 0;
  public int tt = 0;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.readString(0, false);
    this.tt = paramJceInputStream.read(this.tt, 1, false);
    this.qqVersion = paramJceInputStream.readString(2, false);
    this.sceneId = paramJceInputStream.read(this.sceneId, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.appid;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.tt, 1);
    str = this.qqVersion;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    paramJceOutputStream.write(this.sceneId, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.GetArkTailReq
 * JD-Core Version:    0.7.0.1
 */