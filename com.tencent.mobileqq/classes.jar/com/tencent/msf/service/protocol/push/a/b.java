package com.tencent.msf.service.protocol.push.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class b
  extends JceStruct
{
  static ArrayList j;
  static ArrayList k;
  static ArrayList l;
  static ArrayList m;
  public short a;
  public ArrayList b;
  public ArrayList c;
  public ArrayList d;
  public ArrayList e;
  public long f;
  public long g;
  public long h;
  public long i;
  
  public b() {}
  
  public b(short paramShort, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.a = paramShort;
    this.b = paramArrayList1;
    this.c = paramArrayList2;
    this.d = paramArrayList3;
    this.e = paramArrayList4;
    this.f = paramLong1;
    this.g = paramLong2;
    this.h = paramLong3;
    this.i = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, false);
    Object localObject;
    if (j == null)
    {
      j = new ArrayList();
      localObject = new a();
      j.add(localObject);
    }
    this.b = ((ArrayList)paramJceInputStream.read(j, 1, false));
    if (k == null)
    {
      k = new ArrayList();
      localObject = (byte[])new byte[1];
      ((byte[])localObject)[0] = 0;
      k.add(localObject);
    }
    this.c = ((ArrayList)paramJceInputStream.read(k, 2, false));
    if (l == null)
    {
      l = new ArrayList();
      l.add(Long.valueOf(0L));
    }
    this.d = ((ArrayList)paramJceInputStream.read(l, 3, false));
    if (m == null)
    {
      m = new ArrayList();
      localObject = (byte[])new byte[1];
      ((byte[])localObject)[0] = 0;
      m.add(localObject);
    }
    this.e = ((ArrayList)paramJceInputStream.read(m, 4, false));
    this.f = paramJceInputStream.read(this.f, 5, false);
    this.g = paramJceInputStream.read(this.g, 6, false);
    this.h = paramJceInputStream.read(this.h, 7, false);
    this.i = paramJceInputStream.read(this.i, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    if (this.b != null) {
      paramJceOutputStream.write(this.b, 1);
    }
    if (this.c != null) {
      paramJceOutputStream.write(this.c, 2);
    }
    if (this.d != null) {
      paramJceOutputStream.write(this.d, 3);
    }
    if (this.e != null) {
      paramJceOutputStream.write(this.e, 4);
    }
    paramJceOutputStream.write(this.f, 5);
    paramJceOutputStream.write(this.g, 6);
    paramJceOutputStream.write(this.h, 7);
    paramJceOutputStream.write(this.i, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.push.a.b
 * JD-Core Version:    0.7.0.1
 */