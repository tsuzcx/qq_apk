package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Sculptor
  extends else
{
  public static Bennet a = new Bennet();
  public static String b = new String();
  public static byte[] c;
  public static List<String> d;
  public static List<String> e;
  public static List<String> f;
  public Bennet g = null;
  public String h = null;
  public String i = "";
  public String j = "";
  public int k = 0;
  public byte[] l = null;
  public List<String> m = null;
  public String n = "";
  public List<String> o = null;
  public List<String> p = null;
  
  static
  {
    Object localObject = new byte[1];
    c = (byte[])localObject;
    localObject[0] = 0;
    d = new ArrayList();
    localObject = new String();
    d.add(localObject);
    localObject = new ArrayList();
    e = (List)localObject;
    ((List)localObject).add("");
    localObject = new ArrayList();
    f = (List)localObject;
    ((List)localObject).add("");
  }
  
  public void a(case paramcase)
  {
    paramcase.a(this.g, 0);
    Object localObject = this.h;
    if (localObject != null) {
      paramcase.a((String)localObject, 1);
    }
    localObject = this.i;
    if (localObject != null) {
      paramcase.a((String)localObject, 2);
    }
    localObject = this.j;
    if (localObject != null) {
      paramcase.a((String)localObject, 3);
    }
    paramcase.a(this.k, 4);
    localObject = this.l;
    if (localObject != null) {
      paramcase.a((byte[])localObject, 5);
    }
    localObject = this.m;
    if (localObject != null) {
      paramcase.a((Collection)localObject, 6);
    }
    localObject = this.n;
    if (localObject != null) {
      paramcase.a((String)localObject, 7);
    }
    localObject = this.o;
    if (localObject != null) {
      paramcase.a((Collection)localObject, 8);
    }
    localObject = this.p;
    if (localObject != null) {
      paramcase.a((Collection)localObject, 9);
    }
  }
  
  public void a(try paramtry)
  {
    this.g = ((Bennet)paramtry.a(a, 0, true));
    this.h = paramtry.a(b, 1, false);
    this.i = paramtry.b(2, false);
    this.j = paramtry.b(3, false);
    this.k = paramtry.a(this.k, 4, false);
    this.l = paramtry.a(5, false);
    this.m = ((List)paramtry.a(d, 6, false));
    this.n = paramtry.b(7, false);
    this.o = ((List)paramtry.a(e, 8, false));
    this.p = ((List)paramtry.a(f, 9, false));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Sculptor)) {
      return false;
    }
    paramObject = (Sculptor)paramObject;
    Bennet localBennet1 = this.g;
    Bennet localBennet2 = paramObject.g;
    int i1 = goto.a;
    return (localBennet1.equals(localBennet2)) && (this.h.equals(paramObject.h)) && (this.i.equals(paramObject.i)) && (this.j.equals(paramObject.j)) && (goto.a(this.k, paramObject.k)) && (this.l.equals(paramObject.l)) && (this.m.equals(paramObject.m)) && (this.n.equals(paramObject.n)) && (this.o.equals(paramObject.o)) && (this.p.equals(paramObject.p));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Sculptor
 * JD-Core Version:    0.7.0.1
 */