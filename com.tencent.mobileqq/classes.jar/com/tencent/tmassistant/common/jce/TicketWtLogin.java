package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TicketWtLogin
  extends JceStruct
{
  static byte[] cache_A2 = (byte[])new byte[1];
  public byte[] A2 = null;
  public long uin = 0L;
  
  static
  {
    ((byte[])cache_A2)[0] = 0;
  }
  
  public TicketWtLogin() {}
  
  public TicketWtLogin(byte[] paramArrayOfByte, long paramLong)
  {
    this.A2 = paramArrayOfByte;
    this.uin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.A2 = ((byte[])paramJceInputStream.read(cache_A2, 0, false));
    this.uin = paramJceInputStream.read(this.uin, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    byte[] arrayOfByte = this.A2;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 0);
    }
    paramJceOutputStream.write(this.uin, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.TicketWtLogin
 * JD-Core Version:    0.7.0.1
 */