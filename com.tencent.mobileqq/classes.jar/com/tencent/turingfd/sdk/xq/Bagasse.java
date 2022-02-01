package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Bagasse
  extends case
{
  public static Apricot gd;
  public static List<Integer> hd;
  public static List<Integer> nc = new ArrayList();
  public int Ab = 0;
  public boolean Ac = false;
  public int Bc = 0;
  public int Cc = 0;
  public int Ec = 0;
  public String jd = "";
  public String kd = "";
  public Apricot ld = null;
  public List<Integer> md = null;
  public int nd = 0;
  public String rb = "";
  public int ub = 0;
  public int vb = 0;
  public int wb = 0;
  public int xb = 0;
  public String yb = "";
  public List<Integer> yc = null;
  public String zb = "";
  public int zc = 0;
  
  static
  {
    List localList = nc;
    Integer localInteger = Integer.valueOf(0);
    localList.add(localInteger);
    gd = new Apricot();
    hd = new ArrayList();
    hd.add(localInteger);
  }
  
  public void a(byte parambyte)
  {
    parambyte.b(this.ub, 0);
    parambyte.b(this.vb, 1);
    parambyte.b(this.wb, 2);
    parambyte.b(this.xb, 3);
    Object localObject = this.yc;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 4);
    }
    parambyte.b(this.zc, 5);
    parambyte.a(this.Ac, 6);
    parambyte.b(this.Bc, 7);
    parambyte.b(this.Cc, 8);
    localObject = this.yb;
    if (localObject != null) {
      parambyte.b((String)localObject, 9);
    }
    localObject = this.zb;
    if (localObject != null) {
      parambyte.b((String)localObject, 10);
    }
    parambyte.b(this.Ab, 11);
    localObject = this.rb;
    if (localObject != null) {
      parambyte.b((String)localObject, 12);
    }
    localObject = this.jd;
    if (localObject != null) {
      parambyte.b((String)localObject, 13);
    }
    localObject = this.kd;
    if (localObject != null) {
      parambyte.b((String)localObject, 14);
    }
    parambyte.b(this.Ec, 15);
    localObject = this.ld;
    if (localObject != null) {
      parambyte.a((case)localObject, 16);
    }
    localObject = this.md;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 17);
    }
    parambyte.b(this.nd, 18);
  }
  
  public void a(try paramtry)
  {
    this.ub = paramtry.a(this.ub, 0, true);
    this.vb = paramtry.a(this.vb, 1, false);
    this.wb = paramtry.a(this.wb, 2, false);
    this.xb = paramtry.a(this.xb, 3, false);
    this.yc = ((List)paramtry.a(nc, 4, false));
    this.zc = paramtry.a(this.zc, 5, false);
    this.Ac = paramtry.a(this.Ac, 6, false);
    this.Bc = paramtry.a(this.Bc, 7, false);
    this.Cc = paramtry.a(this.Cc, 8, false);
    this.yb = paramtry.a(9, false);
    this.zb = paramtry.a(10, false);
    this.Ab = paramtry.a(this.Ab, 11, false);
    this.rb = paramtry.a(12, false);
    this.jd = paramtry.a(13, false);
    this.kd = paramtry.a(14, false);
    this.Ec = paramtry.a(this.Ec, 15, false);
    this.ld = ((Apricot)paramtry.a(gd, 16, false));
    this.md = ((List)paramtry.a(hd, 17, false));
    this.nd = paramtry.a(this.nd, 18, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Bagasse)) {
      return false;
    }
    paramObject = (Bagasse)paramObject;
    return (char.equals(this.ub, paramObject.ub)) && (char.equals(this.vb, paramObject.vb)) && (char.equals(this.wb, paramObject.wb)) && (char.equals(this.xb, paramObject.xb)) && (char.equals(this.yc, paramObject.yc)) && (char.equals(this.zc, paramObject.zc)) && (char.a(this.Ac, paramObject.Ac)) && (char.equals(this.Bc, paramObject.Bc)) && (char.equals(this.Cc, paramObject.Cc)) && (char.equals(this.yb, paramObject.yb)) && (char.equals(this.zb, paramObject.zb)) && (char.equals(this.Ab, paramObject.Ab)) && (char.equals(this.rb, paramObject.rb)) && (char.equals(this.jd, paramObject.jd)) && (char.equals(this.kd, paramObject.kd)) && (char.equals(this.Ec, paramObject.Ec)) && (char.equals(this.ld, paramObject.ld)) && (char.equals(this.md, paramObject.md)) && (char.equals(this.nd, paramObject.nd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Bagasse
 * JD-Core Version:    0.7.0.1
 */