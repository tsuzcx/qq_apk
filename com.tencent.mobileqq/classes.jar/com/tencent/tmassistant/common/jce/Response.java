package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Response
  extends JceStruct
{
  static byte[] cache_body;
  static RspHead cache_head = new RspHead();
  public byte[] body = null;
  public RspHead head = null;
  
  static
  {
    cache_body = (byte[])new byte[1];
    ((byte[])cache_body)[0] = 0;
  }
  
  public Response() {}
  
  public Response(RspHead paramRspHead, byte[] paramArrayOfByte)
  {
    this.head = paramRspHead;
    this.body = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.head = ((RspHead)paramJceInputStream.read(cache_head, 0, true));
    this.body = ((byte[])paramJceInputStream.read(cache_body, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.head, 0);
    paramJceOutputStream.write(this.body, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.Response
 * JD-Core Version:    0.7.0.1
 */