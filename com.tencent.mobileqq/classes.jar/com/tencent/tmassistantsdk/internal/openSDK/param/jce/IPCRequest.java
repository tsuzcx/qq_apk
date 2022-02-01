package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class IPCRequest
  extends JceStruct
{
  static byte[] cache_body;
  static IPCHead cache_head;
  public byte[] body = null;
  public IPCHead head = null;
  
  public IPCRequest() {}
  
  public IPCRequest(IPCHead paramIPCHead, byte[] paramArrayOfByte)
  {
    this.head = paramIPCHead;
    this.body = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_head == null) {
      cache_head = new IPCHead();
    }
    this.head = ((IPCHead)paramJceInputStream.read(cache_head, 0, true));
    if (cache_body == null)
    {
      cache_body = (byte[])new byte[1];
      ((byte[])cache_body)[0] = 0;
    }
    this.body = ((byte[])paramJceInputStream.read(cache_body, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.head, 0);
    byte[] arrayOfByte = this.body;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCRequest
 * JD-Core Version:    0.7.0.1
 */