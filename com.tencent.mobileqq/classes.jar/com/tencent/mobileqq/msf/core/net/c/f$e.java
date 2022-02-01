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
    Object localObject3;
    if ((this.b == f.e.a.a) && (this.c.isEmpty()))
    {
      localObject1 = this.b;
      localObject1 = f.e.a.a.toString();
    }
    else
    {
      localObject1 = this.c;
      if ((localObject1 != null) && (!((Map)localObject1).isEmpty()))
      {
        localObject2 = this.c.entrySet().iterator();
        for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = ((StringBuilder)localObject4).toString())
        {
          localObject4 = (Map.Entry)((Iterator)localObject2).next();
          localObject3 = (f.e.a)((Map.Entry)localObject4).getKey();
          i1 = ((Integer)((Map.Entry)localObject4).getValue()).intValue();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append((String)localObject1);
          ((StringBuilder)localObject4).append(((f.e.a)localObject3).toString());
          ((StringBuilder)localObject4).append(":");
          ((StringBuilder)localObject4).append(i1);
          ((StringBuilder)localObject4).append(";");
        }
      }
      else
      {
        localObject1 = this.b;
        localObject1 = f.e.a.b.toString();
      }
    }
    int i1 = this.r;
    if ((i1 != 5) && (i1 != 6))
    {
      if (this.d == null)
      {
        localObject2 = "0.0.0.0|";
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.d.getHostAddress());
        ((StringBuilder)localObject2).append("|");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (this.e == null)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append("0.0.0.0|");
        localObject2 = ((StringBuilder)localObject3).toString();
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append(this.e.getHostAddress());
        ((StringBuilder)localObject3).append("|");
        localObject2 = ((StringBuilder)localObject3).toString();
      }
      localObject4 = this.C;
      if (localObject4 != null)
      {
        localObject3 = localObject2;
        if (!((String)localObject4).isEmpty()) {}
      }
      else
      {
        localObject3 = this.e;
        if (localObject3 == null)
        {
          this.C = "0.0.0.0";
          localObject3 = localObject2;
        }
        else
        {
          this.C = ((InetAddress)localObject3).getHostAddress();
          localObject3 = localObject2;
        }
      }
    }
    else
    {
      if (this.K == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("0|");
        ((StringBuilder)localObject2).append("0.0.0.0|");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("0|");
        ((StringBuilder)localObject2).append(this.K);
        ((StringBuilder)localObject2).append("|");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject4 = this.C;
      if (localObject4 != null)
      {
        localObject3 = localObject2;
        if (!((String)localObject4).isEmpty()) {}
      }
      else
      {
        this.C = this.K;
        localObject3 = localObject2;
      }
    }
    Object localObject2 = this.y;
    int i2 = 0;
    if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
    {
      localObject2 = "";
      i1 = 0;
      for (;;)
      {
        localObject4 = localObject2;
        if (i1 >= this.y.size()) {
          break;
        }
        if (i1 != this.y.size() - 1)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append((String)localObject2);
          ((StringBuilder)localObject4).append(this.y.get(i1));
          ((StringBuilder)localObject4).append(",");
          localObject2 = ((StringBuilder)localObject4).toString();
        }
        else
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append((String)localObject2);
          ((StringBuilder)localObject4).append(this.y.get(i1));
          localObject2 = ((StringBuilder)localObject4).toString();
        }
        i1 += 1;
      }
    }
    Object localObject4 = "";
    localObject2 = this.u;
    if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
    {
      localObject2 = "";
      i1 = 0;
      for (;;)
      {
        localObject5 = localObject2;
        if (i1 >= this.u.size()) {
          break;
        }
        if (i1 != this.u.size() - 1)
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append((String)localObject2);
          ((StringBuilder)localObject5).append(this.u.get(i1));
          ((StringBuilder)localObject5).append(",");
          localObject2 = ((StringBuilder)localObject5).toString();
        }
        else
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append((String)localObject2);
          ((StringBuilder)localObject5).append(this.u.get(i1));
          localObject2 = ((StringBuilder)localObject5).toString();
        }
        i1 += 1;
      }
    }
    Object localObject5 = "";
    String str1;
    if (this.x) {
      str1 = this.A;
    } else {
      str1 = "false";
    }
    if (this.a == f.e.b.a)
    {
      localObject2 = new StringBuilder("");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append((String)localObject3);
      ((StringBuilder)localObject2).append(this.f);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.L);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.M);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.N);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.O);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.P);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.Q);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.R);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.C);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.D);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.E);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.F);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.G);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.g);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.l);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.m);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.I.toString().replace("[", "").replace("]", ""));
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.J.toString().replace("[", "").replace("]", ""));
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.n);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.o);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.p);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.q);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.r);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.s);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.t);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append((String)localObject5);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.w);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append((String)localObject4);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.z);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(this.h);
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append(this.i);
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append(this.j);
      return ((StringBuilder)localObject2).toString();
    }
    i1 = Math.min(this.l, this.m);
    String str2;
    if (i1 > 0) {
      str2 = Integer.toString(this.k / i1);
    } else {
      str2 = "0";
    }
    localObject2 = this.v;
    if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
    {
      localObject2 = "";
      i1 = i2;
      for (;;)
      {
        localObject6 = localObject2;
        if (i1 >= this.v.size()) {
          break;
        }
        if (i1 != this.v.size() - 1)
        {
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append((String)localObject2);
          ((StringBuilder)localObject6).append(this.v.get(i1));
          ((StringBuilder)localObject6).append(",");
          localObject2 = ((StringBuilder)localObject6).toString();
        }
        else
        {
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append((String)localObject2);
          ((StringBuilder)localObject6).append(this.v.get(i1));
          localObject2 = ((StringBuilder)localObject6).toString();
        }
        i1 += 1;
      }
    }
    Object localObject6 = "";
    localObject2 = new StringBuilder("");
    ((StringBuilder)localObject2).append(this.a);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append((String)localObject3);
    ((StringBuilder)localObject2).append(this.f);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(this.g);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(str2);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(this.l);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(this.m);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(this.n);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(this.o);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append((String)localObject6);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(this.p);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(this.q);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(this.r);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(this.s);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(this.t);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append((String)localObject5);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(this.w);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(str1);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append((String)localObject4);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(this.z);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(this.h);
    ((StringBuilder)localObject2).append(",");
    ((StringBuilder)localObject2).append(this.i);
    ((StringBuilder)localObject2).append(",");
    ((StringBuilder)localObject2).append(this.j);
    return ((StringBuilder)localObject2).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.f.e
 * JD-Core Version:    0.7.0.1
 */