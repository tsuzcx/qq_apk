package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class a
  extends JceStruct
{
  static l g;
  static l h;
  public int a = 0;
  public l b = null;
  public l c = null;
  public byte d = 0;
  public int e = 0;
  public long f;
  
  public a() {}
  
  public a(int paramInt1, l paraml1, l paraml2, byte paramByte, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paraml1;
    this.c = paraml2;
    this.d = paramByte;
    this.e = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 1, true);
    if (g == null) {
      g = new l();
    }
    this.b = ((l)paramJceInputStream.read(g, 2, false));
    if (h == null) {
      h = new l();
    }
    this.c = ((l)paramJceInputStream.read(h, 3, false));
    this.d = paramJceInputStream.read(this.d, 4, false);
    this.e = paramJceInputStream.read(this.e, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    l locall = this.b;
    if (locall != null) {
      paramJceOutputStream.write(locall, 2);
    }
    locall = this.c;
    if (locall != null) {
      paramJceOutputStream.write(locall, 3);
    }
    paramJceOutputStream.write(this.d, 4);
    paramJceOutputStream.write(this.e, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.msf.service.protocol.serverconfig.a
 * JD-Core Version:    0.7.0.1
 */