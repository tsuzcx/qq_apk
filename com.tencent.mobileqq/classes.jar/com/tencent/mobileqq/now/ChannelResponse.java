package com.tencent.mobileqq.now;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ChannelResponse
  extends JceStruct
{
  public int client_action;
  public String downloadLink = "";
  public long downloadTime;
  public int error_code;
  public String error_msg = "";
  public String h5_url = "";
  public int isDownload;
  public String md5sum = "";
  public int updateInternal;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.isDownload = paramJceInputStream.read(this.isDownload, 0, true);
    this.downloadTime = paramJceInputStream.read(this.downloadTime, 1, true);
    this.updateInternal = paramJceInputStream.read(this.updateInternal, 2, true);
    this.downloadLink = paramJceInputStream.readString(3, true);
    this.error_code = paramJceInputStream.read(this.error_code, 4, false);
    this.error_msg = paramJceInputStream.readString(5, false);
    this.md5sum = paramJceInputStream.readString(6, false);
    this.client_action = paramJceInputStream.read(this.client_action, 7, false);
    this.h5_url = paramJceInputStream.readString(8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.isDownload, 0);
    paramJceOutputStream.write(this.downloadTime, 1);
    paramJceOutputStream.write(this.updateInternal, 2);
    paramJceOutputStream.write(this.downloadLink, 3);
    paramJceOutputStream.write(this.error_code, 4);
    if (this.error_msg != null) {
      paramJceOutputStream.write(this.error_msg, 5);
    }
    if (this.md5sum != null) {
      paramJceOutputStream.write(this.md5sum, 6);
    }
    paramJceOutputStream.write(this.client_action, 7);
    if (this.h5_url != null) {
      paramJceOutputStream.write(this.h5_url, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.now.ChannelResponse
 * JD-Core Version:    0.7.0.1
 */