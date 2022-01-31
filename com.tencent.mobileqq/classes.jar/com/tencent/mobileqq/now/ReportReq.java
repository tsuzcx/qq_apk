package com.tencent.mobileqq.now;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReportReq
  extends JceStruct
{
  public String action_name = "";
  public String channel = "";
  public String ext1 = "";
  public String ext2 = "";
  public String ext3 = "";
  public String ext4 = "";
  public String imei = "";
  public int net_type;
  public long report_time;
  public int result;
  public String uin = "";
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.readString(0, false);
    this.action_name = paramJceInputStream.readString(1, false);
    this.report_time = paramJceInputStream.read(this.report_time, 2, false);
    this.net_type = paramJceInputStream.read(this.net_type, 3, false);
    this.channel = paramJceInputStream.readString(4, false);
    this.imei = paramJceInputStream.readString(5, false);
    this.result = paramJceInputStream.read(this.result, 6, false);
    this.ext1 = paramJceInputStream.readString(7, false);
    this.ext2 = paramJceInputStream.readString(8, false);
    this.ext3 = paramJceInputStream.readString(9, false);
    this.ext4 = paramJceInputStream.readString(10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.uin != null) {
      paramJceOutputStream.write(this.uin, 0);
    }
    if (this.action_name != null) {
      paramJceOutputStream.write(this.action_name, 1);
    }
    paramJceOutputStream.write(this.report_time, 2);
    paramJceOutputStream.write(this.net_type, 3);
    if (this.channel != null) {
      paramJceOutputStream.write(this.channel, 4);
    }
    if (this.imei != null) {
      paramJceOutputStream.write(this.imei, 5);
    }
    paramJceOutputStream.write(this.result, 6);
    if (this.ext1 != null) {
      paramJceOutputStream.write(this.ext1, 7);
    }
    if (this.ext2 != null) {
      paramJceOutputStream.write(this.ext2, 8);
    }
    if (this.ext3 != null) {
      paramJceOutputStream.write(this.ext3, 9);
    }
    if (this.ext4 != null) {
      paramJceOutputStream.write(this.ext4, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.now.ReportReq
 * JD-Core Version:    0.7.0.1
 */