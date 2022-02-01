package com.tencent.tmassistantsdk.internal.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class StatStdReport
  extends JceStruct
{
  public String extraData = "";
  public String name = "";
  public int scene = 0;
  public long time = 0L;
  public String traceId = "";
  public String versionInfo = "";
  
  public StatStdReport() {}
  
  public StatStdReport(String paramString1, int paramInt, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    this.name = paramString1;
    this.scene = paramInt;
    this.extraData = paramString2;
    this.time = paramLong;
    this.versionInfo = paramString3;
    this.traceId = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.name = paramJceInputStream.readString(0, true);
    this.scene = paramJceInputStream.read(this.scene, 1, false);
    this.extraData = paramJceInputStream.readString(2, false);
    this.time = paramJceInputStream.read(this.time, 3, false);
    this.versionInfo = paramJceInputStream.readString(4, false);
    this.traceId = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.name, 0);
    paramJceOutputStream.write(this.scene, 1);
    if (this.extraData != null) {
      paramJceOutputStream.write(this.extraData, 2);
    }
    paramJceOutputStream.write(this.time, 3);
    if (this.versionInfo != null) {
      paramJceOutputStream.write(this.versionInfo, 4);
    }
    if (this.traceId != null) {
      paramJceOutputStream.write(this.traceId, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.protocol.jce.StatStdReport
 * JD-Core Version:    0.7.0.1
 */