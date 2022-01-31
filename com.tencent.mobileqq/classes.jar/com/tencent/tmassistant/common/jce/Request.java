package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Request
  extends JceStruct
{
  static byte[] cache_body;
  static ReqHead cache_head = new ReqHead();
  public byte[] body = null;
  public ReqHead head = null;
  
  static
  {
    cache_body = (byte[])new byte[1];
    ((byte[])cache_body)[0] = 0;
  }
  
  public Request() {}
  
  public Request(ReqHead paramReqHead, byte[] paramArrayOfByte)
  {
    this.head = paramReqHead;
    this.body = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.head = ((ReqHead)paramJceInputStream.read(cache_head, 0, true));
    this.body = ((byte[])paramJceInputStream.read(cache_body, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.head, 0);
    if (this.body != null) {
      paramJceOutputStream.write(this.body, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.Request
 * JD-Core Version:    0.7.0.1
 */