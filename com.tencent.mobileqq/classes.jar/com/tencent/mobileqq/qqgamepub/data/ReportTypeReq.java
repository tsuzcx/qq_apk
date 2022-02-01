package com.tencent.mobileqq.qqgamepub.data;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReportTypeReq
  extends JceStruct
{
  public String appid = "";
  public int sub_type = 0;
  public int tt = 0;
  public int type = 0;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.readString(0, false);
    this.tt = paramJceInputStream.read(this.tt, 1, false);
    this.type = paramJceInputStream.read(this.type, 2, false);
    this.sub_type = paramJceInputStream.read(this.sub_type, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.appid;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.tt, 1);
    paramJceOutputStream.write(this.type, 2);
    paramJceOutputStream.write(this.sub_type, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.ReportTypeReq
 * JD-Core Version:    0.7.0.1
 */