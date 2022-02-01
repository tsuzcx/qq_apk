package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class j
  extends JceStruct
{
  static ArrayList p = new ArrayList();
  static ArrayList q;
  static ArrayList r;
  static ArrayList s;
  static ArrayList t;
  static ArrayList u;
  static ArrayList v;
  static ArrayList w;
  public ArrayList a = null;
  public ArrayList b = null;
  public int c = 0;
  public byte d = 0;
  public byte e = 0;
  public int f = 1;
  public ArrayList g = null;
  public ArrayList h = null;
  public ArrayList i = null;
  public ArrayList j = null;
  public ArrayList k = null;
  public ArrayList l = null;
  public byte m = 0;
  public int n = 0;
  public String o = "";
  
  static
  {
    k localk = new k();
    p.add(localk);
    q = new ArrayList();
    localk = new k();
    q.add(localk);
    r = new ArrayList();
    localk = new k();
    r.add(localk);
    s = new ArrayList();
    localk = new k();
    s.add(localk);
    t = new ArrayList();
    localk = new k();
    t.add(localk);
    u = new ArrayList();
    localk = new k();
    u.add(localk);
    v = new ArrayList();
    localk = new k();
    v.add(localk);
    w = new ArrayList();
    localk = new k();
    w.add(localk);
  }
  
  public j() {}
  
  public j(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, ArrayList paramArrayList3, ArrayList paramArrayList4, ArrayList paramArrayList5, ArrayList paramArrayList6, ArrayList paramArrayList7, ArrayList paramArrayList8, byte paramByte3, int paramInt3, String paramString)
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
    this.j = paramArrayList6;
    this.k = paramArrayList7;
    this.l = paramArrayList8;
    this.m = paramByte3;
    this.n = paramInt3;
    this.o = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = ((ArrayList)paramJceInputStream.read(p, 1, true));
    this.b = ((ArrayList)paramJceInputStream.read(q, 3, true));
    this.c = paramJceInputStream.read(this.c, 4, true);
    this.d = paramJceInputStream.read(this.d, 5, false);
    this.e = paramJceInputStream.read(this.e, 6, false);
    this.f = paramJceInputStream.read(this.f, 7, false);
    this.g = ((ArrayList)paramJceInputStream.read(r, 8, false));
    this.h = ((ArrayList)paramJceInputStream.read(s, 9, false));
    this.i = ((ArrayList)paramJceInputStream.read(t, 10, false));
    this.j = ((ArrayList)paramJceInputStream.read(u, 11, false));
    this.k = ((ArrayList)paramJceInputStream.read(v, 12, false));
    this.l = ((ArrayList)paramJceInputStream.read(w, 13, false));
    this.m = paramJceInputStream.read(this.m, 14, false);
    this.n = paramJceInputStream.read(this.n, 15, false);
    this.o = paramJceInputStream.readString(16, false);
    this.o = paramJceInputStream.readString(16, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 3);
    paramJceOutputStream.write(this.c, 4);
    paramJceOutputStream.write(this.d, 5);
    paramJceOutputStream.write(this.e, 6);
    paramJceOutputStream.write(this.f, 7);
    Object localObject = this.g;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 8);
    }
    localObject = this.h;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 9);
    }
    localObject = this.i;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 10);
    }
    localObject = this.j;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 11);
    }
    localObject = this.k;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 12);
    }
    localObject = this.l;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 13);
    }
    paramJceOutputStream.write(this.m, 14);
    paramJceOutputStream.write(this.n, 15);
    localObject = this.o;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 16);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.msf.service.protocol.serverconfig.j
 * JD-Core Version:    0.7.0.1
 */