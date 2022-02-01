package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Apple
  extends else
{
  public static List<Triangulum> a = new ArrayList();
  public static Map<Integer, Blueberry> b;
  public static Map<Integer, Apricot> c;
  public static Map<Integer, Bagasse> d;
  public static Avocado e;
  public static Map<Integer, Banana> f;
  public static Blackberry g = new Blackberry();
  public int h = 0;
  public List<Triangulum> i = null;
  public Map<Integer, Blueberry> j = null;
  public Map<Integer, Apricot> k = null;
  public int l = 0;
  public Map<Integer, Bagasse> m = null;
  public int n = 0;
  public Avocado o = null;
  public Map<Integer, Banana> p = null;
  public Blackberry q = null;
  
  static
  {
    Object localObject1 = new Triangulum();
    a.add(localObject1);
    Object localObject2 = new HashMap();
    b = (Map)localObject2;
    Blueberry localBlueberry = new Blueberry();
    localObject1 = Integer.valueOf(0);
    ((Map)localObject2).put(localObject1, localBlueberry);
    c = new HashMap();
    localObject2 = new Apricot();
    c.put(localObject1, localObject2);
    d = new HashMap();
    localObject2 = new Bagasse();
    d.put(localObject1, localObject2);
    e = new Avocado();
    f = new HashMap();
    localObject2 = new Banana();
    f.put(localObject1, localObject2);
  }
  
  public void a(case paramcase)
  {
    paramcase.a(this.h, 0);
    Object localObject = this.i;
    if (localObject != null) {
      paramcase.a((Collection)localObject, 1);
    }
    localObject = this.j;
    if (localObject != null) {
      paramcase.a((Map)localObject, 2);
    }
    localObject = this.k;
    if (localObject != null) {
      paramcase.a((Map)localObject, 3);
    }
    paramcase.a(this.l, 4);
    localObject = this.m;
    if (localObject != null) {
      paramcase.a((Map)localObject, 5);
    }
    paramcase.a(this.n, 6);
    localObject = this.o;
    if (localObject != null) {
      paramcase.a((else)localObject, 7);
    }
    localObject = this.p;
    if (localObject != null) {
      paramcase.a((Map)localObject, 8);
    }
    localObject = this.q;
    if (localObject != null) {
      paramcase.a((else)localObject, 9);
    }
  }
  
  public void a(try paramtry)
  {
    this.h = paramtry.a(this.h, 0, true);
    this.i = ((List)paramtry.a(a, 1, false));
    this.j = ((Map)paramtry.a(b, 2, false));
    this.k = ((Map)paramtry.a(c, 3, false));
    this.l = paramtry.a(this.l, 4, false);
    this.m = ((Map)paramtry.a(d, 5, false));
    this.n = paramtry.a(this.n, 6, false);
    this.o = ((Avocado)paramtry.a(e, 7, false));
    this.p = ((Map)paramtry.a(f, 8, false));
    this.q = ((Blackberry)paramtry.a(g, 9, false));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Apple)) {
      return false;
    }
    paramObject = (Apple)paramObject;
    return (goto.a(this.h, paramObject.h)) && (this.i.equals(paramObject.i)) && (this.j.equals(paramObject.j)) && (this.k.equals(paramObject.k)) && (goto.a(this.l, paramObject.l)) && (this.m.equals(paramObject.m)) && (goto.a(this.n, paramObject.n)) && (this.o.equals(paramObject.o)) && (this.p.equals(paramObject.p)) && (this.q.equals(paramObject.q));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Apple
 * JD-Core Version:    0.7.0.1
 */