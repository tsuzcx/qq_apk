package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Sagittarius
  extends case
{
  public static List<String> Qa = new ArrayList();
  public static List<String> Ra;
  public String Za = "";
  public List<String> _a = null;
  public List<String> ab = null;
  public int jb = 0;
  public String nb = "";
  public int type = 0;
  
  static
  {
    Qa.add("");
    Ra = new ArrayList();
    Ra.add("");
  }
  
  public void a(byte parambyte)
  {
    parambyte.b(this.jb, 0);
    Object localObject = this.nb;
    if (localObject != null) {
      parambyte.b((String)localObject, 1);
    }
    parambyte.b(this.type, 2);
    localObject = this.Za;
    if (localObject != null) {
      parambyte.b((String)localObject, 3);
    }
    localObject = this._a;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 4);
    }
    localObject = this.ab;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 5);
    }
  }
  
  public void a(try paramtry)
  {
    this.jb = paramtry.a(this.jb, 0, true);
    this.nb = paramtry.a(1, false);
    this.type = paramtry.a(this.type, 2, false);
    this.Za = paramtry.a(3, false);
    this._a = ((List)paramtry.a(Qa, 4, false));
    this.ab = ((List)paramtry.a(Ra, 5, false));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Sagittarius)) {
      return false;
    }
    paramObject = (Sagittarius)paramObject;
    return (char.equals(this.jb, paramObject.jb)) && (char.equals(this.nb, paramObject.nb)) && (char.equals(this.type, paramObject.type)) && (char.equals(this.Za, paramObject.Za)) && (char.equals(this._a, paramObject._a)) && (char.equals(this.ab, paramObject.ab));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Sagittarius
 * JD-Core Version:    0.7.0.1
 */