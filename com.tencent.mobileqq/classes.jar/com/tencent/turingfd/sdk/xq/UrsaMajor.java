package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UrsaMajor
  extends case
{
  public static List<Scorpius> Fa = new ArrayList();
  public static Map<Integer, Bergamot> Jb;
  public static Map<Integer, UrsaMinor> Kb;
  public static Map<Integer, Almond> Lb;
  public static Vulpecula Mb;
  public static Map<Integer, Apple> Nb;
  public static Bennet Ob = new Bennet();
  public List<Scorpius> Ja = null;
  public Map<Integer, Bergamot> Pb = null;
  public Map<Integer, UrsaMinor> Qb = null;
  public int Rb = 0;
  public Map<Integer, Almond> Sb = null;
  public int Tb = 0;
  public Vulpecula Ub = null;
  public Map<Integer, Apple> Vb = null;
  public Bennet Wb = null;
  public int ba = 0;
  
  static
  {
    Object localObject1 = new Scorpius();
    Fa.add(localObject1);
    Jb = new HashMap();
    Object localObject2 = new Bergamot();
    Map localMap = Jb;
    localObject1 = Integer.valueOf(0);
    localMap.put(localObject1, localObject2);
    Kb = new HashMap();
    localObject2 = new UrsaMinor();
    Kb.put(localObject1, localObject2);
    Lb = new HashMap();
    localObject2 = new Almond();
    Lb.put(localObject1, localObject2);
    Mb = new Vulpecula();
    Nb = new HashMap();
    localObject2 = new Apple();
    Nb.put(localObject1, localObject2);
  }
  
  public void a(byte parambyte)
  {
    parambyte.b(this.ba, 0);
    Object localObject = this.Ja;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 1);
    }
    localObject = this.Pb;
    if (localObject != null) {
      parambyte.a((Map)localObject, 2);
    }
    localObject = this.Qb;
    if (localObject != null) {
      parambyte.a((Map)localObject, 3);
    }
    parambyte.b(this.Rb, 4);
    localObject = this.Sb;
    if (localObject != null) {
      parambyte.a((Map)localObject, 5);
    }
    parambyte.b(this.Tb, 6);
    localObject = this.Ub;
    if (localObject != null) {
      parambyte.a((case)localObject, 7);
    }
    localObject = this.Vb;
    if (localObject != null) {
      parambyte.a((Map)localObject, 8);
    }
    localObject = this.Wb;
    if (localObject != null) {
      parambyte.a((case)localObject, 9);
    }
  }
  
  public void a(try paramtry)
  {
    this.ba = paramtry.a(this.ba, 0, true);
    this.Ja = ((List)paramtry.a(Fa, 1, false));
    this.Pb = ((Map)paramtry.a(Jb, 2, false));
    this.Qb = ((Map)paramtry.a(Kb, 3, false));
    this.Rb = paramtry.a(this.Rb, 4, false);
    this.Sb = ((Map)paramtry.a(Lb, 5, false));
    this.Tb = paramtry.a(this.Tb, 6, false);
    this.Ub = ((Vulpecula)paramtry.a(Mb, 7, false));
    this.Vb = ((Map)paramtry.a(Nb, 8, false));
    this.Wb = ((Bennet)paramtry.a(Ob, 9, false));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof UrsaMajor)) {
      return false;
    }
    paramObject = (UrsaMajor)paramObject;
    return (char.equals(this.ba, paramObject.ba)) && (char.equals(this.Ja, paramObject.Ja)) && (char.equals(this.Pb, paramObject.Pb)) && (char.equals(this.Qb, paramObject.Qb)) && (char.equals(this.Rb, paramObject.Rb)) && (char.equals(this.Sb, paramObject.Sb)) && (char.equals(this.Tb, paramObject.Tb)) && (char.equals(this.Ub, paramObject.Ub)) && (char.equals(this.Vb, paramObject.Vb)) && (char.equals(this.Wb, paramObject.Wb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.UrsaMajor
 * JD-Core Version:    0.7.0.1
 */