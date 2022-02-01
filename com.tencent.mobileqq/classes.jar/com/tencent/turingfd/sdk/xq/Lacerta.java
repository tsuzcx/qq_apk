package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lacerta
  extends case
{
  public static List<Draco> Aa = new ArrayList();
  public static Map<Integer, Sagittarius> Eb;
  public static Map<Integer, LeoMinor> Fb;
  public static Map<Integer, Lyra> Gb;
  public static Lynx Hb;
  public static Map<Integer, Norma> Ib;
  public static Pyxis Jb = new Pyxis();
  public List<Draco> Ea = null;
  public Map<Integer, Sagittarius> Kb = null;
  public Map<Integer, LeoMinor> Lb = null;
  public int Mb = 0;
  public Map<Integer, Lyra> Nb = null;
  public int Ob = 0;
  public Lynx Pb = null;
  public Map<Integer, Norma> Qb = null;
  public int R = 0;
  public Pyxis Rb = null;
  
  static
  {
    Object localObject = new Draco();
    Aa.add(localObject);
    Eb = new HashMap();
    localObject = new Sagittarius();
    Eb.put(Integer.valueOf(0), localObject);
    Fb = new HashMap();
    localObject = new LeoMinor();
    Fb.put(Integer.valueOf(0), localObject);
    Gb = new HashMap();
    localObject = new Lyra();
    Gb.put(Integer.valueOf(0), localObject);
    Hb = new Lynx();
    Ib = new HashMap();
    localObject = new Norma();
    Ib.put(Integer.valueOf(0), localObject);
  }
  
  public void a(byte parambyte)
  {
    parambyte.a(this.R, 0);
    Object localObject = this.Ea;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 1);
    }
    localObject = this.Kb;
    if (localObject != null) {
      parambyte.a((Map)localObject, 2);
    }
    localObject = this.Lb;
    if (localObject != null) {
      parambyte.a((Map)localObject, 3);
    }
    parambyte.a(this.Mb, 4);
    localObject = this.Nb;
    if (localObject != null) {
      parambyte.a((Map)localObject, 5);
    }
    parambyte.a(this.Ob, 6);
    localObject = this.Pb;
    if (localObject != null) {
      parambyte.a((case)localObject, 7);
    }
    localObject = this.Qb;
    if (localObject != null) {
      parambyte.a((Map)localObject, 8);
    }
    localObject = this.Rb;
    if (localObject != null) {
      parambyte.a((case)localObject, 9);
    }
  }
  
  public void a(try paramtry)
  {
    this.R = paramtry.a(this.R, 0, true);
    this.Ea = ((List)paramtry.a(Aa, 1, false));
    this.Kb = ((Map)paramtry.a(Eb, 2, false));
    this.Lb = ((Map)paramtry.a(Fb, 3, false));
    this.Mb = paramtry.a(this.Mb, 4, false);
    this.Nb = ((Map)paramtry.a(Gb, 5, false));
    this.Ob = paramtry.a(this.Ob, 6, false);
    this.Pb = ((Lynx)paramtry.a(Hb, 7, false));
    this.Qb = ((Map)paramtry.a(Ib, 8, false));
    this.Rb = ((Pyxis)paramtry.a(Jb, 9, false));
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
      if (!(paramObject instanceof Lacerta)) {
        return false;
      }
      paramObject = (Lacerta)paramObject;
    } while ((char.equals(this.R, paramObject.R)) && (char.equals(this.Ea, paramObject.Ea)) && (char.equals(this.Kb, paramObject.Kb)) && (char.equals(this.Lb, paramObject.Lb)) && (char.equals(this.Mb, paramObject.Mb)) && (char.equals(this.Nb, paramObject.Nb)) && (char.equals(this.Ob, paramObject.Ob)) && (char.equals(this.Pb, paramObject.Pb)) && (char.equals(this.Qb, paramObject.Qb)) && (char.equals(this.Rb, paramObject.Rb)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Lacerta
 * JD-Core Version:    0.7.0.1
 */