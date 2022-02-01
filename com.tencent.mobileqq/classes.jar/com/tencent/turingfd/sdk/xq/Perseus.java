package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Perseus
  extends case
{
  public static Octans ad;
  public static List<Integer> bd;
  public static List<Integer> ic = new ArrayList();
  public String cd = "";
  public String dd = "";
  public Octans ed = null;
  public List<Integer> gd = null;
  public int hd = 0;
  public String mb = "";
  public int pb = 0;
  public int qb = 0;
  public int rb = 0;
  public int sb = 0;
  public String tb = "";
  public List<Integer> tc = null;
  public String ub = "";
  public int uc = 0;
  public int vb = 0;
  public boolean vc = false;
  public int wc = 0;
  public int xc = 0;
  public int zc = 0;
  
  static
  {
    ic.add(Integer.valueOf(0));
    ad = new Octans();
    bd = new ArrayList();
    bd.add(Integer.valueOf(0));
  }
  
  public void a(byte parambyte)
  {
    parambyte.a(this.pb, 0);
    parambyte.a(this.qb, 1);
    parambyte.a(this.rb, 2);
    parambyte.a(this.sb, 3);
    Object localObject = this.tc;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 4);
    }
    parambyte.a(this.uc, 5);
    parambyte.a(this.vc, 6);
    parambyte.a(this.wc, 7);
    parambyte.a(this.xc, 8);
    localObject = this.tb;
    if (localObject != null) {
      parambyte.b((String)localObject, 9);
    }
    localObject = this.ub;
    if (localObject != null) {
      parambyte.b((String)localObject, 10);
    }
    parambyte.a(this.vb, 11);
    localObject = this.mb;
    if (localObject != null) {
      parambyte.b((String)localObject, 12);
    }
    localObject = this.cd;
    if (localObject != null) {
      parambyte.b((String)localObject, 13);
    }
    localObject = this.dd;
    if (localObject != null) {
      parambyte.b((String)localObject, 14);
    }
    parambyte.a(this.zc, 15);
    localObject = this.ed;
    if (localObject != null) {
      parambyte.a((case)localObject, 16);
    }
    localObject = this.gd;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 17);
    }
    parambyte.a(this.hd, 18);
  }
  
  public void a(try paramtry)
  {
    this.pb = paramtry.a(this.pb, 0, true);
    this.qb = paramtry.a(this.qb, 1, false);
    this.rb = paramtry.a(this.rb, 2, false);
    this.sb = paramtry.a(this.sb, 3, false);
    this.tc = ((List)paramtry.a(ic, 4, false));
    this.uc = paramtry.a(this.uc, 5, false);
    this.vc = paramtry.a(this.vc, 6, false);
    this.wc = paramtry.a(this.wc, 7, false);
    this.xc = paramtry.a(this.xc, 8, false);
    this.tb = paramtry.a(9, false);
    this.ub = paramtry.a(10, false);
    this.vb = paramtry.a(this.vb, 11, false);
    this.mb = paramtry.a(12, false);
    this.cd = paramtry.a(13, false);
    this.dd = paramtry.a(14, false);
    this.zc = paramtry.a(this.zc, 15, false);
    this.ed = ((Octans)paramtry.a(ad, 16, false));
    this.gd = ((List)paramtry.a(bd, 17, false));
    this.hd = paramtry.a(this.hd, 18, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof Perseus)) {
        return false;
      }
      paramObject = (Perseus)paramObject;
    } while ((char.equals(this.pb, paramObject.pb)) && (char.equals(this.qb, paramObject.qb)) && (char.equals(this.rb, paramObject.rb)) && (char.equals(this.sb, paramObject.sb)) && (char.equals(this.tc, paramObject.tc)) && (char.equals(this.uc, paramObject.uc)) && (char.a(this.vc, paramObject.vc)) && (char.equals(this.wc, paramObject.wc)) && (char.equals(this.xc, paramObject.xc)) && (char.equals(this.tb, paramObject.tb)) && (char.equals(this.ub, paramObject.ub)) && (char.equals(this.vb, paramObject.vb)) && (char.equals(this.mb, paramObject.mb)) && (char.equals(this.cd, paramObject.cd)) && (char.equals(this.dd, paramObject.dd)) && (char.equals(this.zc, paramObject.zc)) && (char.equals(this.ed, paramObject.ed)) && (char.equals(this.gd, paramObject.gd)) && (char.equals(this.hd, paramObject.hd)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Perseus
 * JD-Core Version:    0.7.0.1
 */