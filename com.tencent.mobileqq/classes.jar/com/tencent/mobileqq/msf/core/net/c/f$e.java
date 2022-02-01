package com.tencent.mobileqq.msf.core.net.c;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class f$e
{
  public String A;
  public long B = 0L;
  public String C;
  public long D = 0L;
  public int E = 0;
  public int F = 0;
  public int G = 0;
  public int H;
  public ArrayList I = new ArrayList();
  public ArrayList J = new ArrayList();
  public String K;
  public String L = "0.0.0.0";
  public long M = 0L;
  public long N = 0L;
  public int O = 0;
  public String P = "";
  public int Q = 0;
  public String R = "";
  public f.e.b a = f.e.b.a;
  public f.e.a b = f.e.a.a;
  public Map c = new HashMap();
  public InetAddress d;
  public InetAddress e;
  public int f = 0;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k = 0;
  public int l = 0;
  public int m = 0;
  public int n = 0;
  public int o = 0;
  public int p = 0;
  public int q = 0;
  public int r = 0;
  public long s = 0L;
  public long t = 0L;
  ArrayList u;
  ArrayList v;
  public long w = 0L;
  public boolean x = false;
  ArrayList y;
  public long z;
  
  public String toString()
  {
    Object localObject1;
    label79:
    Object localObject3;
    label110:
    Object localObject4;
    if ((this.b == f.e.a.a) && (this.c.isEmpty()))
    {
      localObject1 = this.b;
      localObject1 = f.e.a.a.toString();
      if ((this.r != 5) && (this.r != 6)) {
        break label374;
      }
      if (this.K != null) {
        break label343;
      }
      localObject2 = "0|" + "0.0.0.0|";
      if (this.C != null)
      {
        localObject3 = localObject2;
        if (!this.C.isEmpty()) {}
      }
      else
      {
        this.C = this.K;
        localObject3 = localObject2;
      }
      localObject2 = "";
      localObject4 = localObject2;
      if (this.y == null) {
        break label558;
      }
      localObject4 = localObject2;
      if (this.y.size() == 0) {
        break label558;
      }
      i1 = 0;
      label138:
      localObject4 = localObject2;
      if (i1 >= this.y.size()) {
        break label558;
      }
      if (i1 == this.y.size() - 1) {
        break label529;
      }
    }
    label384:
    label512:
    label529:
    for (Object localObject2 = (String)localObject2 + this.y.get(i1) + ",";; localObject2 = (String)localObject2 + this.y.get(i1))
    {
      i1 += 1;
      break label138;
      if ((this.c == null) || (this.c.isEmpty()))
      {
        localObject1 = this.b;
        localObject1 = f.e.a.b.toString();
        break;
      }
      localObject3 = this.c.entrySet().iterator();
      for (localObject2 = "";; localObject2 = (String)localObject2 + ((f.e.a)localObject4).toString() + ":" + i1 + ";")
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (Map.Entry)((Iterator)localObject3).next();
        localObject4 = (f.e.a)((Map.Entry)localObject1).getKey();
        i1 = ((Integer)((Map.Entry)localObject1).getValue()).intValue();
      }
      label343:
      localObject2 = "0|" + this.K + "|";
      break label79;
      label374:
      if (this.d == null)
      {
        localObject2 = "0.0.0.0|";
        if (this.e != null) {
          break label479;
        }
      }
      label479:
      for (localObject2 = (String)localObject2 + "0.0.0.0|";; localObject2 = (String)localObject2 + this.e.getHostAddress() + "|")
      {
        if (this.C != null)
        {
          localObject3 = localObject2;
          if (!this.C.isEmpty()) {
            break;
          }
        }
        if (this.e != null) {
          break label512;
        }
        this.C = "0.0.0.0";
        localObject3 = localObject2;
        break;
        localObject2 = this.d.getHostAddress() + "|";
        break label384;
      }
      this.C = this.e.getHostAddress();
      localObject3 = localObject2;
      break label110;
    }
    label558:
    localObject2 = "";
    Object localObject5 = localObject2;
    if (this.u != null)
    {
      localObject5 = localObject2;
      if (this.u.size() != 0)
      {
        i1 = 0;
        localObject5 = localObject2;
        if (i1 < this.u.size())
        {
          if (i1 != this.u.size() - 1) {}
          for (localObject2 = (String)localObject2 + this.u.get(i1) + ",";; localObject2 = (String)localObject2 + this.u.get(i1))
          {
            i1 += 1;
            break;
          }
        }
      }
    }
    if (this.x) {}
    for (String str1 = this.A; this.a == f.e.b.a; str1 = "false") {
      return "" + (String)localObject1 + "|" + (String)localObject3 + this.f + "|" + this.L + "|" + this.M + "|" + this.N + "|" + this.O + "|" + this.P + "|" + this.Q + "|" + this.R + "|" + this.C + "|" + this.D + "|" + this.E + "|" + this.F + "|" + this.G + "|" + this.g + "|" + this.l + "|" + this.m + "|" + this.I.toString().replace("[", "").replace("]", "") + "|" + this.J.toString().replace("[", "").replace("]", "") + "|" + this.n + "|" + this.o + "|" + this.p + "|" + this.q + "|" + this.r + "|" + this.s + "|" + this.t + "|" + localObject5 + "|" + this.w + "|" + str1 + "|" + (String)localObject4 + "|" + this.z + "|" + this.h + "," + this.i + "," + this.j;
    }
    int i1 = Math.min(this.l, this.m);
    String str2;
    if (i1 > 0)
    {
      str2 = Integer.toString(this.k / i1);
      String str3 = "";
      localObject2 = str3;
      if (this.v == null) {
        break label1315;
      }
      localObject2 = str3;
      if (this.v.size() == 0) {
        break label1315;
      }
      localObject2 = "";
      i1 = 0;
      label1216:
      if (i1 >= this.v.size()) {
        break label1315;
      }
      if (i1 == this.v.size() - 1) {
        break label1286;
      }
    }
    label1286:
    for (localObject2 = (String)localObject2 + this.v.get(i1) + ",";; localObject2 = (String)localObject2 + this.v.get(i1))
    {
      i1 += 1;
      break label1216;
      str2 = "0";
      break;
    }
    label1315:
    return "" + this.a + "|" + (String)localObject1 + "|" + (String)localObject3 + this.f + "|" + this.g + "|" + str2 + "|" + this.l + "|" + this.m + "|" + this.n + "|" + this.o + "|" + (String)localObject2 + "|" + this.p + "|" + this.q + "|" + this.r + "|" + this.s + "|" + this.t + "|" + localObject5 + "|" + this.w + "|" + str1 + "|" + (String)localObject4 + "|" + this.z + "|" + this.h + "," + this.i + "," + this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.f.e
 * JD-Core Version:    0.7.0.1
 */