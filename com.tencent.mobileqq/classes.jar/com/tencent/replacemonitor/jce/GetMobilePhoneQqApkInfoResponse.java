package com.tencent.replacemonitor.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetMobilePhoneQqApkInfoResponse
  extends JceStruct
{
  public String apkMd5 = "";
  public String channelId = "";
  public long fileSize = 0L;
  public int maxFileSize = 0;
  public String msg = "";
  public int ret = 0;
  public int strategy = 0;
  
  public GetMobilePhoneQqApkInfoResponse() {}
  
  public GetMobilePhoneQqApkInfoResponse(int paramInt1, String paramString1, int paramInt2, String paramString2, long paramLong, String paramString3, int paramInt3)
  {
    this.ret = paramInt1;
    this.msg = paramString1;
    this.strategy = paramInt2;
    this.apkMd5 = paramString2;
    this.fileSize = paramLong;
    this.channelId = paramString3;
    this.maxFileSize = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.strategy = paramJceInputStream.read(this.strategy, 2, false);
    this.apkMd5 = paramJceInputStream.readString(3, false);
    this.fileSize = paramJceInputStream.read(this.fileSize, 4, false);
    this.channelId = paramJceInputStream.readString(5, false);
    this.maxFileSize = paramJceInputStream.read(this.maxFileSize, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    paramJceOutputStream.write(this.strategy, 2);
    if (this.apkMd5 != null) {
      paramJceOutputStream.write(this.apkMd5, 3);
    }
    paramJceOutputStream.write(this.fileSize, 4);
    if (this.channelId != null) {
      paramJceOutputStream.write(this.channelId, 5);
    }
    paramJceOutputStream.write(this.maxFileSize, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.replacemonitor.jce.GetMobilePhoneQqApkInfoResponse
 * JD-Core Version:    0.7.0.1
 */