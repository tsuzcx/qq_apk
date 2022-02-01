package com.tencent.msf.service.protocol.g;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class i
  extends JceStruct
{
  static ArrayList k;
  public String a = "";
  public byte b = 0;
  public String c = "";
  public String d = "";
  public String e = "";
  public byte f = 0;
  public byte g = 0;
  public byte h = 0;
  public String i = "";
  public ArrayList j = null;
  
  public i() {}
  
  public i(String paramString1, byte paramByte1, String paramString2, String paramString3, String paramString4, byte paramByte2, byte paramByte3, byte paramByte4, String paramString5, ArrayList paramArrayList)
  {
    this.a = paramString1;
    this.b = paramByte1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramByte2;
    this.g = paramByte3;
    this.h = paramByte4;
    this.i = paramString5;
    this.j = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(1, true);
    this.b = paramJceInputStream.read(this.b, 2, true);
    this.c = paramJceInputStream.readString(3, true);
    this.d = paramJceInputStream.readString(4, true);
    this.e = paramJceInputStream.readString(5, true);
    this.f = paramJceInputStream.read(this.f, 6, true);
    this.g = paramJceInputStream.read(this.g, 7, true);
    this.h = paramJceInputStream.read(this.h, 8, true);
    this.i = paramJceInputStream.readString(9, true);
    if (k == null)
    {
      k = new ArrayList();
      b localb = new b();
      k.add(localb);
    }
    this.j = ((ArrayList)paramJceInputStream.read(k, 10, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    paramJceOutputStream.write(this.c, 3);
    paramJceOutputStream.write(this.d, 4);
    paramJceOutputStream.write(this.e, 5);
    paramJceOutputStream.write(this.f, 6);
    paramJceOutputStream.write(this.g, 7);
    paramJceOutputStream.write(this.h, 8);
    paramJceOutputStream.write(this.i, 9);
    ArrayList localArrayList = this.j;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.msf.service.protocol.g.i
 * JD-Core Version:    0.7.0.1
 */