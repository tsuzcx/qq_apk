package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Solar
  extends else
{
  public static byte[] a;
  public static byte[] b;
  public static List<String> c;
  public static List<String> d;
  public int e = 0;
  public String f = "";
  public long g = 0L;
  public int h = 0;
  public byte[] i = null;
  public byte[] j = null;
  public int k = 0;
  public String l = "";
  public List<String> m = null;
  public List<String> n = null;
  
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
    ((List)localObject).add("");
    localObject = new ArrayList();
    d = (List)localObject;
    ((List)localObject).add("");
  }
  
  public void a(case paramcase)
  {
    paramcase.a(this.e, 0);
    Object localObject = this.f;
    if (localObject != null) {
      paramcase.a((String)localObject, 1);
    }
    paramcase.a(this.g, 2);
    paramcase.a(this.h, 3);
    localObject = this.i;
    if (localObject != null) {
      paramcase.a((byte[])localObject, 4);
    }
    localObject = this.j;
    if (localObject != null) {
      paramcase.a((byte[])localObject, 5);
    }
    paramcase.a(this.k, 6);
    localObject = this.l;
    if (localObject != null) {
      paramcase.a((String)localObject, 7);
    }
    localObject = this.m;
    if (localObject != null) {
      paramcase.a((Collection)localObject, 8);
    }
    localObject = this.n;
    if (localObject != null) {
      paramcase.a((Collection)localObject, 9);
    }
  }
  
  public void a(try paramtry)
  {
    this.e = paramtry.a(this.e, 0, true);
    this.f = paramtry.b(1, false);
    this.g = paramtry.a(this.g, 2, false);
    this.h = paramtry.a(this.h, 3, false);
    this.i = paramtry.a(4, false);
    this.j = paramtry.a(5, false);
    this.k = paramtry.a(this.k, 6, false);
    this.l = paramtry.b(7, false);
    this.m = ((List)paramtry.a(c, 8, false));
    this.n = ((List)paramtry.a(d, 9, false));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Solar)) {
      return false;
    }
    paramObject = (Solar)paramObject;
    return (goto.a(this.e, paramObject.e)) && (this.f.equals(paramObject.f)) && (goto.a(this.g, paramObject.g)) && (goto.a(this.h, paramObject.h)) && (this.i.equals(paramObject.i)) && (this.j.equals(paramObject.j)) && (goto.a(this.k, paramObject.k)) && (this.l.equals(paramObject.l)) && (this.m.equals(paramObject.m)) && (this.n.equals(paramObject.n));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Solar
 * JD-Core Version:    0.7.0.1
 */