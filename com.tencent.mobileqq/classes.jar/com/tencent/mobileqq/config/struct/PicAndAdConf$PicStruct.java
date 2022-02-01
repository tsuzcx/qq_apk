package com.tencent.mobileqq.config.struct;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class PicAndAdConf$PicStruct
{
  protected long a = 0L;
  protected String b = null;
  protected String c = null;
  protected String d = null;
  protected byte[] e = null;
  protected String f = null;
  protected byte g = 3;
  protected String h = "";
  protected short i = 0;
  protected String j = "";
  protected int k = 0;
  protected boolean l = true;
  
  public PicAndAdConf$PicStruct(PicAndAdConf paramPicAndAdConf) {}
  
  public void a(DataInputStream paramDataInputStream)
  {
    this.a = paramDataInputStream.readLong();
    this.b = paramDataInputStream.readUTF();
    this.c = paramDataInputStream.readUTF();
    this.f = paramDataInputStream.readUTF();
    this.g = paramDataInputStream.readByte();
    this.d = paramDataInputStream.readUTF();
    this.h = paramDataInputStream.readUTF();
    this.i = paramDataInputStream.readShort();
  }
  
  public void a(DataOutputStream paramDataOutputStream)
  {
    if (this.b == null) {
      this.b = "";
    }
    if (this.c == null) {
      this.c = "";
    }
    if (this.f == null) {
      this.f = "";
    }
    if (this.d == null) {
      this.d = "";
    }
    paramDataOutputStream.writeLong(this.a);
    paramDataOutputStream.writeUTF(this.b);
    paramDataOutputStream.writeUTF(this.c);
    paramDataOutputStream.writeUTF(this.f);
    paramDataOutputStream.writeByte(this.g);
    paramDataOutputStream.writeUTF(this.d);
    paramDataOutputStream.writeUTF(this.h);
    paramDataOutputStream.writeShort(this.i);
  }
  
  public void b(DataInputStream paramDataInputStream)
  {
    a(paramDataInputStream);
    this.j = paramDataInputStream.readUTF();
  }
  
  public void b(DataOutputStream paramDataOutputStream)
  {
    a(paramDataOutputStream);
    if (this.j == null) {
      this.j = "";
    }
    paramDataOutputStream.writeUTF(this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.PicAndAdConf.PicStruct
 * JD-Core Version:    0.7.0.1
 */