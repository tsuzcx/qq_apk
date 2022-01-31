package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class i
  extends JceStruct
{
  static ArrayList j = new ArrayList();
  static ArrayList k;
  static ArrayList l;
  static ArrayList m;
  static ArrayList n;
  public ArrayList a;
  public ArrayList b;
  public int c;
  public byte d;
  public byte e;
  public int f = 1;
  public ArrayList g;
  public ArrayList h;
  public ArrayList i;
  
  static
  {
    j localj = new j();
    j.add(localj);
    k = new ArrayList();
    localj = new j();
    k.add(localj);
    l = new ArrayList();
    localj = new j();
    l.add(localj);
    m = new ArrayList();
    localj = new j();
    m.add(localj);
    n = new ArrayList();
    localj = new j();
    n.add(localj);
  }
  
  public i() {}
  
  public i(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, ArrayList paramArrayList3, ArrayList paramArrayList4, ArrayList paramArrayList5)
  {
    this.a = paramArrayList1;
    this.b = paramArrayList2;
    this.c = paramInt1;
    this.d = paramByte1;
    this.e = paramByte2;
    this.f = paramInt2;
    this.g = paramArrayList3;
    this.h = paramArrayList4;
    this.i = paramArrayList5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = ((ArrayList)paramJceInputStream.read(j, 1, true));
    this.b = ((ArrayList)paramJceInputStream.read(k, 3, true));
    this.c = paramJceInputStream.read(this.c, 4, true);
    this.d = paramJceInputStream.read(this.d, 5, false);
    this.e = paramJceInputStream.read(this.e, 6, false);
    this.f = paramJceInputStream.read(this.f, 7, false);
    this.g = ((ArrayList)paramJceInputStream.read(l, 8, false));
    this.h = ((ArrayList)paramJceInputStream.read(m, 9, false));
    this.i = ((ArrayList)paramJceInputStream.read(n, 10, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 3);
    paramJceOutputStream.write(this.c, 4);
    paramJceOutputStream.write(this.d, 5);
    paramJceOutputStream.write(this.e, 6);
    paramJceOutputStream.write(this.f, 7);
    if (this.g != null) {
      paramJceOutputStream.write(this.g, 8);
    }
    if (this.h != null) {
      paramJceOutputStream.write(this.h, 9);
    }
    if (this.i != null) {
      paramJceOutputStream.write(this.i, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.serverconfig.i
 * JD-Core Version:    0.7.0.1
 */