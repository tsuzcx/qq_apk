package com.tencent.turingfd.sdk.xq;

import android.content.pm.FeatureInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bennet
  extends else
{
  public static byte[] a;
  public static byte[] b;
  public static List<Integer> c;
  public static List<byte[]> d;
  public static List<List<byte[]>> e;
  public static byte[] f;
  public static Map<Long, FeatureInfo> g;
  public int A = -1;
  public List<List<byte[]>> B = null;
  public byte[] C = null;
  public Map<Long, FeatureInfo> D = null;
  public String E = "";
  public int h = 0;
  public byte[] i = null;
  public String j = "";
  public byte[] k = null;
  public long l = 0L;
  public String m = "";
  public int n = 0;
  public String o = "";
  public int p = 0;
  public String q = "";
  public int r = 0;
  public int s = 0;
  public int t = 0;
  public List<Integer> u = null;
  public int v = 0;
  public boolean w = false;
  public int x = 0;
  public int y = 0;
  public List<byte[]> z = null;
  
  static
  {
    Object localObject = new byte[1];
    a = (byte[])localObject;
    localObject[0] = 0;
    localObject = new byte[1];
    b = (byte[])localObject;
    localObject[0] = 0;
    localObject = new ArrayList();
    c = (List)localObject;
    ((List)localObject).add(Integer.valueOf(0));
    localObject = new ArrayList();
    d = (List)localObject;
    ((List)localObject).add(new byte[] { 0 });
    e = new ArrayList();
    localObject = new ArrayList();
    ((ArrayList)localObject).add(new byte[] { 0 });
    e.add(localObject);
    localObject = new byte[1];
    f = (byte[])localObject;
    localObject[0] = 0;
    g = new HashMap();
    localObject = new FeatureInfo();
    g.put(Long.valueOf(0L), localObject);
  }
  
  public void a(case paramcase)
  {
    paramcase.a(this.h, 0);
    Object localObject = this.i;
    if (localObject != null) {
      paramcase.a((byte[])localObject, 1);
    }
    localObject = this.j;
    if (localObject != null) {
      paramcase.a((String)localObject, 2);
    }
    localObject = this.k;
    if (localObject != null) {
      paramcase.a((byte[])localObject, 3);
    }
    paramcase.a(this.l, 4);
    localObject = this.m;
    if (localObject != null) {
      paramcase.a((String)localObject, 5);
    }
    paramcase.a(this.n, 6);
    localObject = this.o;
    if (localObject != null) {
      paramcase.a((String)localObject, 7);
    }
    paramcase.a(this.p, 8);
    localObject = this.q;
    if (localObject != null) {
      paramcase.a((String)localObject, 9);
    }
    paramcase.a(this.r, 10);
    paramcase.a(this.s, 11);
    paramcase.a(this.t, 12);
    localObject = this.u;
    if (localObject != null) {
      paramcase.a((Collection)localObject, 13);
    }
    paramcase.a(this.v, 14);
    paramcase.a((byte)this.w, 15);
    paramcase.a(this.x, 16);
    paramcase.a(this.y, 17);
    localObject = this.z;
    if (localObject != null) {
      paramcase.a((Collection)localObject, 18);
    }
    paramcase.a(this.A, 20);
    localObject = this.B;
    if (localObject != null) {
      paramcase.a((Collection)localObject, 21);
    }
    localObject = this.C;
    if (localObject != null) {
      paramcase.a((byte[])localObject, 22);
    }
    localObject = this.D;
    if (localObject != null) {
      paramcase.a((Map)localObject, 23);
    }
    localObject = this.E;
    if (localObject != null) {
      paramcase.a((String)localObject, 24);
    }
  }
  
  public void a(try paramtry)
  {
    this.h = paramtry.a(this.h, 0, true);
    this.i = paramtry.a(1, false);
    this.j = paramtry.b(2, false);
    this.k = paramtry.a(3, false);
    this.l = paramtry.a(this.l, 4, false);
    this.m = paramtry.b(5, false);
    this.n = paramtry.a(this.n, 6, false);
    this.o = paramtry.b(7, false);
    this.p = paramtry.a(this.p, 8, false);
    this.q = paramtry.b(9, false);
    this.r = paramtry.a(this.r, 10, false);
    this.s = paramtry.a(this.s, 11, false);
    this.t = paramtry.a(this.t, 12, false);
    this.u = ((List)paramtry.a(c, 13, false));
    this.v = paramtry.a(this.v, 14, false);
    this.w = paramtry.a(this.w, 15, false);
    this.x = paramtry.a(this.x, 16, false);
    this.y = paramtry.a(this.y, 17, false);
    this.z = ((List)paramtry.a(d, 18, false));
    this.A = paramtry.a(this.A, 20, false);
    this.B = ((List)paramtry.a(e, 21, false));
    this.C = paramtry.a(22, false);
    this.D = ((Map)paramtry.a(g, 23, false));
    this.E = paramtry.b(24, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Bennet)) {
      return false;
    }
    paramObject = (Bennet)paramObject;
    return (goto.a(this.h, paramObject.h)) && (this.i.equals(paramObject.i)) && (this.j.equals(paramObject.j)) && (this.k.equals(paramObject.k)) && (goto.a(this.l, paramObject.l)) && (this.m.equals(paramObject.m)) && (goto.a(this.n, paramObject.n)) && (this.o.equals(paramObject.o)) && (goto.a(this.p, paramObject.p)) && (this.q.equals(paramObject.q)) && (goto.a(this.r, paramObject.r)) && (goto.a(this.s, paramObject.s)) && (goto.a(this.t, paramObject.t)) && (this.u.equals(paramObject.u)) && (goto.a(this.v, paramObject.v)) && (goto.a(this.w, paramObject.w)) && (goto.a(this.x, paramObject.x)) && (goto.a(this.y, paramObject.y)) && (this.z.equals(paramObject.z)) && (goto.a(this.A, paramObject.A)) && (this.B.equals(paramObject.B)) && (this.C.equals(paramObject.C)) && (this.D.equals(paramObject.D)) && (this.E.equals(paramObject.E));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Bennet
 * JD-Core Version:    0.7.0.1
 */