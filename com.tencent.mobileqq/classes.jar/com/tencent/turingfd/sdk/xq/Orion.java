package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Orion
  extends case
{
  public static Phoenix Ea = new Phoenix();
  public static List<Perseus> Fa = new ArrayList();
  public static List<Sagittarius> Ga;
  public static List<Pyxis> Ha;
  public Phoenix Ia = null;
  public List<Perseus> Ja = null;
  public List<Sagittarius> Ka = null;
  public List<Pyxis> La = null;
  
  static
  {
    Object localObject = new Perseus();
    Fa.add(localObject);
    Ga = new ArrayList();
    localObject = new Sagittarius();
    Ga.add(localObject);
    Ha = new ArrayList();
    localObject = new Pyxis();
    Ha.add(localObject);
  }
  
  public void a(byte parambyte)
  {
    Object localObject = this.Ia;
    if (localObject != null) {
      parambyte.a((case)localObject, 0);
    }
    localObject = this.Ja;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 1);
    }
    localObject = this.Ka;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 2);
    }
    localObject = this.La;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 3);
    }
  }
  
  public void a(try paramtry)
  {
    this.Ia = ((Phoenix)paramtry.a(Ea, 0, false));
    this.Ja = ((List)paramtry.a(Fa, 1, false));
    this.Ka = ((List)paramtry.a(Ga, 2, false));
    this.La = ((List)paramtry.a(Ha, 3, false));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Orion)) {
      return false;
    }
    paramObject = (Orion)paramObject;
    return (char.equals(this.Ia, paramObject.Ia)) && (char.equals(this.Ja, paramObject.Ja)) && (char.equals(this.Ka, paramObject.Ka)) && (char.equals(this.La, paramObject.La));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Orion
 * JD-Core Version:    0.7.0.1
 */