package com.tencent.mobileqq.now;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ChannelRequest
  extends JceStruct
{
  public int action_version;
  public String channel = "";
  public long clientTime;
  public String deviceInfo = "";
  public String qq_channel = "";
  public String qq_version = "";
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.channel = paramJceInputStream.readString(0, true);
    this.clientTime = paramJceInputStream.read(this.clientTime, 1, true);
    this.deviceInfo = paramJceInputStream.readString(2, false);
    this.qq_channel = paramJceInputStream.readString(3, false);
    this.qq_version = paramJceInputStream.readString(4, false);
    this.action_version = paramJceInputStream.read(this.action_version, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.channel, 0);
    paramJceOutputStream.write(this.clientTime, 1);
    if (this.deviceInfo != null) {
      paramJceOutputStream.write(this.deviceInfo, 2);
    }
    if (this.qq_channel != null) {
      paramJceOutputStream.write(this.qq_channel, 3);
    }
    if (this.qq_version != null) {
      paramJceOutputStream.write(this.qq_version, 4);
    }
    paramJceOutputStream.write(this.action_version, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.now.ChannelRequest
 * JD-Core Version:    0.7.0.1
 */