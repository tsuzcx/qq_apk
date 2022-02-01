package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RspHead
  extends JceStruct
{
  public int cmdId = 0;
  public byte encryptWithPack = 0;
  public String phoneGuid = "";
  public int requestId = 0;
  public int ret = 0;
  
  public RspHead() {}
  
  public RspHead(int paramInt1, int paramInt2, int paramInt3, byte paramByte, String paramString)
  {
    this.requestId = paramInt1;
    this.cmdId = paramInt2;
    this.ret = paramInt3;
    this.encryptWithPack = paramByte;
    this.phoneGuid = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.requestId = paramJceInputStream.read(this.requestId, 0, true);
    this.cmdId = paramJceInputStream.read(this.cmdId, 1, true);
    this.ret = paramJceInputStream.read(this.ret, 2, true);
    this.encryptWithPack = paramJceInputStream.read(this.encryptWithPack, 3, false);
    this.phoneGuid = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.requestId, 0);
    paramJceOutputStream.write(this.cmdId, 1);
    paramJceOutputStream.write(this.ret, 2);
    paramJceOutputStream.write(this.encryptWithPack, 3);
    if (this.phoneGuid != null) {
      paramJceOutputStream.write(this.phoneGuid, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.RspHead
 * JD-Core Version:    0.7.0.1
 */