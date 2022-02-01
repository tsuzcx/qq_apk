package com.tencent.turingfd.sdk.xq;

import android.content.pm.FeatureInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Octans
  extends case
{
  public static byte[] db = new byte[1];
  public static byte[] hc;
  public static List<Integer> ic;
  public static List<byte[]> jc;
  public static List<List<byte[]>> kc;
  public static byte[] lc;
  public static Map<Long, FeatureInfo> mc;
  public List<List<byte[]>> Ac = null;
  public byte[] Bc = null;
  public Map<Long, FeatureInfo> Cc = null;
  public String Dc = "";
  public int eb = 0;
  public String fb = "";
  public long gb = 0L;
  public byte[] hb = null;
  public byte[] nc = null;
  public String oc = "";
  public int pc = 0;
  public int qb = 0;
  public String qc = "";
  public int rb = 0;
  public int rc = 0;
  public int sb = 0;
  public String sc = "";
  public List<Integer> tc = null;
  public int uc = 0;
  public boolean vc = false;
  public int wc = 0;
  public int xc = 0;
  public List<byte[]> yc = null;
  public int zc = -1;
  
  static
  {
    db[0] = 0;
    hc = new byte[1];
    hc[0] = 0;
    ic = new ArrayList();
    ic.add(Integer.valueOf(0));
    jc = new ArrayList();
    jc.add(new byte[] { 0 });
    kc = new ArrayList();
    Object localObject = new ArrayList();
    ((List)localObject).add(new byte[] { 0 });
    kc.add(localObject);
    lc = new byte[1];
    lc[0] = 0;
    mc = new HashMap();
    localObject = new FeatureInfo();
    mc.put(Long.valueOf(0L), localObject);
  }
  
  public void a(byte parambyte)
  {
    parambyte.a(this.eb, 0);
    Object localObject = this.hb;
    if (localObject != null) {
      parambyte.a((byte[])localObject, 1);
    }
    localObject = this.fb;
    if (localObject != null) {
      parambyte.b((String)localObject, 2);
    }
    localObject = this.nc;
    if (localObject != null) {
      parambyte.a((byte[])localObject, 3);
    }
    parambyte.a(this.gb, 4);
    localObject = this.oc;
    if (localObject != null) {
      parambyte.b((String)localObject, 5);
    }
    parambyte.a(this.pc, 6);
    localObject = this.qc;
    if (localObject != null) {
      parambyte.b((String)localObject, 7);
    }
    parambyte.a(this.rc, 8);
    localObject = this.sc;
    if (localObject != null) {
      parambyte.b((String)localObject, 9);
    }
    parambyte.a(this.qb, 10);
    parambyte.a(this.rb, 11);
    parambyte.a(this.sb, 12);
    localObject = this.tc;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 13);
    }
    parambyte.a(this.uc, 14);
    parambyte.a(this.vc, 15);
    parambyte.a(this.wc, 16);
    parambyte.a(this.xc, 17);
    localObject = this.yc;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 18);
    }
    parambyte.a(this.zc, 20);
    localObject = this.Ac;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 21);
    }
    localObject = this.Bc;
    if (localObject != null) {
      parambyte.a((byte[])localObject, 22);
    }
    localObject = this.Cc;
    if (localObject != null) {
      parambyte.a((Map)localObject, 23);
    }
    localObject = this.Dc;
    if (localObject != null) {
      parambyte.b((String)localObject, 24);
    }
  }
  
  public void a(try paramtry)
  {
    this.eb = paramtry.a(this.eb, 0, true);
    this.hb = paramtry.a(db, 1, false);
    this.fb = paramtry.a(2, false);
    this.nc = paramtry.a(hc, 3, false);
    this.gb = paramtry.a(this.gb, 4, false);
    this.oc = paramtry.a(5, false);
    this.pc = paramtry.a(this.pc, 6, false);
    this.qc = paramtry.a(7, false);
    this.rc = paramtry.a(this.rc, 8, false);
    this.sc = paramtry.a(9, false);
    this.qb = paramtry.a(this.qb, 10, false);
    this.rb = paramtry.a(this.rb, 11, false);
    this.sb = paramtry.a(this.sb, 12, false);
    this.tc = ((List)paramtry.a(ic, 13, false));
    this.uc = paramtry.a(this.uc, 14, false);
    this.vc = paramtry.a(this.vc, 15, false);
    this.wc = paramtry.a(this.wc, 16, false);
    this.xc = paramtry.a(this.xc, 17, false);
    this.yc = ((List)paramtry.a(jc, 18, false));
    this.zc = paramtry.a(this.zc, 20, false);
    this.Ac = ((List)paramtry.a(kc, 21, false));
    this.Bc = paramtry.a(lc, 22, false);
    this.Cc = ((Map)paramtry.a(mc, 23, false));
    this.Dc = paramtry.a(24, false);
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
      if (!(paramObject instanceof Octans)) {
        return false;
      }
      paramObject = (Octans)paramObject;
    } while ((char.equals(this.eb, paramObject.eb)) && (char.equals(this.hb, paramObject.hb)) && (char.equals(this.fb, paramObject.fb)) && (char.equals(this.nc, paramObject.nc)) && (char.a(this.gb, paramObject.gb)) && (char.equals(this.oc, paramObject.oc)) && (char.equals(this.pc, paramObject.pc)) && (char.equals(this.qc, paramObject.qc)) && (char.equals(this.rc, paramObject.rc)) && (char.equals(this.sc, paramObject.sc)) && (char.equals(this.qb, paramObject.qb)) && (char.equals(this.rb, paramObject.rb)) && (char.equals(this.sb, paramObject.sb)) && (char.equals(this.tc, paramObject.tc)) && (char.equals(this.uc, paramObject.uc)) && (char.a(this.vc, paramObject.vc)) && (char.equals(this.wc, paramObject.wc)) && (char.equals(this.xc, paramObject.xc)) && (char.equals(this.yc, paramObject.yc)) && (char.equals(this.zc, paramObject.zc)) && (char.equals(this.Ac, paramObject.Ac)) && (char.equals(this.Bc, paramObject.Bc)) && (char.equals(this.Cc, paramObject.Cc)) && (char.equals(this.Dc, paramObject.Dc)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Octans
 * JD-Core Version:    0.7.0.1
 */