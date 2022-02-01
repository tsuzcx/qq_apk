package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Cepheus
  extends case
{
  public static List<ComaBerenices> Aa;
  public static List<Dorado> Ba;
  public static List<Cygnus> Ca;
  public static Crux za = new Crux();
  public Crux Da = null;
  public List<ComaBerenices> Ea = null;
  public List<Dorado> Fa = null;
  public List<Cygnus> Ga = null;
  
  static
  {
    Aa = new ArrayList();
    Object localObject = new ComaBerenices();
    Aa.add(localObject);
    Ba = new ArrayList();
    localObject = new Dorado();
    Ba.add(localObject);
    Ca = new ArrayList();
    localObject = new Cygnus();
    Ca.add(localObject);
  }
  
  public void a(byte parambyte)
  {
    Object localObject = this.Da;
    if (localObject != null) {
      parambyte.a((case)localObject, 0);
    }
    localObject = this.Ea;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 1);
    }
    localObject = this.Fa;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 2);
    }
    localObject = this.Ga;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 3);
    }
  }
  
  public void a(try paramtry)
  {
    this.Da = ((Crux)paramtry.a(za, 0, false));
    this.Ea = ((List)paramtry.a(Aa, 1, false));
    this.Fa = ((List)paramtry.a(Ba, 2, false));
    this.Ga = ((List)paramtry.a(Ca, 3, false));
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
      if (!(paramObject instanceof Cepheus)) {
        return false;
      }
      paramObject = (Cepheus)paramObject;
    } while ((char.equals(this.Da, paramObject.Da)) && (char.equals(this.Ea, paramObject.Ea)) && (char.equals(this.Fa, paramObject.Fa)) && (char.equals(this.Ga, paramObject.Ga)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Cepheus
 * JD-Core Version:    0.7.0.1
 */