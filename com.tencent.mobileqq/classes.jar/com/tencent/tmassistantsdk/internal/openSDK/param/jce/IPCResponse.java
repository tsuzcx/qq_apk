package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class IPCResponse
  extends JceStruct
{
  static IPCHead a;
  static byte[] b;
  public byte[] body = null;
  public IPCHead head = null;
  
  public IPCResponse() {}
  
  public IPCResponse(IPCHead paramIPCHead, byte[] paramArrayOfByte)
  {
    this.head = paramIPCHead;
    this.body = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (a == null) {
      a = new IPCHead();
    }
    this.head = ((IPCHead)paramJceInputStream.read(a, 0, true));
    if (b == null)
    {
      b = (byte[])new byte[1];
      ((byte[])b)[0] = 0;
    }
    this.body = ((byte[])paramJceInputStream.read(b, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.head, 0);
    paramJceOutputStream.write(this.body, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCResponse
 * JD-Core Version:    0.7.0.1
 */