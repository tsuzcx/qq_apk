package com.tencent.turingfd.sdk.xq;

import android.content.pm.FeatureInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Apricot
  extends case
{
  public static byte[] ib = new byte[1];
  public static byte[] mc;
  public static List<Integer> nc;
  public static List<byte[]> oc;
  public static List<List<byte[]>> pc;
  public static byte[] qc;
  public static Map<Long, FeatureInfo> rc;
  public boolean Ac = false;
  public int Bc = 0;
  public int Cc = 0;
  public List<byte[]> Dc = null;
  public int Ec = -1;
  public List<List<byte[]>> Fc = null;
  public byte[] Gc = null;
  public Map<Long, FeatureInfo> Hc = null;
  public String Ic = "";
  public int jb = 0;
  public String kb = "";
  public long lb = 0L;
  public byte[] mb = null;
  public byte[] sc = null;
  public String tc = "";
  public int uc = 0;
  public int vb = 0;
  public String vc = "";
  public int wb = 0;
  public int wc = 0;
  public int xb = 0;
  public String xc = "";
  public List<Integer> yc = null;
  public int zc = 0;
  
  static
  {
    ib[0] = 0;
    mc = new byte[1];
    mc[0] = 0;
    nc = new ArrayList();
    nc.add(Integer.valueOf(0));
    oc = new ArrayList();
    oc.add(new byte[] { 0 });
    pc = new ArrayList();
    Object localObject = new ArrayList();
    ((List)localObject).add(new byte[] { 0 });
    pc.add(localObject);
    qc = new byte[1];
    qc[0] = 0;
    rc = new HashMap();
    localObject = new FeatureInfo();
    rc.put(Long.valueOf(0L), localObject);
  }
  
  public void a(byte parambyte)
  {
    parambyte.b(this.jb, 0);
    Object localObject = this.mb;
    if (localObject != null) {
      parambyte.a((byte[])localObject, 1);
    }
    localObject = this.kb;
    if (localObject != null) {
      parambyte.b((String)localObject, 2);
    }
    localObject = this.sc;
    if (localObject != null) {
      parambyte.a((byte[])localObject, 3);
    }
    parambyte.a(this.lb, 4);
    localObject = this.tc;
    if (localObject != null) {
      parambyte.b((String)localObject, 5);
    }
    parambyte.b(this.uc, 6);
    localObject = this.vc;
    if (localObject != null) {
      parambyte.b((String)localObject, 7);
    }
    parambyte.b(this.wc, 8);
    localObject = this.xc;
    if (localObject != null) {
      parambyte.b((String)localObject, 9);
    }
    parambyte.b(this.vb, 10);
    parambyte.b(this.wb, 11);
    parambyte.b(this.xb, 12);
    localObject = this.yc;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 13);
    }
    parambyte.b(this.zc, 14);
    parambyte.a(this.Ac, 15);
    parambyte.b(this.Bc, 16);
    parambyte.b(this.Cc, 17);
    localObject = this.Dc;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 18);
    }
    parambyte.b(this.Ec, 20);
    localObject = this.Fc;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 21);
    }
    localObject = this.Gc;
    if (localObject != null) {
      parambyte.a((byte[])localObject, 22);
    }
    localObject = this.Hc;
    if (localObject != null) {
      parambyte.a((Map)localObject, 23);
    }
    localObject = this.Ic;
    if (localObject != null) {
      parambyte.b((String)localObject, 24);
    }
  }
  
  public void a(try paramtry)
  {
    this.jb = paramtry.a(this.jb, 0, true);
    this.mb = paramtry.a(ib, 1, false);
    this.kb = paramtry.a(2, false);
    this.sc = paramtry.a(mc, 3, false);
    this.lb = paramtry.a(this.lb, 4, false);
    this.tc = paramtry.a(5, false);
    this.uc = paramtry.a(this.uc, 6, false);
    this.vc = paramtry.a(7, false);
    this.wc = paramtry.a(this.wc, 8, false);
    this.xc = paramtry.a(9, false);
    this.vb = paramtry.a(this.vb, 10, false);
    this.wb = paramtry.a(this.wb, 11, false);
    this.xb = paramtry.a(this.xb, 12, false);
    this.yc = ((List)paramtry.a(nc, 13, false));
    this.zc = paramtry.a(this.zc, 14, false);
    this.Ac = paramtry.a(this.Ac, 15, false);
    this.Bc = paramtry.a(this.Bc, 16, false);
    this.Cc = paramtry.a(this.Cc, 17, false);
    this.Dc = ((List)paramtry.a(oc, 18, false));
    this.Ec = paramtry.a(this.Ec, 20, false);
    this.Fc = ((List)paramtry.a(pc, 21, false));
    this.Gc = paramtry.a(qc, 22, false);
    this.Hc = ((Map)paramtry.a(rc, 23, false));
    this.Ic = paramtry.a(24, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Apricot)) {
      return false;
    }
    paramObject = (Apricot)paramObject;
    return (char.equals(this.jb, paramObject.jb)) && (char.equals(this.mb, paramObject.mb)) && (char.equals(this.kb, paramObject.kb)) && (char.equals(this.sc, paramObject.sc)) && (char.a(this.lb, paramObject.lb)) && (char.equals(this.tc, paramObject.tc)) && (char.equals(this.uc, paramObject.uc)) && (char.equals(this.vc, paramObject.vc)) && (char.equals(this.wc, paramObject.wc)) && (char.equals(this.xc, paramObject.xc)) && (char.equals(this.vb, paramObject.vb)) && (char.equals(this.wb, paramObject.wb)) && (char.equals(this.xb, paramObject.xb)) && (char.equals(this.yc, paramObject.yc)) && (char.equals(this.zc, paramObject.zc)) && (char.a(this.Ac, paramObject.Ac)) && (char.equals(this.Bc, paramObject.Bc)) && (char.equals(this.Cc, paramObject.Cc)) && (char.equals(this.Dc, paramObject.Dc)) && (char.equals(this.Ec, paramObject.Ec)) && (char.equals(this.Fc, paramObject.Fc)) && (char.equals(this.Gc, paramObject.Gc)) && (char.equals(this.Hc, paramObject.Hc)) && (char.equals(this.Ic, paramObject.Ic));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Apricot
 * JD-Core Version:    0.7.0.1
 */