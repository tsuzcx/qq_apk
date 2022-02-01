package com.tencent.msf.service.protocol.QQWiFi;

import LBS.LBSInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class e
  extends JceStruct
{
  static LBSInfo c;
  public LBSInfo a = null;
  public long b = 0L;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (c == null) {
      c = new LBSInfo();
    }
    this.a = ((LBSInfo)paramJceInputStream.read(c, 0, false));
    this.b = paramJceInputStream.read(this.b, 1, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WiFiMapReq [lbsInfo=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", last_id=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    LBSInfo localLBSInfo = this.a;
    if (localLBSInfo != null) {
      paramJceOutputStream.write(localLBSInfo, 0);
    }
    paramJceOutputStream.write(this.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.msf.service.protocol.QQWiFi.e
 * JD-Core Version:    0.7.0.1
 */