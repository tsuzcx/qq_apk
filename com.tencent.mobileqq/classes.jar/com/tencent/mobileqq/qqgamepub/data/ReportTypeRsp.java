package com.tencent.mobileqq.qqgamepub.data;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReportTypeRsp
  extends JceStruct
{
  public int retCode = 0;
  public String retMsg = "ok";
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.retCode = paramJceInputStream.read(this.retCode, 0, false);
    this.retMsg = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.retCode, 0);
    String str = this.retMsg;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.ReportTypeRsp
 * JD-Core Version:    0.7.0.1
 */