package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class e
  extends JceStruct
{
  static ArrayList A;
  static ArrayList B;
  static ArrayList u;
  static ArrayList v;
  static ArrayList w;
  static ArrayList x;
  static byte[] y;
  static ArrayList z;
  public int a = 0;
  public ArrayList b = null;
  public ArrayList c = null;
  public int d = 0;
  public int e = 86400;
  public byte f = 0;
  public byte g = 0;
  public int h = 1;
  public int i = 5;
  public long j = 0L;
  public int k = 0;
  public ArrayList l = null;
  public ArrayList m = null;
  public byte[] n = null;
  public ArrayList o = null;
  public ArrayList p = null;
  public ArrayList q = null;
  public byte r = 0;
  public int s = 0;
  public String t = "";
  
  public e() {}
  
  public e(int paramInt1, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt2, int paramInt3, byte paramByte1, byte paramByte2, int paramInt4, int paramInt5, long paramLong, int paramInt6, ArrayList paramArrayList3, ArrayList paramArrayList4, byte[] paramArrayOfByte, ArrayList paramArrayList5, ArrayList paramArrayList6, ArrayList paramArrayList7, byte paramByte3, int paramInt7, String paramString)
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
    this.o = paramArrayList5;
    this.p = paramArrayList6;
    this.q = paramArrayList7;
    this.r = paramByte3;
    this.s = paramInt7;
    this.t = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 1, true);
    i locali;
    if (u == null)
    {
      u = new ArrayList();
      locali = new i();
      u.add(locali);
    }
    this.b = ((ArrayList)paramJceInputStream.read(u, 2, true));
    if (v == null)
    {
      v = new ArrayList();
      locali = new i();
      v.add(locali);
    }
    this.c = ((ArrayList)paramJceInputStream.read(v, 3, true));
    this.d = paramJceInputStream.read(this.d, 4, true);
    this.e = paramJceInputStream.read(this.e, 5, true);
    this.f = paramJceInputStream.read(this.f, 6, false);
    this.g = paramJceInputStream.read(this.g, 7, false);
    this.h = paramJceInputStream.read(this.h, 8, false);
    this.i = paramJceInputStream.read(this.i, 9, false);
    this.j = paramJceInputStream.read(this.j, 10, false);
    this.k = paramJceInputStream.read(this.k, 11, false);
    if (w == null)
    {
      w = new ArrayList();
      locali = new i();
      w.add(locali);
    }
    this.l = ((ArrayList)paramJceInputStream.read(w, 12, false));
    if (x == null)
    {
      x = new ArrayList();
      locali = new i();
      x.add(locali);
    }
    this.m = ((ArrayList)paramJceInputStream.read(x, 13, false));
    if (y == null)
    {
      y = (byte[])new byte[1];
      ((byte[])y)[0] = 0;
    }
    this.n = ((byte[])paramJceInputStream.read(y, 14, false));
    if (z == null)
    {
      z = new ArrayList();
      locali = new i();
      z.add(locali);
    }
    this.o = ((ArrayList)paramJceInputStream.read(z, 15, false));
    if (A == null)
    {
      A = new ArrayList();
      locali = new i();
      A.add(locali);
    }
    this.p = ((ArrayList)paramJceInputStream.read(A, 16, false));
    if (B == null)
    {
      B = new ArrayList();
      locali = new i();
      B.add(locali);
    }
    this.q = ((ArrayList)paramJceInputStream.read(B, 17, false));
    this.r = paramJceInputStream.read(this.r, 18, false);
    this.s = paramJceInputStream.read(this.s, 19, false);
    this.t = paramJceInputStream.readString(20, false);
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
    Object localObject = this.l;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 12);
    }
    localObject = this.m;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 13);
    }
    localObject = this.n;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 14);
    }
    localObject = this.o;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 15);
    }
    localObject = this.p;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 16);
    }
    localObject = this.q;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 17);
    }
    paramJceOutputStream.write(this.r, 18);
    paramJceOutputStream.write(this.s, 19);
    localObject = this.t;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 20);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.msf.service.protocol.serverconfig.e
 * JD-Core Version:    0.7.0.1
 */