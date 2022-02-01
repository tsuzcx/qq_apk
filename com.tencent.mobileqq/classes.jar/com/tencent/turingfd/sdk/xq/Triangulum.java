package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.List;

public class Triangulum
  extends case
{
  public static List<Serpens> Ga = new ArrayList();
  public List<Serpens> Ka = null;
  public int ba = 0;
  
  static
  {
    Serpens localSerpens = new Serpens();
    Ga.add(localSerpens);
  }
  
  public void a(byte parambyte)
  {
    parambyte.b(this.ba, 0);
    List localList = this.Ka;
    if (localList != null) {
      parambyte.a(localList, 1);
    }
  }
  
  public void a(try paramtry)
  {
    this.ba = paramtry.a(this.ba, 0, true);
    this.Ka = ((List)paramtry.a(Ga, 1, false));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Triangulum)) {
      return false;
    }
    paramObject = (Triangulum)paramObject;
    return (char.equals(this.ba, paramObject.ba)) && (char.equals(this.Ka, paramObject.Ka));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Triangulum
 * JD-Core Version:    0.7.0.1
 */