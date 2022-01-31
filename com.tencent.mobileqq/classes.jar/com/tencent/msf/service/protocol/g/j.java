package com.tencent.msf.service.protocol.g;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class j
  extends JceStruct
{
  static byte[] f;
  static byte[] g;
  static ArrayList h;
  public byte a;
  public byte[] b;
  public String c = "";
  public byte[] d;
  public ArrayList e;
  
  public j() {}
  
  public j(byte paramByte, byte[] paramArrayOfByte1, String paramString, byte[] paramArrayOfByte2, ArrayList paramArrayList)
  {
    this.a = paramByte;
    this.b = paramArrayOfByte1;
    this.c = paramString;
    this.d = paramArrayOfByte2;
    this.e = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 1, true);
    if (f == null)
    {
      f = (byte[])new byte[1];
      ((byte[])f)[0] = 0;
    }
    this.b = ((byte[])paramJceInputStream.read(f, 2, true));
    this.c = paramJceInputStream.readString(3, true);
    if (g == null)
    {
      g = (byte[])new byte[1];
      ((byte[])g)[0] = 0;
    }
    this.d = ((byte[])paramJceInputStream.read(g, 4, true));
    if (h == null)
    {
      h = new ArrayList();
      b localb = new b();
      h.add(localb);
    }
    this.e = ((ArrayList)paramJceInputStream.read(h, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    paramJceOutputStream.write(this.c, 3);
    paramJceOutputStream.write(this.d, 4);
    if (this.e != null) {
      paramJceOutputStream.write(this.e, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.g.j
 * JD-Core Version:    0.7.0.1
 */