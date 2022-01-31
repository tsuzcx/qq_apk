package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class e
  extends JceStruct
{
  static ArrayList o;
  static ArrayList p;
  static ArrayList q;
  static ArrayList r;
  static byte[] s;
  public int a;
  public ArrayList b;
  public ArrayList c;
  public int d;
  public int e = 86400;
  public byte f;
  public byte g;
  public int h = 1;
  public int i = 5;
  public long j;
  public int k;
  public ArrayList l;
  public ArrayList m;
  public byte[] n;
  
  public e() {}
  
  public e(int paramInt1, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt2, int paramInt3, byte paramByte1, byte paramByte2, int paramInt4, int paramInt5, long paramLong, int paramInt6, ArrayList paramArrayList3, ArrayList paramArrayList4, byte[] paramArrayOfByte)
  {
    this.a = paramInt1;
    this.b = paramArrayList1;
    this.c = paramArrayList2;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramByte1;
    this.g = paramByte2;
    this.h = paramInt4;
    this.i = paramInt5;
    this.j = paramLong;
    this.k = paramInt6;
    this.l = paramArrayList3;
    this.m = paramArrayList4;
    this.n = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 1, true);
    j localj;
    if (o == null)
    {
      o = new ArrayList();
      localj = new j();
      o.add(localj);
    }
    this.b = ((ArrayList)paramJceInputStream.read(o, 2, true));
    if (p == null)
    {
      p = new ArrayList();
      localj = new j();
      p.add(localj);
    }
    this.c = ((ArrayList)paramJceInputStream.read(p, 3, true));
    this.d = paramJceInputStream.read(this.d, 4, true);
    this.e = paramJceInputStream.read(this.e, 5, true);
    this.f = paramJceInputStream.read(this.f, 6, false);
    this.g = paramJceInputStream.read(this.g, 7, false);
    this.h = paramJceInputStream.read(this.h, 8, false);
    this.i = paramJceInputStream.read(this.i, 9, false);
    this.j = paramJceInputStream.read(this.j, 10, false);
    this.k = paramJceInputStream.read(this.k, 11, false);
    if (q == null)
    {
      q = new ArrayList();
      localj = new j();
      q.add(localj);
    }
    this.l = ((ArrayList)paramJceInputStream.read(q, 12, false));
    if (r == null)
    {
      r = new ArrayList();
      localj = new j();
      r.add(localj);
    }
    this.m = ((ArrayList)paramJceInputStream.read(r, 13, false));
    if (s == null)
    {
      s = (byte[])new byte[1];
      ((byte[])s)[0] = 0;
    }
    this.n = ((byte[])paramJceInputStream.read(s, 14, false));
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
    paramJceOutputStream.write(this.j, 10);
    paramJceOutputStream.write(this.k, 11);
    if (this.l != null) {
      paramJceOutputStream.write(this.l, 12);
    }
    if (this.m != null) {
      paramJceOutputStream.write(this.m, 13);
    }
    if (this.n != null) {
      paramJceOutputStream.write(this.n, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.serverconfig.e
 * JD-Core Version:    0.7.0.1
 */