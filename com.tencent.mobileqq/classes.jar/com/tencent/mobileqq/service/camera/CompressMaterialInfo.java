package com.tencent.mobileqq.service.camera;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class CompressMaterialInfo
  extends JceStruct
{
  static byte[] cache_pushBuffer = (byte[])new byte[1];
  public boolean compressed;
  public byte[] wupBuffer;
  
  static
  {
    ((byte[])cache_pushBuffer)[0] = 0;
  }
  
  public CompressMaterialInfo() {}
  
  public CompressMaterialInfo(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    this.compressed = paramBoolean;
    this.wupBuffer = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.compressed = paramJceInputStream.read(this.compressed, 0, false);
    this.wupBuffer = ((byte[])paramJceInputStream.read(cache_pushBuffer, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.compressed, 0);
    if (this.wupBuffer != null) {
      paramJceOutputStream.write(this.wupBuffer, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.service.camera.CompressMaterialInfo
 * JD-Core Version:    0.7.0.1
 */